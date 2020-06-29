package fr.xen0xys.newuhchost.scenario.scenarios;

import fr.xen0xys.newuhchost.gamemodes.Host;
import fr.xen0xys.newuhchost.scenario.Scenario;
import org.bukkit.DyeColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.EnchantingInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Dye;

public class CutClean extends Scenario implements Listener {

    private final Material[] cut_clean_materials = {Material.IRON_ORE, Material.GOLD_ORE};
    private final boolean check_correct_tool;
    private final boolean unlimited_lapis;
    private final ItemStack lapis;

    public CutClean(Host host) {
        super(host);
        this.check_correct_tool = true; // need add in settings
        this.unlimited_lapis = true; // need add in settings
        // Creating lapis item
        this.lapis = getLapisItem();
    }

    private ItemStack getLapisItem(){
        Dye d = new Dye();
        d.setColor(DyeColor.BLUE);
        ItemStack lapis = d.toItemStack();
        lapis.setAmount(64);
        return lapis;
    }

    private void applyCutClean(Block block, Player player){
        Location block_location = block.getLocation();
        switch (block.getType()){
            case IRON_ORE:
                if(player.getGameMode() == GameMode.SURVIVAL && isRequirePickaxeLevel(player.getItemInHand().getType(), 1))
                    this.getHost().getWorld().dropItem(block_location, new ItemStack(Material.IRON_INGOT, getItemNumberByFortune(player.getItemInHand())));
                break;
            case GOLD_ORE:
                if(player.getGameMode() == GameMode.SURVIVAL && isRequirePickaxeLevel(player.getItemInHand().getType(), 2))
                    this.getHost().getWorld().dropItem(block_location, new ItemStack(Material.GOLD_INGOT, getItemNumberByFortune(player.getItemInHand())));
                break;
        }
        block.setType(Material.AIR);
    }

    private int getItemNumberByFortune(ItemStack item){
        return Math.min(item.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) + 1, 3);
    }

    private boolean isRequirePickaxeLevel(Material material, int level){
        if(this.check_correct_tool){
            switch (material){
                case WOOD_PICKAXE:
                    return level <= 0;
                case STONE_PICKAXE:
                    return level <= 1;
                case IRON_PICKAXE:
                    return level <= 2;
                case GOLD_PICKAXE:
                    return level <= 3;
                case DIAMOND_PICKAXE:
                    return level <= 4;
            }
        }
        return true;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        Player player = e.getPlayer();
        if(this.isHostWorld(player.getWorld())){
            Block block = e.getBlock();
            for(Material cut_clean_material: this.cut_clean_materials){
                if(cut_clean_material == block.getType()){
                    e.setCancelled(true);
                    applyCutClean(block, player);
                }
            }
        }
    }

    @EventHandler
    public void openInventoryEvent(InventoryOpenEvent e){
        if(this.isHostWorld(e.getPlayer().getWorld())){
            if (!this.unlimited_lapis) return;

            if (e.getInventory() instanceof EnchantingInventory){
                e.getInventory().setItem(1, this.lapis);
            }
        }
    }

    @EventHandler
    public void closeInventoryEvent(InventoryCloseEvent e){
        if(this.isHostWorld(e.getPlayer().getWorld())){
            if (!this.unlimited_lapis) return;

            if (e.getInventory() instanceof EnchantingInventory){
                e.getInventory().setItem(1, null);
            }
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if(this.isHostWorld(e.getWhoClicked().getWorld())){
            Inventory inv = e.getInventory();
            ItemStack item = e.getCurrentItem();
            if (!this.unlimited_lapis) return;
            if (inv == null || item == null) return;

            if (inv instanceof EnchantingInventory){

                if (item.getType().equals(this.lapis.getType())){
                    e.setCancelled(true);
                }else {
                    e.getInventory().setItem(1, this.lapis);
                }
            }
        }
    }
}

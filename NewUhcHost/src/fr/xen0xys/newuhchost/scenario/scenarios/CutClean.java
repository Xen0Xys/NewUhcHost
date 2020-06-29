package fr.xen0xys.newuhchost.scenario.scenarios;

import fr.xen0xys.newuhchost.gamemodes.Host;
import fr.xen0xys.newuhchost.scenario.Scenario;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class CutClean extends Scenario implements Listener {

    private Material[] cut_clean_materials = {Material.IRON_ORE, Material.GOLD_ORE};
    private Host host;

    public CutClean(Host host) {
        super(host);
        this.host = host;
    }

    private void applyCutClean(Block block, Player player){
        block.setType(Material.AIR);
        Location block_location = block.getLocation();
        this.host.getWorld().dropItem(block_location, new ItemStack(Material.IRON_INGOT, 1));
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        Player player = e.getPlayer();
        if(player.getWorld() == this.host.getWorld()){
            Block block = e.getBlock();
            for(Material cut_clean_material: this.cut_clean_materials){
                if(cut_clean_material == block.getType()){
                    e.setCancelled(true);
                    applyCutClean(block, player);
                }
            }
        }
    }
}

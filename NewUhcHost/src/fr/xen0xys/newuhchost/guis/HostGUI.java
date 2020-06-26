package fr.xen0xys.newuhchost.guis;

import fr.xen0xys.newuhchost.NewUhcHost;
import fr.xen0xys.newuhchost.enums.Language;
import fr.xen0xys.newuhchost.gamemodes.Host;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class HostGUI extends GUI implements InventoryHolder {

    public HostGUI(Player player){
        super(36, Language.HOST.getText());
        this.fillInventory();
        addCurrentHosts(NewUhcHost.getHosts());
        if(player.hasPermission("newuhchost.createhost"))
            this.getInventory().setItem(31, getCreateHostItem());
    }

    public void addCurrentHosts(List<Host> hosts){
        int case_number = 0;
        if(this.getInventory().getSize() > hosts.size()){
            case_number = hosts.size();
        }else if(this.getInventory().getSize() > hosts.size()){
            case_number = this.getInventory().getSize();
        }
        for(int i = 0; i < case_number; i++){
            this.getInventory().setItem(i, hosts.get(i).getHostItem());
        }
    }

    private ItemStack getCreateHostItem(){
        ItemStack item = new ItemStack(Material.GRASS);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Language.CREATE_HOST.getText());
        item.setItemMeta(meta);
        return item;
    }

    public static void onClick(ItemStack item, Player player){
        if(item.getType().equals(Material.GRASS) && item.getItemMeta().getDisplayName().equals(Language.CREATE_HOST.getText())){
            player.openInventory(new GamemodeChoiceGUI().getInventory());
        }
    }
}

package fr.xen0xys.newuhchost.events;

import fr.xen0xys.newuhchost.guis.HostGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class OnInventoryClick implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        String inventory_name = e.getClickedInventory().getName();
        Player player = (Player) e.getWhoClicked();
        ItemStack item = e.getCurrentItem();
        if(inventory_name.equals("Host")){
            e.setCancelled(true);
            HostGUI.onClick(item, player);
        }
    }
}

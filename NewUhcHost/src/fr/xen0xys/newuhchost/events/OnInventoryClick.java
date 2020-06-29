package fr.xen0xys.newuhchost.events;

import fr.xen0xys.newuhchost.enums.Language;
import fr.xen0xys.newuhchost.guis.GamemodeChoiceGUI;
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
        if(inventory_name == null){
            return;
        }
        Player player = (Player) e.getWhoClicked();
        ItemStack item = e.getCurrentItem();
        if(inventory_name.equals(Language.HOST.getText())){
            e.setCancelled(true);
            HostGUI.onClick(item, player);
        }else if(inventory_name.equals(Language.GAMEMODE_CHOICE.getText())){
            e.setCancelled(true);
            GamemodeChoiceGUI.onClick(item, player);
        }
    }
}

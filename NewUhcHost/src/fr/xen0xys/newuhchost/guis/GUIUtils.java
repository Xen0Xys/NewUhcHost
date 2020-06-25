package fr.xen0xys.newuhchost.guis;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUIUtils {
    public static ItemStack getFillItem(){
        ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("-");
        item.setItemMeta(meta);
        return item;
    }

    public static void fillInventory(Inventory inv){
        for(int i = 0; i < inv.getSize(); i++){
            inv.setItem(i, getFillItem());
        }
    }
}

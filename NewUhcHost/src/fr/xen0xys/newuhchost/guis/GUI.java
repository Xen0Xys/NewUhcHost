package fr.xen0xys.newuhchost.guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUI {
    private final Inventory inv;

    public GUI(int size, String name){
        this.inv = Bukkit.createInventory(null, size, name);
    }

    public Inventory getInventory(){
        return this.inv;
    }

    private ItemStack getFillItem(){
        ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("-");
        item.setItemMeta(meta);
        return item;
    }

    public void fillInventory(){
        for(int i = 0; i < inv.getSize(); i++){
            inv.setItem(i, getFillItem());
        }
    }
}

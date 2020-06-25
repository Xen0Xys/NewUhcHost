package fr.xen0xys.newuhchost.guis;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class HostGUI implements InventoryHolder {

    private final Inventory inv;

    public HostGUI(){
        inv = Bukkit.createInventory(null, 45);
    }

    @Override
    public Inventory getInventory() {
        return this.inv;
    }
}

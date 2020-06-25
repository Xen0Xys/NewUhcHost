package fr.xen0xys.newuhchost.guis;

import fr.xen0xys.newuhchost.NewUhcHost;
import fr.xen0xys.newuhchost.models.Host;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class HostGUI implements InventoryHolder {

    private final Inventory inv;

    public HostGUI(){
        this.inv = Bukkit.createInventory(null, 36, "Host");
        GUIUtils.fillInventory(this.inv);
        addCurrentHosts(NewUhcHost.getHosts());
    }

    public void addCurrentHosts(List<Host> hosts){
        int case_number = 0;
        if(this.inv.getSize() > hosts.size()){
            case_number = hosts.size();
        }else if(this.inv.getSize() > hosts.size()){
            case_number = this.inv.getSize();
        }
        for(int i = 0; i < case_number; i++){
            this.inv.setItem(i, hosts.get(i).getHostItem());
        }
    }

    @Override
    public Inventory getInventory() {
        return this.inv;
    }

    public static void onClick(ItemStack item, Player player){

    }
}

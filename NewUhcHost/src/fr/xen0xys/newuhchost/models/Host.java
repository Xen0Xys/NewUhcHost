package fr.xen0xys.newuhchost.models;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

public class Host {

    public ItemStack getHostItem(){
        return new ItemStack(Material.GRASS);
    }

    private final World world;

    public Host(){
        this.world = Bukkit.getWorld("");
    }

    public World getWorld(){
        return world;
    }

    public void start(){

    }

    public void stop(){

    }

}

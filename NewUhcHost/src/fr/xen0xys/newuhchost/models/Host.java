package fr.xen0xys.newuhchost.models;

import fr.xen0xys.newuhchost.NewUhcHost;
import fr.xen0xys.newuhchost.Utils;
import org.apache.commons.io.FileUtils;
import org.bukkit.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

import java.io.File;

import static org.bukkit.Bukkit.getServer;

public class Host {

    public ItemStack getHostItem(){
        return new ItemStack(Material.GRASS);
    }

    private World world = null;
    private final String world_name;
    private final Location spawn_location;

    public Host(){
        this.world_name = "host_" + NewUhcHost.getRandomGameValue();
        initializeWorld();
        spawn_location = new Location(Bukkit.getWorld(world.getName()), 252, 96, 252);
        System.out.println("[NewUhcHost]: " + this.world_name + " initialized");
    }

    private void initializeWorld(){
        world = Bukkit.getWorld(world_name);
        if(world == null){
            world = Bukkit.createWorld(WorldCreator.name(world_name).environment(World.Environment.NORMAL).seed(0));
        }
    }

    public World getWorld(){
        return world;
    }
    public String getWorldName(){
        return this.world_name;
    }
    public Location getSpawnLocation(){
        return this.spawn_location;
    }

    public void start(){

    }

    public void stop(){
        Utils.deleteWorld(this.world_name);
        NewUhcHost.getHosts().remove(this);
    }

}

package fr.xen0xys.newuhchost;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

public class Structures {
    public static void setSpawn(World world){
        int start_y = 150;
        int x_radius = 8;
        int y_radius = 6;
        int z_radius = 8;
        Material material = Material.BARRIER;
        // Ground
        for(int x = -x_radius; x < x_radius; x++){
            for(int z = -z_radius; z < z_radius; z++){
                customSetBlock(new Location(world, x, start_y, z), material);
            }
        }
        // Roof
        for(int x = -x_radius; x < x_radius; x++){
            for(int z = -z_radius; z < z_radius; z++){
                customSetBlock(new Location(world, x, start_y + y_radius, z), material);
            }
        }
        // South wall
        for(int x = -x_radius; x <= x_radius; x++){
            for(int y = start_y; y <= start_y + y_radius; y++){
                customSetBlock(new Location(world, x, y, z_radius), material);
            }
        }
        // East wall
        for(int z = -z_radius; z <= z_radius; z++){
            for(int y = start_y; y <= start_y + y_radius; y++){
                customSetBlock(new Location(world, x_radius, y, z), material);
            }
        }
        // North wall
        for(int x = -x_radius; x <= x_radius; x++){
            for(int y = start_y; y <= start_y + y_radius; y++){
                customSetBlock(new Location(world, x, y, -z_radius), material);
            }
        }
        // West wall
        for(int z = -z_radius; z <= z_radius; z++){
            for(int y = start_y; y <= start_y + y_radius; y++){
                customSetBlock(new Location(world, -x_radius, y, z), material);
            }
        }
    }

    public static void customSetBlock(Location block_location, Material material){
        if(!block_location.getChunk().isLoaded()){
            block_location.getChunk().load();
        }
        block_location.getWorld().getBlockAt(block_location).setType(material);
    }
}

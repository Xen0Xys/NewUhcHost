package fr.xen0xys.newuhchost;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;

import java.io.File;
import java.io.IOException;

public class Utils {
    public static String getTranslationString(String value){
        TranslateLoader handler = new TranslateLoader(NewUhcHost.getInstance()); // 'this' must be replaced with a JavaPlugin reference when used from any other classes.
        return handler.getCaption(value);
    }

    public static void deleteWorld(String world_name){
        System.out.println("[NewUhcHost]: Removing world " + world_name);
        World world = Bukkit.getWorld(world_name);
        Chunk[] chunks = world.getLoadedChunks();
        for (Chunk chunk : chunks) {
            chunk.unload(true);
        }
        Bukkit.unloadWorld(world, true);


        File file = new File(world_name);
        try {
            FileUtils.deleteDirectory(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("[NewUhcHost]: Removed world " + world_name);
    }
}

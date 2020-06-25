package fr.xen0xys.newuhchost.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;

public class OnWorldInit implements Listener {
    @EventHandler
    public void onWorldInit(WorldInitEvent e){
        e.getWorld().setKeepSpawnInMemory(false);
    }
}

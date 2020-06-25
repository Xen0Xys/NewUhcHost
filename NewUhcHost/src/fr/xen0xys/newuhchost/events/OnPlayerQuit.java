package fr.xen0xys.newuhchost.events;

import fr.xen0xys.newuhchost.NewUhcHost;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnPlayerQuit implements Listener {
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){
        Player player = e.getPlayer();
        NewUhcHost.getUsers().remove(player.getUniqueId());
    }
}

package fr.xen0xys.newuhchost.events;

import fr.xen0xys.newuhchost.NewUhcHost;
import fr.xen0xys.newuhchost.models.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        NewUhcHost.getUsers().put(player.getUniqueId(), new User(player));
    }
}

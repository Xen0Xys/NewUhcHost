package fr.xen0xys.newuhchost;

import fr.xen0xys.newuhchost.events.OnPlayerJoin;
import fr.xen0xys.newuhchost.events.OnPlayerQuit;
import fr.xen0xys.newuhchost.models.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class NewUhcHost extends JavaPlugin {

    private static HashMap<UUID, User> users;
    private static NewUhcHost instance;

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;
        this.saveDefaultConfig();
        registerEvents();
        addUsersToUserList();
    }

    private void registerEvents(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new OnPlayerJoin(), this);
        pm.registerEvents(new OnPlayerQuit(), this);
    }

    public static NewUhcHost getInstance(){
        return instance;
    }

    private void addUsersToUserList(){
        for(Player player: Bukkit.getOnlinePlayers()){
            users.put(player.getUniqueId(), new User(player));
        }
    }

    public static HashMap<UUID, User> getUsers() {
        return users;
    }
}

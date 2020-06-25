package fr.xen0xys.newuhchost;

import fr.xen0xys.newuhchost.models.User;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
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
        addUsersToUserList();
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

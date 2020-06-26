package fr.xen0xys.newuhchost;

import fr.xen0xys.newuhchost.commands.NewUhcHostCommand;
import fr.xen0xys.newuhchost.events.OnInventoryClick;
import fr.xen0xys.newuhchost.events.OnPlayerJoin;
import fr.xen0xys.newuhchost.events.OnPlayerQuit;
import fr.xen0xys.newuhchost.events.OnWorldInit;
import fr.xen0xys.newuhchost.gamemodes.Host;
import fr.xen0xys.newuhchost.models.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class NewUhcHost extends JavaPlugin {

    private static final HashMap<UUID, User> users = new HashMap<>();
    private static final List<Host> hosts = new ArrayList<>();
    private static NewUhcHost instance;

    @Override
    public void onDisable() {
        for(Host host: new ArrayList<>(hosts)){
            host.stop();
        }
        super.onDisable();
    }

    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;
        this.saveDefaultConfig();
        registerEvents();
        registerCommands();
        addUsersToUserList();
    }

    private void registerEvents(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new OnPlayerJoin(), this);
        pm.registerEvents(new OnPlayerQuit(), this);
        pm.registerEvents(new OnInventoryClick(), this);
        pm.registerEvents(new OnWorldInit(), this);
    }

    private void registerCommands(){
        this.getCommand("newuhchost").setExecutor(new NewUhcHostCommand());
    }

    public static NewUhcHost getInstance(){
        return instance;
    }
    public static List<Host> getHosts(){
        return hosts;
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

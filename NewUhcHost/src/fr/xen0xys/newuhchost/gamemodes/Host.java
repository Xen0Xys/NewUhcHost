package fr.xen0xys.newuhchost.gamemodes;

import fr.xen0xys.newuhchost.NewUhcHost;
import fr.xen0xys.newuhchost.Structures;
import fr.xen0xys.newuhchost.Utils;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Host {

    private World world = null;
    private final String world_name;
    private final Location spawn_location;
    private final List<Player> game_masters = new ArrayList<>();
    private final List<Player> players = new ArrayList<>();
    private final String gamemode;

    public Host(Player game_master, String gamemode){
        this.world_name = Utils.getConfigValue("host_prefix") + Utils.getAvailableHostValue();
        this.gamemode = gamemode;
        initializeWorld();
        spawn_location = new Location(Bukkit.getWorld(world.getName()), 0, 150, 0);
        addGameMaster(game_master);
        System.out.println("[NewUhcHost]: " + this.world_name + " initialized");
    }

    public void addGameMaster(Player player){
        this.game_masters.add(player);
        if(!isPlayerInGame(player)){
            players.add(player);
            player.teleport(getSpawnLocation());
        }
    }

    public void addPlayer(Player player){
        this.game_masters.add(player);
        if(!isPlayerInGame(player)){
            players.add(player);
            player.teleport(getSpawnLocation());
        }
    }

    public boolean isPlayerInGame(Player player){
        for(Player local_player: new ArrayList<>(players)){
            if(local_player.equals(player)){
                return true;
            }
        }
        return false;
    }

    private void initializeWorld(){
        world = Bukkit.getWorld(world_name);
        if(world == null){
            world = Bukkit.createWorld(WorldCreator.name(world_name).environment(World.Environment.NORMAL).seed(6505837170832228537L));
        }
        Structures.setSpawn(world);
    }

    public ItemStack getHostItem(){
        ItemStack item = new ItemStack(Material.GRASS);
        if(gamemode.equalsIgnoreCase("uhc"))
            item = new ItemStack(Material.GOLDEN_APPLE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(this.gamemode);
        meta.setLore(Arrays.asList(getGameMastersString(), this.world_name));
        item.setItemMeta(meta);
        return item;
    }

    public String getGameMastersString(){
        StringBuilder final_string = new StringBuilder();
        for(Player game_master: this.game_masters){
            final_string.append(game_master.getName()).append("; ");
        }
        return final_string.toString();
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
    public List<Player> getPlayers(){
        return this.players;
    }
    public List<Player> getGameMasters(){
        return this.game_masters;
    }

    public void start(){

    }

    public void stop(){
        Utils.deleteWorld(this.world_name);
        NewUhcHost.getHosts().remove(this);
    }

}

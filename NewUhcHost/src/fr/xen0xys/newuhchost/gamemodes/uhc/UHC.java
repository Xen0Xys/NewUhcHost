package fr.xen0xys.newuhchost.gamemodes.uhc;

import fr.xen0xys.newuhchost.NewUhcHost;
import fr.xen0xys.newuhchost.models.Host;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class UHC extends Host {

    private final List<Player> game_masters = new ArrayList<>();
    private final List<Player> players = new ArrayList<>();

    public UHC(Player game_master){
        this.game_masters.add(game_master);
        players.add(game_master);
        game_master.teleport(getSpawnLocation());

    }

    public void addGameMaster(Player player){
        this.players.add(player);
        this.game_masters.add(player);
        if(!player.getWorld().getName().equals(this.getWorldName())){
            player.teleport(this.getSpawnLocation());
        }
    }

    public List<Player> getGameMasters(){
        return this.game_masters;
    }

    public List<Player> getPlayers(){
        return this.players;
    }


}

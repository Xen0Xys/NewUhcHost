package fr.xen0xys.newuhchost.models;

import org.bukkit.entity.Player;

public class User {
    private final Player player;

    public User(Player player){
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}

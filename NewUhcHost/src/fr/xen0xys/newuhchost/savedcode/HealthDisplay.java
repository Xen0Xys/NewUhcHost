package fr.xen0xys.newuhchost.savedcode;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class HealthDisplay {

    // https://www.spigotmc.org/threads/health-under-player-name.402910/

    private Scoreboard s;

    public HealthDisplay(){
        s = Bukkit.getScoreboardManager().getMainScoreboard();

    }

    private void registerHealthBar(){
        Objective o = s.registerNewObjective("health", "health");
        o.setDisplayName(ChatColor.RED + "❤");
        o.setDisplaySlot(DisplaySlot.BELOW_NAME);
    }

    private void registerNameTag(){
        if(s.getTeam("blue") != null){
            s.getTeam("blue").unregister();
        }
        Team t = s.registerNewTeam("blue");
        t.setPrefix(ChatColor.BLUE + "");
    }

    private void AddPlayer(String team_name, Player player){
        s.getTeam(team_name).addPlayer(player);
    }
}

package fr.xen0xys.newuhchost.gamemodes.uhc;

import fr.xen0xys.newuhchost.NewUhcHost;
import fr.xen0xys.newuhchost.gamemodes.Host;
import fr.xen0xys.newuhchost.scenario.Scenarios;
import org.bukkit.entity.Player;

public class UHC extends Host {

    public UHC(Player game_master){
        super(game_master, "uhc");
        NewUhcHost.getScenarioManager().addScenario(this, Scenarios.CUT_CLEAN);
    }

}

package fr.xen0xys.newuhchost.scenario;

import fr.xen0xys.newuhchost.gamemodes.Host;
import org.bukkit.World;
import org.bukkit.event.Listener;

public class Scenario implements Listener {

    private final Host host;

    public Scenario(Host host){
        this.host = host;
    }

    public Host getHost(){
        return this.host;
    }

    public boolean isHostWorld(World world){
        return world == this.host.getWorld();
    }
}

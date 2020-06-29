package fr.xen0xys.newuhchost.scenario;

import fr.xen0xys.newuhchost.NewUhcHost;
import fr.xen0xys.newuhchost.gamemodes.Host;
import org.bukkit.Bukkit;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScenarioManager {

    private final NewUhcHost plugin;
    private final HashMap<Host, List<Scenario>> scenarios = new HashMap<>();

    public ScenarioManager(NewUhcHost plugin){
        this.plugin = plugin;
    }

    public boolean addScenario(Host host, Scenarios custom_scenario){
        Class<? extends Scenario> scenario_class = custom_scenario.getScenarioClass();
        Scenario scenario = null;
        try {
            scenario = scenario_class.getConstructor(Host.class).newInstance(host);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        if(scenario == null){
            System.out.println("[NewUhcHost]: the scenario can't be activated");
        }else{
            List<Scenario> scenarios = this.scenarios.get(host);
            scenarios.add(scenario);
            this.scenarios.put(host, scenarios);
            Bukkit.getPluginManager().registerEvents(scenario, this.plugin);
        }
        return true;
    }
}

package fr.xen0xys.newuhchost.scenario;

import fr.xen0xys.newuhchost.scenario.scenarios.CutClean;

public enum Scenarios {

    CUT_CLEAN(CutClean.class);

    private final Class<? extends Scenario> scenario_class;

    Scenarios(Class<? extends Scenario> scenario_class){
        this.scenario_class = scenario_class;
    }

    public Class<? extends Scenario> getScenarioClass(){
        return this.scenario_class;
    }
}

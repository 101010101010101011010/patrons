package edu.ics4u.nicolas.keymaps;

import java.util.ArrayList;

import edu.ics4u.nicolas.cars.Car;

public class IJKLKeymap implements Keymap {

    @Override
    public Actions[] keysToActions(String keys) {
    ArrayList<Actions> actions = new ArrayList<>();
    String lowerKeys = keys.toLowerCase();

    if (lowerKeys.contains("i")) { actions.add(Actions.accelerate); }
    else { actions.add(Actions.decelerate); }

    if (lowerKeys.contains("k")) { actions.add(Actions.initiateBrake); }
    else { actions.add(Actions.endBrake); }

    return (Actions[])actions.toArray();
    }

    @Override
    public String actionsToKeys(Actions[] actions) {
    String keys = "";

    for (Actions action : actions) {
        if (action == Actions.accelerate) { keys += "I"; }
        else if (action == Actions.initiateBrake) { keys += "K"; }
    }

    return keys;
    }

    @Override
    public String carToKeys(Car car) {
    String keys = "";

    if (car.isAccelerating()) { keys += "I"; }
    if (car.isBreaking()) { keys += "K"; }

    return keys;
    }

}

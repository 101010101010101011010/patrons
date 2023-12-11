package edu.ics4u.nicolas.keymaps;

import java.util.ArrayList;

import edu.ics4u.nicolas.cars.Car;

public class WASDKeymap implements Keymap {

  @Override
  public Actions[] keysToActions(String keys) {
    ArrayList<Actions> actions = new ArrayList<>();
    String lowerKeys = keys.toLowerCase();
    
    if (lowerKeys.contains("w")) { actions.add(Actions.accelerate); }
    else { actions.add(Actions.decelerate); }

    if (lowerKeys.contains("s")) { actions.add(Actions.initiateBrake); }
    else { actions.add(Actions.endBrake); }

    return (Actions[])actions.toArray();
  }

  @Override
  public String actionsToKeys(Actions[] actions) {
    String keys = "";

    for (Actions action : actions) {
      if (action == Actions.accelerate) { keys += "W"; }
      else if (action == Actions.initiateBrake) { keys += "S"; }
    }

    return keys;
  }

  @Override
  public String carToKeys(Car car) {
    String keys = "";

    if (car.isAccelerating()) { keys += "W"; }
    if (car.isBreaking()) { keys += "S"; }

    return keys;
  }
  
}

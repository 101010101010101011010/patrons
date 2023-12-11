package edu.ics4u.nicolas.keymaps;

import java.util.ArrayList;
import java.util.HashMap;

public class WASDKeymap implements Keymap {
  @Override
  public Actions[] keysToActions(String keys) {
    ArrayList<Actions> actions = new ArrayList<>();
    
    if (keys.contains("w")) { actions.add(Actions.accelerate); }
    else { actions.add(Actions.decelerate); }

    if (keys.contains("s")) { actions.add(Actions.initiateBrake); }
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
  
}

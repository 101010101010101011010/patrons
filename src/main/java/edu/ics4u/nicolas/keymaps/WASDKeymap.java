package edu.ics4u.nicolas.keymaps;

import java.util.ArrayList;

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
  public String actionToKey(Actions[] actions) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'actionToKey'");
  }
  
}

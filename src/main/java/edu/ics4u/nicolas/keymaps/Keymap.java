package edu.ics4u.nicolas.keymaps;

import edu.ics4u.nicolas.cars.Car;

public interface Keymap {
  Actions[] keysToActions(String keys);
  String actionsToKeys(Actions[] actions);
  String carToKeys(Car car);
}
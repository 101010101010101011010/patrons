package edu.ics4u.nicolas.displays;

import edu.ics4u.nicolas.cars.Car;
import edu.ics4u.nicolas.game.Game;
import edu.ics4u.nicolas.keymaps.Keymap;

public class BayDisplay implements Display {
  @Override
  public String renderTop(Game game) {
    Car car = game.getCar();
    Keymap keymap = game.getKeymap();

    String pressedKeys = String.join(", ", keymap.carToKeys(car).split(""));

    return "Accélère: " + (car.isAccelerating() ? "✔" : "✘") + " | Freine: " + (car.isBreaking() ? "✔" : "✘") + " | Clées: " + pressedKeys;
  }

  @Override
  public String renderBottom(Game game) {
    return "Vitesse: " + (int)(game.getCar().getSpeed()*10000) + "m/h";
  }
}

package edu.ics4u.nicolas.displays;

import edu.ics4u.nicolas.cars.Car;
import edu.ics4u.nicolas.game.Game;
import edu.ics4u.nicolas.keymaps.Keymap;

public class StadiumDisplay implements Display {
  int lastSpeed = 0;

  @Override
  public String renderTop(Game game) {
    Car car = game.getCar();
    Keymap keymap = game.getKeymap();

    int currentSpeed = (int)(game.getCar().getSpeed()*10000);
    int deltaSpeed = currentSpeed - lastSpeed;
    lastSpeed = currentSpeed;

    String pressedKeys = String.join(", ", keymap.carToKeys(car).split(""));
    
    return "Clées: " + pressedKeys + " | Delta: " + deltaSpeed + "m/h";
  }

  @Override
  public String renderBottom(Game game) {
    return "Vitesse: " + (int)(game.getCar().getSpeed()*10000) + "m/h";
  }
}

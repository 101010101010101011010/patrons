package edu.ics4u.nicolas.displays;

import edu.ics4u.nicolas.cars.Car;
import edu.ics4u.nicolas.game.Game;

public class BayDisplay implements Display {
  @Override
  public String renderTop(Game game) {
    Car car = game.getCar();

    return "Accélère: " + (car.isAccelerating() ? "✔" : "✘") + " | Freine: " + (car.isBreaking() ? "✔" : "✘") + " | Clées: " + (car.isAccelerating() ? (car.isBreaking() ? "W, S" : " W  ") : (car.isBreaking() ? " S  " : "    "));
  }

  @Override
  public String renderBottom(Game game) {
    return "Vitesse: " + (int)(game.getCar().getSpeed()*10000) + "m/h";
  }
}

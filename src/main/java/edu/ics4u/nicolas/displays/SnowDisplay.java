package edu.ics4u.nicolas.displays;

import edu.ics4u.nicolas.cars.Car;
import edu.ics4u.nicolas.game.Game;

public class SnowDisplay implements Display {
  @Override
  public String renderTop(Game game) {
    Car car = game.getCar();

    return "Accélère: " + (car.isAccelerating() ? "✔" : "✘") + " | Freine: " + (car.isBreaking() ? "✔" : "✘");
  }

  @Override
  public String renderBottom(Game game) {
    return "Vitesse: " + String.valueOf((int)(game.getCar().getSpeed()*100));
  }
}

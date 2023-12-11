package edu.ics4u.nicolas.displays;

import edu.ics4u.nicolas.cars.Car;
import edu.ics4u.nicolas.game.Game;

public class StadiumDisplay implements Display {
  int lastSpeed = 0;

  @Override
  public String renderTop(Game game) {
    Car car = game.getCar();

    int currentSpeed = (int)(game.getCar().getSpeed()*10000);
    int deltaSpeed = currentSpeed - lastSpeed;
    lastSpeed = currentSpeed;

    return "Clées: " + (car.isAccelerating() ? (car.isBreaking() ? "W, S" : " W  ") : (car.isBreaking() ? " S  " : "    ")) + " | Delta: " + deltaSpeed + "m/h";
  }

  @Override
  public String renderBottom(Game game) {
    return "Vitesse: " + (int)(game.getCar().getSpeed()*10000) + "m/h";
  }
}

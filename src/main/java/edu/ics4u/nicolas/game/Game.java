package edu.ics4u.nicolas.game;

import edu.ics4u.nicolas.cars.Car;
import edu.ics4u.nicolas.factories.TrackmaniaFactory;
import edu.ics4u.nicolas.keymaps.Actions;
import edu.ics4u.nicolas.sceneries.Scenery;

public class Game {
    private Car car;
    private Scenery scenery;

    public Game(TrackmaniaFactory factory) {
      this.car = factory.createCar();
      this.scenery = factory.creatScenery();
    }

    public void step(double fps) {
      car.step(fps);
      scenery.step(car, fps);
    }

    public void render() {
      String background = scenery.render();
      String midground = car.render();

      int cutoffLeft = background.length()/2 - midground.length() / 2; // Arrondis vers le bas
      int cutoffRight = background.length()/2 + (midground.length() + 1) / 2; // Arrondis vers le haut

      String view = background.substring(0, cutoffLeft) + midground + background.substring(cutoffRight);

      System.out.print("\033[H\033[2J");
      System.out.flush();
      System.out.println(view);
    }

    public void performActions(Actions[] actions) {
      for (Actions action : actions) {
        performAction(action);
      }
    }

    public void performAction(Actions action) {
      switch (action) {
        case accelerate:
          car.accelerate();
          break;
        case decelerate:
          car.decelerate();
          break;
        case initiateBrake:
          car.initiateBrake();
          break;
        case endBrake:
          car.endBrake();
          break;
        default:
          break;
      }
    }
}

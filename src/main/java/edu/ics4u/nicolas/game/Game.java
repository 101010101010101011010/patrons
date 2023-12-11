package edu.ics4u.nicolas.game;

import edu.ics4u.nicolas.cars.Car;
import edu.ics4u.nicolas.displays.Display;
import edu.ics4u.nicolas.factories.TrackmaniaFactory;
import edu.ics4u.nicolas.keymaps.Actions;
import edu.ics4u.nicolas.sceneries.Scenery;

public class Game {
    private Car car;
    private Scenery scenery;
    private Display display;

    public Game(TrackmaniaFactory factory) {
      this.car = factory.createCar();
      this.scenery = factory.creatScenery();
      this.display = factory.createDisplay();
    }

    public Car getCar() {
      return car;
    }

    public Scenery getScenery() {
      return scenery;
    }

    public void step(double fps) {
      car.step(fps);
      scenery.step(car, fps);
    }

    public void render() {
      String background = scenery.render();
      String midground = car.render();

      int cutoffLeft = background.length()/2 - 2; // Arrondis vers le bas
      int cutoffRight = cutoffLeft + midground.length(); // Arrondis vers le haut

      String view = background.substring(0, cutoffLeft) + midground + background.substring(cutoffRight);

      String upperDisplay = display.renderTop(this);
      String lowerDisplay = display.renderBottom(this);

      System.out.println("\u001B[?25l");
      System.out.print("\033[H\033[2J");
      System.out.println(upperDisplay);
      System.out.println(view);
      System.out.println(lowerDisplay);
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

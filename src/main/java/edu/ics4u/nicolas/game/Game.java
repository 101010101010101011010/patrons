package edu.ics4u.nicolas.game;

import edu.ics4u.nicolas.cars.Car;
import edu.ics4u.nicolas.displays.Display;
import edu.ics4u.nicolas.factories.TrackmaniaFactory;
import edu.ics4u.nicolas.keymaps.Actions;
import edu.ics4u.nicolas.keymaps.Keymap;
import edu.ics4u.nicolas.sceneries.Scenery;

public class Game {
    private Car car;
    private Scenery scenery;
    private Display display;
    private Keymap keymap;

    public Game(TrackmaniaFactory factory) {
      this.car = factory.createCar();
      this.scenery = factory.creatScenery();
      this.display = factory.createDisplay();
      this.keymap = factory.createKeymap();
    }

    /**
     * Un getter de la voiture.
     * 
     * @return la voiture
     */
    public Car getCar() {
      return car;
    }

    /**
     * Un getter de l'affiche.
     * 
     * @return l'affiche
     */
    public Scenery getScenery() {
      return scenery;
    }

    /**
     * Un getter de la configuration de clées.
     * 
     * @return la configuration de clées
     */
    public Keymap getKeymap() {
      return keymap;
    }

    /**
     * Applique les physiques sur tous les composants du jeu selon le nombre d'images par seconde.
     * 
     * @param fps le nombre d'images par seconde
     */
    public void step(double fps) {
      car.step(fps);
      scenery.step(car, fps);
    }

    /**
     * Dessine tous les visuels des composants du jeu à la terminale.
     */
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

    /**
     * Applique tous les actions voulus.
     * 
     * @param actions les actions à appliquer
     */
    public void performActions(Actions[] actions) {
      for (Actions action : actions) {
        performAction(action);
      }
    }

    /**
     * Applique l'action voulu.
     * 
     * @param action l'action à appliquer
     */
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

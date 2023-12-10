package edu.ics4u.nicolas;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import edu.ics4u.nicolas.factories.BayFactory;
import edu.ics4u.nicolas.factories.SnowFactory;
import edu.ics4u.nicolas.factories.StadiumFactory;
import edu.ics4u.nicolas.game.Game;
import edu.ics4u.nicolas.keymaps.Actions;
import edu.ics4u.nicolas.sceneries.BayScenery;
import edu.ics4u.nicolas.sceneries.Scenery;
import edu.ics4u.nicolas.sceneries.SnowScenery;

/**
 * Hello world!
 *
 */
public class App 
{
  public static void main(String[] args) {
    int fps = 24;

    Game game = new Game(new StadiumFactory());
    game.performAction(Actions.accelerate);

    while (true) {
      try{
        TimeUnit.MILLISECONDS.sleep(1000/fps);
      } catch (Exception e) { }

      if (Math.random() > 0.5/fps) {
        double random1 = Math.random();
        if (random1 > 0.75) {
          game.performAction(Actions.accelerate);
        } else if (random1 > 0.50) {
          game.performAction(Actions.decelerate);
        } else if (random1 > 0.25) {
          game.performAction(Actions.initiateBrake);
        } else {
          game.performAction(Actions.endBrake);
        }
      }
      
      game.step(fps);
      game.render();
    }
  }
}

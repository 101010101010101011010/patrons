package edu.ics4u.nicolas;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import edu.ics4u.nicolas.factories.BayFactory;
import edu.ics4u.nicolas.factories.SnowFactory;
import edu.ics4u.nicolas.factories.StadiumFactory;
import edu.ics4u.nicolas.game.Game;
import edu.ics4u.nicolas.keymaps.Actions;

/**
 * Hello world!
 *
 */
public class App 
{
  public static void main(String[] args) {
    int fps = 24;

    Game game;
    boolean alternateWeights = false;

    System.out.println("\u001B[?25h");
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.print("\033[H\033[2J");
      System.out.flush();
      System.out.println(
        "Choisissez votre environnement:\n" +
        "Stade 🏎️  (1)\n" +
        "Baie  🚐 (2)\n" +
        "Neige 🚙 (3)\n\n" +
        "Choix: "
        );

      String answer = scanner.next();
      if (answer.charAt(0) == '1') {
        game = new Game(new StadiumFactory());
        alternateWeights = true;
        break;
      } else if (answer.charAt(0) == '2') {
        game = new Game(new BayFactory());
        break;
      } else if (answer.charAt(0) == '3') {
        game = new Game(new SnowFactory());
        break;
      }
    }
    scanner.close();

    game.performAction(Actions.accelerate);

    while (true) {
      try{
        TimeUnit.MILLISECONDS.sleep(1000/fps);
      } catch (Exception e) { }

      if (Math.random() > 1-0.5/fps) {
        double random1 = Math.random();
        if (random1 > (alternateWeights ? 0.75 : 0.70)) {
          game.performAction(Actions.accelerate);
        } else if (random1 > 0.50) {
          game.performAction(Actions.decelerate);
        } else if (random1 > (alternateWeights ? 0.25 : 0.30)) {
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

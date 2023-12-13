package edu.ics4u.nicolas.sceneries;

import edu.ics4u.nicolas.cars.Car;

public interface Scenery {
  /**
   * La largeure de l'écran en charactères.
   */
  final int printWidth = 40;



  /**
   * Dessine le visuel du paysage dans un {@code String}.
   * 
   * @return le visuelle du paysage
   */
  String render();
  
  /**
   * Applique un déphasage sur le paysage selon le nombre d'images par seconde et l'état de la voiture.
   * 
   * @param car la voiture du jeu
   * @param fps le nombre d'images par seconde
   */
  void step(Car car, double fps);
}

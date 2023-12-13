package edu.ics4u.nicolas.displays;

import edu.ics4u.nicolas.game.Game;

public interface Display {
  /**
   * Dessine le haut du visuel de l'affiche dans un {@code String}.
   * 
   * @param game l'objet du jeu
   * @return le haut du visuel de l'affiche
   */
  String renderTop(Game game);

  /**
   * Dessine le bas du visuel de l'affiche dans un {@code String}.
   * 
   * @param game l'objet du jeu
   * @return le bas du visuel de l'affiche
   */
  String renderBottom(Game game);
}

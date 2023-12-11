package edu.ics4u.nicolas.displays;

import edu.ics4u.nicolas.game.Game;

public interface Display {
  String renderTop(Game game);
  String renderBottom(Game game);
}

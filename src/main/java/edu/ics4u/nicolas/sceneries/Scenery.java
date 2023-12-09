package edu.ics4u.nicolas.sceneries;

public interface Scenery {
  final int printWidth = 40;

  String render();
  void step(int fps);
}

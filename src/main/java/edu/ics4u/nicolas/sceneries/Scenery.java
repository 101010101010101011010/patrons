package edu.ics4u.nicolas.sceneries;

import edu.ics4u.nicolas.cars.Car;

public interface Scenery {
  final int printWidth = 40;

  String render();
  void step(Car car, double fps);
}

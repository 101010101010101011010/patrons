package edu.ics4u.nicolas.sceneries;

import edu.ics4u.nicolas.cars.Car;

public class StadiumScenery implements Scenery {
  private final String scene = "__⇐__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ ";

  private double offset = 0;

  @Override
  public String render() {
    String str = scene.substring((int)offset, scene.length());
    
    while (str.length() < printWidth) {
      str += scene;
    }

    return str.substring(0, printWidth);
  }

  @Override
  public void step(Car car, double fps) {
    offset = (offset - car.getSpeed() + scene.length()) % scene.length();
  }
}

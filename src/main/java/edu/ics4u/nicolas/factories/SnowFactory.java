package edu.ics4u.nicolas.factories;

import edu.ics4u.nicolas.cars.Car;
import edu.ics4u.nicolas.cars.SnowCar;
import edu.ics4u.nicolas.displays.Display;
import edu.ics4u.nicolas.displays.SnowDisplay;
import edu.ics4u.nicolas.sceneries.Scenery;
import edu.ics4u.nicolas.sceneries.SnowScenery;

public class SnowFactory implements TrackmaniaFactory {

  @Override
  public Car createCar() {
    return new SnowCar();
  }

  @Override
  public Scenery creatScenery() {
    return new SnowScenery();
  }

  @Override
  public Display createDisplay() {
    return new SnowDisplay();
  }
    
}

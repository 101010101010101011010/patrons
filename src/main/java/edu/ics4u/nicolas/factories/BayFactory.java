package edu.ics4u.nicolas.factories;

import edu.ics4u.nicolas.cars.BayCar;
import edu.ics4u.nicolas.cars.Car;
import edu.ics4u.nicolas.displays.BayDisplay;
import edu.ics4u.nicolas.displays.Display;
import edu.ics4u.nicolas.sceneries.BayScenery;
import edu.ics4u.nicolas.sceneries.Scenery;

public class BayFactory implements TrackmaniaFactory {

  @Override
  public Car createCar() {
    return new BayCar();
  }

  @Override
  public Scenery creatScenery() {
    return new BayScenery();
  }

  @Override
  public Display createDisplay() {
    return new BayDisplay();
  }
    
}

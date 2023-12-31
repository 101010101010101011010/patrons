package edu.ics4u.nicolas.factories;

import edu.ics4u.nicolas.cars.Car;
import edu.ics4u.nicolas.cars.StadiumCar;
import edu.ics4u.nicolas.displays.Display;
import edu.ics4u.nicolas.displays.StadiumDisplay;
import edu.ics4u.nicolas.keymaps.Keymap;
import edu.ics4u.nicolas.keymaps.WASDKeymap;
import edu.ics4u.nicolas.sceneries.Scenery;
import edu.ics4u.nicolas.sceneries.StadiumScenery;

public class StadiumFactory implements TrackmaniaFactory {

  @Override
  public Car createCar() {
    return new StadiumCar();
  }

  @Override
  public Scenery creatScenery() {
    return new StadiumScenery();
  }

  @Override
  public Display createDisplay() {
    return new StadiumDisplay();
  }

  @Override
  public Keymap createKeymap() {
    return new WASDKeymap();
  }
  
}

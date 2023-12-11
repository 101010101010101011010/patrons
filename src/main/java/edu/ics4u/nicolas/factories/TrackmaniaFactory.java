package edu.ics4u.nicolas.factories;

import edu.ics4u.nicolas.cars.Car;
import edu.ics4u.nicolas.displays.Display;
import edu.ics4u.nicolas.sceneries.Scenery;

public interface TrackmaniaFactory {
    Car createCar();
    Scenery creatScenery();
    Display createDisplay();
}

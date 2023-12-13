package edu.ics4u.nicolas.factories;

import edu.ics4u.nicolas.cars.Car;
import edu.ics4u.nicolas.displays.Display;
import edu.ics4u.nicolas.keymaps.Keymap;
import edu.ics4u.nicolas.sceneries.Scenery;

public interface TrackmaniaFactory {
    /**
     * Crée un objet de voiture et le retourner.
     * 
     * @return le nouvle objet de voiture
     */
    Car createCar();

    /**
     * Crée un objet de paysage et le retourner.
     * 
     * @return le nouvle objet de paysage
     */
    Scenery creatScenery();

    /**
     * Crée un objet d'affiche et le retourner.
     * 
     * @return le nouvle objet d'affiche
     */
    Display createDisplay();

    /**
     * Crée un objet de configuration de clées et le retourner.
     * 
     * @return le nouvle objet de configuration de clées
     */
    Keymap createKeymap();
}

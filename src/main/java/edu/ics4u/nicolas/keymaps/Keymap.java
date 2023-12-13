package edu.ics4u.nicolas.keymaps;

import edu.ics4u.nicolas.cars.Car;

public interface Keymap {
  /**
   * Convertis les clées en actions.
   * 
   * @param keys un {@code String} des clées à convertir
   * @return une liste des actions convertis
   */
  Actions[] keysToActions(String keys);

  /**
   * Convertis les actions en clées.
   * 
   * @param actions une liste des actions à convertir
   * @return un {@code String} des clées convertis
   */
  String actionsToKeys(Actions[] actions);

  /**
   * Traduit l'état de la voiture en un {@code String} des clées appuïées.
   * 
   * @param car la voiture ciblée
   * @return un {@code String} des clées résultantes
   */
  String carToKeys(Car car);
}
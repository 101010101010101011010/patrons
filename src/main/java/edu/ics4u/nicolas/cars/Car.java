package edu.ics4u.nicolas.cars;

public interface Car {
    /**
     * Dessine le visuel de la voiture dans un {@code String}.
     * 
     * @return le visuelle de la voiture
     */
    String render();

    /**
     * Applique les physiques sur la voiture selon le nombre d'images par seconde.
     * 
     * @param fps le nombre d'images par seconde
     */
    void step(double fps);



    /**
     * Met la voiture dans un état d'accélération.
     */
    void accelerate();

    /**
     * Met la voiture dans un état d'aucune accélération.
     */
    void decelerate();



    /**
     * Met la voiture dans un état de freinâge.
     */
    void initiateBrake();

    /**
     * Met la voiture dans un état d'aucun freinâge.
     */
    void endBrake();



    /**
     * Un getter de l'état de dérivâge.
     * 
     * @return un {@code booléan} représentant l'état de dérivage de la voiture
     */
    boolean isDrifting();

    /**
     * Un getter de l'état de freinâge.
     * 
     * @return un {@code booléan} représentant l'état de freinâge de la voiture
     */
    boolean isBreaking();

    /**
     * Un getter de l'état d'accélération.
     * 
     * @return un {@code booléan} représentant l'état d'accélération de la voiture
     */
    boolean isAccelerating();

    /**
     * Un getter de la vitesse maximale de la voiture.
     * 
     * @return un {@code double} de la vitesse maximale de la voiture
     */
    double getMaxSpeed();

    /**
     * Un getter de la vitesse de la voiture.
     * 
     * @return un {@code double} de la vitesse de la voiture
     */
    double getSpeed();
}

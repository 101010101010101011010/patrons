package edu.ics4u.nicolas.cars;

public interface Car {
    String render();
    void step(int fps);

    void accelerate();
    void decelerate();

    void initiateBrake();
    void endBrake();

    boolean isDrifting();
    int getMaxSpeed();
}

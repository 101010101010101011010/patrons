package edu.ics4u.nicolas.cars;

public interface Car {
    String render();
    void step(double fps);

    void accelerate();
    void decelerate();

    void initiateBrake();
    void endBrake();

    boolean isDrifting();
    boolean isBreaking();
    double getMaxSpeed();
    double getSpeed();
}

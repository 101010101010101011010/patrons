package edu.ics4u.nicolas.cars;

public class StadiumCar implements Car {
    private final int maxSpeed = 999; // unités par seconde
    private final int acceleration = 1; // unités par seconde par seconde

    private int speed = 0;
    private boolean isAccelerating = false;
    private boolean isBreaking = false;

    public String render() {
        return "🏎️" + (isDrifting() ? "💭" : "") + (isAccelerating ? "≡" : "");
    }

    public void step(int fps) {
        if (isAccelerating) {
            speed += acceleration / fps;
        }

        if (isDrifting()) {
            speed -= acceleration / 2 / fps;
        } else if (isBreaking) {
            speed -= 2 * acceleration / fps;
        }

    }



    public void accelerate() {
        isAccelerating = true;
    }

    public void decelerate() {
        isAccelerating = false;
    }


    public void initiateBrake() {
        isBreaking = true;
    }

    public void endBrake() {
        isBreaking = false;
    }



    public boolean isDrifting() {
        return isBreaking && speed > 100;
    }


    public int getMaxSpeed() {
        return maxSpeed;
    }
}

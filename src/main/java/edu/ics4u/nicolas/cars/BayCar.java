package edu.ics4u.nicolas.cars;

public class BayCar implements Car {
  private final double maxSpeed = 20; // unités par seconde
  private final double acceleration = 0.06; // unités par seconde par seconde
  private final double driftSpeed = 5; // minumum de vitesse (u/s) où la voiture peut dériver

  private double speed = 0;
  private boolean isAccelerating = false;
  private boolean isBreaking = false;

  @Override
  public String render() {
      return "🚐" + (isDrifting() ? "💭" : "") + (isAccelerating && !isDrifting() ? "≡" : "");
  }

  @Override
  public void step(double fps) {
      if (isAccelerating) {
          speed += acceleration / fps;
      }

      if (isBreaking) {
          speed -= (isDrifting() ? 1 : 4) * acceleration / fps;
      }

  }



  @Override
  public void accelerate() {
      isAccelerating = true;
  }

  @Override
  public void decelerate() {
      isAccelerating = false;
  }

  @Override
  public void initiateBrake() {
      isBreaking = true;
  }

  @Override
  public void endBrake() {
      isBreaking = false;
  }



  @Override
  public boolean isDrifting() {
      return isBreaking && speed >= driftSpeed;
  }

  @Override
  public boolean isBreaking() {
      return isBreaking;
  }


  @Override
  public double getMaxSpeed() {
      return maxSpeed;
  }

  @Override
  public double getSpeed() {
      return speed;
  }
}

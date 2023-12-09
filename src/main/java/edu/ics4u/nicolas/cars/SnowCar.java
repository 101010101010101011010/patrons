package edu.ics4u.nicolas.cars;

public class SnowCar implements Car {
  private final double maxSpeed = 99; // unités par seconde
  private final double acceleration = 1; // unités par seconde par seconde

  private double speed = 0.4;
  private boolean isAccelerating = false;
  private boolean isBreaking = false;

  @Override
  public String render() {
      return "🚙" + (isAccelerating ? "≡" : "");
  }

  @Override
  public void step(int fps) {
      if (isAccelerating) {
          speed += acceleration / fps;
      }

      if (isBreaking) {
          speed -= 2 * acceleration / fps;
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
      return false;
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

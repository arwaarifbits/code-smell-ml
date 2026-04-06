package Problem1AndProblem2;

import java.util.Objects;

/**
 * This is abstract Vehicle class. Represent the vehicle.
 */
public abstract class Vehicle {

  private String iD;
  private Float avgSpeed;
  private Float maxSpeed;

  /**
   * Constructor for Vehicle with ID, average speed and maximum speed
   *
   * @param iD       - ID, represented as a String
   * @param avgSpeed - Average speed, represented as a Float
   * @param maxSpeed - Max speed, represented as a Float
   */
  public Vehicle(String iD, Float avgSpeed, Float maxSpeed) {
    this.iD = iD;
    this.avgSpeed = avgSpeed;
    this.maxSpeed = maxSpeed;
  }

  /**
   * Return ID
   *
   * @return id, float
   */
  public String getiD() {
    return this.iD;
  }

  /**
   * Return average speed
   *
   * @return average speed, float
   */
  public Float getAvgSpeed() {
    return this.avgSpeed;
  }

  /**
   * Return maximum speed
   *
   * @return maximum speed, float
   */
  public Float getMaxSpeed() {
    return this.maxSpeed;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vehicle vehicle = (Vehicle) o;
    return iD.equals(vehicle.iD) && avgSpeed.equals(vehicle.avgSpeed) && maxSpeed.equals(
        vehicle.maxSpeed);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(iD, avgSpeed, maxSpeed);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return
        "iD='" + iD + '\'' +
            ", avgSpeed=" + avgSpeed +
            ", maxSpeed=" + maxSpeed;
  }
}

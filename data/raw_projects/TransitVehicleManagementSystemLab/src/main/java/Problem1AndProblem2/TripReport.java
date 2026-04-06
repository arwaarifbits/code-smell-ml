package Problem1AndProblem2;

import java.util.Objects;

/**
 * This is TripReport class. Represent a report used to store information about a trip made by a
 * particular vehicle.
 */
public class TripReport {

  private Vehicle vehicle;
  private Float speed;
  private Float distance;
  private Integer duration;

  /**
   * Constructor for the TripReport with vehicle, speed, distance and duration
   *
   * @param vehicle  - the Vehicle that took the trip, vehicle class
   * @param speed    - speed in miles per minute, a Float
   * @param distance - distance traveled in miles, a Float
   * @param duration - trip duration in minutes, an Integer
   */

  public TripReport(Vehicle vehicle, Float speed, Float distance, Integer duration) {
    this.vehicle = vehicle;
    this.speed = speed;
    this.distance = distance;
    this.duration = duration;
  }

  /**
   * Return the vehicle
   *
   * @return the vehicle, Vehicle class
   */
  public Vehicle getVehicle() {
    return this.vehicle;
  }

  /**
   * Return the speed
   *
   * @return speed, float
   */
  public Float getSpeed() {
    return this.speed;
  }

  /**
   * Return distance
   *
   * @return distance, float
   */
  public Float getDistance() {
    return this.distance;
  }

  /**
   * Return duration
   *
   * @return duration, integer
   */
  public Integer getDuration() {
    return this.duration;
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
    TripReport that = (TripReport) o;
    return vehicle.equals(that.vehicle) && speed.equals(that.speed) && distance.equals(
        that.distance)
        && duration.equals(that.duration);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(vehicle, speed, distance, duration);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "TripReport{" +
        "vehicle=" + vehicle +
        ", speed=" + speed +
        ", distance=" + distance +
        ", duration=" + duration +
        '}';
  }
}

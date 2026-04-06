package Problem1AndProblem2;

/**
 * This is FleetManager Class. Represent a fleet manager.
 */
public class FleetManager {

  private final static float UNABLE_TO_FINISH = -1F;

  /**
   * Constructor for FleetManager
   */
  public FleetManager() {
  }

  /**
   * To populate the fields of a TripReport. Get the vehicle’s average speed, and calculate the trip
   * duration as distance divided by speed.
   *
   * @param vehicle  - the Vehicle that took the trip, Vehicle class
   * @param distance - distance traveled in miles, a Float
   * @return a new TripReport with vehicle, avgSpeed, distance and calculated duration
   */
  TripReport drive(Vehicle vehicle, float distance) {
    Float speed = vehicle.getAvgSpeed();
    Integer duration = Math.round(distance / speed);
    return new TripReport(vehicle, speed, distance, duration);
  }

  /**
   * To populate the fields of a TripReport. Get the vehicle’s average speed, and calculate the trip
   * distance as speed times duration.
   *
   * @param vehicle  - the Vehicle that took the trip, Vehicle class
   * @param duration - Trip duration in minutes, an Integer
   * @return a new TripReport with vehicle, avgSpeed, calculated distance and duration
   */
  TripReport drive(Vehicle vehicle, int duration) {
    Float speed = vehicle.getAvgSpeed();
    Float distance = speed * duration;
    return new TripReport(vehicle, speed, distance, duration);
  }

  /**
   * To populate the fields of a TripReport. Get the vehicle’s max speed, and check the given speed
   * is valid, if given speed is smaller than or equal to max speed, use given speed, if given speed
   * is larger than max, use the max speed, calculated the duration based on the speed and given
   * distance.
   *
   * @param vehicle  - the Vehicle that took the trip, Vehicle class
   * @param speed    - given speed in miles per minute, a Float
   * @param distance - given distance traveled in miles, a Float
   * @return a new TripReport with vehicle, valid speed, distance and calculated duration
   */
  TripReport drive(Vehicle vehicle, float speed, float distance) {
    Float max = vehicle.getMaxSpeed();
    if (max > speed) {
      int duration = Math.round(distance / speed);
      return new TripReport(vehicle, speed, distance, duration);
    }
    int duration = Math.round(distance / max);
    return new TripReport(vehicle, max, distance, duration);
  }

  /**
   * To populate the fields of a TripReport. Get the vehicle’s max speed, use given distance and
   * duration to calculate the requiring speed. Check the calculated speed is valid, if speed is
   * smaller than and equal to max speed, use calculated speed, if speed is larger than max, set
   * speed to -1 which means unable to finish the distance in given duration.
   *
   * @param vehicle  - the Vehicle that took the trip, Vehicle class
   * @param distance - given distance traveled in miles, a Float
   * @param duration - Trip duration in minutes, an Integer
   * @return a new TripReport with vehicle, calculated speed, distance and duration
   */
  TripReport drive(Vehicle vehicle, float distance, int duration) {
    Float max = vehicle.getMaxSpeed();
    Float speed = distance / duration;
    if (speed > max) {
      return new TripReport(vehicle, UNABLE_TO_FINISH, distance, duration);
    }
    return new TripReport(vehicle, speed, distance, duration);
  }
}

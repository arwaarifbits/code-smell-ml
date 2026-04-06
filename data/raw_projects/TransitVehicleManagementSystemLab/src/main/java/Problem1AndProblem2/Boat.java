package Problem1AndProblem2;

/**
 * This is Boat class which is the subclass of Vehicle. Represent the vehicle boat.
 */
public class Boat extends Vehicle {

  /**
   * Constructor for Boat with ID, average speed and maximum speed
   *
   * @param iD       - ID, represented as a String
   * @param avgSpeed - Average speed, represented as a Float
   * @param maxSpeed - Max speed, represented as a Float
   */
  public Boat(String iD, Float avgSpeed, Float maxSpeed) {
    super(iD, avgSpeed, maxSpeed);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Boat:" + super.toString();
  }
}

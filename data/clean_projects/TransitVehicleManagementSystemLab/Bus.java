package Problem1AndProblem2;

/**
 * This is Bus class which is the subclass of Vehicle. Represent the vehicle bus.
 */
public class Bus extends Vehicle{
  /**
   * Constructor for Bus with ID, average speed and maximum speed
   * @param iD - ID, represented as a String
   * @param avgSpeed - Average speed, represented as a Float
   * @param maxSpeed - Max speed, represented as a Float
   */
  public Bus(String iD, Float avgSpeed, Float maxSpeed) {
    super(iD, avgSpeed, maxSpeed);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Bus:" + super.toString();
  }
}

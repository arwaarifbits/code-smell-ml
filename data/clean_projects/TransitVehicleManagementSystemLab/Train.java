package Problem1AndProblem2;

/**
 * This is Train class which is the subclass of Vehicle. Represent the vehicle train.
 */
public class Train extends Vehicle {

  /**
   * Constructor for Train with ID, average speed and maximum speed
   *
   * @param iD       - ID, represented as a String
   * @param avgSpeed - Average speed, represented as a Float
   * @param maxSpeed - Max speed, represented as a Float
   */
  public Train(String iD, Float avgSpeed, Float maxSpeed) {
    super(iD, avgSpeed, maxSpeed);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Train:" + super.toString();
  }
}

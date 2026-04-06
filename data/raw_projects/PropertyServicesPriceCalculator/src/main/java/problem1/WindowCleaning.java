package problem1;

import java.util.Objects;

/**
 * This is a WindowCleaning class which is the subclass of the Exterior with one additional field
 * numberOfFloors.
 * Represent the Exterior Window Cleaning Service.
 */
public class WindowCleaning extends Exterior {

  private Integer numberOfFloors;
  private final static Integer MAX = 3;
  private final static Integer EXTRA_FEE_THRESHOLD = 1;
  private final static Double EXTRA_RATE = 0.05;

  /**
   * Constructor for Window Cleaning with propertyAddress, propertySize, carriedOutMonthly and
   * numberOfServices
   *
   * @param propertyAddress   - the property address, represented as a String
   * @param propertySize      - the property size, represented as an enum
   * @param carriedOutMonthly - whether the service is carried out monthly, represented as boolean
   * @param numberOfServices  - The number of services previously carried out at the address,
   *                          represented as an Integer
   * @param numberOfFloors    - The number of floors, represented as Integer
   * @throws InvalidNumberOfFloorsException when the number of floors out of range
   */
  public WindowCleaning(String propertyAddress, PropertySize propertySize,
      boolean carriedOutMonthly,
      int numberOfServices, int numberOfFloors) throws InvalidNumberOfFloorsException {
    super(propertyAddress, propertySize, carriedOutMonthly, numberOfServices);
    this.isValidFloor(numberOfFloors);
    this.numberOfFloors = numberOfFloors;
  }

  /**
   * Check whether the given number of floors out of the maximum range
   *
   * @param numberOfFloors - the number of floors, integer
   * @throws InvalidNumberOfFloorsException when number of floors out of the maximum range
   */
  private void isValidFloor(int numberOfFloors) throws InvalidNumberOfFloorsException {
    if (numberOfFloors > MAX) {
      throw new InvalidNumberOfFloorsException("The maximum number of floors "
          + "that the company can work with is 3 !");
    }
  }

  /**
   * Calculate the extra fee based on the extra rate and the extra fee threshold. A 5% fee is added
   * to the price if the property has more than one floor.
   *
   * @return calculated two decimal rounded addition fee, double
   */
  @Override
  public double calculateAdditionalFee() {
    if (this.numberOfFloors > EXTRA_FEE_THRESHOLD) {
      return Math.round((this.calculateBaseFee() * EXTRA_RATE) * 100.0) / 100.0;
    }
    return 0;
  }

  /**
   * Return the number of floors
   *
   * @return numberOfFloors, integer
   */
  public Integer getNumberOfFloors() {
    return this.numberOfFloors;
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
    if (!super.equals(o)) {
      return false;
    }
    WindowCleaning that = (WindowCleaning) o;
    return numberOfFloors.equals(that.numberOfFloors);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numberOfFloors);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "WindowCleaning:" + super.toString() +
        "numberOfFloors=" + numberOfFloors;
  }
}

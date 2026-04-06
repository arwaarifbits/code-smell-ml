package problem1;

/**
 * This is a Gardening class which is the subclass of the Exterior. Represent the Exterior Gardening
 * Service.
 */
public class Gardening extends Exterior {

  private final static double WASTE_REMOVAL_FEE = 20.0;

  /**
   * Constructor for Gardening with propertyAddress, propertySize, carriedOutMonthly and
   * numberOfServices
   *
   * @param propertyAddress   - the property address, represented as a String
   * @param propertySize      - the property size, represented as an enum
   * @param carriedOutMonthly - whether the service is carried out monthly, represented as boolean
   * @param numberOfServices  - The number of services previously carried out at the address,
   *                          represented as an Integer
   */
  public Gardening(String propertyAddress, PropertySize propertySize, boolean carriedOutMonthly,
      int numberOfServices) {
    super(propertyAddress, propertySize, carriedOutMonthly, numberOfServices);
  }

  /**
   * Calculate the additional fee which is a $20 waste removal fee
   *
   * @return the calculated additional fee, double
   */
  @Override
  public double calculateAdditionalFee() {
    return WASTE_REMOVAL_FEE;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Gardening:" + super.toString();
  }
}

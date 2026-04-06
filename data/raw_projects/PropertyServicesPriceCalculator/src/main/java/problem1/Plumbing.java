package problem1;
/**
 * This is a Plumbing class which is the subclass of the Specialist.
 * Represent the Specialist Plumbing Service.
 */
public class Plumbing extends Specialist{
  private final static double  PERMITTING_FEE = 20.0;

  /**
   * Constructor for the Plumbing with propertyAddress,
   * propertySize, carriedOutMonthly, numberOfLicensed and isComplex
   * @param propertyAddress   - the property address, represented as a String
   * @param propertySize      - the property size, represented as an enum
   * @param carriedOutMonthly - whether the service is carried out monthly, represented as boolean
   * @param numberOfServices  - The number of services previously carried out at the address,
   *                          represented as an Integer
   * @param numberOfLicensed  - the number of licensed workers, represented as Integer
   * @param isComplex         - whether the service is complex, represented as boolean
   * @throws InvalidNumberOfLicensedException when number of licensed workers out of range
   */
  public Plumbing(String propertyAddress, PropertySize propertySize, boolean carriedOutMonthly,
      int numberOfServices, int numberOfLicensed, boolean isComplex)
      throws InvalidNumberOfLicensedException {
    super(propertyAddress, propertySize, carriedOutMonthly, numberOfServices, numberOfLicensed,
        isComplex);
  }

  /**
   * Calculate the Extra Fee, a permitting fee of $20
   *
   * @return the calculated additional fee, double
   */
  @Override
  public double calculateAdditionalFee() {
    return PERMITTING_FEE;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Plumbing:" + super.toString();
  }
}

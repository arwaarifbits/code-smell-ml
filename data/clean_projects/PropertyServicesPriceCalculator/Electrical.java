package problem1;

/**
 * This is a Electrical class which is the subclass of the Specialist. Represent the Specialist
 * Electrical Service.
 */
public class Electrical extends Specialist {

  private final static double PERMITTING_FEE = 50.0;
  private final static Integer MAX_LICENSED = 4;

  /**
   * Constructor for the Electrical with propertyAddress, propertySize, carriedOutMonthly,
   * numberOfLicensed and isComplex
   *
   * @param propertyAddress   - the property address, represented as a String
   * @param propertySize      - the property size, represented as an enum
   * @param carriedOutMonthly - whether the service is carried out monthly, represented as boolean
   * @param numberOfServices  - The number of services previously carried out at the address,
   *                          represented as an Integer
   * @param numberOfLicensed  - the number of licensed workers, represented as Integer
   * @param isComplex         - whether the service is complex, represented as boolean
   * @throws InvalidNumberOfLicensedException when number of licensed workers out of range
   */
  public Electrical(String propertyAddress, PropertySize propertySize, boolean carriedOutMonthly,
      int numberOfServices, int numberOfLicensed, boolean isComplex)
      throws InvalidNumberOfLicensedException {
    super(propertyAddress, propertySize, carriedOutMonthly, numberOfServices, numberOfLicensed,
        isComplex);
  }

  /**
   * Calculate the Extra Fee, a permitting fee of $50
   *
   * @return the calculated additional fee, double
   */
  @Override
  public double calculateAdditionalFee() {
    return PERMITTING_FEE;
  }

  /**
   * Check whether the number of licensed worker is valid, cannot exceed the maximum number of
   * licensed employees.
   *
   * @param numberOfLicensed - the number of licensed worker
   * @return the valid licensed worker
   * @throws InvalidNumberOfLicensedException when number of licensed worker out of range
   */
  @Override
  protected Integer isValidLicensed(int numberOfLicensed) throws InvalidNumberOfLicensedException {
    if (numberOfLicensed > MAX_LICENSED) {
      throw new InvalidNumberOfLicensedException("Exceeds maximum number of 4 licensed employees!");
    }
    return super.isValidLicensed(numberOfLicensed);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Electrical:" + super.toString();
  }
}

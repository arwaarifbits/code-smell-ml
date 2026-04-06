package problem1;

/**
 * This is an abstract class Exterior which is the subclass of the AbstractService. Represent the
 * Exterior Service.
 */
public abstract class Exterior extends AbstractService {

  private final static Integer SMALL_HOUR = 1;
  private final static Integer MEDIUM_HOUR = 2;
  private final static Integer LARGE_HOUR = 4;
  private final static Integer BASE = 80;

  /**
   * Constructor for Exterior with propertyAddress, propertySize, carriedOutMonthly and
   * numberOfServices
   *
   * @param propertyAddress   - the property address, represented as a String
   * @param propertySize      - the property size, represented as an enum
   * @param carriedOutMonthly - whether the service is carried out monthly, represented as boolean
   * @param numberOfServices  - The number of services previously carried out at the address,
   *                          represented as an Integer
   */
  public Exterior(String propertyAddress, PropertySize propertySize, boolean carriedOutMonthly,
      int numberOfServices) {
    super(propertyAddress, propertySize, carriedOutMonthly, numberOfServices);
  }

  /**
   * Calculate the base fee for exterior service based on the base price per hour and total hours
   * The number of hours needed to complete the job is estimated as 1 hour for small properties, 2
   * hours for medium properties, and 4 hours for large properties
   *
   * @return calculated base fee, double
   */
  @Override
  public double calculateBaseFee() {
    if (this.getPropertySize() == PropertySize.SMALL) {
      return SMALL_HOUR * BASE;
    } else if (this.getPropertySize() == PropertySize.MEDIUM) {
      return MEDIUM_HOUR * BASE;
    }
    return LARGE_HOUR * BASE;
  }

}

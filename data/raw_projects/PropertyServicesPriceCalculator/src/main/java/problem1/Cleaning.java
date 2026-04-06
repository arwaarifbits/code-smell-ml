package problem1;
/**
 * This is a Cleaning class which is the subclass of the Interior.
 * Represent the Interior Cleaning Service.
 */
public class Cleaning extends Interior {
  private static final Integer BASE = 80;
  private static final Integer SMALL_HOUR = 1;
  private static final Integer MEDIUM_HOUR = 2;
  private static final Integer LARGE_HOUR = 4;

  /**
   * Constructor for Cleaning with propertyAddress, propertySize, carriedOutMonthly
   * numberOfServices and numberOfPets
   * @param propertyAddress - the property address, represented as a String
   * @param propertySize - the property size, represented as an enum
   * @param carriedOutMonthly - whether the service is carried out monthly, represented as boolean
   * @param numberOfServices - The number of services previously carried out at the address,
   *                         represented as an Integer
   * @param numberOfPets - The number of pets the property owns, represent as Integer
   */
  public Cleaning(String propertyAddress, PropertySize propertySize, boolean carriedOutMonthly,
      int numberOfServices, int numberOfPets) {
    super(propertyAddress, propertySize, carriedOutMonthly, numberOfServices, numberOfPets);
  }

  /**
   * Calculate the base fee for interior cleaning service with base fee per hour and total hours The
   * number of hours needed to complete the service is estimated as 1 hour for small properties, 2
   * hours for medium properties, and 4 hours for large properties.
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

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Cleaning:" + super.toString();
  }
}

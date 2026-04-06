package problem1;

/**
 * This is a Painting class which is the subclass of the Interior. Represent the Interior Painting
 * Service.
 */
public class Painting extends Interior {

  private static final Integer BASE = 80;
  private static final Integer LARGE_HOUR = 24;
  private static final Integer SMALL_MEDIUM_HOUR = 16;

  /**
   * Constructor for Painting with propertyAddress, propertySize, carriedOutMonthly numberOfServices
   * and numberOfPets
   *
   * @param propertyAddress   - the property address, represented as a String
   * @param propertySize      - the property size, represented as an enum
   * @param carriedOutMonthly - whether the service is carried out monthly, represented as boolean
   * @param numberOfServices  - The number of services previously carried out at the address,
   *                          represented as an Integer
   * @param numberOfPets      - The number of pets the property owns, represent as Integer
   */
  public Painting(String propertyAddress, PropertySize propertySize, boolean carriedOutMonthly,
      int numberOfServices, int numberOfPets) {
    super(propertyAddress, propertySize, carriedOutMonthly, numberOfServices, numberOfPets);
  }

  /**
   * Calculate the base fee for interior painting service with base fee per hour and total hours The
   * time needed to complete the service is 16 hours for small and medium-sized properties, and 24
   * hours for large properties.
   *
   * @return calculated base fee, double
   */
  @Override
  public double calculateBaseFee() {
    if (this.getPropertySize() == PropertySize.SMALL || getPropertySize() == PropertySize.MEDIUM) {
      return SMALL_MEDIUM_HOUR * BASE;
    }
    return LARGE_HOUR * BASE;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Painting:" + super.toString();
  }
}



package problem1;

import java.util.Objects;

/**
 * This is an abstract class Interior which is the subclass of the AbstractService with additional
 * field numberOfPets. Represent the Interior Service.
 */
public abstract class Interior extends AbstractService {

  private Integer numberOfPets;
  private static final Double EXTRA_RATE_SMALL = 0.05;
  private static final Double EXTRA_RATE_LARGE = 0.07;
  private static final Integer EXTRA_FEE_THRESHOLD = 1;
  private static final Integer EXTRA_FEE_LARGE_THRESHOLD = 2;

  /**
   * Constructor for Interior with propertyAddress, propertySize, carriedOutMonthly numberOfServices
   * and numberOfPets
   *
   * @param propertyAddress   - the property address, represented as a String
   * @param propertySize      - the property size, represented as an enum
   * @param carriedOutMonthly - whether the service is carried out monthly, represented as boolean
   * @param numberOfServices  - The number of services previously carried out at the address,
   *                          represented as an Integer
   * @param numberOfPets      - The number of pets the property owns, represent as Integer
   */
  public Interior(String propertyAddress, PropertySize propertySize, boolean carriedOutMonthly,
      int numberOfServices, int numberOfPets) {
    super(propertyAddress, propertySize, carriedOutMonthly, numberOfServices);
    this.numberOfPets = numberOfPets;
  }

  /**
   * Return the number of the pets the property owns
   *
   * @return numberOfPets, integer
   */
  public Integer getNumberOfPets() {
    return numberOfPets;
  }

  /**
   * Calculate the additional fee for interior service based on number of pets. A 5% fee is added to
   * the price if the property has 1 or 2 pets. A 7% fee is added for 3 or more pets.
   *
   * @return the two decimal rounded additional fee, double
   */
  @Override
  public double calculateAdditionalFee() {
    if (this.numberOfPets == EXTRA_FEE_THRESHOLD
        || this.numberOfPets == EXTRA_FEE_LARGE_THRESHOLD) {
      return Math.round((EXTRA_RATE_SMALL * this.calculateBaseFee()) * 100.0) / 100.0;
    } else if (this.numberOfPets > EXTRA_FEE_LARGE_THRESHOLD) {
      return Math.round((EXTRA_RATE_LARGE * this.calculateBaseFee()) * 100.0) / 100.0;
    }
    return 0;
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
    Interior interior = (Interior) o;
    return numberOfPets.equals(interior.numberOfPets);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numberOfPets);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return super.toString() +
        "numberOfPets=" + numberOfPets;
  }
}

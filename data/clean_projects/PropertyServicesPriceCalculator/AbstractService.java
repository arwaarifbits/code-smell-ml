package problem1;

import java.util.Objects;

/**
 * This is an abstract class for Service with propertyAddress, propertySize, carriedOutMonthly and
 * numberOfServices
 */
public abstract class AbstractService implements ServicePriceCalculation {

  private String propertyAddress;
  private PropertySize propertySize;
  private boolean carriedOutMonthly;
  private int numberOfServices;
  private static final Integer NINE_PAST_SERVICE = 9;
  private static final Double TENTH_SERVICE_DISCOUNT = 0.5;
  private static final Double MONTHLY_DISCOUNT = 0.1;

  /**
   * Constructor for AbstractService with propertyAddress, propertySize, carriedOutMonthly and
   * numberOfServices
   *
   * @param propertyAddress   - the property address, represented as a String
   * @param propertySize      - the property size, represented as an enum
   * @param carriedOutMonthly - whether the service is carried out monthly, represented as boolean
   * @param numberOfServices  - The number of services previously carried out at the address,
   *                          represented as an Integer
   */
  public AbstractService(String propertyAddress, PropertySize propertySize,
      boolean carriedOutMonthly,
      int numberOfServices) {
    this.propertyAddress = propertyAddress;
    this.propertySize = propertySize;
    this.carriedOutMonthly = carriedOutMonthly;
    this.numberOfServices = numberOfServices;
  }

  /**
   * Return the property address
   *
   * @return the propertyAddress, String
   */
  public String getPropertyAddress() {
    return this.propertyAddress;
  }

  /**
   * Return the property size
   *
   * @return the propertySize, enum
   */
  public PropertySize getPropertySize() {
    return this.propertySize;
  }

  /**
   * Return whether the service is carried out monthly
   *
   * @return carriedOutMonthly, boolean
   */
  public boolean isCarriedOutMonthly() {
    return this.carriedOutMonthly;
  }

  /**
   * Return the number of services previously carried out
   *
   * @return the numberOfServices, integer
   */
  public int getNumberOfServices() {
    return this.numberOfServices;
  }

  /**
   * Calculate the final price which equals to base plus extra minus discount
   *
   * @return the two decimal rounded final price, double
   */
  @Override
  public double calculatePrice() {
    return Math.round(
        (this.calculateBaseFee() + this.calculateAdditionalFee() - this.calculateDiscountFee())
            * 100.0) / 100.0;
  }

  /**
   * Calculate the DiscountFee. 50% discount for every 10th service. 10% discount for monthly
   * services. If the service is eligible for both discounts apply the 10th service discount and not
   * the monthly discount.
   *
   * @return the two decimal rounded discount fee, double
   */
  @Override
  public double calculateDiscountFee() {
    if (this.getNumberOfServices() % 10 == NINE_PAST_SERVICE) {
      return Math.round(
          ((this.calculateBaseFee() + this.calculateAdditionalFee()) * TENTH_SERVICE_DISCOUNT)
              * 100.0) / 100.0;
    } else if (this.isCarriedOutMonthly()) {
      return Math.round(
          ((this.calculateBaseFee() + this.calculateAdditionalFee()) * MONTHLY_DISCOUNT) * 100.0)
          / 100.0;
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
    AbstractService that = (AbstractService) o;
    return carriedOutMonthly == that.carriedOutMonthly && numberOfServices == that.numberOfServices
        && propertyAddress.equals(that.propertyAddress) && propertySize == that.propertySize;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(propertyAddress, propertySize, carriedOutMonthly, numberOfServices);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "propertyAddress='" + propertyAddress + '\'' +
        ", propertySize=" + propertySize +
        ", carriedOutMonthly=" + carriedOutMonthly +
        ", numberOfServices=" + numberOfServices;
  }
}

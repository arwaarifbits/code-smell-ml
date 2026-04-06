package problem1;

/**
 * This is an interface for service price calculation
 */
public interface ServicePriceCalculation {

  /**
   * Calculate the final total price for the service
   *
   * @return calculated final total price, double
   */
  double calculatePrice();

  /**
   * Calculate the base fee for the service
   *
   * @return calculated base fee, double
   */
  double calculateBaseFee();

  /**
   * Calculate the additional (extra) fee
   *
   * @return calculated extra fee, double
   */
  double calculateAdditionalFee();

  /**
   * Calculate the discount fee
   *
   * @return calculated discount fee, double
   */
  double calculateDiscountFee();
}

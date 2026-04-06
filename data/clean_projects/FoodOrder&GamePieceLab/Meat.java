package problem1;

import java.time.LocalDateTime;
/**
 * Represent Meat, is a subclass of Perishable Food.
 */
public class Meat extends PerishableFood{

  /**
   * Constructor for the meat object.
   *
   * @param name              - The name of the meat, String.
   * @param pricePerUnit      - Current price per unit, represented as a Double.
   * @param availableQuantity - Currently available quantity, represented as an Integer.
   * @param orderDate         - Order date, encoded as a LocalDateTime object.
   * @param expirationDate    - Expiration date, also encoded as a LocalDateTime object.
   * @throws IncorrectQuantityException if quantity larger than 100 or smaller than 0.
   */
  public Meat(String name, Double pricePerUnit, Integer availableQuantity,
      LocalDateTime orderDate, LocalDateTime expirationDate)
      throws IncorrectQuantityException {
    super(name, pricePerUnit, availableQuantity, orderDate, expirationDate);
  }
}

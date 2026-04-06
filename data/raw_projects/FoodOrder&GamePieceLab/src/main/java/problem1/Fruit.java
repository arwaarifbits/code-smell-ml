package problem1;

import java.time.LocalDateTime;

/**
 * Represent Fruit, is a subclass of Perishable Food
 */
public class Fruit extends PerishableFood{

  /**
   * Constructor for the fruit object.
   *
   * @param name              - The name of the fruit, String.
   * @param pricePerUnit      - Current price per unit, represented as a Double.
   * @param availableQuantity - Currently available quantity, represented as an Integer.
   * @param orderDate         - Order date, encoded as a LocalDateTime object.
   * @param expirationDate    - Expiration date, also encoded as a LocalDateTime object.
   * @throws IncorrectQuantityException if quantity larger than 100 or smaller than 0.
   */
  public Fruit(String name, Double pricePerUnit, Integer availableQuantity,
      LocalDateTime orderDate, LocalDateTime expirationDate) throws IncorrectQuantityException {
    super(name, pricePerUnit, availableQuantity, orderDate, expirationDate);
  }
}

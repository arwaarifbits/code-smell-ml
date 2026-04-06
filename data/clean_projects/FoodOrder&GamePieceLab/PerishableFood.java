package problem1;

import java.time.LocalDateTime;
import java.util.Objects;
/**
 * Represent Perishable Food, is a subclass of FoodItem.
 */
public class PerishableFood extends FoodItem{
  private static final Integer MAX = 100;
  private LocalDateTime orderDate;
  private LocalDateTime expirationDate;
  /**
   * Constructor for the Perishable Food Object.
   *
   * @param name               - The name of the perishable food, String.
   * @param pricePerUnit       - Current price per unit, represented as a Double.
   * @param availableQuantity  - Currently available quantity, represented as an Integer.
   * @param orderDate - Order date, encoded as a LocalDateTime object.
   * @param expirationDate - Expiration date, also encoded as a LocalDateTime object.
   * @throws IncorrectQuantityException if quantity larger than 100 or smaller than 0.
   */
  public PerishableFood(String name, Double pricePerUnit, Integer availableQuantity,
      LocalDateTime orderDate, LocalDateTime expirationDate)
      throws IncorrectQuantityException {
    super(name, pricePerUnit, availableQuantity, MAX);
    this.orderDate = orderDate;
    this.expirationDate = expirationDate;
  }

  /**
   * Returns the Order date, encoded as a LocalDateTime object.
   *
   * @return the Order date, encoded as a LocalDateTime object.
   */
  public LocalDateTime getOrderDate() {
    return this.orderDate;
  }

  /**
   * Returns the Expiration date, encoded as a LocalDateTime object.
   *
   * @return the Expiration date, encoded as a LocalDateTime object.
   */
  public LocalDateTime getExpirationDate() {
    return this.expirationDate;
  }

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
    PerishableFood that = (PerishableFood) o;
    return orderDate.equals(that.orderDate) && expirationDate.equals(that.expirationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), orderDate, expirationDate);
  }

  @Override
  public String toString() {
    return "PerishableFood{" +
        "orderDate=" + orderDate +
        ", expirationDate=" + expirationDate +
        '}';
  }
}

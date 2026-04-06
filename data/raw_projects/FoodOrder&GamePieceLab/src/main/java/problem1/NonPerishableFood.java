package problem1;
/**
 * Represent NonPerishable Food, is a subclass of FoodItem.
 */
public class NonPerishableFood extends FoodItem {

  private final static Integer MAX = 250;

  /**
   * Constructor for the NonPerishableFood class.
   *
   * @param name              - The name of the NonPerishableFood, String.
   * @param pricePerUnit      - Current price per unit, represented as a Double.
   * @param availableQuantity - Currently available quantity, represented as an Integer.
   * @throws IncorrectQuantityException if the quantity is smaller than 0 or larger than maximum
   *                                    allowed quantity
   */
  public NonPerishableFood(String name, Double pricePerUnit, Integer availableQuantity)
      throws IncorrectQuantityException {
    super(name, pricePerUnit, availableQuantity, MAX);
  }
}

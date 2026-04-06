package problem1;
/**
 * Represent Rice, is a subclass of NonPerishable Food.
 */
public class Rice extends NonPerishableFood{

  /**
   * Constructor for the Rice object.
   *
   * @param name              - The name of the rice, String.
   * @param pricePerUnit      - Current price per unit, represented as a Double.
   * @param availableQuantity - Currently available quantity, represented as an Integer.
   * @throws IncorrectQuantityException if the quantity is smaller than 0 or larger than maximum
   *                                    allowed quantity
   */
  public Rice(String name, Double pricePerUnit, Integer availableQuantity)
      throws IncorrectQuantityException {
    super(name, pricePerUnit, availableQuantity);
  }
}

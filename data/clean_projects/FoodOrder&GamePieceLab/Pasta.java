package problem1;
/**
 * Represent Pasta, is a subclass of NonPerishable Food.
 */
public class Pasta extends NonPerishableFood{

  /**
   * Constructor for the pasta object.
   *
   * @param name              - The name of the pasta, String.
   * @param pricePerUnit      - Current price per unit, represented as a Double.
   * @param availableQuantity - Currently available quantity, represented as an Integer.
   * @throws IncorrectQuantityException if the quantity is smaller than 0 or larger than maximum
   *                                    allowed quantity
   */
  public Pasta(String name, Double pricePerUnit, Integer availableQuantity)
      throws IncorrectQuantityException {
    super(name, pricePerUnit, availableQuantity);
  }
}

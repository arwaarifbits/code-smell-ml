package problem1;

import java.util.Objects;

/**
 * This is an abstract class for foodItems with specific info including name, pricePerUnit,
 * availableQuantity, maxAllowedQuantity
 */

public abstract class FoodItem implements FoodOrderingSystem {

  private String name;
  private Double pricePerUnit;
  private Integer availableQuantity;
  private final Integer maxAllowedQuantity;

  /**
   * Constructor for the FoodItem class. This is an abstract class.
   *
   * @param name               - The name of the foodItem, String.
   * @param pricePerUnit       - Current price per unit, represented as a Double.
   * @param availableQuantity  - Currently available quantity, represented as an Integer.
   * @param maxAllowedQuantity - Maximum allowed quantity, which is a constant represented as an
   *                           Integer.
   * @throws IncorrectQuantityException if the quantity is smaller than 0 or larger than maximum
   *                                    allowed quantity
   */
  public FoodItem(String name, Double pricePerUnit, Integer availableQuantity,
      Integer maxAllowedQuantity) throws IncorrectQuantityException {
    this.name = name;
    this.pricePerUnit = pricePerUnit;
    this.maxAllowedQuantity = maxAllowedQuantity;
    this.isValidQuantity(availableQuantity);
    this.availableQuantity = availableQuantity;
  }

  /**
   * Checks whether the quantity is valid
   *
   * @param quantity The quantity to store, integer
   * @throws IncorrectQuantityException if the quantity is smaller than 0 or larger than maximum
   *                                    allowed quantity
   */
  private void isValidQuantity(Integer quantity) throws IncorrectQuantityException {
    if (quantity > this.maxAllowedQuantity) {
      throw new IncorrectQuantityException("Quantity larger than the Maximum allowed quantity!");
    } else if (quantity < 0) {
      throw new IncorrectQuantityException("Quantity should not be negative!");
    }
  }

  /**
   * Returns the name of the FoodItem.
   *
   * @return the name of the FoodItem. String.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Returns the Current price per unit of the FoodItem.
   *
   * @return the Current price per unit of the FoodItem. Double.
   */
  public Double getPricePerUnit() {
    return this.pricePerUnit;
  }

  /**
   * Returns the Currently available quantity of the FoodItem.
   *
   * @return the Currently available quantity of the FoodItem. Integer.
   */
  public Integer getAvailableQuantity() {
    return this.availableQuantity;
  }

  /**
   * Returns the Maximum allowed quantity of the FoodItem.
   *
   * @return the Maximum allowed quantity of the FoodItem. Integer.
   */
  public Integer getMaxAllowedQuantity() {
    return this.maxAllowedQuantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FoodItem foodItem = (FoodItem) o;
    return name.equals(foodItem.name) && pricePerUnit.equals(foodItem.pricePerUnit)
        && availableQuantity.equals(foodItem.availableQuantity) && maxAllowedQuantity.equals(
        foodItem.maxAllowedQuantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, pricePerUnit, availableQuantity, maxAllowedQuantity);
  }

  @Override
  public String toString() {
    return "FoodItem{" +
        "name='" + name + '\'' +
        ", pricePerUnit=" + pricePerUnit +
        ", availableQuantity=" + availableQuantity +
        ", maxAllowedQuantity=" + maxAllowedQuantity +
        '}';
  }
}

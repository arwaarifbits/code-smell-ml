package assignment2.problem1;
/**
 * This is a FamilyRoom class which is a subclass of Room. It represents family room with a maximum
 * occupancy, a price, a number of guests.
 */
public class FamilyRoom extends Room {
  private static final Integer FAMILY_MAX = 4;
  /**
   * Constructor for family room object with specific maximum occupancy 4 and price.
   *
   * @param price        - price, double
   * @throws InvalidPriceException if the price is less than or equal 0
   */
  public FamilyRoom(Double price) throws InvalidPriceException {
    super(FAMILY_MAX, price);
  }
}

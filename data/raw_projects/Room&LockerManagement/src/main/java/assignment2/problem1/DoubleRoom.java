package assignment2.problem1;
/**
 * This is a DoubleRoom class which is a subclass of Room. It represents double room with a maximum
 * occupancy, a price, a number of guests.
 */
public class DoubleRoom extends Room{
  private static final Integer DOUBLE_MAX = 2;
  /**
   * Constructor for double room object with specific maximum occupancy 2 and price.
   *
   * @param price        - price, double
   * @throws InvalidPriceException if the price is less than or equal 0
   */
  public DoubleRoom(Double price) throws InvalidPriceException {
    super(DOUBLE_MAX, price);
  }
}

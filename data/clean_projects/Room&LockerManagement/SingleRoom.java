package assignment2.problem1;

/**
 * This is a SingleRoom class which is a subclass of Room. It represents single room with a maximum
 * occupancy, a price, a number of guests.
 */
public class SingleRoom extends Room{
  private static final Integer SINGLE_MAX = 1;
  /**
   * Constructor for single room object with specific maximum occupancy 1 and price.
   *
   * @param price        - price, double
   * @throws InvalidPriceException if the price is less than or equal 0
   */
  public SingleRoom(Double price) throws InvalidPriceException {
    super(SINGLE_MAX, price);
  }
}

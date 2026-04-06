package assignment2.problem1;

import java.util.Objects;

/**
 * This is a Room class which is a master class. It represents room with a maximum occupancy, a
 * price, a number of guests.
 */
public class Room {

  private Integer maxOccupancy;
  private Double price;
  private Integer guestNumber;
  private static final Integer FREE = 0;

  /**
   * Constructor for room object with specific maximum occupancy, price and number of guests. When
   * the room is first created in the system, the number of guests should be 0.
   *
   * @param maxOccupancy - maximum occupancy, integer
   * @param price        - price, double
   * @throws InvalidPriceException if the price is less than or equal 0
   */
  public Room(Integer maxOccupancy, Double price)
      throws InvalidPriceException {
    this.maxOccupancy = maxOccupancy;
    this.isValidPrice(price);
    this.price = price;
    this.guestNumber = FREE;
  }

  /**
   * Check if the room is available or not. The room is considered available if the number of guests
   * is 0. If there are 1 or more guests, the room is not available.
   *
   * @return true if number of guests is 0 otherwise return false
   */
  public boolean isAvailable() {
    if (this.guestNumber == 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Check whether the number of guests that would like to stay in the room is valid
   *
   * @param guests - the number of guests that would like to stay in the room, integer
   * @throws InvalidGuestNumberException if the number of guests out of range
   */
  private void isValidGuest(int guests) throws InvalidGuestNumberException {
    if (guests < 0) {
      throw new InvalidGuestNumberException("Guests number should not be negative!");
    } else if (guests > this.maxOccupancy) {
      throw new InvalidGuestNumberException("Guest number should not larger than max occupancy!");
    }
  }

  /**
   * Check whether the price is valid
   *
   * @param price - the price of the room, double
   * @throws InvalidPriceException when the price is less than or equal 0
   */
  private void isValidPrice(double price) throws InvalidPriceException {
    if (price <= 0) {
      throw new InvalidPriceException("Price should larger than 0!");
    }
  }

  /**
   * Check whether the room is free
   *
   * @throws InvalidRoomException when the room is not free
   */
  private void isFree() throws InvalidRoomException {
    if (!this.isAvailable()) {
      throw new InvalidRoomException("The room is not free!");
    }
  }

  /**
   * To set the room's number of guest if the room is free and the number of guest
   * is valid
   *
   * @param guests - the number of guests that would like to stay in the room, integer
   * @throws InvalidRoomException        when the room is not free
   * @throws InvalidGuestNumberException if the number of guests out of range
   */
  public void bookRoom(int guests) throws InvalidRoomException, InvalidGuestNumberException {
    this.isFree();
    this.isValidGuest(guests);
    this.guestNumber = guests;
  }

  /**
   * Returns the max occupancy of the room.
   *
   * @return the max occupancy of the room. Integer.
   */
  public Integer getMaxOccupancy() {
    return this.maxOccupancy;
  }

  /**
   * Returns the price of the room.
   *
   * @return the price of the room. Double.
   */
  public Double getPrice() {
    return this.price;
  }

  /**
   * Returns the guest number of the room.
   *
   * @return the guest number of the room. integer.
   */
  public Integer getGuestNumber() {
    return this.guestNumber;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Room room = (Room) o;
    return maxOccupancy.equals(room.maxOccupancy) && price.equals(room.price) && guestNumber.equals(
        room.guestNumber);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(maxOccupancy, price, guestNumber);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Room{" +
        "maxOccupancy=" + maxOccupancy +
        ", price=" + price +
        ", guestNumber=" + guestNumber +
        '}';
  }
}

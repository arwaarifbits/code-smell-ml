package assignment2.problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RoomTest {

  private Room roomTest;
  private Room roomCopy;
  private Room imposterRoom;
  private Room invalidPrice;
  private Room roomTestTwo;

  @BeforeEach
  void setUp() throws InvalidPriceException {
    roomTest = new Room(2, 200.00);
    roomCopy = new Room(2, 200.00);
    imposterRoom = new Room(2, 200.00);
    roomTestTwo = new Room(4, 600.00);
  }

  @Test
  void negativePrice() throws InvalidPriceException {
    assertThrows(InvalidPriceException.class, () -> invalidPrice = new Room(2, -100.00));
  }

  @Test
  void tooManyGuest() throws InvalidGuestNumberException {
    assertThrows(InvalidGuestNumberException.class, () -> roomTest.bookRoom(1000));
  }

  @Test
  void negativeGuest() throws InvalidGuestNumberException {
    assertThrows(InvalidGuestNumberException.class, () -> roomTest.bookRoom(-2));
  }

  @Test
  void isAvailable() throws InvalidRoomException, InvalidGuestNumberException {
    assertTrue(roomTest.isAvailable());
    roomTest.bookRoom(1);
    assertFalse(roomTest.isAvailable());
  }

  @Test
  void isFree() throws InvalidRoomException, InvalidGuestNumberException {
    roomTest.bookRoom(2);
    assertThrows(InvalidRoomException.class, () -> roomTest.bookRoom(1));
  }

  @Test
  void bookRoom() throws InvalidRoomException, InvalidGuestNumberException {
    roomTest.bookRoom(2);
    assertEquals(2, roomTest.getGuestNumber());
  }

  @Test
  void getMaxOccupancy() {
    assertEquals(2, roomTest.getMaxOccupancy());
  }

  @Test
  void getPrice() {
    assertEquals(200.00, roomTest.getPrice());
  }

  @Test
  void getGuestNumber() {
    assertEquals(0, roomTest.getGuestNumber());
  }

  @Test
  void testEquals() {
    assertTrue(roomTest.equals(roomTest) == roomTest.equals(roomTest));
    //test symmetry
    assertTrue(roomTest.equals(roomCopy) == roomCopy.equals(roomTest));
    //test transitivity
    assertTrue(roomTest.equals(roomCopy) && roomCopy.equals(imposterRoom)
        && roomTest.equals(imposterRoom));
    //test null reference
    assertFalse(roomTest.equals(null));
    //test consistency
    assertTrue(roomTest.equals(roomCopy));
    assertTrue(roomTest.equals(roomCopy));
    //test equals where equal should be false
    assertFalse(roomTestTwo.equals(roomTest));
  }

  @Test
  void testHashCode() {
    //test null
    assertFalse(0 == roomTest.hashCode());
    //test consistency
    int testHashCode = roomTest.hashCode();
    assertEquals(testHashCode, roomTest.hashCode());

  }

  @Test
  void testToString() {
    String expected = "Room{" +
        "maxOccupancy=" + "2" +
        ", price=" + "200.0" +
        ", guestNumber=" + "0" +
        '}';
    assertEquals(expected, roomTest.toString());
  }
}
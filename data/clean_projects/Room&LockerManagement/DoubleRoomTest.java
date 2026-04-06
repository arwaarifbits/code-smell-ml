package assignment2.problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DoubleRoomTest {

  private DoubleRoom doubleRoom;

  @BeforeEach
  void setUp() throws InvalidPriceException {
    doubleRoom = new DoubleRoom(288.88);
  }


  @Test
  void getPrice() {
    assertEquals(288.88, doubleRoom.getPrice());
  }

  @Test
  void getMaxOccupancy() {
    assertEquals(2, doubleRoom.getMaxOccupancy());
  }
}
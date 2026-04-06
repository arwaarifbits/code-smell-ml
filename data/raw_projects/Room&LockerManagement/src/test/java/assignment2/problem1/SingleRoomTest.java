package assignment2.problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SingleRoomTest {

  private SingleRoom singleRoom;

  @BeforeEach
  void setUp() throws InvalidPriceException {
    singleRoom = new SingleRoom(150.5);
  }

  @Test
  void getPrice() {
    assertEquals(150.5, singleRoom.getPrice());
  }

  @Test
  void getMaxOccupancy() {
    assertEquals(1, singleRoom.getMaxOccupancy());
  }
}
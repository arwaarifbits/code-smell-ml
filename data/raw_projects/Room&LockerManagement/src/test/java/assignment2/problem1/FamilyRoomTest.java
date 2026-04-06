package assignment2.problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FamilyRoomTest {

  private FamilyRoom familyRoom;

  @BeforeEach
  void setUp() throws InvalidPriceException {
    familyRoom = new FamilyRoom(600.00);
  }

  @Test
  void getPrice() {
    assertEquals(600.00, familyRoom.getPrice());
  }

  @Test
  void getMaxOccupancy() {
    assertEquals(4, familyRoom.getMaxOccupancy());
  }
}
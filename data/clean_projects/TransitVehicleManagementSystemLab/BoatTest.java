package Problem1AndProblem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoatTest {

  private Boat boat;

  @BeforeEach
  void setUp() {
    boat = new Boat("123", 1F, 3F);
  }

  @Test
  void testGetId() {
    assertEquals("123", boat.getiD());
  }

  @Test
  void testGetAvgSpeed() {
    assertEquals(1F, boat.getAvgSpeed());
  }

  @Test
  void testGetMaxSpeed() {
    assertEquals(3F, boat.getMaxSpeed());
  }

  @Test
  void testToString() {
    String expected = "Boat:" + "iD='" + "123" + '\'' +
        ", avgSpeed=" + "1.0" +
        ", maxSpeed=" + "3.0";
    assertEquals(expected, boat.toString());
  }
}
package Problem1AndProblem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BusTest {

  private Bus bus;
  private Bus busCopy;
  private Bus busImposter;
  private Bus busTwo;

  @BeforeEach
  void setUp() {
    bus = new Bus("1212", 9F, 12F);
    busCopy = new Bus("1212", 9F, 12F);
    busImposter = new Bus("1212", 9F, 12F);
    busTwo = new Bus("1234", 9F, 11F);
  }

  @Test
  void testGetId() {
    assertEquals("1212", bus.getiD());
  }

  @Test
  void testGetAvgSpeed() {
    assertEquals(9F, bus.getAvgSpeed());
  }

  @Test
  void testGetMaxSpeed() {
    assertEquals(12F, bus.getMaxSpeed());
  }

  @Test
  void testEquals() {
    assertTrue(bus.equals(bus) == bus.equals(bus));
    //test symmetry
    assertTrue(bus.equals(busCopy) == busCopy.equals(bus));
    //test transitivity
    assertTrue(bus.equals(busCopy) && busCopy.equals(busImposter)
        && bus.equals(busImposter));
    //test null reference
    assertFalse(bus.equals(null));
    //test consistency
    assertTrue(bus.equals(busCopy));
    assertTrue(bus.equals(busCopy));
    //test equals where equal should be false
    assertFalse(busTwo.equals(bus));
  }

  @Test
  void testHashCode() {
    //test null
    assertFalse(0 == bus.hashCode());
    //test consistency
    int testHashCode = bus.hashCode();
    assertEquals(testHashCode, bus.hashCode());

  }

  @Test
  void testToString() {
    String expected = "Bus:" + "iD='" + "1212" + '\'' +
        ", avgSpeed=" + "9.0" +
        ", maxSpeed=" + "12.0";
    assertEquals(expected, bus.toString());
  }
}
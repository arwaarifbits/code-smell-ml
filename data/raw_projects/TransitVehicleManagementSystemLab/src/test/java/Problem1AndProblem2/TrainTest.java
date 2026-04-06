package Problem1AndProblem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrainTest {

  private Train train;

  @BeforeEach
  void setUp() {
    train = new Train("1", 9F, 15F);
  }

  @Test
  void testGetId() {
    assertEquals("1", train.getiD());
  }

  @Test
  void testGetAvgSpeed() {
    assertEquals(9F, train.getAvgSpeed());
  }

  @Test
  void testGetMaxSpeed() {
    assertEquals(15F, train.getMaxSpeed());
  }

  @Test
  void testToString() {
    String expected = "Train:" + "iD='" + "1" + '\'' +
        ", avgSpeed=" + "9.0" +
        ", maxSpeed=" + "15.0";
    assertEquals(expected, train.toString());
  }
}
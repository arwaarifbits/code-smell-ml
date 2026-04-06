package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RunnerTest {

  private Runner testRunner;
  private Name testName;

  @BeforeEach
  void setUp() {
    testName = new Name("Y", "M", "G");
    testRunner = new Runner(testName, 183.0, 80.0, "S", 180.0, 90.0, "speed");
  }

  @Test
  void getBest5KTime() {
    assertEquals(180.0, testRunner.getBest5KTime());
  }

  @Test
  void setBest5KTime() {
    testRunner.setBest5KTime(188.8);
    assertEquals(188.8, testRunner.getBest5KTime());
  }

  @Test
  void getBestHalfMarathonTime() {
    assertEquals(90.0, testRunner.getBestHalfMarathonTime());
  }

  @Test
  void setBestHalfMarathonTime() {
    testRunner.setBestHalfMarathonTime(90.9);
    assertEquals(90.9, testRunner.getBestHalfMarathonTime());
  }

  @Test
  void getFavoriteRunningEvent() {
    assertEquals("speed", testRunner.getFavoriteRunningEvent());
  }

  @Test
  void setFavoriteRunningEvent() {
    testRunner.setFavoriteRunningEvent("slush");
    assertEquals("slush", testRunner.getFavoriteRunningEvent());
  }
}
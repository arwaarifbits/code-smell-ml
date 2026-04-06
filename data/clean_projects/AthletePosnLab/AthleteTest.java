package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AthleteTest {

  private Athlete testAthlete;
  private Name testName;
  private Name testName2;
  private Athlete testWithoutLeague;

  @BeforeEach
  void setUp() {
    testName = new Name("Y", "M", "G");
    testName2 = new Name("G", "G", "G");
    testAthlete = new Athlete(testName, 183.5, 80.0, "S");
    testWithoutLeague = new Athlete(testName2, 183.4, 80.1);
  }

  @Test
  void getAthletesName() {
    assertEquals(testName, testAthlete.getAthletesName());
    assertEquals(testName2, testWithoutLeague.getAthletesName());
  }

  @Test
  void getHeight() {
    assertEquals(183.5, testAthlete.getHeight());
    assertEquals(183.4, testWithoutLeague.getHeight());
  }

  @Test
  void getWeight() {
    assertEquals(80.0, testAthlete.getWeight());
    assertEquals(80.1, testWithoutLeague.getWeight());
  }

  @Test
  void getLeague() {
    assertEquals("S", testAthlete.getLeague());
    assertEquals(null, testWithoutLeague.getLeague());
  }
}
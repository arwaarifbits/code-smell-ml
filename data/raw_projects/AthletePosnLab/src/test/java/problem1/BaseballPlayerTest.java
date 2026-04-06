package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseballPlayerTest {

  private Name testName;
  private BaseballPlayer testPlayer;

  @BeforeEach
  void setUp() {
    testName = new Name("Y", "M", "G");
    testPlayer = new BaseballPlayer(testName, 180.0, 90.0, "s", "doge", 9.0, 1);
  }

  @Test
  void getTeam() {
    assertEquals("doge", testPlayer.getTeam());
  }

  @Test
  void setTeam() {
    testPlayer.setTeam("bit");
    assertEquals("bit", testPlayer.getTeam());
  }

  @Test
  void getAverageBatting() {
    assertEquals(9.0, testPlayer.getAverageBatting());
  }

  @Test
  void setAverageBatting() {
    testPlayer.setAverageBatting(10.0);
    assertEquals(10.0, testPlayer.getAverageBatting());
  }

  @Test
  void getSeasonHomeRuns() {
    assertEquals(1, testPlayer.getSeasonHomeRuns());
  }

  @Test
  void setSeasonHomeRuns() {
    testPlayer.setSeasonHomeRuns(2);
    assertEquals(2, testPlayer.getSeasonHomeRuns());
  }
}
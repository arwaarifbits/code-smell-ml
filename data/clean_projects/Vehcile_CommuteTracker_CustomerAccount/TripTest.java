package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TripTest {

  private Time startTimeUTC;
  private Time endTimeUTC;
  private Trip japanTrip;

  @BeforeEach
  void setUp() {
    this.startTimeUTC = new Time(40, 40, 6);
    this.endTimeUTC = new Time(50, 50, 16);
    this.japanTrip = new Trip("Seattle", "Tokyo", startTimeUTC, endTimeUTC);
  }

  @Test
  void getStartLocation() {
    Assertions.assertEquals("Seattle", japanTrip.getStartLocation());
  }

  @Test
  void getEndLocation() {
    Assertions.assertEquals("Tokyo", japanTrip.getEndLocation());
  }

  @Test
  void getStartTime() {
    Assertions.assertEquals(40, startTimeUTC.getSeconds());
    Assertions.assertEquals(40, startTimeUTC.getMinutes());
    Assertions.assertEquals(6, startTimeUTC.getHours());
  }

  @Test
  void getEndTime() {
    Assertions.assertEquals(50, endTimeUTC.getSeconds());
    Assertions.assertEquals(50, endTimeUTC.getMinutes());
    Assertions.assertEquals(16, endTimeUTC.getHours());
  }

  @Test
  void getDuration() {
    Assertions.assertEquals(10, japanTrip.getDuration().getSeconds());
    Assertions.assertEquals(10, japanTrip.getDuration().getMinutes());
    Assertions.assertEquals(10, japanTrip.getDuration().getHours());
  }

  @Test
  void setStartLocation() {
    japanTrip.setStartLocation("Honolulu");
    Assertions.assertEquals("Honolulu", japanTrip.getStartLocation());
  }

  @Test
  void setEndLocation() {
    japanTrip.setEndLocation("Kyoto");
    Assertions.assertEquals("Kyoto", japanTrip.getEndLocation());
  }

  @Test
  void setStartTime() {
    japanTrip.setStartTime(5, 6, 7);
    Assertions.assertEquals(7, japanTrip.getStartTime().getSeconds());
    Assertions.assertEquals(6, japanTrip.getStartTime().getMinutes());
    Assertions.assertEquals(5, japanTrip.getStartTime().getHours());
  }

  @Test
  void setEndTime() {
    japanTrip.setEndTime(9, 6, 7);
    Assertions.assertEquals(7, japanTrip.getEndTime().getSeconds());
    Assertions.assertEquals(6, japanTrip.getEndTime().getMinutes());
    Assertions.assertEquals(9, japanTrip.getEndTime().getHours());
  }

}
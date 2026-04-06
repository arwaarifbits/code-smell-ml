package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TimeTest {

  private Time timeUTC;

  @BeforeEach
  void setUp() {
    this.timeUTC = new Time(50, 50, 1);
  }

  @Test
  void getSeconds() {
    Assertions.assertEquals(50, timeUTC.getSeconds());
  }

  @Test
  void getMinutes() {
    Assertions.assertEquals(50, timeUTC.getMinutes());
  }

  @Test
  void getHours() {
    Assertions.assertEquals(1, timeUTC.getHours());
  }

  @Test
  void setSeconds() {
    timeUTC.setSeconds(1);
    Assertions.assertEquals(1, timeUTC.getSeconds());
  }

  @Test
  void setMinutes() {
    timeUTC.setMinutes(10);
    Assertions.assertEquals(10, timeUTC.getMinutes());
  }

  @Test
  void setHours() {
    timeUTC.setHours(10);
    Assertions.assertEquals(10, timeUTC.getHours());
  }
}
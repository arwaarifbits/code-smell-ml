package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OwnerTest {

  private Owner yiming;

  @BeforeEach
  void setUp() {
    this.yiming = new Owner("Yiming", "Ge", "1234567");
  }

  @Test
  void getFirstName() {
    Assertions.assertEquals("Yiming", this.yiming.getFirstName());
  }

  @Test
  void getLastName() {
    Assertions.assertEquals("Ge", this.yiming.getLastName());
  }

  @Test
  void getPhoneNumber() {
    Assertions.assertEquals("1234567", this.yiming.getPhoneNumber());
  }

  @Test
  void setFirstName() {
    yiming.setFirstName("medio");
    assertEquals("medio", yiming.getFirstName());
  }

  @Test
  void setLastName() {
    yiming.setLastName("Yang");
    assertEquals("Yang", yiming.getLastName());
  }

  @Test
  void setPhoneNumber() {
    yiming.setPhoneNumber("23333");
    assertEquals("23333", yiming.getPhoneNumber());
  }
}
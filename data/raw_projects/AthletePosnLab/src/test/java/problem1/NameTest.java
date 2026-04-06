package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NameTest {

  Name name;

  @BeforeEach
  void setUp() {
    name = new Name("Yiming", "Medio", "Ge");
  }

  @Test
  void getFirstName() {
    assertEquals("Yiming", name.getFirstName());
  }

  @Test
  void setFirstName() {
    name.setFirstName("Yg");
    assertEquals("Yg", name.getFirstName());
  }

  @Test
  void getMiddleName() {
    assertEquals("Medio", name.getMiddleName());
  }

  @Test
  void setMiddleName() {
    name.setMiddleName("Mid");
    assertEquals("Mid", name.getMiddleName());
  }

  @Test
  void getLastName() {
    assertEquals("Ge", name.getLastName());
  }

  @Test
  void setLastName() {
    name.setLastName("Gg");
    assertEquals("Gg", name.getLastName());
  }
}
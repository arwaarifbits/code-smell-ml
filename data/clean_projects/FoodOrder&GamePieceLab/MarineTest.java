package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MarineTest {
  private Name name;
  private Marine marineTest;
  @BeforeEach
  void setUp() throws IncorrectAgeException, IncorrectStaminaAmountException {
    name = new Name("Doge","Inu");
    marineTest = new Marine(name, 20, 50.00);
  }
  @Test
  void increase() throws IncorrectStaminaAmountException {
    marineTest.increase(20.00);
    assertEquals(70.00, marineTest.getStamina());
  }

  @Test
  void decrease() throws IncorrectStaminaAmountException {
    marineTest.decrease(20.00);
    assertEquals(30.00, marineTest.getStamina());
  }
}
package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EngineerTest {
  private Name name;
  private Engineer engineerTest;
  @BeforeEach
  void setUp() throws IncorrectAgeException, IncorrectWealthAmountException {
    name = new Name("Doge", "Inu");
    engineerTest = new Engineer(name, 30, 10000.00);
  }
  @Test
  void increase() throws IncorrectWealthAmountException {
    engineerTest.increase(1000.00);
    assertEquals(11000.00, engineerTest.getWealth());
  }

  @Test
  void decrease() throws IncorrectWealthAmountException {
    engineerTest.decrease(1000.00);
    assertEquals(9000.00, engineerTest.getWealth());
  }
}
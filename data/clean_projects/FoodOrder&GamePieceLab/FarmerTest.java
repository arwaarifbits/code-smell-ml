package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FarmerTest {

  private Farmer farmerTest;
  private Farmer farmerTestCopy;
  private Farmer imposterFarmerTest;
  private Farmer farmerTest2;
  private Farmer NegativeWealth;
  private Farmer NegativeAge;
  private Farmer LargeAge;
  private Name name;

  @BeforeEach
  void setUp() throws IncorrectAgeException, IncorrectWealthAmountException {
    name = new Name("Doge", "Inu");
    farmerTest = new Farmer(name, 30, 10000.00);
    farmerTestCopy = new Farmer(name, 30, 10000.00);
    imposterFarmerTest = new Farmer(name, 30, 10000.00);
    farmerTest2 = new Farmer(name, 20, 99999.00);
  }

  @Test
  void negativeWealth() throws IncorrectWealthAmountException {
    assertThrows(IncorrectWealthAmountException.class, () -> {
      NegativeWealth = new Farmer(name, 20, -1000.00);
    });
  }

  @Test
  void negativeAge() throws IncorrectAgeException {
    assertThrows(IncorrectAgeException.class, () -> {
      NegativeAge = new Farmer(name, -100, 1000.00);
    });
  }

  @Test
  void largeAge() throws IncorrectAgeException {
    assertThrows(IncorrectAgeException.class, () -> {
      LargeAge = new Farmer(name, 8000, 1000.00);
    });
  }

  @Test
  void increase() throws IncorrectWealthAmountException {
    farmerTest.increase(1000.00);
    assertEquals(11000.00, farmerTest.getWealth());
  }

  @Test
  void decrease() throws IncorrectWealthAmountException {
    farmerTest.decrease(1000.00);
    assertEquals(9000.00, farmerTest.getWealth());
  }

  @Test
  void invalidDecrease() throws IncorrectWealthAmountException {
    assertThrows(IncorrectWealthAmountException.class, () -> {
      farmerTest.decrease(999999.00);
    });
  }

  @Test
  void testEquals() {
    assertTrue(farmerTest.equals(farmerTest) == farmerTest.equals(farmerTest));
    //test symmetry
    assertTrue(farmerTest.equals(farmerTestCopy) == farmerTestCopy.equals(farmerTest));
    //test transitivity
    assertTrue(farmerTest.equals(farmerTestCopy) && farmerTestCopy.equals(imposterFarmerTest)
        && farmerTest.equals(imposterFarmerTest));
    //test null reference
    assertFalse(farmerTest.equals(null));
    //test consistency
    assertTrue(farmerTest.equals(farmerTestCopy));
    assertTrue(farmerTest.equals(farmerTestCopy));
    //test equals where equal should be false
    assertFalse(farmerTest2.equals(farmerTest));
  }

  @Test
  void testHashCode() {
    //test null
    assertFalse(0 == farmerTest.hashCode());
    //test consistency
    int testHashCode = farmerTest.hashCode();
    assertEquals(testHashCode, farmerTest.hashCode());
  }

  @Test
  void testToString() {
    String expectedName =
        "Civilian{" +
            "wealth=" + "10000.0" +
            '}';
    assertEquals(expectedName, farmerTest.toString());
  }


}

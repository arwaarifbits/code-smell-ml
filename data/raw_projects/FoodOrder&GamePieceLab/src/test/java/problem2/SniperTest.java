package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SniperTest {
  private Sniper sniperTest;
  private Sniper sniperTestCopy;
  private Sniper imposterSniperTest;
  private Sniper largeStamina;
  private Sniper negativeStamina;
  private Sniper sniperTest2;
  private Name name;
  @BeforeEach
  void setUp() throws IncorrectAgeException, IncorrectStaminaAmountException {
    name = new Name("Doge","Inu");
    sniperTest = new Sniper(name, 20, 50.00);
    sniperTestCopy = new Sniper(name, 20, 50.00);
    imposterSniperTest = new Sniper(name, 20, 50.00);
    sniperTest2 = new Sniper(name,22,56.00);
  }

  @Test
  void largeStamina() throws IncorrectStaminaAmountException{
    assertThrows(IncorrectStaminaAmountException.class, () -> {
      largeStamina = new Sniper(name, 25, 1000.00);
    });
  }

  @Test
  void negativeStamina() throws IncorrectStaminaAmountException{
    assertThrows(IncorrectStaminaAmountException.class, () -> {
      negativeStamina = new Sniper(name, 33, -10.00);
    });
  }

  @Test
  void increase() throws IncorrectStaminaAmountException {
    sniperTest.increase(20.00);
    assertEquals(70.00, sniperTest.getStamina());
  }

  @Test
  void decrease() throws IncorrectStaminaAmountException {
    sniperTest.decrease(20.00);
    assertEquals(30.00, sniperTest.getStamina());
  }

  @Test
  void invalidIncrease() throws IncorrectStaminaAmountException{
    assertThrows(IncorrectStaminaAmountException.class, () ->{sniperTest.increase(100.00);});
  }

  @Test
  void invalidDecrease() throws  IncorrectStaminaAmountException{
    assertThrows(IncorrectStaminaAmountException.class, () ->{sniperTest.decrease(100.00);});
  }

  @Test
  void testEquals() {
    assertTrue(sniperTest.equals(sniperTest) == sniperTest.equals(sniperTest));
    //test symmetry
    assertTrue(sniperTest.equals(sniperTestCopy) == sniperTestCopy.equals(sniperTest));
    //test transitivity
    assertTrue(sniperTest.equals(sniperTestCopy) && sniperTestCopy.equals(imposterSniperTest)
        && sniperTest.equals(imposterSniperTest));
    //test null reference
    assertFalse(sniperTest.equals(null));
    //test consistency
    assertTrue(sniperTest.equals(sniperTestCopy));
    assertTrue(sniperTest.equals(sniperTestCopy));
    //test equals where equal should be false
    assertFalse(sniperTest2.equals(sniperTest));
  }

  @Test
  void testHashCode() {
    //test null
    assertFalse(0 == sniperTest.hashCode());
    //test consistency
    int testHashCode = sniperTest.hashCode();
    assertEquals(testHashCode, sniperTest.hashCode());
  }

  @Test
  void testToString() {
    String expectedName =
        "Soldier{" +
            "stamina=" + "50.0" +
            '}';
    assertEquals(expectedName, sniperTest.toString());
  }







}
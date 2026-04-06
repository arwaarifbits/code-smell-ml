package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GardeningTest {
  private Gardening gardeningTestOne;
  private Gardening gardeningCopy;
  private Gardening gardeningImposter;
  private Gardening gardeningTestTwo;

  @BeforeEach
  void setUp() {
    gardeningTestOne = new Gardening("ABC",PropertySize.LARGE,true,8);
    gardeningCopy = new Gardening("ABC",PropertySize.LARGE,true,8);
    gardeningImposter = new Gardening("ABC",PropertySize.LARGE,true,8);
    gardeningTestTwo = new Gardening("CBA",PropertySize.SMALL,true,7);
  }

  @Test
  void calculateBaseFee(){
    assertEquals(320,gardeningTestOne.calculateBaseFee());
  }

  @Test
  void calculateAdditionalFee() {
    assertEquals(20,gardeningTestOne.calculateAdditionalFee());
  }

  @Test
  void calculateDiscountFee(){
    assertEquals(34,gardeningTestOne.calculateDiscountFee());
  }

  @Test
  void calculatePrice(){
    assertEquals(306,gardeningTestOne.calculatePrice());
  }

  @Test
  void testEquals() {
    assertTrue(gardeningTestOne.equals(gardeningTestOne) == gardeningTestOne.equals(gardeningTestOne));
    //test symmetry
    assertTrue(gardeningTestOne.equals(gardeningCopy) == gardeningCopy.equals(gardeningTestOne));
    //test transitivity
    assertTrue(gardeningTestOne.equals(gardeningCopy) && gardeningCopy.equals(gardeningImposter)
        && gardeningTestOne.equals(gardeningImposter));
    //test null reference
    assertFalse(gardeningTestOne.equals(null));
    //test consistency
    assertTrue(gardeningTestOne.equals(gardeningImposter));
    assertTrue(gardeningTestOne.equals(gardeningImposter));
    //test equals where equal should be false
    assertFalse(gardeningTestOne.equals(gardeningTestTwo));
  }

  @Test
  void testHashCode() {
    //test null
    assertFalse(0 == gardeningTestOne.hashCode());
    //test consistency
    int testHashCode = gardeningTestOne.hashCode();
    assertEquals(testHashCode, gardeningTestOne.hashCode());

  }

  @Test
  void testToString() {
    String expected = "Gardening:" + "propertyAddress='" + "ABC" + '\'' +
        ", propertySize=" + "LARGE" +
        ", carriedOutMonthly=" + "true" +
        ", numberOfServices=" + "8";
    assertEquals(expected, gardeningTestOne.toString());
  }

}
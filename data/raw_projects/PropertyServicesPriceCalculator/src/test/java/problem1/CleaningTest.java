package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CleaningTest {
  private Cleaning cleaningTestOne;
  private Cleaning cleaningTestTwo;
  private Cleaning cleaningTestThree;
  private Cleaning cleaningTestCopy;
  private Cleaning cleaningTestImposter;

  @BeforeEach
  void setUp() {
    cleaningTestOne = new Cleaning("ABC",PropertySize.SMALL,true,8,3);
    cleaningTestCopy = new Cleaning("ABC",PropertySize.SMALL,true,8,3);
    cleaningTestImposter = new Cleaning("ABC",PropertySize.SMALL,true,8,3);
    cleaningTestTwo = new Cleaning("ABC",PropertySize.LARGE,true,9,2);
    cleaningTestThree = new Cleaning("abc",PropertySize.MEDIUM,false,0,0);
  }

  @Test
  void calculateBaseFee() {
    assertEquals(80.0,cleaningTestOne.calculateBaseFee());
    assertEquals(320.0,cleaningTestTwo.calculateBaseFee());
    assertEquals(160.0,cleaningTestThree.calculateBaseFee());
  }

  @Test
  void calculateAdditionalFee(){
    assertEquals(5.6,cleaningTestOne.calculateAdditionalFee());
    assertEquals(16.0,cleaningTestTwo.calculateAdditionalFee());
    assertEquals(0.0,cleaningTestThree.calculateAdditionalFee());
  }

  @Test
  void calculateDiscountFee(){
    assertEquals(8.56,cleaningTestOne.calculateDiscountFee());
    assertEquals(168.0,cleaningTestTwo.calculateDiscountFee());
    assertEquals(0.0,cleaningTestThree.calculateDiscountFee());
  }

  @Test
  void calculatePrice(){
    assertEquals(77.04,cleaningTestOne.calculatePrice());
    assertEquals(168.0,cleaningTestTwo.calculatePrice());
    assertEquals(160.0,cleaningTestThree.calculatePrice());
  }


  @Test
  void getAddress(){
    assertEquals("ABC",cleaningTestOne.getPropertyAddress());
  }

  @Test
  void getSize(){
    assertEquals(PropertySize.SMALL, cleaningTestOne.getPropertySize());
  }

  @Test
  void testEquals() {
    assertTrue(cleaningTestOne.equals(cleaningTestOne) == cleaningTestOne.equals(cleaningTestOne));
    //test symmetry
    assertTrue(cleaningTestOne.equals(cleaningTestCopy) == cleaningTestOne.equals(cleaningTestCopy));
    //test transitivity
    assertTrue(cleaningTestOne.equals(cleaningTestCopy) && cleaningTestCopy.equals(cleaningTestImposter)
        && cleaningTestOne.equals(cleaningTestImposter));
    //test null reference
    assertFalse(cleaningTestOne.equals(null));
    //test consistency
    assertTrue(cleaningTestOne.equals(cleaningTestCopy));
    assertTrue(cleaningTestOne.equals(cleaningTestCopy));
    //test equals where equal should be false
    assertFalse(cleaningTestOne.equals(cleaningTestTwo));
  }

  @Test
  void testHashCode(){
    //test null
    assertFalse(0 == cleaningTestOne.hashCode());
    //test consistency
    int testHashCode = cleaningTestOne.hashCode();
    assertEquals(testHashCode, cleaningTestOne.hashCode());
  }

  @Test
  void testToString(){
    String expected = "Cleaning:" + "propertyAddress='" + "ABC" + '\'' +
        ", propertySize=" + "SMALL" +
        ", carriedOutMonthly=" + "true" +
        ", numberOfServices=" + "8" + "numberOfPets=" + "3";
    assertEquals(expected,cleaningTestOne.toString());
  }
}
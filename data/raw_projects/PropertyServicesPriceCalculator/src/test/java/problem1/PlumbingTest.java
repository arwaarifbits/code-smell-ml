package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlumbingTest {

  private Plumbing plumbingTestOne;
  private Plumbing plumbingTestTwo;
  private Plumbing plumbingTestThree;
  private Plumbing plumbingCopy;
  private Plumbing plumbingImposter;

  @BeforeEach
  void setUp() throws InvalidNumberOfLicensedException {
    plumbingTestOne = new Plumbing("ABC", PropertySize.SMALL, true,
        9, 0, true);
   plumbingTestTwo = new Plumbing("ABC", PropertySize.LARGE, false,
       7, 0, true);
   plumbingTestThree = new Plumbing("ABC", PropertySize.MEDIUM, false,
       29, 6, false);
   plumbingCopy = new Plumbing("ABC", PropertySize.SMALL, true,
       9, 0, true);
   plumbingImposter = new Plumbing("ABC", PropertySize.SMALL, true,
       9, 0, true);
  }

  @Test
  void calculateBaseFee() {
    assertEquals(400.0,plumbingTestOne.calculateBaseFee());
    assertEquals(600.0,plumbingTestTwo.calculateBaseFee());
    assertEquals(1200.0,plumbingTestThree.calculateBaseFee());
  }


  @Test
  void calculateAdditionalFee() {
    assertEquals(20, plumbingTestThree.calculateAdditionalFee());
  }

  @Test
  void calculateDiscountFee(){
   assertEquals(0,plumbingTestThree.calculateDiscountFee());
  }

  @Test
  void calculatePrice(){
    assertEquals(420.0, plumbingTestOne.calculatePrice());
    assertEquals(620.0,plumbingTestTwo.calculatePrice());
    assertEquals(1220.0,plumbingTestThree.calculatePrice());
  }
  @Test
  void testEquals() {
    assertTrue(plumbingTestOne.equals(plumbingTestOne) == plumbingTestOne.equals(plumbingTestOne));
    //test symmetry
    assertTrue(plumbingTestOne.equals(plumbingCopy) == plumbingTestOne.equals(plumbingCopy));
    //test transitivity
    assertTrue(plumbingTestOne.equals(plumbingCopy) && plumbingCopy.equals(plumbingImposter)
        && plumbingTestOne.equals(plumbingImposter));
    //test null reference
    assertFalse(plumbingTestOne.equals(null));
    //test consistency
    assertTrue(plumbingTestOne.equals(plumbingCopy));
    assertTrue(plumbingTestOne.equals(plumbingCopy));
    //test equals where equal should be false
    assertFalse(plumbingTestOne.equals(plumbingTestTwo));
  }

  @Test
  void testHashCode(){
    //test null
    assertFalse(0 == plumbingTestOne.hashCode());
    //test consistency
    int testHashCode = plumbingTestOne.hashCode();
    assertEquals(testHashCode, plumbingTestOne.hashCode());
  }


  @Test
  void testToString(){
    String expected = "Plumbing:" + "propertyAddress='" + "ABC" + '\'' +
        ", propertySize=" + "SMALL" +
        ", carriedOutMonthly=" + "true" +
        ", numberOfServices=" + "9" + "numberOfLicensed=" + "2" +
        ", isComplex=" + "true";
    assertEquals(expected,plumbingTestOne.toString());
  }

}
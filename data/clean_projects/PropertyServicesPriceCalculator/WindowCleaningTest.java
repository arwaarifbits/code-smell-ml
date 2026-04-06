package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WindowCleaningTest {
  private WindowCleaning windowCleaningTestOne;
  private WindowCleaning windowCleaningTestTwo;
  private WindowCleaning windowCleaningCopy;
  private WindowCleaning windowCleaningImposter;
  private WindowCleaning invalidFloor;

  @BeforeEach
  void setUp() throws InvalidNumberOfFloorsException {
    windowCleaningTestOne = new WindowCleaning("ABC",PropertySize.SMALL,true,0,1);
    windowCleaningCopy = new WindowCleaning("ABC",PropertySize.SMALL,true,0,1);
    windowCleaningImposter = new WindowCleaning("ABC",PropertySize.SMALL,true,0,1);
    windowCleaningTestTwo = new WindowCleaning("BCA",PropertySize.MEDIUM,false,9,2);
  }

  @Test
  void calculateBaseFee(){
    assertEquals(80,windowCleaningTestOne.calculateBaseFee());
    assertEquals(160,windowCleaningTestTwo.calculateBaseFee());
  }
  @Test
  void calculateAdditionalFee() {
    assertEquals(0,windowCleaningTestOne.calculateAdditionalFee());
    assertEquals(8,windowCleaningTestTwo.calculateAdditionalFee());
  }

  @Test
  void getNumberOfFloors() {
    assertEquals(1,windowCleaningTestOne.getNumberOfFloors());
  }

  @Test
  void isValidNumberOfFloors(){
    assertThrows(InvalidNumberOfFloorsException.class, () -> invalidFloor =
        new WindowCleaning("ABC",PropertySize.SMALL,false,0,6));
  }
  @Test
  void testEquals() {
    assertTrue(windowCleaningTestOne.equals(windowCleaningTestOne) == windowCleaningTestOne.equals(windowCleaningTestOne));
    //test symmetry
    assertTrue(windowCleaningTestOne.equals(windowCleaningCopy) == windowCleaningTestOne.equals(windowCleaningCopy));
    //test transitivity
    assertTrue(windowCleaningTestOne.equals(windowCleaningCopy) && windowCleaningCopy.equals(windowCleaningImposter)
        && windowCleaningTestOne.equals(windowCleaningImposter));
    //test null reference
    assertFalse(windowCleaningTestOne.equals(null));
    //test consistency
    assertTrue(windowCleaningTestOne.equals(windowCleaningCopy));
    assertTrue(windowCleaningTestOne.equals(windowCleaningCopy));
    //test equals where equal should be false
    assertFalse(windowCleaningTestTwo.equals(windowCleaningTestOne));
  }

  @Test
  void testHashCode() {
    //test null
    assertFalse(0 == windowCleaningTestOne.hashCode());
    //test consistency
    int testHashCode = windowCleaningTestOne.hashCode();
    assertEquals(testHashCode, windowCleaningTestOne.hashCode());

  }

  @Test
  void testToString() {
    String expected = "WindowCleaning:" + "propertyAddress='" + "ABC" + '\'' +
        ", propertySize=" + "SMALL" +
        ", carriedOutMonthly=" + "true" +
        ", numberOfServices=" + "0" +
        "numberOfFloors=" + '1';
    assertEquals(expected, windowCleaningTestOne.toString());
  }
}
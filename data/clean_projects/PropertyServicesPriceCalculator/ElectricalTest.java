package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ElectricalTest {
  private Electrical electricalTestOne;
  private Electrical electricalInvalid;
  @BeforeEach
  void setUp() throws InvalidNumberOfLicensedException {
    electricalTestOne = new Electrical("ABC",PropertySize.LARGE,true,0,2,true);
  }

  @Test
  void calculateAdditionalFee() {
    assertEquals(50,electricalTestOne.calculateAdditionalFee());
  }

  @Test
  void isInvalidNumberOfLicensed(){
    assertThrows(InvalidNumberOfLicensedException.class, ()->electricalInvalid = new Electrical("ABC",PropertySize.SMALL,true,0,8,true));
  }

  @Test
  void isValidLicensed() throws InvalidNumberOfLicensedException {
    assertEquals(3,electricalTestOne.isValidLicensed(2));
  }

  @Test
  void calculateBaseFee() {
    assertEquals(600,electricalTestOne.calculateBaseFee());
  }

  @Test
  void calculateDiscountFee(){
    assertEquals(0,electricalTestOne.calculateDiscountFee());
  }

  @Test
  void calculatePrice(){
    assertEquals(650.0,electricalTestOne.calculatePrice());
  }

  @Test
  void testToString(){
    String expected = "Electrical:" + "propertyAddress='" + "ABC" + '\'' +
        ", propertySize=" + "LARGE" +
        ", carriedOutMonthly=" + "true" +
        ", numberOfServices=" + "0" + "numberOfLicensed=" + "3" +
        ", isComplex=" + "true";
    assertEquals(expected,electricalTestOne.toString());
  }
}
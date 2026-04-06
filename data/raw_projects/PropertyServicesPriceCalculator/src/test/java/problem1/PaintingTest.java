package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaintingTest {
  private Painting paintingTestOne;
  private Painting paintingTestTwo;
  private Painting paintingTestThree;
  @BeforeEach
  void setUp() {
    paintingTestOne = new Painting("ABC",PropertySize.SMALL,true,8,2);
    paintingTestTwo = new Painting("ABC",PropertySize.MEDIUM,true,29,3);
    paintingTestThree = new Painting("ABC",PropertySize.LARGE,false,0,0);
  }

  @Test
  void calculateBaseFee() {
    assertEquals(1280.0, paintingTestOne.calculateBaseFee());
    assertEquals(1280.0, paintingTestTwo.calculateBaseFee());
    assertEquals(1920.0, paintingTestThree.calculateBaseFee());
  }

  @Test
  void calculateAdditionalFee(){
    assertEquals(64.0,paintingTestOne.calculateAdditionalFee());
    assertEquals(89.6,paintingTestTwo.calculateAdditionalFee());
    assertEquals(0,paintingTestThree.calculateAdditionalFee());
  }

  @Test
  void calculateDiscountFee(){
    assertEquals(134.4, paintingTestOne.calculateDiscountFee());
    assertEquals(684.8,paintingTestTwo.calculateDiscountFee());
    assertEquals(0,paintingTestThree.calculateDiscountFee());
  }

  @Test
  void calculatePrice(){
    assertEquals(1209.6,paintingTestOne.calculatePrice());
    assertEquals(684.8,paintingTestTwo.calculatePrice());
    assertEquals(1920.0,paintingTestThree.calculatePrice());
  }

  @Test
  void testToString(){
    String expected = "Painting:" + "propertyAddress='" + "ABC" + '\'' +
        ", propertySize=" + "SMALL" +
        ", carriedOutMonthly=" + "true" +
        ", numberOfServices=" + "8" + "numberOfPets=" + "2";
    assertEquals(expected,paintingTestOne.toString());
  }
}
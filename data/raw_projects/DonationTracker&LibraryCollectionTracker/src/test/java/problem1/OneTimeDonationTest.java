package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OneTimeDonationTest {

  private OneTimeDonation oneTimeTest;
  private OneTimeDonation oneTimeTestCopy;
  private OneTimeDonation oneTimeTestImposter;
  private OneTimeDonation oneTimeDonation2;

  @BeforeEach
  void setUp() {
    oneTimeTest =
        new OneTimeDonation(45.0,
            LocalDateTime.of(2022, 3, 16, 22, 0, 1));
    oneTimeTestCopy =
        new OneTimeDonation(45.0,
            LocalDateTime.of(2022, 3, 16, 22, 0, 1));
    oneTimeTestImposter =
        new OneTimeDonation(45.0,
            LocalDateTime.of(2022, 3, 16, 22, 0, 1));
    oneTimeDonation2 =
        new OneTimeDonation(43.0,
            LocalDateTime.of(2022, 3, 16, 22, 0, 1));
  }

  @Test
  void calculateDonationThisYear() {
    assertEquals(0.0, oneTimeTest.calculateDonationThisYear(2020));
    assertEquals(0.0, oneTimeTest.calculateDonationThisYear(2026));
    assertEquals(45.0, oneTimeTest.calculateDonationThisYear(2022));
  }

  @Test
  void testEquals() {
    assertTrue(oneTimeTest.equals(oneTimeTest) == oneTimeTest.equals(oneTimeTest));
    //test symmetry
    assertTrue(oneTimeTest.equals(oneTimeTestCopy) == oneTimeTestCopy.equals(oneTimeTest));
    //test transitivity
    assertTrue(
        oneTimeTest.equals(oneTimeTestImposter) && oneTimeTestCopy.equals(oneTimeTestImposter)
            && oneTimeTest.equals(oneTimeTestCopy));
    //test null reference
    assertFalse(oneTimeTest.equals(null));
    //test consistency
    assertTrue(oneTimeTest.equals(oneTimeTestImposter));
    assertTrue(oneTimeTest.equals(oneTimeTestImposter));
    //test equals where equal should be false
    assertFalse(oneTimeDonation2.equals(oneTimeTestCopy));
  }

  @Test
  void testHashCode() {
    //test null
    assertFalse(0 == oneTimeTest.hashCode());
    //test consistency
    int testHashCode = oneTimeTest.hashCode();
    assertEquals(testHashCode, oneTimeTest.hashCode());

  }

  @Test
  void testToString() {
    String expected = "OneTimeDonation:" + "amount=" + "45.0" +
        ", dateTime=" + "2022-03-16T22:00:01";
    assertEquals(expected, oneTimeTest.toString());
  }
}
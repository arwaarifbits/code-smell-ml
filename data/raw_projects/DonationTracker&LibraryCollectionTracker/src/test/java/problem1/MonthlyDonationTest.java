package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MonthlyDonationTest {

  private MonthlyDonation noCancellationTime;
  private MonthlyDonation monthlyDonation1;
  private MonthlyDonation monthlyDonation1Copy;
  private MonthlyDonation monthlyDonation1Imposter;

  @BeforeEach
  void setUp() throws InvalidCancellationTime {
    LocalDateTime creationTime1 =
        LocalDateTime.of(2020, 11, 12, 12, 12, 12);
    LocalDateTime cancellationTime1 =
        LocalDateTime.of(2020, 12, 13, 12, 12, 12);
    monthlyDonation1 = new MonthlyDonation(30.0, creationTime1);
    monthlyDonation1.setCancellationDateTime(cancellationTime1);
    monthlyDonation1Copy = new MonthlyDonation(30.0, creationTime1);
    monthlyDonation1Copy.setCancellationDateTime(cancellationTime1);
    monthlyDonation1Imposter = new MonthlyDonation(30.0, creationTime1);
    monthlyDonation1Imposter.setCancellationDateTime(cancellationTime1);
    noCancellationTime = new MonthlyDonation(20.0,
        LocalDateTime.of(2021, 1, 1, 1, 1, 1));
  }

  @Test
  void calculateDonationThisYear() throws InvalidCancellationTime {
    // creation year is after this year
    assertEquals(0.0, monthlyDonation1.calculateDonationThisYear(1997));
    assertEquals(0.0, monthlyDonation1.calculateDonationThisYear(2088));
    // creation year is in this year
    // if it does not be canceled or cancelled in the future (not in this year)
    assertEquals(240.0, noCancellationTime.calculateDonationThisYear(2021));
    MonthlyDonation cancelledInFuture = new MonthlyDonation(30.0,
        LocalDateTime.of(2020, 11, 12, 12, 12, 12));
    cancelledInFuture.setCancellationDateTime(
        LocalDateTime.of(2024, 11, 12, 12, 12, 12));
    assertEquals(60.0, cancelledInFuture.calculateDonationThisYear(2020));
    //creation year is in this year and the cancellation happens in this year
    assertEquals(60.0, monthlyDonation1.calculateDonationThisYear(2020));
    // creation year is in the past (this.getDateTime().getYear() < year)
    // if it does not be canceled or cancelled in the future (not in this year)
    assertEquals(240.0, noCancellationTime.calculateDonationThisYear(2022));
    assertEquals(360.0, cancelledInFuture.calculateDonationThisYear(2022));
    // creation year is in the past (this.getDateTime().getYear() < year)
    // if the cancellation happens in this year
    assertEquals(330.0, cancelledInFuture.calculateDonationThisYear(2024));
  }

  @Test
  void isValidCancellationTime() {
    assertThrows(InvalidCancellationTime.class, () -> monthlyDonation1.setCancellationDateTime(
        LocalDateTime.of(1997, 1, 1, 1, 1, 1)
    ));
  }

  @Test
  void setCancellationDateTime() throws InvalidCancellationTime {
    LocalDateTime expected =
        LocalDateTime.of(2024, 12, 12, 12, 12, 12);
    monthlyDonation1.setCancellationDateTime(
        LocalDateTime.of(2024, 12, 12, 12, 12, 12));
    assertEquals(expected, monthlyDonation1.getCancellationDateTime());
  }

  @Test
  void getCancellationDateTime() {
    LocalDateTime expected =
        LocalDateTime.of(2020, 12, 13, 12, 12, 12);
    assertEquals(expected, monthlyDonation1.getCancellationDateTime());
  }

  @Test
  void testEquals() {
    assertTrue(
        monthlyDonation1.equals(monthlyDonation1) == monthlyDonation1.equals(monthlyDonation1));
    //test symmetry
    assertTrue(monthlyDonation1.equals(monthlyDonation1Copy) == monthlyDonation1.equals(
        monthlyDonation1Copy));
    //test transitivity
    assertTrue(monthlyDonation1Copy.equals(monthlyDonation1) && monthlyDonation1.equals(
        monthlyDonation1Imposter)
        && monthlyDonation1Copy.equals(monthlyDonation1Imposter));
    //test null reference
    assertFalse(monthlyDonation1.equals(null));
    //test consistency
    assertTrue(monthlyDonation1.equals(monthlyDonation1Copy));
    assertTrue(monthlyDonation1.equals(monthlyDonation1Copy));
    //test equals where equal should be false
    assertFalse(monthlyDonation1.equals(noCancellationTime));
  }

  @Test
  void testHashCode() {//test null
    assertFalse(0 == monthlyDonation1.hashCode());
    //test consistency
    int testHashCode = monthlyDonation1.hashCode();
    assertEquals(testHashCode, monthlyDonation1.hashCode());
  }

  @Test
  void testToString() {
    String expected =
        "MonthlyDonation:" + "amount=" + "30.0" +
            ", dateTime=" + "2020-11-12T12:12:12" +
            "cancellationDateTime=" + "2020-12-13T12:12:12";
    assertEquals(expected, monthlyDonation1.toString());
  }
}
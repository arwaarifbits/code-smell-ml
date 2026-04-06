package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PledgeTest {

  private Pledge noProcessTimePledge;
  private Pledge processTimePledge1;
  private Pledge processTimePledge2;
  private Pledge copyProcessTimePledge1;
  private Pledge imposterProcessTimePledge1;

  @BeforeEach
  void setUp() {
    noProcessTimePledge = new Pledge(20000.0,
        LocalDateTime.of(2000, 11, 11, 11, 11, 11));
    LocalDateTime processingTestOneTime =
        LocalDateTime.of(2030, 10, 10, 12, 12, 12);
    LocalDateTime creationTestOneTime =
        LocalDateTime.of(2010, 10, 10, 12, 12, 12);
    processTimePledge1 = new Pledge(3000.0, creationTestOneTime, processingTestOneTime);
    copyProcessTimePledge1 = new Pledge(3000.0, creationTestOneTime, processingTestOneTime);
    imposterProcessTimePledge1 = new Pledge(3000.0, creationTestOneTime, processingTestOneTime);
    processTimePledge2 = new Pledge(1000.1,
        LocalDateTime.of(2013, 10, 10, 12, 12, 12),
        LocalDateTime.of(2024, 10, 10, 12, 12, 12));
  }

  @Test
  void calculateDonationThisYear() {
    assertEquals(0, noProcessTimePledge.calculateDonationThisYear(2021));
    assertEquals(0, processTimePledge1.calculateDonationThisYear(2022));
    assertEquals(0, processTimePledge1.calculateDonationThisYear(2099));
    assertEquals(3000.0, processTimePledge1.calculateDonationThisYear(2030));
  }

  @Test
  void getProcessingDate() {
    LocalDateTime expected =
        LocalDateTime.of(2024, 10, 10, 12, 12, 12);
    assertEquals(expected, processTimePledge2.getProcessingDate());
  }

  @Test
  void isValidProcessingTime() {
    assertThrows(InvalidProcessingTime.class, () ->
        processTimePledge1.setProcessingDate(
            LocalDateTime.of(2009, 10, 10, 12, 12, 12)));
  }

  @Test
  void setProcessingDate() throws InvalidProcessingTime {
    LocalDateTime expected =
        LocalDateTime.of(2024, 10, 10, 12, 12, 12);
    processTimePledge1.setProcessingDate(
        LocalDateTime.of(2024, 10, 10, 12, 12, 12)
    );
    assertEquals(expected, processTimePledge1.getProcessingDate());
  }

  @Test
  void removeProcessingDate() {
    processTimePledge1.removeProcessingDate();
    assertNull(processTimePledge1.getProcessingDate());
  }

  @Test
  void testEquals() {
    assertTrue(processTimePledge1.equals(processTimePledge1) ==
        processTimePledge1.equals(processTimePledge1));
    //test symmetry
    assertTrue(processTimePledge1.equals(copyProcessTimePledge1) ==
        processTimePledge1.equals(copyProcessTimePledge1));
    //test transitivity
    assertTrue(processTimePledge1.equals(copyProcessTimePledge1) &&
        copyProcessTimePledge1.equals(imposterProcessTimePledge1)
        && processTimePledge1.equals(imposterProcessTimePledge1));
    //test null reference
    assertFalse(processTimePledge1.equals(null));
    //test consistency
    assertTrue(processTimePledge1.equals(copyProcessTimePledge1));
    assertTrue(processTimePledge1.equals(copyProcessTimePledge1));
    //test equals where equal should be false
    assertFalse(processTimePledge1.equals(processTimePledge2));
  }

  @Test
  void testHashCode() {
    //test null
    assertFalse(0 == processTimePledge1.hashCode());
    //test consistency
    int testHashCode = processTimePledge1.hashCode();
    assertEquals(testHashCode, processTimePledge1.hashCode());

  }

  @Test
  void testToString() {
    String expected =
        "Pledge" + "amount=" + "1000.1" +
            ", dateTime=" + "2013-10-10T12:12:12" +
            "processingDateTime=" + "2024-10-10T12:12:12";
    assertEquals(expected, processTimePledge2.toString());
  }
}
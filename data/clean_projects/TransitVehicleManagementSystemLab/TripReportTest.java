package Problem1AndProblem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TripReportTest {

  private Train train;
  private Bus bus;
  private TripReport tripReport;
  private TripReport tripReportCopy;
  private TripReport tripReportImposter;
  private TripReport tripReportTwo;

  @BeforeEach
  void setUp() {
    bus = new Bus("12345", 6F, 10F);
    train = new Train("1111", 9F, 20F);
    tripReport = new TripReport(bus, 3F, 12F, 4);
    tripReportTwo = new TripReport(train, 5F, 10F, 2);
    tripReportCopy = new TripReport(bus, 3F, 12F, 4);
    tripReportImposter = new TripReport(bus, 3F, 12F, 4);
  }

  @Test
  void getVehicle() {
    assertEquals(bus, tripReport.getVehicle());
  }

  @Test
  void getSpeed() {
    assertEquals(3F, tripReport.getSpeed());
  }

  @Test
  void getDistance() {
    assertEquals(12F, tripReport.getDistance());
  }

  @Test
  void getDuration() {
    assertEquals(4, tripReport.getDuration());
  }

  @Test
  void testEquals() {
    assertTrue(tripReport.equals(tripReport) == tripReport.equals(tripReport));
    //test symmetry
    assertTrue(tripReport.equals(tripReportCopy) == tripReportCopy.equals(tripReport));
    //test transitivity
    assertTrue(tripReport.equals(tripReportCopy) && tripReportCopy.equals(tripReportImposter)
        && tripReport.equals(tripReportImposter));
    //test null reference
    assertFalse(tripReport.equals(null));
    //test consistency
    assertTrue(tripReport.equals(tripReportCopy));
    assertTrue(tripReport.equals(tripReportCopy));
    //test equals where equal should be false
    assertFalse(tripReportTwo.equals(tripReport));
  }

  @Test
  void testHashCode() {
    //test null
    assertFalse(0 == tripReport.hashCode());
    //test consistency
    int testHashCode = tripReportTwo.hashCode();
    assertEquals(testHashCode, tripReportTwo.hashCode());
  }

  @Test
  void testToString() {
    String expected = "TripReport{" +
        "vehicle=" + "Bus:iD='12345', avgSpeed=6.0, maxSpeed=10.0" +
        ", speed=" + "3.0" +
        ", distance=" + "12.0" +
        ", duration=" + "4" +
        '}';
    assertEquals(expected, tripReport.toString());
  }

}
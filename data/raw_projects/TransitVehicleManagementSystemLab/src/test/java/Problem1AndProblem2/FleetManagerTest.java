package Problem1AndProblem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FleetManagerTest {

  private FleetManager fleetManager;
  private TripReport tripReport;
  private TripReport tripReportTwo;
  private TripReport tripReportThree;
  private Bus bus;

  @BeforeEach
  void setUp() {
    bus = new Bus("1", 50F, 100F);
    fleetManager = new FleetManager();
    tripReport = new TripReport(bus, 50F, 100F, 2);
    tripReportTwo = new TripReport(bus, 100F, 100F, 1);
    tripReportThree = new TripReport(bus, -1F, 1000F, 1);
  }

  @Test
  void drive() {
    assertEquals(tripReport, fleetManager.drive(bus, 100F));
    assertEquals(tripReport, fleetManager.drive(bus, 2));
    assertEquals(tripReport, fleetManager.drive(bus, 50F, 100F));
    assertEquals(tripReportTwo, fleetManager.drive(bus, 120F, 100F));
    assertEquals(tripReportThree, fleetManager.drive(bus, 1000F, 1));
    assertEquals(tripReport, fleetManager.drive(bus, 100F, 2));
  }
}
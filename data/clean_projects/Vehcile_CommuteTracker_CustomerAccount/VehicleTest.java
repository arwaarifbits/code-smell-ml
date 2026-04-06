package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VehicleTest {
  private Vehicle cyberTruck;
  private Owner elong;
  @BeforeEach
  void setUp() {
    this.elong = new Owner("Elong","Musk","123123");
    this.cyberTruck = new Vehicle(100,"DOGE1",elong);
  }

  @Test
  void getVIN() {
    Assertions.assertEquals(100, cyberTruck.getVIN());
  }

  @Test
  void getLicensePlate() {
    Assertions.assertEquals("DOGE1", cyberTruck.getLicensePlate());
  }

  @Test
  void getOwnerFirstName() {
    Assertions.assertEquals("Elong", cyberTruck.getOwnerFirstName());
  }

  @Test
  void getOwnerLastName() {
    Assertions.assertEquals("Musk", cyberTruck.getOwnerLastName());
  }

  @Test
  void getOwnerPhoneNumber() {
    Assertions.assertEquals("123123", cyberTruck.getOwnerPhoneNumber());
  }

  @Test
  void setVIN() {
    cyberTruck.setVIN(200);
    Assertions.assertEquals(200, cyberTruck.getVIN());
  }

  @Test
  void setLicensePlate() {
    cyberTruck.setLicensePlate("TSLA1");
    Assertions.assertEquals("TSLA1", cyberTruck.getLicensePlate());
  }

  @Test
  void setOwnerFirstName() {
    cyberTruck.setOwnerFirstName("baby");
    Assertions.assertEquals("baby", cyberTruck.getOwnerFirstName());
  }

  @Test
  void setOwnerLastName() {
    cyberTruck.setOwnerLastName("justin");
    Assertions.assertEquals("justin", cyberTruck.getOwnerLastName());
  }

  @Test
  void setOwnerPhoneNumber() {
    cyberTruck.setOwnerPhoneNumber("123456");
    Assertions.assertEquals("123456", cyberTruck.getOwnerPhoneNumber());
  }
}
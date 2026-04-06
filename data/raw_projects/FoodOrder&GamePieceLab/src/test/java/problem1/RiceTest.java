package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RiceTest {
  private Rice largeQuantity;
  private Rice brown;

  @BeforeEach
  void setUp() throws IncorrectQuantityException {
    brown = new Rice("Brown",7.2,30);
  }

  @Test
  void tooLargeQuantity(){
    assertThrows(IncorrectQuantityException.class, ()->{largeQuantity = new Rice("Sakura",9.99, 1000);});
  }

  @Test
  void getName(){
    assertEquals("Brown",brown.getName());
  }

  @Test
  void getQuantity(){
    assertEquals(30,brown.getAvailableQuantity());
  }

  @Test
  void getPrice(){
    assertEquals(7.2, brown.getPricePerUnit());
  }

  @Test
  void getMaxAllowed(){
    assertEquals(250, brown.getMaxAllowedQuantity());
  }
}
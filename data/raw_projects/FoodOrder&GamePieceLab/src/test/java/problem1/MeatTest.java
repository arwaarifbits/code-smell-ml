package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MeatTest {

  private Meat beef;

  @BeforeEach
  void setUp() throws IncorrectQuantityException {
    beef = new Meat("beef", 12.22, 70,
        LocalDateTime.of(2021, 3, 15, 12, 20, 21),
        LocalDateTime.of(2021, 4, 15, 12, 20, 21));
  }

  @Test
  void getName() {
    assertEquals("beef", beef.getName());
  }

  @Test
  void getPrice() {
    assertEquals(12.22, beef.getPricePerUnit());
  }

  @Test
  void getAvaQuantity() {
    assertEquals(70, beef.getAvailableQuantity());
  }

  @Test
  void getOrderDate() {
    assertEquals(LocalDateTime.of(2021, 3, 15, 12, 20, 21), beef.getOrderDate());
  }

  @Test
  void getExpirationDate() {
    assertEquals(LocalDateTime.of(2021, 4, 15, 12, 20, 21), beef.getExpirationDate());
  }
}
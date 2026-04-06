package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VegetableTest {

  private Vegetable potato;

  @BeforeEach
  void setUp() throws IncorrectQuantityException {
    potato = new Vegetable("potato", 1.22, 70,
        LocalDateTime.of(2021, 3, 15, 12, 20, 21),
        LocalDateTime.of(2021, 5, 15, 12, 20, 21));
  }

  @Test
  void getName() {
    assertEquals("potato", potato.getName());
  }

  @Test
  void getPrice() {
    assertEquals(1.22, potato.getPricePerUnit());
  }

  @Test
  void getAvaQuantity() {
    assertEquals(70, potato.getAvailableQuantity());
  }

  @Test
  void getOrderDate() {
    assertEquals(LocalDateTime.of(2021, 3, 15, 12, 20, 21), potato.getOrderDate());
  }

  @Test
  void getExpirationDate() {
    assertEquals(LocalDateTime.of(2021, 5, 15, 12, 20, 21), potato.getExpirationDate());
  }

}
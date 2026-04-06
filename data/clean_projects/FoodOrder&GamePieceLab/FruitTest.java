package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FruitTest {

  private Fruit apple;
  private Fruit pear;
  private Fruit copyApple;
  private Fruit imposterApple;
  private Fruit negativeQuantity;
  private Fruit largeQuantity;

  @BeforeEach
  void setUp() throws IncorrectQuantityException {
    apple = new Fruit("APPLE", 2.22, 70,
        LocalDateTime.of(2021, 3, 15, 12, 20, 21),
        LocalDateTime.of(2021, 5, 15, 12, 20, 21));
    pear = new Fruit("PEAR", 4.1, 20,
        LocalDateTime.of(2021, 4, 15, 12, 20, 21),
        LocalDateTime.of(2021, 5, 15, 12, 20, 21));
    copyApple = new Fruit("APPLE", 2.22, 70,
        LocalDateTime.of(2021, 3, 15, 12, 20, 21),
        LocalDateTime.of(2021, 5, 15, 12, 20, 21));
    imposterApple = new Fruit("APPLE", 2.22, 70,
        LocalDateTime.of(2021, 3, 15, 12, 20, 21),
        LocalDateTime.of(2021, 5, 15, 12, 20, 21));

  }

  @Test
  void tooLargeQuantity() throws IncorrectQuantityException {
    assertThrows(IncorrectQuantityException.class, () -> {
      largeQuantity = new Fruit("APPLE", 2.22, 1000,
          LocalDateTime.of(2021, 3, 15, 12, 20, 21),
          LocalDateTime.of(2021, 5, 15, 12, 20, 21));
    });
  }

  @Test
  void negativeQuantity() throws IncorrectQuantityException {
    assertThrows(IncorrectQuantityException.class, () -> {
      negativeQuantity = new Fruit("APPLE", 2.22, -70,
          LocalDateTime.of(2021, 3, 15, 12, 20, 21),
          LocalDateTime.of(2021, 5, 15, 12, 20, 21));
    });
  }

  @Test
  void getName() {
    assertEquals("APPLE", apple.getName());
  }

  @Test
  void getPrice() {
    assertEquals(2.22, apple.getPricePerUnit());
  }

  @Test
  void getAvaQuantity() {
    assertEquals(70, apple.getAvailableQuantity());
  }

  @Test
  void getOrderDate() {
    assertEquals(LocalDateTime.of(2021, 3, 15, 12, 20, 21), apple.getOrderDate());
  }

  @Test
  void getExpirationDate() {
    assertEquals(LocalDateTime.of(2021, 5, 15, 12, 20, 21), apple.getExpirationDate());
  }

  @Test
  void testEquals() {
    assertTrue(apple.equals(apple) == apple.equals(apple));
    //test symmetry
    assertTrue(apple.equals(copyApple) == copyApple.equals(apple));
    //test transitivity
    assertTrue(apple.equals(copyApple) && copyApple.equals(imposterApple)
        && apple.equals(imposterApple));
    //test null reference
    assertFalse(apple.equals(null));
    //test consistency
    assertTrue(apple.equals(copyApple));
    assertTrue(apple.equals(copyApple));
    //test equals where equal should be false
    assertFalse(pear.equals(apple));
  }

  @Test
  void testHashCode() {
    //test null
    assertFalse(0 == apple.hashCode());
    //test consistency
    int testHashCode = apple.hashCode();
    assertEquals(testHashCode, apple.hashCode());
  }

  @Test
  void testToString() {
    String expectedName =
        "PerishableFood{" +
            "orderDate=" + "2021-03-15T12:20:21" +
            ", expirationDate=" + "2021-05-15T12:20:21" +
            '}';
    assertEquals(expectedName, apple.toString());
  }
}
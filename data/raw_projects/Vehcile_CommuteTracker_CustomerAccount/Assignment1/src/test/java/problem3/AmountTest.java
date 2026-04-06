package problem3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AmountTest {

  private Amount amount1;
  private Amount amount2;

  @BeforeEach
  void setUp() {
    this.amount1 = new Amount(10, 99);
    this.amount2 = new Amount(9, 80);
  }

  @Test
  void getDollarAmount() {
    Assertions.assertEquals(10, amount1.getDollarAmount());
  }

  @Test
  void getCentsAmount() {
    Assertions.assertEquals(99, amount1.getCentsAmount());
  }

  @Test
  void addAmount() {
    Amount depositAmount = amount1.addAmount(amount1, amount2);
    Assertions.assertEquals(20, depositAmount.getDollarAmount());
    Assertions.assertEquals(79, depositAmount.getCentsAmount());

  }

  @Test
  void minusAmount() {
    Amount withdrawAmount = amount1.minusAmount(amount1, amount2);
    Assertions.assertEquals(1, withdrawAmount.getDollarAmount());
    Assertions.assertEquals(19, withdrawAmount.getCentsAmount());
  }
}
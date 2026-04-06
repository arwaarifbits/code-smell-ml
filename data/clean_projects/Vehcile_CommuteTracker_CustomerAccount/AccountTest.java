package problem3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {

  private Account doge;
  private Amount amount1;
  private Amount amount2;

  @BeforeEach
  void setUp() {
    this.amount1 = new Amount(10, 99);
    this.amount2 = new Amount(9, 80);
    this.doge = new Account("elong", "musk", amount1);
  }

  @Test
  void getFirstName() {
    Assertions.assertEquals("elong", doge.getFirstName());
  }

  @Test
  void getLastName() {
    Assertions.assertEquals("musk", doge.getLastName());
  }

  @Test
  void getAmount() {
    Assertions.assertEquals(10, doge.getAmount().getDollarAmount());
    Assertions.assertEquals(99, doge.getAmount().getCentsAmount());
  }

  @Test
  void deposit() {
    Account depositedAccount = doge.deposit(amount2);
    Assertions.assertEquals(20, depositedAccount.getAmount().getDollarAmount());
    Assertions.assertEquals(79, depositedAccount.getAmount().getCentsAmount());
  }

  @Test
  void withdraw() {
    Account withdrawedAccount = doge.withdraw(amount2);
    Assertions.assertEquals(1, withdrawedAccount.getAmount().getDollarAmount());
    Assertions.assertEquals(19, withdrawedAccount.getAmount().getCentsAmount());
  }

  @Test
  void setFirstName() {
    doge.setFirstName("chamath");
    Assertions.assertEquals("chamath", doge.getFirstName());
  }

  @Test
  void setLastName() {
    doge.setLastName("jordan");
    Assertions.assertEquals("jordan", doge.getLastName());
  }
}
package assignment2.problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MailItemTest {

  private Recipient recipient;
  private MailItem mail;
  private MailItem mailCopy;
  private MailItem mailImposter;
  private MailItem mailTwo;
  private MailItem invalidWidth;
  private MailItem invalidHeight;
  private MailItem invalidDepth;

  @BeforeEach
  void setUp() throws InvalidSizeException {
    recipient = new Recipient("Elong", "Musk", "elong@tsla.com");
    mail = new MailItem(2, 3, 4, recipient);
    mailCopy = new MailItem(2, 3, 4, recipient);
    mailImposter = new MailItem(2, 3, 4, recipient);
    mailTwo = new MailItem(3, 4, 5, recipient);
  }

  @Test
  void invalidSize() throws InvalidSizeException {
    assertThrows(InvalidSizeException.class,
        () -> invalidWidth = new MailItem(-1, 2, 4, recipient));
    assertThrows(InvalidSizeException.class,
        () -> invalidHeight = new MailItem(1, -2, 4, recipient));
    assertThrows(InvalidSizeException.class,
        () -> invalidDepth = new MailItem(1, 2, -4, recipient));
  }

  @Test
  void getWidth() {
    assertEquals(2, mail.getWidth());
  }

  @Test
  void getHeight() {
    assertEquals(3, mail.getHeight());
  }

  @Test
  void getDepth() {
    assertEquals(4, mail.getDepth());
  }

  @Test
  void getRecipient() {
    assertEquals(recipient, mail.getRecipient());
  }

  @Test
  void testEquals() {
    assertTrue(mail.equals(mail) == mail.equals(mail));
    //test symmetry
    assertTrue(mail.equals(mailCopy) == mailCopy.equals(mail));
    //test transitivity
    assertTrue(mail.equals(mailCopy) && mailCopy.equals(mailImposter)
        && mail.equals(mailImposter));
    //test null reference
    assertFalse(mail.equals(null));
    //test consistency
    assertTrue(mail.equals(mailCopy));
    assertTrue(mail.equals(mailCopy));
    //test equals where equal should be false
    assertFalse(mailTwo.equals(mail));
  }

  @Test
  void testHashCode() {
    //test null
    assertFalse(0 == mail.hashCode());
    //test consistency
    int testHashCode = mail.hashCode();
    assertEquals(testHashCode, mail.hashCode());
  }

  @Test
  void testToString() {
    String expected = "Mail{" +
        "width=" + "2" +
        ", height=" + "3" +
        ", depth=" + "4" +
        ", recipient="
        + "Recipient{firstName='Elong', lastName='Musk', emailAddress='elong@tsla.com'}" +
        '}';
    assertEquals(expected, mail.toString());
  }
}
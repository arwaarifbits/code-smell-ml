package assignment2.problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LockerTest {

  private Recipient recipient;
  private Recipient incorrectRecipient;
  private MailItem mail;
  private MailItem incorrectSizeMail;
  private Locker locker;
  private Locker lockerCopy;
  private Locker lockerImposter;
  private Locker lockerTwo;
  private Locker invalidLockerSize;
  private Locker negativeWidth;
  private Locker negativeHeight;
  private Locker negativeDepth;
  private MailItem incorrectWidthSizeMail;
  private MailItem incorrectHeightSizeMail;
  private MailItem incorrectDepthSizeMail;

  @BeforeEach
  void setUp() throws InvalidSizeException {
    recipient = new Recipient("Doge", "Inu", "doge@123.com");
    incorrectRecipient = new Recipient("Elong", "Musk", "elong@123.com");
    mail = new MailItem(2, 3, 4, recipient);
    incorrectSizeMail = new MailItem(5, 6, 7, recipient);
    incorrectWidthSizeMail = new MailItem(3, 4, 7, recipient);
    incorrectHeightSizeMail = new MailItem(3, 6, 5, recipient);
    incorrectDepthSizeMail = new MailItem(3,4,7,recipient);
    locker = new Locker(3, 4, 5);
    lockerCopy = new Locker(3, 4, 5);
    lockerImposter = new Locker(3, 4, 5);
    lockerTwo = new Locker(10, 11, 12);
  }

  @Test
  void invalidLockerSize() throws InvalidSizeException {
    assertThrows(InvalidSizeException.class, () -> invalidLockerSize =
        new Locker(0, 0, 0));
    assertThrows(InvalidSizeException.class, () -> negativeWidth =
        new Locker(-10, 10, 6));
    assertThrows(InvalidSizeException.class, () -> negativeHeight =
        new Locker(10, -5, 6));
    assertThrows(InvalidSizeException.class, () -> negativeDepth =
        new Locker(10, 5, -6));

  }

  @Test
  void exceedsMailSize() throws ExceedsSizeException {
    assertThrows(ExceedsSizeException.class, () -> locker.addMail(incorrectSizeMail));
    assertThrows(ExceedsSizeException.class, () -> locker.addMail(incorrectWidthSizeMail));
    assertThrows(ExceedsSizeException.class, () -> locker.addMail(incorrectHeightSizeMail));
    assertThrows(ExceedsSizeException.class, () -> locker.addMail(incorrectDepthSizeMail));
  }

  @Test
  void occupiedLocker() throws OccupiedException, ExceedsSizeException {
    locker.addMail(mail);
    assertThrows(OccupiedException.class, () -> locker.addMail(mail));
  }

  @Test
  void addMail() throws ExceedsSizeException, OccupiedException {
    locker.addMail(mail);
    assertEquals(mail, locker.getMailItem());
  }

  @Test
  void emptyLocker() throws EmptyException {
    assertThrows(EmptyException.class, () -> locker.pickupMail(recipient));
  }

  @Test
  void mismatchRecipient() throws MismatchException, ExceedsSizeException, OccupiedException {
    locker.addMail(mail);
    assertThrows(MismatchException.class, () -> locker.pickupMail(incorrectRecipient));
  }

  @Test
  void pickupMail()
      throws ExceedsSizeException, OccupiedException, EmptyException, MismatchException {
    locker.addMail(mail);
    assertEquals(mail, locker.pickupMail(recipient));
    assertEquals(null, locker.getMailItem());
  }

  @Test
  void getMaxWidth() {
    assertEquals(3, locker.getMaxWidth());
  }

  @Test
  void getMaxHeight() {
    assertEquals(4, locker.getMaxHeight());
  }

  @Test
  void getMaxDepth() {
    assertEquals(5, locker.getMaxDepth());
  }

  @Test
  void getMailItem() {
    assertEquals(null, locker.getMailItem());
  }

  @Test
  void testEquals() throws ExceedsSizeException, OccupiedException {
    locker.addMail(mail);
    lockerCopy.addMail(mail);
    lockerImposter.addMail(mail);
    assertTrue(locker.equals(locker) == locker.equals(locker));
    //test symmetry
    assertTrue(locker.equals(lockerCopy) == lockerCopy.equals(locker));
    //test transitivity
    assertTrue(locker.equals(lockerCopy) && lockerCopy.equals(lockerImposter)
        && locker.equals(lockerImposter));
    //test null reference
    assertFalse(locker.equals(null));
    //test consistency
    assertTrue(locker.equals(lockerCopy));
    assertTrue(locker.equals(lockerCopy));
    //test equals where equal should be false
    assertFalse(locker.equals(lockerTwo));
  }

  @Test
  void testHashCode() {
    //test null
    assertFalse(0 == locker.hashCode());
    //test consistency
    int testHashCode = locker.hashCode();
    assertEquals(testHashCode, locker.hashCode());
  }

  @Test
  void testToString() {
    String expected = "Locker{" +
        "maxWidth=" + "3" +
        ", maxHeight=" + "4" +
        ", maxDepth=" + "5" +
        ", mailItem=" + "null" +
        '}';
    assertEquals(expected, locker.toString());
  }
}
package assignment2.problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecipientTest {
  private Recipient recipient;
  private Recipient recipientCopy;
  private Recipient recipientImposter;
  private Recipient recipientTwo;
  @BeforeEach
  void setUp() {
    recipient = new Recipient("Doge","Inu","doge@123.com");
    recipientCopy = new Recipient("Doge","Inu","doge@123.com");
    recipientImposter = new Recipient("Doge","Inu","doge@123.com");
    recipientTwo = new Recipient("Elong","Musk","elong@tsla.com");
  }

  @Test
  void getFirstName() {
    assertEquals("Doge",recipient.getFirstName());
  }

  @Test
  void getLastName() {
    assertEquals("Inu",recipient.getLastName());
  }

  @Test
  void getEmailAddress() {
    assertEquals("doge@123.com",recipient.getEmailAddress());
  }

  @Test
  void testEquals() {
    assertTrue(recipient.equals(recipient) == recipient.equals(recipient));
    //test symmetry
    assertTrue(recipient.equals(recipientCopy) == recipientCopy.equals(recipient));
    //test transitivity
    assertTrue(recipient.equals(recipientCopy) && recipientCopy.equals(recipientImposter)
        && recipient.equals(recipientImposter));
    //test null reference
    assertFalse(recipient.equals(null));
    //test consistency
    assertTrue(recipientCopy.equals(recipient));
    assertTrue(recipientCopy.equals(recipient));
    //test equals where equal should be false
    assertFalse(recipientTwo.equals(recipient));
  }

  @Test
  void testHashCode() {
    //test null
    assertFalse(0 == recipient.hashCode());
    //test consistency
    int testHashCode = recipient.hashCode();
    assertEquals(testHashCode,recipient.hashCode());
  }

  @Test
  void testToString() {
    String expected = "Recipient{" +
        "firstName='" + "Doge" + '\'' +
        ", lastName='" + "Inu" + '\'' +
        ", emailAddress='" + "doge@123.com" + '\'' +
        '}';
    assertEquals(expected,recipient.toString());
  }
}
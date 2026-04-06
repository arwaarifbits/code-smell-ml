package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NameTest {

  private Name doge;
  private Name dogeCopy;
  private Name elong;
  private Name imposterDoge;

  @BeforeEach
  void setUp() {
    doge = new Name("Doge", "Inu");
    dogeCopy = new Name("Doge", "Inu");
    elong = new Name("Elong", "Musk");
    imposterDoge = new Name("Doge", "Inu");
  }

  @Test
  void getFirstName() {
    assertEquals("Doge", doge.getFirstName());
  }

  @Test
  void getLastName() {
    assertEquals("Inu", doge.getLastName());
  }

  @Test
  void testEquals() {
    assertTrue(doge.equals(doge) == doge.equals(doge));
    //test symmetry
    assertTrue(doge.equals(dogeCopy) == dogeCopy.equals(doge));
    //test transitivity
    assertTrue(doge.equals(dogeCopy) && dogeCopy.equals(imposterDoge) && doge.equals(imposterDoge));
    //test null reference
    assertFalse(doge.equals(null));
    //test consistency
    assertTrue(doge.equals(dogeCopy));
    assertTrue(doge.equals(dogeCopy));
    //test equals where equal should be false
    assertFalse(doge.equals(elong));
    assertFalse(elong.equals(dogeCopy));
  }

  @Test
  void testHashCode() {
    //test null
    assertFalse(0 == doge.hashCode());
    //test consistency
    int testHashCode = doge.hashCode();
    assertEquals(testHashCode, doge.hashCode());
  }

  @Test
  void testToString() {
    String expectedName =
        "Name{" +
            "firstName='" + "Doge" + '\'' +
            ", lastName='" + "Inu" + '\'' +
            '}';
    assertEquals(expectedName, doge.toString());
  }
}
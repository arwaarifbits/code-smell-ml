package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AuthorTest {
  private Author author1;
  private Author author1Copy;
  private Author author1Imposter;
  private Author author2;
  private RecordingArtist recordingArtist;
  @BeforeEach
  void setUp() {
    author1 = new Author("Mark","Twain");
    author1Copy = new Author("Mark","Twain");
    author1Imposter = new Author("Mark","Twain");
    author2 = new Author("George", "Martin");
    recordingArtist = new RecordingArtist("Mark", "Twain");
  }
  @Test
  void getFirstName() {
    assertEquals("Mark",author1.getFirstName());
  }

  @Test
  void getLastName() {
    assertEquals("Twain",author1.getLastName());
  }

  @Test
  void containCreator() {
    assertTrue(author1.containsCreator(author1));
    assertFalse(author1.containsCreator(author2));
    assertFalse(author1.containsCreator(recordingArtist));
  }

  @Test
  void testEquals() {
    assertTrue(author1.equals(author1) == author1.equals(author1));
    //test symmetry
    assertTrue(author1.equals(author1Copy) == author1.equals(author1Copy));
    //test transitivity
    assertTrue(author1.equals(author1Copy) && author1Copy.equals(author1Imposter)
        && author1Imposter.equals(author1));
    //test null reference
    assertFalse(author1.equals(null));
    //test consistency
    assertTrue(author1.equals(author1Copy));
    assertTrue(author1.equals(author1Copy));
    //test equals where equal should be false
    assertFalse(author1.equals(author2));
    assertFalse(author1.equals(recordingArtist));
  }

  @Test
  void testHashCode() {
    //test null
    assertFalse(0 == author1.hashCode());
    //test consistency
    int testHashCode = author1.hashCode();
    assertEquals(testHashCode, author1.hashCode());

  }

  @Test
  void testToString() {
    String expected = "Author{" +
        "firstName='" + "Mark" + '\'' +
        ", lastName='" + "Twain" + '\'' +
        '}';
    assertEquals(expected, author1.toString());
  }
}
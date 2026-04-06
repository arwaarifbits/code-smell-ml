package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BandTest {
  private Band band1;
  private Band band2;
  private Band band1Copy;
  private Band band1Imposter;
  private Book book1;
  private Author author1;
  private RecordingArtist recordingArtist1;
  private RecordingArtist recordingArtist2;
  private RecordingArtist recordingArtist3;
  @BeforeEach
  void setUp() {
    recordingArtist1 = new RecordingArtist("Shiraishi","Mai");
    recordingArtist2 = new RecordingArtist("Kaki", "Haruka");
    recordingArtist3 = new RecordingArtist("Nishino", "Nanase");
    ArrayList<RecordingArtist> members = new ArrayList<RecordingArtist>();
    members.add(recordingArtist1);
    members.add(recordingArtist2);
    members.add(recordingArtist3);
    band1 = new Band("ABC", members);
    band1Copy = new Band("ABC", members);
    band1Imposter = new Band("ABC", members);
    band2 = new Band("AB", members);
    band2.removeMember(recordingArtist2);
    author1 = new Author("Mark", "Twain");
    book1 = new Book(author1, "The Adventures of Tom Sawyer",1876);
  }

  @Test
  void addMember() {
    RecordingArtist recordingArtist = new RecordingArtist("Justin","Bieber");
    ArrayList<RecordingArtist> expected = new ArrayList<RecordingArtist>();
    expected.add(recordingArtist1);
    expected.add(recordingArtist3);
    expected.add(recordingArtist);
    band2.addMember(recordingArtist);
    assertEquals(expected, band2.getMembers());
  }

  @Test
  void removeMember() {
    ArrayList<RecordingArtist> expected = new ArrayList<RecordingArtist>();
    expected.add(recordingArtist1);
    expected.add(recordingArtist3);
    band1.removeMember(recordingArtist2);
    assertEquals(expected,band1.getMembers());
  }
  @Test
  void getName() {
    assertEquals("ABC",band1.getName());
  }

  @Test
  void containCreator() {
    assertTrue(band1.containsCreator(recordingArtist1));
    assertFalse(band2.containsCreator(recordingArtist2));
  }

  @Test
  void testEquals() {
    assertTrue(band1.equals(band1) == band1.equals(band1));
    //test symmetry
    assertTrue(band1.equals(band1Copy) == band1.equals(band1Copy));
    //test transitivity
    assertTrue(band1.equals(band1Copy) && band1Copy.equals(band1Imposter)
        && band1.equals(band1Imposter));
    //test null reference
    assertFalse(band1.equals(null));
    //test consistency
    assertTrue(band1.equals(band1Copy));
    assertTrue(band1.equals(band1Copy));
    //test equals where equal should be false
    assertFalse(band1.equals(band2));
    assertFalse(band1.equals(book1));
  }

  @Test
  void testHashCode() {
    //test null
    assertFalse(0 == band1.hashCode());
    //test consistency
    int testHashCode = band1.hashCode();
    assertEquals(testHashCode, band1.hashCode());
  }


  @Test
  void testToString() {
    String expected = "Band{" +
        "name='" + "AB" + '\'' +
        ", members=" + "[RecordingArtist{firstName='Shiraishi', lastName='Mai'}, "
        + "RecordingArtist{firstName='Nishino', lastName='Nanase'}]" +
        '}';
    assertEquals(expected,band2.toString());
  }
}
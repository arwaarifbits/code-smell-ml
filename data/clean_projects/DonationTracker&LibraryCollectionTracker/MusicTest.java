package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MusicTest {

  private Music musicWithBand;
  private Music music1;
  private Music music1Copy;
  private Music music1Imposter;
  private Band band1;
  private RecordingArtist recordingArtist1;
  private RecordingArtist recordingArtist2;
  private RecordingArtist recordingArtist3;

  @BeforeEach
  void setUp() {
    recordingArtist1 = new RecordingArtist("Justin", "Bieber");
    recordingArtist2 = new RecordingArtist("Shiraishi", "Mai");
    recordingArtist3 = new RecordingArtist("Nishino", "Nanase");
    music1 = new Music(recordingArtist1, "Baby", 2010);
    music1Copy = new Music(recordingArtist1, "Baby", 2010);
    music1Imposter = new Music(recordingArtist1, "Baby", 2010);
    ArrayList<RecordingArtist> members = new ArrayList<RecordingArtist>();
    members.add(recordingArtist2);
    members.add(recordingArtist3);
    band1 = new Band("Nogizaka46", members);
    musicWithBand = new Music(band1, "Influencer", 2017);
  }

  @Test
  void getCreator() {
    assertEquals(recordingArtist1, music1.getCreator());
    assertEquals(band1, musicWithBand.getCreator());
  }

  @Test
  void getTitle() {
    assertEquals("Baby", music1.getTitle());
    assertEquals("Influencer", musicWithBand.getTitle());
  }

  @Test
  void getReleasedYear() {
    assertEquals(2010, music1.getReleasedYear());
    assertEquals(2017, musicWithBand.getReleasedYear());
  }

  @Test
  void containKeyword() {
    assertTrue(music1.containKeyword("B"));
    assertFalse(music1.containKeyword("z"));
  }

  @Test
  void testEquals() {
    assertTrue(music1.equals(music1) == music1.equals(music1));
    //test symmetry
    assertTrue(music1.equals(music1Copy) == music1.equals(music1Copy));
    //test transitivity
    assertTrue(music1.equals(music1Copy) && music1Imposter.equals(music1Copy)
        && music1Imposter.equals(music1));
    //test null reference
    assertFalse(music1.equals(null));
    //test consistency
    assertTrue(music1.equals(music1Copy));
    assertTrue(music1.equals(music1Copy));
    //test equals where equal should be false
    assertFalse(musicWithBand.equals(music1));
  }

  @Test
  void testHashCode() {
    //test null
    assertFalse(0 == music1.hashCode());
    //test consistency
    int testHashCode = music1.hashCode();
    assertEquals(testHashCode, music1.hashCode());
  }

  @Test
  void testToString() {
    String expected = "Music{" +
        "creator=" + "RecordingArtist{" +
        "firstName='" + "Justin" + '\'' +
        ", lastName='" + "Bieber" + '\'' +
        '}' +
        ", title='" + "Baby" + '\'' +
        ", releasedYear=" + "2010" +
        '}';
    assertEquals(expected, music1.toString());
  }
}
package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecordingArtistTest {
  private RecordingArtist recordingArtist1;
  @BeforeEach
  void setUp() {
    recordingArtist1 = new RecordingArtist("Justin","Bieber");
  }

  @Test
  void containCreator(){
    assertTrue(recordingArtist1.containsCreator(recordingArtist1));
  }
  @Test
  void testToString() {
    String expected = "RecordingArtist{" +
        "firstName='" + "Justin" + '\'' +
        ", lastName='" + "Bieber" + '\'' +
        '}';
    assertEquals(expected, recordingArtist1.toString());
  }
}
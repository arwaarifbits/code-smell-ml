package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MusicianTest {
  private Musician musician;
  private Name doge;
  private String[] genre = {"A"};
  private String[] award = {"A", "A"};
  private String[] awardUpdated  = {"A", "A", "A"};
  @BeforeEach
  void setUp() throws InvalidAgeException {
    doge = new Name("doge","inu");
    musician = new Musician(doge,22, genre, award, "ABC","CD" );
  }

  @Test
  void receiveAward() throws InvalidAgeException {
    Musician updated = musician.receiveAward("A");
    assertEquals(3, updated.getAward().length);
    assertEquals("A", updated.getAward()[2]);
  }

  @Test
  void getRecordCompany() {
    assertEquals("ABC", musician.getRecordCompany());
  }

  @Test
  void getRecordAlbum() {
    assertEquals("CD",musician.getRecordAlbum());
  }
}
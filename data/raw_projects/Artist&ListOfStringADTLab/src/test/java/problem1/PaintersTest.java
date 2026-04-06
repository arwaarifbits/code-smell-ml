package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaintersTest {

  private Painters painter;
  private String[] genre = {"A"};
  private String[] award = {"A", "A"};
  private String[] awardUpdated = {"A", "A", "A"};
  private String[] exhibits = {"ABC2", "ABC1", "ABC"};
  private Name name;

  @BeforeEach
  void setUp() throws InvalidAgeException {
    name = new Name("doge", "inu");
    painter = new Painters(name, 40, genre, award, exhibits);
  }

  @Test
  void receiveAward() throws InvalidAgeException {
    FineArtPerson updated = painter.receiveAward("A");
    assertEquals(3, updated.getAward().length);
    assertEquals("A", updated.getAward()[2]);
  }

  @Test
  void getExhibits() {
    assertEquals(exhibits, painter.getExhibits());
  }
}
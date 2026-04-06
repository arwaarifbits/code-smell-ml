package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PoetTest {

  private Poet poet;
  private Name doge;
  private String[] genre = {"A"};
  private String[] award = {"A", "A"};
  private String[] awardUpdated = {"A", "A", "A"};

  @BeforeEach
  void setUp() throws InvalidAgeException {
    doge = new Name("doge", "inu");
    poet = new Poet(doge, 22, genre, award, "NewWorld", "Beauty");
  }


  @Test
  void receiveAward() throws InvalidAgeException {
    Poet updated = poet.receiveAward("A");
    assertEquals(3, updated.getAward().length);
    assertEquals("A", updated.getAward()[2]);
  }

  @Test
  void getPublishingCompany() {
    assertEquals("NewWorld", poet.getPublishingCompany());
  }

  @Test
  void getLastPublishedCollection() {
    assertEquals("Beauty", poet.getLastPublishedCollection());
  }
}
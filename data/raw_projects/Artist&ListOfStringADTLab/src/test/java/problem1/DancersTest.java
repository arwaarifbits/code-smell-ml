package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DancersTest {

  private Dancers dancer;
  private String[] genre = {"A"};
  private String[] award = {"A", "A"};
  private String[] awardUpdated = {"A", "A", "A"};
  private String[] movies = {"ABC2", "ABC1", "ABC"};
  private String[] series = {"BigBoom"};
  private String[] media = {"Funny"};
  private Name name;
  private Dancers largeAge;
  private Dancers smallAge;
  @BeforeEach
  void setUp() throws InvalidAgeException {
    name = new Name("doge", "baby");
    dancer = new Dancers(name,30,genre,award,movies,series,media);
  }

  @Test
  void invalidAge(){
    assertThrows(InvalidAgeException.class, ()->{largeAge = new Dancers(name,200,genre,award,movies,series,media);});
    assertThrows(InvalidAgeException.class, ()->{largeAge = new Dancers(name,-10,genre,award,movies,series,media);});
  }

  @Test
  void getMovies(){
    assertEquals(movies,dancer.getMovies());
  }

  @Test
  void getSeries(){
    assertEquals(series,dancer.getSeries());
  }

  @Test
  void getMedia(){
    assertEquals(media,dancer.getMultimedia());
  }

  @Test
  void getGenre(){
    assertEquals(genre,dancer.getGenres());
  }

  @Test
  void getAge(){
    assertEquals(30,dancer.getAge());
  }

  @Test
  void getName(){
    assertEquals("doge",dancer.getName().getFirstName());
    assertEquals("baby",dancer.getName().getLastName());
  }

  @Test
  void getAward(){
    assertEquals(award,dancer.getAward());
  }

  @Test
  void receiveAward() throws InvalidAgeException {
    ActingPerson updated = dancer.receiveAward("A");
    assertEquals(3, updated.getAward().length);
    assertEquals("A",updated.getAward()[2]);
  }
}
package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {

  private Book book1;
  private Author author1;

  @BeforeEach
  void setUp() {
    author1 = new Author("Mark", "Twain");
    book1 = new Book(author1, "The Adventures of Tom Sawyer", 1876);
  }

  @Test
  void testToString() {
    String expected = "Book{" +
        "creator=" + "Author{" +
        "firstName='" + "Mark" + '\'' +
        ", lastName='" + "Twain" + '\'' +
        '}' + ", title='" + "The Adventures of Tom Sawyer" + '\'' +
        ", releasedYear=" + "1876" +
        '}';
    assertEquals(expected, book1.toString());
  }
}
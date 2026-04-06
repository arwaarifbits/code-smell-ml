package problem2;

/**
 * This is a Book class which is the subclass of the Item. Represent the Book.
 */
public class Book extends Item {

  /**
   * Constructor for book with author, title and releasedYear
   *
   * @param author       - book's author, Author
   * @param title        - book's title, string
   * @param releasedYear - book's releasedYear, integer
   */
  public Book(Author author, String title, Integer releasedYear) {
    super(author, title, releasedYear);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Book{" +
        "creator=" + creator +
        ", title='" + title + '\'' +
        ", releasedYear=" + releasedYear +
        '}';
  }
}

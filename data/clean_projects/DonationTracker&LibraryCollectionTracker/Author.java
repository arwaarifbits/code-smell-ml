package problem2;

/**
 * This is an Author class which is the subclass of the IndividualPerson Represent the Author.
 */
public class Author extends IndividualPerson {

  /**
   * Constructor for Author with firstName and LastName
   *
   * @param firstName - Author firstName, string
   * @param lastName  - Author lastName, string
   */
  public Author(String firstName, String lastName) {
    super(firstName, lastName);
  }

  /**
   * Check whether the Author contain the given creator
   *
   * @param creator - the creator wanted to check, Creator
   * @return true if Author is equal to the given creator otherwise false, boolean
   */
  @Override
  public boolean containsCreator(Creator creator) {
    return this.equals(creator);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Author{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}

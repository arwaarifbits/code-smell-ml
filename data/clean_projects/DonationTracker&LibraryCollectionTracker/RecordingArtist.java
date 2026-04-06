package problem2;

/**
 * This is a RecordingArtist class which is the subclass of the IndividualPerson. Represent the
 * Recording Artist.
 */
public class RecordingArtist extends IndividualPerson {

  /**
   * Constructor for RecordingArtist with firstName and lastName
   *
   * @param firstName - RecordingArtist first name, string
   * @param lastName  - RecordingArtist last name, string
   */
  public RecordingArtist(String firstName, String lastName) {
    super(firstName, lastName);
  }

  /**
   * Check whether the RecordingArtist contain the given creator
   *
   * @param creator - the creator wanted to check, Creator
   * @return true if RecordingArtist is equal to the given creator otherwise false, boolean
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
    return "RecordingArtist{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}

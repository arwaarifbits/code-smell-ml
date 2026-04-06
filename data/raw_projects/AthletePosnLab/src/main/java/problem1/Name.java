package problem1;

/**
 * Class Name contains information about an athlete' name, including athlete's first, middle and
 * last name.
 */
public class Name {

  private String firstName;
  private String middleName;
  private String lastName;

  /**
   * Constructs a new Name, based upon all of the provided input parameters.
   *
   * @param firstName  - athlete's first name
   * @param middleName - athlete's middle name
   * @param lastName   - athlete's last name
   */
  public Name(String firstName, String middleName, String lastName) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
  }

  /**
   * Returns the first name of this Name
   *
   * @return The first name of this Name, as String
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Sets the first name of this Name
   *
   * @param firstName The new first name, as String
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Returns the middle name of this Name
   *
   * @return The middle name of this Name, as String
   */
  public String getMiddleName() {
    return middleName;
  }

  /**
   * Sets the middle name of this Name
   *
   * @param middleName The new middle name, as String
   */
  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  /**
   * Returns the last name of this Name
   *
   * @return The last name of this Name, as String
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Sets the last name of this Name
   *
   * @param lastName The new last name, as String
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


}



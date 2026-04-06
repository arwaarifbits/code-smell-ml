package problem1;

/**
 * Owner is a simple object that has a unique first name, last name and phone number
 */
public class Owner {

  private String firstName;
  private String lastName;
  private String phoneNumber;

  /**
   * Constructor that creates a new owner object with the specified first name, last name and phone
   * number
   *
   * @param firstName   - first name of the new owner object.
   * @param lastName    - last name of the new owner object.
   * @param phoneNumber - phone number of the new owner object.
   */
  public Owner(final String firstName, final String lastName, final String phoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
  }

  /**
   * Returns the firstName of the Owner.
   *
   * @return the firstName of the Owner.
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Returns the lastName of the Owner.
   *
   * @return the LastName of the Owner.
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Returns the phoneNumber of the Owner.
   *
   * @return the phoneNumber of the Owner.
   */
  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  /**
   * Sets the firstName of the Owner.
   *
   * @param firstName - first name of the new owner object.
   */
  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  /**
   * Sets the lastName of the Owner.
   *
   * @param lastName - last name of the new owner object.
   */
  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  /**
   * Sets the phoneNumber of the Owner.
   *
   * @param phoneNumber - phone number of the new owner object.
   */
  public void setPhoneNumber(final String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}



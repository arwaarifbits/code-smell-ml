package assignment2.problem2;

import java.util.Objects;

/**
 * This is a recipient class which represent a recipient object with first name, last name and an
 * email address.
 */
public class Recipient {

  private String firstName;
  private String lastName;
  private String emailAddress;

  /**
   * Constructor for recipient object with specific first name, last name and email address
   *
   * @param firstName    - recipient's first name, string
   * @param lastName     - recipient's last name, string
   * @param emailAddress - recipient's email address, string
   */
  public Recipient(String firstName, String lastName, String emailAddress) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailAddress = emailAddress;
  }

  /**
   * Returns the first name of the recipient
   *
   * @return the first name of the recipient, string.
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Returns last name of the recipient
   *
   * @return last name of the recipient, string
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Returns the email address of the recipient
   *
   * @return the email address of the recipient, string
   */
  public String getEmailAddress() {
    return this.emailAddress;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Recipient recipient = (Recipient) o;
    return firstName.equals(recipient.firstName) && lastName.equals(recipient.lastName)
        && emailAddress.equals(recipient.emailAddress);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, emailAddress);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Recipient{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", emailAddress='" + emailAddress + '\'' +
        '}';
  }
}

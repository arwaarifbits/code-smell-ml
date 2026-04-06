package problem1;

import java.util.Objects;

/**
 * This a Name class represent a name object with first name and last name.
 */
public class Name {
  private String firstName;
  private String lastName;

  /**
   * Constructor for Name, a name object with specific first name and last name
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Return the first name, string
   * @return the first name
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Return the last name, string
   * @return the last name
   */
  public String getLastName() {
    return this.lastName;
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
    Name name = (Name) o;
    return firstName.equals(name.firstName) && lastName.equals(name.lastName);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Name{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}

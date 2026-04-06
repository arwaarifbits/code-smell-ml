package problem2;

import java.util.Objects;

/**
 * Name is an object that contains first name and last name.
 */
public class Name {
  private String firstName;
  private String lastName;

  /**
   * Constructor that creates a new name object with the specified first name, last name
   *
   * @param firstName   - first name of the new name object.
   * @param lastName    - last name of the new name object.
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Returns the firstName of the Name.
   *
   * @return the firstName of the Name.
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Returns the lastName of the Name.
   *
   * @return the lastName of the Name.
   */
  public String getLastName() {
    return this.lastName;
  }


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

  @Override
  public int hashCode() {
    return Objects.hash(this.firstName, this.lastName);
  }

  @Override
  public String toString() {
    return "Name{" +
        "firstName='" + this.firstName + '\'' +
        ", lastName='" + this.lastName + '\'' +
        '}';
  }
}

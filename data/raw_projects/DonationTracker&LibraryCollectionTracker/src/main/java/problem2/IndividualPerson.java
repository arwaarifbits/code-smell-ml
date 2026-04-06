package problem2;

import java.util.Objects;

/**
 * This is an abstract class for IndividualPerson with firstName and lastName
 */
public abstract class IndividualPerson implements Creator {

  /**
   * First Name field
   */
  protected String firstName;
  /**
   * Second Name field
   */
  protected String lastName;

  /**
   * Constructor for IndividualPerson with firstName and lastName
   *
   * @param firstName - first name, string
   * @param lastName  - second name, string
   */
  public IndividualPerson(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Get the first name
   *
   * @return firstName, string
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Get the last name
   *
   * @return lastName, string
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
    IndividualPerson individualPerson = (IndividualPerson) o;
    return firstName.equals(individualPerson.firstName) && lastName.equals(
        individualPerson.lastName);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

}

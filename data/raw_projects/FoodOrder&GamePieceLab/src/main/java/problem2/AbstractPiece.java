package problem2;

import java.util.Objects;

/**
 * This is an abstract class for Piece with specific info name and age.
 */
public abstract class AbstractPiece implements Piece {

  private Name name;
  private Integer age;
  private static final Integer ageMin = 0;
  private static final Integer ageMax = 128;

  /**
   * Constructor for the AbstractPiece class. This is an abstract class.
   *
   * @param name - The name of the piece, Name class.
   * @param age  - The age of the piece, Integer.
   * @throws IncorrectAgeException if the age is out of range
   */

  public AbstractPiece(Name name, Integer age) throws IncorrectAgeException {
    this.name = name;
    this.isValidAge(age);
    this.age = age;
  }

  /**
   * Check whether the age is valid
   *
   * @param age Piece's age, Integer
   * @throws IncorrectAgeException if the age is less than 0 or large than 128
   */
  private void isValidAge(int age) throws IncorrectAgeException {
    if (age < ageMin || age > ageMax) {
      throw new IncorrectAgeException("Out of Age bound!");
    }
  }

  /**
   * Returns the Name of the AbstractPiece.
   *
   * @return the Name of the AbstractPiece.Name class.
   */
  public Name getName() {
    return this.name;
  }

  /**
   * Returns the age of the AbstractPiece.
   *
   * @return the age of the AbstractPiece. Integer
   */
  public Integer getAge() {
    return this.age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractPiece that = (AbstractPiece) o;
    return this.name.equals(that.name) && this.age.equals(that.age);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.name, this.age);
  }

  @Override
  public String toString() {
    return "AbstractPiece{" +
        "name='" + this.name + '\'' +
        ", age=" + this.age +
        '}';
  }
}

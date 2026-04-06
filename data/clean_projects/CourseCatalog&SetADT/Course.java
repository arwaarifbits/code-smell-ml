package problem1;

import java.util.Objects;

/**
 * This is a Course class. Represent a course with name, prefix and number
 */
public class Course {

  private final String name;
  private final String prefix;
  private final int number;

  /**
   * Constructor for the class. Create a course object with specific name, prefix and number
   *
   * @param name   - name of the course, string
   * @param prefix - prefix of the course, string
   * @param number - number of the course, integer
   */
  public Course(String name, String prefix, int number) {
    this.name = name;
    this.prefix = prefix;
    this.number = number;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return prefix + number + ": " + name;
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
    Course course = (Course) o;
    return number == course.number &&
        name.equals(course.name) &&
        prefix.equals(course.prefix);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, prefix, number);
  }


}

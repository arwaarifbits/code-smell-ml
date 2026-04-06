package problem1;

import java.util.Arrays;
import java.util.Objects;

/**
 * This is an abstract and master class for Artist. An artist with Name, Age, Genres and Awards
 */
public abstract class AbstractArtist implements Artist {

  private Name name;
  private Integer age;
  private String[] genres;
  private String[] award;
  private static final Integer MIN = 0;
  private static final Integer MAX = 128;

  /**
   * Constructor for AbstractArtist, with specific name, age, genres, award
   *
   * @param name   - Artist's Name, Name class
   * @param age    - Artist's Age, Integer
   * @param genres - representing an Artist’s genres, string array
   * @param award  - representing all awards that an Artist received, string array
   * @throws InvalidAgeException when age out of range
   */
  public AbstractArtist(Name name, Integer age, String[] genres, String[] award)
      throws InvalidAgeException {
    this.name = name;
    this.isValidAge(age);
    this.age = age;
    this.genres = genres;
    this.award = award;
  }

  /**
   * Check whether the age of the artist is valid
   *
   * @param age - Artist's Age, integer
   * @throws InvalidAgeException when age is out of the range
   */
  private void isValidAge(int age) throws InvalidAgeException {
    if (age < MIN) {
      throw new InvalidAgeException("Age can not be negative !");
    } else if (age > MAX) {
      throw new InvalidAgeException("Age cannot be larger than 128!");
    }
  }

  /**
   * Return the name, name class
   *
   * @return the name
   */
  public Name getName() {
    return this.name;
  }

  /**
   * Return the age, integer
   *
   * @return the age
   */
  public Integer getAge() {
    return this.age;
  }

  /**
   * Return the genre, string array
   *
   * @return the genre
   */
  public String[] getGenres() {
    return genres;
  }

  /**
   * Return the award, string array
   *
   * @return the award
   */
  public String[] getAward() {
    return award;
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
    AbstractArtist that = (AbstractArtist) o;
    return name.equals(that.name) && age.equals(that.age) && Arrays.equals(genres,
        that.genres) && Arrays.equals(award, that.award);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    int result = Objects.hash(name, age);
    result = 31 * result + Arrays.hashCode(genres);
    result = 31 * result + Arrays.hashCode(award);
    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "AbstractArtist{" +
        "name=" + name +
        ", age=" + age +
        ", genres=" + Arrays.toString(genres) +
        ", award=" + Arrays.toString(award) +
        '}';
  }
}


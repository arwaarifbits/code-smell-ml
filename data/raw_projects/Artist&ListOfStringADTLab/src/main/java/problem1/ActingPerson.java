package problem1;

import java.util.Arrays;

/**
 * This is ActingPerson class and subclass of AbstractArtist. Represent any of Actor, Dancer,
 * Filmmakers with three more fields, movies, series, multimedia
 */
public class ActingPerson extends AbstractArtist {

  private String[] movies;
  private String[] series;
  private String[] multimedia;

  /**
   * Constructor for ActingPerson, Represent any of Actor, Dancer, Filmmakers with three more
   * specific fields, movies, series, multimedia
   *
   * @param name       - ActingPerson's Name, Name class
   * @param age        - ActingPerson's Age, Integer
   * @param genres     - representing an ActingPerson’s genres, string array
   * @param award      - representing all awards that an ActingPerson received, string array
   * @param movies     - listing all movies that they worked on (acted in), string array
   * @param series     - listing all TV series that they worked on (acted in), string array
   * @param multimedia - listing all other multimedia content that they worked on (acted in), string
   *                   array
   * @throws InvalidAgeException when age out of field
   */
  public ActingPerson(Name name, Integer age, String[] genres, String[] award,
      String[] movies, String[] series, String[] multimedia) throws InvalidAgeException {
    super(name, age, genres, award);
    this.movies = movies;
    this.series = series;
    this.multimedia = multimedia;
  }

  /**
   * add the award to their current array of awards,
   * @param award - the award that will be added
   * @return A copy ActingPerson object with updated array of awards.
   */
  @Override
  public ActingPerson receiveAward(String award) throws InvalidAgeException {
    int originalAwardLength = this.getAward().length;
    String[] newAwardList = new String[originalAwardLength + 1];
    System.arraycopy(this.getAward(), 0, newAwardList,0, originalAwardLength);
    newAwardList[newAwardList.length-1] = award;
    return new ActingPerson(this.getName(),this.getAge(),this.getGenres(),newAwardList,this.movies,this.series,this.multimedia);
  }

  /**
   * Return the movie, string array
   * @return the movie
   */
  public String[] getMovies() {
    return this.movies;
  }

  /**
   * Return the series, string array
   * @return the movie
   */
  public String[] getSeries() {
    return this.series;
  }

  /**
   * Return the multimedia, string array
   * @return the multimedia
   */
  public String[] getMultimedia() {
    return this.multimedia;
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
    if (!super.equals(o)) {
      return false;
    }
    ActingPerson that = (ActingPerson) o;
    return Arrays.equals(movies, that.movies) && Arrays.equals(series,
        that.series) && Arrays.equals(multimedia, that.multimedia);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + Arrays.hashCode(movies);
    result = 31 * result + Arrays.hashCode(series);
    result = 31 * result + Arrays.hashCode(multimedia);
    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "ActingPerson{" +
        "movies=" + Arrays.toString(movies) +
        ", series=" + Arrays.toString(series) +
        ", multimedia=" + Arrays.toString(multimedia) +
        '}';
  }
}


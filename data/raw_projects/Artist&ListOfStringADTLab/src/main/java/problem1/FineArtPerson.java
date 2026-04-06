package problem1;

import java.util.Arrays;

/**
 * This is FineArtPerson class and subclass of AbstractArtist. Represent any of Painters and
 * Photographers with one more field, exhibits
 */
public class FineArtPerson extends AbstractArtist {
  private String[] exhibits;

  /**
   * Constructor for FineArtPerson, Represent any of Painters and Photographers with one more
   * specific field, exhibit
   *
   * @param name       - ActingPerson's Name, Name class
   * @param age        - ActingPerson's Age, Integer
   * @param genres     - representing an ActingPerson’s genres, string array
   * @param award      - representing all awards that an ActingPerson received, string array
   * @param exhibits   - all exhibits where their art was shown, string array
   * @throws InvalidAgeException when age out of field
   */
  public FineArtPerson(Name name, Integer age, String[] genres, String[] award, String[] exhibits)
      throws InvalidAgeException {
    super(name, age, genres, award);
    this.exhibits = exhibits;
  }

  /**
   * add the award to their current array of awards,
   * @param award - the award that will be added
   * @return A copy FineArtPerson object with updated array of awards.
   */
  @Override
  public FineArtPerson receiveAward(String award) throws InvalidAgeException {
    int originalAwardLength = this.getAward().length;
    String[] newAwardList = new String[originalAwardLength + 1];
    System.arraycopy(this.getAward(), 0, newAwardList,0, originalAwardLength);
    newAwardList[newAwardList.length-1] = award;
    return new FineArtPerson(this.getName(),this.getAge(),this.getGenres(),newAwardList,this.exhibits);
  }

  /**
   * Return the exhibits, String array
   * @return the exhibits
   */
  public String[] getExhibits() {
    return this.exhibits;
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
    FineArtPerson that = (FineArtPerson) o;
    return Arrays.equals(exhibits, that.exhibits);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + Arrays.hashCode(exhibits);
    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "FineArtPerson{" +
        "exhibits=" + Arrays.toString(exhibits) +
        '}';
  }
}

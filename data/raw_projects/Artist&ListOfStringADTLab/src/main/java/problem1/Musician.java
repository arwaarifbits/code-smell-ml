package problem1;

import java.util.Objects;

/**
 * This is Musician class and subclass of AbstractArtist. Represent Musician with two more fields,
 * recordCompany and recordAlbum
 */
public class Musician extends AbstractArtist{
  private String recordCompany;
  private String recordAlbum;
  /**
   * Constructor for Musician, Represent musician with two more fields,
   * recordCompany and recordAlbum
   *
   * @param name       - Name, name class
   * @param age        - age, integer
   * @param genres     - genres, string array
   * @param award      - all award, string array
   * @param recordCompany   - a Musician’s recording company, string
   * @param recordAlbum  -  the title of the latest recorded album, string
   * @throws InvalidAgeException when age out of range
   */
  public Musician(Name name, Integer age, String[] genres, String[] award,
      String recordCompany, String recordAlbum) throws InvalidAgeException {
    super(name, age, genres, award);
    this.recordCompany = recordCompany;
    this.recordAlbum = recordAlbum;
  }

  /**
   * add the award to their current array of awards,
   * @param award - the award that will be added
   * @return A copy Musician object with updated array of awards.
   */
  @Override
  public Musician receiveAward(String award) throws InvalidAgeException {
    int originalAwardLength = this.getAward().length;
    String[] newAwardList = new String[originalAwardLength + 1];
    System.arraycopy(this.getAward(), 0, newAwardList,0, originalAwardLength);
    newAwardList[newAwardList.length-1] = award;
    return new Musician(this.getName(),this.getAge(),this.getGenres(),newAwardList,this.recordCompany, this.recordAlbum);
  }

  /**
   * Return a Musician’s recording company, string
   * @return recordCompany
   */
  public String getRecordCompany() {
    return this.recordCompany;
  }

  /**
   * Return the title of the latest recorded album, string
   * @return recordAlbum
   */
  public String getRecordAlbum() {
    return this.recordAlbum;
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
    Musician musician = (Musician) o;
    return recordCompany.equals(musician.recordCompany) && recordAlbum.equals(musician.recordAlbum);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), recordCompany, recordAlbum);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Musician{" +
        "recordCompany='" + recordCompany + '\'' +
        ", recordAlbum='" + recordAlbum + '\'' +
        '}';
  }
}

package problem1;

import java.util.Objects;

public class Poet extends AbstractArtist{
  private String publishingCompany;
  private String lastPublishedCollection;

  /**
   * Constructor for Poet, Represent poet with two more fields,
   * publishingCompany, lastPublishedCollection
   *
   * @param name       - Name, name class
   * @param age        - age, integer
   * @param genres     - genres, string array
   * @param award      - all award, string array
   * @param publishingCompany   -  Poet’s publishing company, string
   * @param lastPublishedCollection  -  the title of the latest published collection of poems, string
   * @throws InvalidAgeException when age out of range
   */
  public Poet(Name name, Integer age, String[] genres, String[] award,
      String publishingCompany, String lastPublishedCollection) throws InvalidAgeException {
    super(name, age, genres, award);
    this.publishingCompany = publishingCompany;
    this.lastPublishedCollection = lastPublishedCollection;
  }

  /**
   * add the award to their current array of awards,
   * @param award - the award that will be added
   * @return A copy Poet object with updated array of awards.
   */
  @Override
  public Poet receiveAward(String award) throws InvalidAgeException {
    int originalAwardLength = this.getAward().length;
    String[] newAwardList = new String[originalAwardLength + 1];
    System.arraycopy(this.getAward(), 0, newAwardList,0, originalAwardLength);
    newAwardList[newAwardList.length-1] = award;
    return new Poet(this.getName(),this.getAge(),this.getGenres(),newAwardList,this.publishingCompany, this.lastPublishedCollection);
  }

  /**
   * Return the Poet’s publishing company, string
   * @return publishingCompany
   */
  public String getPublishingCompany() {
    return this.publishingCompany;
  }

  /**
   * Return the title of the latest published collection of poems, string
   * @return lastPublishedCollection
   */
  public String getLastPublishedCollection() {
    return this.lastPublishedCollection;
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
    Poet poet = (Poet) o;
    return publishingCompany.equals(poet.publishingCompany) && lastPublishedCollection.equals(
        poet.lastPublishedCollection);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), publishingCompany, lastPublishedCollection);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Poet{" +
        "publishingCompany='" + publishingCompany + '\'' +
        ", lastPublishedCollection='" + lastPublishedCollection + '\'' +
        '}';
  }

}

package problem1;
/**
 * This is Photographers class which is the subclass of the FineArtPerson with name, age, genres, award,
 * exhibits
 */
public class Photographers extends FineArtPerson{
  /**
   * Constructor for Photographers, photographers object with name, age, genres, award, exhibit
   *
   * @param name       - Name, name class
   * @param age        - age, integer
   * @param genres     - genres, string array
   * @param award      - all award, string array
   * @param exhibits   - all exhibits, string array
   * @throws InvalidAgeException when age is out of range
   */
  public Photographers(Name name, Integer age, String[] genres, String[] award,
      String[] exhibits) throws InvalidAgeException {
    super(name, age, genres, award, exhibits);
  }
}

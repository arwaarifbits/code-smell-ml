package problem1;

/**
 * An interface that all Artists can receive an award, which gets added to their current array of
 * awards.
 */
public interface Artist {
  /**
   * The receiving an award behavior
   *
   * @param award - The award will be added
   * @throws InvalidAgeException if age out of range
   * @return the copy of this Artist with updated award list
   */
  Artist receiveAward(String award) throws InvalidAgeException;
}

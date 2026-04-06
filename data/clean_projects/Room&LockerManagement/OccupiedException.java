package assignment2.problem2;

/**
 * Throw OccupiedException when the mail item is not Null.
 */
public class OccupiedException extends Exception {

  /**
   * Constructor for OccupiedException
   *
   * @param message - the message will be given based on the exception.
   */
  public OccupiedException(String message) {
    super(message);
  }
}

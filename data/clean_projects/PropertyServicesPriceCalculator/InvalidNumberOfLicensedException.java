package problem1;

/**
 * Throw InvalidNumberOfLicensedException when number of licensed worker is out of range.
 */
public class InvalidNumberOfLicensedException extends Exception {

  /**
   * Constructor for InvalidNumberOfLicensedException
   *
   * @param message - message based on given Exception
   */
  public InvalidNumberOfLicensedException(String message) {
    super(message);
  }
}

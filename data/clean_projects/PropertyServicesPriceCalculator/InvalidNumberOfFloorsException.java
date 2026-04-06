package problem1;

/**
 * Throw InvalidNumberOfFloorsException when floor number is out of range.
 */
public class InvalidNumberOfFloorsException extends Exception {

  /**
   * Constructor for InvalidNumberOfFloorsException
   *
   * @param message - message based on the given exception
   */
  public InvalidNumberOfFloorsException(String message) {
    super(message);
  }
}

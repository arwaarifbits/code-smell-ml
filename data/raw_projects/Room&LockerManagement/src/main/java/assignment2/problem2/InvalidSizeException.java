package assignment2.problem2;

/**
 * Throw InvalidSizeException when the width or height or depth smaller than 1.
 */
public class InvalidSizeException extends Exception {

  /**
   * Constructor for InvalidSizeException
   *
   * @param message - the message will be given, string
   */
  public InvalidSizeException(String message) {
    super(message);
  }
}

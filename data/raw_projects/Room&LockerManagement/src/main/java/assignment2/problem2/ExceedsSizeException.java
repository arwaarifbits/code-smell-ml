package assignment2.problem2;

/**
 * Throw ExceedsSizeException when the size of mail item exceeds the max size of locker
 */
public class ExceedsSizeException extends Exception {

  /**
   * Constructor for ExceedsSizeException
   *
   * @param message - the message will be given, string
   */
  public ExceedsSizeException(String message) {
    super(message);
  }
}

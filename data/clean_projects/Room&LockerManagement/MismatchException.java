package assignment2.problem2;

/**
 * Throws MismatchException when the recipient mismatches the recipient of the mail item.
 */
public class MismatchException extends Exception {

  /**
   * Constructor for the MismatchException
   *
   * @param message - the message will be given based on the exception, string
   */
  public MismatchException(String message) {
    super(message);
  }
}

package assignment2.problem2;

/**
 * Throw EmptyException when the locker's mail item is Null.
 */
public class EmptyException extends Exception {

  /**
   * Constructor for EmptyException
   *
   * @param message - the message will be given, string
   */
  public EmptyException(String message) {
    super(message);
  }
}

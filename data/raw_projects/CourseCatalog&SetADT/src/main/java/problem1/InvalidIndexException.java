package problem1;
/**
 * This is InvalidIndexException, throw a InvalidIndexException if the index not exist.
 */
public class InvalidIndexException extends Exception{

  /**
   * Constructor for InvalidIndexException
   * @param message - the message will be given when index not found
   */
  public InvalidIndexException(String message) {
    super(message);
  }
}

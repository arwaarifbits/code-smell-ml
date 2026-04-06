package assignment2.problem1;
/**
 * Throw InvalidGuestNumberException when the number of guests that would like to
 * stay in the room out of range
 */
public class InvalidGuestNumberException extends Exception{
  /**
   * Constructor for InvalidGuestNumberException
   * @param message - message based on different exception, String
   */
  public InvalidGuestNumberException(String message) {
    super(message);
  }
}

package assignment2.problem1;
/**
 * Throw InvalidRoomException when the room is not free.
 */
public class InvalidRoomException extends Exception{
  /**
   * Constructor for InvalidRoomException
   * @param message - message will be given based on the exception, String
   */
  public InvalidRoomException(String message) {
    super(message);
  }
}

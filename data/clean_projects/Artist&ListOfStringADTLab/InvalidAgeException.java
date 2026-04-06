package problem1;

/**
 * This is a InvalidAgeException class which will throw the exception when age out of range
 */
public class InvalidAgeException extends Exception {

  /**
   * Constructor for InvalidAgeException
   *
   * @param message - message will be thrown when exception happens
   */
  public InvalidAgeException(String message) {
    super(message);
  }
}

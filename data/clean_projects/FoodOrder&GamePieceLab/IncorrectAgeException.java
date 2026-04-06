package problem2;
/**
 * Throw IncorrectAgeException when age is out of range.
 */
public class IncorrectAgeException extends Exception{
  /**
   * Throw IncorrectAgeException when age is out of range.
   * @param message - message based on different Exception
   */
  public IncorrectAgeException(String message) {
    super(message);
  }
}

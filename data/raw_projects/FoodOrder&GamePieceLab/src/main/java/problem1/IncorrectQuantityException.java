package problem1;
/**
 * Throw IncorrectQuantityException when available quantity out of range
 */
public class IncorrectQuantityException extends Exception{
  /**
   * Throw IncorrectQuantityException when available quantity out of range
   * @param message - message based on different Exception
   */
  public IncorrectQuantityException(String message) {
    super(message);
  }
}

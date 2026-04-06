package problem2;
/**
 * Throw IncorrectWealthAmountException when available wealth out of range
 */
public class IncorrectWealthAmountException extends Exception{
  /**
   * Throw IncorrectWealthAmountException when available wealth out of range
   * @param message - message based on different Exception
   */
  public IncorrectWealthAmountException(String message) {
    super(message);
  }
}

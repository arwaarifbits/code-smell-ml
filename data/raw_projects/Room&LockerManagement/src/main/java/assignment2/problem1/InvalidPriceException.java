package assignment2.problem1;
/**
 * Throw InvalidPriceException when the price is less than or equal to 0.
 */
public class InvalidPriceException extends Exception{
  /**
   * Constructor for InvalidGuestNumberException
   * @param message - message will be given based on the exception, String
   */
  public InvalidPriceException(String message) {
    super(message);
  }
}

package problem2;
/**
 * Throw IncorrectStaminaAmountException when available stamina out of range
 */
public class IncorrectStaminaAmountException extends Exception{
  /**
   * Throw IncorrectStaminaAmountException when available stamina out of range
   * @param message - message based on different Exception
   */
  public IncorrectStaminaAmountException(String message){
    super(message);
  }
}

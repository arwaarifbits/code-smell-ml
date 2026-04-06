package problem2;

/**
 * This interface contains all operations that all types of Pieces should support.
 */
public interface Piece {

  /**
   * The increase behavior of the Piece
   *
   * @param number - The increasing value
   * @throws IncorrectWealthAmountException if wealthAmount out of range
   * @throws IncorrectStaminaAmountException if staminaAmount out of range
   */
  void increase(Double number)
      throws IncorrectWealthAmountException, IncorrectStaminaAmountException;


  /**
   * The decrease behavior of the Piece
   *
   * @param number - The increasing value
   * @throws IncorrectWealthAmountException if wealthAmount out of range
   * @throws IncorrectStaminaAmountException if staminaAmount out of range
   */
  void decrease(Double number)
      throws IncorrectWealthAmountException, IncorrectStaminaAmountException;
}

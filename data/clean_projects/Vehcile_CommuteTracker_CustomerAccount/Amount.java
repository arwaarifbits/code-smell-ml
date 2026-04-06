package problem3;

/**
 * Amount is a simple object that has dollarAmount, centsAmount
 */
public class Amount {

  private Integer dollarAmount;
  private Integer centsAmount;
  /**
   * DOLLAR_TO_CENT  100 CENTS TO DOLLAR
   */
  public static final int DOLLAR_TO_CENT = 100;

  /**
   * Constructor that creates a new amount object with the specified dollarAmount, centAmount
   *
   * @param dollarAmount - dollarAmount of the new amount object.
   * @param centsAmount  - centsAmount of the new amount object.
   */
  public Amount(final int dollarAmount, final int centsAmount) {
    this.dollarAmount = dollarAmount;
    this.centsAmount = centsAmount;
  }

  /**
   * Returns the dollarAmount of the amount.
   *
   * @return the dollarAmount of the amount.
   */
  public Integer getDollarAmount() {
    return dollarAmount;
  }

  /**
   * Returns the centsAmount of the amount.
   *
   * @return the centsAmount of the amount.
   */
  public Integer getCentsAmount() {
    return centsAmount;
  }

  /**
   * Method addAmount Return the amount object after depositing another amount object.
   *
   * @param oriAmount   - the original amount object
   * @param addedAmount - the added amount object
   * @return the amount object after depositing another amount object to original amount.
   */
  public Amount addAmount(Amount oriAmount, Amount addedAmount) {
    int totalOriCents = oriAmount.dollarAmount * DOLLAR_TO_CENT + oriAmount.centsAmount;
    int totalAddedCents = addedAmount.dollarAmount * DOLLAR_TO_CENT + addedAmount.centsAmount;

    int totalDollar = (totalOriCents + totalAddedCents) / DOLLAR_TO_CENT;
    int totalCents = (totalOriCents + totalAddedCents) % DOLLAR_TO_CENT;
    return new Amount(totalDollar, totalCents);
  }

  /**
   * Method minusAmount Return the amount object after withdrawing another amount object.
   *
   * @param oriAmount     - the original amount object
   * @param deletedAmount - the deleted amount object
   * @return the amount object after withdrawing another amount object to original amount.
   */
  public Amount minusAmount(Amount oriAmount, Amount deletedAmount) {
    int totalOriCents = oriAmount.dollarAmount * DOLLAR_TO_CENT + oriAmount.centsAmount;
    int totalDeletedCents = deletedAmount.dollarAmount * DOLLAR_TO_CENT + deletedAmount.centsAmount;

    int totalDollar = (totalOriCents - totalDeletedCents) / DOLLAR_TO_CENT;
    int totalCents = (totalOriCents - totalDeletedCents) % DOLLAR_TO_CENT;
    return new Amount(totalDollar, totalCents);
  }


}

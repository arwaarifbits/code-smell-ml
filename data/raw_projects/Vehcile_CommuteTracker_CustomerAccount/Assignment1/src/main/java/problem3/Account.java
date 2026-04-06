package problem3;

/**
 * Account is a simple object that has firstName and lastName and amount
 */
public class Account {

  private String firstName;
  private String lastName;
  private Amount amount;

  /**
   * Constructor that creates a new account object with the specified firstName and lastName
   *
   * @param firstName - firstName of the new account object.
   * @param lastName  - lastName of the new account object.
   * @param amount    - amount of the new account object
   */
  public Account(final String firstName, final String lastName, final Amount amount) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.amount = amount;
  }

  /**
   * Returns the firstName of the account.
   *
   * @return the firstName of the account.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns the lastName of the account.
   *
   * @return the lastName of the account.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Returns the balance amount of the account.
   *
   * @return the balance amount of the account.
   */
  public Amount getAmount() {
    return amount;
  }

  /**
   * Sets the firstName of the account.
   *
   * @param firstName - firstName of the new account object.
   */
  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  /**
   * Sets lastName of the account.
   *
   * @param lastName - lastName of the new account object.
   */
  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  /**
   * Deposit amount of money into account Return the updated balance of the account after
   * depositing
   *
   * @param amount - amount of money to deposit in
   * @return the updated balance of the account after depositing
   */
  public Account deposit(Amount amount) {
    Amount updatedAmount = amount.addAmount(this.amount, amount);
    return new Account(this.firstName, this.lastName, updatedAmount);
  }

  /**
   * Withdraw amount of money from account Return the updated balance of the account after
   * withdrawing
   *
   * @param amount - amount of money to withdraw
   * @return the updated balance of the account after withdrawing
   */
  public Account withdraw(Amount amount) {
    Amount updatedAmount = amount.minusAmount(this.amount, amount);
    return new Account(this.firstName, this.lastName, updatedAmount);
  }
}

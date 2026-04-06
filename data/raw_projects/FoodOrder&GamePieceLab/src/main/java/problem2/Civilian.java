package problem2;

import java.util.Objects;

/**
 * Civilian is a piece contains name, age and wealth. Civilian is the subclass of AbstractPiece.
 */
public class Civilian extends AbstractPiece{
  private Double wealth;
  private static final Double minWealth = 0.00;

  /**
   * Constructor that creates a new Civilian object with the name, age and wealth
   *
   * @param name   - name of the new civilian object, Name class
   * @param age    - age of the new civilian object, Integer
   * @param wealth - wealth of the new civilian object, Double
   * @throws IncorrectAgeException if the age is not valid.
   * @throws IncorrectWealthAmountException if the wealth is not valid.
   */
  public Civilian(Name name, Integer age, Double wealth) throws IncorrectAgeException, IncorrectWealthAmountException
  {
    super(name, age);
    this.isValidWealth(wealth);
    this.wealth = wealth;
  }


  /**
   * Checks whether the wealth is valid
   * @param wealth The wealth to check, double
   * @throws IncorrectWealthAmountException if the wealth is smaller than 0
   */
  private void isValidWealth(Double wealth) throws IncorrectWealthAmountException{
    if(wealth < minWealth){
      throw new IncorrectWealthAmountException("Wealth Amount should not be negative!");
    }
  }

  /**
   * Checks whether the wealth is valid to decrease
   * @param wealth The wealth to check, double
   * @throws IncorrectWealthAmountException if the wealth is smaller than 0
   */
  private void isValidDecreaseWealth(Double wealth) throws IncorrectWealthAmountException{
    this.isValidWealth(wealth);
    if(this.wealth < wealth){
      throw new IncorrectWealthAmountException("Wealth Deduction Amount is larger than original amount!");
    }
  }


  /**
   * An increase method in the civilian's wealth.
   * @param number The increasing amount of wealth, double
   * @throws IncorrectWealthAmountException if the amount is smaller than 0.
   */
  @Override
  public void increase(Double number)
      throws IncorrectWealthAmountException {
    this.isValidWealth(number);
    this.wealth += number;
  }


  /**
   * A decrease method in the civilian's wealth.
   * @param number The decreasing amount of wealth, double
   * @throws IncorrectWealthAmountException if the amount is smaller than 0 or too large to minus.
   */
  @Override
  public void decrease(Double number)
      throws IncorrectWealthAmountException{
    this.isValidDecreaseWealth(number);
    this.wealth -= number;
  }

  /**
   * Returns the wealth of the Civilian.
   *
   * @return the wealth of the Civilian.
   */
  public Double getWealth() {
    return this.wealth;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Civilian civilian = (Civilian) o;
    return wealth.equals(civilian.wealth);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), wealth);
  }

  @Override
  public String toString() {
    return "Civilian{" +
        "wealth=" + wealth +
        '}';
  }
}

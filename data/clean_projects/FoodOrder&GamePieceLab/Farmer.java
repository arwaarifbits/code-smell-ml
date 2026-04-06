package problem2;

/**
 * Farmer is a civilian contains name, age and wealth. Farmer is the subclass of civilian.
 */
public class Farmer extends Civilian {

  /**
   * Constructor that creates a new Farmer object with the name, age and wealth
   *
   * @param name   - name of the new Farmer object, Name class
   * @param age    - age of the new Farmer object, Integer
   * @param wealth - wealth of the new Farmer object, Double
   * @throws IncorrectAgeException          if the age is not valid.
   * @throws IncorrectWealthAmountException if the wealth is not valid.
   */
  public Farmer(Name name, Integer age, Double wealth)
      throws IncorrectAgeException, IncorrectWealthAmountException {
    super(name, age, wealth);
  }
}

package problem2;

/**
 * Engineer is a civilian contains name, age and wealth. Engineer is the subclass of civilian.
 */
public class Engineer extends Civilian{

  /**
   * Constructor that creates a new Engineer object with the name, age and wealth
   *
   * @param name   - name of the new Engineer object, Name class
   * @param age    - age of the new Engineer object, Integer
   * @param wealth - wealth of the new Engineer object, Double
   * @throws IncorrectAgeException          if the age is not valid.
   * @throws IncorrectWealthAmountException if the wealth is not valid.
   */
  public Engineer(Name name, Integer age, Double wealth)
      throws IncorrectAgeException, IncorrectWealthAmountException {
    super(name, age, wealth);
  }
}

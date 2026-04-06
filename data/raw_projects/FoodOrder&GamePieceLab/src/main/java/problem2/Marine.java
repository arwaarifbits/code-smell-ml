package problem2;

/**
 * Marine is a soldier contains name, age and stamina. Marine is the subclass of Soldier.
 */
public class Marine extends Soldier {

  /**
   * Constructor that creates a new Marine object with the name, age and stamina
   *
   * @param name    - name of the new Marine object, Name class
   * @param age     - age of the new Marine object, Integer
   * @param stamina - wealth of the new Marine object, Double
   * @throws IncorrectAgeException           if the age is not valid.
   * @throws IncorrectStaminaAmountException if the stamina is not valid.
   */
  public Marine(Name name, Integer age, Double stamina)
      throws IncorrectAgeException, IncorrectStaminaAmountException {
    super(name, age, stamina);
  }
}

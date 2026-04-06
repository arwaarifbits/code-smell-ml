package problem2;

/**
 * Sniper is a soldier contains name, age and stamina. Sniper is the subclass of Soldier.
 */
public class Sniper extends Soldier {

  /**
   * Constructor that creates a new Sniper object with the name, age and stamina
   *
   * @param name    - name of the new sniper object, Name class
   * @param age     - age of the new sniper object, Integer
   * @param stamina - wealth of the new sniper object, Double
   * @throws IncorrectAgeException           if the age is not valid.
   * @throws IncorrectStaminaAmountException if the stamina is not valid.
   */
  public Sniper(Name name, Integer age, Double stamina)
      throws IncorrectAgeException, IncorrectStaminaAmountException {
    super(name, age, stamina);
  }

}

package problem2;

import java.util.Objects;

/**
 * Soldier is a piece contains name, age and stamina. Soldier is the subclass of AbstractPiece.
 */
public class Soldier extends AbstractPiece {

  private Double stamina;
  private static final Double maxStamina = 100.00;
  private static final Double minStamina = 0.00;

  /**
   * Constructor that creates a new Soldier object with the name, age and stamina
   *
   * @param name    - name of the new soldier object, Name class
   * @param age     - age of the new soldier object, Integer
   * @param stamina - wealth of the new soldier object, Double
   * @throws IncorrectAgeException           if the age is not valid.
   * @throws IncorrectStaminaAmountException if the stamina is not valid.
   */

  public Soldier(Name name, Integer age, Double stamina)
      throws IncorrectAgeException, IncorrectStaminaAmountException {
    super(name, age);
    this.isValidStamina(stamina);
    this.stamina = stamina;
  }

  /**
   * Checks whether the stamina is valid
   *
   * @param stamina The stamina to check, double
   * @throws IncorrectStaminaAmountException if the stamina is smaller than 0 and greater than 100
   */
  private void isValidStamina(Double stamina) throws IncorrectStaminaAmountException {
    if (stamina < minStamina || stamina > maxStamina) {
      throw new IncorrectStaminaAmountException("Stamina out of range!");
    }
  }


  /**
   * Checks whether the increase stamina amount is valid
   *
   * @param stamina The stamina to check, double
   * @throws IncorrectStaminaAmountException if the increase stamina plus original stamina greater
   *                                         than 100
   */
  private void isValidIncreaseStamina(Double stamina) throws IncorrectStaminaAmountException {
    this.isValidStamina(stamina);
    if ((stamina + this.stamina) > maxStamina) {
      throw new IncorrectStaminaAmountException("The adding stamina is too large!");
    }
  }


  /**
   * Checks whether the decrease stamina amount is valid
   *
   * @param stamina The stamina to check, double
   * @throws IncorrectStaminaAmountException if the decrease stamina plus original stamina less than
   *                                         0
   */
  private void isValidDecreaseStamina(Double stamina) throws IncorrectStaminaAmountException {
    this.isValidStamina(stamina);
    if ((this.stamina - stamina) < minStamina) {
      throw new IncorrectStaminaAmountException("The deducting stamina is too large!");
    }
  }

  /**
   * An increase method in the soldier's stamina.
   *
   * @param number The increasing amount of stamina, double
   * @throws IncorrectStaminaAmountException if the increasing amount is not valid.
   */
  @Override
  public void increase(Double number)
      throws IncorrectStaminaAmountException {
    this.isValidIncreaseStamina(number);
    this.stamina += number;
  }

  /**
   * A decrease method in the soldier's stamina.
   *
   * @param number The decreasing amount of stamina, double
   * @throws IncorrectStaminaAmountException if the decreasing amount is not valid.
   */
  @Override
  public void decrease(Double number)
      throws IncorrectStaminaAmountException {
    this.isValidDecreaseStamina(number);
    this.stamina -= number;
  }

  /**
   * Returns the stamina of the Soldier.
   *
   * @return the stamina of the Soldier.
   */
  public Double getStamina() {
    return this.stamina;
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
    Soldier soldier = (Soldier) o;
    return stamina.equals(soldier.stamina);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), stamina);
  }

  @Override
  public String toString() {
    return "Soldier{" +
        "stamina=" + stamina +
        '}';
  }
}

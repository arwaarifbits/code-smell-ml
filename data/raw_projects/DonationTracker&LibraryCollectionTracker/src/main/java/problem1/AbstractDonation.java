package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * This is an abstract class for Donation with amount and creation date time
 */
public abstract class AbstractDonation implements ICalculateDonation {

  /**
   * Donation amount field
   */
  protected Double amount;
  /**
   * Creation date time filed
   */
  protected LocalDateTime dateTime;

  /**
   * Constructor for AbstractDonation with amount and dateTime
   *
   * @param amount   - the donation amount, double
   * @param dateTime - the donation created time, local date time
   */
  public AbstractDonation(Double amount, LocalDateTime dateTime) {
    this.amount = amount;
    this.dateTime = dateTime;
  }

  /**
   * Get the amount of the donation
   *
   * @return the amount of the donation, double
   */
  public Double getAmount() {
    return this.amount;
  }

  /**
   * Get the creation date time of the donation
   *
   * @return the dateTime of the donation, LocalDateTime
   */
  public LocalDateTime getDateTime() {
    return this.dateTime;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractDonation that = (AbstractDonation) o;
    return amount.equals(that.amount) && dateTime.equals(that.dateTime);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(amount, dateTime);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "amount=" + amount +
        ", dateTime=" + dateTime;
  }
}

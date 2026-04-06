package problem1;

import java.time.LocalDateTime;

/**
 * This is a OneTimeDonation class which is the subclass of the AbstractDonation Represent the One
 * Time Donation.
 */
public class OneTimeDonation extends AbstractDonation {

  /**
   * Constructor for OneTimeDonation with amount and created dateTime
   *
   * @param amount   - the donation amount, double
   * @param dateTime - the donation created time, local date time
   */
  public OneTimeDonation(Double amount, LocalDateTime dateTime) {
    super(amount, dateTime);
  }

  /**
   * Calculate the total OneTimeDonation amount in the given year
   *
   * @param year - the year given to calculate the donation amount, integer
   * @return the total OneTimeDonation amount in the given year, double
   */
  @Override
  public Double calculateDonationThisYear(int year) {
    if (this.getDateTime().getYear() == year) {
      return this.getAmount();
    }
    return 0.0;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "OneTimeDonation:" + super.toString();
  }
}

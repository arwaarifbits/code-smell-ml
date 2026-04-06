package problem1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * This is a MonthlyDonation class which is the subclass of the AbstractDonation with one additional
 * field cancellationDateTime Represent the Monthly Donation.
 */
public class MonthlyDonation extends AbstractDonation {

  private LocalDateTime cancellationDateTime;
  private static final Integer MONTHS_IN_ONE_YEAR = 12;

  /**
   * Constructor for MonthlyDonation with amount, dateTime, cancellationDateTime is null when the
   * MonthlyDonation created
   *
   * @param amount   - the amount of MonthlyDonation, double
   * @param dateTime - the creat date time of MonthlyDonation, LocalDateTime
   */
  public MonthlyDonation(Double amount, LocalDateTime dateTime) {
    super(amount, dateTime);
    this.cancellationDateTime = null;
  }

  /**
   * Helper function to calculate the duration between created time and canceled time
   *
   * @param startTime - the donation subscription created time, LocalDateTime
   * @param endTime   - the donation subscription cancelled time, LocalDateTime
   * @return the duration in Months, long
   */
  private long calculateDuration(LocalDateTime startTime, LocalDateTime endTime) {
    // Ignore days, only calculate the number of month between two dates
    long duration = ChronoUnit.MONTHS.between(startTime.withDayOfMonth(1),
        endTime.withDayOfMonth(1));
    return duration + 1; // always add the final cancellation month
  }

  /**
   * Calculate the total MonthlyDonation amount in the given year
   *
   * @param year - the year given to calculate the donation amount, integer
   * @return the total MonthlyDonation amount in the given year, double
   */
  @Override
  public Double calculateDonationThisYear(int year) {
    if (this.getDateTime().getYear() > year) {  // creation year is after this year
      return 0.0;
    }
    long numberOfMonths = 0;
    if (this.getDateTime().getYear() == year) { // creation year is in this year
      if (this.getCancellationDateTime() == null
          || this.getCancellationDateTime().getYear() > year) {
        // if it does not be canceled or cancelled in the future (not in this year)
        numberOfMonths = MONTHS_IN_ONE_YEAR - this.getDateTime().getMonthValue() + 1;
      } else if (this.getCancellationDateTime().getYear() == year) { // if the cancellation happens
        // in this year
        numberOfMonths = calculateDuration(this.getDateTime(), this.getCancellationDateTime());
      }
    } else { // creation year is in the past (this.getDateTime().getYear() < year)
      if (this.getCancellationDateTime() == null
          || this.getCancellationDateTime().getYear() > year) {
        // if it does not be canceled or cancelled in the future (not in this year)
        numberOfMonths = MONTHS_IN_ONE_YEAR;
      } else if (this.getCancellationDateTime().getYear() == year) { // if the cancellation happens
        // in this year
        numberOfMonths = this.getCancellationDateTime().getMonthValue();
      }
    }
    return numberOfMonths * this.getAmount();
  }

  /**
   * Helper function to check whether the cancellationDateTime is valid
   *
   * @param time - the monthlyDonation cancellationDateTime, LocalDateTime
   * @throws InvalidCancellationTime when the cancellation date and time is prior to the creation
   *                                 date and time
   */
  private void isValidCancellationDateTime(LocalDateTime time) throws InvalidCancellationTime {
    if (time.isBefore(this.getDateTime())) {
      throw new InvalidCancellationTime("Cancellation date and time should not be "
          + "prior to the creation date and time.");
    }
  }

  /**
   * Set the cancellationDateTime
   *
   * @param cancellationDateTime - the monthlyDonation cancellation datetime wanted to set
   * @throws InvalidCancellationTime when the cancellation date and time is prior to the creation
   *                                 date and time
   */
  public void setCancellationDateTime(LocalDateTime cancellationDateTime)
      throws InvalidCancellationTime {
    this.isValidCancellationDateTime(cancellationDateTime);
    this.cancellationDateTime = cancellationDateTime;
  }

  /**
   * Get the cancellationDateTime
   *
   * @return the monthlyDonation cancellation datetime
   */
  public LocalDateTime getCancellationDateTime() {
    return this.cancellationDateTime;
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
    if (!super.equals(o)) {
      return false;
    }
    MonthlyDonation that = (MonthlyDonation) o;
    return Objects.equals(cancellationDateTime, that.cancellationDateTime);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), cancellationDateTime);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "MonthlyDonation:" + super.toString() +
        "cancellationDateTime=" + cancellationDateTime;
  }
}

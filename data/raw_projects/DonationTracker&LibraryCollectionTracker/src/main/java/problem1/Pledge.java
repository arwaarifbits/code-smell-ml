package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * This is a Pledge class which is the subclass of the AbstractDonation with one additional field,
 * processingDateTime Represent the Pledge Donation.
 */
public class Pledge extends AbstractDonation {

  private LocalDateTime processingDateTime;

  /**
   * Constructor for Pledge with amount, dateTime, processingDateTime is null when the pledge
   * donation created
   *
   * @param amount   - the amount of Pledge, double
   * @param dateTime - the creat date time of Pledge, LocalDateTime
   */
  public Pledge(Double amount, LocalDateTime dateTime) {
    super(amount, dateTime);
    this.processingDateTime = null;
  }

  /**
   * Overloaded Constructor for Pledge with amount, dateTime, processingDateTime is given
   *
   * @param amount             - the amount of Pledge, double
   * @param dateTime           - the creat date time of Pledge, LocalDateTime
   * @param processingDateTime - the processing date time of Pledge, LocalDateTime
   */
  public Pledge(Double amount, LocalDateTime dateTime, LocalDateTime processingDateTime) {
    super(amount, dateTime);
    this.processingDateTime = processingDateTime;
  }

  /**
   * Calculate the total Pledge donation amount in the given year
   *
   * @param year - the year given to calculate the donation amount, integer
   * @return the total Pledge donation amount in the given year, double
   */
  @Override
  public Double calculateDonationThisYear(int year) {
    if (this.processingDateTime != null && this.processingDateTime.getYear() == year) {
      return this.getAmount();
    }
    return 0.0;
  }

  /**
   * Get the Pledge donation processingDateTime
   *
   * @return the Pledge donation processingDateTime, LocalDateTime
   */
  public LocalDateTime getProcessingDate() {
    return this.processingDateTime;
  }

  /**
   * Helper function to check whether the processingDateTime is valid
   *
   * @param processingDateTime - the pledge donation processingDateTime, LocalDateTime
   * @throws InvalidProcessingTime when the processing date and time is prior to the creation date
   *                               and time
   */
  private void isValidProcessingTime(LocalDateTime processingDateTime)
      throws InvalidProcessingTime {
    if (processingDateTime.isBefore(this.getDateTime())) {
      throw new InvalidProcessingTime("Processing date and time should not be "
          + "prior to the creation date and time.");
    }
  }

  /**
   * Set the processing date time of the pledge donation
   *
   * @param processingDateTime - the processing date time wanted to be set
   * @throws InvalidProcessingTime the processing date and time is prior to the creation date and
   *                               time
   */
  public void setProcessingDate(LocalDateTime processingDateTime) throws InvalidProcessingTime {
    this.isValidProcessingTime(processingDateTime);
    this.processingDateTime = processingDateTime;
  }

  /**
   * Remove the processing date time. Set the processingDateTime to null.
   */
  public void removeProcessingDate() {
    this.processingDateTime = null;
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
    Pledge pledge = (Pledge) o;
    return Objects.equals(processingDateTime, pledge.processingDateTime);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), processingDateTime);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Pledge" + super.toString() +
        "processingDateTime=" + processingDateTime;
  }
}

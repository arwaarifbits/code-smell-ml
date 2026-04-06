package problem1;

/**
 * This is an interface for donation calculation
 */
public interface ICalculateDonation {

  /**
   * Calculate the total donation amount based on given year
   *
   * @param year - the year given to calculate the donation amount, integer
   * @return the total donation amount based on given year, double
   */
  public Double calculateDonationThisYear(int year);
}

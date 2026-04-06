package problem2;

/**
 * Time is a simple object that has seconds, minutes, hours
 */
public class Time {

  private Integer seconds;
  private Integer minutes;
  private Integer hours;

  /**
   * Constructor that creates a new time object with the specified seconds, minutes and hours
   *
   * @param seconds - seconds of the new time object.
   * @param minutes - minutes of the new time object.
   * @param hours   - hours of the new time object.
   */
  public Time(final Integer seconds, final Integer minutes, final Integer hours) {
    this.seconds = seconds;
    this.minutes = minutes;
    this.hours = hours;
  }

  /**
   * Returns the seconds of the Time.
   *
   * @return the seconds of the Time.
   */
  public Integer getSeconds() {
    return seconds;
  }

  /**
   * Returns the minutes of the Time.
   *
   * @return the minutes of the Time.
   */
  public Integer getMinutes() {
    return minutes;
  }

  /**
   * Returns the hours of the Time.
   *
   * @return the hours of the Time.
   */
  public Integer getHours() {
    return hours;
  }


  /**
   * Sets seconds of the Time.
   *
   * @param seconds - seconds of the new Time object.
   */
  public void setSeconds(final Integer seconds) {
    this.seconds = seconds;
  }

  /**
   * Sets minutes of the Time.
   *
   * @param minutes - minutes of the new Time object.
   */
  public void setMinutes(final Integer minutes) {
    this.minutes = minutes;
  }


  /**
   * Sets hours of the Time.
   *
   * @param hours - hours of the new Time object.
   */
  public void setHours(final Integer hours) {
    this.hours = hours;
  }
}




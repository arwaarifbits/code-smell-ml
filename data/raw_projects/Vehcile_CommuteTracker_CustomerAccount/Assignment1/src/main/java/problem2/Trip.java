package problem2;

/**
 * Trip is a simple object that has start location, end location, start time and end time
 */
public class Trip {

  private String startLocation;
  private String endLocation;
  private Time startTime;
  private Time endTime;
  /**
   * HOUR_TO_SECOND  3600 seconds to hour
   */
  public static final int HOUR_TO_SECOND = 3600;
  /**
   * MINUTE_TO_SECOND  60 seconds to minute
   */
  public static final int MINUTE_TO_SECOND = 60;

  /**
   * Constructor that creates a new trip object with start location, end location, start time and
   * end time
   *
   * @param startLocation - startLocation of the new time object.
   * @param endLocation   - endLocation of the new time object.
   * @param startTime     - startTime of the new time object.
   * @param endTime       - endTime of the new time object.
   */
  public Trip(final String startLocation, final String endLocation, final Time startTime,
      final Time endTime) {
    this.startLocation = startLocation;
    this.endLocation = endLocation;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  /**
   * Returns the startLocation of the Trip.
   *
   * @return the startLocation of the Trip.
   */
  public String getStartLocation() {
    return startLocation;
  }

  /**
   * Returns the endLocation of the Trip.
   *
   * @return the endLocation of the Trip.
   */
  public String getEndLocation() {
    return endLocation;
  }

  /**
   * Returns the startTime of the Trip.
   *
   * @return the startTime of the Trip.
   */
  public Time getStartTime() {
    return startTime;
  }

  /**
   * Returns the endTime of the Trip.
   *
   * @return the endTime of the Trip.
   */
  public Time getEndTime() {
    return endTime;
  }


  /**
   * Sets startLocation of the Trip.
   *
   * @param startLocation - startLocation of the Trip.
   */
  public void setStartLocation(final String startLocation) {
    this.startLocation = startLocation;
  }


  /**
   * Sets endLocation of the Trip.
   *
   * @param endLocation - startLocation of the Trip.
   */
  public void setEndLocation(final String endLocation) {
    this.endLocation = endLocation;
  }

  /**
   * Sets startTime of the Trip.
   *
   * @param hours   - hours of the startTime for the trip.
   * @param minutes - minutes of the startTime for the trip.
   * @param seconds - seconds of the startTime for the trip.
   */
  public void setStartTime(final int hours, final int minutes, final int seconds) {
    this.startTime.setHours(hours);
    this.startTime.setMinutes(minutes);
    this.startTime.setSeconds(seconds);
  }

  /**
   * Sets endTime of the Trip.
   *
   * @param hours   - hours of the endTime for the trip.
   * @param minutes - minutes of the endTime for the trip.
   * @param seconds - seconds of the endTime for the trip.
   */
  public void setEndTime(final int hours, final int minutes, final int seconds) {
    this.endTime.setHours(hours);
    this.endTime.setMinutes(minutes);
    this.endTime.setSeconds(seconds);
  }

  /**
   * Method getDuration tp get the trip duration. Returns the duration of the Trip.
   *
   * @return the duration of the Trip.
   */
  public Time getDuration() {
    int startSeconds = startTime.getSeconds();
    int startMinutesToSec = startTime.getMinutes() * MINUTE_TO_SECOND;
    int startHourToSec = startTime.getHours() * HOUR_TO_SECOND;
    int endSeconds = endTime.getSeconds();
    int endMinutesToSec = endTime.getMinutes() * MINUTE_TO_SECOND;
    int endHourToSec = endTime.getHours() * HOUR_TO_SECOND;

    int totalStartTimeSec = startSeconds + startMinutesToSec + startHourToSec;
    int totalEndTimeSec = endSeconds + endMinutesToSec + endHourToSec;

    int totalDurationSeconds = totalEndTimeSec - totalStartTimeSec;

    int durationHours = totalDurationSeconds / HOUR_TO_SECOND;
    int durationMinutes = (totalDurationSeconds % HOUR_TO_SECOND) / MINUTE_TO_SECOND;
    int durationSeconds =
        totalDurationSeconds - durationHours * HOUR_TO_SECOND - durationMinutes * MINUTE_TO_SECOND;

    return new Time(durationSeconds, durationMinutes, durationHours);

  }

}

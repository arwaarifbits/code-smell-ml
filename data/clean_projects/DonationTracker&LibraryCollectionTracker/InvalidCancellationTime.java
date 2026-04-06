package problem1;

/**
 * Throw InvalidCancellationTime when cancellation time is prior than the creation time
 */
public class InvalidCancellationTime extends Exception {

  /**
   * Constructor for InvalidCancellationTime
   *
   * @param message - message based on the given exception
   */
  public InvalidCancellationTime(String message) {
    super(message);
  }
}

package problem1;

/**
 * Throw InvalidProcessingTime when processing time is prior than the creation time
 */
public class InvalidProcessingTime extends Exception {

  /**
   * Constructor for InvalidProcessingTime
   *
   * @param message - message based on the given exception
   */
  public InvalidProcessingTime(String message) {
    super(message);
  }
}

package problem1;

/**
 * This is CourseNotFoundException, throw a CourseNotFoundException if the Course not exist.
 */
public class CourseNotFoundException extends Exception{

  /**
   * Constructor for the CourseNotFoundException
   * @param message - the message will be given when course not found
   */
  public CourseNotFoundException(String message) {
    super(message);
  }
}

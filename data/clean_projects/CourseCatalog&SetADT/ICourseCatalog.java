package problem1;

/**
 * This is a CourseCatalog Interface — an ordered, mutable collection, which will be used as part of
 * a university course registration system
 */
public interface ICourseCatalog {

  /**
   * Adds a Course to the end of the CourseCatalog
   *
   * @param course - course will be added, Course class
   */
  void append(Course course);

  /**
   * Removes a specified Course from the CourseCatalog. Throw a CourseNotFoundException if the
   * Course not exist.
   *
   * @param course - course will be removed, Course class
   * @throws CourseNotFoundException when the given Course not exist
   */
  void remove(Course course) throws CourseNotFoundException;

  /**
   * Checks if the specified course exists in the CourseCatalog.
   *
   * @param course - course will be checked, Course class
   * @return true if the course exists in the CourseCatalog, otherwise false
   */
  boolean contains(Course course);

  /**
   * Returns the index of the specified Course in the CourseCatalog, if it exists. If the Course
   * doesn’t exist, returns -1
   *
   * @param course - course will be searched, Course class
   * @return the index of the specified Course in the CourseCatalog, if it exists. If the Course not
   * exist, returns -1. Integer.
   */
  int indexOf(Course course);

  /**
   * Gets the number of Courses in the CourseCatalog.
   *
   * @return the number of Courses in the CourseCatalog, integer
   */
  int count();

  /**
   * Returns the Course at the given index in the CourseCatalog
   *
   * @param index - given index in the CourseCatalog, integer
   * @return the Course at the given index in the CourseCatalog, Course class
   * @throws InvalidIndexException when the given index not exist
   */
  Course get(int index) throws InvalidIndexException;

  /**
   * Checks if the CourseCatalog is empty.
   *
   * @return true if the CourseCatalog is empty, otherwise false.
   */
  boolean isEmpty();

}

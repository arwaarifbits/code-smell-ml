package problem1;

import java.util.Arrays;
import java.util.Objects;

/**
 * This is a CourseCatalog class. Represent a CourseCatalog with Courses and number of courses
 */
public class CourseCatalog implements ICourseCatalog {

  private Course[] courseCatalog;
  private Integer numberOfCourses;
  private static final Integer DEFAULT_ARRAY_SIZE = 10;
  private static final Integer INITIAL_NUMBER_OF_COURSES = 0;
  private static final Integer COURSE_NOT_EXIST = -1;

  /**
   * Constructor for CourseCatalog. Create a courseCatalog with new empty courses array and 0 number
   * of courses.
   */
  public CourseCatalog() {
    this.courseCatalog = new Course[DEFAULT_ARRAY_SIZE];
    this.numberOfCourses = INITIAL_NUMBER_OF_COURSES;
  }

  /**
   * Resize the courseCatalog when the courseCatalog array length is not long enough to add the
   * given course and add the given course.
   *
   * @param pastCourseCatalog - the target courseCatalog, Courses array
   * @param course            - the course will be added to the courseCatalog, Course class
   */
  private void resizeCopyArray(Course[] pastCourseCatalog, Course course) {
    Course[] newCourseCatalog = new Course[this.courseCatalog.length + DEFAULT_ARRAY_SIZE];
    for (int i = 0; i < this.numberOfCourses; i++) {
      newCourseCatalog[i] = pastCourseCatalog[i];
    }
    newCourseCatalog[this.numberOfCourses] = course;
    this.courseCatalog = newCourseCatalog;
  }

  /**
   * Adds a Course to the end of the CourseCatalog
   *
   * @param course - course will be added, Course class
   */
  @Override
  public void append(Course course) {
    if (this.courseCatalog.length < this.numberOfCourses + 1) {
      this.resizeCopyArray(courseCatalog, course);
    } else {
      this.courseCatalog[this.numberOfCourses] = course;
    }
    this.numberOfCourses++;
  }

  /**
   * Removes a specified Course from the CourseCatalog. Throw a CourseNotFoundException if the
   * Course not exist.
   *
   * @param course - course will be removed, Course class
   * @throws CourseNotFoundException when the given Course not exist
   */
  @Override
  public void remove(Course course) throws CourseNotFoundException {
    int targetIndex = this.indexOf(course);
    if (targetIndex == COURSE_NOT_EXIST) {
      throw new CourseNotFoundException("Course does not exist!");
    } else {
      Course[] newCatalog = new Course[this.courseCatalog.length];
      for (int i = 0, k = 0; i < this.courseCatalog.length; i++) {
        if (i == targetIndex) {
          continue;
        }
        newCatalog[k++] = this.courseCatalog[i];
      }
      this.courseCatalog = newCatalog;
      this.numberOfCourses--;
    }
  }

  /**
   * Checks if the specified course exists in the CourseCatalog.
   *
   * @param course - course will be checked, Course class
   * @return true if the course exists in the CourseCatalog, otherwise false
   */
  @Override
  public boolean contains(Course course) {
    return this.indexOf(course) != COURSE_NOT_EXIST;
  }

  /**
   * Returns the index of the specified Course in the CourseCatalog, if it exists. If the Course
   * does not exist, returns -1
   *
   * @param course - course will be searched, Course class
   * @return the index of the specified Course in the CourseCatalog, if it exists. If the Course not
   * exist, returns -1. Integer.
   */
  @Override
  public int indexOf(Course course) {
    int index = 0;
    while (index < this.numberOfCourses) {
      if (course.equals(this.courseCatalog[index])) {
        return index;
      }
      index++;
    }
    return COURSE_NOT_EXIST;
  }

  /**
   * Gets the number of Courses in the CourseCatalog.
   *
   * @return the number of Courses in the CourseCatalog, integer
   */
  @Override
  public int count() {
    return this.numberOfCourses;
  }

  /**
   * Returns the Course at the given index in the CourseCatalog
   *
   * @param index - given index in the CourseCatalog, integer
   * @return the Course at the given index in the CourseCatalog, Course class
   * @throws InvalidIndexException when the given index not exist
   */
  @Override
  public Course get(int index) throws InvalidIndexException {
    if (index < INITIAL_NUMBER_OF_COURSES || index >= this.numberOfCourses) {
      throw new InvalidIndexException("Index not exists!");
    }
    return this.courseCatalog[index];
  }

  /**
   * Checks if the CourseCatalog is empty.
   *
   * @return true if the CourseCatalog is empty, otherwise false.
   */
  @Override
  public boolean isEmpty() {
    return this.numberOfCourses == INITIAL_NUMBER_OF_COURSES;
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
    CourseCatalog that = (CourseCatalog) o;
    return Arrays.equals(courseCatalog, that.courseCatalog) && numberOfCourses.equals(
        that.numberOfCourses);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    int result = Objects.hash(numberOfCourses);
    result = 31 * result + Arrays.hashCode(courseCatalog);
    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "CourseCatalog{" +
        "courseCatalog=" + Arrays.toString(courseCatalog) +
        ", numberOfCourses=" + numberOfCourses +
        '}';
  }
}

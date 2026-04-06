package problem2;

/**
 * A ListOfString Interface with add, isEmpty, size, contains, containsAll, filterLargerThan,
 * hasDuplicates, removeDuplicates
 */
public interface ListOfString {

  /**
   * Add the string into the linked list
   *
   * @param string string will be added
   */
  void add(String string);

  /**
   * Checks whether the list is empty.
   *
   * @return True if the list is empty otherwise False
   */
  boolean isEmpty();

  /**
   * Gets the total number of elements in the list
   *
   * @return the size of the linked list, integer
   */
  Integer size();

  /**
   * Consumes a String, and checks if the String is in the list or not.
   *
   * @param string - another string
   * @return True if the String is in the list, otherwise False
   */
  boolean contains(String string);

  /**
   * Consumes another list of Strings, and checks that all elements of this list are in the list
   * passed as argument.
   *
   * @param list - another list of strings
   * @return True if all elements of this list are in the list passed as argument otherwise False
   */
  boolean containsAll(LinkedList list);

  /**
   * Check if the list has at least one duplicate element
   *
   * @return True if list has at least one duplicate element otherwise False
   */
  boolean hasDuplicates();

  /**
   * Return the list with all duplicates removed
   *
   * @return the list with all duplicates removed
   */
  LinkedList removeDuplicates();

  /**
   * Takes the maximum String length, and returns a list with all elements whose length is greater
   * than the maximum length removed
   *
   * @param length - maximum string length
   * @return returns a list with all elements whose length is greater than the maximum length
   * removed
   */
  LinkedList filterLargerThan(Integer length);

}

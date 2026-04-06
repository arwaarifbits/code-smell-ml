package problem1;

/**
 * Represents a List of Integers
 */
public interface List {

  /**
   * Returns the total number of elements in the list.
   *
   * @return number of elements in this list
   */
  Integer size();


  /**
   * Returns true if empty and false otherwise
   */
  Boolean isEmpty();

  /**
   * Given a new element {@code element} prepend it to this list
   *
   * @param element new element to add to the list
   * @return updated list with {@code element} prependeds
   */
  List add(Integer element);


  /**
   * Return the last element of this list.
   *
   * @return the last element of this list.
   */
  Integer last();

  /**
   * returns a boolean value, depending on whether or not the given element is contained in the
   * list
   *
   * @param element takes an argument: the element that is being inspected
   * @return a boolean flag, indicating if the element is included in the list
   */
  Boolean contains(int element);

  /**
   * returns the element at the given index. If the index is out of bounds of the list throws an
   * exception
   *
   * @param index takes an argument: the index that is being inspected
   * @return the requested element
   * @throws InvalidCallException
   */

  Integer elementAt(int index) throws InvalidCallException;

}


package problem2;

public interface Set {

  /**
   * Returns an empty Set
   *
   * @return (Set), an EmptySet object
   */
  Set emptySet();

  /**
   * Returns whether the Set is empty
   *
   * @return (Boolean), indicating whether the Set object is empty
   */
  Boolean isEmpty();

  /**
   * Returns a new Set with the added Integer if the Integer is not already in the Set
   *
   * @param n, (Integer), the Integer to be added
   * @return (Set), a Set object containing the new Integer if not already in Set
   */
  Set add(Integer n);

  /**
   * Indicates whether the specified Integer is contained in the Set
   *
   * @param n, (Integer), the Integer to search for in the Set
   * @return (Boolean), indicating
   */
  Boolean contains(Integer n);

  /**
   * Returns a Set object with the specified Integer removed, if it was present
   *
   * @param n, (Integer), the Integer to be removed
   * @return (Set), a Set with the specified Integer n removed, if it was present
   */
  Set remove(Integer n);

  /**
   * Returns the size of the Set
   *
   * @return (Integer), representing the size of the Set
   */
  Integer size();

}

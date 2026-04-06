package problem2;

/**
 * This is a Set Interface — the mathematical notion of a set
 */
public interface ISet {

  /**
   * Creates and returns an empty Set
   *
   * @return an empty set, Set class
   */
  Set emptySet();

  /**
   * Checks if the Set is empty.
   *
   * @return true if the Set contains no items, false otherwise.
   */
  Boolean isEmpty();

  /**
   * Adds the given Integer to the Set if and only if that Integer is not already in the Set.
   *
   * @param n - the integer will be added, integer
   * @return the set with added Integer, Set class
   */
  Set add(Integer n);

  /**
   * Check if the given integer in the Set
   *
   * @param n - the integer will be checked, integer
   * @return true if the given Integer is in the Set, false otherwise.
   */
  Boolean contains(Integer n);

  /**
   * Remove the given Integer from the Set if and only if that Integer is already in the Set.
   *
   * @param n - the integer will be removed
   * @return a copy of the Set with the given Integer removed. If the given Integer is not in the
   * Set, returns the Set as is. Set class.
   */
  Set remove(Integer n);

  /**
   * Gets the number of items in the Set.
   *
   * @return the number of items in the Set.
   */
  Integer size();
}

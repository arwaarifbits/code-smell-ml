package problem2;

import java.util.Arrays;
import java.util.Objects;

/**
 * This is immutable class Set. Represent a set.
 */
public final class Set implements ISet {

  private Integer[] items;
  private int size;
  private static final Integer DEFAULT_ARRAY_SIZE = 10;
  private static final Integer EMPTY_SIZE = 0;

  /**
   * Constructor for the set. Create an initial set with default integer array and size of the set.
   */
  public Set() {
    this.items = new Integer[DEFAULT_ARRAY_SIZE];
    this.size = EMPTY_SIZE;
  }

  /**
   * Creates and returns an empty Set
   *
   * @return an empty set, Set class
   */
  @Override
  public Set emptySet() {
    return new Set();
  }

  /**
   * Checks if the Set is empty.
   *
   * @return true if the Set contains no items, false otherwise.
   */
  @Override
  public Boolean isEmpty() {
    return this.size == EMPTY_SIZE;
  }

  /**
   * Resize the items array when the items array length is not long enough to add the given integer
   * and add the given integer.
   *
   * @param pastItems - the target set's items array, integer array
   * @param n         - the number will be added to the items array, Integer
   */
  private void resizeCopyArray(Integer[] pastItems, Integer n) {
    Integer[] newItems = new Integer[this.items.length + DEFAULT_ARRAY_SIZE];
    for (int i = 0; i < this.size; i++) {
      newItems[i] = pastItems[i];
    }
    newItems[this.size] = n;
    this.items = newItems;
  }

  /**
   * Adds the given Integer to the Set if and only if that Integer is not already in the Set.
   *
   * @param n - the integer will be added, integer
   * @return the set with added Integer, Set class
   */
  @Override
  public Set add(Integer n) {
    if (!this.contains(n)) {
      if (this.size + 1 > this.items.length) {
        this.resizeCopyArray(this.items, n);
      } else {
        this.items[this.size] = n;
      }
      this.size++;
      return this;
    }
    return this;
  }

  /**
   * Check if the given integer in the Set
   *
   * @param n - the integer will be checked, integer
   * @return true if the given Integer is in the Set, false otherwise.
   */
  @Override
  public Boolean contains(Integer n) {
    for (int i = 0; i < this.size; i++) {
      if (this.items[i].equals(n)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Remove the given Integer from the Set if and only if that Integer is already in the Set.
   *
   * @param n - the integer will be removed
   * @return a copy of the Set with the given Integer removed. If the given Integer is not in the
   * Set, returns the Set as is. Set class.
   */
  @Override
  public Set remove(Integer n) {
    if (this.contains(n)) {
      Set newSet = new Set();
      for (int i = 0; i < this.size; i++) {
        if (!this.items[i].equals(n)) {
          newSet.add(this.items[i]);
        }
      }
      return newSet;
    }
    return this;
  }

  /**
   * Gets the number of items in the Set.
   *
   * @return the number of items in the Set.
   */
  @Override
  public Integer size() {
    return this.size;
  }

  /**
   * Check whether two Sets' items array have same items. The order of the item does not affect the
   * equality. Using this helper method in override equal method.
   *
   * @param comparedItems - the compared items array, integer array
   * @return true if two Sets' items array have same items (order does not matter), otherwise,
   * return false
   */
  private boolean equalItems(Integer[] comparedItems) {
    for (int i = 0; i < this.size; i++) {
      if (!this.contains(comparedItems[i])) {
        return false;
      }
    }
    return true;
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
    Set set = (Set) o;
    return size == set.size && this.equalItems(set.items);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    int result = Objects.hash(size);
    result = 31 * result + Arrays.hashCode(items);
    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Set{" +
        "items=" + Arrays.toString(items) +
        ", size=" + size +
        '}';
  }
}

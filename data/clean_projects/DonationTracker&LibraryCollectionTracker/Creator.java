package problem2;

/**
 * This is an interface for Creator
 */
public interface Creator {

  /**
   * Check whether contain the given creator
   *
   * @param creator - the creator wanted to check, Creator
   * @return true if the creator contains the given creator, otherwise false, boolean
   */
  boolean containsCreator(Creator creator);
}

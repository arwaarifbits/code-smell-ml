package problem2;

import java.util.Objects;

/**
 * This is an abstract class for Item with creator, title and releasedYear
 */
public abstract class Item {

  /**
   * Creator field
   */
  protected Creator creator;
  /**
   * Title field
   */
  protected String title;
  /**
   * ReleasedYear field
   */
  protected Integer releasedYear;

  /**
   * Constructor for Item with creator, title, releasedYear
   *
   * @param creator      - the Item's creator, Creator
   * @param title        - the Item's title, string
   * @param releasedYear - the Item's releasedYear, integer
   */
  public Item(Creator creator, String title, Integer releasedYear) {
    this.creator = creator;
    this.title = title;
    this.releasedYear = releasedYear;
  }

  /**
   * Check whether the item's title contain the keyword, case-insensitive
   *
   * @param keyword - the keyword wanted to search
   * @return true if the item's title contain the keyword otherwise false, boolean
   */
  public boolean containKeyword(String keyword) {
    return this.title.toLowerCase().contains(keyword.toLowerCase());
  }

  /**
   * Get the creator of the item
   *
   * @return the creator of the item, Creator
   */
  public Creator getCreator() {
    return this.creator;
  }

  /**
   * Get the title of the item
   *
   * @return the title of the item, string
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Get the releasedYear of the item
   *
   * @return the releasedYear of the item
   */
  public Integer getReleasedYear() {
    return this.releasedYear;
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
    Item item = (Item) o;
    return creator.equals(item.creator) && title.equals(item.title) && releasedYear.equals(
        item.releasedYear);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(creator, title, releasedYear);
  }

}

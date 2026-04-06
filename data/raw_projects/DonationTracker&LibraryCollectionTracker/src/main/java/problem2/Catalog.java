package problem2;

import java.util.ArrayList;
import java.util.Objects;

/**
 * This is a Catalog class which will be used to store a collection of all the items in the library
 * and to implement search functionality. Represent the Catalog in the library.
 */
public class Catalog {

  private ArrayList<Item> itemsCollection;

  /**
   * Constructor for the catalog with itemsCollection
   *
   * @param itemsCollection - the items that catalog has, Item ArrayList
   */
  public Catalog(ArrayList<Item> itemsCollection) {
    this.itemsCollection = itemsCollection;
  }

  /**
   * Overloaded Constructor for the catalog. ItemsCollection is null when catalog created.
   */
  public Catalog() {
    this.itemsCollection = new ArrayList<Item>();
  }

  /**
   * Add item into the catalog itemsCollection
   *
   * @param item - the item will be added to the catalog, Item
   */
  public void add(Item item) {
    this.itemsCollection.add(item);
  }

  /**
   * Remove item from the catalog itemsCollection
   *
   * @param item - the item will be removed from the catalog, Item
   */
  public void remove(Item item) {
    this.itemsCollection.remove(item);
  }

  /**
   * Search Method Retrieve all items in the catalog, regardless of type, that have a title
   * containing the keyword case-insensitive.
   *
   * @param keyword - the keyword will be searched, string
   * @return all items in the catalog contains the given keyword, Item ArrayList
   */
  public ArrayList<Item> search(String keyword) {
    ArrayList<Item> subset = new ArrayList<Item>();
    for (Item item : this.itemsCollection) {
      if (item.containKeyword(keyword)) {
        subset.add(item);
      }
    }
    return subset;
  }

  /**
   * Overloaded Search Method Retrieve all items in the catalog that have an exact match for the
   * given author
   *
   * @param author - the author will be searched, Author
   * @return all items in the catalog that have an exact match for the given author, Item ArrayList
   */
  public ArrayList<Item> search(Author author) {
    ArrayList<Item> subset = new ArrayList<Item>();
    for (Item item : this.itemsCollection) {
      if (item.creator.containsCreator(author)) {
        subset.add(item);
      }
    }
    return subset;
  }

  /**
   * Overloaded Search Method Retrieve all items in the catalog that have an exact match for the
   * given artist
   *
   * @param artist - the artist will be searched, RecordingArtist
   * @return all items in the catalog that have an exact match for the given author, Item ArrayList
   */
  public ArrayList<Item> search(RecordingArtist artist) {
    ArrayList<Item> subset = new ArrayList<Item>();
    for (Item item : this.itemsCollection) {
      if (item.creator.containsCreator(artist)) {
        subset.add(item);
      }
    }
    return subset;
  }

  /**
   * Get the itemsCollection of the catalog
   *
   * @return the itemsCollection of the catalog, Item ArrayList
   */
  public ArrayList<Item> getItemsCollection() {
    return this.itemsCollection;
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
    Catalog catalog = (Catalog) o;
    return Objects.equals(itemsCollection, catalog.itemsCollection);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(itemsCollection);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Catalog{" +
        "itemsCollection=" + itemsCollection +
        '}';
  }
}

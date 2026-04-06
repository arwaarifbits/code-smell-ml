package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CatalogTest {

  private Book book1;
  private Author author1;
  private Music musicWithBand;
  private Music music1;
  private Band band1;
  private RecordingArtist recordingArtist1;
  private RecordingArtist recordingArtist2;
  private RecordingArtist recordingArtist3;
  private Catalog catalog1;
  private Catalog catalog1Copy;
  private Catalog catalog1Imposter;
  private Catalog catalog2;

  @BeforeEach
  void setUp() {
    author1 = new Author("Mark", "Twain");
    book1 = new Book(author1, "The Adventures of Tom Sawyer", 1876);
    recordingArtist1 = new RecordingArtist("Justin", "Bieber");
    recordingArtist2 = new RecordingArtist("Shiraishi", "Mai");
    recordingArtist3 = new RecordingArtist("Nishino", "Nanase");
    music1 = new Music(recordingArtist1, "Baby", 2010);
    ArrayList<RecordingArtist> members = new ArrayList<RecordingArtist>();
    members.add(recordingArtist2);
    members.add(recordingArtist3);
    band1 = new Band("Nogizaka46", members);
    musicWithBand = new Music(band1, "Influencer", 2017);
    ArrayList<Item> items = new ArrayList<Item>();
    items.add(book1);
    items.add(music1);
    items.add(musicWithBand);
    catalog1 = new Catalog(items);
    catalog1Copy = new Catalog(items);
    catalog1Imposter = new Catalog(items);
    catalog2 = new Catalog();
    catalog2.add(music1);
  }

  @Test
  void add() {
    ArrayList<Item> expected = new ArrayList<Item>();
    expected.add(music1);
    expected.add(book1);
    catalog2.add(book1);
    assertEquals(expected, catalog2.getItemsCollection());
  }

  @Test
  void remove() {
    ArrayList<Item> expected = new ArrayList<Item>();
    catalog2.remove(music1);
    assertEquals(expected, catalog2.getItemsCollection());
  }

  @Test
  void searchKeywords() {
    ArrayList<Item> expected = new ArrayList<Item>();
    expected.add(book1);
    expected.add(music1);
    assertEquals(expected, catalog1.search("A"));
  }

  @Test
  void searchAuthor() {
    ArrayList<Item> expected = new ArrayList<Item>();
    expected.add(book1);
    assertEquals(expected, catalog1.search(author1));
  }

  @Test
  void searchRecordingArtist() {
    ArrayList<Item> expected = new ArrayList<Item>();
    expected.add(music1);
    assertEquals(expected, catalog1.search(recordingArtist1));
    ArrayList<Item> expectedBand = new ArrayList<Item>();
    expectedBand.add(musicWithBand);
    assertEquals(expectedBand, catalog1.search(recordingArtist2));
  }

  @Test
  void getItemsCollection() {
    ArrayList<Item> expected = new ArrayList<Item>();
    expected.add(music1);
    assertEquals(expected, catalog2.getItemsCollection());
  }

  @Test
  void testEquals() {
    assertTrue(catalog1.equals(catalog1) == catalog1.equals(catalog1));
    //test symmetry
    assertTrue(catalog1.equals(catalog1Copy) == catalog1.equals(catalog1Copy));
    //test transitivity
    assertTrue(catalog1.equals(catalog1Copy) && catalog1Copy.equals(catalog1Imposter)
        && catalog1Imposter.equals(catalog1));
    //test null reference
    assertFalse(catalog1.equals(null));
    //test consistency
    assertTrue(catalog1.equals(catalog1Copy));
    assertTrue(catalog1.equals(catalog1Copy));
    //test equals where equal should be false
    assertFalse(catalog1.equals(catalog2));
  }

  @Test
  void testHashCode() {
    //test null
    assertFalse(0 == catalog1.hashCode());
    //test consistency
    int testHashCode = catalog1.hashCode();
    assertEquals(testHashCode, catalog1.hashCode());

  }

  @Test
  void testToString() {
    String expected = "Catalog{" +
        "itemsCollection="
        + "[Music{creator=RecordingArtist{firstName='Justin', lastName='Bieber'},"
        + " title='Baby', releasedYear=2010}]" +
        '}';
    assertEquals(expected, catalog2.toString());
  }
}
package problem2;

/**
 * This is a Music class which is the subclass of the Item. Represent the Music.
 */
public class Music extends Item{

  /**
   * Constructor for the music with artist, title and releasedYear
   * @param artist - the music's artist, RecordingArtist
   * @param title - the music's title, string
   * @param releasedYear - the music's releasedYear, integer
   */
  public Music(RecordingArtist artist, String title, Integer releasedYear) {
    super(artist, title, releasedYear);
  }

  /**
   * Overloaded Constructor for music with band, title and releasedYear
   * @param band - the music's band, Band
   * @param title - the music's title, string
   * @param releasedYear - the music's releasedYear, integer
   */
  public Music(Band band, String title, Integer releasedYear) {
    super(band, title, releasedYear);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Music{" +
        "creator=" + creator +
        ", title='" + title + '\'' +
        ", releasedYear=" + releasedYear +
        '}';
  }
}

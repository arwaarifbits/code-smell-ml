package problem2;

import java.util.ArrayList;
import java.util.Objects;

/**
 * This is a Band class which is the subclass of the Group with additional field band name and
 * members it has. Represent the Band.
 */
public class Band extends Group {

  private ArrayList<RecordingArtist> members;
  private String name;

  /**
   * Constructor for the Band with name and members
   *
   * @param name    - band's name, string
   * @param members - members collection, RecordingArtist ArrayList
   */
  public Band(String name, ArrayList<RecordingArtist> members) {
    this.name = name;
    this.members = members;
  }

  /**
   * Add a member into the band
   *
   * @param artist - the member added to the band, RecordingArtist
   */
  public void addMember(RecordingArtist artist) {
    this.members.add(artist);
  }

  /**
   * Remove a member in the band
   *
   * @param artist - the member removed from the band, RecordingArtist
   */
  public void removeMember(RecordingArtist artist) {
    this.members.remove(artist);
  }

  /**
   * Get the name of the band
   *
   * @return the name of the band, string
   */
  public String getName() {
    return this.name;
  }

  /**
   * Get the collections of the members in the band
   *
   * @return the members of the band, RecordingArtist ArrayList
   */
  public ArrayList<RecordingArtist> getMembers() {
    return this.members;
  }

  /**
   * Check whether the Band contains the given creator
   *
   * @param creator - the creator wanted to check, Creator
   * @return true if Band contains the given creator otherwise false, boolean
   */
  @Override
  public boolean containsCreator(Creator creator) {
    for (RecordingArtist member : this.members) {
      if (member.equals(creator)) {
        return true;
      }
    }
    return false;
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
    Band band = (Band) o;
    return name.equals(band.name) && members.equals(band.members);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, members);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Band{" +
        "name='" + name + '\'' +
        ", members=" + members +
        '}';
  }
}

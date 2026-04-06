package problem1;

import java.util.ArrayList;
import java.util.Objects;

/**
 * This is a NonProfit class with fields name and collections. Represent NonProfit organization
 */
public class NonProfit {

  private String name;
  private ArrayList<AbstractDonation> collections;

  /**
   * Constructor for NonProfit with name and collections, when NonProfit created collections
   * (donations they received) is null
   *
   * @param name - the NonProfit Organization name, String
   */
  public NonProfit(String name) {
    this.name = name;
    this.collections = new ArrayList<AbstractDonation>();
  }

  /**
   * Receive the donation to the collection
   *
   * @param donation - the donation received, AbstractDonation
   */
  public void receiveDonation(AbstractDonation donation) {
    this.collections.add(donation);
  }

  /**
   * Remove all the donations they received.
   */
  public void removeAllDonations() {
    this.collections.clear();
  }

  /**
   * Remove the given donation from the collections
   *
   * @param donation - the donation wanted to remove, AbstractDonation
   */
  public void remove(AbstractDonation donation) {
    this.collections.remove(donation);
  }

  /**
   * Calculate the total donations amount of the given year for the nonprofit organization
   * @param year - the year want to be calculated, integer
   * @return total donations amount of the given year for the nonprofit organization, double
   */
  public Double getTotalDonationsForYear(int year) {
    Double total = 0.0;
    for (AbstractDonation item : this.collections) {
      total += item.calculateDonationThisYear(year);
    }
    return total;
  }

  /**
   * Get the NonProfit organization name
   *
   * @return the NonProfit organization name, string
   */
  public String getName() {
    return this.name;
  }

  /**
   * Get the NonProfit organization donations collections
   *
   * @return the NonProfit collections, AbstractDonation Array List
   */
  public ArrayList<AbstractDonation> getCollections() {
    return this.collections;
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
    NonProfit nonProfit = (NonProfit) o;
    return name.equals(nonProfit.name) && Objects.equals(collections,
        nonProfit.collections);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, collections);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "NonProfit{" +
        "name='" + name + '\'' +
        ", collections=" + collections +
        '}';
  }
}

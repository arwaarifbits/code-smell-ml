package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NonProfitTest {

  private NonProfit noDonations;
  private NonProfit nonProfit1;
  private NonProfit nonProfit2;
  private NonProfit nonProfit1Copy;
  private NonProfit nonProfit1Imposter;
  private Pledge pledge1;
  private OneTimeDonation oneTimeDonation1;
  private OneTimeDonation oneTimeDonation2;
  private MonthlyDonation monthlyDonation1;

  @BeforeEach
  void setUp() {
    noDonations = new NonProfit("ABC");
    nonProfit1 = new NonProfit("CDE");
    nonProfit2 = new NonProfit("ZZZ");
    nonProfit1Copy = new NonProfit("CDE");
    nonProfit1Imposter = new NonProfit("CDE");
    pledge1 = new Pledge(2000.0,
        LocalDateTime.of(2000, 11, 11, 11, 11, 11),
        LocalDateTime.of(2020, 11, 11, 11, 11, 11));
    oneTimeDonation1 = new OneTimeDonation(200.0,
        LocalDateTime.of(2020, 11, 11, 11, 11, 11));
    oneTimeDonation2 = new OneTimeDonation(300.0,
        LocalDateTime.of(2020, 12, 11, 11, 11, 11));
    monthlyDonation1 = new MonthlyDonation(30.0,
        LocalDateTime.of(2020, 11, 11, 11, 11, 11));
    nonProfit1.receiveDonation(pledge1);
    nonProfit1Copy.receiveDonation(pledge1);
    nonProfit1Imposter.receiveDonation(pledge1);
    nonProfit1.receiveDonation(monthlyDonation1);
    nonProfit1Copy.receiveDonation(monthlyDonation1);
    nonProfit1Imposter.receiveDonation(monthlyDonation1);
    nonProfit1.receiveDonation(oneTimeDonation2);
    nonProfit1Copy.receiveDonation(oneTimeDonation2);
    nonProfit1Imposter.receiveDonation(oneTimeDonation2);
    nonProfit1.receiveDonation(oneTimeDonation1);
    nonProfit1Copy.receiveDonation(oneTimeDonation1);
    nonProfit1Imposter.receiveDonation(oneTimeDonation1);
    nonProfit2.receiveDonation(oneTimeDonation1);
  }

  @Test
  void getName() {
    assertEquals("ZZZ", nonProfit2.getName());
  }

  @Test
  void getCollections() {
    ArrayList<AbstractDonation> expected = new ArrayList<AbstractDonation>();
    expected.add(oneTimeDonation1);
    assertEquals(expected, nonProfit2.getCollections());
  }

  @Test
  void receiveDonation() {
    ArrayList<AbstractDonation> expected = new ArrayList<AbstractDonation>();
    expected.add(oneTimeDonation1);
    expected.add(pledge1);
    nonProfit2.receiveDonation(pledge1);
    assertEquals(expected, nonProfit2.getCollections());
  }

  @Test
  void removeAllDonations() {
    nonProfit2.removeAllDonations();
    ArrayList<AbstractDonation> expected = new ArrayList<AbstractDonation>();
    assertEquals(expected, nonProfit2.getCollections());
  }

  @Test
  void remove() {
    ArrayList<AbstractDonation> noChange = new ArrayList<AbstractDonation>();
    noChange.add(oneTimeDonation1);
    nonProfit2.remove(pledge1);
    assertEquals(noChange, nonProfit2.getCollections());
    nonProfit2.remove(oneTimeDonation1);
    ArrayList<AbstractDonation> expected = new ArrayList<AbstractDonation>();
    assertEquals(expected, nonProfit2.getCollections());
  }

  @Test
  void getTotalDonationsForYear() {
    assertEquals(2560.0, nonProfit1.getTotalDonationsForYear(2020));
  }

  @Test
  void testEquals() {
    assertTrue(nonProfit1.equals(nonProfit1) == nonProfit1.equals(nonProfit1));
    //test symmetry
    assertTrue(nonProfit1.equals(nonProfit1Copy) == nonProfit1Copy.equals(nonProfit1));
    //test transitivity
    assertTrue(nonProfit1.equals(nonProfit1Copy) && nonProfit1Copy.equals(nonProfit1Imposter)
        && nonProfit1Imposter.equals(nonProfit1));
    //test null reference
    assertFalse(nonProfit1.equals(null));
    //test consistency
    assertTrue(nonProfit1.equals(nonProfit1Copy));
    assertTrue(nonProfit1.equals(nonProfit1Copy));
    //test equals where equal should be false
    assertFalse(nonProfit1.equals(nonProfit2));
    assertFalse(nonProfit1.equals(noDonations));
  }

  @Test
  void testHashCode() {
    //test null
    assertFalse(0 == nonProfit1.hashCode());
    //test consistency
    int testHashCode = nonProfit1.hashCode();
    assertEquals(testHashCode, nonProfit1.hashCode());
  }

  @Test
  void testToString() {
    String expected = "NonProfit{" +
        "name='" + "ZZZ" + '\'' +
        ", collections=" + "[OneTimeDonation:amount=200.0, dateTime=2020-11-11T11:11:11]" +
        '}';
    assertEquals(expected, nonProfit2.toString());
  }
}
package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseTest {

  private Course computerEng;
  private Course computerEngCopy;
  private Course computerEngImposter;
  private Course mechanicalEng;

  @BeforeEach
  void setUp() {
    computerEng = new Course("ComputerEng", "CS", 1);
    mechanicalEng = new Course("MechanicalEng", "ME", 1);
    computerEngCopy = new Course("ComputerEng", "CS", 1);
    computerEngImposter = new Course("ComputerEng", "CS", 1);
  }

  @Test
  void testToString() {
    String expected = "CS" + "1" + ": " + "ComputerEng";
    assertEquals(expected, computerEng.toString());
  }

  @Test
  void testEquals() {
    assertTrue(computerEng.equals(computerEng) == computerEng.equals(computerEng));
    //test symmetry
    assertTrue(computerEng.equals(computerEngCopy) == computerEngCopy.equals(computerEng));
    //test transitivity
    assertTrue(computerEng.equals(computerEngCopy) && computerEngCopy.equals(computerEngImposter)
        && computerEng.equals(computerEngImposter));
    //test null reference
    assertFalse(computerEng.equals(null));
    //test consistency
    assertTrue(computerEng.equals(computerEngCopy));
    assertTrue(computerEng.equals(computerEngCopy));
    //test equals where equal should be false
    assertFalse(computerEng.equals(mechanicalEng));
  }


  @Test
  void testHashCode() {
    //test null
    assertFalse(0 == computerEng.hashCode());
    //test consistency
    int testHashCode = computerEng.hashCode();
    assertEquals(testHashCode, computerEng.hashCode());
  }
}
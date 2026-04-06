package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseCatalogTest {

  private Course mechanicalEng;
  private Course computerEng;
  private Course maths;
  private Course economics;
  private Course accounting;
  private Course history;
  private CourseCatalog catalogOne;
  private CourseCatalog catalogTest;
  private CourseCatalog catalogOneCopy;
  private CourseCatalog catalogTwo;

  @BeforeEach
  void setUp() {
    mechanicalEng = new Course("MechanicalEng", "ME", 1);
    computerEng = new Course("ComputerEng", "CS", 1);
    maths = new Course("Maths", "math", 2);
    economics = new Course("Economics", "ECON", 2);
    accounting = new Course("Accounting", "ACCT", 3);
    history = new Course("History", "HIST", 4);
    catalogOne = new CourseCatalog();
    catalogOne.append(maths);
    catalogOne.append(history);
    catalogOne.append(accounting);
    catalogOne.append(economics);
    catalogOne.append(computerEng);
    catalogOneCopy = new CourseCatalog();
    catalogOneCopy.append(maths);
    catalogOneCopy.append(history);
    catalogOneCopy.append(accounting);
    catalogOneCopy.append(economics);
    catalogOneCopy.append(computerEng);
    catalogTwo = new CourseCatalog();
    catalogTwo.append(maths);
  }

  @Test
  void append() {
    catalogTest = new CourseCatalog();
    catalogTest.append(maths);
    catalogTest.append(history);
    catalogTest.append(accounting);
    catalogTest.append(economics);
    catalogTest.append(computerEng);
    assertEquals(catalogOne, catalogTest);
    assertTrue(5 == catalogTest.count());
    //Test resizeCopy
    catalogTest.append(maths);
    catalogTest.append(history);
    catalogTest.append(accounting);
    catalogTest.append(economics);
    catalogTest.append(computerEng);
    catalogTest.append(mechanicalEng);
    catalogTest.append(maths);
    assertTrue(12 == catalogTest.count());
  }

  @Test
  void remove() throws CourseNotFoundException {
    catalogTest = new CourseCatalog();
    catalogTest.append(maths);
    catalogTest.append(history);
    catalogTest.append(accounting);
    catalogTest.append(economics);
    catalogTest.append(computerEng);
    catalogTest.append(mechanicalEng);
    assertTrue(6 == catalogTest.count());
    catalogTest.remove(mechanicalEng);
    assertTrue(5 == catalogTest.count());
    assertEquals(catalogOne, catalogTest);
  }

  @Test
  void testCourseNotFound() {
    catalogTest = new CourseCatalog();
    catalogTest.append(computerEng);
    assertThrows(CourseNotFoundException.class, () -> catalogTest.remove(maths));
  }

  @Test
  void contains() {
    assertEquals(true, catalogOne.contains(maths));
    assertEquals(false, catalogOne.contains(mechanicalEng));
  }

  @Test
  void indexOf() {
    assertEquals(0, catalogOne.indexOf(maths));
    assertEquals(4, catalogOne.indexOf(computerEng));
    assertEquals(-1, catalogOne.indexOf(mechanicalEng));
  }

  @Test
  void count() {
    assertEquals(5, catalogOne.count());
  }

  @Test
  void get() throws InvalidIndexException {
    assertEquals(maths, catalogOne.get(0));
  }

  @Test
  void testInvalidIndex() {
    assertThrows(InvalidIndexException.class, () -> catalogOne.get(-1));
    assertThrows(InvalidIndexException.class, () -> catalogOne.get(20));
  }

  @Test
  void isEmpty() {
    assertEquals(false, catalogOne.isEmpty());
    catalogTest = new CourseCatalog();
    assertEquals(true, catalogTest.isEmpty());
  }

  @Test
  void testEquals() {
    assertTrue(catalogOne.equals(catalogOne) == catalogOne.equals(catalogOne));
    //test symmetry
    assertTrue(catalogOneCopy.equals(catalogOne) == catalogOne.equals(catalogOneCopy));
    //test null reference
    assertFalse(catalogOneCopy.equals(null));
    //test equals where equal should be false
    assertFalse(catalogOneCopy.equals(catalogTwo));
  }

  @Test
  void testHashCode() {
    //test null
    assertFalse(0 == catalogOne.hashCode());
    //test consistency
    int testHashCode = catalogOne.hashCode();
    assertEquals(testHashCode, catalogOne.hashCode());
  }

  @Test
  void testToString() {
    String expected = "CourseCatalog{" +
        "courseCatalog=" + "[math2: Maths, null, null, null, null, null, null, null, null, null]" +
        ", numberOfCourses=" + "1" +
        '}';
    assertEquals(expected, catalogTwo.toString());
  }
}
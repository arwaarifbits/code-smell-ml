package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetTest {

  private Set set1;
  private Set set2;
  private Set setTest;
  private Set set1Copy;
  private Set set1DifferentOrder;

  @BeforeEach
  void setUp() {
    set1 = new Set();
    set1.add(1);
    set1.add(2);
    set1.add(3);
    set2 = new Set();
    set2.add(2);
    set2.add(4);
    set1Copy = new Set();
    set1Copy.add(1);
    set1Copy.add(2);
    set1Copy.add(3);
    set1DifferentOrder = new Set();
    set1DifferentOrder.add(2);
    set1DifferentOrder.add(3);
    set1DifferentOrder.add(1);
  }

  @Test
  void emptySet() {
    setTest = set1.emptySet();
    assertEquals(0, setTest.size());
  }

  @Test
  void isEmpty() {
    setTest = set1.emptySet();
    assertEquals(true, setTest.isEmpty());
    assertEquals(false, set1.isEmpty());
  }

  @Test
  void add() {
    setTest = set1.emptySet();
    setTest.add(1);
    setTest.add(2);
    setTest.add(3);
    assertEquals(set1, setTest);
    setTest.add(4);
    setTest.add(5);
    setTest.add(6);
    setTest.add(7);
    setTest.add(8);
    setTest.add(9);
    setTest.add(10);
    setTest.add(11);
    setTest.add(12);
    assertEquals(12, setTest.size());
  }

  @Test
  void contains() {
    assertEquals(true, set1.contains(1));
    assertEquals(false, set1.contains(10));
  }

  @Test
  void remove() {
    assertEquals(true, set1.contains(1));
    assertEquals(true, set1.contains(2));
    assertEquals(true, set1.contains(3));
    Set setTest = set1.remove(1);
    assertEquals(false, setTest.contains(1));
    assertEquals(true, setTest.contains(2));
    assertEquals(true, setTest.contains(3));
    assertEquals(2, setTest.size());
    Set setTest2 = setTest.remove(10);
    assertEquals(true, setTest2.contains(2));
    assertEquals(true, setTest2.contains(3));
    assertEquals(2, setTest2.size());
  }

  @Test
  void size() {
    assertEquals(3, set1.size());
  }

  @Test
  void testEquals() {
    assertTrue(set1.equals(set1));
    assertTrue(set1.equals(set1Copy));
    assertTrue(set1.equals(set1DifferentOrder));
    assertFalse(set1.equals(set2));
  }

  @Test
  void testHashCode() {
    //test null
    assertFalse(0 == set1.hashCode());
    //test consistency
    int testHashCode = set1.hashCode();
    assertEquals(testHashCode, set1.hashCode());
  }

  @Test
  void testToString() {
    String expected = "Set{" +
        "items=" + "[1, 2, 3, null, null, null, null, null, null, null]" +
        ", size=" + "3" +
        '}';
    assertEquals(expected, set1.toString());
  }
}
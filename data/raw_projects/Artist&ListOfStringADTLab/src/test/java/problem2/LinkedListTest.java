package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTest {

  private LinkedList list1;
  private LinkedList list2;
  private String string;
  private String notContain;
  @BeforeEach
  void setUp() {
    list1 = new LinkedList();
    list2 = new LinkedList();
    string = "I";
    notContain = "U";
  }

  @Test
  void add() {
    list1.add("love");
    assertEquals("love", list1.getHead().getStringValue());
  }

  @Test
  void isEmpty() {
    assertTrue(list2.isEmpty());
  }

  @Test
  void size() {
    assertEquals(0,list1.size());
  }

  @Test
  void contains() {
    list1.add(string);
    assertTrue(list1.contains(string));
    assertFalse(list1.contains(notContain));
  }

  @Test
  void containsAll() {
    list1.add("A");
    list1.add("E");
    list1.add("I");
    list2.add("O");
    list2.add("k");
    assertFalse(list1.containsAll(list2));
  }

  @Test
  void hasDuplicates() {
    list1.add("A");
    list1.add("A");
    list1.add("B");
    assertTrue(list1.hasDuplicates());
  }

  @Test
  void removeDuplicates() {
    list1.add("A");
    list1.add("A");
    list1.add("B");
    assertEquals("A",list1.removeDuplicates().getHead().getStringValue());
  }

  @Test
  void filterLargerThan(){
    list1.add("ABC");
    list1.add("A");
    list1.add("BCD");
    assertEquals("A",list1.filterLargerThan(2).getHead().getStringValue());
  }

  @Test
  void getHead() {
    assertEquals(null, list1.getHead());
  }
}
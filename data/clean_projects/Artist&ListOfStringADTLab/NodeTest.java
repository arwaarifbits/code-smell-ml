package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NodeTest {
  private Node node;
  private Node node2;
  private Node node3;
  @BeforeEach
  void setUp() {
    node = new Node("baby",null);
    node2 = new Node("love", node);
    node3 = new Node("you",null);
  }

  @Test
  void testGetStringValue() {
    assertEquals("baby",node.getStringValue());
  }

  @Test
  void testGetNext() {
    assertEquals(node,node2.getNext());
  }

  @Test
  void testSetNext() {
    node.setNext(node3);
    assertEquals(node3,node.getNext());
  }
}
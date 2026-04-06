package problem2;

import java.util.Objects;

/**
 * This is a Node class, represent a Node object with string value and next Node
 */
public class Node {

  private String stringValue;
  private Node next;

  /**
   * Constructor for the Node Class, create a node object with specific string value and next Node.
   *
   * @param stringValue - string value that the node store, string
   * @param next        - next Node, Node Class
   */
  public Node(String stringValue, Node next) {
    this.stringValue = stringValue;
    this.next = next;
  }

  /**
   * Return the String Value, string
   *
   * @return the stringValue
   */
  public String getStringValue() {
    return stringValue;
  }

  /**
   * Return the next node, Node Class
   *
   * @return the next
   */
  public Node getNext() {
    return next;
  }

  /**
   * Set the next Node, convenient to change the tail to remove and add the node in linked list
   *
   * @param next - the next node, Node class
   */
  public void setNext(Node next) {
    this.next = next;
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
    Node node = (Node) o;
    return stringValue.equals(node.stringValue) && next.equals(node.next);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(stringValue, next);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Node{" +
        "stringValue='" + stringValue + '\'' +
        ", next=" + next +
        '}';
  }
}

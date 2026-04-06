package problem2;

import java.util.Objects;

public class LinkedList implements ListOfString {

  private Integer listSize;
  private Node head;

  /**
   * Constructor for the linked list, create a new linked list, initialize it with size 0 and null
   * head
   */
  public LinkedList() {
    this.listSize = 0;
    this.head = null;
  }

  /**
   * Add the string into the linked list
   *
   * @param string string will be added
   */
  @Override
  public void add(String string) {
    //create a new node
    Node newNode = new Node(string, null);
    //If the Linked List is empty, make the new node as head
    if (this.head == null) {
      this.head = newNode;
    } else {
      //else traverse till the last node
      //and insert the new node there
      Node curr = this.head;
      while (curr.getNext() != null) {
        curr = curr.getNext();
      }
      curr.setNext(newNode);
    }
    //update size
    this.listSize += 1;
  }

  /**
   * Checks whether the list is empty.
   *
   * @return True if the list is empty otherwise False
   */
  @Override
  public boolean isEmpty() {
    return this.listSize == 0;
  }

  /**
   * Gets the total number of elements in the list
   *
   * @return the size of the linked list, integer
   */
  @Override
  public Integer size() {
    return this.listSize;
  }

  /**
   * Consumes a String, and checks if the String is in the list or not.
   *
   * @param string - another string
   * @return True if the String is in the list, otherwise False
   */
  @Override
  public boolean contains(String string) {
    Node curr = this.head;
    //traversal
    while (curr != null) {
      if (curr.getStringValue() == string) {
        return true;
      }
      curr = curr.getNext();
    }
    return false;
  }

  /**
   * Consumes another list of Strings, and checks that all elements of this list are in the list
   * passed as argument.
   *
   * @param list - another list of strings
   * @return True if all elements of this list are in the list passed as argument otherwise False
   */
  @Override
  public boolean containsAll(LinkedList list) {
    Node curr = this.head;
    //traversal
    while (curr != null) {
      if (!list.contains(curr.getStringValue())) {
        return false;
      }
      curr = curr.getNext();
    }
    return true;
  }

  /**
   * Check if the list has at least one duplicate element
   *
   * @return True if list has at least one duplicate element otherwise False
   */
  @Override
  public boolean hasDuplicates() {
    while (this.head.getNext() != null) { //iterate the head
      //starting from the next
      Node curr = head.getNext();
      while (curr != null) { // iterate the curr
        //if duplicate node is found
        if (head.getStringValue() == curr.getStringValue()) {
          return true;
        }
        curr = curr.getNext();
      }
      head = head.getNext();
    }
    return false;
  }

  /**
   * Return the list with all duplicates removed
   *
   * @return the list with all duplicates removed
   */
  @Override
  public LinkedList removeDuplicates() {
    LinkedList newList = new LinkedList();
    Node curr = this.head;
    while (curr != null) {
      if (!newList.contains(curr.getStringValue())) {
        newList.add(curr.getStringValue());
      }
      curr = curr.getNext();
    }
    return newList;
  }

  /**
   * Takes the maximum String length, and returns a list with all elements whose length is greater
   * than the maximum length removed
   *
   * @param length - maximum string length
   * @return returns a list with all elements whose length is greater than the maximum length
   * removed
   */
  @Override
  public LinkedList filterLargerThan(Integer length) {
    LinkedList newList = new LinkedList();
    Node curr = this.head;
    while (curr != null) {
      if (curr.getStringValue().length() <= length) {
        newList.add(curr.getStringValue());
      }
      curr = curr.getNext();
    }
    return newList;
  }

  /**
   * Return the head node, node class
   *
   * @return the linked list head node
   */
  public Node getHead() {
    return this.head;
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
    LinkedList that = (LinkedList) o;
    return listSize.equals(that.listSize) && head.equals(that.head);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(listSize, head);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "LinkedList{" +
        "listSize=" + listSize +
        ", head=" + head +
        '}';
  }
}

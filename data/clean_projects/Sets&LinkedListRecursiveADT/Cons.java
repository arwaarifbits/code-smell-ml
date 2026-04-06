package problem1;

import java.util.Objects;

public class Cons implements List {

  private Integer first;
  private List rest;

  public Cons(Integer first, List rest) {
    this.first = first;
    this.rest = rest;
  }

  public Integer getFirst() {
    return this.first;
  }

  public List getRest() {
    return this.rest;
  }

  @Override
  public Integer size() {
    return 1 + this.getRest().size();
  }

  @Override
  public Boolean isEmpty() {
    return false;
  }

  @Override
  public List add(Integer element) {
    return new Cons(element, this);
  }

  @Override
  public Integer last() {
    if (this.rest.isEmpty()) {
      return this.first;
    } else {
      return this.rest.last();
    }
  }

  @Override
  public Boolean contains(int element) {
    if (this.isEmpty()) {
      return false;
    } else {
      return this.getFirst().equals(element) || this.getRest().contains(element);
    }
  }

  @Override
  public Integer elementAt(int index) throws InvalidCallException {
    if (index < 0 || index > this.size()) {
      throw new InvalidCallException("Index out of bound!");
    }
    if (index == 0) {
      return this.getFirst();
    }
    return this.rest.elementAt(index - 1);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cons cons = (Cons) o;
    return Objects.equals(first, cons.first) && Objects.equals(rest, cons.rest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(first, rest);
  }

  @Override
  public String toString() {
    return "Cons{" +
        "first=" + this.first +
        ", rest=" + this.rest +
        '}';
  }
}

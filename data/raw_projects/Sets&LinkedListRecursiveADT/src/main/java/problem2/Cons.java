package problem2;

import java.util.Objects;

public class Cons implements Set {

  private Integer first;
  private Set rest;

  public Cons(Integer first, Set rest) {
    this.first = first;
    this.rest = rest;
  }


  @Override
  public Set emptySet() {
    return null;
  }

  @Override
  public Boolean isEmpty() {
    return false;
  }

  @Override
  public Set add(Integer n) {
    if (this.contains(n)) {
      return this;
    }
    return new Cons(n, this);
  }

  @Override
  public Boolean contains(Integer n) {
    if (this.first == n) {
      return true;
    }
    return this.rest.contains(n);
  }

  @Override
  public Set remove(Integer n) {
    if (!this.contains(n)) {
      return this;
    }
    if (this.first == n) {
      return this.rest;
    }
    return new Cons(this.first, this.rest.remove(n));
  }

  @Override
  public Integer size() {
    return 1 + this.rest.size();
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

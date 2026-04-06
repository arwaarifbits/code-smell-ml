package problem2;

public class Empty implements Set {

  public Empty() {
  }

  @Override
  public Set emptySet() {
    return null;
  }

  @Override
  public Boolean isEmpty() {
    return true;
  }

  @Override
  public Set add(Integer n) {
    return new Cons(n, this);
  }

  @Override
  public Boolean contains(Integer n) {
    return false;
  }

  @Override
  public Set remove(Integer n) {
    return this;
  }

  @Override
  public Integer size() {
    return 0;
  }

  @Override
  public String toString() {
    return "Empty{}";
  }
}

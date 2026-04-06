package problem1;

public class Empty implements List {

  public Empty() {
  }

  @Override
  public Integer size() {
    return 0;
  }

  @Override
  public Boolean isEmpty() {
    return true;
  }

  @Override
  public List add(Integer element) {
    return new Cons(element, this);
  }

  @Override
  public Integer last() throws InvalidCallException {
    throw new InvalidCallException("Cannot use last() on empty linkedList!");
  }

  @Override
  public Boolean contains(int element) {
    return false;
  }

  @Override
  public Integer elementAt(int index) throws InvalidCallException {
    throw new InvalidCallException("Cannot use elementAt() on empty linkedList!");
  }

  @Override
  public String toString() {
    return "Empty{}";
  }
}

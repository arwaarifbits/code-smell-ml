package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem1.Athlete;

class PosnTest {
  Posn posnOne;
  Posn posnTwo;
  Posn posnOneEq;
  Posn xNull;
  Posn yNull;
  Posn xyNull;
  Double test;
  Posn xyNull2;
  @BeforeEach
  void setUp() {
    posnOne = new Posn(10,20);
    posnTwo = new Posn(20, 10);
    posnOneEq = new Posn(10, 20);
    xNull = new Posn(null,20);
    yNull = new Posn(10, null);
    xyNull = new Posn(null, null);
    xyNull2 = new Posn(null, null);
    test = 10.0;
  }

  @Test
  void getX() {
    assertEquals(10, posnOne.getX());
  }

  @Test
  void getY() {
    assertEquals(20, posnOne.getY());
  }

  @Test
  void testEquals() {
    assertFalse(posnOne.equals(test));
    assertFalse(posnOne.equals(posnTwo));
    assertTrue(posnOne.equals(posnOne));
    assertTrue(posnOne.equals(posnOneEq));
    assertFalse(posnOne.equals(xNull));
    assertFalse(posnOne.equals(yNull));
    assertFalse(posnOne.equals(xyNull));
    assertTrue(xyNull.equals(xyNull2));
  }

  @Test
  void testHashCode() {
    assertTrue(posnOne.hashCode() != posnTwo.hashCode());
    assertTrue(posnOne.hashCode() == posnOne.hashCode());
    assertTrue(posnOne.hashCode() != xNull.hashCode());
    assertTrue(posnOne.hashCode() == posnOneEq.hashCode());
    assertTrue(xyNull2.hashCode() == xyNull.hashCode());
  }
  @Test
  void testToString() {
    assertEquals("Posn{x=10, y=20}",posnOne.toString());
  }
}
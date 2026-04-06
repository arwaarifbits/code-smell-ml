package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PastaTest {
  private Pasta pasta;
  @BeforeEach
  void setUp() throws IncorrectQuantityException {
    pasta = new Pasta("Ita",2.2,30);
  }

  @Test
  void getName(){
    assertEquals("Ita",pasta.getName());
  }

  @Test
  void getQuantity(){
    assertEquals(30,pasta.getAvailableQuantity());
  }

  @Test
  void getPrice(){
    assertEquals(2.2, pasta.getPricePerUnit());
  }


}
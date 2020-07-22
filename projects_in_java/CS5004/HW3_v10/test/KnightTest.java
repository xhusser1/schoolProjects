import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * A junit test for the Knight class.
 */

public class KnightTest {
  private Knight blackKnight1;
  private Knight whiteKnight1;
  private Knight whiteKnight2;

  @Before
  public void setUp() {
    blackKnight1 = new Knight(4, 3, Color.BLACK);
    whiteKnight1 = new Knight(2, 4, Color.WHITE);
    whiteKnight2 = new Knight(0, 7, Color.WHITE);
  }

  @Test
  public void testConstructor() {
    assertEquals(4,blackKnight1.getRow());
    assertEquals(3,blackKnight1.getColumn());
    assertEquals(Color.BLACK, blackKnight1.getColor());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructorException() {
    Knight invalidKnight = new Knight(-1,-5,Color.BLACK);
    assertEquals("Row and Column cannot be negative", invalidKnight);
  }

  @Test
  public void testCanMove() {
    assertTrue(blackKnight1.canMove(2, 2));
  }

  @Test
  public void testIllegalMove() {
    assertFalse(whiteKnight1.canMove(1,7));
  }

  @Test
  public void testCanKill() {
    assertTrue(blackKnight1.canKill(whiteKnight1));
  }

  @Test
  public void testCanKill2() {
    assertFalse(blackKnight1.canKill(whiteKnight2));
  }
}
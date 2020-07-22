import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * A junit test for the queen class.
 */
public class QueenTest {
  private Queen whiteQueen1;
  private Queen blackQueen1;
  private Queen blackQueen2;

  @Before
  public void setUp() {
    whiteQueen1 = new Queen(0, 4, Color.WHITE);
    blackQueen1 = new Queen(6, 4, Color.BLACK);
    blackQueen2 = new Queen(6, 1,Color.BLACK);

  }

  @Test
  public void testConstructor() {
    assertEquals(6,blackQueen1.getRow());
    assertEquals(4,blackQueen1.getColumn());
    assertEquals(Color.BLACK, blackQueen1.getColor());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructorException() {
    Queen invalidQueen = new Queen(0,-1,Color.WHITE);
    assertEquals("Row and Column cannot be negative", invalidQueen);
  }

  @Test
  public void testCanMove() {
    assertTrue(whiteQueen1.canMove(1, 3));
    assertTrue(blackQueen1.canMove(5,3));
  }

  @Test
  public void testIllegalMove() {
    assertFalse(whiteQueen1.canMove(1,7));
    assertFalse(blackQueen1.canMove(5,1));
  }

  @Test
  public void testCanKill() {
    assertTrue(blackQueen1.canKill(whiteQueen1));
  }

  @Test
  public void testCanKill2() {
    assertFalse(whiteQueen1.canKill(blackQueen2));
  }
}
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * A junit test for the bishop class with legal data.
 */
public class BishopTest {
  private Bishop blackBishop1;
  private Bishop whiteBishop1;

  @Before
  public void setUp() {
    blackBishop1 = new Bishop(5,6,Color.BLACK);
    whiteBishop1 = new Bishop(2,3,Color.WHITE);

  }

  @Test
  public void testConstructor() {
    assertEquals(5,blackBishop1.getRow());
    assertEquals(6,blackBishop1.getColumn());
    assertEquals(Color.BLACK, blackBishop1.getColor());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructorException() {
    Bishop invalidBishop1 = new Bishop(-2,-2,Color.WHITE);
    assertEquals("Row and Column cannot be negative", invalidBishop1);
  }

  @Test
  public void testCanMove1() {
    assertTrue(whiteBishop1.canMove(5,6));
    assertTrue(whiteBishop1.canMove(1, 2));
  }

  @Test
  public void testCanMove2() {
    assertFalse(whiteBishop1.canMove(3,3));
  }

  @Test
  public void testCanKill() {
    assertTrue(whiteBishop1.canMove(5,6));
    assertTrue(whiteBishop1.canKill(blackBishop1));
  }
}
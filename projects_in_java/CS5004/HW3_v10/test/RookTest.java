import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * A junit test for the Rook class.
 */
public class RookTest {
  private Rook blackRook1;
  private Rook whiteRook1;
  private Rook whiteRook2;
  private Rook blackRook2;


  @Before
  public void setUp() {
    blackRook1 = new Rook(7,7,Color.BLACK);
    whiteRook1 = new Rook(2, 3, Color.WHITE);
    whiteRook2 = new Rook(1, 5, Color.WHITE);
    blackRook2 = new Rook(5, 0, Color.BLACK);
  }

  @Test
  public void testConstructor() {
    assertEquals(7,blackRook1.getRow());
    assertEquals(7,blackRook1.getColumn());
    assertEquals(Color.BLACK, blackRook1.getColor());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructorException() {
    Rook invalidRook = new Rook(-1,-5,Color.WHITE);
    assertEquals("Row and Column cannot be negative", invalidRook);
  }

  @Test
  public void testCanMove() {
    assertTrue(blackRook1.canMove(7, 6));
    assertTrue(whiteRook1.canMove(2, 7));
  }

  @Test
  public void testCanMoveException() {
    assertFalse(whiteRook1.canMove(1,6));
  }

  @Test
  public void testCanKill() {
    whiteRook1 = new Rook(2,7, Color.WHITE);
    assertTrue(blackRook1.canKill(whiteRook1));
  }

  @Test
  public void testCanKill2() {
    assertTrue(whiteRook2.canMove(1, 4));
    assertFalse(whiteRook2.canKill(blackRook2));
  }










}
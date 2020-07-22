import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * A junit test for the Pawn class.
 */
public class PawnTest {
  private Pawn blackPawn1;
  private Pawn whitePawn1;
  private Pawn blackPawn2;

  @Before
  public void setUp() {
    blackPawn1 = new Pawn(4, 1,  Color.BLACK);
    whitePawn1 = new Pawn(3, 0, Color.WHITE);
    blackPawn2 = new Pawn(6, 7, Color.BLACK);
  }

  @Test
  public void testConstructor() {
    assertEquals(4,blackPawn1.getRow());
    assertEquals(1,blackPawn1.getColumn());
    assertEquals(Color.BLACK, blackPawn1.getColor());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructorException() {
    Pawn invalidPawn = new Pawn(0,-1,Color.WHITE);
    assertEquals("Row and Column cannot be negative", invalidPawn);
  }

  @Test
  public void testCanMove() {
    assertTrue(blackPawn1.canMove(3, 1));
  }

  @Test
  public void testIllegalMove() {
    assertFalse(whitePawn1.canMove(5, 2));
    assertFalse(blackPawn1.canMove(7, 0));
  }

  @Test
  public void testCanKill() {
    assertTrue(whitePawn1.canKill(blackPawn1));
  }

  @Test
  public void testCanKill2() {
    assertFalse(blackPawn2.canKill(whitePawn1));
  }

}
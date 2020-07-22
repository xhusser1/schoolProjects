import org.junit.Test;

import cs5004.marblesolitaire.model.MarbleSolitaireModel;
import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * A test suite for the marble solitaire model. Verifying that game state is properly managed, and
 * all game actions are properly validated.
 */
public class MarbleSolitaireModelImplTest {


  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRow() {
    MarbleSolitaireModelImpl msmI = new MarbleSolitaireModelImpl(-1, 3);
    assertEquals("Invalid empty cell position (r,c)", msmI.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidColumn() {
    MarbleSolitaireModelImpl msmI = new MarbleSolitaireModelImpl(3, -3);
    assertEquals("Invalid empty cell position (r,c)", msmI.getGameState());
  }

  @Test
  public void testConstructor1() {
    MarbleSolitaireModel mm1 = new MarbleSolitaireModelImpl();

    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", mm1.getGameState());
  }

  @Test
  public void testConstructor2() {
    MarbleSolitaireModel mm1 = new MarbleSolitaireModelImpl(3, 3);

    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", mm1.getGameState());
  }

  @Test
  public void testConstructor3() {
    MarbleSolitaireModel mm1 = new MarbleSolitaireModelImpl(3);

    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", mm1.getGameState());
  }

  @Test
  public void testConstructor4() {
    MarbleSolitaireModel mm1 = new MarbleSolitaireModelImpl(3, 3, 3);

    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", mm1.getGameState());
  }

  @Test
  public void move() {
    MarbleSolitaireModelImpl msm4 = new MarbleSolitaireModelImpl(3, 3, 3);
    msm4.move(1, 3, 3, 3);
    assertEquals("    O O O\n"
            + "    O _ _\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", msm4.getGameState());

  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove() {
    MarbleSolitaireModel mm1 = new MarbleSolitaireModelImpl();
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", mm1.getGameState());
  }

  @Test
  public void isGameOver() {
    MarbleSolitaireModelImpl msm4 = new MarbleSolitaireModelImpl(3, 3, 3);
    msm4.move(5, 3, 3, 3);
    assertFalse(msm4.isGameOver());
    msm4.move(4, 5, 4, 3);
    msm4.move(2, 5, 4, 5);
    msm4.move(4, 6, 4, 4);
    msm4.move(2, 6, 4, 6);
    msm4.move(3, 3, 5, 3);
    msm4.move(6, 3, 4, 3);
    msm4.move(4, 3, 4, 5);
    msm4.move(4, 6, 4, 4);
    msm4.move(1, 3, 3, 3);
    msm4.move(4, 1, 4, 3);
    msm4.move(4, 3, 4, 5);
    msm4.move(6, 2, 4, 2);
    msm4.move(3, 2, 5, 2);
    msm4.move(6, 4, 4, 4);
    msm4.move(2, 1, 4, 1);
    msm4.move(4, 0, 4, 2);
    msm4.move(5, 2, 3, 2);
    msm4.move(2, 0, 4, 0);
    msm4.move(4, 5, 4, 3);
    msm4.move(4, 3, 2, 3);
    msm4.move(2, 2, 4, 2);
    msm4.move(0, 2, 2, 2);
    msm4.move(0, 4, 0, 2);
    msm4.move(2, 4, 0, 4);
    msm4.move(2, 3, 2, 1);
    assertTrue(msm4.isGameOver());
    assertEquals(6, msm4.getScore());
    assertEquals("    O _ O\n"
            + "    _ _ _\n"
            + "_ O _ _ _ _ _\n"
            + "_ _ _ _ O _ _\n"
            + "O _ O _ _ _ _\n"
            + "    _ _ _\n"
            + "    _ _ _", msm4.getGameState());

  }

  @Test
  public void getGameState() {
    MarbleSolitaireModel mm1 = new MarbleSolitaireModelImpl(3, 3, 3);

    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", mm1.getGameState());

  }

  @Test
  public void getScore() {
    MarbleSolitaireModelImpl msm4 = new MarbleSolitaireModelImpl(3, 3, 3);
    msm4.move(5, 3, 3, 3);
    assertFalse(msm4.isGameOver());
    msm4.move(4, 5, 4, 3);
    msm4.move(2, 5, 4, 5);
    msm4.move(4, 6, 4, 4);
    msm4.move(2, 6, 4, 6);
    msm4.move(3, 3, 5, 3);
    msm4.move(6, 3, 4, 3);
    assertEquals(25, msm4.getScore());
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O _ _\n"
            + "O O O _ O _ _\n"
            + "O O O O O _ O\n"
            + "    O _ O\n"
            + "    O _ O", msm4.getGameState());
  }
}
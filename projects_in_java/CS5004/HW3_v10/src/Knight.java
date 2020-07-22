/**
 * This represents a knight object.
 */
public class Knight extends AbstractChessPiece {

  /**
   * This construct a Knight object and initialize it
   * with a color type and location.
   *
   * @param pieceColor the enum of the piece.
   * @param row the row where the knight lies.
   * @param column the column where the knight lies.
   */
  public Knight(int row, int column, Color pieceColor) {
    super(row, column, pieceColor);
  }

  /**
   * Get the boolean value from a set of conditionals that determine if
   * a knight can make a valid move. A Knight can only move in a L pattern
   * two cells horizontally and one vertically or vice versa.
   * @param row the row that the knight will move to.
   * @param column the column that the knight will move to.
   * @return the boolean value of whether or not a move was valid.
   */
  @Override
  public boolean canMove(int row, int column) {
    return (Math.abs(this.row - row) == 2 && Math.abs(this.column - column) == 1)
            || (Math.abs(this.row - row) == 1 && Math.abs(this.column - column) == 2);
  }

  /**
   * Calling the canKill method from abstract class.
   * @param otherPiece the other chess piece.
   * @return the boolean value of whether a piece can kill another.
   */
  public boolean canKill(ChessPiece otherPiece) {
    return super.canKill(otherPiece);
  }
}

/**
 * This represents a rook object.
 */
public class Rook extends AbstractChessPiece {

  /**
   * This construct a Rook object and initialize it with
   * a color type and location.
   * @param pieceColor the enum of the piece.
   * @param row the row where the bishop lies.
   * @param column the column where the bishop lies.
   */
  public Rook(int row, int column, Color pieceColor) {
    super(row, column, pieceColor);
  }

  /**
   * Get the boolean value from a set of conditionals that determine if
   * a rook can make a valid move. A rook can move horizontally or vertically
   * so the difference between the row or column should be greater than zero.
   * @param row the row that the rook will move to.
   * @param column the column that the rook will move to.
   * @return the boolean value whether move is valid or not.
   */
  @Override
  public boolean canMove(int row, int column) {
    return (Math.abs(this.row - row) > 0 && this.column == column)
            || (Math.abs(this.column - column) > 0  && this.row == row);
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

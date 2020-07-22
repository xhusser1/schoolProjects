/**
 * This represents a Queen object.
 */
public class Queen extends AbstractChessPiece {

  /**
   * This construct a Queen object and initialize it with a
   * color type and position on the chess board.
   *
   * @param pieceColor the enum of the piece.
   * @param row the row where the queen lies.
   * @param column the column where the queen lies.
   */
  public Queen(int row, int column, Color pieceColor) {
    super(row, column, pieceColor);

  }

  /**
   * Get the boolean value from a set of conditionals to determine if
   * a queen can make a valid move. A queen can move horizontally, vertically,
   * and diagonally so it is a combination of rook and bishop movements.
   * @param row the row that the queen will move to.
   * @param column the column that the queen will move to.
   * @return the boolean value of whether a move was valid or not.
   */
  @Override
  public boolean canMove(int row, int column) {
    return (Math.abs(this.row - row) == Math.abs(this.column - column))
            || (Math.abs(this.row - row) > 0 && this.column == column)
            || (Math.abs(this.column - column) > 0 && this.row == row);
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


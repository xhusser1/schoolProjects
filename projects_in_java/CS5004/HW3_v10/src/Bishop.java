/**
 * This class represents a bishop object.
 */
public class Bishop extends AbstractChessPiece {

  /**
   * This construct a bishop object and initializes it with
   * a color type and position on the board.
   *
   * @param pieceColor the enum of the piece.
   * @param row the row where the bishop lies.
   * @param column the column where the bishop lies.
   */
  public Bishop(int row, int column, Color pieceColor) {
    super(row, column, pieceColor);
  }

  /**
   * Get the boolean value from a set of conditionals that determine if
   * a bishop can make a valid move. Bishops can only move diagonally
   * so if the difference of the row and columns are equal it is a valid move.
   *
   * @param row the row that the pawn will move to.
   * @param column the column that the pawn will move to.
   * @return the boolean value of whether or not a move is valid.
   */
  @Override
  public boolean canMove(int row, int column) {
    return Math.abs(this.row - row) == Math.abs(this.column - column);
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
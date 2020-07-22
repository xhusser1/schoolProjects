/**
 * This represents a pawn object.
 */
public class Pawn extends AbstractChessPiece {

  /**
   * This construct a Pawn object and initialize it with a color type and position.
   *
   * @param pieceColor the enum of the piece.
   * @param row the row where the pawn lies.
   * @param column the column where the pawn lies.
   */
  public Pawn(int row, int column, Color pieceColor) {
    super(row, column, pieceColor);
  }

  /**
   * Get the boolean value from a set of conditionals that determine if
   * a pawn can make a valid move. Pawns can only move forward one row
   * so if it is a black piece the difference from start row and end
   * row needs to be 1 and if it is white it needs to be -1.
   *
   * @param row the row that the pawn will move to.
   * @param column the column that the pawn will move to.
   * @return the boolean value of whether or not a move is valid.
   */
  @Override
  public boolean canMove(int row, int column) {
    return ((this.row - row == 1) && (this.getColor() == Color.BLACK) && (this.column == column))
            || ((this.row - row == -1) && (this.getColor() == Color.WHITE)
            && (this.column == column));
  }

  /**
   * In order for the pawn to kill it must move one place forward diagonally
   * so if the piece moves diagonally in the proper direction for its color and the
   * other chess piece is the opposite color then our pawn will be able to kill other pieces.
   *
   * @param otherPiece the other chess piece being examined in relation to this piece.
   * @return the boolean value of whether our piece is able to kill another chess piece.
   */
  @Override
  public boolean canKill(ChessPiece otherPiece) {
    return (((this.getColor() == Color.BLACK) && (otherPiece.getRow() - this.row == -1)
            && Math.abs(this.column - otherPiece.getColumn()) == 1)
            || ((this.getColor() == Color.WHITE) && (otherPiece.getRow() - this.row == 1)
            && Math.abs(this.column - otherPiece.getColumn()) == 1))
            && (this.getColor() != otherPiece.getColor());



  }
}

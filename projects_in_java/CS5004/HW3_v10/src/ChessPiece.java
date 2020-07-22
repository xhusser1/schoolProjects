/**
 * Represents the interface of a chess piece to be implemented in the
 * abstract chess class.
 */
public interface ChessPiece {

  /**
   * Get the integer value of the row.
   */
  int getRow();

  /**
   * Get the integer value of the column.
   */
  int getColumn();

  /**
   * Get the color type of the chess piece.
   */
  Color getColor();

  /**
   * Get the boolean value for if a chess piece can move.
   */
  boolean canMove(int row, int column);

  /**
   * Get the boolean value for if a chess piece can kill another.
   */
  boolean canKill(ChessPiece otherPiece);
}


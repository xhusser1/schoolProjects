/**
 * This represents an abstract chessPiece object to be extended
 * within the respective chess piece classes.
 */
public abstract class AbstractChessPiece implements ChessPiece {
  protected Color pieceColor;
  protected int row;
  protected int column;

  /**
   * This constructs an abstract chess piece object that
   * has a color enum, row, and column to be instantiated.
   *
   * @param pieceColor the color type of chess piece.
   * @param row the row of the chess piece.
   * @param column the column of the chess piece.
   * @throws IllegalArgumentException if row  or column is negative.
   */
  public AbstractChessPiece(int row, int column, Color pieceColor) throws IllegalArgumentException {
    if (row < 0  || column < 0 ) {
      throw new IllegalArgumentException("Row and Column cannot be negative");
      //size of the board
    } else if (row > 8  || column > 8) {
      throw new IllegalArgumentException("This is an 8x8 board");
    }
    this.pieceColor = pieceColor;
    this.row = row;
    this.column = column;
  }

  /**
   * Get the integer value of the row.
   *
   * @return the integer value of the row.
   */
  @Override
  public int getRow() {
    return this.row;
  }

  /**
   * Get the integer value of the column.
   *
   * @return the integer value of the column.
   */
  @Override
  public int getColumn() {
    return this.column;
  }

  /**
   * Get the Color type of the abstract chess piece.
   *
   * @return the color enum type.
   */
  @Override
  public Color getColor() {
    return this.pieceColor;
  }


  /**
   * Get the boolean value of whether a chess piece can move to the location
   * of another chess piece which counts as a kill.
   * @param otherPiece the other chess piece being examined.
   * @return the boolean value of whether a piece can kill another.
   */
  @Override
  public boolean canKill(ChessPiece otherPiece) {
    return this.canMove(otherPiece.getRow(), otherPiece.getColumn())
            && otherPiece.getColor() != this.getColor();
  }
}

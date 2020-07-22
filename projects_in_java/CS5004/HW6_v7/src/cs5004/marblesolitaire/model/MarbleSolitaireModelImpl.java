package cs5004.marblesolitaire.model;

/**
 * This represents a model of a Marble Solitaire game with row, column, and arm thickness.
 */
public class MarbleSolitaireModelImpl implements MarbleSolitaireModel {
  protected BoardOption[][] gameBoard;
  protected int pieces = 0;

  /**
   * This constructs a marble solitaire model without any parameters while initializing game board.
   */
  public MarbleSolitaireModelImpl() {
    this(3, 3, 3);
  }

  /**
   * This constructs a marble solitaire model with two parameters and initializes empty slot at sRow
   * and sCol.
   *
   * @param sRow the starting row.
   * @param sCol the starting column.
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) {
    this(3, sRow, sCol);

  }

  /**
   * This constructs a marble solitaire model passing in the armThickness and initializes game board
   * with empty slot at the center.
   *
   * @param armThickness the armthickness of rows.
   */
  public MarbleSolitaireModelImpl(int armThickness) {
    this(armThickness, ((armThickness - 1) * 3) / 2, ((armThickness - 1) * 3) / 2);
  }

  /**
   * This constructs a marble solitaire model passing in three parameters and take empty slot in row
   * and column along it also throws an exception if the arm thickness is not a positive number or
   * empty cell position is invalid.
   *
   * @param armThickness the armThickness of rows.
   * @param sRow         the starting row.
   * @param sCol         the starting column.
   * @throws IllegalArgumentException if the arm thickness is not a positive number.
   */
  public MarbleSolitaireModelImpl(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    if (sRow > 3 * armThickness - 2 || sRow < 0) {
      throw new IllegalArgumentException("Invalid empty cell position (r,c)");
    }

    if (sCol > 3 * armThickness - 2 || sCol < 0) {
      throw new IllegalArgumentException("Invalid empty cell position (r,c)");
    }

    if (armThickness % 2 == 0 || armThickness < 0) {
      throw new IllegalArgumentException("Invalid empty cell position (r,c)");
    }

    int length = 3 * armThickness - 2;
    int invalidArea = armThickness - 1;
    int space = armThickness * 2 - 2;
    gameBoard = new BoardOption[length][length];
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        if ((i < invalidArea
                && j < invalidArea)
                || (i < invalidArea
                && j > space)
                || (i > space
                && j < invalidArea)
                || (i > space
                && j > space)) {
          this.gameBoard[i][j] = BoardOption.BLANK;
        } else {
          this.gameBoard[i][j] = BoardOption.MARBLE;
          pieces++;
        }
      }
    }
    if (gameBoard[sRow][sCol] == BoardOption.BLANK) {
      throw new IllegalArgumentException("Invalid empty space");
    } else {
      gameBoard[sRow][sCol] = BoardOption.DASH;
      pieces--;
    }
  }

  /**
   * This protected method checks if a move that is made is valid or invalid when called within the
   * move method.
   *
   * @param fromRow the starting row.
   * @param fromCol the starting column.
   * @param toRow   the end row.
   * @param toCol   the end column.
   * @return boolean value of move is or is not valid.
   */
  protected boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
    return fromRow >= 0 && fromRow < gameBoard.length
            && fromCol >= 0
            && fromCol < gameBoard.length
            && toRow >= 0
            && toRow < gameBoard.length
            && toCol >= 0
            && toCol < gameBoard.length
            && gameBoard[fromRow][fromCol] == BoardOption.MARBLE
            && gameBoard[toRow][toCol] == BoardOption.DASH;
  }

  /**
   * Move a single marble from a given position to another given position. A move is valid only if
   * the from and to positions are valid. Specific implementations may place additional constraints
   * on the validity of a move.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0).
   * @param fromCol the column number of the position to be moved from (starts at 0).
   * @param toRow   the row number of the position to be moved to (starts at 0).
   * @param toCol   the column number of the position to be moved to (starts at 0).
   * @throws IllegalArgumentException if the move is not possible.
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
    if (!isValidMove(fromRow, fromCol, toRow, toCol)) {
      throw new IllegalArgumentException("invalid move");
    }

    if ((Math.abs(fromRow - toRow) != 2 && Math.abs(fromCol - toCol) != 2)
            || (Math.abs(fromRow - toRow) == 2 && fromCol != toCol)
            || (Math.abs(fromCol - toCol) == 2 && fromRow != toRow)) {
      throw new IllegalArgumentException("Must be two spaces away");
    }

    gameBoard[fromRow][fromCol] = BoardOption.DASH;
    gameBoard[toRow][toCol] = BoardOption.MARBLE;

    if (fromRow == toRow) {
      if (toCol < fromCol) {
        gameBoard[fromRow][fromCol - 1] = BoardOption.DASH;
      } else {
        gameBoard[fromRow][fromCol + 1] = BoardOption.DASH;
      }
    } else {
      if (toRow < fromRow) {
        gameBoard[fromRow - 1][fromCol] = BoardOption.DASH;
      } else {
        gameBoard[fromRow + 1][fromCol] = BoardOption.DASH;
      }
    }
    --pieces;
  }

  /**
   * Determine and return if the game is over or not. A game is over if no more valid moves can be
   * made.
   *
   * @return true if the game is over, false otherwise.
   */
  @Override
  public boolean isGameOver() {
    for (int i = 0; i < this.gameBoard.length; i++) {
      for (int j = 0; j < this.gameBoard[i].length; j++) {
        if (gameBoard[i][j] == BoardOption.MARBLE && isValidMove(i, j + 1, i, j + 2)) {
          return false;
        }
        if (gameBoard[i][j] == BoardOption.MARBLE && isValidMove(i, j - 1, i, j - 2)) {
          return false;
        }
        if (gameBoard[i][j] == BoardOption.MARBLE && isValidMove(i + 1, j, i + 2, j)) {
          return false;
        }

        if (gameBoard[i][j] == BoardOption.MARBLE && isValidMove(i - 1, j, i - 2, j)) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Return a string that represents the current state of the board. The string should have one line
   * per row of the game board. Each slot on the game board is a single character (O, X or space for
   * a marble, empty and invalid position respectively). Slots in a row should be separated by a
   * space. Each row has no space before the first slot and after the last slot.
   *
   * @return the game state as a string
   */
  @Override
  public String getGameState() {
    StringBuilder newBoard = new StringBuilder();
    for (BoardOption[] boardOptions : this.gameBoard) {
      StringBuilder row = new StringBuilder();
      for (BoardOption boardOption : boardOptions) {
        row.append(boardOption.toString()).append(" ");
      }
      row = new StringBuilder(removeTrails(row.toString()));
      newBoard.append(row).append("\n");
    }
    return newBoard.substring(0, newBoard.length() - 1);
  }

  /**
   * Returns the number of pieces currently on the board that is updated from the move function.
   *
   * @return the number of marbles currently on the board.
   */
  @Override
  public int getScore() {
    return this.pieces;
  }

  /**
   * This method will remove the whitespace trailing on the board when called in the getGameState
   * method.
   *
   * @param state the string representation of an object which in getGameState is the row.
   * @return a string value with a substring.
   */
  protected String removeTrails(String state) {
    int i;
    for (i = state.length() - 1; i > 0; --i) {
      if (!Character.isWhitespace(state.charAt(i - 1))) {
        break;
      }
    }
    return state.substring(0, i);
  }
}

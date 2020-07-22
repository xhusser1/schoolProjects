package cs5004.marblesolitaire.model;

/**
 * A Board enum that has the options of values that be passed in through constructors. The blank
 * represents an invalid piece, marble represents a game piece, and dash represents an empty space
 * where a piece could move to.
 */
public enum BoardOption {
  BLANK, MARBLE, DASH;

  /**
   * Utilizing switch cases to dispatch various executions based on the enum type.
   *
   * @return a string representation of either a marble, invalid piece, or empty space.
   */
  @Override
  public String toString() {
    switch (this) {
      case MARBLE:
        return "O";
      case DASH:
        return "_";
      default:
        return " ";
    }
  }
}



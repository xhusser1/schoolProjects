import java.util.NoSuchElementException;

/**
 * This is represents a rectangle class.
 */
public class Rectangle {
  private int x;
  private int y;
  private int width;
  private int height;

  /**
   * Constructs a Rectangle object and initialize it to the given x, y, width, and height.
   * @param x the x coordinate of the rectangle.
   * @param y  the y coordinate of the rectangle.
   * @param width the width of the rectangle.
   * @param height the height of the rectangle.
   * @throws IllegalArgumentException if the width and height of rectangle are negative.
   * @throws NoSuchElementException if no intersection exists.
   */
  public Rectangle(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("Neither Width nor Height can be negative");
    } else {
      this.width = width;
      this.height = height;
    }
  }

  /**
   * Get the value of x coordinate for the rectangle.
   *
   * @return the integer value of x coordinate.
   */
  private int getX() {
    return this.x;
  }

  /**
   * Get the value of y coordinate for the rectangle.
   *
   * @return the integer value of y coordinate.
   */
  private int getY() {
    return this.y;
  }

  /**
   * Get the value of width for the rectangle.
   *
   * @return the integer value of width.
   */
  private int getWidth() {
    if (this.width < 0) {
      return Integer.parseInt("Width has to be positive value");
    } else {
      return this.width;
    }
  }

  /**
   * Get the value of the height for the rectangle.
   * @return the integer value of height.
   */
  private int getHeight() {
    return this.height;
  }

  /**
   * Get the boolean value of whether or not two rectangles overlap within the bounds of height
   * and width. If one rectangle overlaps with another return true otherwise false.
   * @param other the other rectangle object.
   * @return true if rectangle overlaps and false otherwise.
   */
  public boolean overlap(Rectangle other) {
    return this.x <= other.x + other.width
            && this.x + this.width >= other.x
            && this.y + this.height >= other.y
            && this.y <= other.y + other.height;

  }

  /**
   * Check if two rectangle objects intersect with one another
   * and return the overlapping of the two rectangles.
   * @param other the other rectangle object.
   * @return the rectangle object of intersection.
   * @throws NoSuchElementException if no intersection exists.
   */
  public Rectangle intersect(Rectangle other) throws NoSuchElementException {
    if (this.overlap(other) || other.overlap(this)) {
      int newX = Math.max(this.x , other.x);
      int newY = Math.max(this.y, other.y);
      int topWidth = Math.min((this.x + this.width), (other.x + other.width));
      int topHeight = Math.min((this.y + this.height), (other.y + other.height));

      return new Rectangle(newX, newY, topWidth - newX, topHeight - newY);
    } else {
      throw new NoSuchElementException("Element does not exist");
    }
  }

  /**
   * Get the union of two rectangles which represents the smallest
   * rectangle that contains both rectangles.
   * @param other the other rectangle being combined for union.
   * @return a rectangle object to symbolize the union of the rectangles.
   */
  public Rectangle union(Rectangle other) {
    int xUnion = Math.min(this.x, other.x);
    int yUnion = Math.min(this.y, other.y);
    int wUnion = Math.max(this.x + this.width, other.x + other.width);
    int hUnion = Math.max(this.y + this.height, other.y + other.height);
    return new Rectangle(xUnion, yUnion, wUnion - xUnion, hUnion - yUnion);
  }

  /**
   * Get the string format of a rectangle object
   * by concatenating values.
   * @return string format of rectangle.
   */
  public String toString() {
    String strX = String.valueOf(this.getX());
    String strY = String.valueOf(this.getY());
    String strWidth = String.valueOf(this.getWidth());
    String strHeight = String.valueOf(this.getHeight());
    return "x:" + strX + ", " + "y:" + strY + ", " + "w:" + strWidth + ", " + "h:" + strHeight;
  }

}

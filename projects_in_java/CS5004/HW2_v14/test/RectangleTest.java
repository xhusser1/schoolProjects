import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This is a Junit test of the rectangle class with test cases that
 * contain both legal data and illegal data to test validity of Rectangle object.
 *
 */
public class RectangleTest {
  private Rectangle quadrant1SmallRight;
  private Rectangle copyOfQuadrant1SmallRight;
  private Rectangle quadrant1SmallLeft;
  private Rectangle quadrant1BigRight;
  private Rectangle quadrant3BigLeft;
  private Rectangle quadrant3BottomRight;
  private Rectangle quadrant3TopLeft;
  private Rectangle quadrant2TopLeft;

  @Before
  public void setUP() {
    quadrant1SmallRight = new Rectangle(5,3,6,5);
    copyOfQuadrant1SmallRight = quadrant1SmallRight;
    quadrant1SmallLeft = new Rectangle(0,5,6,7);
    quadrant1BigRight = new Rectangle(0, 0, 20,10);
    quadrant3BigLeft = new Rectangle(-22,-12, 23, 23);
    quadrant3BottomRight = new Rectangle(-50, -50, 5, 5);
    quadrant3TopLeft = new Rectangle(-22,-22,23,23);
    quadrant2TopLeft = new Rectangle(-22,2, 23,5);
  }

  @Test
  public void testConstructor() {
    String quadrant1String = quadrant1SmallRight.toString();
    String quadrant1String2  = copyOfQuadrant1SmallRight.toString();
    assertEquals(quadrant1String, quadrant1String2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testIllArgumentException1() {
    Rectangle negativeWidth = new Rectangle(0, 0, -15, 2);
    String strNegativeWidth = negativeWidth.toString();
    String strNegativeWidth2 = negativeWidth.toString();
    assertEquals(strNegativeWidth, strNegativeWidth2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testIllArgumentException2() {
    Rectangle negativeHeight = new Rectangle(2, 3, 3, -7);
    String strNegativeHeight = negativeHeight.toString();
    String strNegativeHeight2 = negativeHeight.toString();
    assertEquals(strNegativeHeight, strNegativeHeight2);
  }

  @Test
  public void testOverlap1() {
    assertTrue(quadrant1SmallRight.overlap(quadrant1SmallLeft));
    assertTrue(quadrant1SmallLeft.overlap(quadrant1SmallRight));
  }

  @Test
  public void testNoOverlap() {
    Rectangle quadrant3SmallLeft = new Rectangle(-12, -4, 6, 5);
    assertFalse(quadrant1SmallRight.overlap(quadrant3SmallLeft));
    assertFalse(quadrant3SmallLeft.overlap(quadrant1SmallRight));
  }

  @Test
  public void testPerfectOverlap() {
    Rectangle perfectOverlap = new Rectangle(5, 3,6,5);
    assertTrue(quadrant1SmallRight.overlap(perfectOverlap));
  }

  @Test
  public void testIntersect1() {
    String intersection1 = quadrant1BigRight.intersect(quadrant3BigLeft).toString();
    assertEquals("x:0, y:0, w:1, h:10", intersection1);
  }

  @Test
  public void testIntersect2() {
    String intersection2 = quadrant3BigLeft.intersect(quadrant1BigRight).toString();
    assertEquals("x:0, y:0, w:1, h:10", intersection2);
  }

  @Test
  public void testIntersect3() {
    String intersection3 = quadrant3BigLeft.intersect(quadrant3TopLeft).toString();
    assertEquals("x:-22, y:-12, w:23, h:13", intersection3);
  }

  @Test
  public void testIntersect4() {
    String intersection4 = quadrant3TopLeft.intersect(quadrant3BigLeft).toString();
    assertEquals("x:-22, y:-12, w:23, h:13", intersection4);
  }

  @Test (expected = NoSuchElementException.class)
  public void testNoIntersectionException1() {
    quadrant3TopLeft.intersect(quadrant2TopLeft);
  }

  @Test (expected = NoSuchElementException.class)
  public void testIntersectException2() {
    quadrant1SmallRight.intersect(quadrant3TopLeft);
  }

  @Test
  public void testUnion1() {
    String union1 = quadrant1BigRight.union(quadrant3BottomRight).toString();
    assertEquals("x:-50, y:-50, w:70, h:60", union1);
  }

  @Test
  public void testUnion2() {
    String union2 = quadrant3BottomRight.union(quadrant1BigRight).toString();
    assertEquals("x:-50, y:-50, w:70, h:60", union2);
  }

  @Test
  public void testToString() {
    Rectangle strRect = new Rectangle(-2, -2, 3, 5);
    assertEquals("x:-2, y:-2, w:3, h:5", strRect.toString());
  }
}

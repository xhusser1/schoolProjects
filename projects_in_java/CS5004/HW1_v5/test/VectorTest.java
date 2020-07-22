import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A junit test for the Vector3D class.
 */

public class VectorTest {
  private Vector3D vectorA;
  /* Vector to be used for add method */
  private Vector3D addVector;
  /* Vector to be used for multiply method */
  private Vector3D multiplyVector;

  @Before
  public void setUp() {
    vectorA = new Vector3D(2, 4, 6);
    addVector = new Vector3D(5, 9,13);
    multiplyVector = new Vector3D(4, 8, 12);

  }

  @Test
  public void testGetX() {
    assertEquals(2, vectorA.getX(), 0.001);
  }

  @Test
  public void testGetY() {
    assertEquals(4, vectorA.getY(), 0.001);
  }

  @Test
  public void testGetZ() {
    assertEquals(6, vectorA.getZ(), 0.001);
  }

  @Test
  public void testToString() {
    assertEquals( "(2.00,4.00,6.00)", vectorA.toString());
  }

  @Test
  public void testGetMagnitude() {
    double vectorSqrt = Math.sqrt(56);
    double magnitudeOfVectorA = Math.abs(vectorSqrt);
    assertEquals(magnitudeOfVectorA, vectorA.getMagnitude(), 0.001);
  }

  @Test
  public void testNormalized() {
    double xDivieMag = (2 / vectorA.getMagnitude());
    double yDivideMag = (4 / vectorA.getMagnitude());
    double zDivideMag = (6 / vectorA.getMagnitude());
    Vector3D vectorY = new Vector3D(xDivieMag, yDivideMag, zDivideMag);
    String vectorNormal = vectorY.toString();
    double newX = vectorY.getX();
    double newY = vectorY.getY();
    double newZ = vectorY.getZ();
    String vectorZ = new Vector3D(newX, newY, newZ).toString();
    assertEquals(vectorZ, vectorNormal);

  }

  @Test
  public void testAdd() {
    Vector3D otherVector1 = new Vector3D(3, 5, 7);
    String vectorResult = vectorA.add(otherVector1).toString();
    assertEquals(addVector.toString(), vectorResult);
  }

  @Test
  public void testMultiply() {
    String vectorAMultiplied = vectorA.multiply(2).toString();
    assertEquals(multiplyVector.toString(), vectorAMultiplied);
  }

  @Test
  public void testDotProduct() {
    Vector3D otherVector2 = new Vector3D(3, 6, 9);
    assertEquals(84, vectorA.dotProduct(otherVector2), 0.001);
  }

  @Test
  public void testAngleBetween() {
    Vector3D otherVector3 = new Vector3D(2, 3, 6);
    assertEquals(6.934599712271563, vectorA.angleBetween(otherVector3), 0.001);
  }

  @Test(expected = IllegalStateException.class)
  public void testNormalizeException() {
    Vector3D vectorP = new Vector3D(0, 0, 0);
    vectorP.normalize();
  }

  @Test(expected = IllegalStateException.class)
  public void testAngleBetweenException() {
    Vector3D vectorJ = new Vector3D(0,0,0);
    vectorA.angleBetween(vectorJ);
  }
}

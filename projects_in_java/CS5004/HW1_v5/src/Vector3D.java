/**
 * This class represents a 3D vector with components x,y,z.
 */
public class Vector3D {
  private double x;
  private double y;
  private double z;

  /**
   * Construct a Vector3D object and initialize it to the given x, y, and z.
   *
   * @param x the first dimension of the Vector3D.
   * @param y the second dimension of the Vector3D.
   * @param z the third component of Vector3D.
   * @throws IllegalStateException if magnitude is zero.
   */
  public Vector3D(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * Get value of x of this component as a double.
   *
   * @return the value of this component.
   */
  public double getX() {
    return x;
  }

  /**
   * Get value of y of this component as a double.
   *
   * @return the value of this component.
   */
  public double getY() {

    return y;
  }

  /**
   * Get value of z of this component as a double.
   *
   * @return the value of z of component.
   */
  public double getZ() {

    return z;
  }

  /**
   * Convert the Vector3D object to a tuple with string format and string concatenation.
   *
   * @return the tuple of the Vector3D.
   */
  public String toString() {
    String strX = String.format("(%.2f,", this.x);
    String strY = String.format("%.2f,", this.y);
    String strZ = String.format("%.2f)", this.z);
    return strX + strY + strZ;
  }

  /**
   * Get magnitude of the Vector3D by squaring each components of the vector, taking the square root
   * value of x^2 + y^2 + z^2, and getting the absolute value of the square root for the magnitude.
   *
   * @return absolute value of magnitude.
   */
  public double getMagnitude() {
    double vectorSqrt = Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    return Math.abs(vectorSqrt);
  }

  /**
   * Get normalized version of Vector3D by dividing components of vector by magnitude to create new
   * vector object that is a normalized version of the vector passed in.
   *
   * @return a normalized vector3D object.
   * @throws IllegalStateException if the magnitude is zero an exception is thrown as you cannot
   *                               divide any number by zero.
   */
  public Vector3D normalize() throws IllegalStateException {
    if (this.getMagnitude() == 0) {
      throw new IllegalStateException("Division by zero not possible");
    } else {
      double magX = (x / getMagnitude());
      double magY = (y / getMagnitude());
      double magZ = (z / getMagnitude());
      return new Vector3D(magX, magY, magZ);
    }
  }

  /**
   * Get the result of adding vectors passed in by finding components of x,y,z for both vectors then
   * add components from vector 1 and vector 2. The value is assigned to a new vector object called
   * vector 3.
   *
   * @return result of addition between two vectors.
   */
  public Vector3D add(Vector3D otherVector1) {
    double vector1X = this.getX();
    double vector1Y = this.getY();
    double vector1Z = this.getZ();

    double otherVector1x = otherVector1.getX();
    double otherVector1y = otherVector1.getY();
    double otherVector1z = otherVector1.getZ();

    double addX = vector1X + otherVector1x;
    double addY = vector1Y + otherVector1y;
    double addZ = vector1Z + otherVector1z;
    return new Vector3D(addX, addY, addZ);
  }

  /**
   * Get the result of multiplying current vector with constant for all the components within the
   * vector.
   *
   * @return a new vector from multiplication.
   */
  public Vector3D multiply(double constant) {
    return new Vector3D(x * constant, y * constant, z * constant);
  }

  /**
   * Get the result of dot product of two vectors by getting components of both vectors that were
   * passed in, multiplying the first vector's x,y, and z with the second vector and adding the
   * values of the multiplication for x, y, and z to get the dot product.
   *
   * @return a number that is the dot product of two vectors.
   */
  public double dotProduct(Vector3D otherVector2) {
    double vector2X = this.getX();
    double vector2Y = this.getY();
    double vector2Z = this.getZ();

    double otherVector2x = otherVector2.getX();
    double otherVector2y = otherVector2.getY();
    double otherVector2z = otherVector2.getZ();

    return vector2X * otherVector2x + vector2Y * otherVector2y + vector2Z * otherVector2z;
  }

  /**
   * Get the angle between two vectors in degrees by getting the magnitude of the two vectors
   * passed, multiplying the magnitudes, and finding the result of calling the dot product method.
   * Once all of the calculations have been made prior, we will take the inverse cosine of the dot
   * product divided by the magnitude result multiplied by 180 divided.
   *
   * @return a number that is the angle of two vectors.
   * @throws IllegalStateException if  magnitude is less than or equal to zero.
   */
  public double angleBetween(Vector3D otherVector3) {
    double vectorMag = this.getMagnitude();
    double otherVectorMag = otherVector3.getMagnitude();
    double magOfVtimesW = vectorMag * otherVectorMag;
    double dotProductResult = this.dotProduct(otherVector3);

    if (vectorMag * otherVectorMag <= (double) 0) {
      throw new IllegalStateException("Object not normalized");
    }
    return Math.acos((dotProductResult) / magOfVtimesW) * (180 / (Math.PI));
  }
}
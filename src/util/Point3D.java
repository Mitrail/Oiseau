package util;

public class Point3D {

	/**
	 * La position du points en x,y,z
	 */
	private float x, y, z;

	/**
	 * Creer un point a la position x y z 
	 * @param x
	 * @param y
	 * @param z
	 */
	public Point3D(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}


	public boolean equals(Object o) {
		if (o instanceof Point3D) {
			Point3D p = (Point3D) o;
			return this.x == p.x && this.y == p.y && this.z == p.z;
		}
		return false;
	}

	public String toString() {
		return "Coordon�es du point = (" + x + "," + y + "," + z + ")";
	}

	public Point3D clone() {
		return new Point3D(this.x, this.y, this.z);
	}

	/**
	 * Deplace le point de x sur l'axe x
	 * @param x
	 */
	public void moveX(float x) {
		this.x += x;
	}

	/**
	 * Deplace le point de y sur l'axe y
	 * @param y
	 */
	public void moveY(float y) {
		this.y += y;
	}

	/**
	 * Deplace le point de z sur l'axe z
	 * @param z
	 */
	public void moveZ(float z) {
		this.z += z;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}
	
	/**
	 * Actualise la position du point 
	 * @param x la nouvelle position en x
	 * @param y la nouvelle position en y
	 * @param z la nouvelle position en z
	 */
	public void setPos(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}

}

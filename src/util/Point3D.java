package util;

/**
 * Cette classe représente un point dans l'espace (3 dimensions). Cette classe
 * est caractérisée par : sa valeur sur l'axe x, y et z
 * 
 * @author Nico
 *
 */
public class Point3D {

	/**
	 * x, y et z correspondent aux coordonnées dans l'espace d'un object Point3D
	 */
	private float x, y, z;

	/**
	 * Constructeur qui prend un argument les 3 coordonnées
	 * 
	 * @param x
	 *            valeur sur l'axe x
	 * @param y
	 *            valeur sur l'axe y
	 * @param z
	 *            valeur sur l'axe z
	 */
	public Point3D(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Méthode equals de classe. Deux objets Point3D sont identiques s'ils ont
	 * des coordonnées identiques
	 */
	public boolean equals(Object o) {
		if (o instanceof Point3D) {
			Point3D p = (Point3D) o;
			return this.x == p.x && this.y == p.y && this.z == p.z;
		}
		return false;
	}

	/**
	 * Méthode d'affichache console de classe
	 */
	public String toString() {
		return "Coordonï¿½es du point = (" + x + "," + y + "," + z + ")";
	}

	/**
	 * Méthode clonage en profondeur
	 */
	public Point3D clone() {
		return new Point3D(this.x, this.y, this.z);
	}

	/**
	 * Déplace l'objet sur l'axe des X
	 * 
	 * @param x
	 *            valeur de la translation
	 */
	public void moveX(float x) {
		this.x += x;
	}

	/**
	 * Déplace l'objet sur l'axe des Y
	 * 
	 * @param y
	 *            valeur de la translation
	 */
	public void moveY(float y) {
		this.y += y;
	}

	/**
	 * Déplace l'objet sur l'axe des Z
	 * 
	 * @param z
	 *            valeur de la translation
	 */
	public void moveZ(float z) {
		this.z += z;
	}

	/*
	 * Getter & Setter
	 */
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

	public void setPos(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

}

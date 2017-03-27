package util;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;

import model.Oiseau;

/**
 * Cette classe représente un triangle à afficher dans un espace en 3
 * dimensions. L'objet Triangle est caractérisé par 3 Point3D
 * 
 * @author Nico
 *
 */
public class Triangle {

	/**
	 * premier point
	 */
	private Point3D p1;

	/**
	 * deuxième point
	 */
	private Point3D p2;

	/**
	 * troisième point
	 */
	private Point3D p3;

	/**
	 * Constructeur prenant 9 coordonnées en argument
	 * 
	 * @param ax
	 *            Point3D p1 : x
	 * @param ay
	 *            Point3D p1 : y
	 * @param az
	 *            Point3D p1 : z
	 * @param bx
	 *            Point3D p2 : x
	 * @param by
	 *            Point3D p2 : y
	 * @param bz
	 *            Point3D p2 : z
	 * @param cx
	 *            Point3D p3 : x
	 * @param cy
	 *            Point3D p3 : y
	 * @param cz
	 *            Point3D p3 : z
	 */
	public Triangle(float ax, float ay, float az, float bx, float by, float bz, float cx, float cy, float cz) {
		p1 = new Point3D(ax, ay, az);
		p2 = new Point3D(bx, by, bz);
		p3 = new Point3D(cx, cy, cz);
	}

	/**
	 * Constructeur prenant 3 Point3D en argument
	 * 
	 * @param p1
	 *            Point3D 1
	 * @param p2
	 *            Point3D 2
	 * @param p3
	 *            Point3D 3
	 */
	public Triangle(Point3D p1, Point3D p2, Point3D p3) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	/**
	 * Méthode permettant d'afficher l'objet Triangle dans l'espace
	 * 
	 * @param gl
	 */
	public void render(GL2 gl) {
		gl.glBegin(GL.GL_TRIANGLES);
		gl.glVertex3f(p1.getX(), p1.getY(), p1.getZ());
		gl.glVertex3f(p2.getX(), p2.getY(), p2.getZ());
		gl.glVertex3f(p3.getX(), p3.getY(), p3.getZ());
		gl.glEnd();
	}

	/**
	 * Méthode permettant d'afficher l'objet Triangle dans l'espace selon les
	 * coordonnées de l'oiseau
	 * 
	 * @param gl
	 * @param o
	 */
	public void render(GL2 gl, Oiseau o) {
		gl.glBegin(GL.GL_TRIANGLES);
		gl.glVertex3f(p1.getX() + o.getX(), p1.getY() + o.getY(), p1.getZ() + o.getZ());
		gl.glVertex3f(p2.getX() + o.getX(), p2.getY() + o.getY(), p2.getZ() + o.getZ());
		gl.glVertex3f(p3.getX() + o.getX(), p3.getY() + o.getY(), p3.getZ() + o.getZ());
		gl.glEnd();
	}

	/**
	 * Méthode permettant de déplacer le triangle. Effectue une translation sur
	 * les 3 axes
	 * 
	 * @param x
	 *            translation sur l'axe x
	 * @param y
	 *            translation sur l'axe y
	 * @param z
	 *            translation sur l'axe z
	 */
	public void move(float x, float y, float z) {
		p1.setPos(x, y, z);
		p2.setPos(x, y, z);
		p3.setPos(x, y, z);
	}

	public void update(float x, float y, float z) {

	}

	@Override
	/**
	 * Méthode toString de classe affichant les coordonnées de chaque Point3D du
	 * triangle
	 */
	public String toString() {
		return "Triangle [p1=" + p1.getX() + ", p2=" + p1.getY() + ", p3=" + p1.getZ() + "]";
	}

}

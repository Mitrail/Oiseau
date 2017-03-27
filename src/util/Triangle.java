package util;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;

import model.Oiseau;

/**
 * Cette classe represente un triangle e afficher dans un espace en 3
 * dimensions. L'objet Triangle est caracterise par 3 Point3D
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
	 * deuxieme point
	 */
	private Point3D p2;

	/**
	 * troisieme point
	 */
	private Point3D p3;


	/**
	 * Constructeur prenant 3 Point3D en argument dans l'ordre trigonometrique
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
	 * Methode permettant d'afficher l'objet Triangle dans l'espace
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
	 * Methode permettant d'afficher l'objet Triangle dans l'espace selon les
	 * coordonnees de l'oiseau
	 * 
	 * @param gl
	 * @param o
	 */
	public void render(GL2 gl, Oiseau o) {
		gl.glBegin(GL.GL_TRIANGLES);
		gl.glVertex3f(p1.getX() , p1.getY() , p1.getZ() );
		gl.glVertex3f(p2.getX() , p2.getY() , p2.getZ() );
		gl.glVertex3f(p3.getX() , p3.getY() , p3.getZ() );
		gl.glEnd();
	}

	/**
	 * Methode permettant de deplacer le triangle. Effectue une translation sur
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
	 * Methode toString de classe affichant les coordonnees de chaque Point3D du
	 * triangle
	 */
	public String toString() {
		return "Triangle [p1=" + p1.getX() + ", p2=" + p1.getY() + ", p3=" + p1.getZ() + "]";
	}

}

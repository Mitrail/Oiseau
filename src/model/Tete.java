package model;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;

import util.Point3D;
import util.Triangle;

/**
 * Represente la tete de l'oiseau
 * La tete est une sphere, chaque oeil est une sphere
 * 
 * @author mitrail
 *
 */
public class Tete implements InterfaceCorps {

	/**
	 * L'oiseau auquel le membre est rataché
	 */
	private Oiseau oiseau;
	
	/**
	 * Objet permettant d'utiliser les spheres
	 */
	private GLUT glut = new GLUT();

	/**
	 * 
	 * @param o
	 *            Oiseau objet central
	 */
	public Tete(Oiseau o) {
		this.oiseau = o;
	}

	/**
	 * 
	 */
	public void rotate(float angle, float x, float y, float z) {

	}

	/**
	 * 
	 */
	public void move(float x, float y, float z) {

	}

	/**
	 * Trace les informations contenues dans l'objet
	 * 
	 * @param gl
	 *            l'objet effectuant les positionnement des points
	 */
	public void render(GL2 gl) {
		// push car Lune pas affectee par l'angle de la terre autour d'elle meme
		gl.glPushMatrix();

		gl.glTranslatef(0 + oiseau.getX(), 0 + oiseau.getY(), 7 + oiseau.getZ());
		gl.glColor3f(0.0f, 0.0f, 1.0f);
		glut.glutSolidSphere(2, 50, 50);

		gl.glTranslatef(1, 0, 1);
		// gl.glColor3f(1.0f, 1.0f, 1.0f);
		glut.glutWireSphere(0.25, 50, 50);

		gl.glTranslatef(-2, 0, 0);
		// gl.glColor3f(0.0f, 0.0f, 1.0f);
		glut.glutWireSphere(0.25, 50, 50);

		gl.glColor3f(1.0f, 0.0f, 0.0f);
		gl.glPopMatrix();
	}

}

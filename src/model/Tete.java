package model;

import java.util.ArrayList;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;

import util.Point3D;
import util.Triangle;

/**
 * Represente la tete de l'oiseau La tete est une sphere, chaque oeil est une
 * sphere
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
	 * Points
	 */
	private float beg, end, endR, endL, endT;
	private Point3D begin, top, botL, botR;
	private ArrayList<Triangle> liste = new ArrayList<>();

	/**
	 * 
	 * @param o
	 *            Oiseau objet central
	 */
	public Tete(Oiseau o) {
		this.oiseau = o;
		beg = 10.0f;
		end = 7.0f;
		endR = 1.0f;
		endL = -1.0f;
		endT = 1.0f;

		begin = new Point3D(0.0f + oiseau.getX(), -1.0f + oiseau.getY(), beg + oiseau.getZ());
		top = new Point3D(0.0f + oiseau.getX(), 0.0f + oiseau.getY(), end + oiseau.getZ());
		botL = new Point3D(endL + oiseau.getX(), -1.0f + oiseau.getY(), end + oiseau.getZ());
		botR = new Point3D(endR + oiseau.getX(), -1.0f + oiseau.getY(), end + oiseau.getZ());

		liste.add(new Triangle(botL, top, begin));
		liste.add(new Triangle(botR, begin, top));
		liste.add(new Triangle(begin, botR, botL));
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
		gl.glColor3f(1.0f, 1.0f, 1.0f);
		glut.glutSolidSphere(0.25, 10, 10);

		gl.glTranslatef(-2, 0, 0);
		glut.glutSolidSphere(0.25, 10, 10);
		
		
		
		gl.glPopMatrix();

		gl.glColor3f(1.0f, 1.0f, 0.0f);

		for (Triangle t : liste) {
			t.render(gl);
		}
	}

}

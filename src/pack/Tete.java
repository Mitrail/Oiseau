package pack;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;

/**
 * Represente la queue de l'oiseau en deux parties, droite et gauche
 * 
 * @author mitrail
 *
 */
public class Tete implements InterfaceCorps {

	private Oiseau oiseau;
	private ArrayList<Triangle> listeTri = new ArrayList<Triangle>();

	private float coef = 1.0f;

	// haut/bas
	private float top = 1.5f * coef;
	private float bottom = -1.5f * coef;
	// milieu
	private float alignRight = -4.0f * coef;
	private float aligneLeft = 4.0f * coef;
	// droite/gauche
	private float left = -2.5f * coef;
	private float right = 2.5f * coef;
	// avant/arriere
	private float end = -6.0f * coef;
	private float beg = 0 * coef;
	// centre
	private float mid = 0 * coef;

	private float centre = 10.0f;

	private GLUT glut = new GLUT();

	/**
	 * 
	 * @param o
	 *            Oiseau objet central
	 */
	public Tete(Oiseau o) {
		this.oiseau = o;
		Point3D centreTete = new Point3D(oiseau.getX(), oiseau.getY(), oiseau.getZ() + centre);
		Point3D topRight = new Point3D(oiseau.getX() + right, oiseau.getY() + top, oiseau.getZ() + beg);
		Point3D rearLeft = new Point3D(oiseau.getX() + aligneLeft, oiseau.getY() + top, oiseau.getZ() + end);
		Point3D rearRight = new Point3D(oiseau.getX() + alignRight, oiseau.getY() + top, oiseau.getZ() + end);
		Point3D botLeft = new Point3D(oiseau.getX() + left, oiseau.getY() + bottom, oiseau.getZ() + beg);
		Point3D botRight = new Point3D(oiseau.getX() + right, oiseau.getY() + bottom, oiseau.getZ() + beg);

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

		gl.glTranslatef(0+oiseau.getX(), 0+oiseau.getY(), 8+oiseau.getZ());
		gl.glColor3f(0.0f, 0.0f, 1.0f);
		glut.glutWireSphere(2, 50, 50);
		
		
		gl.glTranslatef(1, 0, 1);
		gl.glColor3f(0.0f, 0.0f, 1.0f);
		glut.glutWireSphere(0.25, 10, 10);
		
		
		gl.glTranslatef(-2, 0, 0);
		gl.glColor3f(0.0f, 0.0f, 1.0f);
		glut.glutWireSphere(0.25, 10, 10);
		
		
		
		gl.glPopMatrix();
	}

}

package model;

import java.util.ArrayList;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;

/**
 * Objet representant l'oiseau
 * <p>
 * connait les differentes parties du corps
 * <p>
 * peut se reorienter
 * <p>
 * peut faire battre les ailes et la queue
 * 
 * @author mitrail
 */
public class Oiseau {

	/**
	 * Position de l'oiseau en x y z
	 */
	private float x, y, z;

	// membres pour les acces ponctuels
	/**
	 * Aile gauche de l'oiseau
	 */
	private Aile ag;
	/**
	 * Aile droite de l'oiseau
	 */
	private Aile ad;
	/**
	 * Queue de l'oiseau
	 */
	private Queue q;
	/**
	 * Corps de l'oiseau
	 */
	private Corps c;
	/**
	 * Tete de l'oiseau
	 */
	private Tete t;

	/**
	 * liste des membres de l'oiseau pour iterer
	 */
	private ArrayList<InterfaceCorps> membres = new ArrayList<InterfaceCorps>();

	/**
	 * orientation de l'oiseau d'un angle sur chaque axe
	 */
	private float ox, oy, oz, angle = 0.0f;

	/**
	 * Couleurs RGB de l'oiseau
	 */
	private float r, g, b;

	/**
	 * Creer un nouvel oiseau a une position donnee
	 * 
	 * @param x
	 *            la pos x de l'oiseau dans l'espace
	 * @param y
	 *            la pos y de l'oiseau dans l'espace
	 * @param z
	 *            la pos z de l'oiseau dans l'espace
	 */
	public Oiseau(float x, float y, float z) {
		// couleur aleatoire
		r = (float) Math.random();
		g = (float) Math.random();
		b = (float) Math.random();

		this.x = x;
		this.y = y;
		this.z = z;

		t = new Tete(this);
		ag = new Aile(this, true);
		ad = new Aile(this, false);
		q = new Queue(this);
		c = new Corps(this);

		membres.add(ag);
		membres.add(ad);
		membres.add(q);
		membres.add(c);
		membres.add(t);
	}

	/**
	 * Execute les methodes de rendu des differentes parties du corps
	 * 
	 * @param gl
	 *            l'objet placant les points
	 */
	public void render(GL2 gl) {
		// gl.glDisable(GL.GL_DEPTH_TEST);

		gl.glColor3f(r, g, b);
		gl.glTranslatef(x, y, z);
		gl.glRotatef(angle, 0, 0, 1);
		for (InterfaceCorps i : membres) {
			i.render(gl);
		}

		// gl.glEnable(GL.GL_DEPTH_TEST);

	}

	/**
	 * Deplace le centre de l'oiseau
	 */
	public void orienter(float x, float y, float z) {
		this.x += x;
		this.y += y;
		// this.z += z;
		angle += z * 7.5f;

	}

	/**
	 * Faut battre les ailes et la queue de l'oiseau
	 * 
	 * @param delta
	 *            la variation en hauteur des ailes
	 */
	public void battre(float delta) {
		ag.battre(delta);
		ad.battre(delta);
		q.battre(delta);
	}

	// SET - GET - IS - TO
	/**
	 * @deprecated
	 * @return
	 */
	public float getX() {
		return 0;
	}

	/**
	 * @deprecated
	 * @return
	 */
	public float getY() {
		return 0;
	}

	/**
	 * @deprecated
	 * @return
	 */
	public float getZ() {
		return 0;
	}

}

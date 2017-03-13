package pack;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;

/**
 * Represente la queue de l'oiseau en deux parties, droite et gauche
 * 
 * @author mitrail
 *
 */
public class Queue implements InterfaceCorps {

	private Oiseau oiseau;
	private ArrayList<Triangle> pDroite = new ArrayList<Triangle>();
	private ArrayList<Triangle> pGauche = new ArrayList<Triangle>();
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
	
	
	
	

	/**
	 * 
	 * @param o
	 *            Oiseau objet central
	 */
	public Queue(Oiseau o) {
		this.oiseau = o;
		Point3D topLeft = new Point3D(oiseau.getX() + left, oiseau.getY() + top, oiseau.getZ() + beg);
		Point3D topRight = new Point3D(oiseau.getX() + right, oiseau.getY() + top, oiseau.getZ() + beg);
		Point3D rearLeft = new Point3D(oiseau.getX() + aligneLeft, oiseau.getY() + top, oiseau.getZ() + end);
		Point3D rearRight = new Point3D(oiseau.getX() + alignRight, oiseau.getY() + top, oiseau.getZ() + end);
		Point3D botLeft = new Point3D(oiseau.getX() + left, oiseau.getY() + bottom, oiseau.getZ() + beg);
		Point3D botRight = new Point3D(oiseau.getX() + right, oiseau.getY() + bottom, oiseau.getZ() + beg);

		
		//top
		pGauche.add(new Triangle(topLeft, rearLeft, topRight));
		//int
		pGauche.add(new Triangle(botLeft, rearLeft, topLeft));
		//bot
		pGauche.add(new Triangle(botRight, rearLeft, botLeft));
		//ext
		pGauche.add(new Triangle(botRight,topRight,rearLeft));
		
		//top
		pDroite.add(new Triangle(rearRight, topRight, topLeft));
		//int
		pDroite.add(new Triangle(topRight, rearRight, botRight));
		//bot
		pDroite.add(new Triangle(botRight, rearRight, botLeft));
		//ext
		pDroite.add(new Triangle(topLeft,botLeft,rearRight));

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
		for (Triangle t : pDroite) {
			t.render(gl);
		}

		for (Triangle t : pGauche) {
			t.render(gl);
		}
	}

}

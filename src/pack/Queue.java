package pack;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;

/**
 * Represente la queue de l'oiseau
 * en deux parties, droite et gauche
 * @author mitrail
 *
 */
public class Queue implements InterfaceCorps{

	private Oiseau oiseau; 
	private ArrayList<Triangle> pDroite;
	private ArrayList<Triangle> pGauche;
	private float top = 2.5f;
	private float bottom = -2.5f; 
	private float left = -2.5f;
	private float right = 2.5f;
	
	private float mid = 0;
	private float end = -5.0f;
	private float beg = 0;
	private float alignRight = -1.25f;
	private float aligneLeft = 1.25f;
	
	
	/**
	 * 
	 * @param o Oiseau objet central
	 */
	public Queue(Oiseau o){
		this.oiseau = o;
		
		//haut
		pDroite.add(new Triangle(
				oiseau.getX()+beg,oiseau.getY()+left,oiseau.getZ()+top,
				oiseau.getX()+end,oiseau.getY()+aligneLeft,oiseau.getZ()+mid,
				oiseau.getX()+beg,oiseau.getY()+right,oiseau.getZ()+top
				));
		//exterieur
		pDroite.add(new Triangle(
				oiseau.getX()+beg,oiseau.getY()+left,oiseau.getZ()+bottom,
				oiseau.getX()+end,oiseau.getY()+aligneLeft,oiseau.getZ()+mid,
				oiseau.getX()+beg,oiseau.getY()+left,oiseau.getZ()+top
				));
		//bas
		pDroite.add(new Triangle(
				oiseau.getX()+beg,oiseau.getY()+right,oiseau.getZ()+bottom,
				oiseau.getX()+end,oiseau.getY()+aligneLeft,oiseau.getZ()+mid,
				oiseau.getX()+beg,oiseau.getY()+left,oiseau.getZ()+bottom
				));
		//interieur
		pDroite.add(new Triangle(
				oiseau.getX()+end,oiseau.getY()+aligneLeft,oiseau.getZ()+mid,
				oiseau.getX()+beg,oiseau.getY()+right,oiseau.getZ()+bottom,
				oiseau.getX()+beg,oiseau.getY()+right,oiseau.getZ()+top
				));
		
		
		//haut
		pGauche.add(new Triangle(
				oiseau.getX()+beg,oiseau.getY()+right,oiseau.getZ()+top,
				oiseau.getX()+end,oiseau.getY()+alignRight,oiseau.getZ()+mid,
				oiseau.getX()+beg,oiseau.getY()+left,oiseau.getZ()+top
				));
		//exterieur
		pGauche.add(new Triangle(
				oiseau.getX()+beg,oiseau.getY()+right,oiseau.getZ()+bottom,
				oiseau.getX()+end,oiseau.getY()+alignRight,oiseau.getZ()+mid,
				oiseau.getX()+beg,oiseau.getY()+right,oiseau.getZ()+top
				));
		//bas
		pGauche.add(new Triangle(
				oiseau.getX()+beg,oiseau.getY()+left,oiseau.getZ()+bottom,
				oiseau.getX()+end,oiseau.getY()+alignRight,oiseau.getZ()+mid,
				oiseau.getX()+beg,oiseau.getY()+right,oiseau.getZ()+bottom
				));
		//interieur
		pGauche.add(new Triangle(
				oiseau.getX()+end,oiseau.getY()+alignRight,oiseau.getZ()+mid,
				oiseau.getX()+beg,oiseau.getY()+left,oiseau.getZ()+bottom,
				oiseau.getX()+beg,oiseau.getY()+left,oiseau.getZ()+top
				));
		
	}
	
	/**
	 * 
	 */
	public void rotate(float angle,float x, float y, float z){
		
	}
	
	/**
	 * 
	 */
	public void move(float x, float y, float z){
		
	}
	
	/**
	 * Trace les informations contenues dans l'objet
	 * @param gl l'objet effectuant les positionnement des points
	 */
	public void render(GL2 gl){
		for(Triangle t : pDroite){
			t.render(gl);
		}
	}
	
}

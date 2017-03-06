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
	private ArrayList<Triangles> pDroite;
	private ArrayList<Triangles> pGauche;
	
	
	/**
	 * 
	 * @param o Oiseau objet central
	 */
	public Queue(Oiseau o){
		float decallageX;
		float decallageY;
		float decallageZ;
		this.oiseau = o;
		
		
		pDroite.add(new Triangle(
				oiseau.getX(),oiseau.getY(),oiseau.getZ(),
				oiseau.getX(),oiseau.getY(),oiseau.getZ(),
				oiseau.getX(),oiseau.getY(),oiseau.getZ()
				));
		pDroite.add(new Triangle(
				oiseau.getX(),oiseau.getY(),oiseau.getZ(),
				oiseau.getX(),oiseau.getY(),oiseau.getZ(),
				oiseau.getX(),oiseau.getY(),oiseau.getZ()
				));
		pDroite.add(new Triangle(
				oiseau.getX(),oiseau.getY(),oiseau.getZ(),
				oiseau.getX(),oiseau.getY(),oiseau.getZ(),
				oiseau.getX(),oiseau.getY(),oiseau.getZ()
				));
		pDroite.add(new Triangle(
				oiseau.getX(),oiseau.getY(),oiseau.getZ(),
				oiseau.getX(),oiseau.getY(),oiseau.getZ(),
				oiseau.getX(),oiseau.getY(),oiseau.getZ()
				));
		
		pGauche.add(new Triangle(
				oiseau.getX(),oiseau.getY(),oiseau.getZ(),
				oiseau.getX(),oiseau.getY(),oiseau.getZ(),
				oiseau.getX(),oiseau.getY(),oiseau.getZ()
				));
		pGauche.add(new Triangle(
				oiseau.getX(),oiseau.getY(),oiseau.getZ(),
				oiseau.getX(),oiseau.getY(),oiseau.getZ(),
				oiseau.getX(),oiseau.getY(),oiseau.getZ()
				));
		pGauche.add(new Triangle(
				oiseau.getX(),oiseau.getY(),oiseau.getZ(),
				oiseau.getX(),oiseau.getY(),oiseau.getZ(),
				oiseau.getX(),oiseau.getY(),oiseau.getZ()
				));
		pGauche.add(new Triangle(
				oiseau.getX(),oiseau.getY(),oiseau.getZ(),
				oiseau.getX(),oiseau.getY(),oiseau.getZ(),
				oiseau.getX(),oiseau.getY(),oiseau.getZ()
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
		
	}
	
}

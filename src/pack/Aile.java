package pack;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;

/**
 * Represente les ailes de l'oiseau
 * decoupees en deux segements
 * @author mitrail
 *
 */
public class Aile implements InterfaceCorps{
	
	
	private Oiseau oiseau; 
	private ArrayList<Triangle> tronc1 = new ArrayList<Triangle>();
	private ArrayList<Triangle> tronc2 = new ArrayList<Triangle>();
	
	
	/**
	 * 
	 * @param b boolean droite ou gauche
	 * @param o Oiseau objet central
	 */
	public Aile(boolean b, Oiseau o){
		this.oiseau = o;
		
		
	}
	
	/**
	 * Applique une rotation autour du centre a l'ensemble des points de la structure
	 */
	public void rotate(float angle,float x, float y, float z){
		
	}
	
	/**
	 * Deplace l'ensemble des points de la structure
	 */
	public void move(float x, float y, float z){
		
	}
	
	/**
	 * Trace les informations contenues dans l'objet
	 * @param gl l'objet effectuant les positionnement des points
	 */
	public void render(GL2 gl){
		for(Triangle i : tronc1){
			i.render(gl);
		}
	}
	
	/**
	 * 
	 * @param angle float la modification a apporter aux ailes
	 */
	public void battre(float angle){
		
	}
	
	
}

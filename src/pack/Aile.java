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
	private ArrayList<Triangles> troncon1;
	private ArrayList<Triangles> troncon2;
	
	
	/**
	 * 
	 * @param b boolean droite ou gauche
	 * @param o Oiseau objet central
	 */
	public Aile(boolean b, Oiseau o){
		this.oiseau = o;
		
	
		
		
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
	
	/**
	 * 
	 * @param angle float la modification a apporter aux ailes
	 */
	public void battre(float angle){
		
	}
	
	
}

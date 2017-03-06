package pack;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;

/**
 * 
 * @author mitrail
 * Objet representant l'oiseau, 
 * connait les differentes parties du corps
 */
public class Oiseau {

	private Aile aileD;
	private Aile aileG;
	//Corps corps;
	//Tete tete;
	//Queue queue;
	private ArrayList<InterfaceCorps> membres = new ArrayList<InterfaceCorps>();
	
	private float x;
	private float y;
	private float z;
	
	private Oiseau(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
		
		membres.add(new Aile(false, this));
		membres.add(new Aile(true,this));
		membres.add(new Queue(this));
	}
	
	/**
	 * Execite les methodes de rendu des differentes parties du corps
	 * @param gl l'objet placant les points
	 */
	public void render(GL2 gl){
		
	}
	
	
	/**
	 * Deplace l'ensemble des membres
	 */
	public void move(float x, float y, float z){
		for(InterfaceCorps i : membres){
			i.move(x, y,z);
		}
	}
	
	public void rotate(float angle,float x, float y, float z){
		for(InterfaceCorps i : membres){
			i.rotate(angle, x, y,z);
		}
	}
	
	
	// SET - GET - IS - TO

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getZ() {
		return z;
	}
	
	
	
	
}

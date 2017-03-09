package pack;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;

/**
 * 
 * @author mitrail
 * Objet representant l'oiseau, 
 * connait les differentes parties du corps
 */
public class Oiseau {

	private ArrayList<InterfaceCorps> membres = new ArrayList<InterfaceCorps>();
	
	private float x;
	private float y;
	private float z;
	
	public Oiseau(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
		
		membres.add(new Aile(false, this));
		membres.add(new Aile(true,this));
		membres.add(new Queue(this));
		membres.add(new Corps(this));
	}
	
	/**
	 * Execite les methodes de rendu des differentes parties du corps
	 * @param gl l'objet placant les points
	 */
	public void render(GL2 gl){
		for(InterfaceCorps i : membres){
			i.render(gl);
		}
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

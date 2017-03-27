package model;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;

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
	
	private AileG ag;
	private AileD ad;
	private Queue q;
	private Corps c;
	private Tete t;
	
	private float ox;
	private float oy;
	private float oz;
	private float angle = 0.0f;
	
	public Oiseau(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
		
		ag = new AileG(this);
		ad = new AileD(this);
		q  = new Queue(this);
		c = new Corps(this);
		t = new Tete(this);

		membres.add(ag);
		membres.add(ad);
		membres.add(q);
		membres.add(c);
		membres.add(t);
	}
	
	/**
	 * Execite les methodes de rendu des differentes parties du corps
	 * @param gl l'objet placant les points
	 */
	public void render(GL2 gl){
		

		gl.glTranslatef(x, y, z);
		gl.glRotatef(angle,0,0,1);
		for(InterfaceCorps i : membres){
			i.render(gl);
		}
		//gl.glRotatef(angle,0,0,1);
		
	}
	
	
	/**
	 * Deplace le centre de l'oiseau
	 */
	public void orienter(float x, float y, float z){
		this.x += x;
		this.y += y;
		//this.z += z;
		angle += z*5.0f;

	}
	
	public void rotate(float angle,float x, float y, float z){
		for(InterfaceCorps i : membres){
			i.rotate(angle, x, y,z);
		}
	}
	
	public void battre(float delta){

		ag.battre(delta);
		ad.battre(delta);
		q.battre(delta);
	}
	
	
	// SET - GET - IS - TO

	public float getX() {
		return 0;
	}

	public float getY() {
		return 0;
	}

	public float getZ() {
		return 0;
	}
	
	


	
	
	
}

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
	
	//position de l'oiseau
	private float x; 
	private float y;
	private float z;
	
	//membres pour les acces ponctuels
	private Aile ag;
	private Aile ad;
	private Queue q;
	private Corps c;
	private Tete t;
	
	//liste des membres de l'oiseau pour iterer 
	private ArrayList<InterfaceCorps> membres = new ArrayList<InterfaceCorps>();
	
	//orientation de l'oiseau d'un angle sur chaque axe
	private float ox;			
	private float oy;
	private float oz;
	private float angle = 0.0f;
	
	/**
	 * Creer un nouvel oiseau a une position donnee
	 * @param x la pos x de l'oiseau dans l'espace
	 * @param y la pos y de l'oiseau dans l'espace
	 * @param z la pos z de l'oiseau dans l'espace
	 */
	public Oiseau(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
		
		ag = new Aile(this,true);
		ad = new Aile(this,false);
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
	 * Execute les methodes de rendu des differentes parties du corps
	 * @param gl l'objet placant les points
	 */
	public void render(GL2 gl){
		
		gl.glTranslatef(x, y, z);
		gl.glRotatef(angle,0,0,1);
		for(InterfaceCorps i : membres){
			i.render(gl);
		}
		
	}
	
	
	/**
	 * Deplace le centre de l'oiseau
	 */
	public void orienter(float x, float y, float z){
		this.x += x;
		this.y += y;
		//this.z += z;
		angle += z*7.5f;

	}
	
	

	
	/**
	 * Faut battre les ailes et la queue de l'oiseau
	 * @param delta la variation en hauteur des ailes
	 */
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

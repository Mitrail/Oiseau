package pack;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;

/**
 * Represente les ailes de l'oiseau
 * decoupees en deux segements
 * @author mitrail
 *
 */
public class AileG implements InterfaceCorps{
	
	private boolean monte = true;
	private float delta  = 0;
	
	private Oiseau oiseau; 
	private ArrayList<Triangle> liste1 = new ArrayList<Triangle>();
	private ArrayList<Triangle> liste2 = new ArrayList<Triangle>();
	private float coef = 1.0f;
	
	//close
	private float ctop = 1.5f*coef;
	private float cbot = -1.5f*coef;
	private float cfront = 5.0f*coef;
	private float crear = 0.0f*coef;
	private float cbeg = 2.5f*coef;
	
	
	private float mtop = 1.0f*coef;
	private float mbot = -1.0f*coef;
	private float mfront = 4.0f*coef;
	private float mrear = -1.0f*coef;
	private float mbeg = 5.0f*coef;
	
	
	private float ex = 20.0f*coef;
	private float ey = 0.0f*coef;
	private float ez = -10.0f*coef;
	
	private Point3D closeFT;
	private Point3D closeRT;
	private Point3D closeFB;
	private Point3D closeRB;
	private Point3D midFT;
	private Point3D midRT;
	private Point3D midFB;
	private Point3D midRB;
	private Point3D end;

	
	
	
	
	
	/**
	 * 
	 * @param b boolean droite ou gauche
	 * @param o Oiseau objet central
	 */
	public AileG(Oiseau o){
		this.oiseau = o;
		
		
		closeFT = new Point3D(oiseau.getX() + cbeg, oiseau.getY() + ctop, oiseau.getZ() + cfront);
		closeRT = new Point3D(oiseau.getX() + cbeg, oiseau.getY() + ctop, oiseau.getZ() + crear);
		
		closeFB = new Point3D(oiseau.getX() + cbeg, oiseau.getY() + cbot, oiseau.getZ() + cfront);
		closeRB = new Point3D(oiseau.getX() + cbeg, oiseau.getY() + cbot, oiseau.getZ() + crear);
		
		
		midFT = new Point3D(oiseau.getX() + mbeg, oiseau.getY() + mtop, oiseau.getZ() + mfront);
		midRT = new Point3D(oiseau.getX() + mbeg, oiseau.getY() + mtop, oiseau.getZ() + mrear);
		
		midFB = new Point3D(oiseau.getX() + mbeg, oiseau.getY() + mbot, oiseau.getZ() + mfront);
		midRB = new Point3D(oiseau.getX() + mbeg, oiseau.getY() + mbot, oiseau.getZ() + mrear);
		end = new Point3D(oiseau.getX() + ex, oiseau.getY() + ey, oiseau.getZ() + ez);
		
		
		
		//top
		liste1.add(new Triangle(midFT,closeFT,closeRT));
		liste1.add(new Triangle(midRT,midFT, closeRT));
		liste2.add(new Triangle(midFT,midRT,end));
		
		
		//front
		liste1.add(new Triangle(closeFB,  midFT,midFB));
		liste1.add(new Triangle(midFT,closeFB,closeFT));
		liste2.add(new Triangle(midFB,midFT,end));
		
		//bot
		liste1.add(new Triangle(closeFB, midFB,midRB));
		liste1.add(new Triangle(closeRB,closeFB, midRB));
		liste2.add(new Triangle(midRB,midFB,end));
		
		//rear
		liste1.add(new Triangle(midRT,closeRT, closeRB));
		liste1.add(new Triangle(closeRB, midRB,midRT));
		liste2.add(new Triangle(midRT,midRB,end));
		

	}
	
	/**
	 * Applique une rotation autour du centre a l'ensemble des points de la structure
	 */
	public void rotate(float angle,float x, float y, float z){
		
	}
	
	/**
	 * Trace les informations contenues dans l'objet
	 * @param gl l'objet effectuant les positionnement des points
	 */
	public void render(GL2 gl){
		for (Triangle t : liste1) {
			t.render(gl, oiseau);
		}
		for (Triangle t : liste2) {
			t.render(gl, oiseau);
		}
	}
	
	/**
	 * 
	 * @param angle float la modification a apporter aux ailes
	 */
	public void battre(float angle){

		if(monte && delta>3.0f){
			monte = false;
		} else if (!monte && delta <-3.0f){
			monte = true;
		}
		
		
		if(!monte){
			angle = -angle;
		}
		
		delta += angle;
		
		midFB.moveY(angle);
		midFT.moveY(angle);
		midRB.moveY(angle);
		midRT.moveY(angle);
		
		end.moveY(angle*4.0f);
		
	}
	
	
}

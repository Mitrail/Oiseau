package model;

import java.util.ArrayList;
import com.jogamp.opengl.GL2;

import util.Triangle;
import util.Point3D;

/**
 * Represente les ailes de l'oiseau
 * Implement InterfaceCorps pour automatiser le rendu
 * Les ailes peuvent battre
 * La creation est modifier selon que l'aile est a droite ou a gauche
 * @author mitrail
 *
 */
public class Aile implements InterfaceCorps{
	/**
	 * Defini si l'aile monte ou descend
	 */
	private boolean monte = true;
	/**
	 * Hauteur modifier de l'aile
	 */
	private float delta  = 0;
	
	/**
	 * L'oiseau auquel l'aile est rattachee
	 */
	private Oiseau oiseau; 
	/**
	 * Liste des triangles de la partie de l'aile proche de l'oiseau
	 */
	private ArrayList<Triangle> liste1 = new ArrayList<Triangle>();
	/**
	 * Liste des triangles de la partie de l'aile eloignee de l'oiseau 
	 */
	private ArrayList<Triangle> liste2 = new ArrayList<Triangle>();
	
	/**
	 * Coeficient de redimension
	 */
	private float coef = 1.0f;
	
	/**
	 * localisation des axes communs a plusieurs points
	 */
	private float ctop = 1.5f*coef, cbot = -1.5f*coef, cfront = 5.0f*coef, crear = 0.0f*coef, cbeg = -2.5f*coef,
			mtop = 1.0f*coef, mbot = -1.0f*coef, mfront = 4.0f*coef, mrear = -1.0f*coef, mbeg = -5.0f*coef,
			ex = -20.0f*coef, ey = 0.0f*coef, ez = -10.0f*coef;
	
	/**
	 * ensemble des points de l'aile
	 */
	private Point3D closeFT,closeRT, closeFB,closeRB, midFT, midRT, midFB, midRB, end;
	
	
	/**
	 * 
	 * @param o Oiseau objet central
	 * @param b boolean droite ou gauche
	 */
	public Aile(Oiseau o, boolean b){
		this.oiseau = o;
		
		if(!b){
			cbeg = cbeg*-1.0f;
			mbeg = mbeg * -1.0f;
			ex = ex*-1.0f;
		}
		
		closeFT = new Point3D(oiseau.getX() + cbeg, oiseau.getY() + ctop, oiseau.getZ() + cfront);
		closeRT = new Point3D(oiseau.getX() + cbeg, oiseau.getY() + ctop, oiseau.getZ() + crear);
		
		closeFB = new Point3D(oiseau.getX() + cbeg, oiseau.getY() + cbot, oiseau.getZ() + cfront);
		closeRB = new Point3D(oiseau.getX() + cbeg, oiseau.getY() + cbot, oiseau.getZ() + crear);
		
		
		midFT = new Point3D(oiseau.getX() + mbeg, oiseau.getY() + mtop, oiseau.getZ() + mfront);
		midRT = new Point3D(oiseau.getX() + mbeg, oiseau.getY() + mtop, oiseau.getZ() + mrear);
		
		midFB = new Point3D(oiseau.getX() + mbeg, oiseau.getY() + mbot, oiseau.getZ() + mfront);
		midRB = new Point3D(oiseau.getX() + mbeg, oiseau.getY() + mbot, oiseau.getZ() + mrear);
		end = new Point3D(oiseau.getX() + ex, oiseau.getY() + ey, oiseau.getZ() + ez);
		
		
		if(b){
			//top
			liste1.add(new Triangle(closeFT, midFT,closeRT));
			liste1.add(new Triangle(midFT, midRT, closeRT));
			liste2.add(new Triangle(midFT,end,midRT));
			
			//front
			liste1.add(new Triangle(closeFB, midFB, midFT));
			liste1.add(new Triangle(midFT,closeFT,closeFB));
			liste2.add(new Triangle(midFT,midFB,end));
			
			//bot
			liste1.add(new Triangle(closeFB, midRB, midFB));
			liste1.add(new Triangle(closeFB, closeRB, midRB));
			liste2.add(new Triangle(midFB, midRB,end));
			
			//rear
			liste1.add(new Triangle(closeRT, midRT, closeRB));
			liste1.add(new Triangle(closeRB, midRT, midRB));
			liste2.add(new Triangle(midRT,end,midRB));
		} else {
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
	 * Faut varier les points des ailes pour les faire battre
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

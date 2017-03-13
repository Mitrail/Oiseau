package pack;

import java.util.ArrayList;

import com.jogamp.nativewindow.util.Point;
import com.jogamp.opengl.GL2;

/**
 * Represente les ailes de l'oiseau
 * decoupees en deux segements
 * @author mitrail
 *
 */
public class AileD implements InterfaceCorps{
	
	
	private Oiseau oiseau; 
	private ArrayList<Triangle> listeTri = new ArrayList<Triangle>();
	
	//close
	private float ctop = 1.5f;
	private float cbot = -1.5f;
	private float cfront = 5.0f;
	private float crear = 0.0f;
	private float cbeg = -2.5f;
	
	
	private float mtop = 1.0f;
	private float mbot = -1.0f;
	private float mfront = 4.0f;
	private float mrear = -1.0f;
	private float mbeg = -5.0f;
	
	
	private float ex = -20.0f;
	private float ey = 0.0f;
	private float ez = -10.0f;
	
	
	
	
	
	/**
	 * 
	 * @param b boolean droite ou gauche
	 * @param o Oiseau objet central
	 */
	public AileD(Oiseau o){
		this.oiseau = o;
		
		Point3D closeFT;
		Point3D closeRT;
		Point3D closeFB;
		Point3D closeRB;
		Point3D midFT;
		Point3D midRT;
		Point3D midFB;
		Point3D midRB;
		Point3D end;

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
		listeTri.add(new Triangle(closeFT, midFT,closeRT));
		listeTri.add(new Triangle(midFT, midRT, closeRT));
		listeTri.add(new Triangle(midFT,end,midRT));
		
		//front
		listeTri.add(new Triangle(closeFB, midFB, midFT));
		listeTri.add(new Triangle(midFT,closeFT,closeFB));
		listeTri.add(new Triangle(midFT,midFB,end));
		
		//bot
		listeTri.add(new Triangle(closeFB, midRB, midFB));
		listeTri.add(new Triangle(closeFB, closeRB, midRB));
		listeTri.add(new Triangle(midFB, midRB,end));
		
		//rear
		listeTri.add(new Triangle(closeRT, midRT, closeRB));
		listeTri.add(new Triangle(closeRB, midRT, midRB));
		listeTri.add(new Triangle(midRT,end,midRB));
		

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
		for (Triangle t : listeTri) {
			t.render(gl);
		}

	}
	
	/**
	 * 
	 * @param angle float la modification a apporter aux ailes
	 */
	public void battre(float angle){
		
	}
	
	
}

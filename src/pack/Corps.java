package pack;

import java.util.ArrayList;
import java.util.List;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;

public class Corps implements InterfaceCorps {
	
	public final Point3D // Points de la face avant
	pAvantHautGauche = new Point3D(-1.0f,1.0f,-2.0f),
	pAvantHautDroit = new Point3D(1.0f,1.0f,-2.0f),
	pAvantBasGauche = new Point3D(-1.0f,-1.0f,-2.0f),
	pAvantBasDroit = new Point3D(1.0f,-1.0f,-2.0f),
	
	// Points de la face arrière
	pArriereHautGauche = new Point3D(-1.0f,1.0f,2.0f),
	pArriereHautDroit = new Point3D(1.0f,1.0f,2.0f),
	pArriereBasGauche = new Point3D(-1.0f,-1.0f,2.0f),
	pArriereBasDroit = new Point3D(1.0f,-1.0f,2.0f);
	
	private Oiseau o;
	private List<Point3D> listePoints = new ArrayList<Point3D>();
	
	public Corps(Oiseau o){
		this.o = o;
		listePoints.add(pAvantBasDroit.clone());
		listePoints.add(pAvantHautDroit.clone());
		listePoints.add(pAvantBasGauche.clone());
		listePoints.add(pAvantBasDroit.clone());
		listePoints.add(pArriereHautGauche.clone());
		listePoints.add(pArriereHautDroit.clone());
		listePoints.add(pArriereBasGauche.clone());
		listePoints.add(pArriereBasDroit.clone());
	}
	
	public void afficherPoints() {
				
	}

	@Override
	public void render(GL2 gl) {
		
//		gl.glBegin(GL.GL_TRIANGLES);
//		gl.glVertex3f(p1.getX(),p1.getY(),p1.getZ());
//		gl.glVertex3f(p2.getX(),p2.getY(),p2.getZ());
//		gl.glVertex3f(p3.getX(),p3.getY(),p3.getZ());
//		gl.glEnd();
		
	}

	@Override
	public void rotate(float angle, float x, float y, float z) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(float x, float y, float z) {
		// TODO Auto-generated method stub
		
	}
}

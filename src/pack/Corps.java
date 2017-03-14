package pack;

import java.util.ArrayList;
import java.util.List;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;

public class Corps implements InterfaceCorps {
	
	// position haut-bas, gauche-droite, avant-arrière
	private final float top = 1.5f,bottom = -1.5f,right = 2.5f,left = -2.5f,front = 5.0f,back = -5.0f;
	
	private Point3D 
	// Points de la face avant
	pAvantHautGauche = new Point3D(front,top,left),
	pAvantHautDroit = new Point3D(front,top,right),
	pAvantBasGauche = new Point3D(front,bottom,left),
	pAvantBasDroit = new Point3D(front,bottom,right),
	
	// Points de la face arrière
	pArriereHautGauche = new Point3D(back,top,left),
	pArriereHautDroit = new Point3D(back,top,right),
	pArriereBasGauche = new Point3D(back,bottom,left),
	pArriereBasDroit = new Point3D(back,bottom,right);
	
	private Oiseau o;
	private List<Point3D> listePoints;
	
	public Corps(Oiseau o){
		this.o = o;
		listePoints = new ArrayList<Point3D>();
		listePoints.add(pAvantHautDroit);
		listePoints.add(pAvantHautGauche);
		listePoints.add(pAvantBasGauche);
		listePoints.add(pAvantBasDroit);
		listePoints.add(pArriereHautGauche);
		listePoints.add(pArriereHautDroit);
		listePoints.add(pArriereBasGauche);
		listePoints.add(pArriereBasDroit);
	}
	

	@Override
	public void render(GL2 gl) {
		
		gl.glColor3f(1.0f, 0.0f, 0.0f); // RED 
		
		// Face avant
		gl.glBegin(gl.GL_QUADS);
		gl.glVertex3f(pAvantHautDroit.getX(),pAvantHautDroit.getY(),pAvantHautDroit.getZ()); // pt0
		gl.glVertex3f(pAvantBasDroit.getX(),pAvantBasDroit.getY(),pAvantBasDroit.getZ()); // pt0
		gl.glVertex3f(pAvantBasGauche.getX(),pAvantBasGauche.getY(),pAvantBasGauche.getZ()); // pt0
		gl.glVertex3f(pAvantHautGauche.getX(),pAvantHautGauche.getY(),pAvantHautGauche.getZ()); // pt0
		gl.glEnd();
		
		// Face arrière
		gl.glBegin(gl.GL_QUADS);
		gl.glVertex3f(pArriereHautDroit.getX(),pArriereHautDroit.getY(),pArriereHautDroit.getZ()); // pt0
		gl.glVertex3f(pArriereHautGauche.getX(),pArriereHautGauche.getY(),pArriereHautGauche.getZ()); // pt0
		gl.glVertex3f(pArriereBasGauche.getX(),pArriereBasGauche.getY(),pArriereBasGauche.getZ()); // pt0
		gl.glVertex3f(pArriereBasDroit.getX(),pArriereBasDroit.getY(),pArriereBasDroit.getZ()); // pt0
		gl.glEnd();
		
		gl.glColor3f(0.0f, 1.0f, 0.0f); // GREEN
		
		// Face haut
		gl.glBegin(gl.GL_QUADS);
		gl.glVertex3f(pAvantHautDroit.getX(),pAvantHautDroit.getY(),pAvantHautDroit.getZ()); // pt0
		gl.glVertex3f(pAvantHautGauche.getX(),pAvantHautGauche.getY(),pAvantHautGauche.getZ()); // pt0
		gl.glVertex3f(pArriereHautGauche.getX(),pArriereHautGauche.getY(),pArriereHautGauche.getZ()); // pt0
		gl.glVertex3f(pArriereHautDroit.getX(),pArriereHautDroit.getY(),pArriereHautDroit.getZ()); // pt0
		gl.glEnd();

		// Face bas
		gl.glBegin(gl.GL_QUADS);
		gl.glVertex3f(pArriereBasDroit.getX(),pArriereBasDroit.getY(),pArriereBasDroit.getZ()); // pt0
		gl.glVertex3f(pArriereBasGauche.getX(),pArriereBasGauche.getY(),pArriereBasGauche.getZ()); // pt0
		gl.glVertex3f(pAvantBasGauche.getX(),pAvantBasGauche.getY(),pAvantBasGauche.getZ()); // pt0
		gl.glVertex3f(pAvantBasDroit.getX(),pAvantBasDroit.getY(),pAvantBasDroit.getZ()); // pt0
		gl.glEnd();
		
		gl.glColor3f(0.0f, 0.0f, 1.0f); // BLUE

		// Face gauche
		gl.glBegin(gl.GL_QUADS);
		gl.glVertex3f(pArriereHautGauche.getX(),pArriereHautGauche.getY(),pArriereHautGauche.getZ()); // pt0
		gl.glVertex3f(pAvantHautGauche.getX(),pAvantHautGauche.getY(),pAvantHautGauche.getZ()); // pt0
		gl.glVertex3f(pAvantBasGauche.getX(),pAvantBasGauche.getY(),pAvantBasGauche.getZ()); // pt0
		gl.glVertex3f(pArriereBasGauche.getX(),pArriereBasGauche.getY(),pArriereBasGauche.getZ()); // pt0
		gl.glEnd();

		// Face droite
		gl.glBegin(gl.GL_QUADS);
		gl.glVertex3f(pAvantHautDroit.getX(),pAvantHautDroit.getY(),pAvantHautDroit.getZ()); // pt0
		gl.glVertex3f(pArriereHautDroit.getX(),pArriereHautDroit.getY(),pArriereHautDroit.getZ()); // pt0
		gl.glVertex3f(pArriereBasDroit.getX(),pArriereBasDroit.getY(),pArriereBasDroit.getZ()); // pt0
		gl.glVertex3f(pAvantBasDroit.getX(),pAvantBasDroit.getY(),pAvantBasDroit.getZ()); // pt0
		gl.glEnd();
		
	}

	@Override
	public void rotate(float angle, float x, float y, float z) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(float x, float y, float z) {
		for (Point3D p : listePoints) {
			p.moveX(x);
			p.moveY(y);
			p.moveZ(z);
		}
	}
}

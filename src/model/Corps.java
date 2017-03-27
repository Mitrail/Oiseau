package model;

import java.util.ArrayList;
import java.util.List;

import com.jogamp.opengl.GL2;

import util.Point3D;

public class Corps implements InterfaceCorps {

	// position haut-bas, gauche-droite, avant-arri�re
	private float top, bottom, front, back, left, right;

	private Point3D
	// Points de la face avant
	pAvantHautGauche, pAvantBasGauche, pAvantHautDroit,pAvantBasDroit,

	// Points de la face arri�re
	pArriereHautGauche, pArriereBasGauche,pArriereHautDroit,pArriereBasDroit;

	private Oiseau o;
	private List<Point3D> listePoints = new ArrayList<Point3D>();

	public Corps(Oiseau o) {
		this.o = o;

		top = 1.5f;
		bottom = -1.5f;
		front = 5.5f;
		back = -2.0f;
		left = 2.5f;
		right = -2.5f;

		pAvantHautGauche = new Point3D(left, top, back);
		pAvantHautDroit = new Point3D(left, top, front);
		
		pAvantBasGauche = new Point3D(left, bottom, back);
		pAvantBasDroit = new Point3D(left, bottom, front);

		// Points de la face arri�re
		pArriereHautGauche = new Point3D(right, top, back);
		pArriereHautDroit = new Point3D(right, top, front);
		
		pArriereBasGauche = new Point3D(right, bottom, back);
		pArriereBasDroit = new Point3D(right, bottom, front);

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
		gl.glVertex3f(pAvantHautDroit.getX()+o.getX(), pAvantHautDroit.getY()+o.getY(), pAvantHautDroit.getZ()+o.getZ()); // pt0
		gl.glVertex3f(pAvantBasDroit.getX()+o.getX(), pAvantBasDroit.getY()+o.getY(), pAvantBasDroit.getZ()+o.getZ()); // pt0
		gl.glVertex3f(pAvantBasGauche.getX()+o.getX(), pAvantBasGauche.getY()+o.getY(), pAvantBasGauche.getZ()+o.getZ()); // pt0
		gl.glVertex3f(pAvantHautGauche.getX()+o.getX(), pAvantHautGauche.getY()+o.getY(), pAvantHautGauche.getZ()+o.getZ()); // pt0
		gl.glEnd();

		// Face arri�re
		gl.glBegin(gl.GL_QUADS);
		gl.glVertex3f(pArriereHautDroit.getX()+o.getX(), pArriereHautDroit.getY()+o.getY(), pArriereHautDroit.getZ()+o.getZ()); // pt0
		gl.glVertex3f(pArriereHautGauche.getX()+o.getX(), pArriereHautGauche.getY()+o.getY(), pArriereHautGauche.getZ()+o.getZ()); // pt0
		gl.glVertex3f(pArriereBasGauche.getX()+o.getX(), pArriereBasGauche.getY()+o.getY(), pArriereBasGauche.getZ()+o.getZ()); // pt0
		gl.glVertex3f(pArriereBasDroit.getX()+o.getX(), pArriereBasDroit.getY()+o.getY(), pArriereBasDroit.getZ()+o.getZ()); // pt0
		gl.glEnd();

		//gl.glColor3f(0.0f, 1.0f, 0.0f); // GREEN

		// Face haut
		gl.glBegin(gl.GL_QUADS);
		gl.glVertex3f(pAvantHautDroit.getX()+o.getX(), pAvantHautDroit.getY()+o.getY(), pAvantHautDroit.getZ()+o.getZ()); // pt0
		gl.glVertex3f(pAvantHautGauche.getX()+o.getX(), pAvantHautGauche.getY()+o.getY(), pAvantHautGauche.getZ()+o.getZ()); // pt0
		gl.glVertex3f(pArriereHautGauche.getX()+o.getX(), pArriereHautGauche.getY()+o.getY(), pArriereHautGauche.getZ()+o.getZ()); // pt0
		gl.glVertex3f(pArriereHautDroit.getX()+o.getX(), pArriereHautDroit.getY()+o.getY(), pArriereHautDroit.getZ()+o.getZ()); // pt0
		gl.glEnd();

		// Face bas
		gl.glBegin(gl.GL_QUADS);
		gl.glVertex3f(pArriereBasDroit.getX()+o.getX(), pArriereBasDroit.getY()+o.getY(), pArriereBasDroit.getZ()+o.getZ()); // pt0
		gl.glVertex3f(pArriereBasGauche.getX()+o.getX(), pArriereBasGauche.getY()+o.getY(), pArriereBasGauche.getZ()+o.getZ()); // pt0
		gl.glVertex3f(pAvantBasGauche.getX()+o.getX(), pAvantBasGauche.getY()+o.getY(), pAvantBasGauche.getZ()+o.getZ()); // pt0
		gl.glVertex3f(pAvantBasDroit.getX()+o.getX(), pAvantBasDroit.getY()+o.getY(), pAvantBasDroit.getZ()+o.getZ()); // pt0
		gl.glEnd();

		//gl.glColor3f(0.0f, 0.0f, 1.0f); // BLUE

		// Face gauche
		gl.glBegin(gl.GL_QUADS);
		gl.glVertex3f(pArriereHautGauche.getX()+o.getX(), pArriereHautGauche.getY()+o.getY(), pArriereHautGauche.getZ()+o.getZ()); // pt0
		gl.glVertex3f(pAvantHautGauche.getX()+o.getX(), pAvantHautGauche.getY()+o.getY(), pAvantHautGauche.getZ()+o.getZ()); // pt0
		gl.glVertex3f(pAvantBasGauche.getX()+o.getX(), pAvantBasGauche.getY()+o.getY(), pAvantBasGauche.getZ()+o.getZ()); // pt0
		gl.glVertex3f(pArriereBasGauche.getX()+o.getX(), pArriereBasGauche.getY()+o.getY(), pArriereBasGauche.getZ()+o.getZ()); // pt0
		gl.glEnd();

		// Face droite
		gl.glBegin(gl.GL_QUADS);
		gl.glVertex3f(pAvantHautDroit.getX()+o.getX(), pAvantHautDroit.getY()+o.getY(), pAvantHautDroit.getZ()+o.getZ()); // pt0
		gl.glVertex3f(pArriereHautDroit.getX()+o.getX(), pArriereHautDroit.getY()+o.getY(), pArriereHautDroit.getZ()+o.getZ()); // pt0
		gl.glVertex3f(pArriereBasDroit.getX()+o.getX(), pArriereBasDroit.getY()+o.getY(), pArriereBasDroit.getZ()+o.getZ()); // pt0
		gl.glVertex3f(pAvantBasDroit.getX()+o.getX(), pAvantBasDroit.getY()+o.getY(), pAvantBasDroit.getZ()+o.getZ()); // pt0
		gl.glEnd();

	}

	@Override
	public void rotate(float angle, float x, float y, float z) {
		// TODO Auto-generated method stub

	}

	
}

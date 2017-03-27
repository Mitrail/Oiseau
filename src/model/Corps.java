package model;

import java.util.ArrayList;
import java.util.List;

import com.jogamp.opengl.GL2;

import util.Point3D;

/**
 * Represente le corpse de l'oiseau
 * <p>
 * implements InterfaceCorps
 * <p>
 *
 */
public class Corps implements InterfaceCorps {
	/**
	 * l'Oiseau auquel le membre est rattaché
	 */
	private Oiseau o;

	/**
	 * ensemble des points de l'oiseau
	 */
	private Point3D
	// points de la face avant
	pAvantHautGauche, pAvantBasGauche, pAvantHautDroit, pAvantBasDroit,

			// Points de la face arri�re
			pArriereHautGauche, pArriereBasGauche, pArriereHautDroit, pArriereBasDroit;

	/**
	 * la liste des points pour iterer
	 */
	private List<Point3D> listePoints = new ArrayList<Point3D>();

	public Corps(Oiseau o) {
		this.o = o;

		// positions communes a plusieurs points sur un axe
		float top, bottom, front, back, left, right;

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

		// gl.glColor3f(1.0f, 0.0f, 0.0f); // RED

		// Face avant
		gl.glBegin(gl.GL_QUADS);
		gl.glVertex3f(pAvantHautDroit.getX(), pAvantHautDroit.getY(), pAvantHautDroit.getZ());
		gl.glVertex3f(pAvantBasDroit.getX(), pAvantBasDroit.getY(), pAvantBasDroit.getZ());
		gl.glVertex3f(pAvantBasGauche.getX(), pAvantBasGauche.getY(), pAvantBasGauche.getZ());
		gl.glVertex3f(pAvantHautGauche.getX(), pAvantHautGauche.getY(), pAvantHautGauche.getZ());
		gl.glEnd();

		// Face arri�re
		gl.glBegin(gl.GL_QUADS);
		gl.glVertex3f(pArriereHautDroit.getX(), pArriereHautDroit.getY(), pArriereHautDroit.getZ());
		gl.glVertex3f(pArriereHautGauche.getX(), pArriereHautGauche.getY(), pArriereHautGauche.getZ());
		gl.glVertex3f(pArriereBasGauche.getX(), pArriereBasGauche.getY(), pArriereBasGauche.getZ());
		gl.glVertex3f(pArriereBasDroit.getX(), pArriereBasDroit.getY(), pArriereBasDroit.getZ());
		gl.glEnd();

		// gl.glColor3f(0.0f, 1.0f, 0.0f); // GREEN

		// Face haut
		gl.glBegin(gl.GL_QUADS);

		gl.glVertex3f(pArriereHautDroit.getX(), pArriereHautDroit.getY(), pArriereHautDroit.getZ());
		gl.glVertex3f(pArriereHautGauche.getX(), pArriereHautGauche.getY(), pArriereHautGauche.getZ());
		gl.glVertex3f(pAvantHautGauche.getX(), pAvantHautGauche.getY(), pAvantHautGauche.getZ());
		gl.glVertex3f(pAvantHautDroit.getX(), pAvantHautDroit.getY(), pAvantHautDroit.getZ());
		gl.glEnd();

		// Face bas
		gl.glBegin(gl.GL_QUADS);
		gl.glVertex3f(pAvantBasDroit.getX(), pAvantBasDroit.getY(), pAvantBasDroit.getZ());
		gl.glVertex3f(pAvantBasGauche.getX(), pAvantBasGauche.getY(), pAvantBasGauche.getZ());
		gl.glVertex3f(pArriereBasGauche.getX(), pArriereBasGauche.getY(), pArriereBasGauche.getZ());
		gl.glVertex3f(pArriereBasDroit.getX(), pArriereBasDroit.getY(), pArriereBasDroit.getZ());
		gl.glEnd();

		// gl.glColor3f(0.0f, 0.0f, 1.0f); // BLUE

		// Face gauche
		gl.glBegin(gl.GL_QUADS);
		gl.glVertex3f(pArriereHautGauche.getX(), pArriereHautGauche.getY(), pArriereHautGauche.getZ());
		gl.glVertex3f(pAvantHautGauche.getX(), pAvantHautGauche.getY(), pAvantHautGauche.getZ());
		gl.glVertex3f(pAvantBasGauche.getX(), pAvantBasGauche.getY(), pAvantBasGauche.getZ());
		gl.glVertex3f(pArriereBasGauche.getX(), pArriereBasGauche.getY(), pArriereBasGauche.getZ());
		gl.glEnd();

		// Face droite
		gl.glBegin(gl.GL_QUADS);
		gl.glVertex3f(pAvantBasDroit.getX(), pAvantBasDroit.getY(), pAvantBasDroit.getZ());
		gl.glVertex3f(pArriereBasDroit.getX(), pArriereBasDroit.getY(), pArriereBasDroit.getZ());
		gl.glVertex3f(pArriereHautDroit.getX(), pArriereHautDroit.getY(), pArriereHautDroit.getZ());
		gl.glVertex3f(pAvantHautDroit.getX(), pAvantHautDroit.getY(), pAvantHautDroit.getZ());
		gl.glEnd();

	}

}

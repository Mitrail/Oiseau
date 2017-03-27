package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MyGLEventListener;
import view.Window2;

public class EcouteurBouton implements ActionListener {

	private Window2 w;
	private MyGLEventListener glListener;
	
	public EcouteurBouton(Window2 w, MyGLEventListener gl) {
		this.glListener = gl;
		this.w = w;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Modification de l'angle de la caméra
		if (e.getSource().equals(w.getBtnD())) {
			glListener.updateAngleCam(0.0f, -1.0f, 0.0f);
		}
		else if (e.getSource().equals(w.getBtnZ())) {
			glListener.updateAngleCam(0.0f, 1.0f, 0.0f);
		}
		else if (e.getSource().equals(w.getBtnQ())) {
			glListener.updateAngleCam(-1.0f, 0.0f, 0.0f);
		}
		else if (e.getSource().equals(w.getBtnS())) {
			glListener.updateAngleCam(1.0f, 0.0f, 0.0f);
		}
		
		// Modification de la position de la caméra
		else if (e.getSource().equals(w.getBtnDroite())) {
			glListener.updatePosCam(1.0f, 0.0f, 0.0f);
		}
		else if (e.getSource().equals(w.getBtnGauche())) {
			glListener.updatePosCam(-1.0f, 0.0f, 0.0f);
		}
		else if (e.getSource().equals(w.getBtnAvant())) {
			glListener.updatePosCam(0.0f, 0.0f, -1.0f); 
		}
		else if (e.getSource().equals(w.getBtnArriere())) {
			glListener.updatePosCam(0.0f, 0.0f, 1.0f);
		}
		else if (e.getSource().equals(w.getBtnBas())) {
			glListener.updatePosCam(0.0f, -1.0f, 0.0f);
		}
		else if (e.getSource().equals(w.getBtnHaut())) {
			glListener.updatePosCam(0.0f, 1.0f, 0.0f);
		}
		
		else {
			
		}
		
	}

}

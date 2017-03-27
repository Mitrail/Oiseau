package control;

import java.awt.event.KeyListener;

import model.Oiseau;
import view.MyGLEventListener;


public class EcouteurClavier implements KeyListener {

	private MyGLEventListener glListener;

	public EcouteurClavier(MyGLEventListener glListener) {
		this.glListener = glListener;
	}

	@Override
	public void keyPressed(java.awt.event.KeyEvent e) {
		if (e.getKeyChar() == 'd') {
			glListener.updateAngleCam(1.0f, 0.0f, 0.0f);
		}
		if (e.getKeyChar() == 'z') {
			glListener.updateAngleCam(0.0f, 1.0f, 0.0f);
		}

		if (e.getKeyChar() == 'q') {
			glListener.updateAngleCam(-1.0f, 0.0f, 0.0f);
		}
		if (e.getKeyChar() == 's') {
			glListener.updateAngleCam(0.0f, -1.0f, 0.0f);
		}

		
		
		if (e.getKeyChar() == 'm') {
			glListener.updatePosCam(1.0f, 0.0f, 0.0f);
		}
		if (e.getKeyChar() == 'k') {
			glListener.updatePosCam(-1.0f, 0.0f, 0.0f);
		}
		if (e.getKeyChar() == 'o') {
			glListener.updatePosCam(0.0f, 0.0f, -1.0f);
		}
		if (e.getKeyChar() == 'l') {
			glListener.updatePosCam(0.0f, 0.0f, 1.0f);
		}
		if (e.getKeyChar() == 'p') {
			glListener.updatePosCam(0.0f, -1.0f, 0.0f);
		}
		if (e.getKeyChar() == 'i') {
			glListener.updatePosCam(0.0f, 1.0f, 0.0f);
		}
		

		 if (e.getKeyChar() == 'a') { 
			 for (Oiseau o : glListener.getAo()){
				 o.move(0.0f, 0.0f, -0.1f); 
			 }
            
        } 
		 if (e.getKeyChar() == 'e') { 
			 for (Oiseau o : glListener.getAo()){
				 o.move(0.0f, 0.0f, 0.1f); 
			 }
         } 
		 if (e.getKeyChar() == 'w') { 
			 for (Oiseau o : glListener.getAo()){
				 o.move(0.1f, 0.0f, -0.0f); 
			 }
         } if (e.getKeyChar() == 'c') { 
        	 for (Oiseau o : glListener.getAo()){
				 o.move(-0.1f, 0.0f, -0.0f); 
			 }
         } 

		
	}

	@Override
	public void keyReleased(java.awt.event.KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(java.awt.event.KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}


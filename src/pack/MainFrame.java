package pack;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import com.jogamp.opengl.util.FPSAnimator;

public class MainFrame extends JFrame{

	public MainFrame() {

		setTitle("Un peu de JOGL");

		setSize(640, 480);

		// D�finit les crit�res que le contexte du rendu doit supporter
		// Si la machine ne peut rendre ce que l'on attend d'elle, une extension
		// sera lev�e
		GLCapabilities glCapabilities = new GLCapabilities(GLProfile.getDefault());

		// Cr�ation du canvas OpenGL
		// Support du dessin
		GLCanvas glCanvas = new GLCanvas(glCapabilities);

		MyGLEventListener glListener = new MyGLEventListener();
		
		

		// Callback attach�e � la surface dessinable
		glCanvas.addGLEventListener(glListener);

        glCanvas.addKeyListener(new java.awt.event.KeyListener() {

            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {

            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                // TODO Auto-generated method stub
                if (e.getKeyChar() == 'd') {
                    glListener.updateAngleCam(1.0f,0.0f,0.0f);
                }
                if (e.getKeyChar() == 'z') {
                    glListener.updateAngleCam(0.0f,1.0f,0.0f);
                }
                
                if (e.getKeyChar() == 'q') {
                    glListener.updateAngleCam(-1.0f,0.0f,0.0f);
                }
                if (e.getKeyChar() == 's') {
                    glListener.updateAngleCam(0.0f,-1.0f,0.0f);
                }
                
                
                if (e.getKeyChar() == 'm') {
                    glListener.updatePosCam(1.0f,0.0f,0.0f);
                }
                if (e.getKeyChar() == 'k') {
                    glListener.updatePosCam(-1.0f,0.0f,0.0f);
                }
                if (e.getKeyChar() == 'o') {
                    glListener.updatePosCam(0.0f,0.0f,-1.0f);
                }
                if (e.getKeyChar() == 'l') {
                    glListener.updatePosCam(0.0f,0.0f,1.0f);
                }
                
                if (e.getKeyChar() == 'a') {
                    glListener.o.move(0.0f, 0.1f, 0.0f);
                }
            }
        });

		// Surface dessinable attach�e � la fen�tre
		add(glCanvas);

		// Cr�ation de l'animator
		final FPSAnimator animator = new FPSAnimator(glCanvas, 60);

		// Gestion de la fermeture de la fen�tre
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				animator.stop();
				System.exit(0);
			}
		});
		
		// D�marrage de l'animator qui se charge d'appeler la fonction display()
		animator.start();

	}

	private static final long serialVersionUID = -1227038124975588633L;


}
package view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import com.jogamp.opengl.util.FPSAnimator;

import control.EcouteurClavier;

public class MainFrame extends JFrame {

	public MainFrame() {

		setTitle("Oiseau 3D");
		setSize(640, 480);

		// D�finit les crit�res que le contexte du rendu doit supporter
		// Si la machine ne peut rendre ce que l'on attend d'elle, une exception
		// sera lev�e
		GLCapabilities glCapabilities = new GLCapabilities(GLProfile.getDefault());

		// Cr�ation du canvas OpenGL. Support du dessin
		GLCanvas glCanvas = new GLCanvas(glCapabilities);
		MyGLEventListener glListener = new MyGLEventListener();
		
		// Callback attach� � la surface dessinable
		glCanvas.addGLEventListener(glListener);
		
		// Ajout d'un KeyListener sur le canvas
		glCanvas.addKeyListener(new EcouteurClavier(glListener));
		 
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
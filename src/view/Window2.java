package view;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import control.EcouteurBouton;
import control.EcouteurClavier;
import javax.swing.JLabel;

public class Window2 extends JFrame{

	private JFrame frame;
	private JPanel panelCanvas,panelButton;
	private JButton btnD,btnZ,btnQ,btnS,btnAvant,btnArriere,btnGauche,btnDroite,btnHaut,btnBas;
	private JLabel lblModifierLaPosition;


	/**
	 * Create the application.
	 */
	public Window2() {
		chargerLookAndFeelNimbus();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 854, 608);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		setSize(1059, 630);
		getContentPane().setLayout(null);
		
		panelCanvas = new JPanel(new BorderLayout());
		panelCanvas.setBounds(10, 11, 586, 569);
		getContentPane().add(panelCanvas);
		
		panelButton = new JPanel();
		panelButton.setBounds(606, 11, 427, 569);
		getContentPane().add(panelButton);
		panelButton.setLayout(null);
		
	
		GLCapabilities glCapabilities = new GLCapabilities(GLProfile.getDefault());

		// Crï¿½ation du canvas OpenGL. Support du dessin
		GLCanvas glCanvas = new GLCanvas(glCapabilities);
		
		MyGLEventListener glListener = new MyGLEventListener();
		glListener.updatePosCam(25, 25, 25);
		
		// Callback attachï¿½ ï¿½ la surface dessinable
		glCanvas.addGLEventListener(glListener);
		
		// Ajout d'un KeyListener sur le canvas
		glCanvas.addKeyListener(new EcouteurClavier(glListener));
		 
		// Surface dessinable attachï¿½e ï¿½ la fenï¿½tre
		panelCanvas.add(glCanvas);
		
		// Crï¿½ation de l'animator
		final FPSAnimator animator = new FPSAnimator(glCanvas, 60);

		// Gestion de la fermeture de la fenï¿½tre
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				animator.stop();
				System.exit(0);
			}
		});
		
		// Dï¿½marrage de l'animator qui se charge d'appeler la fonction display()
		animator.start();
		
		// Création et initialisation des boutons
		btnZ = new JButton("Z");
		btnZ.addActionListener(new EcouteurBouton(this,glListener));
		btnZ.setBounds(281, 6, 40, 40);
		panelButton.add(btnZ);
		
		btnQ = new JButton("Q");
		btnQ.addActionListener(new EcouteurBouton(this,glListener));
		btnQ.setBounds(229, 58, 40, 40);
		panelButton.add(btnQ);
		
		btnD = new JButton("S");
		btnD.addActionListener(new EcouteurBouton(this,glListener));
		btnD.setBounds(281, 58, 40, 40);
		panelButton.add(btnD);
		
		btnS = new JButton("D");
		btnS.addActionListener(new EcouteurBouton(this,glListener));
		btnS.setBounds(333, 58, 40, 40);
		panelButton.add(btnS);
		
		JLabel lblMo = new JLabel("Modifier l'angle de la cam\u00E9ra :");
		lblMo.setBounds(6, 33, 166, 33);
		panelButton.add(lblMo);

		btnHaut = new JButton("Haut - O");
		btnHaut.addActionListener(new EcouteurBouton(this,glListener));
		btnHaut.setBounds(281, 224, 90, 40);
		panelButton.add(btnHaut);
		
		btnBas = new JButton("Bas - U");
		btnBas.addActionListener(new EcouteurBouton(this,glListener));
		btnBas.setBounds(75, 224, 90, 40);
		panelButton.add(btnBas);
		
		btnAvant = new JButton("Avant - I");
		btnAvant.addActionListener(new EcouteurBouton(this,glListener));
		btnAvant.setBounds(177, 224, 90, 40);
		panelButton.add(btnAvant);
		
		btnArriere = new JButton("Arrière - K");
		btnArriere.addActionListener(new EcouteurBouton(this,glListener));
		btnArriere.setBounds(177, 276, 90, 40);
		panelButton.add(btnArriere);
		
		btnGauche = new JButton("Gauche - J");
		btnGauche.addActionListener(new EcouteurBouton(this,glListener));
		btnGauche.setBounds(75, 276, 90, 40);
		panelButton.add(btnGauche);
		
		btnDroite = new JButton("Droite - L");
		btnDroite.addActionListener(new EcouteurBouton(this,glListener));
		btnDroite.setBounds(281, 276, 90, 40);
		panelButton.add(btnDroite);
		
		lblModifierLaPosition = new JLabel("Modifier la position de la cam\u00E9ra : ");
		lblModifierLaPosition.setBounds(6, 165, 204, 33);
		panelButton.add(lblModifierLaPosition);
		
	}
	
	
	// Recherche et charge l'apparence "Nimbus"
	public static void chargerLookAndFeelNimbus() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("Look Nimbus indisponible");
		}
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getPanelCanvas() {
		return panelCanvas;
	}

	public void setPanelCanvas(JPanel panelCanvas) {
		this.panelCanvas = panelCanvas;
	}

	public JPanel getPanelButton() {
		return panelButton;
	}

	public void setPanelButton(JPanel panelButton) {
		this.panelButton = panelButton;
	}

	public JButton getBtnD() {
		return btnD;
	}

	public JButton getBtnZ() {
		return btnZ;
	}

	public JButton getBtnQ() {
		return btnQ;
	}

	public JButton getBtnS() {
		return btnS;
	}

	public JButton getBtnAvant() {
		return btnAvant;
	}

	public JButton getBtnArriere() {
		return btnArriere;
	}

	public JButton getBtnGauche() {
		return btnGauche;
	}

	public JButton getBtnDroite() {
		return btnDroite;
	}

	public JButton getBtnHaut() {
		return btnHaut;
	}

	public JButton getBtnBas() {
		return btnBas;
	}

	public JLabel getLblModifierLaPosition() {
		return lblModifierLaPosition;
	}
	
	
}

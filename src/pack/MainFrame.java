package pack;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import com.jogamp.opengl.util.FPSAnimator;



public class MainFrame extends JFrame {



        public MainFrame(){

            setTitle("Un peu de JOGL");

            setSize(640, 480);


            //Définit les critères que le contexte du rendu doit supporter
            //Si la machine ne peut rendre ce que l'on attend d'elle, une extension
            //sera levée
            GLCapabilities glCapabilities = new GLCapabilities(GLProfile.getDefault());

            //Création du canvas OpenGL
            //Support du dessin
            GLCanvas glCanvas = new GLCanvas(glCapabilities);


            MyGLEventListener glListener = new MyGLEventListener();

            //Callback attachée à la surface dessinable
            glCanvas.addGLEventListener(glListener);

            //Surface dessinable attachée à la fenêtre
            add(glCanvas);

            //Création de l'animator
            final FPSAnimator animator = new FPSAnimator(glCanvas, 60);


            //Gestion de la fermeture de la fenêtre
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    animator.stop();
                    System.exit(0);
                }
            });


            //Démarrage de l'animator qui se charge d'appeler la fonction display()
            animator.start();

        }



        private static final long serialVersionUID = -1227038124975588633L;



    }
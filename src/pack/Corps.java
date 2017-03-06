package pack;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;

public class Corps implements GLEventListener {

	private GL2 gl;
	private GLU glu = new GLU();
	private GLUT glut = new GLUT();

	private float camera[] = { 0f, 10f, 20f };
	private float[] light_0_ambient = { 0.5f, 0.5f, 0.5f, 0.0f };
	private float[] light_0_diffuse = { 0.75f, 0.75f, 0.75f, 0.0f };
	private float[] light_0_specular = { 0.1f, 0.1f, 0.1f, 1.0f };
	private float[] light_0_position = { 100f, 0f, 100f, 1f };
	private float[] material_specular = { 1.0f, 1.0f, 1.0f, 1.0f };
	
	@Override
	public void init(GLAutoDrawable drawable) {

		gl = drawable.getGL().getGL2();
		gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

		gl.glEnable(GL2.GL_DEPTH_TEST);
		gl.glClearDepth(1.0f);

		gl.glShadeModel(GL2.GL_SMOOTH);
		gl.glEnable(GL2.GL_LIGHTING);

		gl.glEnable(GL2.GL_LIGHT0);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, light_0_ambient, 0);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, light_0_diffuse, 0);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_SPECULAR, light_0_specular, 0);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, light_0_position, 0);

		gl.glEnable(GL2.GL_COLOR_MATERIAL);
		gl.glColorMaterial(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE);
		gl.glMateriali(GL2.GL_FRONT_AND_BACK, GL2.GL_SHININESS, 90);

		gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, material_specular, 0);
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
	}

	@Override
	public void display(GLAutoDrawable drawable) {

		GL2 gl = drawable.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		glu.gluLookAt(camera[0], camera[1], camera[2], 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);

		gl.glColor3f(0.0f, 0.0f, 1.0f);
		gl.glRotatef(5, 0, 1, 0);
		glut.glutWireTeapot(5);

	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {

		GL2 gl = drawable.getGL().getGL2();
		gl.glViewport(x, y, width, height);

		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluPerspective(60.0f, (float) width / height, 0.1f, 100.0f);
		gl.glMatrixMode(GL2.GL_MODELVIEW);

	}
	
	public void afficherPoints() {
		Point3D pAvantHautGauche = new Point3D(-1.0f,1.0f,-2.0f);
		Point3D pAvantHautDroit = new Point3D(1.0f,1.0f,-2.0f);
		Point3D pAvantBasGauche = new Point3D(-1.0f,-1.0f,-2.0f);
		Point3D pAvantBasDroit = new Point3D(1.0f,-1.0f,-2.0f);
		
		Point3D pArriereHautGauche = new Point3D(-1.0f,1.0f,2.0f);
		Point3D pArriereHautDroit = new Point3D(1.0f,1.0f,2.0f);
		Point3D pArriereBasGauche = new Point3D(-1.0f,-1.0f,2.0f);
		Point3D pArriereBasDroit = new Point3D(1.0f,-1.0f,2.0f);
		
		
	}
}

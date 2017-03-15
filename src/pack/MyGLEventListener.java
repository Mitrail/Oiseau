package pack;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GL2GL3;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;

public class MyGLEventListener implements GLEventListener {

	Oiseau o = new Oiseau(0,0,0);
	Oiseau o2 = new Oiseau(-25,0,-25);
	Oiseau o3 = new Oiseau(25,0,-25);
	
	float modx = 0.0f;
	float mody = 0.0f;
	float modz = 0.0f;
	
	float modPosx = 0.0f;
	float modPosy = 0.0f;
	float modPosz = 0.0f;

	@Override
	public void init(GLAutoDrawable drawable) {

		GL2 gl = drawable.getGL().getGL2();
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
	
	public void updateAngleCam(float x, float y, float z){
		modx += x;
		mody += y;
		modz += z;
	}
	
	public void updatePosCam(float x, float y, float z){
		modPosx += x;
		modPosy += y;
		modPosz += z;
		modx += x;
		mody += y;
		modz += z;
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
		//glu.gluLookAt(camera[0], camera[1], camera[2], 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
		glu.gluLookAt(
                camera[0]+modPosx, camera[1]+modPosy, camera[2]+modPosz,
                modx, mody, modz,
                0.0f, 1.0f, 0.0f
        );
		gl.glPolygonMode(GL.GL_FRONT, GL2GL3.GL_LINE);getClass();
		gl.glColor3f(1.0f, 0.0f, 0.0f);

		o.render(gl);
		o2.render(gl);
		o3.render(gl);

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

	private GLU glu = new GLU();
	private GLUT glut = new GLUT();

	private float camera[] = { 0f, 10f, 20f };
	private float[] light_0_ambient = { 0.5f, 0.5f, 0.5f, 0.0f };
	private float[] light_0_diffuse = { 0.75f, 0.75f, 0.75f, 0.0f };
	private float[] light_0_specular = { 0.1f, 0.1f, 0.1f, 1.0f };
	private float[] light_0_position = { 100f, 0f, 100f, 1f };
	private float[] material_specular = { 1.0f, 1.0f, 1.0f, 1.0f };
}
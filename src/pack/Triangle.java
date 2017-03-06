package pack;

import com.jogamp.opengl.GL2;

public class Triangle {
	private Point3D p1;
	private Point3D p2;
	private Point3D p3;

	
	public Triangle(float ax,float ay,float az,float bx,float by,float bz,float cx,float cy,float cz){
		p1 = new Point3D(ax,ay,az);
		p2 = new Point3D(bx,by,bz);
		p3 = new Point3D(cx,cy,cz);
	}
	
	
	public void render(GL2 gl){
		gl.glBegin(GL.GL_TRIANGLES);
		gl.glVertex3f(p1.getX(),p1.getY,p1.getZ);
		gl.glVertex3f(p2.getX(),p2.getY,p2.getZ);
		gl.glVertex3f(p3.getX(),p3.getY,p3.getZ);
		gl.glEnd();
	}

}

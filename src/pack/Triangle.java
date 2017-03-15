package pack;

import com.jogamp.opengl.GL;
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
	
	public Triangle(Point3D p1,Point3D p2,Point3D p3) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	
	public void render(GL2 gl){
		gl.glBegin(GL.GL_TRIANGLES);
		gl.glVertex3f(p1.getX(),p1.getY(),p1.getZ());
		gl.glVertex3f(p2.getX(),p2.getY(),p2.getZ());
		gl.glVertex3f(p3.getX(),p3.getY(),p3.getZ());
		gl.glEnd();
	}
	
	public void render(GL2 gl, Oiseau o){
		gl.glBegin(GL.GL_TRIANGLES);
		gl.glVertex3f(p1.getX()+o.getX(),p1.getY()+o.getY(),p1.getZ()+o.getZ());
		gl.glVertex3f(p2.getX()+o.getX(),p2.getY()+o.getY(),p2.getZ()+o.getZ());
		gl.glVertex3f(p3.getX()+o.getX(),p3.getY()+o.getY(),p3.getZ()+o.getZ());
		gl.glEnd();
	}
	
	
	/**
	 * @deprecated
	 */
	public void move(float x, float y, float z){
		p1.setPos(x, y, z);
		p2.setPos(x, y, z);
		p3.setPos(x, y, z);
	}
	
	public void update(float x,float y, float z){
		
	}

	@Override
	public String toString() {
		return "Triangle [p1=" + p1.getX() + ", p2=" + p1.getY() + ", p3=" + p1.getZ() + "]";
	}
	
	

}

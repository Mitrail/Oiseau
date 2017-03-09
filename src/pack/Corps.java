package pack;

import com.jogamp.opengl.GL2;

public class Corps implements InterfaceCorps {
	
	Oiseau o;
	
	public Corps(Oiseau o){
		this.o = o;
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

	@Override
	public void render(GL2 gl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rotate(float angle, float x, float y, float z) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(float x, float y, float z) {
		// TODO Auto-generated method stub
		
	}
}

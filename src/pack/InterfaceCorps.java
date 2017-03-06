package pack;

import com.jogamp.opengl.GL2;

/**
 * Assure que toutes les parties du corps ont une methode de :
 * rendu
 * rotation
 * deplacement
 * @author mitrail
 *
 */
public interface InterfaceCorps {

	public void render(GL2 gl);
	
	public void rotate(float angle,float x, float y, float z);//todo
	
	public void move(float x, float y, float z);//todo
	
}

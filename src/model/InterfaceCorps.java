package model;

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

	/**
	 * Effecteur le rendu du membre en utilisant l'objet gl
	 * @param gl  l'objet placant les points
	 */
	public void render(GL2 gl);


	
}

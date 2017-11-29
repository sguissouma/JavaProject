package view;

import java.awt.Dimension;
import javax.swing.JFrame;

@SuppressWarnings("serial")
 public abstract class Fenetre extends JFrame{

	/**
	  Cette m�thode repack la fenetre et la centre au milieu de l'�cran de l'utilisateur
	 */
	public void centrer(){
		this.pack();
		Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int hauteur = (int)tailleEcran.getHeight();
		int largeur = (int)tailleEcran.getWidth();
		this.setLocation((largeur-this.getWidth())/2, (hauteur-this.getHeight())/2);
	}

}

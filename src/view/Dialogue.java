package view;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
@SuppressWarnings("serial")
public class Dialogue extends JDialog{
	
	
	
	public Dialogue(JFrame parent, String string, boolean modale) {
		super(parent,string,modale);
	}
	/**
	  Cette méthode repack la fenetre et la centre au milieu de l'écran de l'utilisateur
	 */
	public void centrer(){
		this.pack();
		Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int hauteur = (int)tailleEcran.getHeight();
		int largeur = (int)tailleEcran.getWidth();
		this.setLocation((largeur-this.getWidth())/2, (hauteur-this.getHeight())/2);
	}

	
	
	
	
	
	
	
}

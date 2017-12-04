package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class FenetrePrincipale extends Fenetre{
	
	/**
	 * Toolbar du haut de la fenetre
	 */
	private TopToolbarFenPrincipale topToolbar;
	
	
	public FenetrePrincipale(){
		
		this.setTitle("Labyrinthe");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		this.setResizable(false);
		
		topToolbar = new TopToolbarFenPrincipale();
		
		initTop();
		initCenter();
		initBottom();
		
		centrer();	
	}

	private void initTop(){
		this.setJMenuBar(topToolbar);
	}
	
	private void initCenter(){

	}
	
	private void initBottom(){
		
	}
	
	/**
	 * Getter de la toolbar du haut de la fenetre.
	 * @return retourne la toolbar du haut de la fenetre.
	 */
	public TopToolbarFenPrincipale getTopToolbarFenPrincipale(){
		return topToolbar;
	}
	
	public void display() {
		super.setVisible(true);
		update();
	}
	
	public void update() {
	}

}

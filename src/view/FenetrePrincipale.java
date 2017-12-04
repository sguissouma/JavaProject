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
	private GameDisplay gameDisplay;
	
	
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
		gameDisplay = new GameDisplay(4, 4);//TODO : trouver un moyen de lier WIDTH et HEIGHT à ceux qui sont (pour l'instant) écrits dans Labyrinthe.java
		this.add(gameDisplay,BorderLayout.CENTER);
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
		gameDisplay.render();
	}

}

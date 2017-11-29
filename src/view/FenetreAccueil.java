package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
/**
 * Classe matérialisant la fenêtre d'acceuil du programme.
 * @author Carlos Nezout
 *
 */
public class FenetreAccueil extends Fenetre{
	

	
	private JButton start;
	private JButton load;
	private JButton option;
	private JButton quit;
	
	/**
	 * Constructeur de la fenetre d'accueil.
	 * Initialise les boutons puis les place
	 */
	public FenetreAccueil(){
		
		this.setTitle("Labyrinthe : ");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		this.setResizable(false);
		this.setJMenuBar(new TopToolbarFenPrincipale());
			
		start = new JButton("Commencer une partie");		
		start.setOpaque(false);
		start.setContentAreaFilled(false);
	//	start.setBorderPainted(false);

		load =  new JButton("Charger une partie");
		load.setOpaque(false);
		load.setContentAreaFilled(false);

		option = new JButton("Options");	
		option.setOpaque(false);
		option.setContentAreaFilled(false);
		
		quit =  new JButton("Quitter");
		quit.setOpaque(false);
		quit.setContentAreaFilled(false);
		
		initTop();
		initCenter();
		initBottom();
		
		centrer();	
	}

	private void initTop(){
	}
	
	private void initCenter(){
		JPanel panEast = new JPanel(new GridLayout(1,0));
		
		JPanel panBoutons = new JPanel(new GridLayout(0,1));
		panBoutons.add(new JPanel());
		panBoutons.add(start);
		panBoutons.add(new JPanel());
		panBoutons.add(load);
		panBoutons.add(new JPanel());
		panBoutons.add(option);
		panBoutons.add(new JPanel());
		panBoutons.add(quit);
		panBoutons.add(new JPanel());
		
		panEast.add(new JPanel());
		panEast.add(new JPanel());
		panEast.add(panBoutons);
		panEast.add(new JPanel());
	
		this.add(panEast,BorderLayout.CENTER);
	}
	
	
	
	private void initBottom(){
		
	}

	/**
     *@return le bouton demarrer
     */
	public JButton getStart(){
		return this.start;
	}
    /**
     *@return le bouton charger
     */
	public JButton getLoad(){
		return this.load;
	}
	/**
     *@return le bouton option
     */
	public JButton getOption(){
		return this.option;
	}	
    /**
     *@return le bouton quitter
     */
	public JButton getExit(){
		return this.quit;
	}
}

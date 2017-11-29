package controller;


import view.FenetreAccueil;
import view.FenetreMsgErreur;
import view.FenetreOption;
import view.FenetrePrincipale;

/**
 * Cette classe fait tourner le programme graphiquement.
 * @author Carlos Nezout
 */
public class GestionnaireGraphique extends Gestionnaire{

	/**
	 * Fenêtre d'acceuil, donnant accès au menu principal
	 */
	private FenetreAccueil fenetreAccueil;

	private FenetrePrincipale fenetrePrincipale;
	
	public GestionnaireGraphique(){
		super();
		fenetreAccueil = new FenetreAccueil();
		fenetrePrincipale = new FenetrePrincipale();
	}

	@Override
	/**
	 * Cette méthode lance le gestionnaire graphique. Elle lance le menu principal via la fenêtre d'accueil.
	 */
	public void run() {
		setControlersFenetreAccueil();
		setControlersFenetreOption();
		fenetreAccueil.setVisible(true);	
	}
	
	/**
	 * Cette méthode ouvre une nouvelle fenetre modale pour afficher une erreur
	 * @param error le message à afficher
	 */
	@Override
	protected void erreur(String error) {
		new FenetreMsgErreur(error, null);
	}
	
	/**
	 * Attribue les controleurs aux éléments de la fenetre d'accueil
	 */
	private void setControlersFenetreAccueil(){
		ListenerAccueil listener = new ListenerAccueil(this);
		fenetreAccueil.getStart().addActionListener(listener);
		fenetreAccueil.getLoad().addActionListener(listener);
		fenetreAccueil.getOption().addActionListener(listener);
		fenetreAccueil.getExit().addActionListener(listener);	
	}
	
	/**
	 * Attribue les controleurs aux éléments de la fenetre des options
	 */
	private void setControlersFenetreOption(){
				
		
	}
	
	
	
	public void showOptions(){		
		FenetreOption fenetreOption = new FenetreOption(null); 
		fenetreOption.setVisible(true);
	}
	
	
	/**
	 * Fonction permettant d'arreter le programme.<br/>
	 * Il procède à la fermeture des fenêtres
	 */
	public void endProgram(){
		fenetreAccueil.dispose();		
	}
	
		
	/**
	 * Getter de la fenetre d'accueil
	 */
	public FenetreAccueil getFenetreAccueil(){
		return fenetreAccueil;
	}	
	
	public FenetrePrincipale getFenetrePrincipale() {
		return fenetrePrincipale;
	}
}

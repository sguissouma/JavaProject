package controller;

/**
 * Classe générale de gestion pour controler le programme
 * @author Carlos Nezout
 *
 */
public abstract class Gestionnaire {
	
	/**
	 * Constructeur<br/>
	 */
	public Gestionnaire(){

	}
	/**
	 * Cette fonction doit lancer le gestionnaire selon son type.
	 */
	public abstract void run();
	
	/**
	 * Cette fonction doit permettre d'afficher une erreur quelque soit le type du gestionnaire
	 * @param erreur
	 */
	protected abstract void erreur(String error);
	
		
}

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Cette classe "�coute" les boutons de la fenetre d'accueil
 * @author Carlos Nezout
 *
 */
public class ListenerAccueil implements ActionListener{
	
	GestionnaireGraphique gestion;
	
	public ListenerAccueil(GestionnaireGraphique g){
		gestion=g;
	}
	
	/**
	 * Selon le bouton sur lequel on a appuy� sur la fenetre d'accueil, le gestionnaire ex�cute une action diff�rente
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource()==gestion.getFenetreAccueil().getStart()){
			gestion.getFenetrePrincipale().display();//on affiche la fen�tre principale en cas de clic sur le bouton getStart 
		}
		else if(arg0.getSource()==gestion.getFenetreAccueil().getLoad()){
			
		}
		else if(arg0.getSource()==gestion.getFenetreAccueil().getOption()){
			gestion.showOptions();
		}
		else{//L'utilisateur a appuy� sur le bouton "quitter"
			gestion.endProgram();
		}
		
	}
}

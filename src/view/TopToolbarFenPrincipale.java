package view;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import model.Horloge;

@SuppressWarnings("serial")
public class TopToolbarFenPrincipale extends JMenuBar{
	
	/**
	 * onglet "Fichier"
	 */
	private JMenu onglet1;
	/**
	 * item "Nouveau"
	 */
	private JMenuItem item1;
	/**
	 * item "Charger"
	 */
	private JMenuItem item2;
	/**
	 * item "Sauver"
	 */
	private JMenuItem item3;
	/**
	 * item "Quitter"
	 */
	private JMenuItem item4;
	/**
	 * onglet "A propos"
	 */
	private JMenu onglet2;
	/**
	 * item "Aide"
	 */
	private JMenuItem item5;
	/**
	 * item "?"
	 */
	private JMenuItem item6;

	private JMenu heure;
	
	public TopToolbarFenPrincipale(){

		//Initialisation de l'onglet "Fichier" et de ses items
		onglet1 = new JMenu("Fichier");
		item1 = new JMenuItem("Nouveau");
		item2 = new JMenuItem("Charger");
		item3 = new JMenuItem("Enregistrer");
		item4 = new JMenuItem("Quitter");
		
		onglet1.setMnemonic(KeyEvent.VK_F);
		item1.setMnemonic(KeyEvent.VK_N);
		item2.setMnemonic(KeyEvent.VK_C);
		item3.setMnemonic(KeyEvent.VK_S);
		item4.setMnemonic(KeyEvent.VK_Q);
		
		onglet1.add(item1);
		onglet1.add(item2);
		onglet1.add(item3);
		onglet1.add(item4);
		
		//Initialisation de l'onglet "A Propos" et de ses items
		onglet2 = new JMenu("A propos");				
		item5 = new JMenuItem("Aide");		
		item6 = new JMenuItem("Version");

		onglet2.setMnemonic('P');
		item5.setMnemonic(KeyEvent.VK_A);
		item6.setMnemonic(KeyEvent.VK_V);
		
		onglet2.add(item5);
		onglet2.add(item6);
		
		Horloge horloge = new Horloge();
		heure = new JMenu(horloge.getHeure());
		
		this.add(onglet1);	
		this.add(onglet2);
		this.add(heure);
	}
		
	
	public JMenuItem getNouveau(){
		return item1;
	}
	public JMenuItem getCharger(){
		return item2;
	}
	public JMenuItem getSauver(){
		return item3;
	}
	public JMenuItem getQuitter(){
		return item4;
	}
	public JMenuItem getAide(){
		return item5;
	}
	public JMenuItem getVersion(){
		return item6;
	}
}
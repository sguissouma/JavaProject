package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



@SuppressWarnings("serial")
/**
 * Générateur de fenetres d'erreur
 * @author Carlos Nezout
 */
public class FenetreMsgErreur extends Dialogue{
	
	
	
	public FenetreMsgErreur(String msgErreur,JFrame parent){
		
		super(parent,"Labyrinthe : Une erreur inatendue s'est produite",true);
		this.setResizable(true);	
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		initCenter(msgErreur);

		centrer();
		this.setVisible(true);
	
	}
	
	public void initCenter(String msgErreur){
		
		JPanel panMsgErreur = new JPanel();
		panMsgErreur.setLayout(new BorderLayout());
		
		JLabel msgError=new JLabel(msgErreur);
		msgError.setFont(new Font("Arial", Font.BOLD, 20));
		msgError.setForeground(Color.BLACK);
		msgError.setHorizontalAlignment(JLabel.CENTER);//mettre le label au centre du conteneur quelque soit le layout du conteneur

		panMsgErreur.add(msgError,BorderLayout.CENTER);
		
		this.add(panMsgErreur,BorderLayout.CENTER);
		
	}
}

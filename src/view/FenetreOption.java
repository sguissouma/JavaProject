package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
/**
 * Classe matérialisant la fenêtre présentant les options disponibles.
 * @author Arthur
 *
 */
public class FenetreOption extends Dialogue{

	private JComboBox<String> option1;
	public FenetreOption(JFrame parent){
		
		super(parent,"Labyrinthe : Options",true);
		this.setResizable(true);	
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBackground(Color.BLUE);
		
		JLabel langueLabel = new JLabel("Option 1");

		String[] tab = {"Français","English","Español"};
		this.option1 = new JComboBox<String>(tab);
		this.option1.setSelectedIndex(0);
		
		/*
		JPanel vide = new JPanel();
		vide.setOpaque(false);
		vide.add(this.langues);
		this.add(vide);
		 */
		
		
		
		JPanel boxGrid = new JPanel();
		boxGrid.setLayout(new FlowLayout());
		boxGrid.add(langueLabel);
		boxGrid.add(this.option1);
	//	boxGrid.setBorder(BorderFactory.createTitledBorder("Nombre de joueurs"));
		
		
		
		JPanel panNombre = new JPanel();
		panNombre.setLayout(new BorderLayout());
		
		JPanel vide = new JPanel();
		vide.setPreferredSize(new Dimension(100,0));
		panNombre.add(vide,BorderLayout.EAST);		
		JPanel vide2 = new JPanel();
		vide2.setPreferredSize(new Dimension(100,0));
		panNombre.add(vide2,BorderLayout.WEST);
		panNombre.add(boxGrid,BorderLayout.CENTER);
		JPanel vide3 = new JPanel();
		vide3.setPreferredSize(new Dimension(0,20));
		panNombre.add(vide3,BorderLayout.NORTH);
		
		
		this.add(panNombre,BorderLayout.NORTH);
		
		
		
		
		
		centrer();
		

		
		
	}

}

package model;
import java.util.ArrayList;
import java.util.Calendar;

public class Horloge extends Thread implements Observable{
        //Objet calendrier pour r�cup�rer l'heure courante.
	private Calendar cal;
	private String hour = "";
	//Notre collection d'observateurs !
	private ArrayList<Observateur> listObservateur;
	
	public Horloge(){
		listObservateur = new ArrayList<Observateur>();
		Thread t = new Thread(this);
		t.start();
	}
	public void run() {
		while(true){
                                    
	        //On r�cup�re l'instance d'un calendrier � chaque tour 
	        //celui-ci va nous permettre de r�cup�rer l'heure actuelle
	        this.cal = Calendar.getInstance();
	        this.hour = 		        	
	        	/* Les heures */       	
	        	this.cal.get(Calendar.HOUR_OF_DAY) + " : " + 
			 	/* Les minutes */			
	        	(
				this.cal.get(Calendar.MINUTE) < 10
				? "0" + this.cal.get(Calendar.MINUTE)
				: this.cal.get(Calendar.MINUTE)
	        	)
	        	;
			//On avertit les observateurs que l'heure a �t� mise � jour !
			this.updateObservateur();
	        try {
	        	Thread.sleep(5000);
	        } catch (InterruptedException e) {
	        	// TODO Auto-generated catch block
	        	e.printStackTrace();
	        }
		}
	}
	public String getHeure(){
		return hour;
	}
	/**
	 * Ajoute un observateur � la liste
	 */
	@Override
	public void addObservateur(Observateur obs) {
		this.listObservateur.add(obs);
	}
	/**
	 * Retire tous les observateurs de la liste
	 */
	@Override
	public void delObservateur() {
		this.listObservateur = new ArrayList<Observateur>();
	}
	/**
	 * Avertit les observateurs que l'observable a chang� 
	 * et invoque la m�thode update de chaque observateur !
	 */
	@Override
	public void updateObservateur() {
		for(Observateur obs : this.listObservateur )
			obs.update(this.hour);
	}
}
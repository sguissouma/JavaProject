import controller.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main{ //peut-être extends Application, si on garde la version en commentaire...

	//	public static void main(String[] args) {
	//		launch();
	//		
	//	}
	//
	//	@Override
	//	public void start(Stage primaryStage) throws Exception {
	//		Controller.makeInstance();
	//		Controller.start(primaryStage);
	//	}
	//	
	//	public void stop() {
	//		System.exit(0);
	//	}

	private GestionnaireGraphique gestion;

	public static void main(String[] args) {


		/* Mise en place du gestionnaire graphique et lancement */
		GestionnaireGraphique gestion = new GestionnaireGraphique();
		gestion.run(); 
	}


}

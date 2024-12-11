package Controller;

import Model.Domain.Credentials;
import Model.Domain.Role;
import View.AdminView;
import View.AgenziaView;

public class ApplicationController implements Controller {
	

	    private Credentials credentials;

	    @Override
	    public void start() {
	        // 1. Acquisisco le credenziali tramite il LoginController
	        LoginController loginController = new LoginController();
	        loginController.start();  // Avvia la logica del login

	        // 2. Recupero le credenziali dal LoginController
	        credentials = loginController.getCredentials();

	        // 3. A seconda del ruolo, avvio la vista appropriata
	        if (credentials.getRole() == Role.AMMINISTRATORE) {  //se vedi nel DB role = 1, 1 sarebbe amministratore nelle enumerazioni
	            AdminView adminView = new AdminView();
	            adminView.showAdminDashboard(credentials);  // Avvia la vista Admin
	        } else if (credentials.getRole() == Role.AGENZIA) { //se vedi nel db, qui invece è 2 role.
	            AgenziaView agenziaView = new AgenziaView();
	            agenziaView.showAgenziaDashboard(credentials);  // Avvia la vista Agenzia
	        } else {
	            System.out.println("Invalid role or login failed.");
	        }
	    }
	}

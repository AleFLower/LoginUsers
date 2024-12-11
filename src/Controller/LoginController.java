package Controller;

import java.io.IOException;
import java.sql.SQLException;

import Exception.DaoException;
import Model.DAO.LoginDao;
import Model.Domain.Credentials;
import View.LoginView;


public class LoginController implements Controller {

    private Credentials credentials;  // Oggetto che contiene le credenziali dell'utente

    @Override
    public void start() {
        try {
            // 1. Acquisisco i dati di login dalla vista
            credentials = LoginView.authenticate();

            // 2. Creo un'istanza di LoginDAO e invoco il metodo execute per verificare le credenziali
            LoginDao loginDAO = new LoginDao();
            credentials = loginDAO.execute(credentials.getUsername(), credentials.getPassword());

            // 3. Passo le credenziali verificate alla vista per mostrare il messaggio
            LoginView view = new LoginView();
            view.showWelcomeMessage(credentials);  // Mostra il messaggio di benvenuto

        } catch (IOException | SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred during login.");
        }
    }

    public Credentials getCredentials() {
        return credentials;
    }
}

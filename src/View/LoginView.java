package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Model.Domain.Credentials;  //va importato in quanto è in un package differente credentials
import Model.Domain.Role;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginView {

    // Metodo che autentica l'utente
    public static Credentials authenticate() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter username: ");
        String user = reader.readLine();  // Acquisisco l'username
        System.out.print("Enter password: ");
        String pass = reader.readLine();  // Acquisisco la password

        return new Credentials(user, pass, null);  // Restituisco un oggetto Credentials con username e password
    }

    // Metodo che mostra il messaggio di benvenuto in base al ruolo dell'utente
    public void showWelcomeMessage(Credentials credentials) {
        if (credentials.getRole() != null) {
            System.out.println("Login successful! Welcome " + credentials.getUsername());

            // Mostro messaggi diversi in base al ruolo
            if (credentials.getRole() == Role.AMMINISTRATORE) {
                System.out.println("Hello Admin!");
            } else if (credentials.getRole() == Role.AGENZIA) {
                System.out.println("Hello Agenzia!");
            }
        } else {
            System.out.println("Invalid credentials.");
        }
    }
}



//NOTA: in realtà la view non dovrebbe comunicare direttamente con le entity, cioè tra controller e view 
//non si devono passare entity(model), ma dovrebbero esserci classi beans, poi vedremo come fare nella versione 2
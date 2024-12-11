package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static Connection connection;

    static {
        try {
            // Connessione al database con parametri espliciti
            String url = "jdbc:mysql://localhost:3306/company_db"; // Modifica con il tuo nome del database
            String user = "root"; // Modifica con il tuo username del database
            String password = "Fiorellino3"; // Modifica con la tua password del database

            // Crea la connessione con i parametri definiti
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}

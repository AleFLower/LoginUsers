package Model.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import Exception.DaoException;
import Model.Domain.Credentials;
import Model.Domain.Role;

import java.sql.*;


public class LoginDao implements GenericProcedure<Credentials> {

    @Override
    public Credentials execute(Object... params) throws SQLException {
        String username = (String) params[0];  // username passato come parametro
        String password = (String) params[1];  // password passata come parametro

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";  // Query di login
        Role role = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);  // Imposto l'username nel prepared statement
            stmt.setString(2, password);  // Imposto la password nel prepared statement

            ResultSet rs = stmt.executeQuery();  // Eseguo la query

            // Se l'utente esiste nel database, prendo il ruolo
            if (rs.next()) {
                int roleId = rs.getInt("role");  // Prendo l'ID del ruolo dal database
                role = Role.fromInt(roleId);  // Converto l'ID nel corrispondente enum Role
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Login failed");
        }

        // Ritorno l'oggetto Credentials con i dati di login
        return new Credentials(username, password, role);
    }
}


package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.Persona;

public class PersonaDAO {
    private static final String SQL_SELECT = "SELECT id, name, email FROM users";
    private static final String SQL_INSERT = "INSERT INTO users(name, email, password) VALUES(?, ?, 'daskdlaksd')";
    private static final String SQL_UPDATE = "UPDATE users SET name = ?, email = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM users WHERE id = ?";

    /**
     * It connects to the database, creates a prepared statement, executes the
     * query, and returns the
     * results
     * 
     * @return A list of personas.
     */
    public List<Persona> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            conn = Conexion.getConecction();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                persona = new Persona(id, name, email);
                personas.add(persona);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return personas;
    }

    /**
     * It takes a person object, connects to the database, prepares a statement,
     * sets the values of the
     * statement, executes the statement, and returns the number of rows affected
     * 
     * @param persona is the object that contains the data to be inserted into the
     *                database.
     * @return The number of rows affected by the query.
     */
    public int insertar(Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConecction();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getEmail());

            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return registros;
    }

    /**
     * It updates the database with the new values of the object
     * 
     * @param persona is the object that contains the data to be updated.
     * @return The number of rows affected by the update.
     */
    public int actualizar(Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConecction();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getEmail());
            stmt.setInt(3, persona.getIdPersona());

            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return registros;
    }

    /**
     * It deletes a person from the database
     * 
     * @param persona is the object that contains the data to be deleted.
     * @return The number of rows affected by the query.
     */
    public int eliminar(Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConecction();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPersona());

            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return registros;
    }
}

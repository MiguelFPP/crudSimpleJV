package test;

import java.sql.*;

public class TestMySqlJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/ecommerce?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "");

            Statement instruccion = conexion.createStatement();

            String sql = "select id,email, name from users";

            ResultSet resultado = instruccion.executeQuery(sql);

            while (resultado.next()) {
                System.out.print(resultado.getString("email"));
                System.out.print(" Nombre: " + resultado.getString("name"));
                System.out.print(" Id: " + resultado.getInt("id"));
                System.out.println("");
            }

            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
}

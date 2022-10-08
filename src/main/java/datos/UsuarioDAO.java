package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Usuario;

public class UsuarioDAO {
    private static final String SQL_INSERT="INSERT INTO usuario(usuario, password) VALUES(?,?)";
    private static final String SQL_SELECT="SELECT id, usuario, password FROM usuario WHERE usuario=? AND password=?";
    private static final String SQL_LIST="SELECT id, usuario, password FROM usuario";

    public int insertar(Usuario usuario){
        Connection conn=null;
        PreparedStatement stmt=null;
        int rows=0;
        try{
            conn=ConexionTestJV.getConecction();
            stmt=conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getPassword());
            rows=stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            ConexionTestJV.close(stmt);
            ConexionTestJV.close(conn);
        }
        return rows;
    }

    public Usuario seleccionar(Usuario usuario){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        Usuario usuarioObj=null;

        try {
            conn=ConexionTestJV.getConecction();
            stmt=conn.prepareStatement(SQL_SELECT);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getPassword());
            rs=stmt.executeQuery();
            while(rs.next()){
                String usuarioStr=rs.getString("usuario");
                String password=rs.getString("password");
                usuarioObj=new Usuario(usuarioStr, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            ConexionTestJV.close(rs);
            ConexionTestJV.close(stmt);
            ConexionTestJV.close(conn);
        }
        return usuarioObj;
    }

    public List<Usuario> listar(){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        Usuario usuario=null;
        List<Usuario> usuarios=new ArrayList<>();

        try {
            conn=ConexionTestJV.getConecction();
            stmt=conn.prepareStatement(SQL_LIST);
            rs=stmt.executeQuery();
            while(rs.next()){
                int idUsuario=rs.getInt("id");
                String usuarioStr=rs.getString("usuario");
                String password=rs.getString("password");
                usuario=new Usuario(idUsuario, usuarioStr, password);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            ConexionTestJV.close(rs);
            ConexionTestJV.close(stmt);
            ConexionTestJV.close(conn);
        }
        return usuarios;
    }
}

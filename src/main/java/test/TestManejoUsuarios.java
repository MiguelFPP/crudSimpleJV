package test;

import datos.UsuarioDAO;
import domain.Usuario;

public class TestManejoUsuarios {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO=new UsuarioDAO();

        //Insertar un nuevo usuario
        usuarioDAO.insertar(new Usuario("Juan", "123"));

        /* listar usuarios */
        for(Usuario usuario:usuarioDAO.listar()){
            System.out.println("usuario = " + usuario);
        }
    }
}

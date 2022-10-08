package test;

import datos.UsuarioDAO;
import domain.Usuario;

public class TestManejoUsuarios {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Insertar un nuevo usuario
        usuarioDAO.insertar(new Usuario("Juan", "123"));

        /* listar usuarios */
        for (Usuario usuario : usuarioDAO.listar()) {
            System.out.println("usuario = " + usuario);
        }

        /* seleccionar usuario */
        Usuario usuario = usuarioDAO.seleccionar(new Usuario("Juan", "123"));
        System.out.println("usuario = " + usuario);

        /* actualizar usuario */
        usuarioDAO.actualizar(new Usuario(1, "Juan", "123"));

        /* eliminar usuario */
        usuarioDAO.eliminar(new Usuario(1));
    }
}

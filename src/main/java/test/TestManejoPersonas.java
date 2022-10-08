package test;

import java.util.List;

import datos.PersonaDAO;
import domain.Persona;

public class TestManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();

        
        /* insertando un nuevo objeto de ripo persona */
        Persona personaNueva = new Persona("juan", "email@email.com");
        personaDao.insertar(personaNueva);

        /* modificando registro persona */
        Persona personaAct=new Persona(2, "juan2", "email2@email.com");
        personaDao.actualizar(personaAct);

        /* eliminar un registro */
        Persona personaDel=new Persona(2);
        personaDao.eliminar(personaDel);

        /* listando personas */
        List<Persona> personas = personaDao.seleccionar();

        for (Persona persona : personas) {
            System.out.println("persona = " + persona);
        }
        
    }
}

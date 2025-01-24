package hibernate1;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import models.Persona;

public class Funciones {
    static AccesoBD instancia;
    static Session sesion;
    public static void main(String[] args) throws Exception {
        //guardarPersona("El mejor", 3000);
        showPersonaID(1);
    }

    public static Persona guardarPersona(String nombre, int saldo) throws Exception{
        instancia = new AccesoBD();
        Persona persona = new Persona(nombre, saldo);
        instancia.abrir();
        instancia.guardar(persona);
        instancia.cerrar();
        return persona;
    }
    public static void showPersonaID(int id)throws Exception{
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        Persona persona = sesion.get(Persona.class, id);
        ImprimirRespuestas.showPersonaID(persona); //! ESTO EN LA INTERFAZ TAMBIEN
        instancia.cerrar();
    }
    public static void showPersonaNombre(String inputUsuario) throws Exception{
        instancia = new AccesoBD();
        instancia.abrir();
        List<Persona> personasPorNombre = new ArrayList<Persona>();
        sesion = instancia.get_sesion();
        personasPorNombre = sesion.createNativeQuery("SELECT idPersona, nombre, saldo FROM Personas WHERE nombre LIKE '%"+inputUsuario+"%';").getResultList();
        //for (Persona persona : personasPorNombre) {
         //   ImprimirRespuestas.imprimirListaPersonasPorNombre(persona); //! DEBERIA IR AL MAIN, PERO NO SE COMO SACARLO 
        //}
        System.out.println(personasPorNombre.get(0));

    }
    public void updatePersona() throws Exception{

    }

    public void dropPersona() throws Exception{

    }
    
}

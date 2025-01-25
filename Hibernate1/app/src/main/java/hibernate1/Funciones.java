package hibernate1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.Persona;

public class Funciones {
    static AccesoBD instancia;
    static Session sesion;

    public static Persona guardarPersona(String nombre, int saldo) throws Exception {
        instancia = new AccesoBD();
        Persona persona = new Persona(nombre, saldo);
        instancia.abrir();
        instancia.guardar(persona);
        instancia.cerrar();
        return persona;
    }

    public static void showPersonas() throws Exception {
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        List<Persona> personas = sesion.createNativeQuery("SELECT * from Personas",Persona.class).list();
        for (Persona persona : personas) {
            ImprimirRespuestas.imprimirListaPersonas(persona); // ! DEBERIA IR AL MAIN, PERO NO SE COMO SACARLO
        }
        instancia.cerrar();
    }

    public static void showPersonaID(int id) throws Exception {
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        Persona persona = sesion.get(Persona.class, id);
        ImprimirRespuestas.showPersonaID(persona); // ! ESTO EN LA INTERFAZ TAMBIEN
        instancia.cerrar();
    }

    public static void showPersonaNombre(String inputUsuario) throws Exception {
        instancia = new AccesoBD();
        instancia.abrir();
        List<Persona> personasPorNombre = new ArrayList<Persona>();
        sesion = instancia.get_sesion();
        personasPorNombre = sesion
                .createNativeQuery("SELECT idPersona, nombre, saldo FROM Personas WHERE nombre LIKE :inputUsuario",
                        Persona.class)
                .setParameter("inputUsuario", "%" + inputUsuario + "%").getResultList();
        for (Persona persona : personasPorNombre) {
            ImprimirRespuestas.imprimirListaPersonasPorNombre(persona); // ! DEBERIA IR AL MAIN, PERO NO SE COMO SACARLO
        }
    }

    public static void showPersonaSaldo(String operador, int saldo) throws Exception {
        instancia = new AccesoBD();
        instancia.abrir();
        List<Persona> personasPorNombre = new ArrayList<Persona>();
        sesion = instancia.get_sesion();
        personasPorNombre = sesion
                .createNativeQuery("SELECT idPersona, nombre, saldo FROM Personas WHERE saldo " + operador + " :saldo",
                        Persona.class)
                .setParameter("saldo", saldo).getResultList();
        for (Persona persona : personasPorNombre) { //
            ImprimirRespuestas.imprimirListaPersonasPorSaldo(persona); // ! DEBERIA IR AL MAIN, PERO NO SE COMO SACARLO
        }
        instancia.cerrar();

    }

    public static void updatePersona(int idPersona, String nombrePersona, int saldo) throws Exception {
        instancia = new AccesoBD();
        try {
            instancia.abrir();
            sesion = instancia.get_sesion();
            Persona persona = sesion.get(Persona.class, idPersona);
            persona.set_Nombre(nombrePersona);
            persona.set_Saldo(saldo);
            sesion.update(persona);
        } catch (Exception errorUpdatePersona) {
            System.err.println("No se pudo completar la actualización de la persona con ID:" + idPersona + ". "
                    + errorUpdatePersona.getMessage());
        }
        instancia.cerrar();
    }

    public static void deletePersona(int idPersona, String respuesta) throws Exception {
        instancia.abrir();
        sesion = instancia.get_sesion();    
        Persona persona = sesion.get(Persona.class, idPersona);
        if (respuesta.equals("Y")) {
            sesion.delete(persona);
            instancia.cerrar();   
        }else if(respuesta.equals("N")){
            System.out.println("Operación cancelada con éxito"); 
        }else{
            System.out.println("Ha ocurrido un error.");
        }
    }

}

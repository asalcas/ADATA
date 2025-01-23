package hibernate1;
import org.hibernate.Session;
import models.Persona;

public class Principal {
    private static AccesoBD instancia;
    private static Session sesion;
    public static void main(String[] args) throws Exception {
        instancia = new AccesoBD();

        //guardarPersona("El mejor", 3000);
        showPersonaID(1);
    }

    public static void guardarPersona(String nombre, int saldo) throws Exception{
        Persona persona = new Persona(nombre, saldo);
        instancia.abrir();
        instancia.guardar(persona);
        Imprimir.mensajeGuardarPersonas(persona); //! ESTO RETORNARLO EN LA CLASE INTERFAZ DE USUARIO y LLAMAR ALLI IMPRIMIR
        instancia.cerrar();

    // ABRIR() es esto de abajo
        //PersonasEntity persona = new PersonasEntity("Pocholo", "H");
        //Session session = sessionFactory.openSession();
        //Transaction transaction = session.beginTransaction();

    // GUARDAR()
        //int id = (int) session.save(persona);

    // CERRAR()
        //transaction.commit();
        //System.out.println(id);
        //sessionFactory.close();

    }
    public static void showPersonaID(int id)throws Exception{
        instancia.abrir();
        sesion = instancia.get_sesion();
        Persona persona = sesion.get(Persona.class, id);
        Imprimir.showPersonaID(persona);
        instancia.cerrar();
    }
    public static void showPersonaNombre(String nombre) throws Exception{
        instancia.abrir();
        sesion = instancia.get_sesion();
        sesion.createNativeQuery(""); //TODO
    }
    public void updatePersona() throws Exception{

    }

    public void dropPersona() throws Exception{

    }
    
}

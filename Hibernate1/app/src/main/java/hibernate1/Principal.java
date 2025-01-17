package hibernate1;
import org.hibernate.Session;

import models.Persona;

public class Principal {
    private static AccesoBD instancia;
    private static Session sesion;
    public static void main(String[] args) throws Exception {
        instancia = new AccesoBD();

        guardarPersona("alvaro", 100);

    }

    public static void guardarPersona(String nombre, int saldo) throws Exception{
        Persona persona = new Persona(nombre, saldo);
        instancia.abrir();
        instancia.guardar(persona);
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
    public void showPersona(int id)throws Exception{
        instancia.abrir();
        sesion = instancia.get_sesion();
        Persona persona = sesion.get(Persona.class, id);
        System.out.println(persona);
        instancia.cerrar();

    // ABRIR()
        //setUp();
        //sesion=sf.openSession();
        //Transaction transaction=session.beginTransaction();

    // Nuestro GET()/LOAD()
        //PersonasEntity persona = session.load(PersonasEntity.class, id);
        //PersonasEntity persona = session.get(PersonasEntity.class, id); // Esta línea también funcionaría como la anterior

    // CERRAR()
        //System.out.println(persona.getNombre());
        //transaction.commit();
        //instancia.cerrar();
    }
    public void updatePersona() throws Exception{

    }

    public void dropPersona() throws Exception{

    }
}

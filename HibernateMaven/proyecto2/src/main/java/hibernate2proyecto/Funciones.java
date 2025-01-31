package hibernate2proyecto;
import java.util.List;

import org.hibernate.Session;

import Models.Usuarios;


public class Funciones {
    static AccesoBD instancia;
    static Session sesion;

    public static List<Usuarios> obtenerTodosLosUsuarios() throws Exception{
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        List<Usuarios> listaUsuarios = sesion.createNativeQuery("SELECT * from Usuarios", Usuarios.class).list();
        instancia.cerrar();
        return listaUsuarios;
    }
}

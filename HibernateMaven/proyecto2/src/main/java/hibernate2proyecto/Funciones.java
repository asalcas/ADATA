package hibernate2proyecto;

import java.util.List;

import org.hibernate.Session;

import Models.Usuarios;

public class Funciones {
    static AccesoBD instancia;
    static Session sesion;

    public static Usuarios guardarPersona(String Nombre, String Apellidos, String Username, String Password, String Email) throws Exception {
        instancia = new AccesoBD();
        Usuarios usuarioGuardar = new Usuarios(Nombre, Apellidos, Username, Password, Email);
        instancia.abrir();
        instancia.guardar(usuarioGuardar);
        instancia.cerrar();
        return usuarioGuardar;
    }


    public static List<Usuarios> obtenerTodosLosUsuarios() throws Exception {
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        List<Usuarios> listaUsuarios = sesion.createNativeQuery("SELECT * from Usuarios", Usuarios.class).list();
        instancia.cerrar();
        return listaUsuarios;
    }

    public static Usuarios obtenerUsuarioPorID(int idUsuario) throws Exception {
        Usuarios usuarioObtenido;
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        usuarioObtenido = sesion.get(Usuarios.class, idUsuario);
        return usuarioObtenido;
    }

    public static List<Usuarios> obtenerUsuariosPor(String inputUsuario, String tabla) throws Exception {
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        List<Usuarios> UsuariosPorParametro = sesion
                .createNativeQuery("SELECT idUsuarios, Nombre, Apellidos, Username, Email FROM "+tabla+" WHERE Nombre LIKE :inputUsuario",
                        Usuarios.class)
                .setParameter("inputUsuario", "%" + inputUsuario + "%").getResultList();
        return UsuariosPorParametro;
    }
    
}


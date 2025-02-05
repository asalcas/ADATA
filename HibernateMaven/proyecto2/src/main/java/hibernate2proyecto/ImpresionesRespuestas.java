package hibernate2proyecto;

import java.util.List;

import Models.Usuarios;

public class ImpresionesRespuestas {

    public static void usuarioGuardado(Usuarios usuario) {

        System.out.println("---------------------------------------------");
        System.out.println("-  ¡Resultados del nuevo Usuario guardado!  -");
        System.out.println("---------------------------------------------");
        System.out.println("ID: " + usuario.getIdUsuario());
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Apellidos: " + usuario.getApellidos());
        System.out.println("Username: " + usuario.getUsername());
        System.out.println("Password: " + usuario.getPassword().hashCode());
        System.out.println("Email: " + usuario.getEmail());

    }

    public static void respuestaShowTODOPersonas(List<Usuarios> listaUsuarios) {

        System.out.println("------------------------------------------");
        System.out.println("-  Resultados de toda la tabla Usuarios  -");
        System.out.println("------------------------------------------");
        for (Usuarios usuario : listaUsuarios) {
            System.out.println("ID: " + usuario.getIdUsuario());
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Apellidos: " + usuario.getApellidos());
            System.out.println("Username: " + usuario.getUsername());
            System.out.println("Password: " + usuario.getPassword().hashCode());
            System.out.println("Email: " + usuario.getEmail());
        }
    }

    public static void respuestaShowUsuarioPorID(Usuarios usuario) {
        System.out.println("---------------------------------------------------");
        System.out.println("-  Resultados del Usuario con el ID seleccionado  -");
        System.out.println("---------------------------------------------------");
        System.out.println("ID: " + usuario.getIdUsuario());
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Apellidos: " + usuario.getApellidos());
        System.out.println("Username: " + usuario.getUsername());
        System.out.println("Password: " + usuario.getPassword().hashCode());
        System.out.println("Email: " + usuario.getEmail());
    }

    public static void respuestaShowUsuarioPorParametro(List<Usuarios> listaUsuarios, String tabla) {

        System.out.println("----------------------------------------");
        System.out.println(String.format("-  Resultados del Usuario por: %s  -", tabla));
        System.out.println("----------------------------------------");
        for (Usuarios usuario : listaUsuarios) {
            System.out.println("ID: " + usuario.getIdUsuario());
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Apellidos: " + usuario.getApellidos());
            System.out.println("Username: " + usuario.getUsername());
            System.out.println("Password: " + usuario.getPassword().hashCode());
            System.out.println("Email: " + usuario.getEmail());
        }
    }

}

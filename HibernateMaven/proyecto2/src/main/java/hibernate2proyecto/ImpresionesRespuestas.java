package hibernate2proyecto;

import java.util.List;

import Models.Post;
import Models.Usuarios;

public class ImpresionesRespuestas {
//#region USUARIOS
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

    public static void respuestaShowUsuarioPorParametro(List<Usuarios> listaUsuarios, String columna) {
        switch (columna) {
            case "Apellidos":
                System.out.println("-------------------------------------------");
                System.out.println(String.format("-  Resultados del Usuario por: %s  -", columna));
                System.out.println("-------------------------------------------");
                break;
            case "Username":
                System.out.println("------------------------------------------");
                System.out.println(String.format("-  Resultados del Usuario por: %s  -", columna));
                System.out.println("------------------------------------------");
                break;
            default:
                System.out.println("----------------------------------------");
                System.out.println(String.format("-  Resultados del Usuario por: %s  -", columna));
                System.out.println("----------------------------------------");
                break;
        }
        for (Usuarios usuario : listaUsuarios) {
            System.out.println("ID: " + usuario.getIdUsuario());
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Apellidos: " + usuario.getApellidos());
            System.out.println("Username: " + usuario.getUsername());
            System.out.println("Password: " + usuario.getPassword().hashCode());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println();
        }

        
    }
    //#endregion
    //#region POST
    public static void PostGuardado(Post post) {

        System.out.println("------------------------------------------");
        System.out.println("-  ¡Resultados del nuevo Post guardado!  -");
        System.out.println("------------------------------------------");
        System.out.println("ID del Post: " + post.getIdPost());
        System.out.println("ID del Usuario: " + post.getUsuario().getIdUsuario());
        System.out.println("Fecha de creación del Post: " + post.getCreated_at());
        System.out.println("Fecha de actualización del post: " + post.getUpdated_at());
    }





    
    //#endregion
}

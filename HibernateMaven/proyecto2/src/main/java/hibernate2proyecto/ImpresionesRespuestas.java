package hibernate2proyecto;

import java.util.List;

import Models.Likes;
import Models.Post;
import Models.Usuarios;

public class ImpresionesRespuestas {
    // #region USUARIOS
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

    public static void respuestaShowTODOUsuarios(List<Usuarios> listaUsuarios) {

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
            System.out.println();
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
        System.out.println();
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

    // #endregion
    // #region POST
    public static void PostGuardado(Post post) {

        System.out.println("------------------------------------------");
        System.out.println("-  ¡Resultados del nuevo Post guardado!  -");
        System.out.println("------------------------------------------");
        System.out.println("ID del Post: " + post.getIdPost());
        System.out.println("ID del Usuario: " + post.getUsuario().getIdUsuario());
        System.out.println("Fecha de creación del Post: " + post.getCreated_at());
        System.out.println("Fecha de actualización del post: " + post.getUpdated_at());
    }

    public static void respuestaShowTODOPost(List<Post> listaPost) {

        System.out.println("----------------------------------------");
        System.out.println("-  ¡Resultados de toda la tabla Post!  -");
        System.out.println("----------------------------------------");
        for (Post post : listaPost) {
            System.out.println("ID del Post: " + post.getIdPost());
            System.out.println("ID del Usuario: " + post.getUsuario().getIdUsuario());
            System.out.println("Fecha de creación del Post: " + post.getCreated_at());
            System.out.println("Fecha de actualización del post: " + post.getUpdated_at());
            System.out.println();
        }

    }

    public static void respuestaShowPostPorIDPost(List<Post> listaPost) {

        System.out.println("--------------------------------------------------------------");
        System.out.println("-  ¡Resultados del filtro en la tabla Post por ID de Post !  -");
        System.out.println("--------------------------------------------------------------");
        for (Post post : listaPost) {
            System.out.println("ID del Post: " + post.getIdPost());
            System.out.println("ID del Usuario: " + post.getUsuario().getIdUsuario());
            System.out.println("Fecha de creación del Post: " + post.getCreated_at());
            System.out.println("Fecha de actualización del post: " + post.getUpdated_at());
            System.out.println();
        }

    }

    public static void respuestaShowPostPorIDUsuario(List<Post> listaPost) {

        System.out.println("--------------------------------------------------------------");
        System.out.println("-  ¡Resultados del filtro en la tabla Post por ID de Usuario !  -");
        System.out.println("--------------------------------------------------------------");
        for (Post post : listaPost) {
            System.out.println("ID del Post: " + post.getIdPost());
            System.out.println("ID del Usuario: " + post.getUsuario().getIdUsuario());
            System.out.println("Fecha de creación del Post: " + post.getCreated_at());
            System.out.println("Fecha de actualización del post: " + post.getUpdated_at());
            System.out.println();
        }

    }

    public static void respuestaShowPostPorDate(List<Post> listaPost, int respuestaSubMenuPost) {
        String campo = "";
        if (respuestaSubMenuPost == 4){
            campo = "Created_at ";
        }else if(respuestaSubMenuPost == 5){
            campo = "Updated_at ";
        }
        System.out.println("---------------------------------------------------------------");
        System.out.println("-  ¡Resultados del filtro en la tabla Post por  " + campo + "!  -");
        System.out.println("---------------------------------------------------------------");
        if(listaPost.isEmpty()){
            
            System.out.println("\nNo hay ningún Post para estos parametros!\n");
        }
        for (Post post : listaPost) {
            System.out.println("ID del Post: " + post.getIdPost());
            System.out.println("ID del Usuario: " + post.getUsuario().getIdUsuario());
            System.out.println("Fecha de creación del Post: " + post.getCreated_at());
            System.out.println("Fecha de actualización del post: " + post.getUpdated_at());
            System.out.println();
        }

    }

    // #endregion
    // #region Likes

    public static void LikeGuardado(Likes like) {
        System.out.println("------------------------------------------");
        System.out.println("-  ¡Resultados del nuevo Like guardado!  -");
        System.out.println("------------------------------------------");
        System.out.println("ID del Like: " + like.getIdLike());
        System.out.println("ID del Usuario que dio el Like: " + like.getUsuario().getIdUsuario());
        System.out.println("ID del Post que tiene el Like: " + like.getPost().getIdPost());

    }

    public static void respuestaShowTODOLikes(List<Likes> listaLikes) {

        System.out.println("-----------------------------------------");
        System.out.println("-  ¡Resultados de toda la tabla Likes!  -");
        System.out.println("-----------------------------------------");
        if (listaLikes.isEmpty()){
            System.out.println("\nLa lista de Likes está vacía!\n");
        }
        for (Likes like : listaLikes) {
            System.out.println("ID del Like: " + like.getIdLike());
            System.out.println("ID del Usuario: " + like.getUsuario().getIdUsuario());
            System.out.println("ID del Post: " + like.getPost().getIdPost());
            System.out.println();
        }

    }
    public static void respuestaShowLikesPor(List<Likes> listaLikes, int respuestaMenuLikes) {
        String campo = "";
        switch (respuestaMenuLikes) {
            case 2:
                campo = "IdLikes ";
                break;
            case 3:
                campo = "IdUsuarios ";
                break;
            case 4:
                campo = "IdPost";
                break;
            default:
                break;
        }
        System.out.println("----------------------------------------------------------------");
        System.out.println("-  ¡Resultados del filtro en la tabla Likes por  " + campo + "!  -");
        System.out.println("----------------------------------------------------------------");
        if(listaLikes.isEmpty()){
            
            System.out.println("\nNo hay ningún Like para estos parametros!\n");
        }
        for (Likes like : listaLikes) {
            System.out.println("ID del Like: " + like.getIdLike());
            System.out.println("ID del Usuario: " + like.getUsuario().getIdUsuario());
            System.out.println("ID del Post: " + like.getPost().getIdPost());
            System.out.println();
        }
    }
    // #endregion
}

package hibernate2proyecto;

import java.util.List;

import Models.Likes;
import Models.Post;
import Models.Usuarios;

public class ImpresionesRespuestas {
    // #region USUARIOS
    public static void usuarioGuardado(Usuarios usuario) {
        System.out.println();
        System.out.println(
                Colores.ANSI_GREEN_BACKGROUND + "   ¡Resultados del nuevo Usuario guardado!   " + Colores.ANSI_RESET);
        System.out.println(Colores.ANSI_GREEN + "ID: " + Colores.ANSI_RESET + usuario.getIdUsuario());
        System.out.println(Colores.ANSI_GREEN + "Nombre: " + Colores.ANSI_RESET + usuario.getNombre());
        System.out.println(Colores.ANSI_GREEN + "Apellidos: " + Colores.ANSI_RESET + usuario.getApellidos());
        System.out.println(Colores.ANSI_GREEN + "Username: " + Colores.ANSI_RESET + usuario.getUsername());
        System.out.println(Colores.ANSI_GREEN + "Password: " + Colores.ANSI_RESET + usuario.getPassword().hashCode());
        System.out.println(Colores.ANSI_GREEN + "Email: " + Colores.ANSI_RESET + usuario.getEmail());
        System.out.println();
    }

    public static void usuarioActualizado(Usuarios usuario) {
        System.out.println();
        System.out.println(Colores.ANSI_GREEN_BACKGROUND + "   ¡Resultados de la actualización del Usuario!   "
                + Colores.ANSI_RESET);
        System.out.println(Colores.ANSI_GREEN + "ID: " + Colores.ANSI_RESET + usuario.getIdUsuario());
        System.out.println(Colores.ANSI_GREEN + "Nombre: " + Colores.ANSI_RESET + usuario.getNombre());
        System.out.println(Colores.ANSI_GREEN + "Apellidos: " + Colores.ANSI_RESET + usuario.getApellidos());
        System.out.println(Colores.ANSI_GREEN + "Username: " + Colores.ANSI_RESET + usuario.getUsername());
        System.out.println(Colores.ANSI_GREEN + "Password: " + Colores.ANSI_RESET + usuario.getPassword().hashCode());
        System.out.println(Colores.ANSI_GREEN + "Email: " + Colores.ANSI_RESET + usuario.getEmail());
        System.out.println();
    }

    public static void respuestaShowTODOUsuarios(List<Usuarios> listaUsuarios) {
        System.out.println();
        System.out.println();
        System.out.println(
                Colores.ANSI_GREEN_BACKGROUND + "   Resultados de toda la tabla Usuarios   " + Colores.ANSI_RESET);
        if (listaUsuarios.isEmpty()) {
            System.out.println(Colores.ANSI_RED + "\n No hay Usuarios en la BD!\n" + Colores.ANSI_RESET);
        } else {
            for (Usuarios usuario : listaUsuarios) {
                System.out.println(Colores.ANSI_GREEN + "ID: " + Colores.ANSI_RESET + usuario.getIdUsuario());
                System.out.println(Colores.ANSI_GREEN + "Nombre: " + Colores.ANSI_RESET + usuario.getNombre());
                System.out.println(Colores.ANSI_GREEN + "Apellidos: " + Colores.ANSI_RESET + usuario.getApellidos());
                System.out.println(Colores.ANSI_GREEN + "Username: " + Colores.ANSI_RESET + usuario.getUsername());
                System.out.println(
                        Colores.ANSI_GREEN + "Password: " + Colores.ANSI_RESET + usuario.getPassword().hashCode());
                System.out.println(Colores.ANSI_GREEN + "Email: " + Colores.ANSI_RESET + usuario.getEmail());
                System.out.println();
            }
        }

    }

    public static void respuestaShowUsuarioPorID(Usuarios usuario) {
        System.out.println();
        System.out.println();
        System.out.println(Colores.ANSI_GREEN_BACKGROUND + "   Resultados del Usuario con el ID seleccionado   "
                + Colores.ANSI_RESET);
        System.out.println(Colores.ANSI_GREEN + "ID: " + Colores.ANSI_RESET + usuario.getIdUsuario());
        System.out.println(Colores.ANSI_GREEN + "Nombre: " + Colores.ANSI_RESET + usuario.getNombre());
        System.out.println(Colores.ANSI_GREEN + "Apellidos: " + Colores.ANSI_RESET + usuario.getApellidos());
        System.out.println(Colores.ANSI_GREEN + "Username: " + Colores.ANSI_RESET + usuario.getUsername());
        System.out.println(Colores.ANSI_GREEN + "Password: " + Colores.ANSI_RESET + usuario.getPassword().hashCode());
        System.out.println(Colores.ANSI_GREEN + "Email: " + Colores.ANSI_RESET + usuario.getEmail());
        System.out.println();
    }

    public static void respuestaShowUsuarioPorParametro(List<Usuarios> listaUsuarios, String columna) {
        switch (columna) {
            case "Apellidos" -> {
                System.out.println();
                System.out.println(String.format(
                        Colores.ANSI_GREEN_BACKGROUND + "   Resultados del Usuario por: %s   " + Colores.ANSI_RESET,
                        columna));
                System.out.println();
            }
            case "Username" -> {
                System.out.println();
                System.out.println(String.format(
                        Colores.ANSI_GREEN_BACKGROUND + "   Resultados del Usuario por: %s   " + Colores.ANSI_RESET,
                        columna));
                System.out.println();
            }
            default -> {
                System.out.println();
                System.out.println(String.format(
                        Colores.ANSI_GREEN_BACKGROUND + "   Resultados del Usuario por: %s   " + Colores.ANSI_RESET,
                        columna));
                System.out.println();
            }
        }
        if (listaUsuarios.isEmpty()) {
            System.out.println(Colores.ANSI_RED + "\nLa lista de Usuarios esta vacía!\n" + Colores.ANSI_RESET);
        } else {
            for (Usuarios usuario : listaUsuarios) {
                System.out.println(Colores.ANSI_GREEN + "ID: " + Colores.ANSI_RESET + usuario.getIdUsuario());
                System.out.println(Colores.ANSI_GREEN + "Nombre: " + Colores.ANSI_RESET + usuario.getNombre());
                System.out.println(Colores.ANSI_GREEN + "Apellidos: " + Colores.ANSI_RESET + usuario.getApellidos());
                System.out.println(Colores.ANSI_GREEN + "Username: " + Colores.ANSI_RESET + usuario.getUsername());
                System.out.println(
                        Colores.ANSI_GREEN + "Password: " + Colores.ANSI_RESET + usuario.getPassword().hashCode());
                System.out.println(Colores.ANSI_GREEN + "Email: " + Colores.ANSI_RESET + usuario.getEmail());
                System.out.println();
            }
        }
    }

    // #endregion
    // #region POST
    public static void postGuardado(Post post) {
        System.out.println();
        System.out.println(
                Colores.ANSI_GREEN_BACKGROUND + "   ¡Resultados del nuevo Post guardado!   " + Colores.ANSI_RESET);
        System.out.println(Colores.ANSI_GREEN + "ID del Post: " + Colores.ANSI_RESET + post.getIdPost());
        System.out.println(
                Colores.ANSI_GREEN + "ID del Usuario: " + Colores.ANSI_RESET + post.getUsuario().getIdUsuario());
        System.out.println(
                Colores.ANSI_GREEN + "Fecha de creación del Post: " + Colores.ANSI_RESET + post.getCreated_at());
        System.out.println(
                Colores.ANSI_GREEN + "Fecha de actualización del post: " + Colores.ANSI_RESET + post.getUpdated_at());
        System.out.println();
    }

    public static void postActualizado(Post post) {
        System.out.println();
        System.out
                .println(
                        Colores.ANSI_GREEN_BACKGROUND + "   ¡Resultados del Post actualizado!   " + Colores.ANSI_RESET);
        System.out.println(Colores.ANSI_GREEN + "ID del Post: " + Colores.ANSI_RESET + post.getIdPost());
        System.out.println(
                Colores.ANSI_GREEN + "ID del Usuario: " + Colores.ANSI_RESET + post.getUsuario().getIdUsuario());
        System.out.println(
                Colores.ANSI_GREEN + "Fecha de creación del Post: " + Colores.ANSI_RESET + post.getCreated_at());
        System.out.println(
                Colores.ANSI_GREEN + "Fecha de actualización del post: " + Colores.ANSI_RESET + post.getUpdated_at());
        System.out.println();
    }

    public static void respuestaShowTODOPost(List<Post> listaPost) {
        System.out.println();
        System.out.println(
                Colores.ANSI_GREEN_BACKGROUND + "   ¡Resultados de toda la tabla Post!   " + Colores.ANSI_RESET);
        if (listaPost.isEmpty()) {
            System.out.println(Colores.ANSI_RED + "\nLa lista de Post esta vacía!\n" + Colores.ANSI_RESET);
        } else {
            for (Post post : listaPost) {
                System.out.println(Colores.ANSI_GREEN + "ID del Post: " + Colores.ANSI_RESET + post.getIdPost());
                System.out.println(Colores.ANSI_GREEN + "ID del Usuario: " + Colores.ANSI_RESET
                        + post.getUsuario().getIdUsuario());
                System.out.println(Colores.ANSI_GREEN + "Fecha de creación del Post: " + Colores.ANSI_RESET
                        + post.getCreated_at());
                System.out.println(Colores.ANSI_GREEN + "Fecha de actualización del post: " + Colores.ANSI_RESET
                        + post.getUpdated_at());
                System.out.println();
            }
        }

    }

    public static void respuestaShowPostPorIDPost(List<Post> listaPost) {
        System.out.println();
        System.out.println(Colores.ANSI_GREEN_BACKGROUND
                + "   ¡Resultados del filtro en la tabla Post por ID de Post !   " + Colores.ANSI_RESET);
        if (listaPost.isEmpty()) {
            System.out.println(Colores.ANSI_RED + "\nLa lista de Post esta vacía!\n" + Colores.ANSI_RESET);
        } else {
            for (Post post : listaPost) {
                System.out.println(Colores.ANSI_GREEN + "ID del Post: " + Colores.ANSI_RESET + post.getIdPost());
                System.out.println(Colores.ANSI_GREEN + "ID del Usuario: " + Colores.ANSI_RESET
                        + post.getUsuario().getIdUsuario());
                System.out.println(Colores.ANSI_GREEN + "Fecha de creación del Post: " + Colores.ANSI_RESET
                        + post.getCreated_at());
                System.out.println(Colores.ANSI_GREEN + "Fecha de actualización del post: " + Colores.ANSI_RESET
                        + post.getUpdated_at());
                System.out.println();
            }
        }
    }

    public static void respuestaShowPostPorIDUsuario(List<Post> listaPost) {
        System.out.println();
        System.out.println(Colores.ANSI_GREEN_BACKGROUND
                + "   ¡Resultados del filtro en la tabla Post por ID de Usuario !   " + Colores.ANSI_RESET);
        if (listaPost.isEmpty()) {
            System.out.println(Colores.ANSI_RED + "\nLa lista de Post esta vacía!\n" + Colores.ANSI_RESET);
        } else {
            for (Post post : listaPost) {
                System.out.println(Colores.ANSI_GREEN + "ID del Post: " + Colores.ANSI_RESET + post.getIdPost());
                System.out.println(Colores.ANSI_GREEN + "ID del Usuario: " + Colores.ANSI_RESET
                        + post.getUsuario().getIdUsuario());
                System.out.println(Colores.ANSI_GREEN + "Fecha de creación del Post: " + Colores.ANSI_RESET
                        + post.getCreated_at());
                System.out.println(Colores.ANSI_GREEN + "Fecha de actualización del post: " + Colores.ANSI_RESET
                        + post.getUpdated_at());
                System.out.println();
            }
        }
    }

    public static void respuestaShowPostPorDate(List<Post> listaPost, int respuestaSubMenuPost) {
        String campo = "";
        if (respuestaSubMenuPost == 4) {
            campo = "Created_at ";
        } else if (respuestaSubMenuPost == 5) {
            campo = "Updated_at ";
        }
        System.out.println();
        System.out.println(Colores.ANSI_GREEN_BACKGROUND + "   ¡Resultados del filtro en la tabla Post por  " + campo
                + "!   " + Colores.ANSI_RESET);
        if (listaPost.isEmpty()) {

            System.out.println(Colores.ANSI_RED + "\nNo hay ningún Post para estos parametros!\n" + Colores.ANSI_RESET);
        }
        for (Post post : listaPost) {
            System.out.println(Colores.ANSI_GREEN + "ID del Post: " + Colores.ANSI_RESET + post.getIdPost());
            System.out.println(
                    Colores.ANSI_GREEN + "ID del Usuario: " + Colores.ANSI_RESET + post.getUsuario().getIdUsuario());
            System.out.println(
                    Colores.ANSI_GREEN + "Fecha de creación del Post: " + Colores.ANSI_RESET + post.getCreated_at());
            System.out.println(Colores.ANSI_GREEN + "Fecha de actualización del post: " + Colores.ANSI_RESET
                    + post.getUpdated_at());
            System.out.println();
        }

    }

    // #endregion
    // #region Likes

    public static void likeGuardado(Likes like) {
        System.out.println();
        System.out.println(
                Colores.ANSI_GREEN_BACKGROUND + "   ¡Resultados del nuevo Like guardado!   " + Colores.ANSI_RESET);
        System.out.println(Colores.ANSI_GREEN + "ID del Like: " + like.getIdLike());
        System.out.println(Colores.ANSI_GREEN + "ID del Usuario que dio el Like: " + Colores.ANSI_RESET
                + like.getUsuario().getIdUsuario());
        System.out.println(Colores.ANSI_GREEN + "ID del Post que tiene el Like: " + Colores.ANSI_RESET
                + like.getPost().getIdPost());
        System.out.println();
    }

    public static void likeActualizado(Likes like) {
        System.out.println();
        System.out
                .println(
                        Colores.ANSI_GREEN_BACKGROUND + "   ¡Resultados del Like actualizado!   " + Colores.ANSI_RESET);
        System.out.println(Colores.ANSI_GREEN + "ID del Like: " + like.getIdLike());
        System.out.println(Colores.ANSI_GREEN + "ID del Usuario que dio el Like: " + Colores.ANSI_RESET
                + like.getUsuario().getIdUsuario());
        System.out.println(Colores.ANSI_GREEN + "ID del Post que tiene el Like: " + Colores.ANSI_RESET
                + like.getPost().getIdPost());
        System.out.println();
    }

    public static void respuestaShowTODOLikes(List<Likes> listaLikes) {
        System.out.println();
        System.out.println(
                Colores.ANSI_GREEN_BACKGROUND + "   ¡Resultados de toda la tabla Likes!   " + Colores.ANSI_RESET);
        if (listaLikes.isEmpty()) {
            System.out.println(Colores.ANSI_RED + "\nLa lista de Likes está vacía!\n" + Colores.ANSI_RESET);
        } else {
            for (Likes like : listaLikes) {
                System.out.println(Colores.ANSI_GREEN + "ID del Like: " + Colores.ANSI_RESET + like.getIdLike());
                System.out.println(Colores.ANSI_GREEN + "ID del Usuario: " + Colores.ANSI_RESET
                        + like.getUsuario().getIdUsuario());
                System.out.println(
                        Colores.ANSI_GREEN + "ID del Post: " + Colores.ANSI_RESET + like.getPost().getIdPost());
                System.out.println();
            }
        }

    }

    public static void respuestaShowLikesPor(List<Likes> listaLikes, int respuestaMenuLikes) {
        String campo = "";
        switch (respuestaMenuLikes) {
            case 2 -> campo = "IdLikes ";
            case 3 -> campo = "IdUsuarios ";
            case 4 -> campo = "IdPost";
            default -> {
            }
        }
        System.out.println();
        System.out.println(Colores.ANSI_GREEN_BACKGROUND + "   ¡Resultados del filtro en la tabla Likes por  " + campo
                + "!   " + Colores.ANSI_RESET);
        if (listaLikes.isEmpty()) {

            System.out.println(Colores.ANSI_RED + "\nNo hay ningún Like para estos parametros!\n" + Colores.ANSI_RESET);
        } else {
            for (Likes like : listaLikes) {
                System.out.println(Colores.ANSI_GREEN + "ID del Like: " + Colores.ANSI_RESET + like.getIdLike());
                System.out.println(Colores.ANSI_GREEN + "ID del Usuario: " + Colores.ANSI_RESET
                        + like.getUsuario().getIdUsuario());
                System.out.println(
                        Colores.ANSI_GREEN + "ID del Post: " + Colores.ANSI_RESET + like.getPost().getIdPost());
                System.out.println();
            }
        }

    }
    // #endregion
}

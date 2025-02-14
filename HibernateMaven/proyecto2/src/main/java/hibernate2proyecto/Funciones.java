package hibernate2proyecto;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import Models.Likes;
import Models.Post;
import Models.Usuarios;

public class Funciones {
    static AccesoBD instancia;
    static Session sesion;

    // #region USUARIOS
    public static Usuarios guardarUsuarios(String Nombre, String Apellidos, String Username, String Password,
            String Email) throws Exception {
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

    public static List<Usuarios> obtenerUsuariosPor(String inputUsuario, String columna) throws Exception {
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        List<Usuarios> UsuariosPorParametro = sesion
                .createNativeQuery(
                        "SELECT idUsuarios, Nombre, Apellidos, Username, Email, Password FROM Usuarios WHERE " + columna
                                + " LIKE :inputUsuario",
                        Usuarios.class)
                .setParameter("inputUsuario", "%" + inputUsuario + "%").getResultList();
        return UsuariosPorParametro;
    }

    // #endregion
    // #region POST
    // ! CUANDO MODIFIQUE EL POST, QUE LA FECHA DEL UPDATED PASE DE NULL A LA DEL
    // EQUIPO

    public static Post guardarPost(Usuarios usuario, LocalDate create_at)
            throws Exception {
        instancia = new AccesoBD();
        Post postGuardar = new Post(usuario, create_at, null);
        instancia.abrir();
        instancia.guardar(postGuardar);
        instancia.cerrar();
        return postGuardar;

    }

    public static List<Post> obtenerTodosLosPost() throws Exception {
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        List<Post> listaPost = sesion.createNativeQuery("SELECT * from Posts", Post.class).list();
        instancia.cerrar();
        return listaPost;
    }

    public static Post obtenerPostPorID(int idPost) throws Exception {
        Post postObtenido;
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        postObtenido = sesion.get(Post.class, idPost);
        return postObtenido;
    }

    public static List<Post> obtenerPostPor(int ID, String operador, int respuestaSubMenuPost) throws Exception {
        String columna = "";
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        if (respuestaSubMenuPost == 2) {
            columna = "IdPost ";
        } else if (respuestaSubMenuPost == 3) {
            columna = "IdUsuarios ";
        }
        List<Post> UsuariosPorParametro = sesion
                .createNativeQuery(
                        "SELECT IdPost, IdUsuarios, Created_at, Updated_at FROM Posts WHERE " + columna + operador
                                + " :ID",
                        Post.class)
                .setParameter("ID", ID).getResultList();
        return UsuariosPorParametro;
    }

    public static List<Post> obtenerPostPorDATE(String fecha, String operador, int respuestaSubMenuPost)
            throws Exception {
        String columna = "";
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        if (respuestaSubMenuPost == 4) {
            columna = "Created_at ";
        } else if (respuestaSubMenuPost == 5) {
            columna = "Updated_at ";
        }
        List<Post> UsuariosPorParametro = sesion
                .createNativeQuery(
                        "SELECT IdPost, IdUsuarios, Created_at, Updated_at FROM Posts WHERE " + columna + operador
                                + " :date",
                        Post.class)
                .setParameter("date", fecha).getResultList();
        return UsuariosPorParametro;
    }
    // #endregion

    // #region Likes

    public static Likes guardarLikes(Usuarios usuario, Post post) throws Exception {

        instancia = new AccesoBD();
        Likes nuevoLike = new Likes(usuario, post);
        instancia.abrir();
        instancia.guardar(nuevoLike);
        instancia.cerrar();
        return nuevoLike;

    }

    public static List<Likes> obtenerTodosLosLikes() throws Exception {
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        List<Likes> listaLikes = sesion.createNativeQuery("SELECT * from Likes", Likes.class).list();
        instancia.cerrar();
        return listaLikes;
    }

    public static List<Likes> obtenerLikesPor(int id, String operador, int respuestaMenuLikes)
            throws Exception {
        String columna = "";
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        switch (respuestaMenuLikes) {
            case 2 -> columna = "IdLikes";
            case 3 -> columna = "IdUsuarios ";
            case 4 -> columna = "IdPost ";
            default -> {
            }
        }
        List<Likes> LikesPorParametro = sesion
                .createNativeQuery(
                        "SELECT IdLikes, IdUsuarios, IdPost FROM Likes WHERE " + columna + operador
                                + " :condition",
                        Likes.class)
                .setParameter("condition", id).getResultList();
        return LikesPorParametro;
    }

    // #endregion

    public static String selectOperator(Scanner sc) {
        String operador = "";
        System.out.print("Introduce que operación quieres hacer: ");
        int input = sc.nextInt();
        sc.nextLine();
        switch (input) {
            case 1 -> operador = ">=";
            case 2 -> operador = "<=";
            case 3 -> operador = "=";
            default -> System.out.println("Has introducido una respuesta inválida.");
        }
        return operador;
    }
}

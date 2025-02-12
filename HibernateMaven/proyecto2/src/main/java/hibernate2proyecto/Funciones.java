package hibernate2proyecto;

import java.time.LocalDate;
import java.util.List;

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
    // ! CUANDO MODIFIQUE EL POST, QUE LA FECHA DEL UPDATED PASE DE NULL A LA DEL EQUIPO

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
        List<Post> listaPost = sesion.createNativeQuery("SELECT * from Usuarios", Post.class).list();
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
    public static List<Post> obtenerPostPor(int ID, String operador) throws Exception {
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        List<Post> UsuariosPorParametro = sesion
                .createNativeQuery(
                        "SELECT IdPost, IdUsuarios, Created_at, Updated_at FROM Usuarios WHERE IdUsuarios" + operador
                                + " :ID",
                        Post.class)
                .setParameter("ID", ID).getResultList();
        return UsuariosPorParametro;
    }
    // #endregion

    // #region Likes

    public static Likes guardarLikes(int idUsuario, int idPost) throws Exception {

        instancia = new AccesoBD();
        Likes nuevoLike = new Likes();
        instancia.abrir();
        instancia.guardar(nuevoLike);
        instancia.cerrar();
        return nuevoLike;

    }
    public static List<Likes> obtenerTodosLosLikes() throws Exception {
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        List<Likes> listaLikes = sesion.createNativeQuery("SELECT * from Usuarios", Likes.class).list();
        instancia.cerrar();
        return listaLikes;
    }

    public static Likes obtenerLikesPorID(int idLike) throws Exception {
        Likes likeObtenido;
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        likeObtenido = sesion.get(Likes.class, idLike);
        return likeObtenido;
    }
    /*public static List<Usuarios> obtenerLikesPor(int ID, String columna) throws Exception {
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
*/
    public static Likes obtenerLikesPorIDPost(int idPost) throws Exception {
        Likes likeObtenido;
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        likeObtenido = sesion.get(Likes.class, idPost);
        return likeObtenido;
    }

    // #endregion
}

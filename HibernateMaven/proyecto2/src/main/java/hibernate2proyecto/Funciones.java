package hibernate2proyecto;

import java.time.DateTimeException;
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
    private static Scanner sc = new Scanner(System.in);

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
        List<Likes> listaLikes = sesion.createNativeQuery("SELECT * FROM Likes", Likes.class).list();
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
    public static void delete(){
        
    }

    public static String selectOperator() {
        String operador = "";
        int input = leerInt("Introduce que operación quieres hacer: ");
        switch (input) {
            case 1 -> operador = ">=";
            case 2 -> operador = "<=";
            case 3 -> operador = "=";
            default -> System.out.println("Has introducido una respuesta inválida.");
        }
        return operador;
    }

    public static Post updatePost(int idPost, int eleccionActualizar) throws Exception {
        int idUsuario;
        Usuarios nuevoUsuario;
        LocalDate fecha;
        String fechaString;
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        Post postModificar = sesion.get(Post.class, idPost);

        if (postModificar == null) {
            instancia.cerrar();
            throw new Exception("El post con ID " + idPost + " no existe.");
        } else {
            switch (eleccionActualizar) {
                case 1 -> {
                    idUsuario = leerInt("Introduce el ID del nuevo Usuario del Post: "); 
                    // Obtengo el id de usuario que quiero que reemplaze al existente
                    nuevoUsuario = obtenerUsuarioPorID(idUsuario);
                    // obtengo el usuario por ese id
                    postModificar = obtenerPostPorID(idPost);
                    // con el ID del post que pedi anteriormente saco el objeto a modificar
                    postModificar.setUsuario(nuevoUsuario);
                    // y le reemplazo el objeto
                    fecha = LocalDate.now();
                    postModificar.setUpdated_at(fecha);
                }
                case 2 -> {
                    // Actualizar usuario
                    idUsuario = leerInt("Introduce el ID del nuevo Usuario del Post: ");
                    nuevoUsuario = obtenerUsuarioPorID(idUsuario);
                    postModificar = obtenerPostPorID(idPost);
                    postModificar.setUsuario(nuevoUsuario);
                }
                case 3 -> {
                    // Actualizar creacion
                    boolean salir = false;
                    do {
                        try {
                            postModificar = obtenerPostPorID(idPost);
                            fechaString = obtenerFecha();
                            fecha = LocalDate.parse(fechaString);
                            postModificar.setCreated_at(fecha);
                            postModificar.setUpdated_at(LocalDate.now());
                            salir = true; // Aqui no hace falta ponerlo despues de nada, esto sale de ahi.
                        } catch (DateTimeException e) {
                            System.out.println("Has introducido la Fecha Incorrecta! Vuelve a intentarlo");
                        }
                    } while (!salir);
                }
                case 0 -> System.out.println("Volviendo atrás...");

                default -> {
                }
            }
        }
        instancia.guardar(postModificar);
        instancia.cerrar();
        return postModificar;
    }

    public static Likes updateLike(int idLike, int eleccionActualizar) throws Exception {
        int idUsuario;
        int idPost;
        List<Likes> likeLista;
        Usuarios nuevoUsuario;
        Post nuevoPost;
        
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        Likes likeModificar = sesion.get(Likes.class, idLike);
        if (likeModificar == null){
            instancia.cerrar();
            throw new Exception("El Like con ID " + idLike + " no existe");
        }else{
            switch(eleccionActualizar){
                case 1 -> {
                    // ACTUALIZAMOS TOOD 
                    //(IDUSUARIO)
                    idUsuario = leerInt("Introduce el nuevo ID de Usuario del Like: ");
                    nuevoUsuario = obtenerUsuarioPorID(idUsuario);
                    likeLista = obtenerLikesPor(idLike, "=", 2);
                    likeModificar = likeLista.get(0);
                    likeModificar.setUsuario(nuevoUsuario);
                    ImpresionesRespuestas.likeActualizado(likeModificar);
                    // (IDPOST)
                    idPost = leerInt("Introduce el nuevo ID de Post del Like: ");
                    nuevoPost = obtenerPostPorID(idPost);
                    likeLista = obtenerLikesPor(idLike, "=", 2);
                    likeModificar = likeLista.get(0);
                    likeModificar.setPost(nuevoPost);
                    ImpresionesRespuestas.likeActualizado(likeModificar);

                    

                    
                    }
                case 2 -> {
                    idUsuario = leerInt("Introduce el nuevo ID de Usuario del Like: ");
                    nuevoUsuario = obtenerUsuarioPorID(idUsuario);
                    likeLista = obtenerLikesPor(idLike, "=", 2);
                    likeModificar = likeLista.get(0);
                    likeModificar.setUsuario(nuevoUsuario);
                    ImpresionesRespuestas.likeActualizado(likeModificar);
                }
                case 3 -> {
                    idPost = leerInt("Introduce el nuevo ID de Post del Like: ");
                    nuevoPost = obtenerPostPorID(idPost);
                    likeLista = obtenerLikesPor(idLike, "=", 2);
                    likeModificar = likeLista.get(0);
                    likeModificar.setPost(nuevoPost);
                    ImpresionesRespuestas.likeActualizado(likeModificar);
                    
                }
                case 0 -> {System.out.println("Volviendo atrás...");}
            }
            instancia.guardar(likeModificar);
            instancia.cerrar();
        }
        return likeModificar;
    }

    public static Usuarios updateUsuario(int idUsuario, int eleccionActualizar) throws Exception {
        String nombreNuevo;
        String apellidoNuevo;
        String nuevoUsername;
        String nuevoEmail;
        String nuevaPassword;

        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        Usuarios usuarioModificar = sesion.get(Usuarios.class, idUsuario);

        if (usuarioModificar == null) {
            instancia.cerrar(); // Cerrar la conexión antes de lanzar la excepción
            throw new Exception("El usuario con ID " + idUsuario + " no existe.");
        } else {
            switch (eleccionActualizar) {
                case 1 -> {
                    nombreNuevo = leerString("Introduce el nuevo Nombre: ");
                    usuarioModificar.setNombre(nombreNuevo);
                    apellidoNuevo = leerString("Introduce el nuevo Apellido: ");
                    usuarioModificar.setApellidos(apellidoNuevo);
                    nuevoUsername = leerString("Introduce el nuevo Username: ");
                    usuarioModificar.setUsername(nuevoUsername);
                    nuevaPassword = leerString("Introduce la nueva Contraseña: ");
                    usuarioModificar.setPassword(nuevaPassword);
                    nuevoEmail = leerString("Introduce el nuevo Email: ");
                    usuarioModificar.setEmail(nuevoEmail);
                }
                case 2 -> {
                    nombreNuevo = leerString("Introduce el nuevo Nombre: ");
                    usuarioModificar.setNombre(nombreNuevo);
                }
                case 3 -> {
                    apellidoNuevo = leerString("Introduce el nuevo Apellido: ");
                    usuarioModificar.setApellidos(apellidoNuevo);
                }
                case 4 -> {
                    nuevoUsername = leerString("Introduce el nuevo Username: ");
                    usuarioModificar.setUsername(nuevoUsername);
                }
                case 5 -> {
                    nuevaPassword = leerString("Introduce la nueva Contraseña: ");
                    usuarioModificar.setPassword(nuevaPassword);
                }
                case 6 -> {
                    nuevoEmail = leerString("Introduce el nuevo Email: ");
                    usuarioModificar.setEmail(nuevoEmail);
                }
                case 0 -> System.out.println("Volviendo atrás...");
                default -> {
                }
            }
        }

        instancia.guardar(usuarioModificar);
        instancia.cerrar();
        return usuarioModificar;
    }

    public static String leerString(String mensaje) {
        System.out.println(mensaje);
        String respuestaUsuario = sc.nextLine();
        return respuestaUsuario;
    }

    public static int leerInt(String mensaje) {
        int respuestaUsuario = 0;
        boolean success = false;
        do {

            try {
                // Dejamos un espacio vacio encima del mensaje
                System.out.println();
                System.out.print(mensaje); // Mostramos mensaje

                // Capturamos el input
                respuestaUsuario = sc.nextInt();

                // Si todo sale bien, salimos por la condición
                success = true;

            } catch (Exception e) {
                System.err.println("Debes imprimir un número entero. Vuelve a intentarlo...");
            } finally {
                // Limpiamos el Scanner
                sc.nextLine();
            }

        } while (!success);
        return respuestaUsuario;
    }

    public static String obtenerFecha() {
        String day;
        String month;
        String year;
        String fecha;

        day = leerString("Día: ");
        if (day.length() == 1) {
            day = "0" + day;
        }
        month = leerString("Mes: ");
        if (month.length() == 1) {
            month = "0" + month;
        }
        year = leerString("Año: ");

        fecha = String.format("%s-%s-%s", year, month, day);

        return fecha;
    }
}

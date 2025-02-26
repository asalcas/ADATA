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
    /**
     * Función que se encarga de GUARDAR un usuario con todos los parámetros pasados
     * a la función
     * 
     * @param Nombre
     * @param Apellidos
     * @param Username
     * @param Password
     * @param Email
     * @return Objeto Usuario: 'usuarioGuardar'
     * @throws Exception
     */
    public static Usuarios guardarUsuarios(String Nombre, String Apellidos, String Username, String Password,
            String Email) throws Exception {
        instancia = new AccesoBD();
        Usuarios usuarioGuardar = new Usuarios(Nombre, Apellidos, Username, Password, Email);
        instancia.abrir();
        instancia.guardar(usuarioGuardar);
        instancia.cerrar();
        return usuarioGuardar;
    }

    /**
     * Función que Obtiene todos los usuarios de la BD
     * 
     * @return Lista de usuarios: 'listaUsuarios'
     * @throws Exception
     */
    public static List<Usuarios> obtenerTodosLosUsuarios() throws Exception {
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        List<Usuarios> listaUsuarios = sesion.createNativeQuery("SELECT * from Usuarios", Usuarios.class).list();
        instancia.cerrar();
        return listaUsuarios;
    }

    /***
     * Es una funcion llama de la base de datos TODOS los registros de la tabla
     * Usuarios y los guarda en una lista pero sin cerrar la 'sesion', para poder
     * trabajar con mas de un registro
     * 
     * @return Lista usuarios: 'listaUsuarios'
     * @throws Exception
     */
    public static List<Usuarios> obtenerTodosLosUsuariosSinCerrar() throws Exception {
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        List<Usuarios> listaUsuarios = sesion.createNativeQuery("SELECT * from Usuarios", Usuarios.class).list();
        return listaUsuarios;
    }

    /**
     * Función que se encarga de Obtener un Usuario específicado por el ID
     * 
     * @param idUsuario
     * @return Usuario por ID: 'usuarioObtenido'
     * @throws Exception
     */
    public static Usuarios obtenerUsuarioPorID(int idUsuario) throws Exception {
        Usuarios usuarioObtenido;
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        usuarioObtenido = sesion.get(Usuarios.class, idUsuario);
        return usuarioObtenido;
    }

    /**
     * Función conjunta, donde obtendremos una lista de Usuarios según la columna
     * seleccionada: Nombre, Apellido, Username, Email
     * 
     * @param inputUsuario
     * @param columna
     * @return Lista de Usuarios: 'usuariosPorParametro'
     * @throws Exception
     */
    public static List<Usuarios> obtenerUsuariosPor(String inputUsuario, String columna) throws Exception {
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        List<Usuarios> usuariosPorParametro = sesion
                .createNativeQuery(
                        "SELECT idUsuarios, Nombre, Apellidos, Username, Email, Password FROM Usuarios WHERE " + columna
                                + " LIKE :inputUsuario",
                        Usuarios.class)
                .setParameter("inputUsuario", "%" + inputUsuario + "%").getResultList();
        return usuariosPorParametro;
    }
    /**
     * Función que se encarga de actualizar un Usuario según su ID
     * 
     * @param idUsuario
     * @param eleccionActualizar
     * @return Usuario Modificado: 'usuarioModificar'
     * @throws Exception
     */
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
                    nombreNuevo = leerString(Colores.ANSI_YELLOW + "Introduce el nuevo Nombre: " + Colores.ANSI_RESET);
                    usuarioModificar.setNombre(nombreNuevo);
                    apellidoNuevo = leerString(
                            Colores.ANSI_YELLOW + "Introduce el nuevo Apellido: " + Colores.ANSI_RESET);
                    usuarioModificar.setApellidos(apellidoNuevo);
                    nuevoUsername = leerString(
                            Colores.ANSI_YELLOW + "Introduce el nuevo Username: " + Colores.ANSI_RESET);
                    usuarioModificar.setUsername(nuevoUsername);
                    nuevaPassword = leerString(
                            Colores.ANSI_YELLOW + "Introduce la nueva Contraseña: " + Colores.ANSI_RESET);
                    usuarioModificar.setPassword(nuevaPassword);
                    nuevoEmail = leerString(Colores.ANSI_YELLOW + "Introduce el nuevo Email: " + Colores.ANSI_RESET);
                    usuarioModificar.setEmail(nuevoEmail);
                }
                case 2 -> {
                    nombreNuevo = leerString(Colores.ANSI_YELLOW + "Introduce el nuevo Nombre: " + Colores.ANSI_RESET);
                    usuarioModificar.setNombre(nombreNuevo);
                }
                case 3 -> {
                    apellidoNuevo = leerString(
                            Colores.ANSI_YELLOW + "Introduce el nuevo Apellido: " + Colores.ANSI_RESET);
                    usuarioModificar.setApellidos(apellidoNuevo);
                }
                case 4 -> {
                    nuevoUsername = leerString(
                            Colores.ANSI_YELLOW + "Introduce el nuevo Username: " + Colores.ANSI_RESET);
                    usuarioModificar.setUsername(nuevoUsername);
                }
                case 5 -> {
                    nuevaPassword = leerString(
                            Colores.ANSI_YELLOW + "Introduce la nueva Contraseña: " + Colores.ANSI_RESET);
                    usuarioModificar.setPassword(nuevaPassword);
                }
                case 6 -> {
                    nuevoEmail = leerString(Colores.ANSI_YELLOW + "Introduce el nuevo Email: " + Colores.ANSI_RESET);
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

    // #endregion
    // #region POST

    /**
     * Función encargada de guardar un Post
     * 
     * @param usuario
     * @param create_at
     * @return Objeto Post: 'postGuardar'
     * @throws Exception
     */
    public static Post guardarPost(Usuarios usuario, LocalDate create_at)
            throws Exception {
        instancia = new AccesoBD();
        Post postGuardar = new Post(usuario, create_at, null);
        instancia.abrir();
        instancia.guardar(postGuardar);
        instancia.cerrar();
        return postGuardar;

    }

    /**
     * Función encargada de obtener todos los Post
     * 
     * @return Lista de Post: 'listaPost'
     * @throws Exception
     */
    public static List<Post> obtenerTodosLosPost() throws Exception {
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        List<Post> listaPost = sesion.createNativeQuery("SELECT * from Posts", Post.class).list();
        instancia.cerrar();
        return listaPost;
    }

    /***
     * Funcion que se encarga de obtener todos los Post, sin cerrar la 'sesion',
     * para seguir operando
     * 
     * @return Lista de Post: 'listaPost'
     * @throws Exception
     */
    public static List<Post> obtenerTodosLosPostSinCerrar() throws Exception {
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        List<Post> listaPost = sesion.createNativeQuery("SELECT * from Posts", Post.class).list();
        return listaPost;
    }

    /**
     * Función encargada de obtener UN Post por un ID
     * 
     * @param idPost
     * @return Post: 'postObtenido'
     * @throws Exception
     */
    public static Post obtenerPostPorID(int idPost) throws Exception {
        Post postObtenido;
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        postObtenido = sesion.get(Post.class, idPost);
        return postObtenido;
    }

    /**
     * Función parametrizada para Obtener una lista de Post filtrando por distintas
     * columnas y órdenes
     * 
     * @param ID
     * @param operador
     * @param respuestaSubMenuPost
     * @return Lista Post: 'postPorParametros'
     * @throws Exception
     */
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
        List<Post> postPorParametros = sesion
                .createNativeQuery(
                        "SELECT IdPost, IdUsuarios, Created_at, Updated_at FROM Posts WHERE " + columna + operador
                                + " :ID",
                        Post.class)
                .setParameter("ID", ID).getResultList();
        return postPorParametros;
    }

    /**
     * Función parametrizada para obtener los Post por distintos órdenes y tablas
     * 
     * @param fecha
     * @param operador
     * @param respuestaSubMenuPost
     * @return Lista de Post: 'postPorParametros'
     * @throws Exception
     */
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
        List<Post> postPorParametros = sesion
                .createNativeQuery(
                        "SELECT IdPost, IdUsuarios, Created_at, Updated_at FROM Posts WHERE " + columna + operador
                                + " :date",
                        Post.class)
                .setParameter("date", fecha).getResultList();
        return postPorParametros;
    }

        /**
     * Función que se encarga de actualizar un Post según su ID
     * 
     * @param idPost
     * @param eleccionActualizar
     * @return Post Modificado: 'postModificar'
     * @throws Exception
     */
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
                    idUsuario = leerInt(
                            Colores.ANSI_YELLOW + "Introduce el ID del nuevo Usuario del Post: " + Colores.ANSI_RESET);
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
                    idUsuario = leerInt(
                            Colores.ANSI_YELLOW + "Introduce el ID del nuevo Usuario del Post: " + Colores.ANSI_RESET);
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
                            System.out.println(Colores.ANSI_RED
                                    + "Has introducido la Fecha Incorrecta! Vuelve a intentarlo" + Colores.ANSI_RESET);
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
    // #endregion

    // #region Likes
    /**
     * Función encargada de guardar un objeto tipo Likes
     * 
     * @param usuario
     * @param post
     * @return Likes: 'nuevoLike'
     * @throws Exception
     */
    public static Likes guardarLikes(Usuarios usuario, Post post) throws Exception {

        instancia = new AccesoBD();
        Likes nuevoLike = new Likes(usuario, post);
        instancia.abrir();
        instancia.guardar(nuevoLike);
        instancia.cerrar();
        return nuevoLike;

    }

    /**
     * Función para obtener una lista con todos los Objetos Like de la BD
     * 
     * @return Lista Likes: 'listaLikes'
     * @throws Exception
     */
    public static List<Likes> obtenerTodosLosLikes() throws Exception {
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        List<Likes> listaLikes = sesion.createNativeQuery("SELECT * FROM Likes", Likes.class).list();
        instancia.cerrar();
        return listaLikes;
    }

    /**
     * Función para obtener todos los objetos Likes de la BD sin cerrar la sesión
     * para poder seguir operando con los datos
     * 
     * @return Lista Likes: 'listaLikes'
     * @throws Exception
     */
    public static List<Likes> obtenerTodosLosLikesSinCerrar() throws Exception {
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        List<Likes> listaLikes = sesion.createNativeQuery("SELECT * FROM Likes", Likes.class).list();
        return listaLikes;
    }

    /**
     * Función parametrizada que sirve para obtener los Likes dependiendo de una
     * columna y orden específico
     * 
     * @param id
     * @param operador
     * @param respuestaMenuLikes
     * @return Lista de Likes: 'likesPorParametro'
     * @throws Exception
     */
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
        List<Likes> likesPorParametro = sesion
                .createNativeQuery(
                        "SELECT IdLikes, IdUsuarios, IdPost FROM Likes WHERE " + columna + operador
                                + " :condition",
                        Likes.class)
                .setParameter("condition", id).getResultList();
        return likesPorParametro;
    }
    /**
     * Función que se encarga de actualizar un Like según su ID
     * 
     * @param idLike
     * @param eleccionActualizar
     * @return Like Modificado: 'likeModificar'
     * @throws Exception
     */
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
        if (likeModificar == null) {
            instancia.cerrar();
            throw new Exception("El Like con ID " + idLike + " no existe");
        } else {
            switch (eleccionActualizar) {
                case 1 -> {
                    // ACTUALIZAMOS TOOD
                    // (IDUSUARIO)
                    idUsuario = leerInt(
                            Colores.ANSI_YELLOW + "Introduce el nuevo ID de Usuario del Like: " + Colores.ANSI_RESET);
                    nuevoUsuario = obtenerUsuarioPorID(idUsuario);
                    likeLista = obtenerLikesPor(idLike, "=", 2);
                    likeModificar = likeLista.get(0);
                    likeModificar.setUsuario(nuevoUsuario);
                    ImpresionesRespuestas.likeActualizado(likeModificar);
                    // (IDPOST)
                    idPost = leerInt(
                            Colores.ANSI_YELLOW + "Introduce el nuevo ID de Post del Like: " + Colores.ANSI_RESET);
                    nuevoPost = obtenerPostPorID(idPost);
                    likeLista = obtenerLikesPor(idLike, "=", 2);
                    likeModificar = likeLista.get(0);
                    likeModificar.setPost(nuevoPost);
                    ImpresionesRespuestas.likeActualizado(likeModificar);

                }
                case 2 -> {
                    idUsuario = leerInt(
                            Colores.ANSI_YELLOW + "Introduce el nuevo ID de Usuario del Like: " + Colores.ANSI_RESET);
                    nuevoUsuario = obtenerUsuarioPorID(idUsuario);
                    likeLista = obtenerLikesPor(idLike, "=", 2);
                    likeModificar = likeLista.get(0);
                    likeModificar.setUsuario(nuevoUsuario);
                    ImpresionesRespuestas.likeActualizado(likeModificar);
                }
                case 3 -> {
                    idPost = leerInt(
                            Colores.ANSI_YELLOW + "Introduce el nuevo ID de Post del Like: " + Colores.ANSI_RESET);
                    nuevoPost = obtenerPostPorID(idPost);
                    likeLista = obtenerLikesPor(idLike, "=", 2);
                    likeModificar = likeLista.get(0);
                    likeModificar.setPost(nuevoPost);
                    ImpresionesRespuestas.likeActualizado(likeModificar);

                }
                case 0 -> {
                    System.out.println("Volviendo atrás...");
                }
            }
            instancia.guardar(likeModificar);
            instancia.cerrar();
        }
        return likeModificar;
    }

    // #endregion

    //#region GENERICA
    /**
     * Función encargada de borrar datos de la BD según un ID
     * 
     * @param id
     * @param eleccionTabla
     * @return Boolean: 'estadoBorrado'
     * @throws Exception
     */
    public static boolean deletePorID(int id, int eleccionTabla) throws Exception {
        boolean estadoBorrado = false;
        instancia = new AccesoBD();
        instancia.abrir();
        sesion = instancia.get_sesion();
        try {

            switch (eleccionTabla) {
                case 1 -> {
                    // Usuario

                    Usuarios usuarioRemove = sesion.get(Usuarios.class, id);
                    sesion.remove(usuarioRemove);
                }
                case 2 -> {
                    // Post

                    Post postRemove = sesion.get(Post.class, id);
                    sesion.remove(postRemove);
                }
                case 3 -> {
                    // Likes

                    Likes likeRemove = sesion.get(Likes.class, id);
                    sesion.remove(likeRemove);
                }
                case 0 -> {
                    System.out.println("Volviendo atrás...");
                }

            }
            estadoBorrado = true;
        } catch (Exception e) {
            System.out.println(Colores.ANSI_RED + "Ha ocurrido un error al Eliminar Registros por ID: "
                    + Colores.ANSI_RESET + e.getMessage());
        }
        instancia.cerrar();
        return estadoBorrado;
    }

    /**
     * Función que dependiendo de la tabla seleccionada Borra TODOS los registros de
     * esta
     * 
     * @param eleccionTabla
     * @throws Exception
     * @return Boolean: 'estadoBorrado'
     */
    public static boolean deleteAll(int eleccionTabla) throws Exception {
        instancia = new AccesoBD();
        boolean estadoBorrado;
        instancia.abrir();
        sesion = instancia.get_sesion();
        try {
            switch (eleccionTabla) {
                case 1 -> {
                    // Borramos todo usuarios
                    List<Usuarios> listaUsuarios = obtenerTodosLosUsuariosSinCerrar();
                    for (Usuarios usuario : listaUsuarios) {
                        sesion.remove(usuario); // EL ERROR ESTÁ AQUI EN TEORIA DEBO CREAR UNA SESION POR CADA REMOVE
                    }
                }
                case 2 -> {
                    // Borramos todo Posts
                    List<Post> listaPosts = obtenerTodosLosPostSinCerrar();
                    for (Post post : listaPosts) {
                        sesion.remove(post); // EL ERROR ESTÁ AQUI EN TEORIA DEBO CREAR UNA SESION POR CADA REMOVE
                    }
                }
                case 3 -> {
                    // Borramos todo Likes
                    List<Likes> listaLikes = obtenerTodosLosLikesSinCerrar();
                    for (Likes like : listaLikes) {
                        sesion.remove(like); // EL ERROR ESTÁ AQUI EN TEORIA DEBO CREAR UNA SESION POR CADA REMOVE
                    }
                }
                case 0 -> {
                    System.out.println("Volviendo atrás...");
                }
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al Borrar TODOS los datos de la tabla seleccionada.");
        }
        estadoBorrado = true;

        instancia.cerrar();
        return estadoBorrado;
    }

    /**
     * Función simple para seleccionar un operador relacional
     * 
     * @return String: 'operador'
     */
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

    /**
     * Función encargada de Leer tipos String para no tener que pasar por parámetros
     * un Scanner constantemente
     * 
     * @param mensaje
     * @return String: 'respuestaUsuario'
     */
    public static String leerString(String mensaje) {
        System.out.println(mensaje);
        String respuestaUsuario = sc.nextLine();
        return respuestaUsuario;
    }

    /**
     * Función encargada de Leer tipos Int para no tener que pasar por parámetros
     * un Scanner constantemente (Comprobando que son tipos INT)
     * 
     * @param mensaje
     * @return Int: 'respuestaUsuario'
     */
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
                System.err.println(Colores.ANSI_RED + "Debes imprimir un número entero. Vuelve a intentarlo..."
                        + Colores.ANSI_RESET);
            } finally {
                // Limpiamos el Scanner
                sc.nextLine();
            }

        } while (!success);
        return respuestaUsuario;
    }

    /**
     * Función que recoge unos datos y forma un dato tipo Fecha
     * 
     * @return String: 'fecha'
     */
    public static String obtenerFecha() {
        String day;
        String month;
        String year;
        String fecha;

        day = leerString(Colores.ANSI_YELLOW + "Día: " + Colores.ANSI_RESET);
        if (day.length() == 1) {
            day = "0" + day;
        }
        month = leerString(Colores.ANSI_YELLOW + "Mes: " + Colores.ANSI_RESET);
        if (month.length() == 1) {
            month = "0" + month;
        }
        year = leerString(Colores.ANSI_YELLOW + "Año: " + Colores.ANSI_RESET);

        fecha = String.format("%s-%s-%s", year, month, day);

        return fecha;
    }
    //#endregion
}

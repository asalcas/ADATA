package hibernate2proyecto;

import java.sql.SQLDataException;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.PropertyValueException;

import Models.Likes;
import Models.Post;
import Models.Usuarios;

public class Main {
    public static void main(String[] args) {

        int opcionSwitch;
        String verbo = "";

        do {
            Impresiones.inicio();
            opcionSwitch = Funciones.leerInt(Colores.ANSI_YELLOW + "Selecciona una opción: " + Colores.ANSI_RESET);
            try {
                switch (opcionSwitch) {
                    case 1 -> {
                        verbo = "POST";
                        menuGuardarDatos();
                    }
                    case 2 -> {
                        verbo = "SELECT";
                        Impresiones.menuObtenerDatos();
                        menuObtenerDatos();
                    }
                    case 3 -> {
                        verbo = "UPDATE";
                        Impresiones.menuActualizar();
                        menuActualizarDatos();
                    }
                    case 4 -> {
                        verbo = "DELETE";
                        Impresiones.menuBorrarDatos();
                        menuBorrarDatos();
                    }
                    case 0 -> {
                        System.out.println(Colores.ANSI_YELLOW + "Nos vemos pronto!" + Colores.ANSI_RESET);
                        System.out.println("( ^-^)/");
                    }

                }
            } catch (Exception e) {
                System.err.println(
                        Colores.ANSI_RED + "Ha ocurrido un error con la operación: " + verbo + ": " + e.getMessage());
            }
        } while (opcionSwitch != 0);

    }

    public static void menuBorrarDatos() throws Exception {
        String tabla = "";
        int eleccionCantidad;
        int eleccionTabla;
        int idBorrado;
        boolean estadoBorrado;

        eleccionTabla = Funciones.leerInt(Colores.ANSI_YELLOW + "Introduce tu elección: " + Colores.ANSI_RESET);

        // ! PARA ASIGNAR COSAS INTENTAR USAR DICCIONARIOS!

        // eleccionTabla = [{1 = "Usuarios"}] o algo así

        switch (eleccionTabla) {
            case 1 -> {
                tabla = "Usuarios";
            }
            case 2 -> {
                tabla = "Post";
            }
            case 3 -> {
                tabla = "Likes";
            }

            case 0 -> {
                System.out.println("Volviendo atrás...");
            }
        }
        if (eleccionTabla > 0 && eleccionTabla <= 3) {
            Impresiones.menuSeleccionaTablaBorrar(tabla);
            eleccionCantidad = Funciones.leerInt(Colores.ANSI_YELLOW + "Introduce tu elección: " + Colores.ANSI_RESET);
            switch (eleccionCantidad) {
                case 1 -> {
                    // Toda la tabla
                    Funciones.deleteAll(eleccionTabla);
                }
                case 2 -> {
                    try {
                        switch (eleccionTabla) {
                            case 1 -> {
                                List<Usuarios> listaUsuarios = Funciones.obtenerTodosLosUsuarios();
                                ImpresionesRespuestas.respuestaShowTODOUsuarios(listaUsuarios);
                            }
                            case 2 -> {
                                List<Post> listaPost = Funciones.obtenerTodosLosPost();
                                ImpresionesRespuestas.respuestaShowTODOPost(listaPost);
                            }
                            case 3 -> {
                                List<Usuarios> listaUsuarios = Funciones.obtenerTodosLosUsuarios();
                                ImpresionesRespuestas.respuestaShowTODOUsuarios(listaUsuarios);
                            }

                        }
                        idBorrado = Funciones.leerInt(Colores.ANSI_YELLOW
                                + "Introduce el ID del registro que quieras ELIMINAR: " + Colores.ANSI_RESET);
                        estadoBorrado = Funciones.deletePorID(idBorrado, eleccionTabla);
                        if (estadoBorrado == true) {
                            System.out.println(Colores.ANSI_GREEN + "Se ha borrado el Registro de " + tabla
                                    + " con exito!" + Colores.ANSI_RESET);
                        }
                    } catch (Exception e) {
                        System.out.println(Colores.ANSI_RED + "Ha ocurrido un error en el borrado!: "
                                + Colores.ANSI_RESET + e.getMessage());
                    }
                }
                case 0 -> {
                    System.out.println("Volviendo atrás...");
                }
                    //! ANTES DE REALIZAR UN BORRADO, HE DE AVISAR: MANDA MENSAJE DE AVISO Y UNA RESPUESTA, ya que se borra todo
            }

        }
    }

    public static void menuGuardarDatos() throws Exception {
        String nombre;
        String apellido;
        String username;
        String password;
        String email;
        List<Post> listaPost;
        Usuarios usuarioSeleccionado;
        Post postSeleccionado;
        int idUsuarioPOST;
        LocalDate create_at;
        LocalDate updated_at;
        int likesIDPost;
        int likesIDUsuarios;

        Impresiones.menuGuardar();
        int eleccionDatoGuardar = Funciones
                .leerInt(Colores.ANSI_YELLOW + "Introduce tu elección: " + Colores.ANSI_RESET);

        switch (eleccionDatoGuardar) {
            case 1 -> {
                Impresiones.guardarDatosUSUARIO();
                nombre = Funciones.leerString(Colores.ANSI_YELLOW + "1. Nombre: " + Colores.ANSI_RESET);
                apellido = Funciones.leerString(Colores.ANSI_YELLOW + "2. Apellido: " + Colores.ANSI_RESET);
                username = Funciones.leerString(Colores.ANSI_YELLOW + "3. Username: " + Colores.ANSI_RESET);
                password = Funciones.leerString(Colores.ANSI_YELLOW + "4. Contraseña: " + Colores.ANSI_RESET);
                email = Funciones.leerString(Colores.ANSI_YELLOW + "5. Email: ");
                Usuarios usuarioNuevo = Funciones.guardarUsuarios(nombre, apellido, username, password, email);
                ImpresionesRespuestas.usuarioGuardado(usuarioNuevo);
            }
            case 2 -> {
                List<Usuarios> listaUsuarios = Funciones.obtenerTodosLosUsuarios();
                ImpresionesRespuestas.respuestaShowTODOUsuarios(listaUsuarios);
                Impresiones.guardarDatosPOST();

                idUsuarioPOST = Funciones
                        .leerInt(Colores.ANSI_YELLOW + "Id del Usuario del post: " + Colores.ANSI_RESET);
                Usuarios usuarioPost = Funciones.obtenerUsuarioPorID(idUsuarioPOST);
                create_at = LocalDate.now();
                updated_at = null;
                Post postGuardado = Funciones.guardarPost(usuarioPost, create_at);
                ImpresionesRespuestas.postGuardado(postGuardado);
            }
            case 3 -> {
                List<Usuarios> listaUsuarios = Funciones.obtenerTodosLosUsuarios();
                ImpresionesRespuestas.respuestaShowTODOUsuarios(listaUsuarios);
                Impresiones.guardarDatosLikes();
                likesIDUsuarios = Funciones
                        .leerInt(Colores.ANSI_YELLOW + "Introduce el Id del Usuario: " + Colores.ANSI_RESET);
                usuarioSeleccionado = Funciones.obtenerUsuarioPorID(likesIDUsuarios);
                System.out.println();
                try {
                    listaPost = Funciones.obtenerTodosLosPost();
                } catch (Exception e) {
                    listaPost = null;
                }
                if (listaPost != null) {
                    ImpresionesRespuestas.respuestaShowTODOPost(listaPost);
                    likesIDPost = Funciones.leerInt(Colores.ANSI_YELLOW
                            + "Introduce el Id del Post al que daremos Like: " + Colores.ANSI_RESET);
                    postSeleccionado = Funciones.obtenerPostPorID(likesIDPost);
                    try {
                        Likes likeGuardado = Funciones.guardarLikes(usuarioSeleccionado, postSeleccionado);
                        ImpresionesRespuestas.likeGuardado(likeGuardado);
                    } catch (PropertyValueException e) {
                        if ("idPost".equals(e.getPropertyName())) {
                            System.err.println(Colores.ANSI_RED
                                    + "\n ERROR: No puedes crear un Like si no tenemos un Post válido!\n"
                                    + Colores.ANSI_RESET);
                        } else if ("idUsuario".equals(e.getPropertyName())) {
                            System.err.println(Colores.ANSI_RED
                                    + "\n ERROR: No puedes crear un Like si no tienes un Usuario válido\n!"
                                    + Colores.ANSI_RESET);
                        }
                    }
                } else {
                    System.out.println(Colores.ANSI_RED + "La lista de post está vacía, primero debes CREAR un Post. "
                            + Colores.ANSI_RESET);

                }
            }
            case 0 -> System.out.println("Volviendo atras...");
            default -> throw new AssertionError();
        }
    }

    public static void menuObtenerDatos() throws Exception {
        int respuestaMenuUsuario = Funciones
                .leerInt(Colores.ANSI_YELLOW + "Introduce tu elección: " + Colores.ANSI_RESET);
        switch (respuestaMenuUsuario) {
            case 1 -> menuObtenerDatosUsuario();
            case 2 -> menuObtenerDatosPost();
            case 3 -> menuObtenerDatosLikes();
            case 0 -> {
            }
        }
    }

    public static void menuObtenerDatosLikes() throws Exception {
        int respuestaMenuLikes;
        List<Likes> listaLikes;
        String operador;
        int inputID;

        Impresiones.menuObtenerDatosLikes();
        respuestaMenuLikes = Funciones.leerInt(Colores.ANSI_YELLOW + "Introduce tu elección: " + Colores.ANSI_RESET);
        switch (respuestaMenuLikes) {
            case 1 -> {
                listaLikes = Funciones.obtenerTodosLosLikes();
                ImpresionesRespuestas.respuestaShowTODOLikes(listaLikes);
            }
            case 2 -> {
                Impresiones.selectOperadores();
                operador = Funciones.selectOperator();
                inputID = Funciones.leerInt(Colores.ANSI_YELLOW
                        + "Introduce el ID de Like con el que quieres realizar la búsqueda: " + Colores.ANSI_RESET);
                listaLikes = Funciones.obtenerLikesPor(inputID, operador, respuestaMenuLikes);
                ImpresionesRespuestas.respuestaShowLikesPor(listaLikes, respuestaMenuLikes); // POR ID LIKE
            }
            case 3 -> {
                Impresiones.selectOperadores();
                operador = Funciones.selectOperator();
                List<Usuarios> listaUsuarios = Funciones.obtenerTodosLosUsuarios();
                ImpresionesRespuestas.respuestaShowTODOUsuarios(listaUsuarios);
                inputID = Funciones.leerInt(Colores.ANSI_YELLOW
                        + "Introduce el ID de Usuarios con el que quieres realizar la búsqueda: " + Colores.ANSI_RESET);
                listaLikes = Funciones.obtenerLikesPor(inputID, operador, respuestaMenuLikes);
                ImpresionesRespuestas.respuestaShowLikesPor(listaLikes, respuestaMenuLikes); // POR ID USUARIO
            }
            case 4 -> {
                Impresiones.selectOperadores();
                operador = Funciones.selectOperator();
                List<Post> listaPost = Funciones.obtenerTodosLosPost();
                ImpresionesRespuestas.respuestaShowTODOPost(listaPost);
                Funciones.obtenerTodosLosPost();
                inputID = Funciones.leerInt(Colores.ANSI_YELLOW
                        + "Introduce el ID de Post con el que quieres realizar la búsqueda: " + Colores.ANSI_RESET);
                listaLikes = Funciones.obtenerLikesPor(inputID, operador, respuestaMenuLikes);
                ImpresionesRespuestas.respuestaShowLikesPor(listaLikes, respuestaMenuLikes); // POR ID POST
            }
            case 0 -> System.out.println("Volviendo atras...");

            default -> {
            }
        }

    }

    public static void menuObtenerDatosUsuario() throws Exception {
        String inputUsuario;
        String columna = "";

        Impresiones.menuObtenerDatosUsuarios();
        int respuestaSubMenuUsuario = Funciones
                .leerInt(Colores.ANSI_YELLOW + "Introduce tu elección: " + Colores.ANSI_RESET);
        switch (respuestaSubMenuUsuario) {
            case 1 -> {
                List<Usuarios> listaUsuarios = Funciones.obtenerTodosLosUsuarios();
                ImpresionesRespuestas.respuestaShowTODOUsuarios(listaUsuarios);
            }
            case 2 -> {
                int idUsuario = Funciones.leerInt(
                        Colores.ANSI_YELLOW + "Introduce un ID para realizar la busqueda: " + Colores.ANSI_RESET);
                Usuarios usuario = Funciones.obtenerUsuarioPorID(idUsuario);
                ImpresionesRespuestas.respuestaShowUsuarioPorID(usuario);
            }
            case 3, 4, 5, 6 -> {
                try {
                    switch (respuestaSubMenuUsuario) {
                        case 3 -> columna = "Nombre";
                        case 4 -> columna = "Apellidos";
                        case 5 -> columna = "Username";
                        case 6 -> columna = "Email";
                    }
                    inputUsuario = Funciones.leerString(Colores.ANSI_YELLOW
                            + "Introduce un String para realizar la busqueda: " + Colores.ANSI_RESET);

                    List<Usuarios> listaUsuariosPorParametros = Funciones.obtenerUsuariosPor(inputUsuario, columna);
                    ImpresionesRespuestas.respuestaShowUsuarioPorParametro(listaUsuariosPorParametros, columna);
                } catch (Exception e) {
                    System.err.println(
                            Colores.ANSI_RED + "Has introducido una opción erronea, vuelve a intentarlo más tarde."
                                    + Colores.ANSI_RESET);
                }
            }

            case 0 -> System.out.println("Volviendo atrás...");

            default -> System.err.println(Colores.ANSI_RED
                    + "Has introducido una opción erronea, vuelve a intentarlo más tarde." + Colores.ANSI_RESET);
        }
    }

    public static void menuObtenerDatosPost() throws Exception {
        int respuestaSubMenuPost;
        String operador;
        List<Post> listaPost;
        String fecha;
        Impresiones.menuObtenerDatosPost();
        respuestaSubMenuPost = Funciones.leerInt(Colores.ANSI_YELLOW + "Introduce tu elección: " + Colores.ANSI_RESET);

        switch (respuestaSubMenuPost) {
            case 1 -> {
                try {
                    listaPost = Funciones.obtenerTodosLosPost();
                    ImpresionesRespuestas.respuestaShowTODOPost(listaPost);
                } catch (Exception e) {
                    System.err.println(Colores.ANSI_RED + "\nLa lista de Post está vacía!\n" + Colores.ANSI_RESET);
                }
            }

            case 2 -> {
                // POR ID POST
                try {
                    Impresiones.selectOperadores();
                    operador = Funciones.selectOperator();

                    int idPost = Funciones.leerInt(Colores.ANSI_YELLOW
                            + "Introduce el ID del Post que quieres obtener: " + Colores.ANSI_RESET);
                    List<Post> postObtenido = Funciones.obtenerPostPor(idPost, operador, respuestaSubMenuPost);
                    ImpresionesRespuestas.respuestaShowPostPorIDPost(postObtenido);

                } catch (Exception e) {
                    System.out.println(Colores.ANSI_RED + "\nNo existe ese Post!\n" + Colores.ANSI_RESET);
                }
            }
            case 3 -> {
                Impresiones.selectOperadores();
                operador = Funciones.selectOperator();
                try {
                    int idUsuario = Funciones
                            .leerInt(Colores.ANSI_YELLOW
                                    + "Introduce el ID del Usuario con el que quieres obtener el Post: "
                                    + Colores.ANSI_RESET);
                    List<Post> postObtenido = Funciones.obtenerPostPor(idUsuario, operador, respuestaSubMenuPost);
                    ImpresionesRespuestas.respuestaShowPostPorIDUsuario(postObtenido);

                } catch (Exception e) {
                    System.out.println(Colores.ANSI_RED + "\nNo existe ese Post!\n" + Colores.ANSI_RESET);
                }
            }
            case 4, 5 -> {
                Impresiones.selectOperadores();
                operador = Funciones.selectOperator();
                if (respuestaSubMenuPost == 4) {
                    System.out.println(Colores.ANSI_YELLOW
                            + "Para poder trabajar con la Fecha de creación debes introducir: " + Colores.ANSI_RESET);

                } else if (respuestaSubMenuPost == 5) {
                    System.out.println(
                            Colores.ANSI_YELLOW + "Para poder trabajar con la Fecha de actualización debes introducir: "
                                    + Colores.ANSI_RESET);

                }
                try {
                    fecha = Funciones.obtenerFecha();
                    listaPost = Funciones.obtenerPostPorDATE(fecha, operador, respuestaSubMenuPost);
                    ImpresionesRespuestas.respuestaShowPostPorDate(listaPost, respuestaSubMenuPost);

                } catch (SQLDataException fechaErr) {
                    System.err.println(Colores.ANSI_RED +
                            "Has introducido incorrectamente la fecha, vuelve a intentarlo " + Colores.ANSI_RESET
                            + fechaErr.getMessage());
                }
            }

            default -> {
                System.out.println(Colores.ANSI_RED + "Has introducido una respuesta inválida, vuelve a intentarlo."
                        + Colores.ANSI_RESET);
            }
        }

    }

    public static void menuActualizarDatos() throws Exception {
        int eleccionActualizar;
        int idUsuario;
        int idPost;
        int idLike;
        int respuestaMenuActualizar = Funciones
                .leerInt(Colores.ANSI_YELLOW + "Seleccione una opción: " + Colores.ANSI_RESET);
        switch (respuestaMenuActualizar) {
            case 1 -> {
                Impresiones.menuActualizarUsuario();
                eleccionActualizar = Funciones
                        .leerInt(Colores.ANSI_YELLOW + "Seleccione una opción: " + Colores.ANSI_RESET);
                List<Usuarios> listaUsuarios = Funciones.obtenerTodosLosUsuarios();
                ImpresionesRespuestas.respuestaShowTODOUsuarios(listaUsuarios);
                idUsuario = Funciones.leerInt(
                        Colores.ANSI_YELLOW + "Selecciona el ID del Usuario a actualizar: " + Colores.ANSI_RESET);
                Usuarios usuarioGuardado = Funciones.updateUsuario(idUsuario, eleccionActualizar);
                ImpresionesRespuestas.usuarioActualizado(usuarioGuardado);
            }
            case 2 -> {
                Impresiones.menuActualizarPost();
                eleccionActualizar = Funciones
                        .leerInt(Colores.ANSI_YELLOW + "Seleccione una opción: " + Colores.ANSI_RESET);
                List<Post> listaPost = Funciones.obtenerTodosLosPost();
                ImpresionesRespuestas.respuestaShowTODOPost(listaPost);
                idPost = Funciones
                        .leerInt(Colores.ANSI_YELLOW + "Selecciona el ID del Post a actualizar: " + Colores.ANSI_RESET);
                Post postGuardado = Funciones.updatePost(idPost, eleccionActualizar);
                ImpresionesRespuestas.postActualizado(postGuardado);
            }

            case 3 -> {
                Impresiones.menuActualizarLikes();
                eleccionActualizar = Funciones
                        .leerInt(Colores.ANSI_YELLOW + "Selecciona una opción: " + Colores.ANSI_RESET);
                List<Likes> listaLikes = Funciones.obtenerTodosLosLikes();
                ImpresionesRespuestas.respuestaShowTODOLikes(listaLikes);
                idLike = Funciones
                        .leerInt(Colores.ANSI_YELLOW + "Escribe el ID del Like a actualizar: " + Colores.ANSI_RESET);
                Likes likeActualizado = Funciones.updateLike(idLike, eleccionActualizar);
                ImpresionesRespuestas.likeActualizado(likeActualizado);

            }

            case 0 -> System.out.println("Volviendo atrás...");
        }
    }

}

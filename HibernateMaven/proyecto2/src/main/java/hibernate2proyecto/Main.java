package hibernate2proyecto;

import java.sql.SQLDataException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.hibernate.PropertyValueException;

import Models.Likes;
import Models.Post;
import Models.Usuarios;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcionSwitch;
        String verbo = "";

        do {
            Impresiones.inicio();
            opcionSwitch = sc.nextInt();
            sc.nextLine();
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
                        System.out.println("Nos vemos pronto!");
                        System.out.println("( ^-^)/");
                    }

                }
            } catch (Exception e) {
                System.err.println("Ha ocurrido un error con la operación: " + verbo + ": " + e.getMessage());
            }
        } while (opcionSwitch != 0);

        sc.close();
    }

    public static void menuBorrarDatos() throws Exception {
        String tabla = "";
        int eleccionCantidad;
        int eleccionTabla;
        int idBorrado;
        boolean estadoBorrado = false;

        eleccionTabla = Funciones.leerInt("Introduce tu elección: ");

        //! PARA ASIGNAR COSAS INTENTAR USAR DICCIONARIOS!
        
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
            eleccionCantidad = Funciones.leerInt("Introduce tu elección: ");
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
                        idBorrado = Funciones.leerInt("Introduce el ID del registro que quieras ELIMINAR: ");
                        estadoBorrado = Funciones.deletePorID(idBorrado, eleccionTabla);
                        if(estadoBorrado == true){
                            System.out.println("Se ha borrado el Registro de "+tabla+" con exito!");
                        }
                    } catch (Exception e) {
                        System.out.println("Ha ocurrido un error en el borrado!: "+ e.getMessage());
                    }
                }
                case 0 -> {
                    System.out.println("Volviendo atrás...");
                }
                
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
        int eleccionDatoGuardar = Funciones.leerInt("Introduce tu elección: ");

        switch (eleccionDatoGuardar) {
            case 1 -> {
                Impresiones.guardarDatosUSUARIO();
                nombre = Funciones.leerString("1. Nombre: ");
                apellido = Funciones.leerString("2. Apellido: ");
                username = Funciones.leerString("3. Username: ");
                password = Funciones.leerString("4. Contraseña: ");
                email = Funciones.leerString("5. Email: ");
                Usuarios usuarioNuevo = Funciones.guardarUsuarios(nombre, apellido, username, password, email);
                ImpresionesRespuestas.usuarioGuardado(usuarioNuevo);
            }
            case 2 -> {
                List<Usuarios> listaUsuarios = Funciones.obtenerTodosLosUsuarios();
                ImpresionesRespuestas.respuestaShowTODOUsuarios(listaUsuarios);
                Impresiones.guardarDatosPOST();

                idUsuarioPOST = Funciones.leerInt("Id del Usuario del post: ");
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
                likesIDUsuarios = Funciones.leerInt("Introduce el Id del Usuario: ");
                usuarioSeleccionado = Funciones.obtenerUsuarioPorID(likesIDUsuarios);
                System.out.println();
                try {
                    listaPost = Funciones.obtenerTodosLosPost();
                } catch (Exception e) {
                    listaPost = null;
                }
                if (listaPost != null) {
                    ImpresionesRespuestas.respuestaShowTODOPost(listaPost);
                    likesIDPost = Funciones.leerInt("Introduce el Id del Post al que daremos Like: ");
                    postSeleccionado = Funciones.obtenerPostPorID(likesIDPost);
                    try {
                        Likes likeGuardado = Funciones.guardarLikes(usuarioSeleccionado, postSeleccionado);
                        ImpresionesRespuestas.likeGuardado(likeGuardado);
                    } catch (PropertyValueException e) {
                        if ("idPost".equals(e.getPropertyName())) {
                            System.err.println("\n ERROR: No puedes crear un Like si no tenemos un Post válido!\n");
                        } else if ("idUsuario".equals(e.getPropertyName())) {
                            System.err.println("\n ERROR: No puedes crear un Like si no tienes un Usuario válido\n!");
                        }
                    }
                } else {
                    System.out.println("La lista de post está vacía, primero debes CREAR un Post. ");

                }
            }
            case 0 -> System.out.println("Volviendo atras...");
            default -> throw new AssertionError();
        }
    }

    public static void menuObtenerDatos() throws Exception {
        int respuestaMenuUsuario = Funciones.leerInt("Introduce tu elección: ");
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
        respuestaMenuLikes = Funciones.leerInt("Introduce tu elección: ");
        switch (respuestaMenuLikes) {
            case 1 -> {
                listaLikes = Funciones.obtenerTodosLosLikes();
                ImpresionesRespuestas.respuestaShowTODOLikes(listaLikes);
            }
            case 2 -> {
                Impresiones.selectOperadores();
                operador = Funciones.selectOperator();
                inputID = Funciones.leerInt("Introduce el ID de Like con el que quieres realizar la búsqueda: ");
                listaLikes = Funciones.obtenerLikesPor(inputID, operador, respuestaMenuLikes);
                ImpresionesRespuestas.respuestaShowLikesPor(listaLikes, respuestaMenuLikes); // POR ID LIKE
            }
            case 3 -> {
                Impresiones.selectOperadores();
                operador = Funciones.selectOperator();
                List<Usuarios> listaUsuarios = Funciones.obtenerTodosLosUsuarios();
                ImpresionesRespuestas.respuestaShowTODOUsuarios(listaUsuarios);
                inputID = Funciones.leerInt("Introduce el ID de Usuarios con el que quieres realizar la búsqueda: ");
                listaLikes = Funciones.obtenerLikesPor(inputID, operador, respuestaMenuLikes);
                ImpresionesRespuestas.respuestaShowLikesPor(listaLikes, respuestaMenuLikes); // POR ID USUARIO
            }
            case 4 -> {
                Impresiones.selectOperadores();
                operador = Funciones.selectOperator();
                List<Post> listaPost = Funciones.obtenerTodosLosPost();
                ImpresionesRespuestas.respuestaShowTODOPost(listaPost);
                Funciones.obtenerTodosLosPost();
                inputID = Funciones.leerInt("Introduce el ID de Post con el que quieres realizar la búsqueda: ");
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
        int respuestaSubMenuUsuario = Funciones.leerInt("Introduce tu elección: ");
        switch (respuestaSubMenuUsuario) {
            case 1 -> {
                List<Usuarios> listaUsuarios = Funciones.obtenerTodosLosUsuarios();
                ImpresionesRespuestas.respuestaShowTODOUsuarios(listaUsuarios);
            }
            case 2 -> {
                int idUsuario = Funciones.leerInt("Introduce un ID para realizar la busqueda: ");
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
                    inputUsuario = Funciones.leerString("Introduce un String para realizar la busqueda: ");

                    List<Usuarios> listaUsuariosPorParametros = Funciones.obtenerUsuariosPor(inputUsuario, columna);
                    ImpresionesRespuestas.respuestaShowUsuarioPorParametro(listaUsuariosPorParametros, columna);
                } catch (Exception e) {
                    System.err.println("Has introducido una opción erronea, vuelve a intentarlo más tarde.");
                }
            }

            case 0 -> System.out.println("Volviendo atrás...");

            default -> System.err.println("Has introducido una opción erronea, vuelve a intentarlo más tarde.");
        }
    }

    public static void menuObtenerDatosPost() throws Exception {
        int respuestaSubMenuPost;
        String operador;
        List<Post> listaPost;
        String fecha;
        Impresiones.menuObtenerDatosPost();
        respuestaSubMenuPost = Funciones.leerInt("Introduce tu elección: ");

        switch (respuestaSubMenuPost) {
            case 1 -> {
                try {
                    listaPost = Funciones.obtenerTodosLosPost();
                    ImpresionesRespuestas.respuestaShowTODOPost(listaPost);
                } catch (Exception e) {
                    System.err.println("\nLa lista de Post está vacía!\n");
                }
            }

            case 2 -> {
                // POR ID POST
                try {
                    Impresiones.selectOperadores();
                    operador = Funciones.selectOperator();

                    int idPost = Funciones.leerInt("Introduce el ID del Post que quieres obtener: ");
                    List<Post> postObtenido = Funciones.obtenerPostPor(idPost, operador, respuestaSubMenuPost);
                    ImpresionesRespuestas.respuestaShowPostPorIDPost(postObtenido);

                } catch (Exception e) {
                    System.out.println("\nNo existe ese Post!\n");
                }
            }
            case 3 -> {
                Impresiones.selectOperadores();
                operador = Funciones.selectOperator();
                try {
                    int idUsuario = Funciones
                            .leerInt("Introduce el ID del Usuario con el que quieres obtener el Post: ");
                    List<Post> postObtenido = Funciones.obtenerPostPor(idUsuario, operador, respuestaSubMenuPost);
                    ImpresionesRespuestas.respuestaShowPostPorIDUsuario(postObtenido);

                } catch (Exception e) {
                    System.out.println("\nNo existe ese Post!\n");
                }
            }
            case 4, 5 -> {
                Impresiones.selectOperadores();
                operador = Funciones.selectOperator();
                if (respuestaSubMenuPost == 4) {
                    System.out.println("Para poder trabajar con la Fecha de creación debes introducir: ");

                } else if (respuestaSubMenuPost == 5) {
                    System.out.println("Para poder trabajar con la Fecha de actualización debes introducir: ");

                }
                try {
                    fecha = Funciones.obtenerFecha();
                    listaPost = Funciones.obtenerPostPorDATE(fecha, operador, respuestaSubMenuPost);
                    ImpresionesRespuestas.respuestaShowPostPorDate(listaPost, respuestaSubMenuPost);

                } catch (SQLDataException fechaErr) {
                    System.err.println(
                            "Has introducido incorrectamente la fecha, vuelve a intentarlo " + fechaErr.getMessage());
                }
            }

            default -> {
            }
        }

    }

    public static void menuActualizarDatos() throws Exception {
        int eleccionActualizar;
        int idUsuario;
        int idPost;
        int idLike;
        int respuestaMenuActualizar = Funciones.leerInt("Seleccione una opción: ");
        switch (respuestaMenuActualizar) {
            case 1 -> {
                Impresiones.menuActualizarUsuario();
                eleccionActualizar = Funciones.leerInt("Seleccione una opción: ");
                List<Usuarios> listaUsuarios = Funciones.obtenerTodosLosUsuarios();
                ImpresionesRespuestas.respuestaShowTODOUsuarios(listaUsuarios);
                idUsuario = Funciones.leerInt("Selecciona el ID del Usuario a actualizar: ");
                Usuarios usuarioGuardado = Funciones.updateUsuario(idUsuario, eleccionActualizar);
                ImpresionesRespuestas.usuarioActualizado(usuarioGuardado);
            }
            case 2 -> {
                Impresiones.menuActualizarPost();
                eleccionActualizar = Funciones.leerInt("Seleccione una opción: ");
                List<Post> listaPost = Funciones.obtenerTodosLosPost();
                ImpresionesRespuestas.respuestaShowTODOPost(listaPost);
                idPost = Funciones.leerInt("Selecciona el ID del Post a actualizar: ");
                Post postGuardado = Funciones.updatePost(idPost, eleccionActualizar);
                ImpresionesRespuestas.postActualizado(postGuardado);
            }

            case 3 -> {
                Impresiones.menuActualizarLikes();
                eleccionActualizar = Funciones.leerInt("Selecciona una opción: ");
                List<Likes> listaLikes = Funciones.obtenerTodosLosLikes();
                ImpresionesRespuestas.respuestaShowTODOLikes(listaLikes);
                idLike = Funciones.leerInt("Escribe el ID del Like a actualizar: ");
                Likes likeActualizado = Funciones.updateLike(idLike, eleccionActualizar);
                ImpresionesRespuestas.likeActualizado(likeActualizado);

            }

            case 0 -> System.out.println("Volviendo atrás...");
        }
    }

}

package hibernate2proyecto;

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
        int respuestaMenuUsuario;
        int opcionSwitch;
        String verbo = "";

        do {
            Impresiones.inicio();
            opcionSwitch = sc.nextInt();
            sc.nextLine();
            try {
                switch (opcionSwitch) {
                    case 1:
                    // TODO QUITAR SCANNERS POR PARAMETROS 
                        verbo = "POST";
                        menuGuardarDatos(sc);
                        break;
                    case 2:
                    // TODO Quitar SCANNERS por PARAMETROS
                        verbo = "SELECT";
                        Impresiones.menuObtenerDatos();
                        menuObtenerDatos(sc);
                        break;
                    case 3:
                        verbo = "UPDATE";
                        // TODO ESTAMOS AQUI
                        Impresiones.menuActualizar();
                        menuActualizarDatos();

                        break;
                    case 4:
                        verbo = "DELETE";
                        break;

                    case 0:
                        System.out.println("Nos vemos pronto!");
                        System.out.println("( ^-^)/");
                        break;

                }
            } catch (Exception e) {
                System.err.println("Ha ocurrido un error con la operación: " + verbo + ": " + e.getMessage());
            }
        } while (opcionSwitch != 0);

        sc.close();
    }

    public static void menuGuardarDatos(Scanner sc) throws Exception {
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
        int eleccionDatoGuardar = sc.nextInt();
        sc.nextLine();

        switch (eleccionDatoGuardar) {
            case 1:
                Impresiones.guardarDatosUSUARIO();
                System.out.print("1. Nombre: ");
                nombre = sc.nextLine();
                System.out.print("2. Apellido: ");
                apellido = sc.nextLine();
                System.out.print("3. Username: ");
                username = sc.nextLine();
                System.out.print("4. Contraseña: ");
                password = sc.nextLine();
                System.out.print("5. Email: ");
                email = sc.nextLine();
                Usuarios usuarioNuevo = Funciones.guardarUsuarios(nombre, apellido, username, password, email);
                ImpresionesRespuestas.usuarioGuardado(usuarioNuevo);
                break;
            case 2:

                List<Usuarios> listaUsuarios = Funciones.obtenerTodosLosUsuarios();
                ImpresionesRespuestas.respuestaShowTODOUsuarios(listaUsuarios);
                Impresiones.guardarDatosPOST();
                System.out.print("Id del Usuario del post: ");

                idUsuarioPOST = sc.nextInt();
                Usuarios usuarioPost = Funciones.obtenerUsuarioPorID(idUsuarioPOST);
                create_at = LocalDate.now();
                updated_at = null;
                Post postGuardado = Funciones.guardarPost(usuarioPost, create_at);
                ImpresionesRespuestas.PostGuardado(postGuardado);

                break;
            case 3:

                listaUsuarios = Funciones.obtenerTodosLosUsuarios();
                ImpresionesRespuestas.respuestaShowTODOUsuarios(listaUsuarios);
                Impresiones.guardarDatosLikes();
                System.out.print("Introduce el Id del Usuario: ");
                likesIDUsuarios = sc.nextInt();
                usuarioSeleccionado = Funciones.obtenerUsuarioPorID(likesIDUsuarios);
                System.out.println();
                try {
                    listaPost = Funciones.obtenerTodosLosPost();
                } catch (Exception e) {
                    listaPost = null;
                }

                if (listaPost != null) {
                    ImpresionesRespuestas.respuestaShowTODOPost(listaPost);
                    System.out.println("Introduce el Id del Post al que daremos Like: ");
                    likesIDPost = sc.nextInt();
                    postSeleccionado = Funciones.obtenerPostPorID(likesIDPost);
                    sc.nextLine();
                    try {
                        Likes likeGuardado = Funciones.guardarLikes(usuarioSeleccionado, postSeleccionado);
                        ImpresionesRespuestas.LikeGuardado(likeGuardado);
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
                break;
            case 0:
                System.out.println("Volviendo atras...");
                break;
            default:
                throw new AssertionError();
        }
    }

    public static void menuObtenerDatos(Scanner sc) throws Exception {
        int respuestaMenuUsuario = sc.nextInt();
        switch (respuestaMenuUsuario) {
            case 1:
                menuObtenerDatosUsuario(sc);
                break;
            case 2:
                menuObtenerDatosPost(sc);
                break;
            case 3:
                menuObtenerDatosLikes(sc);
                break;
            case 0:
                break;
        }
    }

    public static void menuObtenerDatosLikes(Scanner sc) throws Exception {
        int respuestaMenuLikes;
        List<Likes> listaLikes;
        String operador = "";
        int inputID;

        Impresiones.menuObtenerDatosLikes();
        respuestaMenuLikes = sc.nextInt();
        sc.nextLine();
        switch (respuestaMenuLikes) {
            case 1:
                listaLikes = Funciones.obtenerTodosLosLikes();
                ImpresionesRespuestas.respuestaShowTODOLikes(listaLikes);

                break;
            case 2:
                Impresiones.selectOperadores();
                operador = Funciones.selectOperator();
                System.out.print("Introduce el ID de Like con el que quieres realizar la búsqueda: ");
                inputID = sc.nextInt();
                sc.nextLine();
                listaLikes = Funciones.obtenerLikesPor(inputID, operador, respuestaMenuLikes);
                ImpresionesRespuestas.respuestaShowLikesPor(listaLikes, respuestaMenuLikes); // POR ID LIKE
                break;
            case 3:
                Impresiones.selectOperadores();
                operador = Funciones.selectOperator();
                List<Usuarios> listaUsuarios = Funciones.obtenerTodosLosUsuarios();
                ImpresionesRespuestas.respuestaShowTODOUsuarios(listaUsuarios);
                System.out.print("Introduce el ID de Usuarios con el que quieres realizar la búsqueda: ");
                inputID = sc.nextInt();
                sc.nextLine();
                listaLikes = Funciones.obtenerLikesPor(inputID, operador, respuestaMenuLikes);
                ImpresionesRespuestas.respuestaShowLikesPor(listaLikes, respuestaMenuLikes); // POR ID USUARIO
                break;
            case 4:
                Impresiones.selectOperadores();
                operador = Funciones.selectOperator();
                List<Post> listaPost = Funciones.obtenerTodosLosPost();
                ImpresionesRespuestas.respuestaShowTODOPost(listaPost);
                System.out.print("Introduce el ID de Post con el que quieres realizar la búsqueda: ");
                Funciones.obtenerTodosLosPost();
                inputID = sc.nextInt();
                sc.nextLine();
                listaLikes = Funciones.obtenerLikesPor(inputID, operador, respuestaMenuLikes);
                ImpresionesRespuestas.respuestaShowLikesPor(listaLikes, respuestaMenuLikes); // POR ID POST
                break;
            case 0:
                System.out.println("Volviendo atras...");
                break;

            default:
                break;
        }

    }

    public static void menuObtenerDatosUsuario(Scanner sc) throws Exception {
        String inputUsuario;
        String columna = "";

        Impresiones.menuObtenerDatosUsuarios();
        int respuestaSubMenuUsuario = sc.nextInt();
        sc.nextLine();
        switch (respuestaSubMenuUsuario) {
            case 1:
                List<Usuarios> listaUsuarios = Funciones.obtenerTodosLosUsuarios();
                ImpresionesRespuestas.respuestaShowTODOUsuarios(listaUsuarios);
                break;
            case 2:
                System.out.println("Introduce un ID para realizar la busqueda: ");
                int idUsuario = sc.nextInt();
                sc.nextLine();
                Usuarios usuario = Funciones.obtenerUsuarioPorID(idUsuario);
                ImpresionesRespuestas.respuestaShowUsuarioPorID(usuario);
                break;
            case 3, 4, 5, 6:
                try {
                    switch (respuestaSubMenuUsuario) {
                        case 3:
                            columna = "Nombre";
                            break;
                        case 4:
                            columna = "Apellidos";
                            break;
                        case 5:
                            columna = "Username";
                            break;
                        case 6:
                            columna = "Email";
                            break;
                    }
                    System.out.println("Introduce un String para realizar la busqueda: ");
                    inputUsuario = sc.nextLine();

                    List<Usuarios> listaUsuariosPorParametros = Funciones.obtenerUsuariosPor(inputUsuario, columna);
                    ImpresionesRespuestas.respuestaShowUsuarioPorParametro(listaUsuariosPorParametros, columna);
                } catch (Exception e) {
                    System.err.println("Has introducido una opción erronea, vuelve a intentarlo más tarde.");
                }

                break;

            case 0:
                System.out.println("Volviendo atrás...");
                break;

            default:
                System.err.println("Has introducido una opción erronea, vuelve a intentarlo más tarde.");
                break;
        }
    }

    public static void menuObtenerDatosPost(Scanner sc) throws Exception {
        int respuestaSubMenuPost;
        String operador = "";
        List<Post> listaPost;
        String day = "";
        String month = "";
        String year = "";
        String fecha = "";
        Impresiones.menuObtenerDatosPost();
        respuestaSubMenuPost = sc.nextInt();
        switch (respuestaSubMenuPost) {
            case 1:
                try {
                    listaPost = Funciones.obtenerTodosLosPost();
                    ImpresionesRespuestas.respuestaShowTODOPost(listaPost);
                } catch (Exception e) {
                    System.err.println("\nLa lista de Post está vacía!\n");
                }
                break;

            case 2:
                // POR ID POST
                try {
                    Impresiones.selectOperadores();
                    operador = Funciones.selectOperator();

                    System.out.print("Introduce el ID del Post que quieres obtener: ");
                    int idPost = sc.nextInt();
                    sc.nextLine();
                    List<Post> postObtenido = Funciones.obtenerPostPor(idPost, operador, respuestaSubMenuPost);
                    ImpresionesRespuestas.respuestaShowPostPorIDPost(postObtenido);

                } catch (Exception e) {
                    System.out.println("\nNo existe ese Post!\n");
                }

                break;
            case 3:
                Impresiones.selectOperadores();
                operador = Funciones.selectOperator();
                try {
                    System.out.print("Introduce el ID del Usuario con el que quieres obtener el Post: ");
                    int idUsuario = sc.nextInt();
                    sc.nextLine();
                    List<Post> postObtenido = Funciones.obtenerPostPor(idUsuario, operador, respuestaSubMenuPost);
                    ImpresionesRespuestas.respuestaShowPostPorIDUsuario(postObtenido);

                } catch (Exception e) {
                    System.out.println("\nNo existe ese Post!\n");
                }
                break;
            case 4, 5:

                Impresiones.selectOperadores();
                operador = Funciones.selectOperator();
                if (respuestaSubMenuPost == 4) {
                    System.out.println("Para poder trabajar con la Fecha de creación debes introducir: ");

                } else {
                    System.out.println("Para poder trabajar con la Fecha de actualización debes introducir: ");

                }
                fecha = Funciones.obtenerFecha();
                listaPost = Funciones.obtenerPostPorDATE(fecha, operador, respuestaSubMenuPost);
                ImpresionesRespuestas.respuestaShowPostPorDate(listaPost, respuestaSubMenuPost);
                break;

            default:

                break;
        }

    }

    public static void menuActualizarDatos() throws Exception {
        int eleccionActualizar;
        int idUsuario;
        int idPost;
        int respuestaMenuActualizar = Funciones.leerInt("Seleccione una opción: ");
        switch (respuestaMenuActualizar) {
            case 1 -> {
                Impresiones.menuActualizarUsuario();
                eleccionActualizar = Funciones.leerInt("Seleccione una opción: ");
                List<Usuarios> listaUsuarios = Funciones.obtenerTodosLosUsuarios();
                ImpresionesRespuestas.respuestaShowTODOUsuarios(listaUsuarios);
                idUsuario = Funciones.leerInt("Selecciona el ID del Usuario a actualizar: ");
                Funciones.updateUsuario(idUsuario, eleccionActualizar);
            }
            case 2 -> {
                Impresiones.menuActualizarPost();
                eleccionActualizar = Funciones.leerInt("Seleccione una opción: ");
                List<Post> listaPost = Funciones.obtenerTodosLosPost();
                ImpresionesRespuestas.respuestaShowTODOPost(listaPost);
                idPost = Funciones.leerInt("Selecciona el ID del Post a actualizar: ");
                Funciones.updatePost(idPost, eleccionActualizar);
            }

            case 3 -> {
                Impresiones.menuActualizarLikes(); 
            }

            case 0 -> System.out.println("Volviendo atrás...");
        }
    }
}


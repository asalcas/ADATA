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
                        verbo = "POST";
                        menuGuardarDatos(sc);
                        break;
                    case 2:
                        verbo = "SELECT";
                        Impresiones.menuObtenerDatos();
                        menuObtenerDatos(sc);
                        break;
                    case 3:
                        verbo = "UPDATE";
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
                System.err.println("Ha ocurrido un error con la operación: " + verbo);
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
                    sc.nextLine();
                    try {
                        Likes likeGuardado = Funciones.guardarLikes(likesIDUsuarios, likesIDPost);
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
        Impresiones.menuObtenerDatosLikes();
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
        List<Post> listaPost;
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
                    System.out.print("Introduce el ID del Post que quieres obtener: ");
                    int idPost = sc.nextInt();
                    sc.nextLine();
                    Post postObtenido = Funciones.obtenerPostPorID(idPost);
                    ImpresionesRespuestas.respuestaShowPostPorID(postObtenido);

                } catch (Exception e) {
                    System.out.println("\nNo existe ese Post!\n");
                }

                break;
            case 3:
                int input;
                int idUsuario;
                String operador = "";
                Impresiones.selectOperadores();
                System.out.print("Introduce que operación quieres hacer:");
                input = sc.nextInt();
                sc.nextLine();
                switch (input) {
                    case 1:
                        operador = ">=";
                        break;
                    case 2:
                        operador = "<=";
                        break;
                    case 3:
                        operador = "=";
                        break;
                    default:
                    System.out.println("Has introducido una respuesta inválida.");
                        break;
                }
                try {
                    Impresiones.selectOperadores();
                    System.out.print("Introduce el ID del Post que quieres obtener: ");
                    idUsuario = sc.nextInt();
                    sc.nextLine();
                    List<Post> postObtenido = Funciones.obtenerPostPor(idUsuario, operador);
                    ImpresionesRespuestas.respuestaShowPostPorIDORDENADO(postObtenido);

                } catch (Exception e) {
                    System.out.println("\nNo existe ese Post!\n");
                }
                break;
            case 4:
                // por FECHA DE CREACIÓN
                // pedir los digitos dia mes año y concatenarlos en: localdate variable = String
                // format ("%d-%2d-%2d")
                break;

            case 5:
                // por fecha de actualización
                // pedir los digitos dia mes año y concatenarlos en: localdate variable = String
                // format ("%d-%2d-%2d")
            default:

                break;
        }

    }
}

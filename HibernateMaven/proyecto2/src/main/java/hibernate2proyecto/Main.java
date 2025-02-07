package hibernate2proyecto;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

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

                        menuGuardarDatos(sc);
                        verbo = "POST";
                        break;
                    case 2:

                        Impresiones.menuObtenerDatos();
                        respuestaMenuUsuario = sc.nextInt();
                        menuObtenerDatosUsuario(sc);
                        verbo = "SELECT";
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

                    default:
                        break;
                }
            } catch (Exception e) {
                System.err.println(String.format("Ha ocurrido un error con la operación: %s" + e.getMessage(), verbo));
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
        int idUsuarioPOST;
        LocalDate create_at;

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
                
                Funciones.obtenerTodosLosUsuarios();
                Impresiones.guardarDatosPOST();
                System.out.print("1. Id del Usuario del post: ");

                idUsuarioPOST = sc.nextInt();
                Usuarios usuarioPost = Funciones.obtenerUsuarioPorID(idUsuarioPOST);
                create_at = LocalDate.now();
                Funciones.guardarPost(usuarioPost, create_at);

                break;
            default:
                throw new AssertionError();
        }
    }

    public static void menuObtenerDatos(int respuestaMenuUsuario, Scanner sc) throws Exception {
        switch (respuestaMenuUsuario) {
            case 1:
                menuObtenerDatosUsuario(sc);
                break;
            case 2:
                menuObtenerDatosPost(sc);
                break;
            case 3:
                break;
            case 0:
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
                ImpresionesRespuestas.respuestaShowTODOPersonas(listaUsuarios);
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
        Impresiones.menuObtenerDatosPost();

    }
}

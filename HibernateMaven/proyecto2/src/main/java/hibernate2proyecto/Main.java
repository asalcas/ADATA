package hibernate2proyecto;

import java.util.List;
import java.util.Scanner;

import Models.Usuarios;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int respuestaMenuUsuario;
        int opcionSwitch;
        String verbo = "";
        String nombre;
        String apellido;
        String username;
        String password;
        String email;

        do {
            Impresiones.inicio();
            opcionSwitch = sc.nextInt();
            sc.nextLine();
            try {
                switch (opcionSwitch) {
                    case 1:

                        Impresiones.guardarDatos();
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
                        Usuarios usuarioNuevo = Funciones.guardarPersona(nombre, apellido, username, password, email);
                        ImpresionesRespuestas.usuarioGuardado(usuarioNuevo);
                        verbo = "POST";
                        break;
                    case 2:

                        Impresiones.menuObtenerDatos();
                        respuestaMenuUsuario = sc.nextInt();
                        menuObtenerDatos(respuestaMenuUsuario, sc);
                        verbo = "SELECT";
                        break;

                    case 3:
                        verbo = "UPDATE";
                        break;

                    case 4:
                        verbo = "DELETE";
                        break;

                    case 0:

                        break;

                    default:
                        break;
                }
            } catch (Exception e) {
                System.err.println("Ha ocurrido un error con la operación: " + verbo + e.getMessage());
            }
        } while (opcionSwitch != 0);

        sc.close();
    }

    public static void menuObtenerDatos(int respuestaMenuUsuario, Scanner sc) throws Exception {
        String inputUsuario;
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
                String tabla;
                if (respuestaMenuUsuario == 3) {
                    tabla = "Nombre";
                } else if (respuestaMenuUsuario == 4) {
                    tabla = "Apellidos";
                } else if (respuestaMenuUsuario == 5) {
                    tabla = "Username";
                } else {
                    tabla = "Email";
                }
                System.out.println("Introduce un String para realizar la busqueda: ");
                inputUsuario = sc.nextLine();
                List<Usuarios> listaUsuariosPorParametros = Funciones.obtenerUsuariosPor(inputUsuario, tabla);
                ImpresionesRespuestas.respuestaShowUsuarioPorParametro(listaUsuariosPorParametros, tabla);

                break;
            case 0:
                System.out.println("Volviendo atrás...");
                break;

            default:
                break;
        }
    }
}

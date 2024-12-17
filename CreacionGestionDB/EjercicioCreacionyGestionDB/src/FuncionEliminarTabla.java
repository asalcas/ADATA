import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FuncionEliminarTabla {
    // #region Códigos ANSI COLOREAR TEXTO
    static String reset = "\033[0m"; // Resetear color al predeterminado
    static String rojo = "\033[31m";
    static String verde = "\033[32m";
    static String amarillo = "\033[33m";
    static String azul = "\033[34m";

    // #endregion
    public static void eliminarTablas(Connection conn, Scanner lector) {

        int opcionUsuario;
        String tabla = "";
        String borrarTablaQuery;
        boolean opcionCorrecta = false;
        String borrarRegistro = "";

        Pintar.eliminarTablaORegistro();
        opcionUsuario = lector.nextInt();
        do {
            switch (opcionUsuario) {
                case 1:

                    Pintar.registroTablaEliminar();
                    switch (opcionUsuario) {
                        case 1:
                            tabla = "Usuarios";
                            break;
                        case 0:
                            opcionCorrecta = true;
                            break;
                        default:
                            System.out.println("Nombre de tabla no valido.");
                            break;
                    }
                    Pintar.eliminarRegistrosMenu();
                    opcionUsuario = lector.nextInt();
                    // INTRODUCIR QUERY BORRAR
                    break;
                case 2:
                    Pintar.eliminarTablasMenu();
                    opcionUsuario = lector.nextInt();

                    // Validar que el orden de eliminación sea correcto
                    switch (opcionUsuario) {
                        case 1:
                            tabla = "Usuarios";
                            break;
                        case 2:
                            tabla = "Posts";
                            break;
                        case 3:
                            tabla = "Likes";
                            break;
                        default:
                            System.out.println("Nombre de tabla no válido.");
                            break;
                    }
                    borrarTablaQuery = "DROP TABLE IF EXISTS " + tabla;
                    try (PreparedStatement stmt = conn.prepareStatement(borrarTablaQuery)) {
                        stmt.executeUpdate();
                        System.out.println("Tabla " + tabla + " eliminada correctamente.");
                    } catch (SQLException e) {
                        if (e.getSQLState().equals("23000")) {
                            System.err.println(
                                    rojo + "No se puede eliminar esta tabla por que otras la referencian con Foreign Keys. Borra primero LIKES y POSTS"
                                            + reset);
                        }
                    }
                    opcionCorrecta = true;
                    break;
                case 0:
                    opcionCorrecta = true;
                    break;

                default:
                    System.err.println("Has introducido una opcion no valida");
                    break;
            }
        } while (!opcionCorrecta);
    }
}

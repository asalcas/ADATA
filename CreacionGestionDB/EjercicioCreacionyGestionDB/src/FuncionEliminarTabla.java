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
        int idParaBorrar = 0;
        String primaryKEY = "";
        String queryDELETE = "";
        String confirmacion = "";
        String selectDatosRegistroBorrar = "";

        Pintar.eliminarTablaORegistro();
        opcionUsuario = lector.nextInt();
        do {
            switch (opcionUsuario) {
                case 1:

                    Pintar.registroTablaEliminar();
                    opcionUsuario = lector.nextInt();
                    switch (opcionUsuario) {
                        case 1:
                            tabla = "Usuarios";
                            primaryKEY = "idUsuarios";
                            break;
                        case 2:
                            tabla = "Posts";
                            primaryKEY = "idPost";
                            break;
                        case 3:
                            tabla = "Likes";
                            primaryKEY = "idLikes";
                            break;
                        case 0:
                            opcionCorrecta = true;
                            break;
                        default:
                            System.out.println("Opcion no valida, intentelo de nuevo.");
                            break;
                    }
                    Pintar.eliminarRegistrosMenu();
                    idParaBorrar = lector.nextInt();

                    selectDatosRegistroBorrar = "SELECT * FROM " + tabla + " WHERE " + primaryKEY + " = ?";
                    try (PreparedStatement pstmt = conn.prepareStatement(selectDatosRegistroBorrar)) {
                        pstmt.setInt(1, idParaBorrar);
                        try (ResultSet rs = pstmt.executeQuery()) {
                            if (rs.next()) {

                                System.out.println(amarillo + "\nDatos actuales del registro: \n" + reset);
                                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                                    System.out.println(rs.getMetaData().getColumnName(i) + ": " + rs.getString(i));
                                }
                                System.out.println("");
                                System.out.println("¿Seguro que quieres borrar los datos? (Y/N)");
                                confirmacion = lector.next().toUpperCase().trim();
                                if (confirmacion.equals("Y")) {
                                    queryDELETE = "DELETE FROM " + tabla + " WHERE " + primaryKEY + " = ?";
                                    try (PreparedStatement pstmtDELETE = conn.prepareStatement(queryDELETE)) {
                                        pstmtDELETE.setInt(1, idParaBorrar);
                                        int filasAfectadas = pstmtDELETE.executeUpdate();
                                        if (filasAfectadas > 0) {
                                            System.out
                                                    .println("Registro eliminado correctamente de la tabla: " + tabla);
                                        }

                                    }
                                } else {
                                    System.out.println(amarillo + "Operacion cancelada por el user" + reset);
                                }
                            } else {
                                System.out.println("No se encontró ningun registro con el ID que seleccionaste");
                            }
                        }
                    } catch (SQLException e) {
                        if (e.getSQLState().equals("23000")) {
                            System.err.println(
                                    "No se puede eliminar este registro por que otras tablas lo estan referenciando con Foreign Keys");
                        } else {
                            System.err.println("Error inesperado: " + e.getMessage());
                        }
                    }
                    opcionCorrecta = true;
                    break;
                case 2:
                    Pintar.eliminarTablasMenu();
                    opcionUsuario = lector.nextInt();
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

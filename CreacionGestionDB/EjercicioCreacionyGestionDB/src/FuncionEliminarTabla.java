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
    }

    public static void eliminarRegistros(Connection conn, Scanner lector) { //! ELIMINAR REGISTRO SOLO
        int opcionUsuario;
        boolean funcionando;
        String tablaModificar = "";
        int idRegistro;
        String targetModificar = "";
        String referenciaTABLA = "";
        String nuevoContenido = "";
        String updateColumna = "";
        String opcionUsuarioString = "";

        // #region Códigos ANSI COLOREAR TEXTO
        String reset = "\033[0m"; // Resetear color al predeterminado
        String rojo = "\033[31m";
        String verde = "\033[32m";
        String amarillo = "\033[33m";
        String azul = "\033[34m";
        // #endregion
        try {
            conn.setAutoCommit(false);

            funcionando = false;
            while (!funcionando) {
                // Mostrar las tablas disponibles y seleccionar una
                Pintar.modificarRegistros();
                opcionUsuario = lector.nextInt();
                lector.nextLine();

                switch (opcionUsuario) {
                    case 1:
                        tablaModificar = "Usuarios";
                        referenciaTABLA = "idUsuarios";
                        break;
                    case 2:
                        tablaModificar = "Posts";
                        referenciaTABLA = "idPost";
                        break;
                    case 0:
                        funcionando = true;
                        break;

                    default:
                        System.err.println("Has introducido una opcion no valida");
                        break;
                }
                funcionando = true;
            }

            Pintar.modificarUsuarios();
            opcionUsuario = lector.nextInt();
            lector.nextLine();
            funcionando = false;
            while (!funcionando) {
                switch (opcionUsuario) {
                    case 1:
                        targetModificar = "Nombre";
                        break;
                    case 2:
                        targetModificar = "Apellidos";
                        break;
                    case 3:
                        targetModificar = "Username";
                        break;
                    case 4:
                        targetModificar = "Password";
                        break;
                    case 5:
                        targetModificar = "email";
                        break;
                    case 0:
                        funcionando = true;
                        break;

                    default:
                        System.out.println("Tienes que introducir un Nº valido.");
                        break;
                }
                funcionando = true;
            }
            System.out.print("Introduce el ID del registro que deseas modificar: ");
            idRegistro = lector.nextInt();
            lector.nextLine(); // Limpiar el buffer

            String consulta = "SELECT * FROM " + tablaModificar + " WHERE " + referenciaTABLA + " = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                pstmt.setInt(1, idRegistro);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {

                    System.out.println(amarillo + "\nDatos actuales del registro: \n" + reset);
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        System.out.println(rs.getMetaData().getColumnName(i) + ": " + rs.getString(i));
                    }

                    System.out.print("Introduce el nuevo valor para " + targetModificar + ": ");
                    nuevoContenido = lector.nextLine();
                    updateColumna = "UPDATE " + tablaModificar + " SET " + targetModificar + " = ? WHERE "
                            + referenciaTABLA
                            + " = ?";
                    System.out.println(updateColumna);

                    try (PreparedStatement updateStmt = conn.prepareStatement(updateColumna)) {
                        updateStmt.setString(1, nuevoContenido);
                        updateStmt.setInt(2, idRegistro);

                        System.out.print("¿Quieres guardar los cambios? (Y/N): ");
                        opcionUsuarioString = lector.nextLine().toUpperCase().trim();

                        if (opcionUsuarioString.equals("Y")) {
                            int filasActualizadas = updateStmt.executeUpdate();
                            if (filasActualizadas > 0) {
                                System.out.println("¡Registro actualizado correctamente!");
                            } else {
                                System.out.println("No se pudo actualizar el registro. Verifica el ID.");
                                conn.rollback();
                            }
                        } else if (opcionUsuarioString.equals("N")) {
                            conn.rollback();
                            System.out.println("Se han descartado los cambios correctamente.");

                        }
                    }
                } else {
                    System.out.println("No se encontró ningún registro con el ID proporcionado.");
                }
            } catch (SQLException errorException) {
                System.err.println("Error al actualizar un registro");
            }
        } catch (

        SQLException e) {
            System.err.println("Error al consultar o actualizar el registro: " + e.getMessage());
        }
    }
}

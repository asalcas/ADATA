import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class FuncionEliminarTabla {

    public void eliminarTablas(Connection conn) {
        Scanner lector = new Scanner(System.in);

        System.out.println("No es posible eliminar todas las tablas a la vez debido a las dependencias entre ellas.");
        System.out.println("Se deben eliminar en el siguiente orden: Likes -> Posts -> Usuarios.");
        System.out.print("¿Qué tabla deseas eliminar primero? (Likes/Posts/Usuarios): ");
        String tabla = lector.nextLine();

        // Validar que el orden de eliminación sea correcto
        switch (tabla.toLowerCase()) {
            case "likes":
                eliminarTabla(conn, "Likes");
                break;
            case "posts":
                System.out.println("Debes eliminar primero la tabla Likes debido a las claves foráneas.");
                break;
            case "usuarios":
                System.out.println("Debes eliminar primero las tablas Likes y Posts debido a las claves foráneas.");
                break;
            default:
                System.out.println("Nombre de tabla no válido.");
                break;
        }
    }

    private void eliminarTabla(Connection conn, String tabla) {
        String sqlDrop = "DROP TABLE IF EXISTS " + tabla;
        try (PreparedStatement stmt = conn.prepareStatement(sqlDrop)) {
            stmt.executeUpdate();
            System.out.println("Tabla " + tabla + " eliminada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar la tabla " + tabla + ": " + e.getMessage());
        }
    }
}

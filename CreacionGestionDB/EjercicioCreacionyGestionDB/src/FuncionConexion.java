import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FuncionConexion {

    /**
     * Funcion que se encarga de conectarse a la base de datos
     * ad2425_alvaro_salvador
     * 
     * @return Connection conn
     * @throws SQLException
     */
    public static Connection conectar(String url, String usuario, String password) throws SQLException {

        Connection conn = null;
        try {
            // Cargar el controlador de MySQL JDBC.
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecemos la conexión a la DB con las variables (url, consulta, password)
            conn = DriverManager.getConnection(url, usuario, password);
            // Notificamos al usuario que hizo conexión correctamente.
            System.out.println("Se ha establecido la conexion con la DB\n=======================================");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println(sqlException.getMessage());
        } catch (ClassNotFoundException classError) {
            classError.printStackTrace();
        }
        return conn;
    }
}

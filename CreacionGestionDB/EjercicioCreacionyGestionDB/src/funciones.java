import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class funciones {
public static void main(String[] args) throws SQLException {
    crearTabla(conectar());
}
    public static Connection conectar() throws SQLException {

        String url = "jdbc:mysql://dns11036.phdns11.es:3306/ad2425_alvaro_salvador";
        String usuario = "alvaro_salvador";
        String password = "12345";
        Connection conn = null;
        try {
            // Cargar el controlador de MySQL JDBC.
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecemos la conexión a la DB con las variables (url, consulta, password)
            conn = DriverManager.getConnection(url, usuario, password);
            // Notificamos al usuario que hizo conexión correctamente.
            System.out.println("Se ha establecido la conexion ^^\n_____________________________");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classError) {
            classError.printStackTrace();
        }
        return conn;
    }

    public static void crearTabla(Connection conn) throws SQLException {
        Statement stmt = null;
        Scanner lector = new Scanner(System.in);
        String tabla = "";
        boolean funcionando = true;
        try {
            conn = conectar();
            stmt = conn.createStatement();
            int respuestaUser = 0;
            while (funcionando) {
                System.out.println("¿Quieres crear una tabla o todas a la vez?\n1. Una a una\n2. Todas");
                respuestaUser = lector.nextInt();
                if (respuestaUser == 1){
                    System.out.println("¿Que tabla quieres crear?\n1. Usuarios\n2. Likes\n3. Posts\nEscribe el Nº: ");
                    respuestaUser = lector.nextInt();
                    switch (respuestaUser) {
                        case 1:
                            tabla = "Usuarios"; // MEJORAR CREATE TABLE
                            funcionando = false;
                            break;
                        case 2:
                            tabla = "Likes";
                            funcionando = false;
                            break;
                        case 3:
                            tabla = "Posts";
                            funcionando = false;
                            break;
                        default:
                            System.out.println("Tienes que introducir un Nº valido.");
                            break;
                    }

                } else{



                }
                
            }
            stmt.executeUpdate("CREATE TABLE " + tabla); // HACERLA BIEN
            System.out.println("TABLA CREADA CORRECTAMENTE: " + tabla);
        } catch (SQLException sqlConnectException) {
            System.out.println("Ha ocurrido un error de conexion a la DATABASE: " + sqlConnectException);

        } finally {
            conn.close();
            stmt.close();
            lector.close();
        }

    }
}

package ejercicioconexionprofesor;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionPcProfesor {
    public ConexionPcProfesor() {
    }

    public static void main(String[] args) {
        if (conexionJDBC() == null) {
            System.out.println("Cagadon");
        } else {
            System.out.println("Perfe");
        }

    }

    public static Connection conexionJDBC() {
        String url = "jdbc:mysql://dns11036.phdns11.es:3306/ad2425_alvaro_salvador";
        String usuario = "alvaro_salvador";
        String password = "12345";
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, password);
            System.out.println("Se ha hecho la conexion :) ");
        } catch (SQLException var5) {
            var5.printStackTrace();
        } catch (ClassNotFoundException var6) {
            var6.printStackTrace();
        }

        return conn;
    }
}

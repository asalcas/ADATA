package crearClase;

import ejercicioConexionProfesor.ConexionPcProfesor;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCrearClase {
    public JDBCrearClase() {
    }

    public static void main(String[] args) {
        try {
            crecionBaseDeDatos();
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public static void crecionBaseDeDatos() throws Exception {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = ConexionPcProfesor.conexionJDBC();
            stmt = conn.createStatement();
            String sql = "CREATE OR REPLACE DATABASE PERSONASEjercicio1";
            stmt.executeUpdate(sql);
        } catch (SQLException var7) {
            var7.printStackTrace();
        } catch (Exception var8) {
            var8.printStackTrace();
        } finally {
            stmt.close();
            conn.close();
        }

    }
}
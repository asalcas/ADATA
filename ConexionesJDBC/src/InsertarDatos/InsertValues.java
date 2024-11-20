package InsertarDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import ejercicioConexionProfesor.ConexionPcProfesor;

public class InsertValues {

    public static void main(String[] args) {
        Connection conn = null; // Declaramos el objeto Conexion llamado conn en "null"
        Statement stmt = null; // Declaramos el objeto Statement llamado stmt en "null"

        String[] arrayConsulta = ArrayInsertDB.insertDB; //
        try {
            conn = ConexionPcProfesor.conexionJDBC();
            stmt = conn.createStatement();
            System.out.println("Nos hemos conectado a la DB perfectamente :)");
            for (String cadaConsulta : arrayConsulta) {
                stmt.executeUpdate(cadaConsulta);

            }

        } catch (SQLException errorSql) {
            errorSql.printStackTrace();
            
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error inesperado: " + e);
        }finally {
            try{
                if(stmt != null){
                    stmt.close();
                    conn.close();
                }
            }catch(SQLException errorSql) {
                System.err.println("No se ha podido cerrar la conexión");

                
            }
        }

    }
}
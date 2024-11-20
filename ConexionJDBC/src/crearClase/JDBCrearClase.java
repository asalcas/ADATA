package crearClase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import ejercicioConexionProfesor.ConexionPcProfesor;


public class JDBCrearClase {
	public static void main(String[] args) {
		
		// NO HAGAS ESTOOOOOOOOOO
		try {
			crecionBaseDeDatos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void crecionBaseDeDatos() throws Exception {
	    Connection conn = null;
	    Statement stmt = null;
	    try {
	        //Paso 1.Previamente habremos realizado la conexión
	        conn = ConexionPcProfesor.conexionJDBC();
	        //Paso 2. Creamos un nuevo objeto con la conexión
	        stmt = conn.createStatement();
	        //Paso 3. Definimos la sentencia de crear una nueva base de datos
	        String sql = "CREATE OR REPLACE DATABASE PERSONASEjercicio1";
	        //Paso 4. Ejecutar la sentencia
	        stmt.executeUpdate(sql);
	    }catch(SQLException se){
	        //Gestionamos los posibles errores que puedan surgir durante la ejecucion de la insercion
	        se.printStackTrace();
	    }catch(Exception e){
	        //Gestionamos los posibles errores
	        e.printStackTrace();
	    }finally{
	        //Paso 5. Cerrar el objeto en uso y la conexión
	        stmt.close();
	        conn.close();
	    }
	}

}

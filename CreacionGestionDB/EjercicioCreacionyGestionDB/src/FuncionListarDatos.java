import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class FuncionListarDatos {
    public static void main(String[] args) {
        

        
    }
    public static boolean listarDatos(Connection conn) throws SQLException{
        PreparedStatement pstmt = null;
        String listarUsuarios = String.format(
                "INSERT INTO Usuarios (Nombre, Apellidos, Username, Password, email) VALUES (?, ?, ?, ?, ? );");


                // SELECT variable + IF SI {,} + variable
                // switch select objeto de la tabla, si respuesta usuario
                // switch que datos quieres introducir (switch con posibles) 
                boolean dejarDeFuncionar = true;
                
        try {
            pstmt = conn.prepareStatement(listarUsuarios);
            
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error inesperado: " + e );
        }
        
        return dejarDeFuncionar;
    }
}

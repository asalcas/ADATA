import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class InterfazAplicacion {
    private static Scanner lector = new Scanner(System.in);

    // SCANNER AQUI
    public static void main(String[] args) throws Exception {
        final String url = "jdbc:mysql://dns11036.phdns11.es:3306/ad2425_alvaro_salvador";
        final String usuario = "alvaro_salvador";
        final String password = "12345";
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        boolean dejarDeFuncionar = false;
        int respuestauser;
    
        // Y LOS STRING PARA LA CONEXION
        boolean funcionando = true;
        while (funcionando) {
            Pintar.menuPrincipal();
            respuestauser = lector.nextInt();
            lector.nextLine();
            switch (respuestauser) {
                // CREAR CONTROL DE FLUJO PARA EVITAR ERRORES 
                case 1:
                    conn = FuncionConexion.conectar(url, usuario, password);

                    break;
                case 2:
                try {
                    FuncionCrearTablas.crearTabla(conn, lector, stmt);
                    //TODO por aqui voy, esto esta por preguntarse   
                } catch (Exception e) {
                    System.err.println("Ha ocurrido algo inesperado, pruebe mas tarde");
                }
                    break;
                case 3:
                    //pintarInsertarDatos();
                    break;
                case 4:

                /*do {
                    //pintarListarDatos();
                    dejarDeFuncionar = FuncionListarDatos.listarDatos(conn);
                } while (!dejardefuncionar);*/
                    break;
                case 5:
                    //pintarModificarDatos();
                    break;
                case 6:
                    //pintarBorrarDatos();
                    break;
                case 0:
                    funcionando = false;
                    break;
                default:
                    break;
            }
        }

        // ORDEN PROGRAMAS:
        // ? 1. INTERFAZ GRAFICA (MAIN)
        // ? 2.
        // Menus siempre en una funcion para llamarlas desde ahi, desgranar las
        // funciones a lo más básico, 1 funcion == 1 funcionalidad.ç
        // Dividir por modelos
    }
    private static void pintarCrearTablas(Connection conn, Scanner lector){

    }
    private static void pintarListarDatos(){

    }
}

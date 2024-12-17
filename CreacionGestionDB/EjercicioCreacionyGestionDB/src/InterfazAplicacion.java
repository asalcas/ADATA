import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class InterfazAplicacion {
    private static Scanner lector = new Scanner(System.in);
    // #region Códigos ANSI COLOREAR TEXTO
    String reset = "\033[0m"; // Resetear color al predeterminado
    String rojo = "\033[31m";
    String verde = "\033[32m";
    String amarillo = "\033[33m";
    String azul = "\033[34m";
    // #endregion

    // SCANNER AQUI
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://dns11036.phdns11.es:3306/ad2425_alvaro_salvador";
        String usuario = "alvaro_salvador";
        String password = "12345";
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
                    try {
                        conn = FuncionConexion.conectar(url, usuario, password);
                    } catch (Exception error) {
                        error.getMessage();
                        System.err.println("Ha ocurrido un error inesperado en la conexion");
                    }
                    break;
                case 2:
                    try {
                        FuncionCrearTablas.crearTabla(conn, lector, stmt);
                    } catch (Exception e) {
                        System.err.println("Ha ocurrido algo inesperado, pruebe mas tarde");
                    }
                    break;
                case 3:
                    try {

                        FuncionInsertarDatos.insertarDatos(conn, lector);
                    } catch (Exception e) {
                        System.err.println("Ha ocurrido algo inesperado, pruebe mas tarde");
                    }

                    break;
                case 4:

                    do {
                        dejarDeFuncionar = FuncionListarDatos.listarDatos(conn, lector);
                    } while (!dejarDeFuncionar);
                    break;
                case 5:
                    FuncionModificarDatos.modificarDatos(conn, lector);
                    break;
                case 6:
                    // pintarBorrarDatos();
                    break;
                case 0:
                    funcionando = false;
                    if (stmt != null) {
                        stmt.close();
                    }
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    lector.close();
                    break;
                default:
                    break;
            }
        }
    }
}

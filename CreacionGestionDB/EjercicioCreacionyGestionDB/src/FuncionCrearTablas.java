import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class FuncionCrearTablas {
    /**
     * Funcion que crea TABLAS en la base de datos Persona
     * 
     * @param conn
     * @throws SQLException
     */
    public static void crearTabla(Connection conn, Scanner lector, Statement stmt) throws SQLException {
        String tabla = "";
        String nombreTabla = "";
        boolean funcionando = true;

        // QUERYS PARA CREAR TABLAS:
        String crearTablaUsuarios = "CREATE TABLE Usuarios (\n" + //
                "idUsuarios INT AUTO_INCREMENT PRIMARY KEY,\n" + //
                "Nombre VARCHAR (45),\n" + //
                "Apellidos VARCHAR (45),\n" + //
                "Username VARCHAR(12),\n" + //
                "Password VARCHAR(128),\n" + //
                "email VARCHAR (50)\n" + //
                ");";

        String crearTablaPosts = "CREATE TABLE Posts (\n" + //
                "idPost INT AUTO_INCREMENT PRIMARY KEY,\n" + //
                "idUsuarios INT,\n" + //
                "created_at DATE,\n" + //
                "updated_at DATE,\n" + //
                "CONSTRAINT fk_idUsuarios FOREIGN KEY (idUsuarios) REFERENCES Usuarios(idUsuarios) ON UPDATE CASCADE\n" + //
                ");";

        String crearTablaLikes = "CREATE TABLE Likes (\n" + //
                "idLikes INT AUTO_INCREMENT PRIMARY KEY,\n" + //
                "idUsuarios INT,\n" + //
                "idPost INT,\n" + //
                "CONSTRAINT fk_idPost FOREIGN KEY (idPost) REFERENCES Posts(idPost) ON UPDATE CASCADE,\n" + //
                "CONSTRAINT fk_idUsuario FOREIGN KEY (idUsuarios) REFERENCES Usuarios(idUsuarios) ON UPDATE CASCADE\n" + //
                ");";

        try {
            stmt = conn.createStatement();
            int respuestaUser = 0;
            do{
                Pintar.menuCrearTablaOpcionPrincipal();
                respuestaUser = lector.nextInt();
                if (respuestaUser == 1) {
                    Pintar.menuCrearTablaSeleccionada();
                    respuestaUser = lector.nextInt();
                    switch (respuestaUser) {
                        case 1:
                            tabla = crearTablaUsuarios;
                            nombreTabla = "Usuarios";
                            funcionando = false;
                            break;
                        case 2:
                            tabla = crearTablaPosts;
                            nombreTabla = "Posts";
                            funcionando = false;
                            break;
                        case 3:
                            tabla = crearTablaLikes;
                            nombreTabla = "Likes";
                            funcionando = false;
                            break;
                        default:
                            System.out.println("Tienes que introducir un Nº valido.");
                            break;
                    }
                    stmt.executeUpdate(tabla); // HACERLA BIEN
                    System.out.println("TABLA CREADA CORRECTAMENTE: " + nombreTabla);

                } else if (respuestaUser == 2) {
                    stmt.executeUpdate(crearTablaUsuarios);
                    System.out.println("TABLA Usuarios CREADA CORRECTAMENTE");
                    stmt.executeUpdate(crearTablaPosts);
                    System.out.println("TABLA Posts CREADA CORRECTAMENTE");
                    stmt.executeUpdate(crearTablaLikes);
                    System.out.println("TABLA Likes CREADA CORRECTAMENTE");

                } else if (respuestaUser == 3) {
                    funcionando = false;
                } else {
                    System.out.println("Opción no válida, vuelve a intentarlo.");
                }

            }while (funcionando);
        } catch (SQLException sqlConnectException) {
            sqlConnectException.getMessage(); // Para que me de el mensaje y posteriormente tratar el numero
            System.out.println("Ha ocurrido un error de conexion a la DATABASE: " + sqlConnectException);
            

        } finally {
            conn.close();
            stmt.close();
            lector.close();
        }

    }
}

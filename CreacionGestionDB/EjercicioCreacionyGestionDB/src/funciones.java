import java.io.Console;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;

public class funciones {
    public static void main(String[] args) throws SQLException {

        // crearTabla(conectar());
        

    }

    

    

    /**
     * Funcion que inserta los datos en una tabla específica (Usuarios, Posts o
     * Likes)
     * 
     * @param conn
     * @throws SQLException
     */
    public static void insertarDatos(Connection conn) throws SQLException {
        Scanner lector = new Scanner(System.in);

        // Variables Usuarios
        PreparedStatement pstmt = null;
        String usuarioNombre = "";
        String usuarioApellidos = "";
        String usuarioUsername = "";
        String usuarioPassword = "";
        String usuarioEmail = "";
        // Variables Posts
        int postIdUsuarios = 0;
        String formato = "2024-12-04";
        Date postCreate_at = Date.valueOf(formato);
        Date postUpdated_at = Date.valueOf(formato);
        // Variables Likes
        int likesIdLikes = 0;
        int likesIdUsuarios = 0;
        int likesIdPost = 0;

        // QUERYS PARA INSERTAR DATOS:

        String insertarUsuarios = String.format(
                "INSERT INTO Usuarios (Nombre, Apellidos, Username, Password, email) VALUES (?, ?, ?, ?, ? );");
        String insertarPost = ("INSERT INTO Posts (idUsuarios, created_at, updated_at) VALUES (?, ?, ?);");
        String insertarLikes = ("INSERT INTO Likes (idLikes, idUsuarios, idPost) VALUES ("
                + likesIdLikes + ", " + likesIdUsuarios + ", "
                + likesIdPost + ");");

        // Condición para el bucle while
        boolean funcionando = true;
        try {
            conn = conectar();
            while (funcionando) { //! PASAR TODO LOS ENTRYS A LA CLASE 
                Pintar.menuInsertarDatos();
                int respuestaUser = lector.nextInt();
                lector.nextLine();
                System.out.println("Deberas introducir los siguientes datos: ");
                switch (respuestaUser) {
                    case 1:
                        System.out.print("Nombre: ");
                        usuarioNombre = lector.nextLine();
                        System.out.print("Apellidos: ");
                        usuarioApellidos = lector.nextLine();
                        System.out.print("Username: ");
                        usuarioUsername = lector.nextLine();
                        Console console = System.console();

                        // ESTO HACE QUE NO SALGA NADA AL INTRODUCIR LA CONTRASEÑA EN LA TERMINAL ( PERO
                        // SI SE ALMACENA EN LA VARIABLE "usuarioPassword")
                        char[] passwordArray = console.readPassword("Introduce tu contraseña: ");
                        usuarioPassword = new String(passwordArray); // Convertir el array de caracteres a un String si
                                                                     // es necesario
                        Arrays.fill(passwordArray, ' '); // Por seguridad, limpia el array después de usarlo
                        System.out.println("Contraseña capturada de forma segura.");

                        System.out.print("Email: ");
                        usuarioEmail = lector.nextLine();
                        Usuario paraInsertarUsuarios = new Usuario(usuarioNombre, usuarioApellidos, usuarioUsername,
                                usuarioPassword, usuarioEmail);

                        // PREPARAMOS EL PreparedStatement
                        // ---------------------------------
                        pstmt = conn.prepareStatement(insertarUsuarios);
                        pstmt.setString(1, paraInsertarUsuarios.getNombre());
                        pstmt.setString(2, paraInsertarUsuarios.getApellidos());
                        pstmt.setString(3, paraInsertarUsuarios.getUsername());
                        pstmt.setString(4, paraInsertarUsuarios.getPassword());
                        pstmt.setString(5, paraInsertarUsuarios.getEmail());
                        
                        pstmt.executeUpdate(); // Sin esto no ejecuta
                        System.out.println("Has introducido al usuario con exito!");
                        break;
                    case 2:
                        System.out.print("Escribe el ID del usuario que hizo el Post: ");
                        postIdUsuarios = lector.nextInt();
                        lector.nextLine(); // Limpiamos el caché del Scanner
                        System.out.print("Inserta la fecha de creacion del archivo (formato: yyyy-mm-dd): ");
                        postCreate_at = Date.valueOf(lector.nextLine());
                        System.out.print("Inserta la fecha de actualización del archivo (formato: yyyy-mm-dd): ");
                        postUpdated_at = Date.valueOf(lector.nextLine());
                        lector.nextLine();

                        // PREPARAMOS EL "PreparedStatement"
                        // --------------------------------
                        Posts paraInsertarPost = new Posts(postIdUsuarios, postCreate_at, postUpdated_at);
                        
                        pstmt = conn.prepareStatement(insertarPost);
                        pstmt.setInt(1, paraInsertarPost.getIdUsuarios());
                        pstmt.setDate(2, paraInsertarPost.getCreated_at());
                        pstmt.setDate(3, paraInsertarPost.getUpdated_at());
                        pstmt.executeUpdate(); // Sin esto no ejecuta

                        break;
                    case 3:


                        Likes paraInsertarLikes = new Likes(likesIdLikes , likesIdUsuarios, likesIdPost);

                        pstmt = conn.prepareStatement(insertarLikes);
                        pstmt.setInt(1, paraInsertarLikes.getIdLikes());
                        pstmt.setInt(2, paraInsertarLikes.getIdUsuarios());
                        pstmt.setInt(3, paraInsertarLikes.getIdPost());
                        pstmt.executeUpdate(); // Sin esto no ejecuta

                        break;
                    case 4:
                        funcionando = false;
                        break;
                    default:
                        break;
                }
                // PARA CREAR MODELO DE QUERY podria usar un Switch con una variable llamada
                // tipoConsulta, que dependiendo

            }
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error en la conexión con la DB: " + e);
        }

    }
}

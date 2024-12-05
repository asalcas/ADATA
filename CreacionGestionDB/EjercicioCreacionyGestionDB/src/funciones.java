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
        insertarDatos(conectar());

    }

    /**
     * Funcion que se encarga de conectarse a la base de datos
     * ad2425_alvaro_salvador
     * 
     * @return Connection conn
     * @throws SQLException
     */
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
            System.out.println("Se ha establecido la conexion con la DB\n=======================================");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classError) {
            classError.printStackTrace();
        }
        return conn;
    }

    /**
     * Funcion que crea TABLAS en la base de datos Persona
     * 
     * @param conn
     * @throws SQLException
     */
    public static void crearTabla(Connection conn) throws SQLException {
        Statement stmt = null;
        Scanner lector = new Scanner(System.in);
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
                "CONSTRAINT fk_idUsuarios FOREIGN KEY (idUsuarios) REFERENCES Usuarios(idUsuarios)\n" + //
                ");";

        String crearTablaLikes = "CREATE TABLE Likes (\n" + //
                "idLikes INT AUTO_INCREMENT PRIMARY KEY,\n" + //
                "idUsuarios INT,\n" + //
                "idPost INT,\n" + //
                "CONSTRAINT fk_idPost FOREIGN KEY (idPost) REFERENCES Posts(idPost),\n" + //
                "CONSTRAINT fk_idUsuario FOREIGN KEY (idUsuarios) REFERENCES Usuarios(idUsuarios)\n" + //
                ");";

        try {
            conn = conectar();
            stmt = conn.createStatement();
            int respuestaUser = 0;
            while (funcionando) {
                System.out.println("================================================");
                System.out.println("|  ¿Quieres crear una tabla o todas a la vez?  |");
                System.out.println("================================================");
                System.out.println("1. Una a una");
                System.out.println("2. Todas");
                System.out.println("3. Salir");
                System.out.println("Escribe el Nº: ");
                System.out.print("Tu respuesta: ");

                respuestaUser = lector.nextInt();
                if (respuestaUser == 1) {
                    System.out.println("===============================");
                    System.out.println("|  ¿Que tabla quieres crear?  |");
                    System.out.println("===============================");
                    System.out.println("Recuerda que debes crear las tablas en orden:");
                    System.out.println("ATENCION, el orden debe ser: 1º Usuarios, 2º Posts y 3º la tabla Likes");
                    System.out.println("1. Usuarios");
                    System.out.println("2. Posts");
                    System.out.println("3. Likes");
                    System.out.println("Escribe el Nº: ");
                    System.out.print("Tu respuesta: ");
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

            }
        } catch (SQLException sqlConnectException) {
            System.out.println("Ha ocurrido un error de conexion a la DATABASE: " + sqlConnectException);

        } finally {
            conn.close();
            stmt.close();
            lector.close();
        }

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
                System.out.println("===========================================");
                System.out.println("|  ¿En que tabla quieres insertar datos?  |");
                System.out.println("===========================================");
                System.out.println("1. Usuarios");
                System.out.println("2. Posts");
                System.out.println("3. Likes");
                System.out.println("4. SALIR");
                System.out.println("Escribe el Nº:  ");
                System.out.print("Tu respuesta: ");
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
                    case 3:
                        // TODO LIKES 2 campso
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

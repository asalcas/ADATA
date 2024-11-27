package selectsparadb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import ejercicioconexionprofesor.ConexionPcProfesor;

class FuncionesSelect {

    public static void main(String[] args) {
        boolean funcionando = true;
        while (funcionando) {
            try {
                Scanner lector = new Scanner(System.in);
                System.out.println("\n=======================================");
                System.out.println("==        ¿Que quieres hacer?        ==");
                System.out.println("=======================================");
                System.out.println("1. Enseña la tabla.");
                System.out.println("2. SELECT de PERSONA ordenados por Edad.");
                System.out.println("3. SELECT de PERSONA ordenados por Apellido.");
                System.out.println("4. SELECT de PERSONA mayores de 30 Anyos.");
                System.out.println("5. SELECT de PERSONA Nombre Comienza por J y ordenados por Apellido.");
                System.out.println("6. SELECT de PERSONA Nombre Comienza por C y Apellido por A.");
                System.out.println("7. SELECT de PERSONA que saca 'media_edad'.");
                System.out.println("8. SELECT de PERSONA que saque Apellido cuando comience por Oh/Ma.");
                System.out.println("9. SELECT de PERSONA con Edad entre 24-32.");
                System.out.println("10. SELECT de PERSONA con Edad > 65.");
                System.out.println("11. ALTER TABLE añadir Columna 'laboral'.");
                System.out.println("12. UPDATE registros de PERSONA segun su edad'.");
                System.out.println("0. SALIR.");

                System.out.println("\nPara seleccionar una opción pon el Nº: ");
                int opcionUser = lector.nextInt();

                switch (opcionUser) {
                    case 0:
                        funcionando = false;
                        break;
                    case 1:
                        mostrarTabla();
                        break;
                    case 2:
                        selectPorEdad();
                        break;
                    case 3:
                        selectPorApellidos();
                        break;
                    case 4:
                        selectPersonasMayor30();
                        break;
                    case 5:
                        selectJOrderApellidos();
                        break;
                    case 6:
                        selectNombresCApellidosA();
                        break;
                    case 7:
                        selectMediaEdad();
                        break;
                    case 8:
                        selectApellidosOHMA();
                        break;
                    case 9:
                        listadoPersonasEntre24y32();
                        break;
                    case 10:
                        listadoPersonasMAYORES65();
                        break;
                    case 11:
                        alterTables();
                        break;
                    case 12:
                        actualizarLaboral();
                        break;

                    default:
                        break;

                }
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error inesperado: " + e);

            }

        }

    }

    // Función que añadirá insertará valores a "laboral" donde según las condiciones
    // ('estudiante', 'jubilado', 'parado' o 'ocupado')
    public static void actualizarLaboral() {
        Connection conn = null;
        Statement stmt = null;
        // UPDATE
        String consulta = "UPDATE PERSONA SET laboral = CASE WHEN edad<18 THEN 'estudiante' WHEN edad >65 THEN 'jubilado' WHEN edad %2 != 0 THEN 'parado' ELSE 'ocupado' END;";
        try {
            conn = ConexionPcProfesor.conexionJDBC(); // Conexión
            stmt = conn.createStatement(); // Statement para realizar la ejecución
            stmt.executeUpdate(consulta); // Ejecución
            System.out.println("TABLA ALTERADA");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Función que añadirá una columna más a PERSONA
    // llamado "laboral"
    public static void alterTables() {

        Connection conn = null;
        Statement stmt = null;

        String consulta = "ALTER TABLE PERSONA ADD COLUMN laboral VARCHAR(20);"; // Consulta
        try {
            conn = ConexionPcProfesor.conexionJDBC(); // Conexion
            stmt = conn.createStatement(); // Objeto Statement que permite la ejecución
            stmt.executeUpdate(consulta); // Ejecución
            System.out.println("TABLA ALTERADA");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Función que devolverá el resultado de una Query de PERSONA que traerá
    // (IdPersona, Nombre, DniPersona, Edad) de PERSONA mayores a 65 años (0)
    public static void listadoPersonasMAYORES65() {
        Connection conn = null;
        Statement stmt = null;

        String consulta = "SELECT * FROM PERSONA WHERE Edad > 65;"; // ! NO TENGO APELLIDOS
        try {
            conn = ConexionPcProfesor.conexionJDBC(); // Conexion
            stmt = conn.createStatement(); // Objeto Statement que permite la ejecución
            ResultSet rs = stmt.executeQuery(consulta); // Ejecución
            System.out.println("Resultados de la consulta: ");
            while (rs.next()) {
                // Datos obtenidos: (IdPersona, Nombre, DniPersona, Edad)
                int id = rs.getInt("IdPersona");
                String nombre = rs.getString("Nombre");
                String dni = rs.getString("DniPersona");
                String apellido = rs.getString("Apellido");
                int edad = rs.getInt("Edad");
                // String apellido = rs.getString("Apellido");
                System.out.printf("ID: %d, Nombre: %s, Dni: %s, Edad: %d, Apellido: %s%n", id, nombre, dni, edad,
                        apellido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Función que devolverá el resultado de una Query de PERSONA que traerá
    // (IdPersona, Nombre, DniPersona, Edad) de PERSONA con Edad entre 24-32
    public static void listadoPersonasEntre24y32() {
        Connection conn = null;
        Statement stmt = null;

        String consulta = "SELECT * FROM PERSONA WHERE Edad BETWEEN 24 AND 32;";
        try {
            conn = ConexionPcProfesor.conexionJDBC(); // Conexion
            stmt = conn.createStatement(); // Objeto Statement que hace posible la ejecución
            ResultSet rs = stmt.executeQuery(consulta); // Ejecución
            System.out.println("Resultados de la consulta: ");
            while (rs.next()) {
                // Datos extraidos (IdPersona, Nombre, DniPersona, Edad,)
                int id = rs.getInt("IdPersona");
                String nombre = rs.getString("Nombre");
                String dni = rs.getString("DniPersona");
                String apellido = rs.getString("Apellido");
                int edad = rs.getInt("Edad");
                System.out.printf("ID: %d, Nombre: %s, Dni %s, Edad: %d, Apellido; %s%n", id, nombre, dni, edad,
                        apellido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Función que devolverá el resultado de una Query de PERSONA que traerá los
    // Apellidos cuando empiecen por Oh / Ma
    public static void selectApellidosOHMA() {
        Connection conn = null;
        Statement stmt = null;

        String consulta = "SELECT apellido FROM PERSONA WHERE Apellido LIKE 'oh%' OR Apellido LIKE 'ma%';";
        try {
            conn = ConexionPcProfesor.conexionJDBC(); // Conexión
            stmt = conn.createStatement(); // Objeto Statement para ejecutar las consultas
            ResultSet rs = stmt.executeQuery(consulta); // Ejecución de la consulta
            System.out.println("Resultados de la consulta: ");
            while (rs.next()) {
                // Datos extraidos (Apellido)
                String apellido = rs.getString("Apellido");
                System.out.printf("Apellido: %s%n", apellido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Función que devolverá el resultado de una Query de PERSONA que traerá la
    // media de edad de toda la tabla
    public static void selectMediaEdad() {
        Connection conn = null;
        Statement stmt = null;

        String consulta = "SELECT AVG(Edad) AS media_edad FROM PERSONA;";
        try {
            conn = ConexionPcProfesor.conexionJDBC(); // Conexion
            stmt = conn.createStatement(); // Objeto para ejecutar query
            ResultSet rs = stmt.executeQuery(consulta); // Ejecución
            System.out.println("Resultados de la consulta: ");
            while (rs.next()) {
                // Datos extraidos (media_edad)
                int media_edad = rs.getInt("media_edad");
                System.out.printf("Media Edad: %d%n", media_edad);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Función que devolverá el resultado de una Query de PERSONA que traerá Nombre,
    // Apellido y Edad
    // cuando Nombre empiece por C y apellido empiece por A
    public static void selectNombresCApellidosA() {
        Connection conn = null;
        Statement stmt = null;

        String consulta = "SELECT Nombre, Apellido, Edad FROM PERSONA WHERE nombre LIKE 'C%' AND apellido LIKE 'A%' ORDER BY edad DESC;";
        try {
            conn = ConexionPcProfesor.conexionJDBC(); // Conexion
            stmt = conn.createStatement(); // Objeto para ejecutar
            ResultSet rs = stmt.executeQuery(consulta);
            System.out.println("Resultados de la consulta: ");
            // Datos a sacar (Nombre, Apellido, Edad)
            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                int edad = rs.getInt("Edad");
                System.out.printf("Nombre: %s, Apellido: %s, Edad: %d%n", nombre, apellido, edad);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Función que devolverá el resultado de una Query de PERSONA que traerá Nombre
    // y Apellido
    // de las personas cuando Nombre empiece por J y se ordene por Apellido
    public static void selectJOrderApellidos() {
        Connection conn = null;
        Statement stmt = null;

        String consulta = "SELECT Nombre, Apellido FROM PERSONA WHERE Nombre LIKE 'J%' ORDER BY apellido;";
        try {
            conn = ConexionPcProfesor.conexionJDBC(); // Conexion
            stmt = conn.createStatement(); // Objeto Statement para ejecutar las Query
            ResultSet rs = stmt.executeQuery(consulta); // Ejecutamos
            System.out.println("Resultados de la consulta: ");
            while (rs.next()) {
                // Sacamos los datos (Nombre, Apellido)
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                System.out.printf("Nombre: %s, Apellido: %s%n", nombre, apellido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Función que devolverá el resultado de una Query de PERSONA que traerá Nombre
    // y Apellido
    // de las personas MAYORES a 30 años
    public static void selectPersonasMayor30() {
        Connection conn = null;
        Statement stmt = null;

        String consulta = "SELECT Nombre, Apellido FROM PERSONA WHERE Edad > 30;"; // Consulta
        try {
            conn = ConexionPcProfesor.conexionJDBC(); // Conexion
            stmt = conn.createStatement(); // Objeto para hacer la consulta
            ResultSet rs = stmt.executeQuery(consulta); // Ejecución
            System.out.println("Resultados de la consulta: ");
            while (rs.next()) {
                // Datos a recoger (Nombre, Apellido)
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");

                System.out.printf("Nombre: %s, Apellido: %s%n", nombre, apellido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Función que devolverá el resultado de una Query de PERSONA que traerá Nombre
    // y Apellido
    // ordenado por Apellido
    public static void selectPorApellidos() {
        Connection conn = null;
        Statement stmt = null;
        String consulta = "SELECT Nombre, Apellido FROM PERSONA ORDER BY Apellido;"; // Consulta
        try {
            conn = ConexionPcProfesor.conexionJDBC(); // Conexión
            stmt = conn.createStatement(); // Objeto para realizar Consultas
            ResultSet rs = stmt.executeQuery(consulta); // Ejecutamos la consulta
            System.out.println("Resultados de la consulta: ");
            while (rs.next()) {
                // Datos a extraer (Nombre, Apellido)
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");

                System.out.printf("Nombre: %s, Apellido: %s%n", nombre, apellido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Función que devolverá el resultado de una Query de PERSONA ordenado por
    // "edad"
    public static void selectPorEdad() {

        Connection conn = null; // Solo lo declaramos por que ya tenemos establecida la conexion en otra tabla
                                // que la traemos con un import
        Statement stmt = null;
        String consulta = "SELECT * FROM PERSONA ORDER BY edad;"; // Consulta
        try {
            conn = ConexionPcProfesor.conexionJDBC(); // Conexion
            stmt = conn.createStatement(); // Objeto Statement para realizar la consulta
            ResultSet rs = stmt.executeQuery(consulta); // Ejecuta la variable consulta
            System.out.println("Resultados de la consulta: ");
            while (rs.next()) {
                // Saca la información de los registros: (IdPersona, Nombre, DniPersona, Edad,
                // Apellido)
                int id = rs.getInt("IdPersona");
                String nombre = rs.getString("Nombre");
                String dni = rs.getString("DniPersona");
                String apellido = rs.getString("Apellido");
                int edad = rs.getInt("Edad");

                System.out.printf("ID: %d, Nombre: %s, Dni %s, Edad: %d, Apellido: %s%n", id, nombre, dni, edad,
                        apellido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void mostrarTabla() { // Lo que hace esta función, es enseñarnos que TABLAS TENEMOS.
        Connection conn = null;
        Statement stmt = null;
        String consulta = "SHOW TABLES;"; // ESTA ES LA QUERY para poder ver que tablas tenemos (Como tenemos 1 solo,
                                          // siempre nos dará la misma)
        try {
            conn = ConexionPcProfesor.conexionJDBC(); // Establecemos la conexión
            stmt = conn.createStatement(); // Usamos el objeto para enviar las consultas más adelante
            ResultSet rs = stmt.executeQuery(consulta); // Ejecutamos la Query que está guardado en la variable
                                                        // "consulta"
            System.out.println("Resultados de la consulta: ");
            while (rs.next()) { // Mientras el ResultSet lea contenido, seguirá ejecutando
                String tabla = rs.getString(1); // Lee el indice 1 de las TABLAS (Su nombre)
                System.out.printf("- " + tabla);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

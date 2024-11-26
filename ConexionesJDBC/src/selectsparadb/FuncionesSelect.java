package selectsparadb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ejercicioConexionProfesor.ConexionPcProfesor;

class FuncionesSelect {

    public static void main(String[] args) {

        //TODO ELIGE QUE METODO LLAMAR :)

    }

    public static void actualizarLaboral() {

    Connection conn = null;
    Statement stmt = null;

    String consulta = "UPDATE PERSONA SET laboral = CASE WHEN edad<18 THEN 'estudiante' WHEN edad >65 THEN 'jubilado' WHEN edad %2 != 0 THEN 'parado' ELSE 'ocupado' END;";
    try{
        conn = ConexionPcProfesor.conexionJDBC();
        stmt = conn.createStatement();
        stmt.executeUpdate(consulta);
        System.out.println("TABLA ALTERADA");
        

    } catch (SQLException e) {
        e.printStackTrace();
        }
    }

    public static void alterTables(){

        Connection conn = null;
        Statement stmt = null;

        String consulta = "ALTER TABLE PERSONA ADD COLUMN laboral VARCHAR(20);";
        try{
            conn = ConexionPcProfesor.conexionJDBC();
            stmt = conn.createStatement();
            stmt.executeUpdate(consulta);
            System.out.println("TABLA ALTERADA");
            

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void listadoPersonasMAYORES65(){
        Connection conn = null;
        Statement stmt = null;

        String consulta = "SELECT * FROM PERSONA WHERE Edad > 65;"; //! NO TENGO APELLIDOS
        try{
            conn = ConexionPcProfesor.conexionJDBC();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
            System.out.println("Resultados de la consulta: ");
            while (rs.next()) {
                int id = rs.getInt("IdPersona");
                String nombre = rs.getString("Nombre");
                String dni = rs.getString("DniPersona");
                String apellido = rs.getString("Apellido");
                int edad= rs.getInt("Edad");
                //String apellido = rs.getString("Apellido");
                System.out.printf("ID: %d, Nombre: %s, Dni: %s, Edad: %d, Apellido: %s%n", id, nombre, dni, edad, apellido); 
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void listadoPersonasEntre24y32(){
        Connection conn = null;
        Statement stmt = null;

        String consulta = "SELECT * FROM PERSONA WHERE Edad BETWEEN 24 AND 32;"; //! NO TENGO APELLIDOS
        try{
            conn = ConexionPcProfesor.conexionJDBC();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
            System.out.println("Resultados de la consulta: ");
            while (rs.next()) {
                int id = rs.getInt("IdPersona");
                String nombre = rs.getString("Nombre");
                String dni = rs.getString("DniPersona");
                String apellido = rs.getString("Apellido");
                int edad= rs.getInt("Edad");
                //String apellido = rs.getString("Apellido");
                System.out.printf("ID: %d, Nombre: %s, Dni %s, Edad: %d, Apellido; %s%n", id, nombre, dni, edad, apellido); 
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void selectApellidosOHMA(){
        Connection conn = null;
        Statement stmt = null;

        String consulta = "SELECT apellido FROM PERSONA WHERE Apellido LIKE '%oh% OR Apellido LIKE '%ma%;"; //! NO TENGO APELLIDOS
        try{
            conn = ConexionPcProfesor.conexionJDBC();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
            System.out.println("Resultados de la consulta: ");
            while (rs.next()) {
                String apellido = rs.getString("Apellido");
                System.out.printf("Apellido: %s%n", apellido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void selectMediaEdad(){
        Connection conn = null;
        Statement stmt = null;

        String consulta = "SELECT AVG(Edad) AS media_edad FROM PERSONA;";
        try {          
            conn = ConexionPcProfesor.conexionJDBC();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
            System.out.println("Resultados de la consulta: ");
            while (rs.next()) {
                int media_edad = rs.getInt("media_edad");
                System.out.printf("Media Edad: %d%n", media_edad); 
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void selectNombresCApellidosA(){
        Connection conn = null; 
        Statement stmt = null; 

        String consulta = "SELECT Nombre, Apellido, Edad FROM PERSONA WHERE nombre LIKE 'C%' AND apellido LIKE 'A%' ORDER BY edad DESC;"; 
        //! NO FUNCIONA POR QUE NO TENGO APELLIDOS EN LA BASE DE DATOS, SE ME OLVIDÓ
        try {          
            conn = ConexionPcProfesor.conexionJDBC();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
            System.out.println("Resultados de la consulta: ");
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


    public static void selectJOrderApellidos(){
        Connection conn = null; 
        Statement stmt = null;

        String consulta = "SELECT Nombre, Apellido FROM PERSONA WHERE nombre LIKE 'J%' ORDER BY apellido;"; //! NO FUNCIONA POR QUE NO TENGO APELLIDOS EN LA BASE DE DATOS, SE ME OLVIDÓ
        try {          
            conn = ConexionPcProfesor.conexionJDBC();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
            System.out.println("Resultados de la consulta: ");
            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                System.out.printf("Nombre: %s, Apellido: %s%n", nombre, apellido); 
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }
    


    public static void selectPersonasMayor30(){
        Connection conn = null; 
        Statement stmt = null; 

        String consulta = "SELECT Nombre, Edad FROM PERSONA WHERE Edad > 30;"; //! NO FUNCIONA POR QUE NO TENGO APELLIDOS EN LA BASE DE DATOS, SE ME OLVIDÓ
        try {                           //, sería apellido en vez de edad
            conn = ConexionPcProfesor.conexionJDBC();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
            System.out.println("Resultados de la consulta: ");
            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");


                System.out.printf("Nombre: %s, Apellido: %s%n", nombre, apellido); //! NO EXISTE APELLIDO AUN
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }



    public static void selectPorApellidos() {
        Connection conn = null; // Declaramos el objeto Conexion llamado conn en "null"
        Statement stmt = null; // Declaramos el objeto Statement llamado stmt en "null"
        String consulta = "SELECT Nombre, apellidos FROM PERSONA ORDER BY apellido;"; //! NO FUNCIONA POR QUE NO TENGO APELLIDOS EN LA BASE DE DATOS, SE ME OLVIDÓ
        try {
            conn = ConexionPcProfesor.conexionJDBC();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
            System.out.println("Resultados de la consulta: ");
            while (rs.next()) {
                int id = rs.getInt("IdPersona");
                String nombre = rs.getString("Nombre");
                String dni = rs.getString("DniPersona");
                String apellido = rs.getString("Apellido");
                int edad = rs.getInt("Edad");

                System.out.printf("ID: %d, Nombre: %s, Dni %s, Edad: %d, Apellido: %s%n", id, nombre, dni, edad, apellido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }

    public static void selectPorEdad() {

        
        Connection conn = null;
        Statement stmt = null; 
        String consulta = "SELECT * FROM PERSONA ORDER BY edad;";
        try {
            conn = ConexionPcProfesor.conexionJDBC();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
            System.out.println("Resultados de la consulta: ");
            while (rs.next()) {
                int id = rs.getInt("IdPersona");
                String nombre = rs.getString("Nombre");
                String dni = rs.getString("DniPersona");
                String apellido = rs.getString("Apellido");
                int edad = rs.getInt("Edad");

                System.out.printf("ID: %d, Nombre: %s, Dni %s, Edad: %d, Apellido: %s%n", id, nombre, dni, edad, apellido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarTabla() {
        Connection conn = null;
        Statement stmt = null;
        String consulta = "SHOW TABLES;";
        try {
            conn = ConexionPcProfesor.conexionJDBC();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
            System.out.println("Resultados de la consulta: ");
            while (rs.next()) {
                String tabla = rs.getString(1);
                System.out.printf("- " + tabla);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

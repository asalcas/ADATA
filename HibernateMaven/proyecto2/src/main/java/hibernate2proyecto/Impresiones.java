package hibernate2proyecto;

public class Impresiones {
    public static void inicio(){
        System.out.println("---------------------------------------");
        System.out.println("-  ¡Bienvenido!, ¿Que quieres hacer?  -");
        System.out.println("---------------------------------------");
        System.out.println("1. Obtener datos."); // Por hacer
        System.out.println("2. Guardar datos."); // Por hacer
        System.out.println("3. Insertar datos."); // Por hacer
        System.out.println("4. Modificar datos."); // Por hacer
        System.out.println("0. SALIR."); 
    }
        
    public static void menuObtenerDatos(){
        System.out.println("---------------------------------------------------");
        System.out.println("-  Estás en Obtener Datos, seleccione una opción  -");
        System.out.println("---------------------------------------------------");
        System.out.println("1. Obtener datos de los Usuarios."); // Por hacer
        System.out.println("2. Obtener datos de los Post."); // Por hacer
        System.out.println("3. Obtener datos de los Likes."); // Por hacer
        System.out.println("0. SALIR."); //TODO
    }
    public static void menuObtenerDatosUsuarios(){
        System.out.println("---------------------------------------------------------");
        System.out.println("-  Obteniendo datos de Usuarios, seleccione una opción  -");
        System.out.println("---------------------------------------------------------");
        System.out.println("1. Obtener todos los Usuarios."); // Por hacer
        System.out.println("2. Obtener Usuarios por ID."); // Por hacer
        System.out.println("3. Obtener Usuarios por Nombre."); // Por hacer
        System.out.println("4. Obtener Usuarios por Apellidos."); // Por hacer
        System.out.println("5. Obtener Usuarios por Username."); // Por hacer
        System.out.println("6. Obtener Usuarios por Email."); // Por hacer
        System.out.println("0. SALIR."); 
    }
    
}


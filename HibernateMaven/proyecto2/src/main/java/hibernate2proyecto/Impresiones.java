package hibernate2proyecto;

public class Impresiones {
    public static void inicio() {
        System.out.println("---------------------------------------");
        System.out.println("-  ¡Bienvenido!, ¿Que quieres hacer?  -");
        System.out.println("---------------------------------------");
        System.out.println("1. Guardar datos."); // Por hacer
        System.out.println("2. Obtener datos."); // Por hacer
        System.out.println("3. Insertar datos."); // Por hacer
        System.out.println("4. Borrar datos."); // Por hacer
        System.out.println("0. SALIR.");
    }

    public static void guardarDatos() {
        System.out.println("---------------------------------------------------");
        System.out.println("-   Para guardar un Usuario debemos introducir:   -");
        System.out.println("---------------------------------------------------");
    }

    public static void menuObtenerDatos() {
        System.out.println("---------------------------------------------------");
        System.out.println("-  Estás en Obtener Datos, seleccione una opción  -");
        System.out.println("---------------------------------------------------");
        System.out.println("1. Obtener datos de los Usuarios."); // Por hacer
        System.out.println("2. Obtener datos de los Post."); // Por hacer
        System.out.println("3. Obtener datos de los Likes."); // Por hacer
        System.out.println("0. SALIR.");
    }

    public static void menuObtenerDatosUsuarios() {
        System.out.println("---------------------------------------------------------");
        System.out.println("-  Obteniendo datos de Usuarios, seleccione una opción  -");
        System.out.println("---------------------------------------------------------");
        System.out.println("1. Obtener todos los Usuarios.");
        System.out.println("2. Obtener Usuarios por ID.");
        System.out.println("3. Obtener Usuarios por Nombre.");
        System.out.println("4. Obtener Usuarios por Apellidos.");
        System.out.println("5. Obtener Usuarios por Username.");
        System.out.println("6. Obtener Usuarios por Email.");
        System.out.println("0. SALIR.");
    }

}

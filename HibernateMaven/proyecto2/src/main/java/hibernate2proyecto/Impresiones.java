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
    public static void menuGuardar() {

        System.out.println("---------------------------------------------------");
        System.out.println("-  Estás en Guardar Datos, seleccione una opción  -");
        System.out.println("---------------------------------------------------");
        System.out.println("1. Guardar datos de los Usuarios.");
        System.out.println("2. Guardar datos de los Post."); // Por hacer
        System.out.println("3. Guardar datos de los Likes."); // Por hacer
        System.out.println("0. SALIR.");

    }
    public static void guardarDatosUSUARIO() {
        System.out.println("---------------------------------------------------");
        System.out.println("-   Para guardar un Usuario debemos introducir:   -");
        System.out.println("---------------------------------------------------");
    }
    public static void guardarDatosPOST() {
        System.out.println("------------------------------------------------");
        System.out.println("-   Para guardar un Post debemos introducir:   -");
        System.out.println("------------------------------------------------");
    }
    public static void guardarDatosLikes() {
        System.out.println("------------------------------------------------");
        System.out.println("-   Para guardar un Like debemos introducir:   -");
        System.out.println("------------------------------------------------");
    }
    public static void menuObtenerDatos() {
        System.out.println("---------------------------------------------------");
        System.out.println("-  Estás en Obtener Datos, seleccione una opción  -");
        System.out.println("---------------------------------------------------");
        System.out.println("1. Obtener datos de los Usuarios.");
        System.out.println("2. Obtener datos de los Post."); // Por hacer
        System.out.println("3. Obtener datos de los Likes."); // Por hacer
        System.out.println("0. SALIR.");
    }

    public static void selectOperadores() {
        System.out.println("-----------------------------------------------------");
        System.out.println("-  ¿Que operacion realizar?, seleccione una opción  -");
        System.out.println("-----------------------------------------------------");
        System.out.println("1. Mayor o igual que (>=)");
        System.out.println("2. Menor o igual que (<=)");
        System.out.println("3. Igual que (=)");
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

    public static void menuObtenerDatosPost() {
        System.out.println("----------------------------------------------------------");
        System.out.println("-  Obteniendo datos de los Posts, seleccione una opción  -");
        System.out.println("----------------------------------------------------------");
        System.out.println("1. Obtener todos los Post.");
        System.out.println("2. Obtener Post por ID de Post.");
        System.out.println("3. Obtener Post por ID de Usuario.");
        System.out.println("4. Obtener Post por fecha de Creación.");
        System.out.println("5. Obtener Post por fecha de Actualización.");
        System.out.println("0. SALIR.");
    }



    public static void menuObtenerDatosLikes() {
        System.out.println("----------------------------------------------------------");
        System.out.println("-  Obteniendo datos de los Likes, seleccione una opción  -");
        System.out.println("----------------------------------------------------------");
        System.out.println("1. Obtener todos los Likes.");
        System.out.println("2. Obtener Likes por ID de Likes.");
        System.out.println("3. Obtener Likes por ID de Usuario.");
        System.out.println("4. Obtener Likes por ID de Post.");
        System.out.println("0. SALIR.");
    }

}

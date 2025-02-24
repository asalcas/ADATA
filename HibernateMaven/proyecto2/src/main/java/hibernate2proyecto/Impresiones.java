package hibernate2proyecto;

public class Impresiones {

    public static void inicio() {

        System.out.println("---------------------------------------");
        System.out.println("-  ¡Bienvenido!, ¿Que quieres hacer?  -");
        System.out.println("---------------------------------------");
        System.out.println("1. Guardar datos."); // Por hacer
        System.out.println("2. Obtener datos."); // Por hacer
        System.out.println("3. Actualizar datos."); // Por hacer
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
        System.out.println("2. Obtener datos de los Post.");
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

    public static void menuActualizar() {

        System.out.println("------------------------------------------------------");
        System.out.println("-  Estás en Actualizar Datos, seleccione una opción  -");
        System.out.println("------------------------------------------------------");
        System.out.println("1. Actualizar datos de los Usuarios.");
        System.out.println("2. Actualizar datos de los Post.");
        System.out.println("3. Actualizar datos de los Likes.");
        System.out.println("0. SALIR.");

    }

    public static void menuActualizarUsuario() {
        System.out.println("-----------------------------------------------------------");
        System.out.println("-  Actualizando datos de Usuarios, ¿Qué quieres cambiar?  -");
        System.out.println("-----------------------------------------------------------");
        System.out.println("1. Actualizar todo.");
        System.out.println("2. Actualizar Nombre.");
        System.out.println("3. Actualizar Apellidos.");
        System.out.println("4. Actualizar Username.");
        System.out.println("5. Actualizar Contraseña.");
        System.out.println("6. Actualizar Email.");
        System.out.println("0. SALIR.");
    }

    public static void menuActualizarPost() {
        System.out.println("-------------------------------------------------------");
        System.out.println("-  Actualizando datos de Post, ¿Qué quieres cambiar?  -");
        System.out.println("-------------------------------------------------------");
        System.out.println("1. Actualizar todo.");
        System.out.println("2. Actualizar ID del Usuario.");
        System.out.println("3. Actualizar Fecha de creación.");
        System.out.println("0. SALIR.");
    }

    public static void menuActualizarLikes() {
        System.out.println("--------------------------------------------------------");
        System.out.println("-  Actualizando datos de Likes, ¿Qué quieres cambiar?  -");
        System.out.println("--------------------------------------------------------");
        System.out.println("1. Actualizar todo.");
        System.out.println("2. Actualizar ID del Usuario.");
        System.out.println("3. Actualizar ID del Post.");
        System.out.println("0. SALIR.");
    }

    public static void menuBorrarDatos() {

        System.out.println("---------------------------------------------------");
        System.out.println("-  Borrado de datos, ¿Qué tabla quieres cambiar?  -");
        System.out.println("---------------------------------------------------");
        System.out.println("1. DELETE de Usuarios.");
        System.out.println("2. DELETE de Post.");
        System.out.println("3. DELETE de Likes.");
        System.out.println("0. SALIR.");

    }


    public static void menuSeleccionaTablaBorrar(String tabla) {

        System.out.println("----------------------------------------------------");
        System.out.println("-  Borrado de datos en "+tabla+", ¿Qué quieres hacer?  -");
        System.out.println("----------------------------------------------------");
        System.out.println("1. DELETE de toda la Tabla");
        System.out.println("2. DELETE de registros por ID de "+tabla+".");
        System.out.println("0. SALIR.");

    }
    public static void menuBorrarRegistros() {

        System.out.println("-----------------------------------------------------------------");
        System.out.println("-  Borrado de datos por ID, ¿Sbbre que tabla quieres trabajar?  -");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("1. DELETE registros por ID de Usuarios.");
        System.out.println("2. DELETE registros por ID de Post.");
        System.out.println("3. DELETE registros por ID de Likes.");
        System.out.println("0. SALIR.");

    }
}

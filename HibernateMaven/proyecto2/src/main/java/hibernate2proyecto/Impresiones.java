package hibernate2proyecto;

public class Impresiones {

    public static void inicio() {

        System.out.println(Colores.ANSI_CYAN + "---------------------------------------");
        System.out.println("-  ¡Bienvenido!, ¿Que quieres hacer?  -");
        System.out.println("---------------------------------------" + Colores.ANSI_RESET);
        System.out.println(Colores.ANSI_PURPLE + "1." + Colores.ANSI_RESET + " Guardar datos."); // Por hacer
        System.out.println(Colores.ANSI_PURPLE + "2." + Colores.ANSI_RESET + " Obtener datos."); // Por hacer
        System.out.println(Colores.ANSI_PURPLE + "3." + Colores.ANSI_RESET + " Actualizar datos."); // Por hacer
        System.out.println(Colores.ANSI_PURPLE + "4." + Colores.ANSI_RESET + " Borrar datos."); // Por hacer
        System.out.println(Colores.ANSI_PURPLE + "0." + Colores.ANSI_RESET + " SALIR.");
    }

    public static void menuGuardar() {

        System.out.println(Colores.ANSI_CYAN + "---------------------------------------------------");
        System.out.println("-  Estás en Guardar Datos, seleccione una opción  -");
        System.out.println("---------------------------------------------------" + Colores.ANSI_RESET);
        System.out.println(Colores.ANSI_PURPLE + "1." + Colores.ANSI_RESET + " Guardar datos de los Usuarios.");
        System.out.println(Colores.ANSI_PURPLE + "2." + Colores.ANSI_RESET + " Guardar datos de los Post."); // Por
                                                                                                             // hacer
        System.out.println(Colores.ANSI_PURPLE + "3." + Colores.ANSI_RESET + " Guardar datos de los Likes."); // Por
                                                                                                              // hacer
        System.out.println(Colores.ANSI_PURPLE + "0." + Colores.ANSI_RESET + " SALIR.");

    }

    public static void guardarDatosUSUARIO() {
        System.out.println(Colores.ANSI_CYAN + "---------------------------------------------------");
        System.out.println("-   Para guardar un Usuario debemos introducir:   -");
        System.out.println("---------------------------------------------------" + Colores.ANSI_RESET);
    }

    public static void guardarDatosPOST() {
        System.out.println(Colores.ANSI_CYAN + "------------------------------------------------");
        System.out.println("-   Para guardar un Post debemos introducir:   -");
        System.out.println("------------------------------------------------" + Colores.ANSI_RESET);
    }

    public static void guardarDatosLikes() {
        System.out.println(Colores.ANSI_CYAN + "------------------------------------------------");
        System.out.println("-   Para guardar un Like debemos introducir:   -");
        System.out.println("------------------------------------------------" + Colores.ANSI_RESET);
    }

    public static void menuObtenerDatos() {
        System.out.println(Colores.ANSI_CYAN + "---------------------------------------------------");
        System.out.println("-  Estás en Obtener Datos, seleccione una opción  -");
        System.out.println("---------------------------------------------------" + Colores.ANSI_RESET);
        System.out.println(Colores.ANSI_PURPLE + "1." + Colores.ANSI_RESET + " Obtener datos de los Usuarios.");
        System.out.println(Colores.ANSI_PURPLE + "2." + Colores.ANSI_RESET + " Obtener datos de los Post.");
        System.out.println(Colores.ANSI_PURPLE + "3." + Colores.ANSI_RESET + " Obtener datos de los Likes."); // Por
                                                                                                              // hacer
        System.out.println(Colores.ANSI_PURPLE + "0." + Colores.ANSI_RESET + " SALIR.");
    }

    public static void selectOperadores() {
        System.out.println(Colores.ANSI_CYAN + "-----------------------------------------------------");
        System.out.println("-  ¿Que operacion realizar?, seleccione una opción  -");
        System.out.println("-----------------------------------------------------" + Colores.ANSI_RESET);
        System.out.println(Colores.ANSI_PURPLE + "1." + Colores.ANSI_RESET + " Mayor o igual que (>=)");
        System.out.println(Colores.ANSI_PURPLE + "2." + Colores.ANSI_RESET + " Menor o igual que (<=)");
        System.out.println(Colores.ANSI_PURPLE + "3." + Colores.ANSI_RESET + " Igual que (=)");
    }

    public static void menuObtenerDatosUsuarios() {
        System.out.println(Colores.ANSI_CYAN + "---------------------------------------------------------");
        System.out.println("-  Obteniendo datos de Usuarios, seleccione una opción  -");
        System.out.println("---------------------------------------------------------" + Colores.ANSI_RESET);
        System.out.println(Colores.ANSI_PURPLE + "1." + Colores.ANSI_RESET + " Obtener todos los Usuarios.");
        System.out.println(Colores.ANSI_PURPLE + "2." + Colores.ANSI_RESET + " Obtener Usuarios por ID.");
        System.out.println(Colores.ANSI_PURPLE + "3." + Colores.ANSI_RESET + " Obtener Usuarios por Nombre.");
        System.out.println(Colores.ANSI_PURPLE + "4." + Colores.ANSI_RESET + " Obtener Usuarios por Apellidos.");
        System.out.println(Colores.ANSI_PURPLE + "5." + Colores.ANSI_RESET + " Obtener Usuarios por Username.");
        System.out.println(Colores.ANSI_PURPLE + "6." + Colores.ANSI_RESET + " Obtener Usuarios por Email.");
        System.out.println(Colores.ANSI_PURPLE + "0." + Colores.ANSI_RESET + " SALIR.");
    }

    public static void menuObtenerDatosPost() {
        System.out.println(Colores.ANSI_CYAN + "----------------------------------------------------------");
        System.out.println("-  Obteniendo datos de los Posts, seleccione una opción  -");
        System.out.println("----------------------------------------------------------" + Colores.ANSI_RESET);
        System.out.println(Colores.ANSI_PURPLE + "1." + Colores.ANSI_RESET + " Obtener todos los Post.");
        System.out.println(Colores.ANSI_PURPLE + "2." + Colores.ANSI_RESET + " Obtener Post por ID de Post.");
        System.out.println(Colores.ANSI_PURPLE + "3." + Colores.ANSI_RESET + " Obtener Post por ID de Usuario.");
        System.out.println(Colores.ANSI_PURPLE + "4." + Colores.ANSI_RESET + " Obtener Post por fecha de Creación.");
        System.out
                .println(Colores.ANSI_PURPLE + "5." + Colores.ANSI_RESET + " Obtener Post por fecha de Actualización.");
        System.out.println(Colores.ANSI_PURPLE + "0." + Colores.ANSI_RESET + " SALIR.");
    }

    public static void menuObtenerDatosLikes() {
        System.out.println(Colores.ANSI_CYAN + "----------------------------------------------------------");
        System.out.println("-  Obteniendo datos de los Likes, seleccione una opción  -");
        System.out.println("----------------------------------------------------------" + Colores.ANSI_RESET);
        System.out.println(Colores.ANSI_PURPLE + "1. " + Colores.ANSI_RESET + "Obtener todos los Likes.");
        System.out.println(Colores.ANSI_PURPLE + "2. " + Colores.ANSI_RESET + "Obtener Likes por ID de Likes.");
        System.out.println(Colores.ANSI_PURPLE + "3. " + Colores.ANSI_RESET + "Obtener Likes por ID de Usuario.");
        System.out.println(Colores.ANSI_PURPLE + "4. " + Colores.ANSI_RESET + "Obtener Likes por ID de Post.");
        System.out.println(Colores.ANSI_PURPLE + "0. " + Colores.ANSI_RESET + "SALIR.");
    }

    public static void menuActualizar() {

        System.out.println(Colores.ANSI_CYAN + "------------------------------------------------------");
        System.out.println("-  Estás en Actualizar Datos, seleccione una opción  -");
        System.out.println("------------------------------------------------------" + Colores.ANSI_RESET);
        System.out.println(Colores.ANSI_PURPLE + "1." + Colores.ANSI_RESET + " Actualizar datos de los Usuarios.");
        System.out.println(Colores.ANSI_PURPLE + "2." + Colores.ANSI_RESET + " Actualizar datos de los Post.");
        System.out.println(Colores.ANSI_PURPLE + "3." + Colores.ANSI_RESET + " Actualizar datos de los Likes.");
        System.out.println(Colores.ANSI_PURPLE + "0." + Colores.ANSI_RESET + " SALIR.");

    }

    public static void menuActualizarUsuario() {
        System.out.println(Colores.ANSI_CYAN + "-----------------------------------------------------------");
        System.out.println("-  Actualizando datos de Usuarios, ¿Qué quieres cambiar?  -");
        System.out.println("-----------------------------------------------------------" + Colores.ANSI_RESET);
        System.out.println(Colores.ANSI_PURPLE + "1." + Colores.ANSI_RESET + " Actualizar todo.");
        System.out.println(Colores.ANSI_PURPLE + "2." + Colores.ANSI_RESET + " Actualizar Nombre.");
        System.out.println(Colores.ANSI_PURPLE + "3." + Colores.ANSI_RESET + " Actualizar Apellidos.");
        System.out.println(Colores.ANSI_PURPLE + "4." + Colores.ANSI_RESET + " Actualizar Username.");
        System.out.println(Colores.ANSI_PURPLE + "5." + Colores.ANSI_RESET + " Actualizar Contraseña.");
        System.out.println(Colores.ANSI_PURPLE + "6." + Colores.ANSI_RESET + " Actualizar Email.");
        System.out.println(Colores.ANSI_PURPLE + "0." + Colores.ANSI_RESET + " SALIR.");
    }

    public static void menuActualizarPost() {
        System.out.println(Colores.ANSI_CYAN + "-------------------------------------------------------");
        System.out.println("-  Actualizando datos de Post, ¿Qué quieres cambiar?  -");
        System.out.println("-------------------------------------------------------" + Colores.ANSI_RESET);
        System.out.println(Colores.ANSI_PURPLE + "1." + Colores.ANSI_RESET + " Actualizar todo.");
        System.out.println(Colores.ANSI_PURPLE + "2." + Colores.ANSI_RESET + " Actualizar ID del Usuario.");
        System.out.println(Colores.ANSI_PURPLE + "3." + Colores.ANSI_RESET + " Actualizar Fecha de creación.");
        System.out.println(Colores.ANSI_PURPLE + "0." + Colores.ANSI_RESET + " SALIR.");
    }

    public static void menuActualizarLikes() {
        System.out.println(Colores.ANSI_CYAN + "--------------------------------------------------------");
        System.out.println("-  Actualizando datos de Likes, ¿Qué quieres cambiar?  -");
        System.out.println("--------------------------------------------------------" + Colores.ANSI_RESET);
        System.out.println(Colores.ANSI_PURPLE + "1." + Colores.ANSI_RESET + " Actualizar todo.");
        System.out.println(Colores.ANSI_PURPLE + "2." + Colores.ANSI_RESET + " Actualizar ID del Usuario.");
        System.out.println(Colores.ANSI_PURPLE + "3." + Colores.ANSI_RESET + " Actualizar ID del Post.");
        System.out.println(Colores.ANSI_PURPLE + "0." + Colores.ANSI_RESET + " SALIR.");
    }

    public static void menuBorrarDatos() {

        System.out.println(Colores.ANSI_CYAN + "---------------------------------------------------");
        System.out.println("-  Borrado de datos, ¿Qué tabla quieres cambiar?  -");
        System.out.println("---------------------------------------------------" + Colores.ANSI_RESET);
        System.out.println(Colores.ANSI_PURPLE + "1." + Colores.ANSI_RESET + " DELETE de Usuarios.");
        System.out.println(Colores.ANSI_PURPLE + "2." + Colores.ANSI_RESET + " DELETE de Post.");
        System.out.println(Colores.ANSI_PURPLE + "3." + Colores.ANSI_RESET + " DELETE de Likes.");
        System.out.println(Colores.ANSI_PURPLE + "0." + Colores.ANSI_RESET + " SALIR.");

    }

    public static void menuSeleccionaTablaBorrar(String tabla) {

        System.out.println(Colores.ANSI_CYAN + "----------------------------------------------------");
        System.out.println("-  Borrado de datos en " + tabla + ", ¿Qué quieres hacer?  -");
        System.out.println("----------------------------------------------------" + Colores.ANSI_RESET);
        System.out.println(Colores.ANSI_PURPLE + "1." + Colores.ANSI_RESET + " DELETE de toda la Tabla");
        System.out.println(
                Colores.ANSI_PURPLE + "2." + Colores.ANSI_RESET + " DELETE de registros por ID de " + tabla + ".");
        System.out.println(Colores.ANSI_PURPLE + "0." + Colores.ANSI_RESET + " SALIR.");

    }

    public static void menuBorrarRegistros() {

        System.out.println(Colores.ANSI_CYAN + "-----------------------------------------------------------------");
        System.out.println("-  Borrado de datos por ID, ¿Sbbre que tabla quieres trabajar?  -");
        System.out.println("-----------------------------------------------------------------" + Colores.ANSI_RESET);
        System.out.println(Colores.ANSI_PURPLE + "1." + Colores.ANSI_RESET + " DELETE registros por ID de Usuarios.");
        System.out.println(Colores.ANSI_PURPLE + "2." + Colores.ANSI_RESET + " DELETE registros por ID de Post.");
        System.out.println(Colores.ANSI_PURPLE + "3." + Colores.ANSI_RESET + " DELETE registros por ID de Likes.");
        System.out.println(Colores.ANSI_PURPLE + "0." + Colores.ANSI_RESET + " SALIR.");

    }

    public static void advertenciaDELETETablaUsuario(){
        System.out.println();
        System.out.println(Colores.ANSI_YELLOW +" Ten en cuenta que si quieres borrar todos los datos de la Tabla Usuario, todos los datos dependientes se eliminarán (POST, LIKES) ¿Estás seguro? (Y/N)" + Colores.ANSI_RESET);
        System.out.println();
    }
    public static void advertenciaDELETETablaPost(){
        System.out.println();
        System.out.println(Colores.ANSI_YELLOW +" Ten en cuenta que si quieres borrar todos los datos de la Tabla Post, todos los datos dependientes se eliminarán (LIKES) ¿Estás seguro? (Y/N)" + Colores.ANSI_RESET);
        System.out.println();
    }
}

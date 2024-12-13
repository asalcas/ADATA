public class Pintar {
    //#region Menu principal
    public static void menuPrincipal(){
        System.out.println("==============================================");
        System.out.println("|                                            |");
        System.out.println("|             ¿QUE QUIERES HACER?            |");
        System.out.println("|                                            |");
        System.out.println("==============================================");
        System.out.println("1. Conectar a la DATABASE."); // *Hecho */
        System.out.println("2. Crear TABLAS en la DATABASE."); // *hecho */
        System.out.println("3. Insertar datos."); // *Hecho */
        System.out.println("4. ListarDatos."); // TODO
        System.out.println("5. Modificar datos."); // TODO
        System.out.println("6. Borrar datos."); // TODO
        System.out.println("0. SALIR.");
    }
    //#endregion 
    //#region Tablas de la función crear tablas
    public static void menuCrearTablaOpcionPrincipal(){
        System.out.println("================================================");
        System.out.println("|  ¿Quieres crear una tabla o todas a la vez?  |");
        System.out.println("================================================");
        System.out.println("1. Una a una");
        System.out.println("2. Todas");
        System.out.println("3. Salir");
        System.out.println("Escribe el Nº: ");
        System.out.print("Tu respuesta: ");
    }
    public static void menuCrearTablaSeleccionada(){
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
    }
    //#endregion
    //#region Insertar datos
    public static void menuInsertarDatos(){
        System.out.println("===========================================");
        System.out.println("|  ¿En que tabla quieres insertar datos?  |");
        System.out.println("===========================================");
        System.out.println("1. Usuarios");
        System.out.println("2. Posts");
        System.out.println("3. Likes");
        System.out.println("4. SALIR");
        System.out.println("Escribe el Nº:  ");
        System.out.print("Tu respuesta: ");
    }


    //#endregion
}

public class Pintar {

    // #region Códigos ANSI COLOREAR TEXTO
    static String reset = "\033[0m"; // Resetear color al predeterminado
    static String rojo = "\033[31m";
    static String verde = "\033[32m";
    static String amarillo = "\033[33m";
    static String azul = "\033[34m";
    // #endregion

    // #region Menu principal
    public static void menuPrincipal() {
        System.out.println("==============================================");
        System.out.println("|                                            |");
        System.out.println("|             ¿QUE QUIERES HACER?            |");
        System.out.println("|                                            |");
        System.out.println("==============================================");
        System.out.println("1. Conectar a la DATABASE.");
        System.out.println("2. Crear TABLAS en la DATABASE."); 
        System.out.println("3. Insertar datos.");
        System.out.println("4. ListarDatos."); // TODO
        System.out.println("5. Modificar datos."); // TODO
        System.out.println("6. Borrar datos."); // TODO
        System.out.println("0. SALIR.");
        System.out.print("Tu respuesta (Nº): ");
    }

    // #endregion
    // #region Tablas de la función crear tablas
    public static void menuCrearTablaOpcionPrincipal() {
        System.out.println("================================================");
        System.out.println("|  ¿Quieres crear una tabla o todas a la vez?  |");
        System.out.println("================================================");
        System.out.println("1. Una a una");
        System.out.println("2. Todas");
        System.out.println("3. Salir");
        System.out.print("Tu respuesta (Nº): ");
    }

    public static void menuCrearTablaSeleccionada() {
        System.out.println("===============================");
        System.out.println("|  ¿Que tabla quieres crear?  |");
        System.out.println("===============================");
        System.out.println("Recuerda que debes crear las tablas en orden:");
        System.out.println(rojo + "ATENCION" + reset + ", el orden debe ser:"+ amarillo + "1º Usuarios, 2º Posts y 3º la tabla Likes" + reset);
        System.out.println("1. Usuarios");
        System.out.println("2. Posts");
        System.out.println("3. Likes");
        System.out.print("Tu respuesta (Nº): ");
    }

    // #endregion
    // #region Insertar datos
    public static void menuInsertarDatos() {
        System.out.println("===========================================");
        System.out.println("|  ¿En que tabla quieres insertar datos?  |");
        System.out.println("===========================================");
        System.out.println("1. Usuarios");
        System.out.println("2. Posts");
        System.out.println("3. Likes");
        System.out.println("4. SALIR");
        System.out.print("Tu respuesta (Nº): ");
    }

    // #endregion

    // #region ListarDatos
    public static void menuListarDatos() {
        System.out.println("================================");
        System.out.println("|  ¿Que tabla quieres listar?  |");
        System.out.println("================================");
        System.out.println("1. Usuarios");
        System.out.println("2. Posts");
        System.out.println("3. Likes");
        System.out.println("0. SALIR");
        System.out.print("Tu respuesta (Nº): ");

    }

    public static void subMenuListarUSUARIO() {
        System.out.println("=====================================");
        System.out.println("|  ¿Que columna quieres consultar?  |");
        System.out.println("=====================================");
        System.out.println("1. ID");
        System.out.println("2. Nombre");
        System.out.println("3. Apellidos");
        System.out.println("4. Username");
        System.out.println("5. Password");
        System.out.println("6. email");
        System.out.println("7. TODOS");
        System.out.print("Tu respuesta (Nº): ");

    }

    public static void subMenuListarPOSTS() {
        System.out.println("=====================================");
        System.out.println("|  ¿Que columna quieres consultar?  |");
        System.out.println("=====================================");
        System.out.println("1. ID del POST");
        System.out.println("2. ID del USUARIO que creo el POST"); // FK
        System.out.println("3. Cuando se creo");
        System.out.println("4. Ultima vez actualizado");
        System.out.println("5. TODOS");
        System.out.print("Tu respuesta (Nº): ");

    }

    public static void subMenuListarLIKES() {
        System.out.println("=====================================");
        System.out.println("|  ¿Que columna quieres consultar?  |");
        System.out.println("=====================================");
        System.out.println("1. ID del LIKE");
        System.out.println("2. ID del USUARIO que dio LIKE"); // FK
        System.out.println("3. ID del POST");
        System.out.println("4. TODOS");
        System.out.print("Tu respuesta (Nº): ");

    }

    public static void menuFiltrarSelect() {
        System.out.println("==================================");
        System.out.println("|  ¿Quieres filtrar la consulta? |");
        System.out.println("==================================");
        System.out.print("Tu respuesta (Y/N): ");

    }

    public static void selectFiltrado() {
        System.out.println("=======================================");
        System.out.println("|  ¿Como quieres filtrar la consulta? |");
        System.out.println("=======================================");
        System.out.print("1. idUsuario: ");
        System.out.print("2. Nombre: ");
        System.out.print("3. Apellidos: ");
        System.out.print("4. Username: ");
        System.out.print("5. Password: ");
        System.out.print("6. email: ");
        System.out.print("Tu respuesta (Nº): ");
    }

    
    // #endregion
}

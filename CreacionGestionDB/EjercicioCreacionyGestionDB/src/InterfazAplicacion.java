public class InterfazAplicacion {
    //SCANNER AQUI
    public static void main(String[] args) throws Exception {
        //Y LOS STRING PARA LA CONEXION



        boolean funcionando = true;
        while(funcionando) {
            System.out.println("==============================================");
            System.out.println("|                                            |");
            System.out.println("|             ¿QUE QUIERES HACER?            |");
            System.out.println("|                                            |");
            System.out.println("==============================================");
            System.out.println("1. Conectar a la DATABASE."); //*Hecho */
            System.out.println("2. Crear TABLAS en la DATABASE."); //*hecho */
            System.out.println("3. Insertar datos."); //TODO
            System.out.println("4. ListarDatos."); //TODO
            System.out.println("5. Modificar datos."); //TODO
            System.out.println("6. Borrar datos."); //TODO
            System.out.println("0. SALIR.");
        }




        // ORDEN PROGRAMAS:
        //? 1. INTERFAZ GRAFICA (MAIN)
        //? 2.
        // Menus siempre en una funcion para llamarlas desde ahi, desgranar las funciones a lo más básico, 1 funcion == 1 funcionalidad.ç
        // Dividir por modelos
    }   
}

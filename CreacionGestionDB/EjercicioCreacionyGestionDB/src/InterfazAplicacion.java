public class InterfazAplicacion {
    public static void main(String[] args) throws Exception {
        boolean funcionando = true;
        while(funcionando) {
            System.out.println("==============================================");
            System.out.println("|                                            |");
            System.out.println("|             ¿QUE QUIERES HACER?            |");
            System.out.println("|                                            |");
            System.out.println("==============================================");
            System.out.println("1. Conectar a la DATABASE."); //*Hecho */
            System.out.println("2. Crear TABLAS en la DATABASE."); //TODO
            System.out.println("3. Insertar datos."); //TODO
            System.out.println("4. ListarDatos."); //TODO
            System.out.println("5. Modificar datos."); //TODO
            System.out.println("6. Borrar datos."); //TODO
            System.out.println("0. SALIR.");
        }

    }
}

import java.util.Scanner;

public class InterfazAplicacion {
    Scanner lector = new Scanner(System.in);
    //SCANNER AQUI
    public static void main(String[] args) throws Exception {
        final String  url = "jdbc:mysql://dns11036.phdns11.es:3306/ad2425_alvaro_salvador";
        final String usuario = "alvaro_salvador";
        final String password = "12345";
        
        
        //Y LOS STRING PARA LA CONEXION

        // TODO: Tengo que mandar las interfaces a la clase "InterfazAplicacion"
        // TODO: 

        boolean funcionando = true;
        while(funcionando) {
            System.out.println("==============================================");
            System.out.println("|                                            |");
            System.out.println("|             ¿QUE QUIERES HACER?            |");
            System.out.println("|                                            |");
            System.out.println("==============================================");
            System.out.println("1. Conectar a la DATABASE."); //*Hecho */
            System.out.println("2. Crear TABLAS en la DATABASE."); //*hecho */
            System.out.println("3. Insertar datos."); //*Hecho */
            System.out.println("4. ListarDatos."); //TODO
            System.out.println("5. Modificar datos."); //TODO
            System.out.println("6. Borrar datos."); //TODO
            System.out.println("0. SALIR.");

            
            switch (args) {
                case value:
                    
                    break;
            
                default:
                    break;
            }
        }

        
        
        // ORDEN PROGRAMAS:
        //? 1. INTERFAZ GRAFICA (MAIN)
        //? 2.
        // Menus siempre en una funcion para llamarlas desde ahi, desgranar las funciones a lo más básico, 1 funcion == 1 funcionalidad.ç
        // Dividir por modelos
    }   
}

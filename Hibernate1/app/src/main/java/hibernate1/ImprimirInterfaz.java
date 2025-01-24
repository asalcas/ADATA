package hibernate1;

public class ImprimirInterfaz {
    
    public static void interfazPrincipal(){
        System.out.println(Colores.YELLOW+"===============================================");
        System.out.println("==            ¿QUE QUIERES HACER?            ==");
        System.out.println("==============================================="+Colores.PURPLE);  
        System.out.println("1. "+Colores.Blanco+"Guardar Persona"+Colores.PURPLE); 
        System.out.println("2. "+Colores.Blanco+"Obtener Persona"+Colores.PURPLE); //TODO
        System.out.println("3. "+Colores.Blanco+"Actualizar Persona"+Colores.PURPLE); //TODO
        System.out.println("4. "+Colores.Blanco+"Borrado de Persona"+Colores.PURPLE); //TODO
        System.out.println("0. SALIR"+Colores.Blanco);
    }
    public static void subMenuGuardarPersonas(){
        System.out.println("===============================================");
        System.out.println("==             Debes introducir:             ==");
        System.out.println("===============================================");  
        System.out.println("Nombre: ");
        System.out.println("Saldo: ");
    }
    public static void subMenuObtenerPersonas(){
        System.out.println("===============================================");
        System.out.println("==            ¿Como filtramos?            ==");
        System.out.println("===============================================");  
        System.out.println("1. Obtener por ID"); //TODO
        System.out.println("2. Obtener por Nombre"); //TODO
        System.out.println("3. Obtener por Saldo"); //TODO
        System.out.println("0. SALIR"); //TODO
    }
    
    
    
}

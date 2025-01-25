package hibernate1;

public class ImprimirInterfaz {
    
    public static void interfazPrincipal(){
        System.out.println(Colores.YELLOW+"===============================================");
        System.out.println("==            ¿QUE QUIERES HACER?            ==");
        System.out.println("==============================================="+Colores.PURPLE);  
        System.out.println("1. "+Colores.Blanco+"Guardar Persona"+Colores.PURPLE); 
        System.out.println("2. "+Colores.Blanco+"Obtener Persona"+Colores.PURPLE);
        System.out.println("3. "+Colores.Blanco+"Actualizar Persona"+Colores.PURPLE); 
        System.out.println("4. "+Colores.Blanco+"Borrado de Persona"+Colores.PURPLE); 
        System.out.println("0. SALIR"+Colores.Blanco);
    }
    public static void subMenuGuardarPersonas(){
        System.out.println(Colores.YELLOW+"===============================================");
        System.out.println("==             Debes introducir:             ==");
        System.out.println("==============================================="+Colores.PURPLE);  
        System.out.println(Colores.Blanco+ "Nombre: ");
        System.out.println("Saldo: ");
    }
    public static void subMenuObtenerPersonas(){
        System.out.println(Colores.YELLOW+"===============================================");
        System.out.println("==            ¿Como filtramos?            ==");
        System.out.println("==============================================="+Colores.PURPLE);  
        System.out.println("1. "+Colores.Blanco+"Obtener por ID"+ Colores.PURPLE); 
        System.out.println("2. "+ Colores.Blanco +"Obtener por Nombre"+Colores.PURPLE);
        System.out.println("3. "+Colores.Blanco+"Obtener por Saldo"+Colores.PURPLE); 
        System.out.println("4. "+Colores.Blanco+"Muestrame todos"+Colores.PURPLE);
        System.out.println("0.  Volver atras"+ Colores.Blanco); 
    }
    public static void subMenuObtenerPersonasSueldo(){
        System.out.println(Colores.YELLOW+"===============================================");
        System.out.println("==            ¿Como filtramos?            ==");
        System.out.println("==============================================="+Colores.PURPLE);  
        System.out.println("1. "+Colores.Blanco+"(>=) Mayor o igual que:"+ Colores.PURPLE); 
        System.out.println("2. "+Colores.Blanco+"(>) Mayor que:"+ Colores.PURPLE);
        System.out.println("3. "+ Colores.Blanco +"(<=) Menor o igual que:"+Colores.PURPLE);
        System.out.println("4. "+ Colores.Blanco +"(<) Menor que:"+Colores.PURPLE);
        System.out.println("5. "+Colores.Blanco+"(==) Igual que:"+Colores.PURPLE);
        System.out.println("0. SALIR"+ Colores.Blanco); 
    }
    public static void subMenuModificarPersonas(){
        System.out.println(Colores.YELLOW+"===============================================");
        System.out.println("==             Debes introducir:             ==");
        System.out.println("==============================================="+Colores.PURPLE);  
        System.out.println(Colores.Blanco+ "Nombre: ");
        System.out.println("Saldo: ");
    }
    
    
    
}

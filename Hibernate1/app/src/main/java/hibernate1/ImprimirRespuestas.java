package hibernate1;
import models.Persona;
import hibernate1.Colores;
public class ImprimirRespuestas {

    public static void mensajeGuardarPersonas(Persona persona){
        System.out.println( Colores.GREEN + "\n==============================");
        System.out.println("=   Nueva persona guardada   =");
        System.out.println("=============================="+ Colores.CYAN);
        System.out.println("Id: " + persona.getId());
        System.out.println("Nombre: " +  persona.getNombre());
        System.out.println("Saldo: " + persona.getSaldo()+ "\n" + Colores.Blanco);
    }
    public static void showPersonaID(Persona persona){
        System.out.println( Colores.GREEN + "\n====================================");
        System.out.println("=  Resultado de la busqueda por ID =");
        System.out.println("====================================" + Colores.CYAN);
        System.out.println("Id: " + persona.getId());
        System.out.println("Nombre: " +  persona.getNombre());
        System.out.println("Saldo: " + persona.getSaldo()+ "\n" + Colores.Blanco);
    }
    public static void imprimirListaPersonasPorNombre(Persona persona){
        System.out.println( Colores.GREEN + "\n========================================");
        System.out.println("=  Resultado de la busqueda por Nombre =");
        System.out.println("========================================" + Colores.CYAN);
        System.out.println("Id: " + persona.getId());
        System.out.println("Nombre: " +  persona.getNombre());
        System.out.println("Saldo: " + persona.getSaldo()+ "\n" + Colores.Blanco);
    }
    public static void imprimirListaPersonas(Persona persona){
        System.out.println(Colores.GREEN+ "========================================" + Colores.CYAN);
        System.out.println("Id: " + persona.getId());
        System.out.println("Nombre: " +  persona.getNombre());
        System.out.println("Saldo: " + persona.getSaldo()+ "\n" + Colores.Blanco);
    }
    public static void imprimirListaPersonasPorSaldo(Persona persona){
        System.out.println( Colores.GREEN + "\n========================================");
        System.out.println("=  Resultado de la busqueda por Saldo =");
        System.out.println("========================================" + Colores.CYAN);
        System.out.println("Id: " + persona.getId());
        System.out.println("Nombre: " +  persona.getNombre());
        System.out.println("Saldo: " + persona.getSaldo()+ "\n" + Colores.Blanco);
    }
    public static void updatePersona(Persona persona){
        System.out.println( Colores.GREEN + "\n========================================");
        System.out.println("=   Resultado de la modificación  =");
        System.out.println("========================================" + Colores.CYAN);
        System.out.println("Id: " + persona.getId());
        System.out.println("Nombre: " +  persona.getNombre());
        System.out.println("Saldo: " + persona.getSaldo()+ "\n" + Colores.Blanco);
    }
    
}

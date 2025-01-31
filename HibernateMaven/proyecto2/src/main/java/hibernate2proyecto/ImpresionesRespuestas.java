package hibernate2proyecto;

import java.util.List;

import Models.Usuarios;

public class ImpresionesRespuestas {
    public static void respuestaShowTODOPersonas(List<Usuarios> listaUsuarios){
        for (Usuarios usuario : listaUsuarios) {
            System.out.println("------------------------------------------");
            System.out.println("-  Resultados de toda la tabla Usuarios  -");
            System.out.println("------------------------------------------");
            System.out.println("ID: " + usuario.getIdUsuario()); 
            System.out.println("Nombre: " + usuario.getNombre()); 
            System.out.println("Apellidos: "+ usuario.getApellidos());
            System.out.println("Username: "+ usuario.getUsername()); 
            System.out.println("Password: " + usuario.getPassword().hashCode());   
        }
        
    }
    
}

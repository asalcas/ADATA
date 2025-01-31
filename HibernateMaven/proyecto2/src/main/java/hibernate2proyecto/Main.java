package hibernate2proyecto;

import java.util.List;
import java.util.Scanner;

import Models.Usuarios;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int respuestaMenuUsuario;
        int condicionDoWhiles = 1;
        Impresiones.inicio();
        respuestaMenuUsuario = sc.nextInt();
        do {
            switch (respuestaMenuUsuario) {
                case 1:
                    Impresiones.menuObtenerDatosUsuarios();
                    switch (respuestaMenuUsuario) {
                        case 1:
            
                            break;
                        case 2:
            
                            break;
                        case 3:
            
                            break;
                        case 4:
            
                            break;
                        case 5:
            
                            break;
                        case 6:
            
                            break;
                        case 0:
                            System.out.println("Volviendo atrás...");
                            break;
                        default:
                            System.err.println("Opción no válida, vuelve a intentarlo...");
                            break;
                    }
                    break;
                case 2:
    
                    break;
                case 3:
    
                    break;
                case 4:
    
                    break;
                case 0:
                    condicionDoWhiles = respuestaMenuUsuario;
                    break;
                default:
                System.err.println("Opción no válida, intentelo de nuevo...");
                    break;
            }
            
        } while (condicionDoWhiles != 0);
        

        try {
            List<Usuarios> todosUsuarios = Funciones.obtenerTodosLosUsuarios();
            ImpresionesRespuestas.respuestaShowTODOPersonas(todosUsuarios);

        } catch (Exception e) {
            System.err.println("Hubo un error en la consulta");
        }

    }
}
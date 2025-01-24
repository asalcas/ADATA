package hibernate1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Persona;

public class InterfazUsuario {
    public static void main(String[] args) {
        List<Persona> listaPersonasPintar;
        Scanner sc = new Scanner(System.in);
        String nombre = "";
        int saldo = 0;
        int respuestaUsuario;
        String inputString;
        Persona persona;
        do {
            ImprimirInterfaz.interfazPrincipal();
            respuestaUsuario = sc.nextInt();
            sc.nextLine();
            if (respuestaUsuario >= 0 && respuestaUsuario < 5) {
                switch (respuestaUsuario) {
                    case 1:
                        ImprimirInterfaz.subMenuGuardarPersonas();
                        do {
                            System.out.print("Introduce un nombre: ");
                            nombre = sc.nextLine();
                            System.out.println("Introduce su saldo: ");
                            saldo = sc.nextInt();
                            sc.nextLine();
                            try {
                                persona = Funciones.guardarPersona(nombre, saldo);
                                // Podria hacer un si el statusmsg = no conexion, saltar esto
                                ImprimirRespuestas.mensajeGuardarPersonas(persona);
                            } catch (Exception errorGuardarPersona) {
                                System.err.println(
                                        "No se ha podido guardar correctamente: " + errorGuardarPersona.getMessage());
                            }
                        } while (saldo < 0);
                        break;
                    case 2:
                        ImprimirInterfaz.subMenuObtenerPersonas();
                        respuestaUsuario = sc.nextInt();
                        sc.nextLine();
                        do {
                            switch (respuestaUsuario) {
                                
                                case 1:

                                    break;
                                case 2:
                                
                                    System.out.print("Introduce una parte del nombre que quieres buscar: ");
                                    inputString = sc.nextLine();
                                    try {
                                        Funciones.showPersonaNombre(inputString);                                    
                                    } catch (Exception errorShowPorNombre) {
                                        System.err.println("No se pudo hacer la consulta correctamente: "+ errorShowPorNombre.getMessage());
                                    }
                                    break;
                                case 3:

                                    break;
                                case 0:

                                    break;

                                default:
                                    break;
                            }
                        } while (respuestaUsuario != 0);
                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 0:

                        break;

                    default:
                        break;
                }
            }

        } while (respuestaUsuario != 0);
        sc.close();
    }

}

package hibernate1;

import java.util.List;
import java.util.Scanner;

import models.Persona;


public class InterfazUsuario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre = "";
        int saldo = 0;
        int respuestaUsuario;
        int idPersona;
        String respuesta = "";
        String inputString;
        Persona persona;

        do {
            ImprimirInterfaz.interfazPrincipal();
            respuestaUsuario = sc.nextInt();
            sc.nextLine();
            
                switch (respuestaUsuario) {
                    case 1:
                        /*
                         * Función que Guarda personas en la Base de Datos
                         * 
                         */
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
                                        Colores.RED+"No se ha podido guardar correctamente: " + errorGuardarPersona.getMessage()+Colores.Blanco);
                            }
                        } while (saldo < 0);
                        break;
                    case 2:
                        /*
                         * Función que Muestra personas
                         * 
                         */
                        ImprimirInterfaz.subMenuObtenerPersonas();
                        respuestaUsuario = sc.nextInt();
                        sc.nextLine();
                        loopingExterno: do {
                            switch (respuestaUsuario) {
                                // Opciones de filtrado
                                case 1:
                                    System.out.print("Introduce el Id de la persona que quieres buscar: ");
                                    idPersona = sc.nextInt();
                                    try {
                                        Funciones.showPersonaID(idPersona);
                                    } catch (Exception errorShowPorID) {
                                        System.err.println(
                                                Colores.RED+"Error con la busqueda por ID: " + errorShowPorID.getMessage()+Colores.Blanco);
                                    }
                                    break loopingExterno;
                                case 2:

                                    System.out.print("Introduce una parte del nombre que quieres buscar: ");
                                    inputString = sc.nextLine();
                                    try {
                                        Funciones.showPersonaNombre(inputString);
                                    } catch (Exception errorShowPorNombre) {
                                        System.err.println(Colores.RED+"No se pudo hacer la consulta correctamente: "
                                                + errorShowPorNombre.getMessage()+Colores.Blanco);
                                    }
                                    break loopingExterno;
                                case 3:
                                    String operador = "";
                                    int respuestaOperador;
                                    do {
                                        ImprimirInterfaz.subMenuObtenerPersonasSueldo();
                                        respuestaOperador = sc.nextInt();
                                        switch (respuestaOperador) {
                                            case 1:
                                                operador = ">=";
                                                break;
                                            case 2:
                                                operador = ">";
                                                break;
                                            case 3:
                                                operador = "<=";
                                                break;
                                            case 4:
                                                operador = "<";
                                                break;
                                            case 5:
                                                operador = "=";
                                                break;
                                            case 0:
                                                System.out.println(Colores.CYAN+"Saliendo de programa..."+Colores.Blanco);
                                                break loopingExterno;
                                            default:
                                                System.out.println(Colores.RED+"Opción no valida. Intentalo de nuevo"+Colores.Blanco);
                                                break;
                                        }
                                    } while (respuestaOperador < 0 && respuestaOperador > 5);
                                    try {
                                        System.out.println(
                                                "Introduce el saldo por el que filtrar (no puede ser menor de 0): ");
                                        saldo = sc.nextInt();
                                        sc.nextLine();
                                        if (saldo < 0) {
                                            System.out.println(
                                                    Colores.RED+"No se puede introducir una cantidad negativa, pasa a ser 0."+Colores.Blanco);
                                            saldo = 0;
                                        }
                                        Funciones.showPersonaSaldo(operador, saldo);
                                    } catch (Exception errorShowPorSaldo) {
                                        System.out.println(Colores.RED+ "No se pudo hacer la consulta correctamente: "
                                                + errorShowPorSaldo.getMessage()+Colores.Blanco);
                                    }
                                    break;
                                case 4:
                                    try {
                                        List<Persona> personas = Funciones.showPersonas();
                                        for (Persona persona1 : personas) {
                                            ImprimirRespuestas.imprimirListaPersonas(persona1); // ! EJEMPLO PARA PONER COSAS EN MAIN (impresiones listaobjetos)
                                        }
                                    } catch (Exception errorShow) {
                                        System.out.println(Colores.RED+"Error al listar Personas: " + errorShow.getMessage()+Colores.Blanco);
                                    }
                                    break loopingExterno;
                                case 0:
                                    System.out.println(Colores.CYAN+"Volviendo atras..."+Colores.Blanco);
                                    break;

                                default:
                                    System.out.println(Colores.RED+"\"Opción no valida. Intentalo de nuevo"+Colores.Blanco);
                                    break;
                            }
                        } while (respuestaUsuario != 0);
                        break;
                    case 3:
                        /*
                         * Función que modifica una persona en la Base de Datos
                         * pre: idPersona, nombre, saldo
                         */
                        try {
                            Funciones.showPersonas();
                            System.out.println(Colores.YELLOW+"Indica el Id del usuario a modificar: "+Colores.Blanco);
                            idPersona = sc.nextInt();
                            sc.nextLine();
                            ImprimirInterfaz.subMenuModificarPersonas();
                            System.out.print("Nombre: ");
                            nombre = sc.nextLine();
                            System.out.print("Saldo: ");
                            saldo = sc.nextInt();
                            Funciones.updatePersona(idPersona, nombre, saldo);
                            Funciones.showPersonaID(idPersona);
                        } catch (Exception errorUpdate) {
                            System.out.println(
                                    Colores.RED+"No ha sido posible realizar el Update de la persona: " + errorUpdate.getMessage()+Colores.Blanco);
                        }
                        break;
                    case 4:
                        /*
                         * Función que elimina a una persona en la Base de Datos
                         * pre: idPersona
                         */
                        System.out.println(Colores.YELLOW+"Escribe el ID de la persona a eliminar: "+Colores.Blanco);
                        idPersona = sc.nextInt();
                        sc.nextLine();

                        try {
                            Funciones.showPersonaID(idPersona);
                            System.out.println("¿Seguro que quieres eliminar esta persona? (Y/N)");
                            respuesta = sc.nextLine().toUpperCase();
                            Funciones.deletePersona(idPersona, respuesta);
                            System.out.println(Colores.GREEN+"\nLa persona con ID: " + idPersona+ " ha sido elimnada con exito"+ Colores.Blanco);
                        } catch (Exception errorDelete) {
                            System.out.println(
                                    Colores.RED+"No ha sido posible realizar el Delete de la persona: "+Colores.Blanco+ errorDelete.getMessage());
                        }
                    case 0:
                        System.out.println(Colores.YELLOW+"Saliendo del programa.."+Colores.Blanco);
                        break;

                    default:
                        break;
                }
            

        } while (respuestaUsuario != 0);
        sc.close();
    }

}

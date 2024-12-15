import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FuncionListarDatos {
    public static void main(String[] args) {

    }

    public static boolean listarDatos(Connection conn, Scanner lector) throws SQLException {
        PreparedStatement pstmt = null;
        int respuestaUsuario;
        String tablaConsulta = "";
        String cadenaCompleta;
        String campoConsultar = "";
        String imprimir = "";
        String variableResultado = "";

        // #region Códigos ANSI COLOREAR TEXTO
        String reset = "\033[0m"; // Resetear color al predeterminado
        String rojo = "\033[31m";
        String verde = "\033[32m";
        String amarillo = "\033[33m";
        String azul = "\033[34m";
        // #endregion

        Pintar.menuListarDatos();
        respuestaUsuario = lector.nextInt();
        boolean dejarDeFuncionar = false;
        do {
            switch (respuestaUsuario) {
                case 1:
                    tablaConsulta = "Usuarios";
                    do {
                        Pintar.subMenuListarUSUARIO();
                        respuestaUsuario = lector.nextInt();

                        switch (respuestaUsuario) {
                            case 1:
                                campoConsultar = "idUsuarios";
                                break;
                            case 2:
                                campoConsultar = "Nombre";
                                break;
                            case 3:
                                campoConsultar = "Apellidos";
                                break;
                            case 4:
                                campoConsultar = "Username";
                                break;
                            case 5:
                                campoConsultar = "Password";
                                break;
                            case 6:
                                campoConsultar = "email";
                                break;
                            case 7:
                                campoConsultar = "*";
                                break;
                            default:
                                System.out.println("Has introducido un valor invalido, intentelo de nuevo.");
                                continue; // Vuelve al inicio del bucle
                        }
                        dejarDeFuncionar = true;
                    } while (!dejarDeFuncionar);
                    break;
                case 2:
                    tablaConsulta = "Posts";
                    do {
                        Pintar.subMenuListarPOSTS();
                        respuestaUsuario = lector.nextInt();
                        switch (respuestaUsuario) {
                            case 1:
                                campoConsultar = "idPost";
                                break;
                            case 2:
                                campoConsultar = "idUsuarios";
                                break;
                            case 3:
                                campoConsultar = "created_at";
                                break;
                            case 4:
                                campoConsultar = "updated_at";
                                break;
                            case 5:
                                campoConsultar = "*";
                                break;

                            default:
                                System.out.println("Has introducido un valor invalido, intentelo de nuevo.");
                                continue; // Vuelve al inicio del bucle
                        }
                        dejarDeFuncionar = true;
                    } while (!dejarDeFuncionar);
                    break;
                case 3:
                    tablaConsulta = "Likes";
                    do {
                        Pintar.subMenuListarLIKES();
                        respuestaUsuario = lector.nextInt();
                        switch (respuestaUsuario) {
                            case 1:
                                campoConsultar = "idLikes";
                                break;
                            case 2:
                                campoConsultar = "idUsuarios";
                                break;
                            case 3:
                                campoConsultar = "idPost";
                                break;
                            case 4:
                                campoConsultar = "*";
                                break;
                            default:
                                break;
                        }
                        dejarDeFuncionar = true;
                    } while (!dejarDeFuncionar);

                    break;
                case 0:
                    dejarDeFuncionar = true;
                    break;
            }
        } while (!dejarDeFuncionar);

        try {

            cadenaCompleta = String.format(
                    "SELECT " + campoConsultar + " FROM " + tablaConsulta); // ! a cambiar
            if (tablaConsulta.equals("Usuarios")) { // ? --------------------------------------- TABLA SELECCIONADA
                                                    // USUARIOS
                if (campoConsultar.equals("*")) {
                    pstmt = conn.prepareStatement(cadenaCompleta);
                    ResultSet rs = pstmt.executeQuery(); // Ejecución
                    System.out.println("");
                    System.out.println("Resultados de la consulta: ");

                    while (rs.next()) {
                        // Datos obtenidos: (idUsuarios, Nombre, Apellidos, Username, Password, email)
                        int id = rs.getInt("idUsuarios");
                        String nombre = rs.getString("Nombre");
                        String apellidos = rs.getString("Apellidos");
                        String username = rs.getString("Username");
                        String password = rs.getString("Password");
                        String email = rs.getString("email");
                        if (id == 1) {
                            System.out.println(amarillo + "=======================================" + reset);
                        }

                        System.out.println(rojo + "ID: " + reset + id);
                        System.out.println(rojo + "Nombre: " + reset + nombre);
                        System.out.println(rojo + "Apellido: " + reset + apellidos);
                        System.out.println(rojo + "Username: " + reset + username);
                        System.out.println(rojo + "Password: " + reset + password);
                        System.out.println(rojo + "Correo electronico: " + reset + email);
                        System.out.println(amarillo + "=======================================" + reset);
                    }

                } else {
                    if (campoConsultar.equals("idUsuarios")) {

                        imprimir = "ID: ";

                    } else if (campoConsultar.equals("Nombre")) {
                        imprimir = "Nombre: ";

                    } else if (campoConsultar.equals("Apellidos")) {
                        imprimir = "Apellido: ";

                    } else if (campoConsultar.equals("Username")) {
                        imprimir = "Username: ";

                    } else if (campoConsultar.equals("Password")) {
                        imprimir = "Password: ";

                    } else if (campoConsultar.equals("email")) {
                        imprimir = "Correo electronico: ";
                    }
                    pstmt = conn.prepareStatement(cadenaCompleta);
                    ResultSet rs = pstmt.executeQuery(); // Ejecución
                    System.out.println("");
                    System.out.println("Resultados de la consulta: ");
                    System.out.println(amarillo + "=======================================" + reset);
                    while (rs.next()) {
                        // Datos obtenidos: (Nombre)
                        variableResultado = rs.getString(campoConsultar);
                        System.out.println(rojo + imprimir + reset + variableResultado);
                        System.out.println(amarillo + "=======================================" + reset);

                    }
                }

            } else {
                if (tablaConsulta.equals("Posts")) { // ? --------------------------------------- TABLA SELECCIONADA
                                                     // POST
                                                     // CREO QUE DEBERIA AÑADIR EL ID A TODAS LAS BUSQUEDAS
                                                     // INDIVIDUALES
                    if (campoConsultar.equals("*")) {
                        pstmt = conn.prepareStatement(cadenaCompleta);
                        ResultSet rs = pstmt.executeQuery(); // Ejecución
                        System.out.println("");
                        System.out.println("Resultados de la consulta: ");

                        while (rs.next()) {
                            // Datos obtenidos: (idPost, idUsuarios, created_at, updated_at)
                            int idPost = rs.getInt("idPost");
                            int idUser = rs.getInt("idUsuarios");
                            Date creado_fecha = rs.getDate("created_at");
                            Date actualizado_fecha = rs.getDate("updated_at");

                            if (idPost == 1) {
                                System.out.println(amarillo + "=======================================" + reset);
                            }

                            System.out.println(rojo + "ID-Post: " + reset + idPost);
                            System.out.println(rojo + "ID-Usuario: " + reset + idUser);
                            System.out.println(rojo + "Fue creado el: " + reset + creado_fecha);
                            System.out.println(rojo + "Fue actualizado el: " + reset + actualizado_fecha);
                            System.out.println(amarillo + "=======================================" + reset);
                        }

                    } else {
                        if (campoConsultar.equals("idPost")) {
                            imprimir = "ID-Post: ";

                        } else if (campoConsultar.equals("idUsuarios")) {
                            imprimir = "ID-Usuario: ";

                        } else if (campoConsultar.equals("created_at")) {
                            imprimir = "Fue creado el: ";

                        } else if (campoConsultar.equals("updated_at")) {
                            imprimir = "Fue actualizado el: ";
                        }
                        pstmt = conn.prepareStatement(cadenaCompleta);
                        ResultSet rs = pstmt.executeQuery(); // Ejecución
                        System.out.println("");
                        System.out.println("Resultados de la consulta: ");
                        System.out.println(amarillo + "=======================================" + reset);
                        while (rs.next()) {
                            // Datos obtenidos: (Nombre)
                            variableResultado = rs.getString(campoConsultar);
                            System.out.println(rojo + imprimir + reset + variableResultado);
                            System.out.println(amarillo + "=======================================" + reset);
                        }
                    }
                } else if (tablaConsulta.equals("Likes")) { // ? --------------------------------------- TABLA
                                                            // SELECCIONADA
                                                            // LIKES
                    if (campoConsultar.equals("*")) {
                        pstmt = conn.prepareStatement(cadenaCompleta);
                        ResultSet rs = pstmt.executeQuery(); // Ejecución
                        System.out.println("");
                        System.out.println("Resultados de la consulta: ");

                        while (rs.next()) {
                            // Datos obtenidos: (idLikes, idUsuarios, idPost)
                            int idLikes = rs.getInt("idLikes");
                            int idUser = rs.getInt("idUsuarios");
                            int idPost = rs.getInt("idPost");

                            if (idPost == 1) {
                                System.out.println(amarillo + "=======================================" + reset);
                            }

                            System.out.println(rojo + "ID-Likes: " + reset + idLikes);
                            System.out.println(rojo + "ID-Usuario: " + reset + idUser);
                            System.out.println(rojo + "ID-Post: " + reset + idPost);
                            System.out.println(amarillo + "=======================================" + reset);
                        }

                    } else {
                        if (campoConsultar.equals("idLikes")) {
                            imprimir = "ID-Like: ";
                        } else if (campoConsultar.equals("idUsuarios")) {
                            imprimir = "ID-Usuario: ";
                        } else if (campoConsultar.equals("idPost")) {
                            imprimir = "ID-Post: ";
                        }
                        pstmt = conn.prepareStatement(cadenaCompleta);
                        ResultSet rs = pstmt.executeQuery(); // Ejecución
                        System.out.println("");
                        System.out.println("Resultados de la consulta: ");
                        System.out.println(amarillo + "=======================================" + reset);
                        while (rs.next()) {
                            // Datos obtenidos: (Nombre)
                            variableResultado = rs.getString(campoConsultar);
                            System.out.println(rojo + imprimir + reset + variableResultado);
                            System.out.println(amarillo + "=======================================" + reset);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error inesperado: " + e);
        }

        return dejarDeFuncionar;
    }
}

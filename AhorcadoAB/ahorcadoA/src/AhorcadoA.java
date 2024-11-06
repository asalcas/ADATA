import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AhorcadoA {
    public static void main(String[] args){
    
        String archivoINPUT = "C:\\Users\\alvar\\Desktop\\DAM\\ADATA\\ahorcadoA\\src\\archivoleer.txt"; // ESTAS SON LAS RUTAS EN CASA
        String archivoOUTPUT = "C:\\Users\\alvar\\Desktop\\DAM\\ADATA\\ahorcadoA\\src\\archivoescribir.txt"; // ESTAS SON LAS RUTAS EN CASA
        String linea = "";

        try(
            BufferedReader lector = new BufferedReader(new FileReader(archivoINPUT));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoOUTPUT)))
            {
            linea = lector.readLine();

            StringBuilder palabra = new StringBuilder(); // Es una version mejorada de String, que permite modificar mucho más un string (Internet)

            for (char letra : linea.toCharArray()) { // Por cada letra en linea: P, l, u, t, o 
                if (Character.isUpperCase(letra) && palabra.length() > 0) { // Comprobamos si una es Mayuscula y si mas caracteres antes de la siguiente Mayuscula. P, l, u, t, o, |B|
                    escritor.write(palabra.toString()); // Escribe una palabra con el contenido de palabra
                    escritor.newLine(); // Y agrega una nueva linea al archivo
                    palabra.setLength(0); // REINICIAMOS el StringBuilder
                }
                palabra.append(letra); // Agrega la NUEVA MAYUSCULA a palabra y volvemos a comenzar con el bucle (con la que nos salimos del IF)
            }
            if (palabra.length() > 0) { // Si era la ultima palabra, al llegar aqui salimos escribiendo el contenido de palabra al final.
                escritor.write(palabra.toString());
            }


        }catch (IOException error){
            System.err.println("Error al procesar el archivo: "+ error.getMessage());
        }
    }
}

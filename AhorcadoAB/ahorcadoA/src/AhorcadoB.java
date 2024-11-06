import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AhorcadoB {
    public static void main(String[] args){
    
        String archivoINPUT = "C:\\Users\\alvar\\Desktop\\DAM\\ADATA\\ahorcadoA\\src\\archivoescribir.txt"; // ESTAS SON LAS RUTAS EN CASA
        String archivoOUTPUT = "C:\\Users\\alvar\\Desktop\\DAM\\ADATA\\ahorcadoA\\src\\archivoescribirOrden.txt"; // ESTAS SON LAS RUTAS EN CASA
        String linea = "";

       List<String> palabras = new ArrayList<>(); // Creamos un arraylist

       try (BufferedReader lector = new BufferedReader(new FileReader(archivoINPUT))){ // Creamos el lector

            while ((linea = lector.readLine()) != null) { // CUANDO linea no sea null (como los cursores)
                palabras.add(linea); // Agregamos cada palabra que vaya conteniendo "linea" en el arraylist

            }

        }catch (IOException error){
                System.err.println(error);
        }

       Collections.sort(palabras); // Ordenamos el ArrayList

       try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoOUTPUT))){ // Creamos el escritor
        for (String palabra: palabras){ // por cada PALABRA (nueva variable) dentro de el arraylist Palabras
            escritor.write(palabra); // escribela
            escritor.newLine(); // crea una nueva linea
        }

    
        } catch (IOException error) {
            System.err.println(error);
        }
    }
}


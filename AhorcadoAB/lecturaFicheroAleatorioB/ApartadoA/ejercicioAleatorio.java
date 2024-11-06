package ApartadoA;
import java.io.IOException;
import java.io.RandomAccessFile;


public class ejercicioAleatorio {

/*
 * 
 * 1.Crea un documento de texto con una única letra "a" que será leído de forma aleatoria (seek) y escrito 5 veces en otro documento también de forma aleatoria (seek).
 * 2.Aumenta el documento de lectura hasta la letra "e" en líneas diferentes (a, b, c, d, e) y crea un método que las escriba en otro de forma inversa. Sin usar ARRAYS ni BUFFER.
 * 3.Añade un número a cada letra (a1, b2, c3, d4, e5) y realiza la misma operación anterior. Debe quedar e5 d4 c3 b2 a1.
 */

public static void main(String[] args){
    String rutaArchivoInput = "C:\\Users\\alvaro.salvador\\Desktop\\GitHub\\ADATA\\AhorcadoAB\\lecturaFicheroAleatorioB\\ApartadoA\\letras.txt";
    String rutaArchivoOutput = "C:\\Users\\alvaro.salvador\\Desktop\\GitHub\\ADATA\\AhorcadoAB\\lecturaFicheroAleatorioB\\ApartadoA\\letrasEscritas.txt";
    
    String letra;

    try (RandomAccessFile lector = new RandomAccessFile(rutaArchivoInput, "r");
        RandomAccessFile escritor = new RandomAccessFile(rutaArchivoOutput, "rw")){
        
        for (int i = 0; i < 5; i++){
            lector.seek(0); // CONTENGO LA LETRA EN LECTOR
            letra = lector.readLine(); // AHORA 'letra' VALE LO QUE TENGO EN LECTOR ( LA LETRA 'a')

            //System.out.print(letra);

            escritor.seek(i); // Asigno un indice autoincrementado ya que tengo que escribir 5 letras
            escritor.writeBytes(letra); // Le digo que imprimir.
            
        }
        lector.close(); // SE CIERRA SOLO, pero para verlo lo dejo
        escritor.close(); // SE CIERRA SOLO, pero para verlo lo dejo
        
        
    }

    catch (IOException e) {
        System.err.println("Ha ocurrido un error inesperado al acceder al fichero" + e);
        }
    }
}


// EJERCICIO PURA AYUDA DE DANIEL.
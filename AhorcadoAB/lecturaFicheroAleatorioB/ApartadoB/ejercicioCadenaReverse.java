package ApartadoB;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ejercicioCadenaReverse {

    public static void main (String... args){

        String rutaArchivoInput = "C:\\Users\\alvaro.salvador\\Desktop\\GitHub\\ADATA\\AhorcadoAB\\lecturaFicheroAleatorioB\\ApartadoB\\letras.txt";
        String rutaArchivoOutput = "C:\\Users\\alvaro.salvador\\Desktop\\GitHub\\ADATA\\AhorcadoAB\\lecturaFicheroAleatorioB\\ApartadoB\\letrasReverse.txt";
        
        String letra;

        try (RandomAccessFile lector = new RandomAccessFile(rutaArchivoInput, "r");
            RandomAccessFile escritor = new RandomAccessFile(rutaArchivoOutput, "rw")){

                for (long i = lector.length()-1; i >= 0; i-=3){ 
                    lector.seek(i);
                    letra= lector.readLine();
                    escritor.writeBytes(letra);
                    if (i > 0){
                        escritor.writeBytes("\n");
                    }

                    /*if (letra == "\n"){  PARA NO TENER QUE DECREMENTAR 3
                        i--;
                    }
                    */
                }


            
                

        }catch(IOException error) {
            System.out.println("Ha ocurrido un error inesperado: " + error);

        }

    }
}


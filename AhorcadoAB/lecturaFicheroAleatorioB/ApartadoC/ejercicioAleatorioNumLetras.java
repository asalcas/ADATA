package ApartadoC;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ejercicioAleatorioNumLetras {

     public static void main (String... args){

        String rutaArchivoInput = "C:\\Users\\alvaro.salvador\\Desktop\\GitHub\\ADATA\\AhorcadoAB\\lecturaFicheroAleatorioB\\ApartadoC\\letrasNum.txt";
        String rutaArchivoOutput = "C:\\Users\\alvaro.salvador\\Desktop\\GitHub\\ADATA\\AhorcadoAB\\lecturaFicheroAleatorioB\\ApartadoC\\letrasNumReverse.txt";
        String cadenaResul = "";

        try (RandomAccessFile lector = new RandomAccessFile(rutaArchivoInput, "r");
            RandomAccessFile escritor = new RandomAccessFile(rutaArchivoOutput, "rw")){
                for (long i = lector.length()-1; i>= 0; i--){
                    lector.seek(i);




                    /*lector.seek(lector.length()-1);
                    char primeraLetra = (char)lector.readByte();
                    primeraLetra = Character.toLowerCase(primeraLetra);
                    if (Character.isLetter(primeraLetra)){
                        cadenaResul += primeraLetra;
                    }
                    switch (primeraLetra) {
                        case 'a':
                            cadenaResul += "1"; 
                            break;
                        case 'b':
                            cadenaResul += "2";   
                            break;
                        case 'c':
                            cadenaResul += "3"; 
                            break;
                        case 'd':
                            cadenaResul += "4"; 
                            break;
                        case 'e':
                            cadenaResul += "5"; 
                            break;
                        default:
                            break;
                    }
                    if (primeraLetra == '\n'){
                        i++;
                    }
                    // UN SWITCH CON INDEX OF 0 = case "a", "b"...
                */
            }

        }catch(IOException error) {
            System.out.println("Ha ocurrido un error inesperado: " + error);

        }

    }
}




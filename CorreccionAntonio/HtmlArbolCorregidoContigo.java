package Ejercicio2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HtmlArbol {
	
	
	public static void main(String[] args) {
	
	String directorio = "C:\\Users\\alvaro.salvador\\";
	File directorioFinal;
	BufferedReader lec = null;
	String linea = ""; 
	
	try {
	lec = new BufferedReader(new FileReader("C:\\Users\\alvaro.salvador\\eclipse-workspace\\Unidad1\\src\\Ejercicio1\\carpeta.txt"));
	
	// Creamos una variable que contenga un BufferedReader con un FileReader nuevo indicando la ruta del archivo a leer.
	
	linea = lec.readLine(); 

	while (linea!=null) { // CUANDO linea NO ESTE VACIA entonces:	
		directorioFinal = new File(directorio + linea); // Creo un objeto File
								  // RUTA  +  concatenación
							// ":\\Users\\alvaro.salvador\\ (AD, AD\\EJER01) concatenación
		int indice = linea.lastIndexOf("\\");
		
		if (directorioFinal.exists()) { // 
			 // CREALO
			
			String html = ("<html>\r\n"
					 + "   <head>\r\n"
					 + "      <title> " + linea + " </title>\r\n"
					 + "   </head>\r\n"
					 + "   <body>\r\n"
					 + "      <h1>"+ directorioFinal.getName() +"</h1>\r\n"
					 + "      <h3>Autor: Álvaro </h3>\r\n"
					 + "   </body>\r\n"
					 + "</html>");
			
			File archivoHTML = new File(directorioFinal + "\\" + linea.substring(indice + 1) +".html");
		   FileWriter escribirHTML = new FileWriter(archivoHTML, false);
		   
		   escribirHTML.write(html);
		   escribirHTML.close();
			
			System.out.println("Los archivos se ha creado correctamente"); // IMPRIME
			
		}else {
			System.out.println("La carpeta ya existe."); // IMPRIME
		}
		
		linea = lec.readLine(); }
	
	}catch (IOException errorIneseperado){
		System.out.println("Ha ocurrido un error inesperado.");
	}
	
		
	
	
	}	
		
}
	

	

	
	

	

	
	
	

	
	
	
	


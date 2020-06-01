package Grupo4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImportaCSV {
	
	public void Ler(String caminho) {
		File arquivoCSV = new File(caminho);
		
		try {
			String linhasDoArquivo = new String();
			
			Scanner leitor = new Scanner(arquivoCSV);
			
			while(leitor.hasNext()) {
				linhasDoArquivo = leitor.nextLine();
				
				String[] valoresEntreVirgulas = linhasDoArquivo.split(",");
			
				System.out.println(valoresEntreVirgulas[1]+" , "+valoresEntreVirgulas[4]+" , "+valoresEntreVirgulas[5]);
			}
		}catch(FileNotFoundException e) {
			System.out.println("errrro");
		}
	}
}

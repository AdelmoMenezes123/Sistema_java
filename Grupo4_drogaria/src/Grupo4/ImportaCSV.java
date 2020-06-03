package Grupo4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ImportaCSV {
	
	private ImportaCSV() {}

	private static BufferedReader conteudoCsv = null;
	
	public static void lerArquivoCSV(String csvArquivo) {
		
		//String csvArquivo = ".\\Dados_DB\\MOCK_DATA.csv";
		
		try {
			if(conteudoCsv == null) {
				conteudoCsv = new BufferedReader(new FileReader(csvArquivo));
				String linha ="";
				while ((linha = conteudoCsv.readLine()) != null) {
					String[] Produtos = linha.split(",");
					
					System.out.println("[id = " 	 + Produtos[0]+"]" 
							+", [nome da marca = " + Produtos[1]+"]"
							+", [nome generico = " + Produtos[2]+"]"
							+", [laboratorio = "   + Produtos[3]+"]"
							+", [quantidade = "    + Produtos[4]+"]"
							+", [preco = "	     + Produtos[5]+"]"
							);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo nao encontrado: \n"+e.getMessage());
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("indexOutOfBounds: \n"+e.getMessage());
		}catch (IOException e) {
			System.out.println("IO Erro: \n"+ e.getMessage());
		} finally {
			if(conteudoCsv != null) {
				try {
					conteudoCsv.close();
				} catch (IOException e) {
					System.out.println("IO Erro: \n"+ e.getMessage());
				}
			}
		}
	}
	
}

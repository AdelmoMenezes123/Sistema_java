package Grupo4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import model.produ.Produto;

public class ImportaCSV {

	private ImportaCSV() {}// CONSTRUTOR
	
	public static BufferedReader reader; //leitura de uma InputStreamReade
	public static ArrayList<Produto> produtos; // LISTA DE PRODUTOS;  

	public static void lerArquivoCSV(String caminho) throws Exception {// METODO QUE PARA LEITURA DE ARQUIVO

		try {
			Produto p; // OBJETO DA CLASSE PRODUTO
			
			System.out.println("Caminho do Arquivo: "+caminho.replace("\\", "\\" + "\\"));// CONFIRMANDO SE O VAL DA URL(DIRETORIO) ESTA CORRETO AO SER TRATADA

			 //reader = new BufferedReader(new InputStreamReader(new FileInputStream("caminho")));
	       
			    // PASSANDO O CAMINHO DO ARQUIVO E TRATANDO LOGO EM SEGUIDA. O CAMINHO ESTAVA COM " \ " E O WINDOWNS NAO ACEITA
			    // ENTAO TODA VEZ QUE COLOCO UM CAMINHO AO USAR O JFILECHOOSE EU TRATO SE CASO O CAMINHO VINHER COM   
				// COM UMA BARRA " \ "  EU FORCO ELE TER MAIS UMA USANDO replace("\\", "\\" + "\\"));
			    FileInputStream arquivo = new FileInputStream(caminho.replace("\\", "\\" + "\\")); 
				InputStreamReader input = new InputStreamReader(arquivo);///LENDO O ARQUVIO 
				reader = new BufferedReader(input);	//ACESSO AS LINHAS DO ARQUIVO
			 
			 
			 
			reader.readLine();// CABECALHO DO ARQUIVO ID, NOME(MARCA) .....
			 String linha ;
			 produtos = new ArrayList<>(); // INICIANDO A LISTA
	        while ((linha = reader.readLine()) != null) { // ENQUANTO TIVER LINHA PULE PARA PROXIMA 
			 //linha = reader.nextLine();
	        String[] dados = linha.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // SEPARANDO AS COLUNAS APENAS POR VIRGULA E RESPEITANDO 
	        																	// OUTROS CARACTERES EX UMA VIRGULA ENTRE DE ASPAS 
			String x = dados[5].replace( "$" , "" ); // SE CASO TIVER $ TROQUE POR CARACTER VAZIO ...
													// TAVA DANDO ERRO AO TENTAR CONVERTER PARA DOUBLE
			   
			     
			     p = new Produto(); //INICIANDO UM NOVO OBJ DO TIPO Produto
	             p.setId(Integer.parseInt(dados[0]));// CONVERTENDO STRING ID PARA INT E COLOCANDO NA VARIAVEL ATRAVEL DO SETID()
				 p.setNomeM(dados[1]); // NAO PRECISEI CONVERTER PORQUE JA E STRING
				 p.setNomeG(dados[2]);
				 p.setLab(dados[3]);
				 p.setQtn(Integer.valueOf(dados[4])); //CONVERTENDO  STRING PARA INTEIRO E ENVIANDO PARA O OBJETO
				 p.setPreco(Double.parseDouble(x) );//CONVERTENDO  STRING PARA DOUBLE E ENVIANDO PARA O OBJETO
				 produtos.add(p); // ADD NA LISTA O OBJT DO TIPO Produto  QUE CONTEM TODOS OS DADOS QUE FOI TRATADO A CIMA
	        }
	        
			// TRATAMENTO DE ERROS CASO HOUVER ERRO.
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo nao encontrado: \n" + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("indexOutOfBounds: \n" + e.getMessage());
		} finally { // SE TUDO OK OU NAO EXECULTE
			if (reader != null) { // BUFFER TA COM ARQUIVOS ABERTO AINDA?
				reader.close(); // FECHE O ARQUIVO
			}
		}
		 				
				
	}
}

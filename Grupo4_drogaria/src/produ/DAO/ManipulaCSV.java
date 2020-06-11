package produ.DAO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.produ.Produto;

public class ManipulaCSV {

	private ManipulaCSV() {}// CONSTRUTOR
	
	public static BufferedReader reader; //leitura de uma InputStreamReade
	public static ArrayList<Produto> produtos ; // LISTA DE PRODUTOS;  

	public static void lerArquivoCSV(String caminho) throws Exception {// METODO QUE PARA LEITURA DE ARQUIVO

		try {
			Produto p; // OBJETO DA CLASSE PRODUTO
			
			System.out.println("Caminho do Arquivo: "+caminho.replace("\\", "\\" + "\\"));// CONFIRMANDO SE O VALOR DA URL(DIRETORIO)
																							//ESTA CORRETO AO SER TRATADA
				//TENTANDO LE O ARQUIVO SEM TRATATR CAMINHO
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

	        	String[] dados = linha.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // SEPARANDO AS COLUNAS APENAS POR VIRGULA E RESPEITANDO 
	     																	// OUTROS CARACTERES EX UMA VIRGULA ENTRE DENTRO DE UMA ASPAS 
	        	String x = dados[5].replace( "$" , "" ); // SE CASO TIVER $ TROQUE POR CARACTER VAZIO ...
													// TAVA DANDO ERRO AO TENTAR CONVERTER PARA DOUBLE
			   
			     
			     p = new Produto(); //INICIANDO UM NOVO OBJ DO TIPO Produto
	             p.setId(Integer.parseInt(dados[0]));// CONVERTENDO STRING DO ID PARA INT E COLOCANDO NO OBJ ATRAVEZ DO setId()
				 p.setNomeM(dados[1]); // NAO PRECISEI CONVERTER PORQUE JA E STRING
				 p.setNomeG(dados[2]);
				 p.setLab(dados[3]);
				 p.setQtn(Integer.valueOf(dados[4])); //CONVERTENDO  STRING PARA INTEIRO E ENVIANDO PARA O OBJETO
				 p.setPreco(Double.parseDouble(x) );//CONVERTENDO  STRING PARA DOUBLE E ENVIANDO PARA O OBJETO
				 produtos.add(p); // ADD NA LISTA O OBJT DO TIPO Produto  QUE CONTEM TODOS OS DADOS QUE FOI TRATADO A CIMA
	        }
	        
			// TRATAMENTO DE ERROS CASO HOUVER ERRO.
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo nao encontrado:  \n" + e);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("indexOutOfBounds: \n" + e.getMessage());
		} finally { // SE TUDO OK OU NAO EXECULTE
			if (reader != null) { // BUFFER TA COM ARQUIVOS ABERTO AINDA?
				reader.close(); // FECHE O ARQUIVO
			}
		}
	}
	
	
	
	
	public static void escreverArquivoCSV(String caminho,String novoFile) throws Exception {// METODO PARA ESCRITA NO ARQUIVO

		try {
			
			//cria arquivo para ser escrito
			FileOutputStream arquivo = new FileOutputStream(caminho.replace("\\", "\\" + "\\")+"\\"+novoFile);

			// recebe um arquivo para poder escrever
			PrintWriter pr = new  PrintWriter(arquivo);
			
			
		    // CRIA OBJ PARA CHAMAR METODO DO BANCO DE DADOS
			CrudProdutos crud = new CrudProdutos(); 
			
			pr.println("id,nome (marca),nome generico,laboratorio,quantidade,preco");
			for (Produto pro : crud.listarProdutos()) { // LISTA TODOS OS REGISTROS DO BANCO E ARMAZENA EM UM OBJ DO TIPO PRODUTO
				
				// ESCREVE NO ARQUIVO.
				pr.println(pro.getId()+","+pro.getNomeM()+","+pro.getNomeG()+","+pro.getLab()+","+pro.getQtn()+","+pro.getPreco());
			
			}
			
			pr.close();
			arquivo.close();	

			JOptionPane.showMessageDialog(null, "Arquivo criado com sucesso!!\n");
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}	
				
	}
}

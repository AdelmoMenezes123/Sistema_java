package View;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Label;




public class Tela extends JFrame{
	
	
	public Tela(){
		this.criandoJanela();
		this.criandoBotoes();
		this.criandoTable();
		this.criandoTextfild();
		this.criandoLabels();
	}
	
	
	public void criandoJanela() {
		
		setTitle("Sistema Drogaria");					//O nome da janela
		setSize(700,600);								// Largura e Tamanho da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//fecha a aplicacao quando aperta para sair da janela.
		setResizable(false);							// nao rederezar a janela JANELA STATICA
		setLocationRelativeTo(null); 					// iniciar a janela centralizada
		setVisible(true);								// vizualiza a tela
	}
	
	public void criandoBotoes() {
		
		//-------------------------- CRIANDO BOTOES -------------------------------------------------------------------------
				//-----------> IMPORTA
				JButton importa_btn = new JButton("IMPORTAR");	//cria obj da classe jbutton
				getContentPane().setLayout(null); 			// Nao Ultilizar layout, add componetes de conta propria
				importa_btn.setBounds(4,188,96,32);			// (horizontal, vertical, largura, altura)
				importa_btn.setVisible(true);
				getContentPane().add(importa_btn);	           //add botao a janela
				//----------> EXPORTA
				JButton exporta_btn = new JButton("EXPORTAR");
				getContentPane().setLayout(null); 		
				exporta_btn.setBounds(110,188,96,32);		
				exporta_btn.setVisible(true);
				getContentPane().add(exporta_btn);
				//------>GRAFICO
				JButton grafico_btn = new JButton("GRAFICO");
				grafico_btn.setBounds(216, 188, 96, 32);
				grafico_btn.setVisible(true);
				getContentPane().add(grafico_btn);
				//----------> PESQUISAR
				JButton pesquisar_btn = new JButton("PESQUISAR");
				getContentPane().setLayout(null); 		
				pesquisar_btn.setBounds(566,188,118,32);	
				pesquisar_btn.setVisible(true);
				getContentPane().add(pesquisar_btn);
				//----------> PESQUISAR
				JButton addGrafico_btn = new JButton("ADD NO GRAFICO");
				getContentPane().setLayout(null); 		
				addGrafico_btn.setBounds(550,91,121,44);	
				addGrafico_btn.setVisible(true);
				getContentPane().add(addGrafico_btn);
				//-------> LIGAR
				JButton conectar_btn = new JButton("CONECTAR");
				conectar_btn.setBounds(198, 11, 89, 23);
				conectar_btn.setVisible(true);
				getContentPane().add(conectar_btn);
				//-----------> DESLIGAR
				JButton desconectar_btn = new JButton("DESCONECTAR");
				desconectar_btn.setBounds(297, 11, 108, 23);
				desconectar_btn.setVisible(true);
				getContentPane().add(desconectar_btn);
				//------------------------------------------------------------------------------------
	}
	
	public void criandoLabels() {
		
		//-----------------------CRIANDO LABELS----------------------------------------------
				//-------> ID
				Label id_Label = new Label("ID"); 						// cria e da o nome para a label
				id_Label.setFont(new Font("Arial", Font.BOLD, 15)); // Adiciona font BOLD, ARIAL E 15 de tamanho da fonte
				id_Label.setBounds(10, 70, 46, 25); 						//horizontal, vertical, largura e altura
				id_Label.setVisible(true);
				getContentPane().add(id_Label);							 // add o label na janela principal
				//--------> NOME
				Label nome_Label = new Label("NOME");
				nome_Label.setFont(new Font("Arial", Font.BOLD, 15));
				nome_Label.setBounds(110, 70, 46, 25);
				nome_Label.setVisible(true);
				getContentPane().add(nome_Label);
				//-----------> QUANTIDADE
				Label qtn_Label = new Label("QUANTIDADE");
				qtn_Label.setFont(new Font("Arial", Font.BOLD, 15));
				qtn_Label.setBounds(331, 70, 108, 25);
				qtn_Label.setVisible(true);
				getContentPane().add(qtn_Label);
				//----------> PRECO
				Label preco_Label = new Label("PRECO");
				preco_Label.setFont(new Font("Arial", Font.BOLD, 15));
				preco_Label.setBounds(454, 70, 71, 25);
				preco_Label.setVisible(true);
				getContentPane().add(preco_Label);
				//--------->Pesquisa
				Label pesquisa_Label = new Label("ID do produto");
				pesquisa_Label.setFont(new Font("Arial", Font.BOLD, 15));
				pesquisa_Label.setBounds(437, 171, 108, 14);
				pesquisa_Label.setVisible(true);
				getContentPane().add(pesquisa_Label);
				
				
				
				//-----------------------------------------------------------------------------------

	}
	
	public void criandoTextfild() {

		//-----------------------CRIANDO TEXTFILD ------------------------------------------
		//--------> ID
		TextField id_TextField = new TextField();  				// cria e da o nome para a TEXTFILD
		id_TextField.setBounds(4, 103, 80, 32);					//horizontal, vertical, largura e altura
		id_TextField.setColumns(10);
		id_TextField.setVisible(true);
		getContentPane().add(id_TextField);						//add o TEXTFILD na janela principal
		//--------> NOME
		TextField nome_TextField = new TextField();
		nome_TextField.setBounds(110, 103, 199, 32);
		getContentPane().add(nome_TextField);
		nome_TextField.setVisible(true);
		nome_TextField.setColumns(10);
		//--------> QUANTIDADE
		TextField qtd_TextField = new TextField();
		qtd_TextField.setBounds(331, 102, 93, 34);
		getContentPane().add(qtd_TextField);
		qtd_TextField.setVisible(true);
		qtd_TextField.setColumns(10);
		//--------> PRECO
		TextField preco_TextField = new TextField();
		preco_TextField.setBounds(454, 102, 71, 34);
		getContentPane().add(preco_TextField);
		preco_TextField.setVisible(true);
		preco_TextField.setColumns(10);
		//--------> PESQUISA
		TextField pesquisa_TextField = new TextField();
		pesquisa_TextField.setBounds(437, 194, 119, 26);
		getContentPane().add(pesquisa_TextField);
		pesquisa_TextField.setVisible(true);
		pesquisa_TextField.setColumns(10);
		
	//--------------------------------------------------------------------------------------
	
	}
	
	public void criandoTable() {
		
		//----------------------- CRIANDO TABELA  --------------------------------------------------------
		
		JTable table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 13));
		table.setBounds(0, 227, 694, 345);
		table.setVisible(true);
		getContentPane().add(table);
		//------------------------------------------------------------------------------------------------
	}
}


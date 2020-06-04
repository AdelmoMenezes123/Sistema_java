package View;


import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;



public class Tela extends JFrame{

	public Tela(){
		
		setTitle("Sistema Drogaria");					//O nome da janela
		setSize(700,500);								// Largura e Tamanho da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//fecha a aplicacao quando aperta para sair da janela.
		setLocationRelativeTo(null); 					// inicia a janela centralizada
		setVisible(true);								// vizualiza a tela
		
		//-------------------------- crinado Botoes -------------------------------------------------------------------------
		//-----------> IMPORTA
		JButton importa = new JButton("IMPORTAR");	//cria obj da classe jbutton
		getContentPane().setLayout(null); 			// Nao Ultilizar layout, add componetes de conta propria
		importa.setBounds(21,117,96,32);			// (horizontal, vertical, largura, altura)
		importa.setVisible(true);
		getContentPane().add(importa);	           //add botao a janela
		//----------> EXPORTA
		JButton exporta = new JButton("EXPORTAR");
		getContentPane().setLayout(null); 		
		exporta.setBounds(127,117,96,32);		
		exporta.setVisible(true);
		getContentPane().add(exporta);
		//------>GRAFICO
		JButton grafico = new JButton("GRAFICO");
		grafico.setBounds(233, 117, 96, 32);
		grafico.setVisible(true);
		getContentPane().add(grafico);
		//----------> PESQUISAR
		JButton pesquisar = new JButton("PESQUISAR");
		getContentPane().setLayout(null); 		
		pesquisar.setBounds(538,117,118,32);	
		pesquisar.setVisible(true);
		getContentPane().add(pesquisar);
		//----------> PESQUISAR
		JButton addGrafico = new JButton("ADD NO GRAFICO");
		getContentPane().setLayout(null); 		
		addGrafico.setBounds(535,45,121,32);	
		addGrafico.setVisible(true);
		getContentPane().add(addGrafico);
		//------------------------------------------------------------------------------------
	
		//-----------------------CRIANDO LABELS----------------------------------------------
		//-------> ID
		JLabel id_JLabel = new JLabel("ID"); 						// cria e da o nome para a label
		id_JLabel.setFont(new Font("Arial", Font.BOLD, 15)); // Adiciona font BOLD, ARIAL E 15 de tamanho da fonte
		id_JLabel.setHorizontalAlignment(SwingConstants.LEFT);	 // coloca a label para esquerda
		id_JLabel.setBounds(21, 33, 46, 25); 						//horizontal, vertical, largura e altura
		getContentPane().add(id_JLabel);							 // add o label na janela principal
		//--------> NOME
		JLabel nome_JLabel = new JLabel("NOME");
		nome_JLabel.setFont(new Font("Arial", Font.BOLD, 15));
		nome_JLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nome_JLabel.setBounds(111, 33, 46, 25);
		getContentPane().add(nome_JLabel);
		//-----------> QUANTIDADE
		JLabel qtn_JLabel = new JLabel("QUANTIDADE");
		qtn_JLabel.setFont(new Font("Arial", Font.BOLD, 15));
		qtn_JLabel.setHorizontalAlignment(SwingConstants.LEFT);
		qtn_JLabel.setBounds(331, 33, 108, 25);
		getContentPane().add(qtn_JLabel);
		//----------> PRECO
		JLabel preco_JLabel = new JLabel("PRECO");
		preco_JLabel.setFont(new Font("Arial", Font.BOLD, 15));
		preco_JLabel.setHorizontalAlignment(SwingConstants.LEFT);
		preco_JLabel.setBounds(454, 33, 71, 25);
		getContentPane().add(preco_JLabel);
		//--------->Pesquisa
		JLabel pesquisa_JLabel = new JLabel("ID do produto");
		pesquisa_JLabel.setFont(new Font("Arial", Font.BOLD, 15));
		pesquisa_JLabel.setHorizontalAlignment(SwingConstants.LEFT);
		pesquisa_JLabel.setBounds(409, 102, 108, 14);
		getContentPane().add(pesquisa_JLabel);
		//-----------------------------------------------------------------------------------
		
		//-----------------------CRIANDO TEXTFILD
		//--------> ID
		JTextField id_JTextField = new JTextField();  				// cria e da o nome para a TEXTFILD
		id_JTextField.setBounds(20, 57, 80, 20);					//horizontal, vertical, largura e altura
		id_JTextField.setColumns(10);
		getContentPane().add(id_JTextField);						//add o TEXTFILD na janela principal
		//--------> NOME
		JTextField nome_JTextField = new JTextField();
		nome_JTextField.setBounds(111, 57, 199, 20);
		getContentPane().add(nome_JTextField);
		nome_JTextField.setColumns(10);
		//--------> QUANTIDADE
		JTextField quantidade_JTextField = new JTextField();
		quantidade_JTextField.setBounds(335, 57, 93, 20);
		getContentPane().add(quantidade_JTextField);
		quantidade_JTextField.setColumns(10);
		//--------> PRECO
		JTextField preco_JTextField = new JTextField();
		preco_JTextField.setBounds(454, 57, 71, 20);
		getContentPane().add(preco_JTextField);
		preco_JTextField.setColumns(10);
		//--------> PESQUISA
		JTextField pesquisa_JTextField = new JTextField();
		pesquisa_JTextField.setBounds(409, 123, 119, 20);
		getContentPane().add(pesquisa_JTextField);
		pesquisa_JTextField.setColumns(10);
		//-------------------------------------------------------------------------
		
		
	}
}


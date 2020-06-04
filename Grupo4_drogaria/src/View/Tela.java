package View;


import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class Tela extends JFrame{
	// declarando as variaveis que serao usadas no TEXTFILD
	private JTextField id;
	private JTextField nome;
	private JTextField quantidade;
	private JTextField preco;
	private JTextField pesquisa;


	public Tela(){
		
		setTitle("Sistema Drogaria");					//O nome da janela
		setSize(700,500);								// Largura e Tamanho da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//feicha a aplicacao quando aperta para sair da janela.
		setLocationRelativeTo(null); 					// inicia a janela centralizada
		setVisible(true);
		
		//-------------------------- crinado Botoes -------------------------------------------------------------------------
		//-----------> IMPORTA
		JButton importa = new JButton("IMPORTA");
		getContentPane().setLayout(null); 		// nao Ultilizar layout, add componetes de conta propria
		importa.setBounds(21,117,96,32);			// 4 parametros (horizontal em px,vertical, largura, altura)
		importa.setVisible(true);
		getContentPane().add(importa);
		//----------> EXPORTA
		JButton exporta = new JButton("EXPORTA");
		getContentPane().setLayout(null); 		// nao Ultilizar layout, add componetes de conta propria
		exporta.setBounds(146,117,96,32);			// 4 parametros (horizontal em px,vertical, largura, altura)
		exporta.setVisible(true);
		getContentPane().add(exporta);
		//----------> PESQUISAR
		JButton pesquisar = new JButton("PESQUISAR");
		getContentPane().setLayout(null); 		// nao Ultilizar layout, add componetes por conta propria
		pesquisar.setBounds(545,117,96,32);	//horizontal, vertical, largura e altura
		pesquisar.setVisible(true);
		getContentPane().add(pesquisar);
		//------------------------------------------------------------------------------------
	
		//-----------------------CRIANDO LABELS----------------------------------------------
		//-------> ID
		JLabel id = new JLabel("ID"); 						// cria e da o nome para a label
		id.setHorizontalAlignment(SwingConstants.LEFT);	 // coloca a label para esquerda
		id.setBounds(21, 33, 46, 25); 						//horizontal, vertical, largura e altura
		getContentPane().add(id);							 // add o label na janela principal
		//--------> NOME
		JLabel nome = new JLabel("NOME");
		nome.setHorizontalAlignment(SwingConstants.LEFT);
		nome.setBounds(111, 33, 46, 25);
		getContentPane().add(nome);
		//-----------> QUANTIDADE
		JLabel qtn = new JLabel("QUANTIDADE");
		qtn.setHorizontalAlignment(SwingConstants.LEFT);
		qtn.setBounds(338, 33, 90, 25);
		getContentPane().add(qtn);
		//----------> PRECO
		JLabel preco = new JLabel("PRECO");
		preco.setHorizontalAlignment(SwingConstants.LEFT);
		preco.setBounds(423, 33, 46, 25);
		getContentPane().add(preco);
		//-----------------------------------------------------------------------------------
		
		//-----------------------CRIANDO TEXTFILD
		//--------> ID
		this.id = new JTextField();  			// cria e da o nome para a TEXTFILD
		this.id.setBounds(20, 57, 80, 20);		//horizontal, vertical, largura e altura
		getContentPane().add(this.id);			//add o TEXTFILD na janela principal
		//--------> NOME
		this.nome = new JTextField();
		this.nome.setBounds(111, 57, 217, 20);
		getContentPane().add(this.nome);
		this.nome.setColumns(10);
		//--------> QUANTIDADE
		this.quantidade = new JTextField();
		this.quantidade.setBounds(342, 57, 63, 20);
		getContentPane().add(this.quantidade);
		this.quantidade.setColumns(10);
		//--------> PRECO
		this.preco = new JTextField();
		this.preco.setBounds(420, 57, 86, 20);
		getContentPane().add(this.preco);
		this.preco.setColumns(10);
		//--------> PESQUISA
		this.pesquisa = new JTextField();
		this.pesquisa.setBounds(449, 123, 86, 20);
		getContentPane().add(this.pesquisa);
		this.pesquisa.setColumns(10);
		//-------------------------------------------------------------------------
		
		
	}
}


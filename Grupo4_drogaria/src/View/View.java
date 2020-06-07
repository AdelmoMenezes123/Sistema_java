package View;

import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import Grupo4.ImportaCSV;
import Grupo4.Produto;
import javax.swing.JLabel;

public class View extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public static JButton pesquisar_btn;
	public static JButton importa_btn;
	public static Label arquivo_Label;

	public static JButton pesq_id;
	public static JButton btnAtualizar;
	public static JButton btnGrafico;
	public static JButton btnExportar;
	public static JButton btnAddGrafico;

	public static JFileChooser fc;
	public static String caminho;
	public static FileNameExtensionFilter filtro = new FileNameExtensionFilter(" *.csv", "csv");
	Produto p = new Produto();

	public static TextField caixaArquivo;
	public static TextField caixaPesquisar;
	public static TextField caixaProduto;

	public static JLabel labelProdutos;
	public static JLabel labelPreco;
	public static JLabel labelId;
	public static JLabel labelQuantidade;
	public static TextField caixaQuantidade;
	public static TextField caixaPreco;
	public static Label labelIdUpdate;

	public View() { // CONSTRUTOR DA CLASSE VIEW
		criarJanela();// CHAMANDO O METODO CRIAR JANELA

		// CHAMANDO METODOS DE CRIAR BOTOES
		btnPesqArquivo();
		btnImporta();
		btnGrafico();
		btnAddGrafico();
		btnPesquisar();
		btnAtualizar();
		btnExportar();

//		CHAMANDO METODOS DE CRIAR LABELS
		labelArquivo();
		labelPesqProdutos();
		labelQuantidade();
		labelId();
		labelUpdate();

//		CHAMANDO METODS DE CRIAR CAIXA DE (TEXTFILD)
		caixaArquivo();
		caixaPesquisar();
		caixaProduto();
		caixaQuantidade();
		caixaPreco();

	}

	// -------------------------> criar janela
	public void criarJanela() {
		setTitle("Sistema Drogaria"); // O nome da janela
		setSize(700, 600); // Largura e Tamanho da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fecha a aplicacao quando aperta para sair da janela.
		setResizable(false); // nao rederezar a janela JANELA STATICA
		setLocationRelativeTo(null); // iniciar a janela centralizada
		setVisible(true); // vizualiza a tela
	}

	// -------------------------------- botoes
	// ---------------------------------------------------------------------------------------------

	// ---------------------------> BOTAO DE PESQUISAR ARQUIVO
	public void btnPesqArquivo() {
		pesquisar_btn = new JButton("PESQUISAR");
		pesquisar_btn.addActionListener(new ActionListener() { // CRIANDO ACAO AO CLICAR NO BOTAO (PESQUISAR) ABRE
																// JANELA DE ARQUIVOS
			public void actionPerformed(java.awt.event.ActionEvent e) {
				fc = new JFileChooser("C:\\Users\\usuario\\Desktop\\"); // JA COMECA NO DIRETORIO DESKTOP QUANDO FOR
																		// PESQUISAR O ARQUIVO
				fc.setFileFilter(filtro); // FILTRAR OS ARQUIVOS POR CSV TA DECLARADO PERTO DOS IMPORTS
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY); // ADD APENAS ARQUIVO
				fc.showOpenDialog(fc); /// CAIXA DE DIALOGO ONDE VOU ESCOLHER O DIRETORIO DO ARQUIVO
				fc.setDialogTitle("Procurar arquivo"); // TITULO DA CAIXA
				fc.setBounds(493, 50, 400, 300);
				File f = fc.getSelectedFile(); // ARQUIVO SELECIONADO
				caixaArquivo.setText(f.getPath()); // PEGA O CAMINHO DO ARQUIVO E COLOCA NA CAIXAARQUIVO
				caminho = f.getPath();// COLOCANDO O CAMINHO NA VARIAVEL QUE VAI PARA FUNCAO LER ARQUIVO
			}
		});
		getContentPane().setLayout(null);// CONFIGURACAO DE LAYOUT MANUAL
		pesquisar_btn.setBounds(493, 50, 118, 32);
		getContentPane().add(pesquisar_btn);
//				getContentPane().setLayout(null);

	}

//------------------------------> BOTAO DE IMPORTAR
	public void btnImporta() {
		importa_btn = new JButton("IMPORTAR");
		importa_btn.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				try {

					ImportaCSV.lerArquivoCSV(caminho);
					// EnviarProdutos();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		importa_btn.setBounds(74, 111, 96, 32);
		importa_btn.setVisible(true);
		getContentPane().add(importa_btn);
		getContentPane().setLayout(null);
	}

//--------------------------------> BOTAO DO GRAFICO
	public void btnGrafico() {
		btnGrafico = new JButton("GRAFICO");
		btnGrafico.setBounds(279, 111, 89, 32);// HORIZONTAL, VERTICAL, LARGUTA ALTURA
		getContentPane().add(btnGrafico); // ADD NA JANELA
	}

//---------------------------------------------->BOTAO DE ADD GRAFICO
	public void btnAddGrafico() {
		btnAddGrafico = new JButton("ADD no grafico");
		btnAddGrafico.setBounds(41, 257, 128, 23);
		getContentPane().add(btnAddGrafico);
	}

//-----------------------------------> BOTAO DE PESQUISAR ID
	public void btnPesquisar() {
		pesq_id = new JButton("Pesquisar");
		pesq_id.setBounds(528, 180, 89, 23);
		getContentPane().add(pesq_id);
	}

//---------------------------------------> BOTAO DE ATUALIZAR PRODUTO
	public void btnAtualizar() {
		btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.setBounds(540, 257, 89, 23);
		getContentPane().add(btnAtualizar);
	}

//-------------------------------------------> BOTAO DE EXPORTAR ARQUIVO SCV
	public void btnExportar() {
		btnExportar = new JButton("Exporta");
		btnExportar.setBounds(180, 111, 89, 32);
		getContentPane().add(btnExportar);
	}
//-------------------------------------------------------------------------------------------

//----------------------------CRIANDO LABELS---------------------------------------------------------------

//-------------------------------------------> LABEL ARQUIVO
	public void labelArquivo() {
		// -------> ARQIVO
		arquivo_Label = new Label("Arquivo :");
		arquivo_Label.setFont(new Font("Arial", Font.BOLD, 15));
		arquivo_Label.setBounds(10, 50, 69, 25);
		arquivo_Label.setVisible(true); // DEIXA VISIVEL O OBJETO
		getContentPane().add(arquivo_Label);
	}

	// -------------------------------------------> LABEL PRODUTO
	public void labelPesqProdutos() {
		labelProdutos = new JLabel("Produto");
		labelProdutos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelProdutos.setBounds(54, 175, 77, 32);
		getContentPane().add(labelProdutos);
	}

	// -------------------------------------------> LABEL QUANTIDADE
	public void labelQuantidade() {
		labelQuantidade = new JLabel("QUANTIDADE");
		labelQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelQuantidade.setBounds(331, 233, 86, 14);
		getContentPane().add(labelQuantidade);
	}

	// -------------------------------------------> LABEL PRECO
	public void labelPreco() {
		labelPreco = new JLabel("PRECO");
		labelPreco.setBounds(441, 237, 46, 14);
		getContentPane().add(labelPreco);
	}

	// -------------------------------------------> LABEL ID
	public void labelId() {
		labelId = new JLabel("ID");
		labelId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelId.setBounds(459, 156, 46, 14);
		getContentPane().add(labelId);
	}

	// ---------------------------------------> LABEL PRECO
	public void labelUpdate() {
		labelIdUpdate = new Label("PRECO");
		labelIdUpdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelIdUpdate.setBounds(441, 233, 64, 14);
		getContentPane().add(labelIdUpdate);
	}

	// -------------------------------------------------------------------------------------------

	// ---------------------------CRIANDO CAIXA
	// TEXTFILD-------------------------------------------------------------------

	// -----------------------------------> CAIXA DE ARQUIVOS
	public void caixaArquivo() {
		caixaArquivo = new TextField();
		caixaArquivo.setBounds(80, 50, 407, 32); // horizontal, vertical, largura e altura
		caixaArquivo.setColumns(10);
		caixaArquivo.setVisible(true);
		getContentPane().add(caixaArquivo);
	}

	// -----------------------------------> CAIXA DE PESQUISA ID
	public void caixaPesquisar() {
		caixaPesquisar = new TextField();
		caixaPesquisar.setBounds(459, 181, 59, 23);
		getContentPane().add(caixaPesquisar);
		caixaPesquisar.setColumns(10);
	}

	// -----------------------------------> CAIXA DE PRODUTOS
	public void caixaProduto() {
		caixaProduto = new TextField();
		caixaProduto.setBounds(104, 180, 292, 23);
		getContentPane().add(caixaProduto);
		caixaProduto.setColumns(10);
	}

	// -------------------------------------> CAIXA QUANTIDADE
	public void caixaQuantidade() {
		caixaQuantidade = new TextField();
		caixaQuantidade.setBounds(331, 257, 86, 20);
		getContentPane().add(caixaQuantidade);
		caixaQuantidade.setColumns(10);
	}

	/// -------------------------- CAIXA PRECO
	public void caixaPreco() {
		caixaPreco = new TextField();
		caixaPreco.setBounds(434, 258, 86, 20);
		getContentPane().add(caixaPreco);
		caixaPreco.setColumns(10);
	}
//------------------------------------------------------------------------------------------------------------------------------

}

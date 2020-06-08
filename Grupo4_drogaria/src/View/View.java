package View;

import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Grupo4.ImportaCSV;
import model.produ.CrudProdutos;
import model.produ.Produto;
import model.produ.TableModelProd;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import java.awt.Component;

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
//	Produto p = new Produto();

	public static TextField caixaArquivo;
	public static TextField caixaPesquisar;
	public static TextField caixaProduto;

	public static JLabel labelProdutos;
	public static JLabel labelPreco;
	public static JLabel labelId ;
	public static JLabel labelQuantidade;
	public static TextField caixaQuantidade;
	public static TextField caixaPreco;
	public static Label labelIdUpdate;
	public static JTable table_1 ;
	private JScrollPane scrollPane;;
	
	

	public View() throws Exception {

		criarJanela();// CHAMANDO O METODO CRIAR JANELA
		criaTabela();
		// CHAMANDO METODOS DE CRIAR BOTOES
		btnPesqArquivo();
		btnImporta();
		btnGrafico();
		btnAddGrafico();
		btnPesquisar();
		btnAtualizar();
		btnExportar();
		btnVizu();

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
	

// ---------------------------------------->CRIA TABELA
	public void criaTabela()  {
		{ 
			scrollPane = new JScrollPane(); // BARRA DE ROLAGEM
			scrollPane.setBounds(0, 336, 694, 236);
			getContentPane().add(scrollPane);
			table_1 = new JTable(); // TABELA
			scrollPane.setViewportView(table_1); // MOSTRA SCROL
			table_1.setModel(new DefaultTableModel( // SETANDO O VALOR DAS COLUNAS 
				new Object[][] { // COLUNAS QUE VAI INICIA UM NOVO PRODUTO
				},
				new String[] {
					"ID", "NOME MARCA", "QUANTIDADE", "PRECO" // HEADER
				}
			) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				boolean[] columnEditables = new boolean[] {
					false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			table_1.getColumnModel().getColumn(0).setPreferredWidth(83);
			table_1.getColumnModel().getColumn(0).setMaxWidth(1111111);
			table_1.getColumnModel().getColumn(1).setPreferredWidth(299);
			table_1.getColumnModel().getColumn(2).setPreferredWidth(120);
			table_1.getColumnModel().getColumn(3).setPreferredWidth(97);
		}
	}
	public void scrol() {
		
	}

	// -------------------------> CRIA JANELA ----------------------------------
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

	public void addProTable(Produto pro) { // LER TABELA
		 
			DefaultTableModel model = (DefaultTableModel) table_1.getModel();   // CARREGANDO O MODELO... RECEBENDO UMA LISTA     
	        model.addRow(new Object[] {pro.getId(), pro.getNomeM(), pro.getPreco(), pro.getQtn()});	  //SETANDO OS VALORES P/ CADA LINHA   
	      //  System.out.println(model.getDataVector());
	}
		

	public void btnVizu() {
		JButton btnVizualiza = new JButton("VER LISTA");
		btnVizualiza.setFont(new Font("Tahoma", Font.BOLD, 11));
		// DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		
		btnVizualiza.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {		        
		        try {
		        	
		        	
					for (Produto pro : CrudProdutos.listarProdutos()) { // CARREGANDO LISTA QUE DE PRODUTOS DO BANCO 
						
						addProTable(pro); //INSERINDO NA TABELA
					}
					criaTabela(); //INICIANDO TABELA AO CLICAR NO BOTAO
					
				} catch (Exception e) {
					System.out.println("erro ao add :"+ e);
					e.printStackTrace();
				}
				
			}
		});
		btnVizualiza.setBounds(10, 307, 661, 23);
		getContentPane().add(btnVizualiza);
	}

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
				if (fc.getSelectedFile() != null) { // SE ARQUIVO SELECIONADO
					caixaArquivo.setText(f.getPath()); // FACA O CAMINHO DO DIREITORIO APARECER NO TEXTFILD
					caminho = f.getPath();// COLOCANDO O CAMINHO NA VARIAVEL QUE VAI PARA FUNCAO LER ARQUIVO
				}

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
		importa_btn.addActionListener(new ActionListener() { // ACAO AO CLICAR NO BOTAO
			public void actionPerformed(java.awt.event.ActionEvent e) {
				try {

					if (caminho != null) { // SE O CAMINHO OBTIDO NO BOTAO DE PESQUISA FOR DIFERENTE DE NULL
						ImportaCSV.lerArquivoCSV(caminho); // ENVIE O CAMINHO PARA O METODO QUE VAI LE O ARQUIVO
						Produto p = new Produto() ;//OBJTS QUE VAI RECEBER A LISTA 
						CrudProdutos crud = new CrudProdutos();// OBJ PARA CHAMAR O INSERT
						crud.crate(p); // INSERT  
					} else {
						JOptionPane.showMessageDialog(null, "Caminho vazio add um arquivo");// JANELA
					}

				} catch (Exception e1) {
					System.out.println("Eita deu Erro: " + e1);
				}

			}
		});

		importa_btn.setBounds(81, 111, 89, 32);
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
		btnAddGrafico = new JButton("ADD NO GRAFICO");
		btnAddGrafico.setBounds(104, 202, 148, 32);
		getContentPane().add(btnAddGrafico);
	}

//-----------------------------------> BOTAO DE PESQUISAR ID
	public void btnPesquisar() {
		pesq_id = new JButton("PESQUISAR");
		pesq_id.setBounds(528, 174, 89, 32);
		getContentPane().add(pesq_id);
	}

//---------------------------------------> BOTAO DE ATUALIZAR PRODUTO
	public void btnAtualizar() {
		btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.setBounds(533, 248, 103, 32);
		getContentPane().add(btnAtualizar);
	}

//-------------------------------------------> BOTAO DE EXPORTAR ARQUIVO SCV
	public void btnExportar() {
		btnExportar = new JButton("EXPORTAR");
		btnExportar.setBounds(180, 111, 89, 32);
		getContentPane().add(btnExportar);
	}
//-------------------------------------------------------------------------------------------

//----------------------------CRIANDO LABELS---------------------------------------------------------------

//-------------------------------------------> LABEL ARQUIVO
	public void labelArquivo() {
		// -------> ARQIVO
		arquivo_Label = new Label("Arquivo ");
		arquivo_Label.setFont(new Font("Arial", Font.BOLD, 15));
		arquivo_Label.setBounds(10, 50, 69, 25);
		arquivo_Label.setVisible(true); // DEIXA VISIVEL O OBJETO
		getContentPane().add(arquivo_Label);
	}

	// -------------------------------------------> LABEL PRODUTO
	public void labelPesqProdutos() {
		labelProdutos = new JLabel("Produto");
		labelProdutos.setHorizontalAlignment(SwingConstants.LEFT);
		labelProdutos.setFont(new Font("Arial Black", Font.BOLD, 13));
		labelProdutos.setBounds(24, 174, 76, 32);
		getContentPane().add(labelProdutos);
	}

	// -------------------------------------------> LABEL QUANTIDADE
	public void labelQuantidade() {
		labelQuantidade = new JLabel("QUANTIDADE");
		labelQuantidade.setFont(new Font("Arial", Font.BOLD, 13));
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
		labelId.setHorizontalAlignment(SwingConstants.LEFT);
		labelId.setFont(new Font("Arial", Font.BOLD, 13));
		labelId.setBounds(441, 154, 46, 14);
		labelId.setVisible(true);
		getContentPane().add(labelId);
	}

	// ---------------------------------------> LABEL PRECO
	public void labelUpdate() {
		labelIdUpdate = new Label("PRECO");
		labelIdUpdate.setFont(new Font("Arial", Font.BOLD, 13));
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
		caixaPesquisar.setBounds(441, 174, 77, 30);
		getContentPane().add(caixaPesquisar);
		caixaPesquisar.setColumns(10);
	}

	// -----------------------------------> CAIXA DE PRODUTOS
	public void caixaProduto() {
		caixaProduto = new TextField();
		caixaProduto.setBounds(104, 174, 292, 29);
		getContentPane().add(caixaProduto);
		caixaProduto.setColumns(10);
	}

	// -------------------------------------> CAIXA QUANTIDADE
	public void caixaQuantidade() {
		caixaQuantidade = new TextField();
		caixaQuantidade.setBounds(331, 252, 86, 28);
		getContentPane().add(caixaQuantidade);
		caixaQuantidade.setColumns(10);
	}

	/// -------------------------- CAIXA PRECO
	public void caixaPreco() {
		caixaPreco = new TextField();
		caixaPreco.setBounds(441, 252, 86, 28);
		getContentPane().add(caixaPreco);
		caixaPreco.setColumns(10);

	}
}


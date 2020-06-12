package View;

import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import model.produ.Produto;
import produ.DAO.CrudProdutos;
import produ.DAO.ManipulaCSV;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

import java.awt.Button;
import java.awt.SystemColor;
import java.awt.TextArea;


public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	public static Button pesquisar_btn = new Button("PESQUISAR");;
	public static Button importa_btn = new Button("IMPORTAR");
	public static Button pesq_id = new Button("PESQUISAR");;
	public static Button btnAtualizar = new Button("ATUALIZAR");;
	public static Button btnGrafico = new Button("GRÁFICO");;
	public static Button btnExportar = new Button("EXPORTAR");;
	public static Button btnAddGrafico = new Button("ADD NO GRÁFICO");
	public Button btnVizualiza = new Button("VER LISTA");

	public static ChartPanel painel;
	public JFreeChart grafico;
	public static DefaultPieDataset graficoProdutos = new DefaultPieDataset();;
	public JFrame grafi = new JFrame();
	public  JTable table_1 = new JTable();;
	private JScrollPane scrollPane;
	public static JFileChooser fc;
	public static String caminho;
	public static FileNameExtensionFilter filtro = new FileNameExtensionFilter(" *.csv", "csv");

	public Double prec = 0.0;
	public int quanti = -1;
	public int id = 0;
	public int idADD = 0;

	// TEXTFILDS
	public static TextField caixaQuantidade;
	public static TextField caixaPreco;
	public static TextField caixaArquivo;
	public static TextField caixaPesquisar;
	public TextArea buscaID;
	// LABELS
	public static Label labelProdutos = new Label("PRODUTO A SER  EDITADO OU ADICIONADO NA LISTA");
	public static Label labelId = new Label("ID");
	public static Label labelQuantidade = new Label("QUANTIDADE");;
	public static Label labelIdUpdate = new Label("PREÇO");;
	public static Label arquivo_Label = new Label("Arquivo ");
	private TextField novoFile;

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
		caixaListProdutos();
		caixaCriaCaminho();
		
	}


	//----------------------------------------->CRIAR GRAFICO
	public void criarGrafico(DefaultPieDataset graficoProdutos ) {
		grafico = ChartFactory.createPieChart("GRÁFICO DE MEDICAMENTOS",graficoProdutos,true,true, false);
		painel = new ChartPanel(grafico);
		grafi.setLocationRelativeTo(null);
		grafi.setResizable(false);
//		grafi.setSize(800,800);
		grafi.getContentPane().add(painel);
		
	}
	//----------------------------- EXIBI GRAFICO
	public void GraficoProdutos() {
			grafi.setTitle("Grafico dos produtos");
			grafi.setSize(800,700);
			grafi.setLocationRelativeTo(null);
			grafi.setVisible(true);
			grafi.setResizable(false);
	}
	// ---------------------------------------->CRIAR TABELA
	public void criaTabela() {
		{
			scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setBounds(0, 425, 794, 236);
			getContentPane().add(scrollPane);
			table_1 = new JTable(); // TABELA
			scrollPane.setViewportView(table_1); // MOSTRA SCROL
			table_1.setModel(new DefaultTableModel( // SETANDO O VALOR DAS COLUNAS
					new Object[][] { // COLUNAS QUE VAI INICIA UM NOVO PRODUTO
					}, new String[] { "ID", "NOME MARCA", "QUANTIDADE", "PREÇO" }) {// HEADER
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				boolean[] columnEditables = new boolean[] { false, false, false, false };

				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
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
		setSize(800, 700); // Largura e Tamanho da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fecha a aplicacao quando aperta para sair da janela.
		setResizable(false); // nao rederezar a janela JANELA STATICA
		setLocationRelativeTo(null); // iniciar a janela centralizada
		setVisible(true); // vizualiza a tela
	}
	// -------------------------------- botoes
	// ---------------------------------------------------------------------------------------------

	public void addProTable(Produto pro) { // LER TABELA

		DefaultTableModel model = (DefaultTableModel) table_1.getModel(); // CARREGANDO O MODELO... RECEBENDO UMA LISTA
		model.addRow(new Object[] { pro.getId(), pro.getNomeM(), pro.getQtn(), pro.getPreco() }); // SETANDO OS VALORES
																									// P/ CADA LINHA
		// System.out.println(model.getDataVector());
	}

	public void btnVizu() {
		btnVizualiza.setBackground(SystemColor.activeCaption);
		btnVizualiza.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVizualiza.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {

					CrudProdutos crud = new CrudProdutos();
					for (Produto pro : crud.listarProdutos()) { // CARREGANDO LISTA QUE DE PRODUTOS DO BANCO

						addProTable(pro); // INSERINDO NA TABELA
					}
					criaTabela(); // INICIANDO TABELA AO CLICAR NO BOTAO

				} catch (Exception e) {
					System.out.println("ERRO ao add :" + e);

				}

			}
		});
		btnVizualiza.setBounds(0, 394, 794, 25);
		getContentPane().add(btnVizualiza);
	}

	// ---------------------------> BOTAO DE PESQUISAR ARQUIVO
	public void btnPesqArquivo() {
		pesquisar_btn.setBackground(SystemColor.activeCaption);

		pesquisar_btn.addActionListener(new ActionListener() { // CRIANDO ACAO AO CLICAR NO BOTAO (PESQUISAR) ABRE
																// JANELA DE ARQUIVOS
			public void actionPerformed(java.awt.event.ActionEvent e) {
				fc = new JFileChooser("C:\\Users\\usuario\\Desktop\\"); // JA COMECA NO DIRETORIO DESKTOP QUANDO FOR
																		// PESQUISAR O ARQUIVO
				fc.setFileFilter(filtro); // FILTRAR OS ARQUIVOS POR CSV TA DECLARADO PERTO DOS IMPORTS
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // ADD APENAS ARQUIVO
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
		pesquisar_btn.setBounds(637, 43, 125, 32);
		getContentPane().add(pesquisar_btn);
//				getContentPane().setLayout(null);

	}

//------------------------------> BOTAO DE IMPORTAR
	public void btnImporta() {
		importa_btn.setBackground(SystemColor.activeCaption);
		importa_btn.addActionListener(new ActionListener() { // ACAO AO CLICAR NO BOTAO
			public void actionPerformed(java.awt.event.ActionEvent e) {
				try {

					if (caminho != null) { // SE O CAMINHO OBTIDO NO BOTAO DE PESQUISA FOR DIFERENTE DE NULL
						ManipulaCSV.lerArquivoCSV(caminho); // ENVIE O CAMINHO PARA O METODO QUE VAI LE O ARQUIVO
						Produto p = new Produto();// OBJTS QUE VAI RECEBER A LISTA
						CrudProdutos crud = new CrudProdutos();// OBJ PARA CHAMAR O INSERT
						crud.crate(p); // INSERT
						caixaArquivo.setText("");
						caminho = "";
					} else {
						JOptionPane.showMessageDialog(null, "Caminho vazio add um arquivo");// JANELA
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "ERRO"+e1);
				}

			}
		});
		
		
		

		importa_btn.setBounds(397, 111, 89, 32);
		importa_btn.setVisible(true);
		getContentPane().add(importa_btn);
		getContentPane().setLayout(null);
	}

//--------------------------------> BOTAO DO GRAFICO
	public void btnGrafico() {
		btnGrafico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GraficoProdutos();
				//criarGrafico();		
			}
		});
		btnGrafico.setBackground(SystemColor.activeCaption);
		btnGrafico.setBounds(519, 111, 89, 32);// HORIZONTAL, VERTICAL, LARGUTA ALTURA
		getContentPane().add(btnGrafico); // ADD NA JANELA
	}

//---------------------------------------------->BOTAO DE ADD NO GRAFICO
	public void btnAddGrafico() {
		btnAddGrafico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ( idADD >0) {
									
					try {
						CrudProdutos crud = new CrudProdutos();
						
						//for (Produto pro : crud.listarPorId(idADD)) { // CARREGANDO LISTA DE PRODUTOS DO BANCO
						//CrudProdutos crud = new CrudProdutos(); 
						Produto pro = crud.listarPorId(idADD);
							
							pro.setQtn(pro.getQtn()) ;
							
							graficoProdutos.setValue("NOME: "+pro.getNomeG(), pro.getQtn());
							criarGrafico( graficoProdutos );
								
							JOptionPane.showMessageDialog(null,
						    "Adicionado no Grafico,\nMedicamento: "+pro.getNomeM()+"\nQuantidade: "+pro.getQtn());
							
							caixaPesquisar.setText(""); // ZORO A CAIXA DE PESQUISA
						//}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} 
				idADD = 0;
			}
		});
		btnAddGrafico.setBackground(SystemColor.activeCaption);
		btnAddGrafico.setBounds(614, 111, 148, 32);
		getContentPane().add(btnAddGrafico);
	}

//-----------------------------------> BOTAO DE PESQUISAR ID
	public void btnPesquisar() {

		pesq_id.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					id = Integer.parseInt(caixaPesquisar.getText());// CONVERTENDO PARA INT
					idADD =id;
					
					CrudProdutos crud = new CrudProdutos();
					//for (Produto pro : crud.listarPorId(id)) { // CARREGANDO LISTA DE PRODUTOS DO BANCO

						//CrudProdutos crud = new CrudProdutos();
						Produto pro =  crud.listarPorId(id);
						buscaID.setText("ID: (" + pro.getId() + ") " + "\nNOME MARCA: (" + pro.getNomeM()
								+ ")\nNOME GENERICO: (" + pro.getNomeG() + ")\nLABORATORIO: (" + pro.getLab()
								+ ")\nQUANTIDADE: (" + pro.getQtn() + ")\nPREÇO: (" + pro.getPreco() + ")");
						quanti = pro.getQtn();// VALOR VAI SER ULTIL QUANDO FOR ATUALIZAR
						prec = pro.getPreco();// GUARDANDO VALOR
				    //}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Sr(a), Porfavor insira o ID correto!");
				}

			}
		});
		pesq_id.setBackground(SystemColor.activeCaption);
		pesq_id.setBounds(654, 225, 108, 32);
		getContentPane().add(pesq_id);
	}

//---------------------------------------> BOTAO DE ATUALIZAR PRODUTO
	public void btnAtualizar() {
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrudProdutos crud = new CrudProdutos();
				try {
					id = Integer.parseInt(caixaPesquisar.getText());
					if (id > 0) { // CASO O USUARIO NAO TENHA DIGITADO O ID
						int qtd = Integer.parseInt(caixaQuantidade.getText());// VALOR DIGITADO NO CAMPO QUANTIDADE
						double preco = Double.parseDouble(caixaPreco.getText());// VALOR DIGITADO NO CAMPO PRECO
						if (( ((quanti >= 0 && quanti <=10)&& qtd > 0) || (quanti > 10 && qtd >= -1))// a quantidade nao pode ser menor que -1
								&& (((prec >= 5 && prec <= 50) && (preco >= 5 && preco <= 100))
										|| ((prec >= 49 && prec <= 380) && (preco >= 50 && preco <= 380)))) { 
							int qtdSomado = qtd + quanti;
							crud.update(qtdSomado, preco, id); // ATUALIZE BANCO!
							JOptionPane.showMessageDialog(null, "Atualizado com sucesso !!!");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Adicione valores correto !!!");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Pesquise o id primeiro e depois\n insira os dados correto!!");
				}
				caixaPesquisar.setText("");
				caixaQuantidade.setText("");
				caixaPreco.setText("");
				buscaID.setText("");
			}
		});
		btnAtualizar.setBackground(SystemColor.activeCaption);
		btnAtualizar.setBounds(670, 338, 103, 32);
		getContentPane().add(btnAtualizar);
	}

//-------------------------------------------> BOTAO DE EXPORTAR ARQUIVO SCV
	public void btnExportar() {
		btnExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if( caminho != null && novoFile.getText() != null && novoFile.getText() != "") {
						ManipulaCSV.escreverArquivoCSV(caminho,novoFile.getText()+".csv");
						caminho = "";
						caixaPesquisar.setText(""); // ZeRO A CAIXA DE PESQUISA
						novoFile.setText("");
					}else {
						JOptionPane.showMessageDialog(null,"Selecione a pasta que o arquivo vai ser gravado\ne Escreva o nome do novo Arquivo");	
					}
				} catch (Exception e) {
					System.out.println("ERRO: "+e.getMessage());		
				}
			}
		});
		btnExportar.setBackground(SystemColor.activeCaption);
		btnExportar.setBounds(286, 111, 89, 32);
		getContentPane().add(btnExportar);
	}
//-------------------------------------------------------------------------------------------

//----------------------------CRIANDO LABELS---------------------------------------------------------------

//-------------------------------------------> LABEL ARQUIVO
	public void labelArquivo() {
		// -------> ARQIVO
		arquivo_Label.setFont(new Font("Arial", Font.BOLD, 15));
		arquivo_Label.setBounds(129, 43, 69, 25);
		arquivo_Label.setVisible(true); // DEIXA VISIVEL O OBJETO
		getContentPane().add(arquivo_Label);
	}

	// -------------------------------------------> LABEL PRODUTO
	public void labelPesqProdutos() {
		labelProdutos.setFont(new Font("Arial Black", Font.BOLD, 13));
		labelProdutos.setBounds(10, 190, 393, 32);
		getContentPane().add(labelProdutos);
	}

	// -------------------------------------------> LABEL QUANTIDADE
	public void labelQuantidade() {

		labelQuantidade.setFont(new Font("Arial", Font.BOLD, 13));
		labelQuantidade.setBounds(453, 318, 86, 14);
		getContentPane().add(labelQuantidade);
	}

	// -------------------------------------------> LABEL ID
	public void labelId() {
		labelId.setFont(new Font("Arial", Font.BOLD, 13));
		labelId.setBounds(571, 205, 46, 14);
		labelId.setVisible(true);
		getContentPane().add(labelId);
	}

	// ---------------------------------------> LABEL PRECO
	public void labelUpdate() {
		labelIdUpdate.setFont(new Font("Arial", Font.BOLD, 13));
		labelIdUpdate.setBounds(580, 318, 86, 14);
		getContentPane().add(labelIdUpdate);
	}

	// -------------------------------------------------------------------------------------------

	// ---------------------------CRIANDO CAIXA
	// TEXTFILD-------------------------------------------------------------------

	// -----------------------------------> CAIXA DE ARQUIVOS
	public void caixaArquivo() {
		caixaArquivo = new TextField();
		caixaArquivo.setText("Pesquise o caminho do arquivo");
		caixaArquivo.setBounds(211, 43, 407, 32); // horizontal, vertical, largura e altura
		caixaArquivo.setColumns(10);
		caixaArquivo.setVisible(true);
		getContentPane().add(caixaArquivo);
	}

	// -----------------------------------> CAIXA DE PESQUISA ID
	public void caixaPesquisar() {
		caixaPesquisar = new TextField();
		caixaPesquisar.setBounds(571, 225, 77, 30);
		getContentPane().add(caixaPesquisar);
		caixaPesquisar.setColumns(10);
	}

	// -----------------------------------> CAIXA DE PRODUTOS
	public void caixaProduto() {
	}

	// -------------------------------------> CAIXA QUANTIDADE
	public void caixaQuantidade() {
		caixaQuantidade = new TextField();
		caixaQuantidade.setBounds(453, 338, 86, 28);
		getContentPane().add(caixaQuantidade);
		caixaQuantidade.setColumns(10);
	}

	/// -------------------------- CAIXA PRECO
	public void caixaPreco() {
		caixaPreco = new TextField();
		caixaPreco.setBounds(563, 338, 86, 28);
		getContentPane().add(caixaPreco);
		caixaPreco.setColumns(10);

	}

	// ----------------------------- CAIXA DE LISTAGEM

	public void caixaListProdutos() {
		buscaID = new TextArea();
		buscaID.setBounds(10, 225, 401, 158);
		getContentPane().add(buscaID);
	}
	
	public void caixaCriaCaminho() {
		novoFile = new TextField(); // TEXTFILD PARA CRIAR CAMINHO
		novoFile.setBounds(10, 111, 247, 32);
		getContentPane().add(novoFile);
		novoFile.setColumns(10);
		
		Label file = new Label("ESCREVA AQUI O NOME DO NOVO ARQUIVO"); // LABEL DO TEXTFILD
		file.setFont(new Font("Arial", Font.BOLD, 11));
		file.setBounds(10, 86, 247, 25);
		getContentPane().add(file);
	}
}

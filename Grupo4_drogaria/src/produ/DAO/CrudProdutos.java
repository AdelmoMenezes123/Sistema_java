package produ.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import factory.ConnectionFactory;
import model.produ.Produto;

public class CrudProdutos {

	private final static String INSERT = "INSERT INTO `remedios`(`Id`,`nomeMar`, `nomeGen`, `laboratorio`, `quantidade`, `preco`) VALUES (?,?,?,?,?,?)";
	private final static String UPDATE = "UPDATE `remedios` SET `quantidade`=?, `preco`=? WHERE `Id`=?";
//    private final static String DELETE = "DELETE FROM `remedios` WHERE ID =?";
	private final static String LISTA = "SELECT * FROM `remedios` ";
	private final static String LISTAID = "SELECT * FROM `remedios` WHERE Id=?";
	// private final String LISTABYID = "SELECT * FROM `remedios` WHERE `Id`=?";

	public CrudProdutos() {
	}

	int linhaAfetada = 0;

	public void crate(Produto p) throws Exception {
		Connection con = ConnectionFactory.getConnection();

		PreparedStatement stmt = null;
		try {

			for (int i = 0; i < ManipulaCSV.produtos.size(); i++) {// PERCORRE A LISTA QUE TEM O CSV  
				
				p = ManipulaCSV.produtos.get(i); // CARREGANDO LISTA PARA NO OBJ PRODUTO
				
				if(listarPorId(p.getId()) != null)  { // ANTES DE INSERIR NO BANCO OLHE SE JA EXISTE
					Produto p1 = listarPorId(p.getId()); // SE EXISTER COLOQUE O VALOR NESSE OBJETO
					int qtd = p.getQtn() + p1.getQtn();//SOME A QUANTIDADE DO QUE JA EXISTE NO BANCO E A NOVA QUE.
					update(qtd, p.getPreco(), p.getId());// ATUALIZE O PRODUTO QUE JA EXISTE!!!
				}else {		
					
					// inserindo novo produto
					stmt = con.prepareStatement(INSERT); // PREPARANDO INSERT
					stmt.setInt(1, p.getId()); // POSICAO E VALOR QUE SERA INSERIDA NO BANCO
					stmt.setString(2, p.getNomeM());
					stmt.setString(3, p.getNomeG());
					stmt.setString(4, p.getLab());
					stmt.setInt(5, p.getQtn());
					stmt.setDouble(6, p.getPreco());
					linhaAfetada = stmt.executeUpdate(); // RESPONSAVEL PELA DML... vai gerar o sql insert TBM VAI COLOCAR O
				}										// NUMERO DE INSERT
			}
   
			if (linhaAfetada == 0) { // SE A LINHA NAO FOR AFETADA PRINT NA TELA .
				throw new SQLException(null, "Sucesso, nenhuma linha foi afetada");
			}

			JOptionPane.showMessageDialog(null, "Sucesso: dados inseridos ");

		} catch (Exception e) {
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	} // FIM METODO

	 	
	public List<Produto> listarProdutos() throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Produto> produto = new ArrayList<>();
		try {
			stmt = con.prepareStatement(LISTA);
			rs = stmt.executeQuery();// CONSULTAR O BANCO, GUARDANDO NA VARIAVEL rs.

			while (rs.next()) { // SE EXISTIR UM PROXIMO VALOR

				
				Produto p = new Produto(); // OBJ DO TIPO Produto
				p.setId(rs.getInt("Id")); // ADD OS VALORES DO BANCO NO OBJ P. PARA DEPOIS ADD NA LISTA
				p.setNomeM(rs.getString("nomeMar")); // setNomeM ? VEM DA CLASSE produto.
				p.setNomeG(rs.getString("nomeGen"));
				p.setLab(rs.getString("laboratorio"));
				p.setQtn(rs.getInt("quantidade")); // rs ? ME DA ACESSO A CONSULTA NO BANCO
				p.setPreco(rs.getDouble("preco")); // getDouble ? PEGANDO O VALOR DO BANCO E PASSANDO COLUNA DO BANCO
													// TIPO DOUBLE

				produto.add(p);
			}

		} catch (SQLException e) {
			System.out.println("Erro na consulta: " + e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return produto;
	}

	public Produto listarPorId(int id) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
//		List<Produto> produtos = new ArrayList<>();
		Produto p = new Produto();
		try {
			stmt = con.prepareStatement(LISTAID);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();// CONSULTAR O BANCO, GUARDANDO NA VARIAVEL rs.
			
			while (rs.next()) { // SE EXISTIR UM PROXIMO VALOR

				
				p.setId(rs.getInt("Id"));
				p.setNomeM(rs.getString("nomeMar"));
				p.setNomeG(rs.getString("nomeGen"));
				p.setLab(rs.getString("laboratorio"));
				p.setQtn(rs.getInt("quantidade"));
				p.setPreco(rs.getDouble("preco"));

				//produtos.add(p);
			}

		} catch (SQLException e) {
			System.out.println("Erro na consulta: " + e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return p;
	}

	public void update(int qtd, Double preco, int id ) throws Exception {
		Connection con = ConnectionFactory.getConnection();

		PreparedStatement stmt = null;
		try {
				// INSERINDO ATUALIZACAO
				stmt = con.prepareStatement(UPDATE); // PREPARANDO UPDATE
				stmt.setInt(1, qtd);// PRIMEIRA VALOR 
				stmt.setDouble(2, preco); // SEGUNDO VALOR A SER ALTERADO
				stmt.setInt(3, id); // VALOR DO WHERE 
				stmt.executeUpdate(); // RESPONSAVEL PELA DML... vai gerar o sql

		} catch (Exception e) {
			System.out.println("Erro ao Atualizar o Banco :  " + e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
}

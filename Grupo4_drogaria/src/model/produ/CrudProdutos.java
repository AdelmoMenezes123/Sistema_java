package model.produ;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import Grupo4.ImportaCSV;
import connectio.ConnectionFactory;

public class CrudProdutos {

	private final static String INSERT = "INSERT INTO `remedios`(`Id`,`nomeMar`, `nomeGen`, `laboratorio`, `quantidade`, `preco`) VALUES (?,?,?,?,?,?)";
	private final static String UPDATE = "UPDATE `remedios` SET `quantidade`=?, `preco`=? WHERE `Id`=?";
//    private final static String DELETE = "DELETE FROM `remedios` WHERE ID =?";
    private final static String LISTA = "SELECT * FROM `remedios` LIMIT 30";
    //private final String LISTABYID = "SELECT * FROM `remedios` WHERE `Id`=?";
	
    public CrudProdutos(){}
	
	int linhaAfetada = 0;
	static ResultSet rs = null;
	// int id = 0;
	// ResultSet generatedKeys = null;
	//static String sql = "";

	public void crate(Produto p) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {

			for (int i = 0; i < ImportaCSV.produtos.size(); i++) {

				p = ImportaCSV.produtos.get(i); // CARREGANDO LISTA PARA NO OBJ PRODUTO
				// inserindo novo produto
				stmt = con.prepareStatement(INSERT); // PREPARANDO INSERT
				stmt.setInt(1, p.getId()); // POSICAO E VALOR QUE SERA INSERIDA NO BANCO
				stmt.setString(2, p.getNomeM());
				stmt.setString(3, p.getNomeG());
				stmt.setString(4, p.getLab());
				stmt.setInt(5, p.getQtn());
				stmt.setDouble(6, p.getPreco());

				linhaAfetada = stmt.executeUpdate(); // RESPONSAVEL PELA DML... vai gerar o sql insert TBM VAI COLOCAR O
														// NUMERO DE INSERT

				// generatedKeys = stmt.getGeneratedKeys();// PEGANDO ID DOS PRODUTOS DO BANCO

//				if (generatedKeys.next()) {    // SE TIVER PROXIMO ID 
//	                id = generatedKeys.getInt(i); // COLOQUE ELES NA VARIAVEL ID 
//	    			System.out.println("Produto inserido com id: " + id);  // PRINT NA TELA O VALOR DELE 
//	            }
			}

			if (linhaAfetada == 0) { // SE A LINHA NAO FOR AFETADA PRINT NA TELA .
				throw new SQLException(null, "Sucesso, nenhuma linha foi afetada");
			}

			JOptionPane.showMessageDialog(null, "Sucesso: dados inseridos ");

		} catch (Exception e) {
			System.out.println("Erro ao salvar no Banco : " + e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	} // FIM METODO

	public static List<Produto> listarProdutos() throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		List<Produto> produtos = new ArrayList<>();

		try {
			stmt = con.prepareStatement(LISTA);
			rs = stmt.executeQuery();// CONSULTAR O BANCO, GUARDANDO NA VARIAVEL rs.

			while (rs.next()) { // SE EXISTIR UM PROXIMO VALOR

				Produto p = new Produto(); // OBJ DO TIPO Produto
				p.setId(rs.getInt("Id")); // ADD OS VALORES DO BANCO NO OBJ P. PARA DEPOIS ADD NA LISTA
				p.setNomeM(rs.getString("nomeMar")); // setNomeM ? VEM DA CLASSE produto.
				p.setQtn(rs.getInt("quantidade")); // rs ? ME DA ACESSO A CONSULTA NO BANCO
				p.setPreco(rs.getDouble("preco")); // getDouble ? PEGANDO O VALOR DO BANCO E PASSANDO COLUNA DO BANCO
													// TIPO DOUBLE

				produtos.add(p);
			}

		} catch (SQLException e) {
			System.out.println("Erro na consulta: " + e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return produtos;
	}

}

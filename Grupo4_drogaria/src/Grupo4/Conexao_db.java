package Grupo4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao_db {

	private static Connection conexao = null;

	private Conexao_db() {} 

	//criando
	public static Connection criarConexao() throws ClassNotFoundException, SQLException {
		try {
			if (conexao == null) {
				String url = "jdbc:mysql://localhost:3306/a5_arquitetura?serverTimezone=UTC";
				String user ="root";
				String password = "";
				Class.forName("com.mysql.jdbc.Driver");
				conexao = DriverManager.getConnection(url,user,password);
				System.out.println("Conectado com sucesso");
				
				
				
//		------------------------------------------------------------
				
				ResultSet rs;
				Statement stmt;
				String sql;
				int id;
				
				//buscando todos os produtos
				stmt = conexao.createStatement();
				
				
				sql = "SELECT * FROM produtos where id = 10";
				rs = stmt.executeQuery(sql);
				id=0;

				while(rs.next()){
					//pegando por nome de coluna
					id  = rs.getInt("Id");	          
					String nome = rs.getString("Quantidade");
					String preco = rs.getString("Preco");

					//exibindo valores
					System.out.print("ID: " + id);
					System.out.print(", Nome: " + nome);
					System.out.print(", Preco: " + preco);
					System.out.println();
				}
				
//	--------------------------------------------------------------------------------
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERRO ao conectar");
		}
		return conexao;
	}
	
	// Desconectando
	static void desconectar() {
		try {
			if(conexao != null) {
			conexao.close();
				System.out.println("Desconectado com cucesso");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERRO ao desconectar");
		}
		//return conexao;
	}
}
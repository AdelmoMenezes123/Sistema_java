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
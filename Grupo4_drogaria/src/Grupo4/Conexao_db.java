package Grupo4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao_db {

	private static Connection conexao = null;
	private final static String driver = "com.mysql.jdbc.Driver";
	private final static String url = "jdbc:mysql://localhost:3306/a5_arquitetura?serverTimezone=UTC";
	private final static String user ="root";
	private final static String password = "";

	private Conexao_db() {} 

	//criando
	public static Connection criarConexao() throws ClassNotFoundException, SQLException {
		try {
			if (conexao == null) {
				
				Class.forName(driver);
				conexao =  DriverManager.getConnection(url,user,password);				
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
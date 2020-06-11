package factory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

	//private static Connection conexao = null;
	private final static String url = "jdbc:mysql://localhost:3306/a5_arquitetura?serverTimezone=UTC"; // URL DO BANCO 
	private final static String user ="root";// USUARIO 
	private final static String password = "";//SENHA

	private ConnectionFactory() {} // CONSTRUTOR

	//criando
	public static Connection getConnection() throws Exception{
		try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");// CLASSE QUE SOLICITA O DRIVE
				return  DriverManager.getConnection(url,user,password);	//RETORNANDO A CONEXAO 			

		} catch (ClassNotFoundException | SQLException e) {
			throw new Exception("ERRO ao conectar",e);
		}
	}
	
	
	// Desconectando
	public static void closeConnection(Connection con) { // FECHANDO CONEXAO
		try {
			if(con != null) {
			con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt) {// FECHANDO VARIAVEL QUE VAI RECEBER A QUERY
		closeConnection(con);// CHAMADA DE METODO  
		try {
			if(stmt != null) {
			stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
		//FECHANDO AS VARIAVES USADA PARA MANIPULAR O BD
		closeConnection(con, stmt); // CHAMADA DE METODO
		
		try {
			if(rs != null) {
			rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

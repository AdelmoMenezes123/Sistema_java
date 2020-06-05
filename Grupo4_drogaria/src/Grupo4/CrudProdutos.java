package Grupo4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudProdutos {
	
	public void crate(ImportaCSV p) throws ClassNotFoundException, SQLException {
		Connection conn = Conexao_db.criarConexao();
		ResultSet rs = null;
		//Statement stmt = null;
		PreparedStatement pStmt = null;

		try {
			pStmt = conn.prepareStatement("INSERT INTO produtos (Id,Nome_marca,Nome_generico,Laboratorio,Quantidade,Preco) VALUES(?,?,?,?,?,?)");
			//pStmt.setString(0, p.Produtos[]);
		} catch (Exception e) {
			
		}
		
	}
}

package Grupo4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudProdutos {
	
	
//	System.out.println("--------------------------");
//	for (Produto produto : ImportaCSV.produtos) {
//		System.out.println("ID " + produto.getId());
//		System.out.println("NOMEM: " + produto.getNomeM());
//		System.out.println("NOMEG: " + produto.getNomeG());
//		System.out.println("LAB: " + produto.getLab());
//		System.out.println("QUANTI: " + produto.getQtn());
//		System.out.println("PRECO: " + produto.getPreco());
//		System.out.println("--------------------------");
//
//	}
	
	
	public void crate(ImportaCSV p) throws ClassNotFoundException, SQLException {
		//Connection conn = Conexao_db.getConnection();
		ResultSet rs = null;
		//Statement stmt = null;
		PreparedStatement pStmt = null;

		try {
		//	pStmt = conn.prepareStatement("INSERT INTO produtos (Id,Nome_marca,Nome_generico,Laboratorio,Quantidade,Preco) VALUES(?,?,?,?,?,?)");
			//pStmt.setString(0, p.Produtos[]);
		} catch (Exception e) {
			
		}
		
	}
}

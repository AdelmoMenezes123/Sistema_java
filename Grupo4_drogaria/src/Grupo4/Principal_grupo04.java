package Grupo4;

import java.sql.SQLException;

public class Principal_grupo04 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		//Conexao_db.criarConexao();
		
		new GraficoProdutos();
		
		//Conexao_db.desconectar();
		
		//ImportaCSV ler = new ImportaCSV();
		//ler.Ler(".\\Dados_DB\\MOCK_DATA.csv");
		
	}

}

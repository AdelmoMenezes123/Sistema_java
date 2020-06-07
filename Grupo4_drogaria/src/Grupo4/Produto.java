package Grupo4;


import java.util.List;

public class Produto { 
	
	public Produto (){}// CONSTRUTORES
	
	 // CRIANDO VARIAVEL QUE VAI SER PASSADO PARA LISTA
	private  int    id;
	private  String nomeM;
	private  String nomeG;
	private  String lab;
	private  int    qtn;
	private  Double preco;
	
	// CRIANDO METODOS GETS E SETS PARA OBTER E CONFIGURAR AS VARIAVELS DO TIPO PRIVADO
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeM() {
		return nomeM;
	}
	public void setNomeM(String nomeM) {
		this.nomeM = nomeM;
	}
	public String getNomeG() {
		return nomeG;
	}
	public void setNomeG(String nomeG) {
		this.nomeG = nomeG;
	}
	public String getLab() {
		return lab;
	}
	public void setLab(String lab) {
		this.lab = lab;
	}
	public int getQtn() {
		return qtn;
	}
	public void setQtn(int qtn) {
		this.qtn = qtn;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}	
}
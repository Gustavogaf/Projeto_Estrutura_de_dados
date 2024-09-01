package app;

public class Controle_Estoque {
	
	Controle_Estoque ant;
	Controle_Estoque prox;
	int quantidade;
	int codigo;
	String nome;
	
	public Controle_Estoque(int quantidade, int codigo, String nome) {
		this.quantidade = quantidade;
		this.codigo = codigo;
		this.nome = nome;
		this.ant= null;
		this.prox= null;
		
	}
	
	
	
	
	
	

}

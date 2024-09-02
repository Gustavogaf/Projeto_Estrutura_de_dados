package app;

public class Controle_Estoque extends Lista_Estoque{
	
	Controle_Estoque ant;
	Controle_Estoque prox;
	int quantidade;
	
	public Controle_Estoque(int codigo, String descricao, String marca, double valorDeEntrada, double valorDeSaida,
			int quantidadeDeEstoque, int quantidade) {
		super(codigo, descricao, marca, valorDeEntrada, valorDeSaida, quantidadeDeEstoque);
		this.quantidade = quantidade;
	}

	
	
	
	
	
	
	
	
	

}

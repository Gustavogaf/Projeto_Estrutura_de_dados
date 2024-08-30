package app;

public class Lista_Estoque {
	int codigo;
	String descricao;
	String marca;
	double valorDeEntrada;
	double valorDeSaida;
	int quantidadeDeEstoque;
	Lista_Estoque ant;
	Lista_Estoque prox;
	
	
	public Lista_Estoque(int codigo, String descricao, String marca, double valorDeEntrada, double valorDeSaida,
			int quantidadeDeEstoque) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.marca = marca;
		this.valorDeEntrada = valorDeEntrada;
		this.valorDeSaida = valorDeSaida;
		this.quantidadeDeEstoque = quantidadeDeEstoque;
		this.ant = null;
		this.prox = null;
	}
	
	
}

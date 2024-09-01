package app;

public class Lista_Estoque {
	int codigo;
	String descricao;
	String marca;
	double valorDeEntrada;
	double valorDeSaida;
	int quantidadeDeEstoque;
	Lista_Estoque prox;
	
	

	
	
	
	
	public Lista_Estoque(int codigo, String descricao, String marca, double valorDeEntrada, double valorDeSaida,
			int quantidadeDeEstoque) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.marca = marca;
		this.valorDeEntrada = valorDeEntrada;
		this.valorDeSaida = valorDeSaida;
		this.quantidadeDeEstoque = quantidadeDeEstoque;
		this.prox = null;
	}


	@Override
	public String toString() {
		return "Lista Estoque codigo=" + codigo + "\n descricao=" + descricao + "\n marca=" + marca + "\n valorDeEntrada="
				+ valorDeEntrada + "\n valorDeSaida=" + valorDeSaida + "\n quantidadeDeEstoque=" + quantidadeDeEstoque;
	}
	
	
	
	
}



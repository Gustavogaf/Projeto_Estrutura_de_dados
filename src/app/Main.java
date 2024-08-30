package app;

import java.util.Scanner;

public class Main {
	static Metodos_Lista pontListaEstoque = new Metodos_Lista(null,null,null,null);
	static Metodos_Lista pontListaVendas = new Metodos_Lista(null,null,null,null);
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		for (int i = 0; i < 3; i++) {
			System.out.println("Informe o codigo do produto");
			int codigo = ler.nextInt();
			System.out.println("Informe o nome do produto");
			String descricao = ler.next();
			System.out.println("Informe a marca do produto");
			String marca = ler.next();
			System.out.println("Informe o valor de entrada");
			double valorDeEntrada = ler.nextDouble();
			System.out.println("Informe o valor de saída do produto");
			double valorDeSaida = ler.nextDouble();
			System.out.println("Informe a quantidade que será inserida no estoque");
			int quantidadeNoEstoque = ler.nextInt();
			Lista_Estoque blocoNovo = new Lista_Estoque(codigo, descricao, marca, valorDeEntrada, valorDeSaida, quantidadeNoEstoque);
			Metodos_Lista.insereBlocoOrdenado(blocoNovo,pontListaEstoque);
		}
		
		Lista_Estoque aux = pontListaEstoque.inicio;
		for (int i = 0; i < 3; i++) {
			System.out.println(aux.descricao);
			aux = aux.prox;
		}
		
		
		
		
		
		
	}

}

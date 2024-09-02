package app;

import java.util.Scanner;

//import Testes.Lista_Estoque;

public class Main {
	static Metodos_Lista pontListaEstoque = new Metodos_Lista();
	static Metodos_Lista pontControleEstoque = new Metodos_Lista();
	
	
	
	
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		int funcao=0;
		
		
		System.out.println("-----Menu-----");
		System.out.println("Didite o valor refente a sua função ou 0 para sair do sistema ");
		System.out.println(" 1- Gerente \n 2- Caixa \n 3- Repositor");
		funcao=ler.nextInt();
		
		
		while (funcao!=0) {
	
		switch(funcao) {
		case 1:
			System.out.println("-------GERENTE-------");
			System.out.println("Digite o número da ação que deseja realizar");
			System.out.println(" 1- Gerar relatório de venda \n 2- Gerar relatório de estoque \n "
					          + "3- Aplicar alteração de preço em todos os produtos \n 4- Mostrar produtos \n 5- Remover produto ");
			int opGerente = ler.nextInt();
			
			if(opGerente==1) {
				Metodos_Lista.gerarRelatorioDeVendas(pontListaEstoque, pontControleEstoque);
			}
			if (opGerente==2) {
				Metodos_Lista.GerarRelatoriDeEstoque(pontListaEstoque,pontControleEstoque);
			}
			if (opGerente==3) {
				Metodos_Lista.alterarPrecosProdutos(pontListaEstoque);
				
			}
			if (opGerente==4) {
				
				Metodos_Lista.mostrar(pontListaEstoque);
				
			}
			if (opGerente==5) {
				System.out.println("Digite o codigo do produto que deseja remover:");
				int codigo= ler.nextInt();
				Metodos_Lista.removeBloco(codigo, pontListaEstoque);
			}
			break;
			
		case 2: 
			System.out.println("-------CAIXA-------");
			System.out.println("Digite o número da ação que deseja realizar");
			System.out.println(" 1- Vender produto \n 2- Mostrar produto ");
			
			int opCaixa = ler.nextInt();
			
			if (opCaixa==1) {
				System.out.println("informe o código do produto que será vendido: ");
				int cod;
				do {
					cod = ler.nextInt();
					if(Metodos_Lista.buscar(cod, pontListaEstoque)) {
						System.out.println("Produto não encontrado, informe outro código");
					}
				 } while (Metodos_Lista.buscar(cod, pontListaEstoque));
				Metodos_Lista.realizarVenda(cod, pontListaEstoque, pontControleEstoque);
			}
			if (opCaixa==2) {
				Metodos_Lista.mostrar(pontListaEstoque);
				
			}
			
			break;
			
		case 3:
			System.out.println("-------Repositor-------");
			System.out.println("Digite o número da ação que deseja realizar");
			System.out.println(" 1- Adicionar produto \n 2- Repor estoque \n 3- Mostrar produtos");
            
			int opRepositor = ler.nextInt();
			
			if(opRepositor==1) {
				for (int i = 0; i < 3; i++) {
				int codigo;
				do {
					System.out.println("Informe o codigo do produto");
					codigo = ler.nextInt();
					if (Metodos_Lista.verificarCodigo(codigo, pontListaEstoque)) {
						System.out.println("Elemento já cadastrado, por favor informe outro codigo");
					}
				
				}while(Metodos_Lista.verificarCodigo(codigo, pontListaEstoque));
				
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
				Controle_Estoque blocoNovo2 = new Controle_Estoque(codigo, descricao, marca, valorDeEntrada, valorDeSaida,quantidadeNoEstoque, quantidadeNoEstoque);
				Metodos_Lista.insereBlocoOrdenado(blocoNovo2,pontControleEstoque);
				Metodos_Lista.insereBlocoOrdenado(blocoNovo,pontListaEstoque);
				}
				
				
				
				
			}
			if (opRepositor==2) {
				System.out.println("Digite o código do produto que deseja repor:");
				int codigo= ler.nextInt();
				Metodos_Lista.reporEstoque(codigo, pontListaEstoque,pontControleEstoque);
			}
			if (opRepositor==3) {
				
				Metodos_Lista.mostrar(pontListaEstoque);
				
			}
			
			break;
		}
		System.out.println("-----Menu-----");
		System.out.println("Didite o valor refente a sua função ou 0 para sair do sistema ");
		System.out.println(" 1- Gerente \n 2- Caixa \n 3- Repositor");
		funcao=ler.nextInt();
		

	}
		
  }

}

package app;

import java.util.Scanner;

public class Metodos_Lista {
	
	
	Lista_Estoque inicio;
	Lista_Estoque fim;
	Lista_Estoque atual;
	Lista_Estoque ant;
	static int tamanho; 
	
	
	
	static Scanner sc= new Scanner(System.in);
	
	public Metodos_Lista() {
		this.inicio = null;
		this.fim = null;
		this.atual = null;
		this.ant = null;
		Metodos_Lista.tamanho = 0;
	}
	
	public static void insereBlocoOrdenado(Lista_Estoque bloco, Metodos_Lista pontLista) {
		if (Metodos_Lista.tamanho == 0) {
			pontLista.inicio = bloco;
			pontLista.fim=bloco;
			
		} else if (pontLista.inicio.descricao.compareTo(bloco.descricao)>=0){
			bloco.prox=pontLista.inicio;
			pontLista.inicio=bloco;
		} else {
			pontLista.atual=pontLista.inicio;
			while (pontLista.atual.prox != null && pontLista.atual.descricao.compareTo(bloco.descricao)<0) {
				pontLista.atual=pontLista.atual.prox;
			}
			bloco.prox=pontLista.atual.prox;
			pontLista.atual.prox=bloco;
			
			if (bloco.prox == null) {
				pontLista.fim=bloco;
			}
		}
		Metodos_Lista.tamanho ++;
	}
	
	
	
	public static boolean verificarCodigo(int codigo, Metodos_Lista pontLista) {
		boolean teste = false;
		
			Lista_Estoque aux = pontLista.inicio;
			while(aux!= null) {
				if(aux.codigo == codigo) {
					teste = true;
				}
				aux = aux.prox;
			
		}
		
		return teste;
	}
	
	public static boolean buscar(int codigo,Metodos_Lista pontLista) {
		boolean teste = false;
		if(Metodos_Lista.tamanho == 0) {
			System.out.println("Lista vazia");
		} else {
			Lista_Estoque aux = pontLista.inicio;
			while(aux!= null) {
				if(aux.codigo == codigo) {
					teste = true;
				}
				aux = aux.prox;
			}
		}
		if (teste=false) {
			System.out.println("Elemento não cadastrado");
		}
		return teste;
	}
	
	public static void removeBloco(int codigo,Metodos_Lista pontLista) {
		
		if (!buscar(codigo,pontLista)) {	
		} else {
			pontLista.atual=pontLista.inicio;
			if(pontLista.atual.codigo == codigo) {
				pontLista.inicio=pontLista.inicio.prox;
			} else {
				while(pontLista.atual.codigo != codigo) {
					pontLista.ant = pontLista.atual;
					pontLista.atual = pontLista.atual.prox;
					
				}	
			}
			pontLista.ant.prox = pontLista.atual.prox;
			Metodos_Lista.tamanho --;
		}
		if(pontLista.inicio == null) {
			pontLista.fim = pontLista.inicio;
		}
		if(pontLista.ant.prox==null) {
			pontLista.fim=pontLista.ant;
		}
		System.out.println("Produto eliminado");
	}
	
	public static void mostrar(Metodos_Lista pontLista ) {
		Lista_Estoque aux = pontLista.inicio;
		if(Metodos_Lista.tamanho == 0) {
			System.out.println("Lista vazia");
		} else {
			while (aux!=null) {
				System.out.println(aux.toString());
				System.out.println("---------------");
				
				aux=aux.prox;
			}
		}
	}
	
	public static void alterarPrecosProdutos( Metodos_Lista pontLista) {
		if(Metodos_Lista.tamanho == 0) {
			System.out.println("Lista vazia");
		}else {
			pontLista.atual= pontLista.inicio;
			
			int resposta; 
			do {
				System.out.println("É aumento ou desconto? (1-aumento 2-desconto)");
				resposta= sc.nextInt();
			}while(resposta<1 && resposta>2);
			
			System.out.println("De quanto será o aumento ou desconto em porcentagem ?");
			double valor = sc.nextDouble();
			
			while(pontLista.atual!= null) {
				if (resposta==1) {
				  pontLista.atual.valorDeEntrada*= (valor/100 + 1);
				  pontLista.atual.valorDeSaida*= (valor/100 + 1);
				}else {
					 pontLista.atual.valorDeEntrada*= (1 - valor/100);
					 pontLista.atual.valorDeSaida*= (1- valor/100);
				}
				
				pontLista.atual= pontLista.atual.prox;
				
				
				
			}
		}
		
		
	}
	
	public static void reporEstoque (int codigo, Metodos_Lista pontList) {
		if (!verificarCodigo(codigo, pontList)) {
			System.out.println("Produto não cadastrado, utilize o metodo inserir produto ");
			
		}else {
			pontList.atual= pontList.inicio;
			while(pontList.atual.codigo!=codigo) {
				pontList.atual=pontList.atual.prox;
			}
			
			System.out.println("Informe a quantidade de produtos que será reposto no estoque: ");
			int qnt = sc.nextInt();
			pontList.atual.quantidadeDeEstoque+= qnt;
	
		}
		
	}
	
	
	
	
	
}



	
		
		
	


package app;

import java.util.Scanner;


public class Metodos_Lista {
	
	
	Lista_Estoque inicio;
	Lista_Estoque fim;
	Lista_Estoque atual;
	Lista_Estoque ant;
	int tamanho; 
	
	
	
	static Scanner sc= new Scanner(System.in);
	
	public Metodos_Lista() {
		this.inicio = null;
		this.fim = null;
		this.atual = null;
		this.ant = null;
		this.tamanho = 0;
	}
	
	public static void insereBlocoOrdenado(Lista_Estoque bloco, Metodos_Lista pontLista) {
	    if (pontLista.tamanho == 0) {
	        pontLista.inicio = bloco;
	        pontLista.fim = bloco;
	    } else if (pontLista.inicio.descricao.compareTo(bloco.descricao) > 0) {
	        bloco.prox = pontLista.inicio;
	        pontLista.inicio = bloco;
	    } else {
	        pontLista.atual = pontLista.inicio;
	        while (pontLista.atual.prox != null && pontLista.atual.prox.descricao.compareTo(bloco.descricao) < 0) {
	            pontLista.atual = pontLista.atual.prox;
	        }
	        bloco.prox = pontLista.atual.prox;
	        pontLista.atual.prox = bloco;

	        if (bloco.prox == null) {
	            pontLista.fim = bloco;
	        }
	    }
	    pontLista.tamanho++;
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
		if(pontLista.tamanho == 0) {
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
			System.out.println("Produto não cadastrado");
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
			pontLista.tamanho --;
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
		if(pontLista.tamanho == 0) {
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
		if(pontLista.tamanho == 0) {
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
	
	public static void reporEstoque (int codigo, Metodos_Lista pontList, Metodos_Lista pontListaControl) {
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
			Controle_Estoque novoBloControle_Estoque = new Controle_Estoque(codigo, pontList.atual.descricao, pontList.atual.marca, pontList.atual.valorDeEntrada, pontList.atual.valorDeSaida, pontList.atual.quantidadeDeEstoque, qnt);
			Metodos_Lista.insereBlocoOrdenado(novoBloControle_Estoque,pontListaControl);
			
	
		}
		
	}
	
	public static void realizarVenda(int cod, Metodos_Lista pontLista, Metodos_Lista pontListaControl) {
		pontLista.atual=pontLista.inicio;
		while(pontLista.atual.codigo!=cod) {
			pontLista.atual=pontLista.atual.prox;
		}
		int quant;
		do {
			System.out.println("Informe a quantidade de produtos que será vendida: ");
			quant = sc.nextInt();
			if (quant>pontLista.atual.quantidadeDeEstoque) {
				System.out.println("Não existe estoque suficiente para realizar venda, existem apenas "+pontLista.atual.quantidadeDeEstoque+" no estoque");
			}
		} while (quant>pontLista.atual.quantidadeDeEstoque);
		pontLista.atual.quantidadeDeEstoque-=quant;
		quant*=-1;
		Controle_Estoque novoBloControle_Estoque = new Controle_Estoque(cod, pontLista.atual.descricao, pontLista.atual.marca, pontLista.atual.valorDeEntrada, pontLista.atual.valorDeSaida, pontLista.atual.quantidadeDeEstoque, quant);
		Metodos_Lista.insereBlocoOrdenado(novoBloControle_Estoque,pontListaControl);
	}
	
	public static void GerarRelatoriDeEstoque(Metodos_Lista pontLista, Metodos_Lista pontListaControl) {
		if(pontListaControl.tamanho==0) {
			System.out.println("Lista vazia");
		} else {
			
			
			Lista_Estoque aux = pontListaControl.inicio;
			Lista_Estoque aux2= pontLista.inicio;
				
			int tam = pontListaControl.tamanho;
			while(aux!=null) {
				Controle_Estoque auxAnt = (Controle_Estoque) aux;
				
					if(auxAnt.quantidade < 0) {
						System.out.println("O produto "+auxAnt.descricao+" Teve saída de: "+auxAnt.quantidade);
					} else if (auxAnt.quantidade>0) {
						System.out.println("O produto "+auxAnt.descricao+" Teve entrada de: "+auxAnt.quantidade);
					}
					
					if(!(aux.prox==null)) {
						if(aux.descricao!=aux.prox.descricao) {
							System.out.println("O estoque atual do produto é de: "+aux2.quantidadeDeEstoque);
							aux2=aux2.prox;
						}
				
					} else {
						System.out.println("O estoque atual do produto é de: "+aux2.quantidadeDeEstoque);
					}
					aux=aux.prox;
			}
		}
	} 
	
	
	public static void gerarRelatorioDeVendas(Metodos_Lista pontLista, Metodos_Lista pontListaControl) {
		if(pontListaControl.tamanho==0) {
			System.out.println("Lista vazia");
		} else {
			double lucroPorProduto=0;
			double lucroBruto=0;
		}
	}
	
	
}



	
		
		
	


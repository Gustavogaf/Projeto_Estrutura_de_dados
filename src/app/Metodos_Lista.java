package app;

public class Metodos_Lista {
	Lista_Estoque inicio;
	Lista_Estoque fim;
	Lista_Estoque atual;
	Lista_Estoque ant;
	static int tamanho; 
	
	
	
	public Metodos_Lista(Lista_Estoque inicio, Lista_Estoque fim, Lista_Estoque atual, Lista_Estoque ant) {
		this.inicio = inicio;
		this.fim = fim;
		this.atual = atual;
		this.ant = ant;
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
			while (pontLista.atual.prox != null && pontLista.atual.descricao.compareTo(bloco.descricao)>0) {
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
			System.out.println("Elemento não foi encontrado");
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
	
	
	}



	
		
		
	


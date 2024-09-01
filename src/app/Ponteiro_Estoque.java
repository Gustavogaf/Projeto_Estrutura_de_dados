package app;

public class Ponteiro_Estoque {
	
	
	Controle_Estoque inicio;
	Controle_Estoque fim;
	Controle_Estoque atual;
	Controle_Estoque ant;
	static int tamanho;
		
		public Ponteiro_Estoque() {
			
			
			this.inicio = null;
			this.fim = null;
			this.atual = null;
			this.ant = null;
			this.tamanho=0;
			
		}
		
		public static void insereBlocoOrdenadoControleEstoque(Controle_Estoque bloco, Ponteiro_Estoque pontLista) {
			if (Ponteiro_Estoque.tamanho == 0) {
				pontLista.inicio = bloco;
				pontLista.fim=bloco;
				
			} else if (pontLista.inicio.nome.compareTo(bloco.nome)>=0){
				bloco.prox=pontLista.inicio;
				pontLista.inicio=bloco;
			} else {
				pontLista.atual=pontLista.inicio;
				while (pontLista.atual.prox != null && pontLista.atual.nome.compareTo(bloco.nome)<0) {
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
		
		
	

}

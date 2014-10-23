package algoritmo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import entidades.Cor;
import entidades.CorVertice;
import entidades.VerticeBuscaProfundidade;
import grafos.Aresta;
import grafos.Grafo;

public class BuscaProfundidade implements Algoritmo {

	private Grafo<VerticeBuscaProfundidade, Aresta<VerticeBuscaProfundidade,VerticeBuscaProfundidade>> g;
	//private VerticeBuscaProfundidade v;
	private int tempo;
	
	public BuscaProfundidade(Grafo<VerticeBuscaProfundidade, Aresta<VerticeBuscaProfundidade,VerticeBuscaProfundidade>> grafo){
		this.g = grafo;
	}
	
	public void inicializaGrafo(){
		Iterator<VerticeBuscaProfundidade> it = this.g.getVertices();
		while(it.hasNext()){
			VerticeBuscaProfundidade v = it.next();
			v.setCor(new CorVertice(Cor.Branco));
			v.setPai(null);
			tempo = 0;
		}
	
		Iterator<VerticeBuscaProfundidade> it1 = this.g.getVertices();
		while(it1.hasNext()){
			VerticeBuscaProfundidade v = it1.next();
			System.out.println("Vertice Inicial: " + v.getId());
			if(v.getCor().getCor().equals(Cor.Branco)){
				DFS(v);
			}else{
				
			}
		}
	}

	@Override
	public void BFS() {

	}

	@Override
	public void DFS(VerticeBuscaProfundidade vertice) {
		System.out.println("v: " + vertice.getId());
		this.tempo++;
		vertice.setTempoDescoberta(tempo);
		vertice.setCor(new CorVertice(Cor.Cinza));
		try {
			Iterator<VerticeBuscaProfundidade> it = this.g.getVerticesAdjacentes(vertice);
			while(it.hasNext()){
				VerticeBuscaProfundidade v = it.next();
				
				if(v.getCor().getCor().equals(Cor.Branco)){
					System.out.println("-- adj: " + v.getId());
					v.setPai(vertice);
					DFS(v);
				}
			}	
		} catch (Exception e) {
			System.out.println("Vertice <" + vertice.getId() + "> não tem adjacente.");
		}
		
		vertice.setCor(new CorVertice(Cor.Preto));
		System.out.println("vertice preto: " + vertice.getId());
		this.tempo++;
		vertice.setTempoFinalizacao(tempo);
		//imprime(vertice);
	}
	
	
	public void dfsIterativo(VerticeBuscaProfundidade v){
		this.tempo++;
		v.setTempoDescoberta(tempo);
		v.setCor(new CorVertice(Cor.Cinza));
		
		/*nao precisa guarda esta lista com os adjacentes, quando desempilhar todos, chama novamente 
		 * o getVerticesAdjs excluindo o que ja foi visitado (estara preto) e vai para o proximo adj.*/
		
		Iterator<VerticeBuscaProfundidade> it = this.g.getVerticesAdjacentes(v);
		ArrayList<VerticeBuscaProfundidade> lista = new ArrayList<VerticeBuscaProfundidade>();
		Stack<VerticeBuscaProfundidade> pilha = new Stack<VerticeBuscaProfundidade>();
		
		pilha.push(v);
		VerticeBuscaProfundidade vertice = it.next();
		
		vertice.setPai(v);
		
		while(it.hasNext()){
			VerticeBuscaProfundidade aux = it.next();
			lista.add(aux);
		}
		
		while(!lista.isEmpty()){
			if(vertice.getCor().getCor().equals(Cor.Branco)){
				// empilha o pai
				pilha.push(vertice);
				// pega os adjacente ao pai
				it = this.g.getVerticesAdjacentes(vertice);
				// pega o primeira elemento da lista de adjacentes
				vertice = it.next();
				// diz para vertice que seu pai é o ultimo elemento empilhado na pilha
				vertice.setPai(pilha.peek());
				
				// se a lista de vertices adjacente tiver o vertice, tira ele da lista
				if(lista.contains(vertice)){
					lista.remove(vertice);
				}
				// insere os elementos adjacentes na lista
				while(it.hasNext()){
					VerticeBuscaProfundidade aux = it.next();
					lista.add(aux);
				}
		
			}
			
			
		}
		
		
		
		
		
	}
	public void imprime(VerticeBuscaProfundidade v){
		
		
			//System.out.println("Vertice Pai: " + v.getPai().getId().toString());
		
		System.out.println("Descoberto: " + v.getTempoDescoberta());
		System.out.println("Finalizado: " + v.getTempoFinalizacao());
	}

}

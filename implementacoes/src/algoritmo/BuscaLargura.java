package algoritmo;

import java.util.ArrayList;
import java.util.Iterator;

import entidades.Cor;
import entidades.CorVertice;
import entidades.VerticeBuscaLargura;
import entidades.VerticeBuscaProfundidade;
import grafos.Aresta;
import grafos.Grafo;

public class BuscaLargura implements Algoritmo{
	
	private Grafo<VerticeBuscaLargura, Aresta<VerticeBuscaLargura,VerticeBuscaLargura>> g;
	private VerticeBuscaLargura s;
	private ArrayList<VerticeBuscaLargura> f = new ArrayList<VerticeBuscaLargura>();

	
	public BuscaLargura(Grafo<VerticeBuscaLargura, Aresta<VerticeBuscaLargura,VerticeBuscaLargura>> g, VerticeBuscaLargura verticeInicial){
		if (g.getVertice(verticeInicial.getId()) == null)
			throw new RuntimeException("O vértice de índice " + verticeInicial.getId() + " não pertence ao grafo " + g.toString() + ". "
					+ "Utilize um vértice válido como argumento do construtor da classe " + this.getClass().getName());
		else {
			this.g = g;
			this.s = verticeInicial;
		}
	}
	
	//Algoritmo para inicialização do grafo na BFS 
	public void inicializaGrafo(){
		Iterator<VerticeBuscaLargura> it = this.g.getVertices();
		while(it.hasNext()){
			VerticeBuscaLargura u = it.next();
			if(u != this.s){
				u.setCor(new CorVertice(Cor.Branco));
				u.setDistancia((int)Float.POSITIVE_INFINITY);
				u.setPai(null);
			}
		}
		s.setDistancia(0);
		s.setPai(null);
		s.setCor(new CorVertice(Cor.Cinza));
		this.f.add(s);
	}
	
	
	
	@Override
	public void BFS() {
		while(!this.f.isEmpty()){
			VerticeBuscaLargura u = this.f.remove(0);
			Iterator<VerticeBuscaLargura> it = this.g.getVerticesAdjacentes(u);
			while(it.hasNext()){
				VerticeBuscaLargura v = it.next();
				System.out.println("-- " + v.getId());
				if(v.getCor().equals(Cor.Branco)){
					v.setCor(new CorVertice(Cor.Cinza));
					v.setDistancia(u.getDistancia() + 1);
					v.setPai(u);
					this.f.add(it.next());
				}
			}
			System.out.println(u.getId());
			u.setCor(new CorVertice(Cor.Preto));
		}
	}
	
	public void imprimeGrafo(Grafo<VerticeBuscaLargura, Aresta<VerticeBuscaLargura,VerticeBuscaLargura>> g, VerticeBuscaLargura s, VerticeBuscaLargura v) {
		if (v.equals(s)){
			System.out.print(s);
		} else {
			if (v.getPai() == null){
				System.out.print("não há caminho entre " + s + " e " + v);
			} else {
				imprimeGrafo(g,s,v.getPai());
				System.out.print(v);
			}
		}

	}

	@Override
	public void DFS(VerticeBuscaProfundidade v) {
		// TODO Auto-generated method stub
		
	}
}

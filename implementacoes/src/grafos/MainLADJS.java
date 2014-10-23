package grafos;

import java.util.Iterator;

import factory.GrafoFactory;
import factory.Representacao;

public class MainLADJS {


	public static void main(String[] args) {
		/* cria o grafo, e informa qual será sua forma de representação */
		Grafo<Vertice, Aresta<Vertice,Vertice>> grafo;
		grafo = GrafoFactory.constroiGrafo(Representacao.LISTA_ADJACENCIA);
		
		/* vértice inicial */
		Vertice s = new Vertice("s");

		/* cria os vértices */
		Vertice u = new Vertice("u");
		Vertice v = new Vertice("v");
		Vertice z = new Vertice("z");
		Vertice w = new Vertice("w");
		
		/* adicionando os vértices ao grafo */
		grafo.adicionaVertice(s); // s
		grafo.adicionaVertice(s, v); // s - v
	    grafo.adicionaVertice(s, u); // s - u
	    grafo.adicionaVertice(v, z); // v - z
	    grafo.adicionaVertice(v, w); // v - w
	    
	    Iterator<Vertice> iv = grafo.getVertices();
	    while(iv.hasNext()){
	    	System.out.println(iv.next().getId());
	    }
	    
	    
	}

}

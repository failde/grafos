package grafos;


import java.util.HashMap;
import java.util.Iterator;

import algoritmo.BuscaLargura;
import entidades.VerticeBuscaLargura;
import factory.GrafoFactory;
import factory.Representacao;

public class MainBFS {

	public static void main(String[] args) {
	
		HashMap<Vertice, Integer> distanciasMinimas = new HashMap<Vertice,Integer>();
		
		Grafo<VerticeBuscaLargura,Aresta<VerticeBuscaLargura,VerticeBuscaLargura>> g;
		g = GrafoFactory.constroiGrafo(Representacao.LISTA_ADJACENCIA);
		
		//vértice inicial
		VerticeBuscaLargura s = new VerticeBuscaLargura("s");
		g.adicionaVertice(s);
		
		//armazena a distancia de 's' até 's
		distanciasMinimas.put(s, 0);
		
		//criação dos vértices
		VerticeBuscaLargura r = new VerticeBuscaLargura("r");
		VerticeBuscaLargura t = new VerticeBuscaLargura("t");
		VerticeBuscaLargura u = new VerticeBuscaLargura("u");
		VerticeBuscaLargura v = new VerticeBuscaLargura("v");
		VerticeBuscaLargura w = new VerticeBuscaLargura("w");
		VerticeBuscaLargura x = new VerticeBuscaLargura("x");
		VerticeBuscaLargura y = new VerticeBuscaLargura("y");
		
		//adição dos vértices
		g.adicionaVertice(s,r); //s-r
		g.adicionaVertice(s,w); //s-w
		g.adicionaVertice(r,v); //r-v
		g.adicionaVertice(w,t); //w-t
		g.adicionaVertice(w,x); //w-x
		g.adicionaVertice(x,u); //x-u
		g.adicionaVertice(x,y); //x-y
		g.adicionaVertice(x,t); //x-t
		g.adicionaVertice(t,u); //t-u
		g.adicionaVertice(u,y); //u-y
		
		

		BuscaLargura bl = new BuscaLargura(g, w);
		bl.inicializaGrafo();
		bl.BFS();

	}

}

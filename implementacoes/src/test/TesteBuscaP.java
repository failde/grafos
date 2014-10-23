package test;

import algoritmo.BuscaProfundidade;
import entidades.VerticeBuscaProfundidade;
import factory.GrafoFactory;
import factory.Representacao;
import grafos.Aresta;
import grafos.Grafo;

public class TesteBuscaP {

	public static void main(String[] args) {
		Grafo<VerticeBuscaProfundidade,Aresta<VerticeBuscaProfundidade,VerticeBuscaProfundidade>> g;
		g = GrafoFactory.constroiGrafo(Representacao.LISTA_ADJACENCIA);
		
		//vértice inicial
		VerticeBuscaProfundidade s = new VerticeBuscaProfundidade("s");
		g.adicionaVertice(s);
		
		
		//criação dos vértices
		VerticeBuscaProfundidade r = new VerticeBuscaProfundidade("r");
		VerticeBuscaProfundidade t = new VerticeBuscaProfundidade("t");
		VerticeBuscaProfundidade u = new VerticeBuscaProfundidade("u");
		VerticeBuscaProfundidade v = new VerticeBuscaProfundidade("v");
		VerticeBuscaProfundidade w = new VerticeBuscaProfundidade("w");
		VerticeBuscaProfundidade x = new VerticeBuscaProfundidade("x");
		VerticeBuscaProfundidade y = new VerticeBuscaProfundidade("y");
		
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
		
		BuscaProfundidade dfs = new BuscaProfundidade(g);
		dfs.inicializaGrafo();

	}

}

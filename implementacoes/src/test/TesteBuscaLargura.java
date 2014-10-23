package test;
import static org.junit.Assert.*;
import entidades.VerticeBuscaLargura;
import factory.GrafoFactory;
import factory.Representacao;
import grafos.Vertice;
import grafos.Aresta;
import grafos.Grafo;

import java.util.HashMap;

import org.junit.Test;

import algoritmo.BuscaLargura;



//TODO Exercicio 3.2 - Implementar um teste para verificar 
//os lemas e teoremas relacionados ?? busca em largura
public class TesteBuscaLargura {

	@Test
	public void Lema1() {
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
		
		BuscaLargura bl = new BuscaLargura(g, s);
		bl.inicializaGrafo();
		bl.BFS();
		
		//TODO Exercício 3.3
		//Testar se, para toda aresta (u,v) a menor distância
		//entre 's' e 'v' é menor ou igual a menor distância 
		//entre 's' e 'u + 1'
	}
	
	@Test
	public void Lema2() {
		fail("Not yet implemented");
	}
	
	@Test
	public void Lema3() {
		fail("Not yet implemented");
	}
	
	@Test
	public void TeoremaCorretude() {
		fail("Not yet implemented");
	}

}

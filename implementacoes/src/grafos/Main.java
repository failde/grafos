package grafos;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import factory.GrafoFactory;
import factory.GrafoListaAdjacencia;
import factory.Representacao;

public class Main {

	public static void main(String[] args) {
		
		/* cria o grafo, e informa qual será sua forma de representação */
		Grafo<Vertice, Aresta<Vertice,Vertice>> grafo;
		grafo = GrafoFactory.constroiGrafo(Representacao.MATRIZ_ADJACENCIA);
		
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
	    grafo.adicionaAresta(new Aresta<Vertice, Vertice>(v, u)); // v - u OK dando certo
	    //grafo.adicionaAresta(new Aresta<Vertices, Vertices>(z, w)); // z - w OK
	    //grafo.adicionaAresta(new Aresta<Vertices, Vertices>(u, z)); // u - z OK

	    System.out.println("GetVertice: " + grafo.getVertice("w").getId());
	   
	    
	    /* teste getVertices -- OK */
	    System.out.println("Vertices do grafo: ");
	    Iterator<Vertice> vs = grafo.getVertices();
	    while(vs.hasNext()){
	    	System.out.println(vs.next().getId());
	    }
	    
	    /*teste getVerticeAdjs*/
	    System.out.println("Vertices adjs são: ");
	    Iterator<Vertice> adjs = grafo.getVerticesAdjacentes(v);
	    while(adjs.hasNext()){
	    	System.out.println(adjs.next().getId());
	    }
	    
	    /*teste getArestas*/
	    System.out.println("Arestas do Grafo são: ");
	    Iterator<Aresta<Vertice, Vertice>> arestas = grafo.getArestas();
	    
	    while(arestas.hasNext()){
	    	Aresta<Vertice, Vertice> a = arestas.next();
	    	Vertice aux1 = a.getVertice1();
	    	Vertice aux2 = a.getVertice2();
	    	try {
	    		System.out.println(aux1.getId() + " -- " + aux2.getId());
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	
	    }

	    		
		}
		
	}



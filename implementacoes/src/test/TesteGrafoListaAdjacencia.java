package test;
import static org.junit.Assert.*;
import entidades.VerticeBuscaLargura;
import factory.GrafoFactory;
import factory.Representacao;
import grafos.Vertice;
import grafos.Aresta;
import grafos.Grafo;
import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;


public class TesteGrafoListaAdjacencia {

	@Test
	public void testeVertice() {
		Grafo<Vertice, Aresta<Vertice, Vertice>> g = GrafoFactory.constroiGrafo(Representacao.MATRIZ_ADJACENCIA);
		Vertice a = new Vertice("a");
		g.adicionaVertice(a);

		// 'a' foi adicionado ao grafo
		assertEquals(a, g.getVertice(a.getId()));

		Vertice b = new Vertice("b");
		Vertice c = new Vertice("c");
		g.adicionaVertice(a, b);
		g.adicionaVertice(a, c);

		// 'b' e 'c' foram adicionados ao grafo
		assertEquals(b, g.getVertice(b.getId()));
		assertEquals(c, g.getVertice(c.getId()));

		// todas as arestas tem 'a' como antecessor
		Iterator<Aresta<Vertice, Vertice>> iteratorAresta = g.getArestas();
		while (iteratorAresta.hasNext()) {
			Aresta<Vertice, Vertice> aresta = iteratorAresta.next();
			assertEquals(a, aresta.getVertice1());
		}

		// 'a' tem 'b' e 'c' como sucessores
		Iterator<Vertice> iteratorVertice = g.getVerticesAdjacentes(a);
		while (iteratorVertice.hasNext()) {
			Vertice u = iteratorVertice.next();
			assertTrue(u.equals(b) || u.equals(c));
		}

		Vertice d = new Vertice("d");
		Vertice e = new Vertice("e");
		Vertice f = new Vertice("f");

		g.adicionaVertice(b, d);
		g.adicionaVertice(b, e);
		g.adicionaVertice(b, f);

		// as arestas 'd', 'e' e 'f' tem 'b' como antecessor
		iteratorAresta = g.getArestas();
		while (iteratorAresta.hasNext()) {
			Aresta<Vertice, Vertice> aresta = iteratorAresta.next();
			if (aresta.getVertice1().getId().equals("b"))
				assertTrue(aresta.getVertice2().getId().equals("d")
						|| aresta.getVertice2().getId().equals("e")
						|| aresta.getVertice2().getId().equals("f"));
		}

		// 'b' tem 'd', 'e' e 'f' como sucessores
		iteratorVertice = g.getVerticesAdjacentes(b);
		while (iteratorVertice.hasNext()) {
			Vertice u = iteratorVertice.next();
			assertTrue(u.equals(d) || u.equals(e) || u.equals(f));
		}
	}

	@Test
	public void testeAresta() {
		Grafo<Vertice, Aresta<Vertice, Vertice>> g = GrafoFactory.constroiGrafo(Representacao.MATRIZ_ADJACENCIA);
		Vertice v1 = new Vertice("a");
		Vertice v2 = new Vertice("b");
		Aresta<Vertice, Vertice> a1 = new Aresta<Vertice, Vertice>(v1, v2);
		g.adicionaAresta(a1);

		Iterator<Aresta<Vertice, Vertice>> i = g.getArestas();
		while (i.hasNext()) {
			Aresta<Vertice, Vertice> aresta = i.next();
			assertTrue(aresta.getVertice1().equals(v1));
			assertTrue(aresta.getVertice2().equals(v2));
		}

		Vertice v3 = new Vertice("a");
		Vertice v4 = new Vertice("c");
		
		assertFalse(g.getVertice("a").equals(v3));
		assertNull(g.getVertice("c"));
		
		Aresta<Vertice, Vertice> a2 = new Aresta<Vertice, Vertice>(v3, v4);
		g.adicionaAresta(a2);

		assertFalse(g.getVerticesAdjacentes(v4).hasNext());
		
		i = g.getArestas();
		while (i.hasNext()) {
			Aresta<Vertice, Vertice> aresta = i.next();
			assertTrue(aresta.getVertice1().equals(v1));
			assertTrue(aresta.getVertice2().equals(v4)
					|| aresta.getVertice2().equals(v2));
		}
		
		Vertice v5 = new Vertice("x");
		Vertice v6 = new Vertice("y");
		Aresta<Vertice, Vertice> a3 = new Aresta<Vertice, Vertice>(v5, v6);
		g.adicionaAresta(a3);		
		
		i = g.getArestas();
		while (i.hasNext()) {
			Aresta<Vertice, Vertice> aresta = i.next();
			if (aresta.getVertice1() == v5){
				assertTrue(aresta.getVertice2().equals(v6));
			}
		}
	}
}
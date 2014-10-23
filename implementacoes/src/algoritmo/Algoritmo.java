package algoritmo;

import entidades.VerticeBuscaProfundidade;

public interface Algoritmo {
	
	/**
	 * Função que executa a busca em largura, esta função explora as arestas do grafo para descobrir
	 * cada vértice acessivel a partir do vertice inicial. */
	public void BFS();
	
	/**
	 * Este algoritmo explora os vértices não explorados, adjacentes ao vértice decoberto mais recentemente.
	 * */
	public void DFS(VerticeBuscaProfundidade v);
}

package grafos;

import java.util.Iterator;

	public interface Grafo<V extends Vertice, A extends Aresta<V,V>> {
	public final int NAO_DIRECIONADO = 0;
	public final int DIRECIONADO = 1;
	public final int PONDERADO = 2;
	public final int DIRECIONADO_PONDERADO = 3;
	
	public Iterator<V> getVerticesAdjacentes(V u);
	public Iterator<V> getVertices();
	public Iterator<A> getArestas();
	public V getVertice(String idVertice);
	
	/**
	 * Adiciona o vértice <code>verticeAdicionado</code> ajdacente 
	 * ao vértice <code>verticeNoGrafo</code> que já está no grafo.
	 * Necessariamente, o vértice <code>verticeNoGrafo</code> precisa
	 * estar no grafo
	 * 
	 * @param verticeNoGrafo Vértice que já está no grafo
	 * @param verticeAdicionado Vértice sendo adicionado no grafo
	 */
	public void adicionaVertice(V verticeNoGrafo, V verticeAdicionado);
	
	/**
	 * Adiciona um vértice <code>verticeAdicionado</code> ao grafo.
	 * O vértice ficará sem nenhum outro vértice adjacente.
	 * 
	 * @param verticeAdicionado Vértice sendo adicionado ao grafo
	 */
	public void adicionaVertice(V verticeAdicionado);
	
	/**
	 * Adiciona uma aresta ao grafo. Se algum dos vértices
	 * da aresta adicionada já estiverem no grafo eles são
	 * sobrepostos
	 * 
	 * @param arestaAdicionada Aresta adicionada ao grafo
	 */
	public void adicionaAresta(A arestaAdicionada);	
}

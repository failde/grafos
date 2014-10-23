package factory;





import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import grafos.*;

public class GrafoListaAdjacencia implements Grafo<Vertice, Aresta<Vertice,Vertice>> {
	HashMap<Vertice, ArrayList<Vertice>> grafo = new HashMap<Vertice,ArrayList<Vertice>>();
	
	
	public GrafoListaAdjacencia(){
		
		
	}
	
	@Override
	public Iterator<Vertice> getVerticesAdjacentes(Vertice u) {
		// TODO Auto-generated method stub
		if(u != null && grafo.containsKey(u)){
			return grafo.get(u).iterator();
		}else{
			return null;
		}
	}

	@Override
	public Iterator<Vertice> getVertices() {
		// TODO Auto-generated method stub
		//System.out.println(grafo.keySet().size());
		return grafo.keySet().iterator();
	}

	@Override
	public Iterator<Aresta<Vertice, Vertice>> getArestas() {
		// TODO Auto-generated method stub
		Set<Aresta<Vertice, Vertice>> i = new HashSet<Aresta<Vertice, Vertice>>();
		for (Entry<Vertice, ArrayList<Vertice>> adj : grafo.entrySet()) {
			for (Vertice u : adj.getValue()) {
				i.add(new Aresta<Vertice, Vertice>(adj.getKey(), u));
			}
		}
		return i.iterator();
	}

	@Override
	public Vertice getVertice(String idVertice) {
		// TODO Auto-generated method stub
		for(Entry<Vertice, ArrayList<Vertice>> proc: grafo.entrySet()){
			if(proc.getKey().getId().equals(idVertice)){
				return proc.getKey();
			}else{
				ArrayList<Vertice> adj = proc.getValue();
				for (Vertice v : adj){
					if (v.getId().equals(idVertice))
						return v;
					}
				}
			}
	return null;
	}

	@Override
	public void adicionaVertice(Vertice verticeNoGrafo,
			Vertice verticeAdicionado) {
		// verifica se verticeNoGrafo esta no grafo
				Vertice v = getVertice(verticeNoGrafo.getId());
				if (v == null)
					throw new RuntimeException("O vértice com identificado "
							+ verticeNoGrafo.getId()
							+ " precisa necessariamente estar no grafo.");
				// else -> vertice esta no grafo !
				else {
					// verifica se o vertice verticeNoGrafo já possui
					// outros vértices adjacentes
					ArrayList<Vertice> adj = this.grafo.get(v);
					if (adj == null) {
						adj = new ArrayList<Vertice>();
						adj.add(verticeAdicionado);
						this.grafo.put(v, adj);
					} else {
						adj.add(verticeAdicionado);
						this.grafo.put(v, adj);
					}
				}
	}

	@Override
	public void adicionaVertice(Vertice verticeAdicionado) {
		// verifica se o vertice ja esta no grafo
		Vertice v = getVertice(verticeAdicionado.getId());
		if(v == null){
			grafo.put(verticeAdicionado, new ArrayList<Vertice>());
		}
		verticeAdicionado = v;
	}

	@Override
	public void adicionaAresta(Aresta<Vertice, Vertice> arestaAdicionada) {
		// TODO Auto-generated method stub
		/*se v1 == null ainda nao esta adicionado ao grafo*/
		if( arestaAdicionada.getVertice1() == null || arestaAdicionada.getVertice2() == null){
			throw new RuntimeException("Não é possível adicionar uma aresta com vértice nulos no grafo");
		}else{
			/*verifica se v1 ja esta no grafo, se não estiver cria uma entrada na lista de adjacencias*/
			Vertice v1 = getVertice(arestaAdicionada.getVertice1().getId());
			/*se v1 ainda nao esta adicionado ao grafo*/
			if(v1 == null){
				Vertice v2 = getVertice(arestaAdicionada.getVertice2().getId());
				if (v2 != null) {
					v1 = arestaAdicionada.getVertice1();
					ArrayList<Vertice> adjV2 = new ArrayList<Vertice>();
					adjV2.add(v2);

					this.grafo.put(v1, adjV2);
				} else {
					// vertice 2 nao esta no grafo !
					v1 = arestaAdicionada.getVertice1();
					v2 = arestaAdicionada.getVertice2();
					ArrayList<Vertice> adjV2 = new ArrayList<Vertice>();
					adjV2.add(v2);

					// adiciona listas de adjacencia do vertice 2 e do vertice 1
					this.grafo.put(v1, adjV2);
					this.grafo.put(v2, new ArrayList<Vertice>());
				}
				// se vertice 1 esta no grafo, adiciona novo elemento na lista
				// de adjacência
			} else {
				// vértice 2 está no grafo?
				Vertice v2 = getVertice(arestaAdicionada.getVertice2().getId());
				if (v2 == null) {
					v2 = arestaAdicionada.getVertice2();
					// adiciona vertice 2 ao grafo
					this.grafo.put(v2, new ArrayList<Vertice>());
				}

				// adiciona vertice 2 a lista de adjacencia do vertice 1
				List<Vertice> l = this.grafo.get(v1);
				l.add(v2);
			}

			}
			
		}
	}


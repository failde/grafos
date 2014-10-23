package factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import grafos.Aresta;
import grafos.Grafo;
import grafos.Vertice;

public class GrafoMatrizAdj implements Grafo<Vertice, Aresta<Vertice,Vertice>>{

	/* Inserir Vertice: mapear no HashMap.
	 * Inserir Aresta: mapear na Matriz. */
	private int TamanhoMatrizAdj = 1000;
	private int TamanhoAtual = 0;
	
	Float[][] matrizAdj = new Float[TamanhoMatrizAdj][TamanhoMatrizAdj];

	HashMap<Integer, Vertice> IntToVert= new HashMap<Integer,Vertice>();
	HashMap<Vertice,Integer> VertToInt = new HashMap<Vertice,Integer>();
	
	/* Se não esta mapeado no hashMap, mapeia, se já esta lança excessão
	 * Só mapeia no HashMap IntToVert se a chave(TamanhoAtual) não estiver na estrutura, caso já esteja
	 * mapeando algum valor lança excessão. 
	 * */
	
	/**
	 * Função responsável por mapear um novo vertice ao HashMap.
	 * @param vertice vertice a ser adicionado ao HashMap
	 */
	public void mapeiaVertice(Vertice vertice){
		if(!IntToVert.containsKey(this.TamanhoAtual) && !VertToInt.containsValue(vertice)){
			this.IntToVert.put(TamanhoAtual, vertice);
			this.VertToInt.put(vertice, TamanhoAtual);
			System.out.println("key: " + this.VertToInt.get(vertice) + "value: " + this.IntToVert.get(TamanhoAtual).getId());
			this.TamanhoAtual++;
		}else{
			throw new RuntimeException("A key " + this.TamanhoAtual + "já está mapeada no HashMap.");
		}
	}
	
	@Override
	public Iterator<Vertice> getVerticesAdjacentes(Vertice u) {
		if(u != null && this.VertToInt.containsKey(u)){
			ArrayList<Vertice> adjs = new ArrayList<Vertice>();
			int key = this.VertToInt.get(u);
			//System.out.println(key);
			/** Percorro o matriz na linha [key], variando a coluna, se matriz[key][i] == 1
			 * adiciona em uma lista que contem os vertices adjacentes. */
			
			for (int i = 0; i < this.TamanhoAtual; i++) {
				try{
					if(this.matrizAdj[key][i] != null){
					//if(!this.matrizAdj[key][i].equals(null)){
						adjs.add(this.IntToVert.get(i));
					}
				}catch(NullPointerException e){
					System.out.println("err: " + e);
				}
				
			}
			return adjs.iterator();
		}else{
			return null;
		}
	}

	@Override
	public Iterator<Vertice> getVertices() {
		return this.VertToInt.keySet().iterator();
	}

	@Override
	public Iterator<Aresta<Vertice, Vertice>> getArestas() {
		//Set<Aresta<Vertices, Vertices>> arestas = new HashSet<Aresta<Vertices,Vertices>>();
		ArrayList<Aresta<Vertice, Vertice>> a = new ArrayList<Aresta<Vertice, Vertice>>();
		
		for(Entry<Integer, Vertice> v: this.IntToVert.entrySet()){
			System.out.println(":" + v.getValue().getId());
			Iterator<Vertice> vertAdjs = this.getVerticesAdjacentes(v.getValue());
			while(vertAdjs.hasNext()){
				Vertice ver = vertAdjs.next();
				System.out.println("-- " + ver.getId());
				a.add(new Aresta<Vertice, Vertice>(v.getValue(), ver));
				//arestas.add(new Aresta<Vertices, Vertices>(v.getValue(), vertAdjs.next()));
			}
		}
		//System.out.println(a.size());
		return a.iterator();
	}

	@Override
	public Vertice getVertice(String idVertice) {
		for(Entry<Vertice, Integer> v : this.VertToInt.entrySet()){
			if(v.getKey().getId().equals(idVertice)){
				return v.getKey();
			}
		}
		return null;
	}

	@Override
	public void adicionaVertice(Vertice verticeNoGrafo,Vertice verticeAdicionado) {
		/* verifica se o verticeNoGrafo esta mapeado na Matriz */
		Vertice v = getVertice(verticeNoGrafo.getId());
		if(v == null){
			throw new RuntimeException("O vertice" + verticeNoGrafo + "deve estar necessarimente no Grafo.");
		}else{
			//System.out.println("Vertice " + verticeAdicionado.getId() + " Id: " + this.TamanhoAtual);
			mapeiaVertice(verticeAdicionado);
			
			/* Insere na MatrizAdj */

			this.matrizAdj[this.VertToInt.get(verticeNoGrafo)][this.VertToInt.get(verticeAdicionado)] = (float) 1.0;
			System.out.println("MattrizAdj[" + this.VertToInt.get(verticeNoGrafo) + "]" + "[" +this.VertToInt.get(verticeAdicionado)+ "] : " + this.matrizAdj[this.VertToInt.get(verticeNoGrafo)][this.VertToInt.get(verticeAdicionado)]);

		}
	}

	@Override
	public void adicionaVertice(Vertice verticeAdicionado) {
	/* Mapeia no HashMap, mas não coloca na matriz pois nao tem vertice adjacente. */		
		Vertice v = getVertice(verticeAdicionado.getId());
		if(v == null){
			mapeiaVertice(verticeAdicionado);
		}else{
			System.out.println("Este vértice já foi inserido no grafo");
			verticeAdicionado = v;
		}
	}

	@Override
	public void adicionaAresta(Aresta<Vertice, Vertice> arestaAdicionada) {
	/* Uma aresta é composta por dois vértices (V1 e V2)
	 * 1 - V1 e V2 não estão na hash.
	 * 2 - V1 e V2 estão na hash.
	 * 3 - V1 não esta na hash.
	 * 4 - V2 não esta na hash.
	 * */
	Vertice v1 = arestaAdicionada.getVertice1();
	Vertice v2 = arestaAdicionada.getVertice2();
	System.out.println("v1 ->" + v1.getId() + "v2 -> " + v2.getId());
	
	/*Caso 1. Adiciona os vertices no hash, e adiciona uma aresta entre eles(marca 1 na matrizAdj).*/
	if(this.getVertice(v1.getId()) == null && this.getVertice(v2.getId()) == null){
		/*Adiciona V1 ao hash, depois com V1 já no hash, adiciona v2 adjacente a v1.*/
		this.adicionaVertice(v1);
		this.adicionaVertice(v1, v2);
	}
	/*Caso 2. Apenas adiciona uma aresta entre os vertices. */
	else if(this.getVertice(v1.getId()) != null && this.getVertice(v2.getId()) != null){
		//System.out.println("if2");
		this.matrizAdj[this.VertToInt.get(v1)][this.VertToInt.get(v2)] = (float)1.0;
	}	
	/*Case 3 e 4.*/
	else if(this.getVertice(v1.getId()) == null && this.getVertice(v2.getId()) != null){
		//System.out.println("if34");
		this.adicionaVertice(v2, v1);
	}else if(this.getVertice(v1.getId()) != null && this.getVertice(v2.getId()) == null){
		System.out.println("if4");
		this.adicionaVertice(v1, v2);
	}
	
	}

	
	
}

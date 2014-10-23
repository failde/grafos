package grafos;

public class Aresta<U extends Vertice, V extends Vertice> {
	private Vertice vertice1 = null;
	private Vertice vertice2 = null;
	
	public Aresta(V V1, V V2) {
		// TODO Auto-generated constructor stub
		this.vertice1 = V1;
		this.vertice2 = V2;
	}

	public Vertice getVertice1() {
		return vertice1;
	}

	public void setVertice1(Vertice vertice1) {
		this.vertice1 = vertice1;
	}

	public Vertice getVertice2() {
		return vertice2;
	}

	public void setVertice2(Vertice vertice2) {
		this.vertice2 = vertice2;
	}
	
	

}

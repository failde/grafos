package grafos;

public class ArestaPonderada extends Aresta<Vertice, Vertice> {
	private double peso = Double.POSITIVE_INFINITY;
	
	public ArestaPonderada(Vertice V1, Vertice V2) {
		super(V1, V2);
		// TODO Auto-generated constructor stub
	}
	
	public double getPeso(){
		return peso;
	}
	
	public void setPeso(double peso){
		this.peso = peso;
	}

}

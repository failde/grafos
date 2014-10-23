package entidades;

import grafos.Vertice;

public class VerticeBuscaLargura extends Vertice {

	private CorVertice cor = new CorVertice(Cor.Branco);
	private int distancia = (int)Float.POSITIVE_INFINITY;
	private VerticeBuscaLargura pai = null;
	
	public VerticeBuscaLargura(String id){
		super(id);
	}
	
	public VerticeBuscaLargura(){
		super();
	}
	
	public CorVertice getCor() {
		return cor;
	}
	
	public void setCor(CorVertice cor) {
		this.cor = cor;
	}
	public int getDistancia() {
		return distancia;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	public VerticeBuscaLargura getPai() {
		return pai;
	}
	public void setPai(VerticeBuscaLargura pai) {
		this.pai = pai;
	}
	
	
}

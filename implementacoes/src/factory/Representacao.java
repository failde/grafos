package factory;

public enum Representacao {
	LISTA_ADJACENCIA(0),
	MATRIZ_ADJACENCIA(1);
	
	private int representacao;
	
	Representacao(int representacao){
		this.setRepresentacao(representacao);
	}

	public int getRepresentacao() {
		return representacao;
	}

	public void setRepresentacao(int representacao) {
		this.representacao = representacao;
	}
}

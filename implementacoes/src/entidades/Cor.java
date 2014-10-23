package entidades;

public enum Cor {
	Preto(0),
	Cinza(1),
	Branco(2),
	Vermelho(3);
	
	private int cor;
	
	Cor(int cor){
		this.setCor(cor);
	}

	public int getCor() {
		return cor;
	}

	public void setCor(int cor) {
		this.cor = cor;
	}
}

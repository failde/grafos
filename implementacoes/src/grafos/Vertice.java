package grafos;

public class Vertice {
	private String id;
	
	public Vertice(){
		this.id = String.valueOf(getClass().hashCode());
	}
	

	
	public Vertice(String id){
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	

}

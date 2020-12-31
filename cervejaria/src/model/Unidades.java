package model;

public class Unidades {
	private String nome;
	private int id;
	
	public Unidades() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Unidades(int id, String nome) {
		super();
		this.nome = nome;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
}

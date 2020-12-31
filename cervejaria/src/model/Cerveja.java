package model;

//import model.DAO;

public class Cerveja {
	private int id;
	private String nome;
	private float indice_alcool;
	private int mililitros;
	private float preco;
	
	public Cerveja(int id, String nome, float indice_alcool, int mililitros, float preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.indice_alcool = indice_alcool;
		this.mililitros = mililitros;
		this.preco = preco;
	}
	public Cerveja() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public float getIndice_alcool() {
		return indice_alcool;
	}
	public void setIndice_alcool(float indice_alcool) {
		this.indice_alcool = indice_alcool;
	}
	
	public int getMililitros() {
		return mililitros;
	}
	public void setMililitros(int mililitros) {
		this.mililitros = mililitros;
	}
	
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
}

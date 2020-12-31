package model;

public class Receita {
	private Cerveja Cerveja_id;
	private Insumo Insumos_id;
	private Unidades Unidades_id;
	private int quantidade;
	
	
	public Receita() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Receita(Cerveja cerveja_id, Insumo insumo_id, Unidades unidades_id, int quantidade) {
		super();
		Cerveja_id = cerveja_id;
		Insumos_id = insumo_id;
		Unidades_id = unidades_id;
		this.quantidade = quantidade;
	}
	
	public Cerveja getCerveja_id() {
		return Cerveja_id;
	}
	public void setCerveja_id(Cerveja cerveja_id) {
		Cerveja_id = cerveja_id;
	}
	public Insumo getInsumos_id() {
		return Insumos_id;
	}
	public void setInsumos_id(Insumo insumos_id) {
		Insumos_id = insumos_id;
	}
	public Unidades getUnidades_id() {
		return Unidades_id;
	}
	public void setUnidades_id(Unidades unidades_id) {
		Unidades_id = unidades_id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}

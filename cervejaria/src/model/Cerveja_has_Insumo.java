package model;

public class Cerveja_has_Insumo {
	private int Cerveja_id;
	private int Insumos_id;
	private int Unidades_id;
	private int quantidade;
	
	public Cerveja_has_Insumo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cerveja_has_Insumo(int cerveja_id, int insumos_id, int unidades_id, int quantidade) {
		super();
		this.Cerveja_id = cerveja_id;
		this.Insumos_id = insumos_id;
		this.Unidades_id = unidades_id;
		this.quantidade = quantidade;
	}
	
	public int getCerveja_id() {
		return Cerveja_id;
	}
	public void setCerveja_id(int cerveja_id) {
		this.Cerveja_id = cerveja_id;
	}
	
	public int getInsumos_id() {
		return Insumos_id;
	}
	public void setInsumos_id(int insumos_id) {
		this.Insumos_id = insumos_id;
	}
	
	public int getUnidades_id() {
		return Unidades_id;
	}
	public void setUnidades_id(int unidades_id) {
		this.Unidades_id = unidades_id;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}

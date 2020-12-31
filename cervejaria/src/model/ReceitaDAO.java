package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReceitaDAO {
	private Connection conexao=DAO.conectar();
	
	public void addReceita(Receita receita) {
		try {			
			PreparedStatement preparedStatement = conexao.prepareStatement("insert into Cerveja_has_Insumos(Cerveja_id, Insumos_id, Unidades_id, quantidade) values (?,?,?,?)");
			preparedStatement.setInt(1, receita.getCerveja_id().getId());
			preparedStatement.setInt(2, receita.getInsumos_id().getId());
			preparedStatement.setInt(3, receita.getUnidades_id().getId());
			preparedStatement.setInt(4, receita.getQuantidade());
			preparedStatement.executeUpdate();
		}catch (SQLException e) {
            e.printStackTrace();
        }				
	}
	
//	fazer intersecao/ diferenca para descobrir quais ingredientes foram removidos
	
	public void deleteReceita(Receita receita) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("delete from Cerveja_has_Insumos where Cerveja_id=? and Insumos_id=? and Unidades_id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, receita.getCerveja_id().getId());
            preparedStatement.setInt(2, receita.getInsumos_id().getId());
            preparedStatement.setInt(3, receita.getUnidades_id().getId());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void updateReceita(Receita receita) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("update Cerveja_has_Insumos set quantidade=? where Cerveja_id=? and Insumos_id=? and Unidades_id=?");
            // Parameters start with 1
			preparedStatement.setInt(1, receita.getQuantidade());
            preparedStatement.setInt(2, receita.getCerveja_id().getId());
			preparedStatement.setInt(3, receita.getInsumos_id().getId());
			preparedStatement.setInt(4, receita.getUnidades_id().getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public List<Receita> getAllReceitas() {
        List<Receita> listaDeReceitas= new ArrayList<Receita>();
        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Cerveja_has_Insumos order by Cerveja_id");
            while (rs.next()) {
            	Receita receita= new Receita();
            	CervejaDAO cerveja = new CervejaDAO();
            	InsumoDAO insumo = new InsumoDAO();
            	UnidadesDAO unidade =  new UnidadesDAO();
            	
                receita.setCerveja_id(cerveja.getCervejaById(rs.getInt("Cerveja_id")));
    			receita.setInsumos_id(insumo.getInsumoById(rs.getInt("Insumos_id")));
    			receita.setUnidades_id(unidade.getUnidadeById(rs.getInt("Unidades_id")));
    			receita.setQuantidade(rs.getInt("quantidade"));
                listaDeReceitas.add(receita);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDeReceitas;
    }
	
	public Receita getReceitaById(int cerveja_id, int unidade_id, int insumo_id) {
		Receita nova_receita= new Receita();
    	CervejaDAO cerveja = new CervejaDAO();
    	InsumoDAO insumo = new InsumoDAO();
    	UnidadesDAO unidade =  new UnidadesDAO();
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("select * from Cerveja_has_Insumos where Cerveja_id=? and Insumos_id=? and Unidades_id=?");
            preparedStatement.setInt(1, cerveja_id);
            preparedStatement.setInt(2, insumo_id);
            preparedStatement.setInt(3, unidade_id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	nova_receita.setQuantidade(rs.getInt("quantidade"));
            	nova_receita.setCerveja_id(cerveja.getCervejaById(rs.getInt("Cerveja_id")));
            	nova_receita.setInsumos_id(insumo.getInsumoById(rs.getInt("Insumos_id")));
            	nova_receita.setUnidades_id(unidade.getUnidadeById(rs.getInt("Unidades_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nova_receita;
    }
}

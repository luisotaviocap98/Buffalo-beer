package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Cerveja_has_InsumoDAO {
private Connection conexao=DAO.conectar();
	

	public void addReceita(Cerveja_has_Insumo receita) {
		try {			
			PreparedStatement preparedStatement = conexao.prepareStatement("insert into Cerveja_has_Insumos(Cerveja_id, Insumos_id, Unidades_id, quantidade) values (?,?,?,?)");
			preparedStatement.setInt(1, receita.getCerveja_id());
			preparedStatement.setInt(1, receita.getInsumos_id());
			preparedStatement.setInt(1, receita.getUnidades_id());
			preparedStatement.setInt(1, receita.getQuantidade());
			preparedStatement.executeUpdate();
		}catch (SQLException e) {
            e.printStackTrace();
        }				
	}
	
//	fazer intersecao/ diferenca para descobrir quais ingredientes foram removidos
	
	public void deleteReceita(Cerveja_has_Insumo receita) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("delete from Cerveja_has_Insumos where Cerveja_id=? and Insumos_id=? and Unidades_id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, receita.getCerveja_id());
            preparedStatement.setInt(2, receita.getInsumos_id());
            preparedStatement.setInt(3, receita.getUnidades_id());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void updateReceita(Cerveja_has_Insumo receita) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("update Cerveja_has_Insumos set Cerveja_id=?, Insumos_id=?, Unidades_id=?, quantidade=?" + "where Cerveja_id=? and Insumos_id=? and Unidades_id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, receita.getCerveja_id());
			preparedStatement.setInt(2, receita.getInsumos_id());
			preparedStatement.setInt(3, receita.getUnidades_id());
			preparedStatement.setInt(4, receita.getQuantidade());

            preparedStatement.setInt(5, receita.getCerveja_id());
			preparedStatement.setInt(6, receita.getInsumos_id());
			preparedStatement.setInt(7, receita.getUnidades_id());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//
	
//	 
//	"select *"
//+"from Cerveja_has_Insumos" 
//+"join Cerveja on Cerveja_has_Insumos.Cerveja_id = Cerveja.id" 
//+"join Insumos on Insumos.id = Cerveja_has_Insumos.Insumos_id"
//+"join Unidades on Unidades.id = Cerveja_has_Insumos.Unidades_id"
//+"order by Cerveja.id"
	public List<Cerveja_has_Insumo> getAllReceitas() {
        List<Cerveja_has_Insumo> listaDeReceitas= new ArrayList<Cerveja_has_Insumo>();
        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Cerveja_has_Insumos order by Cerveja_id");
            while (rs.next()) {
            	Cerveja_has_Insumo receita= new Cerveja_has_Insumo();
                receita.setCerveja_id(rs.getInt("Cerveja_id"));
    			receita.setInsumos_id(rs.getInt("Insumos_id"));
    			receita.setUnidades_id(rs.getInt("Unidades_id"));
    			receita.setQuantidade(rs.getInt("quantidade"));
                listaDeReceitas.add(receita);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDeReceitas;
    }
	
	public Cerveja_has_Insumo getReceitaById(Cerveja_has_Insumo receita) {
		Cerveja_has_Insumo nova_receita= new Cerveja_has_Insumo();
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("select * from Cerveja_has_Insumos where Cerveja_id=? and Insumos_id=? and Unidades_id=?");
            preparedStatement.setInt(1, receita.getCerveja_id());
            preparedStatement.setInt(2, receita.getInsumos_id());
            preparedStatement.setInt(3, receita.getUnidades_id());
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	nova_receita.setCerveja_id(rs.getInt("Cerveja_id"));
            	nova_receita.setInsumos_id(rs.getInt("Insumos_id"));
            	nova_receita.setUnidades_id(rs.getInt("Unidades_id"));
            	nova_receita.setQuantidade(rs.getInt("quantidade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nova_receita;
    }
}

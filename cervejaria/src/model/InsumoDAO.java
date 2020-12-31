package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InsumoDAO {
	private Connection conexao=DAO.conectar();

	
	public void addInsumo(Insumo insumo) {
		try {			
			PreparedStatement preparedStatement = conexao.prepareStatement("insert into Insumos(nome) values (?)");
			preparedStatement.setString(1, insumo.getNome());
			preparedStatement.executeUpdate();
		}catch (SQLException e) {
            e.printStackTrace();
        }				
	}
	
	public int deleteInsumo(int id) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("delete from Insumos where id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
	
	public void updateInsumo(Insumo insumo) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("update Insumos set nome=? where id=?");
            // Parameters start with 1
            preparedStatement.setString(1, insumo.getNome());
            preparedStatement.setInt(2, insumo.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	
	public List<Insumo> getAllInsumo() {
        List<Insumo> listaDeInsumo= new ArrayList<Insumo>();
        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Insumos");
            while (rs.next()) {
                Insumo insumo= new Insumo();
                insumo.setId(rs.getInt("id"));
                insumo.setNome(rs.getString("nome"));
                listaDeInsumo.add(insumo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDeInsumo;
    }
	
	public Insumo getInsumoById(int id) {
        Insumo insumo= new Insumo();
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("select * from Insumos where id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                insumo.setId(rs.getInt("id"));
                insumo.setNome(rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return insumo;
    }
}

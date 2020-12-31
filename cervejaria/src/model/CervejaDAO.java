package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CervejaDAO {
	private Connection conexao=DAO.conectar();
	
	
	public void addCerveja(Cerveja cerveja) {

		try {			
			PreparedStatement preparedStatement = conexao.prepareStatement("insert into Cerveja(nome,indice_alcool,mililitros,preco) values (?, ?, ?, ? )");
		
			preparedStatement.setString(1, cerveja.getNome());
			preparedStatement.setFloat(2, cerveja.getIndice_alcool());
			preparedStatement.setInt(3, cerveja.getMililitros());
			preparedStatement.setFloat(4, cerveja.getPreco());
			preparedStatement.executeUpdate();
			
			
		}catch (SQLException e) {
            e.printStackTrace();
        }	
	}
	
	public int deleteCerveja(int id) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("delete from Cerveja where id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
	
	public void updateCerveja(Cerveja cerveja) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("update Cerveja set nome=?, indice_alcool=?, mililitros=?, preco=? where id=?");
            // Parameters start with 1
            preparedStatement.setString(1, cerveja.getNome());
            preparedStatement.setFloat(2, cerveja.getIndice_alcool());
            preparedStatement.setInt(3, cerveja.getMililitros());
            preparedStatement.setFloat(4, cerveja.getPreco());
            preparedStatement.setInt(5, cerveja.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	
	public List<Cerveja> getAllCerveja() {
        List<Cerveja> listaDeCerveja= new ArrayList<Cerveja>();
        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Cerveja");
            while (rs.next()) {
                Cerveja cerveja= new Cerveja();
                cerveja.setId(rs.getInt("id"));
                cerveja.setNome(rs.getString("nome"));
                cerveja.setIndice_alcool(rs.getFloat("indice_alcool"));
                cerveja.setMililitros(rs.getInt("mililitros"));
                cerveja.setPreco(rs.getFloat("preco"));
                listaDeCerveja.add(cerveja);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDeCerveja;
    }
	
	public Cerveja getCervejaById(int id) {
        Cerveja cerveja= new Cerveja();
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("select * from Cerveja where id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                cerveja.setId(rs.getInt("id"));
                cerveja.setNome(rs.getString("nome"));
                cerveja.setIndice_alcool(rs.getFloat("indice_alcool"));
                cerveja.setMililitros(rs.getInt("mililitros"));
                cerveja.setPreco(rs.getFloat("preco"));
                cerveja.setNome(rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cerveja;
    }
}

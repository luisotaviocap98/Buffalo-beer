package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UnidadesDAO {
private Connection conexao=DAO.conectar();;

	
	public void addUnidade(Unidades unidade) {
		try {			
			PreparedStatement preparedStatement = conexao.prepareStatement("insert into Unidades(nome) values (?)");
			preparedStatement.setString(1, unidade.getNome());
			preparedStatement.executeUpdate();
		}catch (SQLException e) {
            e.printStackTrace();
        }				
	}
	
	public int deleteUnidade(int id) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("delete from Unidades where id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
	
	public void updateUnidade(Unidades unidade) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("update Unidades set nome=? where id=?");
            // Parameters start with 1
            preparedStatement.setString(1, unidade.getNome());
            preparedStatement.setInt(2, unidade.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	
	public List<Unidades> getAllUnidade() {
        List<Unidades> listaDeUnidades= new ArrayList<Unidades>();
      
        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Unidades");
            while (rs.next()) {
                Unidades unidade= new Unidades();
                unidade.setId(rs.getInt("id"));
                unidade.setNome(rs.getString("nome"));
                listaDeUnidades.add(unidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDeUnidades;
    }
	
	public Unidades getUnidadeById(int id) {
        Unidades unidade= new Unidades();
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("select * from Unidades where id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                unidade.setId(rs.getInt("id"));
                unidade.setNome(rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return unidade;
    }
}

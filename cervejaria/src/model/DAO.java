package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/mydb?useTimezone=true&serverTimezone=UTC";
	private static String user = "root";
	private static String password = "";
	
	public static Connection conectar() {
		Connection conect = null;
		try {
			Class.forName(driver);
			conect = DriverManager.getConnection(url, user, password);
			return conect;
		} catch (Exception e) {
			System.out.println(e);
			return null;
			// TODO: handle exception
		}
	}
	public void testConexao() {
		try {
			Connection conect = conectar();
			System.out.println(conect);
			conect.close();
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}
}

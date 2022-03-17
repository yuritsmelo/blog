package br.ucsal.blog.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoDados {
	public static void main(String[] args) {
		String url = "jdbc:hsqldb:mem:mymemdb";
		String user = "sa";
		String password = "";
		Connection connection= null;
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Statement statement = connection.createStatement();
			String sql = "CREATE TABLE ALUNOS (ID INT PRIMARY KEY, "
					+ "MATRICULA CHAR(20), "
					+ "NOME VARCHAR(250))";
			statement.execute(sql);
			
			System.out.println("CRIOU A TABELA");
			
			Statement insert = connection.createStatement();
			String sqldoInsert = "INSERT INTO ALUNOS "
					+ " (ID, MATRICULA, NOME) VALUES (1, '202012301','PEDRO LUCAS')";
			insert.execute(sqldoInsert);
			
			System.out.println("INSERIU NA TABELA");
			
			Statement select= connection.createStatement();
			String sqldoSelect = "SELECT * FROM ALUNOS ";
			ResultSet resultSet = select.executeQuery(sqldoSelect);
			
			while (resultSet.next()) {
				System.out.println(resultSet.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

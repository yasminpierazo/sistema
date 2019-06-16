package br.com.sistema.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conex�o {
	//private final String driverClass = "com.mysql.jdbc.Driver";

	private static final String USUARIO = "root";
	private static final String SENHA = "200102";
	private static final String URL = "jdbc:mysql://localhost:3306/sistema?useTimezone=true&serverTimezone=UTC";
	
	public static Connection conectar() throws SQLException{
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;	
	}
	
	public static void main(String[] args) {
		try{
		Connection conexao = Conex�o.conectar();
		System.out.println("Conex�o realizada com sucesso!");
		}catch(SQLException ex){
			ex.printStackTrace();
			System.out.println("N�o foi poss�vel realizar conex�o!");
			
		}
	}
	
}

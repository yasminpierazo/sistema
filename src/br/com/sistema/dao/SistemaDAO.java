package br.com.sistema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.sistema.domain.Sistema;
import br.com.sistema.factory.Conexão;

public class SistemaDAO {


	public void salvar(Sistema s) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO sistema ");
		sql.append("(cliente, telefone, end, equip, marca, modelo, defeito, datachegada, preco) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ");

		Connection conexao = Conexão.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, s.getCliente());
		comando.setString(2, s.getTelefone());
		comando.setString(3, s.getEnd());
		comando.setString(4, s.getEquip());
		comando.setString(5, s.getMarca());
		comando.setString(6, s.getModelo());
		comando.setString(7, s.getDefeito());
		comando.setString(8, s.getDatachegada());
		comando.setDouble(9, s.getPreco());
		comando.executeUpdate();

	}
	
	public void excluir (Sistema p)throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM sistema ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = Conexão.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setInt(1, p.getCodigo());
		
		comando.executeUpdate();
	}
	
	public void editar(Sistema s) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE sistema ");
		sql.append("SET cliente = ?, telefone = ?, end = ?, equip = ?, marca = ?, modelo = ?, defeito = ?, datachegada = ?, datasaida = ?, preco = ?, servicoex = ?, status = ? ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = Conexão.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, s.getCliente());
		comando.setString(2, s.getTelefone());
		comando.setString(3, s.getEnd());
		comando.setString(4, s.getEquip());
		comando.setString(5, s.getMarca());
		comando.setString(6, s.getModelo());
		comando.setString(7, s.getDefeito());
		comando.setString(8, s.getDatachegada());
		comando.setString(9, s.getDatasaida());
		comando.setDouble(10, s.getPreco());
		comando.setString(11, s.getServicoex());
		comando.setBoolean(12, s.getStatus());
		comando.setInt(13, s.getCodigo());
		
		comando.executeUpdate();

	}
	public void finalizar (Sistema p)throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE sistema ");
		sql.append("SET status = false, datasaida = ?, preco = ?, servicoex = ? ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = Conexão.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, p.getDatasaida());
		comando.setDouble(2, p.getPreco());
		comando.setString(3, p.getServicoex());
		comando.setInt(4, p.getCodigo());
		
		comando.executeUpdate();
	}
	
	
	
	public ArrayList<Sistema> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.codigo, p.cliente, p.telefone, p.end, p.equip, p.marca, p.modelo, p.defeito, p.datachegada, p.datasaida, p.preco, p.servicoex, p.status ");
		sql.append("FROM sistema p ");
		
		Connection conexao = Conexão.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Sistema> itens = new ArrayList<Sistema>();
		
		while(resultado.next()){
			
			Sistema p = new Sistema();
			p.setCodigo(resultado.getInt("p.codigo"));
			p.setCliente(resultado.getString("p.cliente"));
			p.setTelefone(resultado.getString("p.telefone"));
			p.setEnd(resultado.getString("p.end"));
			p.setEquip(resultado.getString("p.equip"));
			p.setMarca(resultado.getString("p.marca"));
			p.setModelo(resultado.getString("p.modelo"));
			p.setDefeito(resultado.getString("p.defeito"));
			p.setDatachegada(resultado.getString("p.datachegada"));
			p.setDatasaida(resultado.getString("p.datasaida"));
			p.setPreco(resultado.getDouble("p.preco"));
			p.setServicoex(resultado.getString("p.servicoex"));
			p.setStatus(resultado.getBoolean("p.status"));
						
			itens.add(p);
			
		}
		return itens;
	}
	
	
}

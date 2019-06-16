package br.com.sistema.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sistema.dao.SistemaDAO;
import br.com.sistema.domain.Sistema;
import br.com.sistema.relatorio.Relatorio;
import br.com.sistema.util.JSFUtil;

@ManagedBean(name = "MBSistema")
@ViewScoped
public class SistemaBean implements Serializable  {
	private Sistema sistema;
	private ArrayList<Sistema> itens;
	private ArrayList<Sistema> itensFiltrados;

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public ArrayList<Sistema> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Sistema> itens) {
		this.itens = itens;
	}

	public ArrayList<Sistema> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Sistema> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	// @PostConstruct
	public void carregarListagem() {
		try {
			SistemaDAO dao = new SistemaDAO();
			itens = dao.listar();

		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.addMsgErro(ex.getMessage());
		}

	}

	public void prepararNovo() {
		sistema = new Sistema();
	}

	public void novo() {
		try {
			SistemaDAO dao = new SistemaDAO();
			dao.salvar(sistema);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Serviço salvo com sucesso.");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.addMsgErro(ex.getMessage());
		}
	}

	public void excluir() {
		try {
			SistemaDAO dao = new SistemaDAO();
			dao.excluir(sistema);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Serviço removido com sucesso.");

		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.addMsgErro(ex.getMessage());

		}

	}

	public void prepararEditar() {
		try {

			SistemaDAO dao = new SistemaDAO();

			itens = dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.addMsgErro(ex.getMessage());
		}
	}

	public void editar() {
		try {
			SistemaDAO dao = new SistemaDAO();
			dao.editar(sistema);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Serviço editado com sucesso.");

		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.addMsgErro(ex.getMessage());
		}
	}

	public void prepararFinalizar() {
		try {

			SistemaDAO dao = new SistemaDAO();

			itens = dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.addMsgErro(ex.getMessage());
		}
	}

	public void finalizar() {
		try {
			SistemaDAO dao = new SistemaDAO();
			dao.finalizar(sistema);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Serviço finalizado com sucesso.");

		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.addMsgErro(ex.getMessage());
		}
	}

	
	
	public void imprimir() {
		Relatorio report = new Relatorio();
		List<Sistema> pp = new ArrayList<>();
		pp.add(sistema);
		report.getRelatorio(pp);
			

		
	}

}

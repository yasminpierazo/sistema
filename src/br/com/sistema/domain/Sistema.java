package br.com.sistema.domain;

public class Sistema {
	private Integer codigo;
	private String cliente;
	private String telefone;
	private String end;
	private String equip;
	private String marca;
	private String modelo;
	private String defeito;
	private String datachegada;
	private String datasaida;
	private Double preco;
	private String servicoex;
	private Boolean status;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getEquip() {
		return equip;
	}

	public void setEquip(String equip) {
		this.equip = equip;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDefeito() {
		return defeito;
	}

	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}

	public String getDatachegada() {
		return datachegada;
	}

	public void setDatachegada(String datachegada) {
		this.datachegada = datachegada;
	}

	public String getDatasaida() {
		return datasaida;
	}

	public void setDatasaida(String datasaida) {
		this.datasaida = datasaida;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getServicoex() {
		return servicoex;
	}

	public void setServicoex(String servicoex) {
		this.servicoex = servicoex;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}

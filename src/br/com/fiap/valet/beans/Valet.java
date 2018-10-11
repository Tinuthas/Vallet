package br.com.fiap.valet.beans;

import java.util.Date;

public class Valet {
	private long id;
	private String modelo;
	private String placa;
	private Date entrada;
	private Date saida;
	private double preco;
	public Valet(long id, String modelo, String placa, Date entrada, Date saida, double preco) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.placa = placa;
		this.entrada = entrada;
		this.saida = saida;
		this.preco = preco;
	}
	public Valet() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Date getEntrada() {
		return entrada;
	}
	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}
	public Date getSaida() {
		return saida;
	}
	public void setSaida(Date saida) {
		this.saida = saida;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	
}

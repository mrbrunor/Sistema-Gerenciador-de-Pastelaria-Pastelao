package com.au.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the caixa database table.
 * 
 */
@Entity
@Table(name="caixa")
@NamedQuery(name="Caixa.findAll", query="SELECT c FROM Caixa c")
public class Caixa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idCaixa;

	@Column(nullable=false)
	private Time aberturaCaixa;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dataCaixa;

	@Column(nullable=false)
	private byte estaAberto;

	private Time fechamentoCaixa;

	@Column(nullable=false)
	private double fundoCaixa;

	@Column(nullable=false)
	private double totalCaixa;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idFunc", nullable=false)
	private Funcionario funcionario;

	//bi-directional many-to-one association to Despesa
	@OneToMany(mappedBy="caixa")
	private List<Despesa> despesas;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="caixa")
	private List<Pedido> pedidos;

	public Caixa() {
	}

	public int getIdCaixa() {
		return this.idCaixa;
	}

	public void setIdCaixa(int idCaixa) {
		this.idCaixa = idCaixa;
	}

	public Time getAberturaCaixa() {
		return this.aberturaCaixa;
	}

	public void setAberturaCaixa(Time aberturaCaixa) {
		this.aberturaCaixa = aberturaCaixa;
	}

	public Date getDataCaixa() {
		return this.dataCaixa;
	}

	public void setDataCaixa(Date dataCaixa) {
		this.dataCaixa = dataCaixa;
	}

	public byte getEstaAberto() {
		return this.estaAberto;
	}

	public void setEstaAberto(byte estaAberto) {
		this.estaAberto = estaAberto;
	}

	public Time getFechamentoCaixa() {
		return this.fechamentoCaixa;
	}

	public void setFechamentoCaixa(Time fechamentoCaixa) {
		this.fechamentoCaixa = fechamentoCaixa;
	}

	public double getFundoCaixa() {
		return this.fundoCaixa;
	}

	public void setFundoCaixa(double fundoCaixa) {
		this.fundoCaixa = fundoCaixa;
	}

	public double getTotalCaixa() {
		return this.totalCaixa;
	}

	public void setTotalCaixa(double totalCaixa) {
		this.totalCaixa = totalCaixa;
	}

	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Despesa> getDespesas() {
		return this.despesas;
	}

	public void setDespesas(List<Despesa> despesas) {
		this.despesas = despesas;
	}

	public Despesa addDespesa(Despesa despesa) {
		getDespesas().add(despesa);
		despesa.setCaixa(this);

		return despesa;
	}

	public Despesa removeDespesa(Despesa despesa) {
		getDespesas().remove(despesa);
		despesa.setCaixa(null);

		return despesa;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setCaixa(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setCaixa(null);

		return pedido;
	}

}
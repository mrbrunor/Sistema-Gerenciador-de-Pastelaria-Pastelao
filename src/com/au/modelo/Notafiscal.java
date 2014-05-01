package com.au.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the notafiscal database table.
 * 
 */
@Entity
@Table(name="notafiscal")
@NamedQuery(name="Notafiscal.findAll", query="SELECT n FROM Notafiscal n")
public class Notafiscal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idNota;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dataNota;

	@Column(nullable=false)
	private double descNota;

	@Column(nullable=false)
	private Time horaNota;

	@Column(nullable=false)
	private double subTotNota;

	@Column(nullable=false)
	private double totNota;

	//bi-directional many-to-one association to Despesa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idDesp", nullable=false)
	private Despesa despesa;

	//bi-directional many-to-one association to Fornecedor
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idForn", nullable=false)
	private Fornecedor fornecedor;

	//bi-directional many-to-one association to Notaingrediente
	@OneToMany(mappedBy="notafiscal")
	private List<Notaingrediente> notaingredientes;

	//bi-directional many-to-one association to Notaproduto
	@OneToMany(mappedBy="notafiscal")
	private List<Notaproduto> notaprodutos;

	public Notafiscal() {
	}

	public int getIdNota() {
		return this.idNota;
	}

	public void setIdNota(int idNota) {
		this.idNota = idNota;
	}

	public Date getDataNota() {
		return this.dataNota;
	}

	public void setDataNota(Date dataNota) {
		this.dataNota = dataNota;
	}

	public double getDescNota() {
		return this.descNota;
	}

	public void setDescNota(double descNota) {
		this.descNota = descNota;
	}

	public Time getHoraNota() {
		return this.horaNota;
	}

	public void setHoraNota(Time horaNota) {
		this.horaNota = horaNota;
	}

	public double getSubTotNota() {
		return this.subTotNota;
	}

	public void setSubTotNota(double subTotNota) {
		this.subTotNota = subTotNota;
	}

	public double getTotNota() {
		return this.totNota;
	}

	public void setTotNota(double totNota) {
		this.totNota = totNota;
	}

	public Despesa getDespesa() {
		return this.despesa;
	}

	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}

	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Notaingrediente> getNotaingredientes() {
		return this.notaingredientes;
	}

	public void setNotaingredientes(List<Notaingrediente> notaingredientes) {
		this.notaingredientes = notaingredientes;
	}

	public Notaingrediente addNotaingrediente(Notaingrediente notaingrediente) {
		getNotaingredientes().add(notaingrediente);
		notaingrediente.setNotafiscal(this);

		return notaingrediente;
	}

	public Notaingrediente removeNotaingrediente(Notaingrediente notaingrediente) {
		getNotaingredientes().remove(notaingrediente);
		notaingrediente.setNotafiscal(null);

		return notaingrediente;
	}

	public List<Notaproduto> getNotaprodutos() {
		return this.notaprodutos;
	}

	public void setNotaprodutos(List<Notaproduto> notaprodutos) {
		this.notaprodutos = notaprodutos;
	}

	public Notaproduto addNotaproduto(Notaproduto notaproduto) {
		getNotaprodutos().add(notaproduto);
		notaproduto.setNotafiscal(this);

		return notaproduto;
	}

	public Notaproduto removeNotaproduto(Notaproduto notaproduto) {
		getNotaprodutos().remove(notaproduto);
		notaproduto.setNotafiscal(null);

		return notaproduto;
	}

}
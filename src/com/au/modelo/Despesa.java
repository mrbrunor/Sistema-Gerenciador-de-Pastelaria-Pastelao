package com.au.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the despesa database table.
 * 
 */
@Entity
@Table(name="despesa")
@NamedQuery(name="Despesa.findAll", query="SELECT d FROM Despesa d")
public class Despesa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idDesp;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dataDesp;

	@Column(nullable=false, length=100)
	private String descDesp;

	@Column(nullable=false)
	private byte retirada;

	@Column(nullable=false)
	private double valorDesp;

	//bi-directional many-to-one association to Caixa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCaixa", nullable=false)
	private Caixa caixa;


	public Despesa() {
	}

	public int getIdDesp() {
		return this.idDesp;
	}

	public void setIdDesp(int idDesp) {
		this.idDesp = idDesp;
	}

	public Date getDataDesp() {
		return this.dataDesp;
	}

	public void setDataDesp(Date dataDesp) {
		this.dataDesp = dataDesp;
	}

	public String getDescDesp() {
		return this.descDesp;
	}

	public void setDescDesp(String descDesp) {
		this.descDesp = descDesp;
	}

	public byte getRetirada() {
		return this.retirada;
	}

	public void setRetirada(byte retirada) {
		this.retirada = retirada;
	}

	public double getValorDesp() {
		return this.valorDesp;
	}

	public void setValorDesp(double valorDesp) {
		this.valorDesp = valorDesp;
	}

	public Caixa getCaixa() {
		return this.caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}
}
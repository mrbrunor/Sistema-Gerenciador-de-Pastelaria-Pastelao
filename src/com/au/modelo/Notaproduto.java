package com.au.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the notaproduto database table.
 * 
 */
@Entity
@Table(name="notaproduto")
@NamedQuery(name="Notaproduto.findAll", query="SELECT n FROM Notaproduto n")
public class Notaproduto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NotaprodutoPK id;

	@Column(nullable=false)
	private int qtdNota;

	@Column(nullable=false)
	private double valorNota;

	//bi-directional many-to-one association to Notafiscal
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idNota", nullable=false, insertable=false, updatable=false)
	private Notafiscal notafiscal;

	//bi-directional many-to-one association to Produto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idProd", nullable=false, insertable=false, updatable=false)
	private Produto produto;

	public Notaproduto() {
	}

	public NotaprodutoPK getId() {
		return this.id;
	}

	public void setId(NotaprodutoPK id) {
		this.id = id;
	}

	public int getQtdNota() {
		return this.qtdNota;
	}

	public void setQtdNota(int qtdNota) {
		this.qtdNota = qtdNota;
	}

	public double getValorNota() {
		return this.valorNota;
	}

	public void setValorNota(double valorNota) {
		this.valorNota = valorNota;
	}

	public Notafiscal getNotafiscal() {
		return this.notafiscal;
	}

	public void setNotafiscal(Notafiscal notafiscal) {
		this.notafiscal = notafiscal;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
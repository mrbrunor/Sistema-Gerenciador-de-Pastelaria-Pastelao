package com.au.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the notaingrediente database table.
 * 
 */
@Entity
@Table(name="notaingrediente")
@NamedQuery(name="Notaingrediente.findAll", query="SELECT n FROM Notaingrediente n")
public class Notaingrediente implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NotaingredientePK id;

	@Column(nullable=false)
	private int qtdNota;

	@Column(nullable=false)
	private double valorNota;

	//bi-directional many-to-one association to Ingrediente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idIng", nullable=false, insertable=false, updatable=false)
	private Ingrediente ingrediente;

	//bi-directional many-to-one association to Notafiscal
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idNota", nullable=false, insertable=false, updatable=false)
	private Notafiscal notafiscal;

	public Notaingrediente() {
	}

	public NotaingredientePK getId() {
		return this.id;
	}

	public void setId(NotaingredientePK id) {
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

	public Ingrediente getIngrediente() {
		return this.ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public Notafiscal getNotafiscal() {
		return this.notafiscal;
	}

	public void setNotafiscal(Notafiscal notafiscal) {
		this.notafiscal = notafiscal;
	}

}
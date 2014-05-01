package com.au.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ingrediente database table.
 * 
 */
@Entity
@Table(name="ingrediente")
@NamedQuery(name="Ingrediente.findAll", query="SELECT i FROM Ingrediente i")
public class Ingrediente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idIng;

	@Column(nullable=false, length=100)
	private String descIng;

	@Column(nullable=false)
	private double valorIng;

	//bi-directional many-to-one association to Notaingrediente
	@OneToMany(mappedBy="ingrediente")
	private List<Notaingrediente> notaingredientes;

	//bi-directional many-to-many association to Produto
	@ManyToMany(mappedBy="ingredientes")
	private List<Produto> produtos;

	public Ingrediente() {
	}

	public int getIdIng() {
		return this.idIng;
	}

	public void setIdIng(int idIng) {
		this.idIng = idIng;
	}

	public String getDescIng() {
		return this.descIng;
	}

	public void setDescIng(String descIng) {
		this.descIng = descIng;
	}

	public double getValorIng() {
		return this.valorIng;
	}

	public void setValorIng(double valorIng) {
		this.valorIng = valorIng;
	}

	public List<Notaingrediente> getNotaingredientes() {
		return this.notaingredientes;
	}

	public void setNotaingredientes(List<Notaingrediente> notaingredientes) {
		this.notaingredientes = notaingredientes;
	}

	public Notaingrediente addNotaingrediente(Notaingrediente notaingrediente) {
		getNotaingredientes().add(notaingrediente);
		notaingrediente.setIngrediente(this);

		return notaingrediente;
	}

	public Notaingrediente removeNotaingrediente(Notaingrediente notaingrediente) {
		getNotaingredientes().remove(notaingrediente);
		notaingrediente.setIngrediente(null);

		return notaingrediente;
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
package com.au.modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the produto database table.
 * 
 */
@Entity
@Table(name="produto")
@NamedQuery(name="Produto.findAll", query="SELECT p FROM Produto p")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idProd;

	@Column(length=15)
	private String codBarras;

	@Column(nullable=false, length=100)
	private String descProd;

	@Column(nullable=false)
	private byte eIndustrializado;

	private Integer qtdProd;

	@Column(nullable=false)
	private double valorProd;

	//bi-directional many-to-one association to Itempedido
	@OneToMany(mappedBy="produto")
	private List<Itempedido> itempedidos;

	//bi-directional many-to-many association to Ingrediente
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="receita"
		, joinColumns={
			@JoinColumn(name="idProd", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="idIng", nullable=false)
			}
		)
	private List<Ingrediente> ingredientes = new ArrayList<>();

	public Produto() {
	}

	public int getIdProd() {
		return this.idProd;
	}

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	public String getCodBarras() {
		return this.codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public String getDescProd() {
		return this.descProd;
	}

	public void setDescProd(String descProd) {
		this.descProd = descProd;
	}

	public byte getEIndustrializado() {
		return this.eIndustrializado;
	}

	public void setEIndustrializado(byte eIndustrializado) {
		this.eIndustrializado = eIndustrializado;
	}

	public Integer getQtdProd() {
		return this.qtdProd;
	}

	public void setQtdProd(Integer qtdProd) {
		this.qtdProd = qtdProd;
	}

	public double getValorProd() {
		return this.valorProd;
	}

	public void setValorProd(double valorProd) {
		this.valorProd = valorProd;
	}

	public List<Itempedido> getItempedidos() {
		return this.itempedidos;
	}

	public void setItempedidos(List<Itempedido> itempedidos) {
		this.itempedidos = itempedidos;
	}

	public Itempedido addItempedido(Itempedido itempedido) {
		getItempedidos().add(itempedido);
		itempedido.setProduto(this);

		return itempedido;
	}

	public Itempedido removeItempedido(Itempedido itempedido) {
		getItempedidos().remove(itempedido);
		itempedido.setProduto(null);

		return itempedido;
	}

	public List<Ingrediente> getIngredientes() {
		return this.ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public void adicionaIngrediente(Ingrediente ingrediente) {
		if (!this.ingredientes.contains(ingrediente)) {
			this.ingredientes.add(ingrediente);
		}
	}

}
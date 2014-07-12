package com.au.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the itempedido database table.
 * 
 */
@Entity
@Table(name="itempedido")
@NamedQuery(name="Itempedido.findAll", query="SELECT i FROM Itempedido i")
public class Itempedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItempedidoPK id;

	@Column(nullable=false)
	private Integer qtdProd;

	@Column(nullable=false)
	private double totProd;

	//bi-directional many-to-one association to Pedido
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idPedido", nullable=false, insertable=false, updatable=false)
	private Pedido pedido;

	//bi-directional many-to-one association to Produto
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idProd", nullable=false, insertable=false, updatable=false)
	private Produto produto;

	public Itempedido() {
	}

	public ItempedidoPK getId() {
		return this.id;
	}

	public void setId(ItempedidoPK id) {
		this.id = id;
	}

	public Integer getQtdProd() {
		return this.qtdProd;
	}

	public void setQtdProd(Integer qtdProd) {
		this.qtdProd = qtdProd;
	}

	public double getTotProd() {
		return this.totProd;
	}

	public void setTotProd(double totProd) {
		this.totProd = totProd;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
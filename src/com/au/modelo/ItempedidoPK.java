package com.au.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the itempedido database table.
 * 
 */
@Embeddable
public class ItempedidoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private int idPedido;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private int idProd;

	public ItempedidoPK() {
	}
	public int getIdPedido() {
		return this.idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public int getIdProd() {
		return this.idProd;
	}
	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ItempedidoPK)) {
			return false;
		}
		ItempedidoPK castOther = (ItempedidoPK)other;
		return 
			(this.idPedido == castOther.idPedido)
			&& (this.idProd == castOther.idProd);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPedido;
		hash = hash * prime + this.idProd;
		
		return hash;
	}
}
package com.au.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the notaproduto database table.
 * 
 */
@Embeddable
public class NotaprodutoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private int idProd;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private int idNota;

	public NotaprodutoPK() {
	}
	public int getIdProd() {
		return this.idProd;
	}
	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}
	public int getIdNota() {
		return this.idNota;
	}
	public void setIdNota(int idNota) {
		this.idNota = idNota;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof NotaprodutoPK)) {
			return false;
		}
		NotaprodutoPK castOther = (NotaprodutoPK)other;
		return 
			(this.idProd == castOther.idProd)
			&& (this.idNota == castOther.idNota);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idProd;
		hash = hash * prime + this.idNota;
		
		return hash;
	}
}
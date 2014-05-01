package com.au.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the notaingrediente database table.
 * 
 */
@Embeddable
public class NotaingredientePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private int idIng;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private int idNota;

	public NotaingredientePK() {
	}
	public int getIdIng() {
		return this.idIng;
	}
	public void setIdIng(int idIng) {
		this.idIng = idIng;
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
		if (!(other instanceof NotaingredientePK)) {
			return false;
		}
		NotaingredientePK castOther = (NotaingredientePK)other;
		return 
			(this.idIng == castOther.idIng)
			&& (this.idNota == castOther.idNota);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idIng;
		hash = hash * prime + this.idNota;
		
		return hash;
	}
}
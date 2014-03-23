package com.au.bean;
/**
Author: BrunoRicardo
 */
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ingrediente {
	@Id
	private int idIng;
	private String descIng;
	private double valorIng;
	
	public int getIdIng() {
		return idIng;
	}
	public void setIdIng(int idIng) {
		this.idIng = idIng;
	}
	public String getDescIng() {
		return descIng;
	}
	public void setDescIng(String descIng) {
		this.descIng = descIng;
	}
	public double getValorIng() {
		return valorIng;
	}
	public void setValorIng(double valorIng) {
		this.valorIng = valorIng;
	}
	
	
}

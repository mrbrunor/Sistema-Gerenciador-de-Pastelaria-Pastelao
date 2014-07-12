package com.au.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the funcionario database table.
 * 
 */
@Entity
@Table(name="funcionario")
@NamedQuery(name="Funcionario.findAll", query="SELECT f FROM Funcionario f")
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idFunc;

	@Column(nullable=false, length=15)
	private String celFunc;

	@Column(unique=true, nullable=false, length=15)
	private String cpfFunc;

	@Column(nullable=false)
	private byte estaAtivo;

	@Column(length=15)
	private String foneFunc;

	@Column(nullable=false, length=150)
	private String mailFunc;

	@Column(nullable=false)
	private int nivelFunc;

	@Column(nullable=false, length=250)
	private String nomeFunc;

	@Column(nullable=false, length=64)
	private String passFunc;

        @Column(unique=true, nullable=false, length=50)
	private String userFunc;

	//bi-directional many-to-one association to Caixa
	@OneToMany(mappedBy="funcionario")
	private List<Caixa> caixas;

	public Funcionario() {
	}

	public int getIdFunc() {
		return this.idFunc;
	}

	public void setIdFunc(int idFunc) {
		this.idFunc = idFunc;
	}

	public String getCelFunc() {
		return this.celFunc;
	}

	public void setCelFunc(String celFunc) {
		this.celFunc = celFunc;
	}

	public String getCpfFunc() {
		return this.cpfFunc;
	}

	public void setCpfFunc(String cpfFunc) {
		this.cpfFunc = cpfFunc;
	}

	public byte getEstaAtivo() {
		return this.estaAtivo;
	}

	public void setEstaAtivo(byte estaAtivo) {
		this.estaAtivo = estaAtivo;
	}

	public String getFoneFunc() {
		return this.foneFunc;
	}

	public void setFoneFunc(String foneFunc) {
		this.foneFunc = foneFunc;
	}

	public String getMailFunc() {
		return this.mailFunc;
	}

	public void setMailFunc(String mailFunc) {
		this.mailFunc = mailFunc;
	}

	public int getNivelFunc() {
		return this.nivelFunc;
	}

	public void setNivelFunc(int nivelFunc) {
		this.nivelFunc = nivelFunc;
	}

	public String getNomeFunc() {
		return this.nomeFunc;
	}

	public void setNomeFunc(String nomeFunc) {
		this.nomeFunc = nomeFunc;
	}

	public String getPassFunc() {
		return this.passFunc;
	}

	public void setPassFunc(String passFunc) {
		this.passFunc = passFunc;
	}

	public String getUserFunc() {
		return this.userFunc;
	}

	public void setUserFunc(String userFunc) {
		this.userFunc = userFunc;
	}

	public List<Caixa> getCaixas() {
		return this.caixas;
	}

	public void setCaixas(List<Caixa> caixas) {
		this.caixas = caixas;
	}

	public Caixa addCaixa(Caixa caixa) {
		getCaixas().add(caixa);
		caixa.setFuncionario(this);

		return caixa;
	}

	public Caixa removeCaixa(Caixa caixa) {
		getCaixas().remove(caixa);
		caixa.setFuncionario(null);

		return caixa;
	}

}
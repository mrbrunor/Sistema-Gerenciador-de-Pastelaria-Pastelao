package com.au.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fornecedor database table.
 * 
 */
@Entity
@Table(name="fornecedor")
@NamedQuery(name="Fornecedor.findAll", query="SELECT f FROM Fornecedor f")
public class Fornecedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idForn;

	@Column(nullable=false, length=15)
	private String celForn;

	@Column(nullable=false, length=20)
	private String cnpjForn;

	@Column(length=15)
	private String foneForn;

	@Column(nullable=false, length=150)
	private String mailForn;

	@Column(nullable=false, length=250)
	private String nomeForn;

	//bi-directional many-to-one association to Notafiscal
	@OneToMany(mappedBy="fornecedor")
	private List<Notafiscal> notafiscals;

	//bi-directional many-to-one association to Produto
	@OneToMany(mappedBy="fornecedor")
	private List<Produto> produtos;

	public Fornecedor() {
	}

	public int getIdForn() {
		return this.idForn;
	}

	public void setIdForn(int idForn) {
		this.idForn = idForn;
	}

	public String getCelForn() {
		return this.celForn;
	}

	public void setCelForn(String celForn) {
		this.celForn = celForn;
	}

	public String getCnpjForn() {
		return this.cnpjForn;
	}

	public void setCnpjForn(String cnpjForn) {
		this.cnpjForn = cnpjForn;
	}

	public String getFoneForn() {
		return this.foneForn;
	}

	public void setFoneForn(String foneForn) {
		this.foneForn = foneForn;
	}

	public String getMailForn() {
		return this.mailForn;
	}

	public void setMailForn(String mailForn) {
		this.mailForn = mailForn;
	}

	public String getNomeForn() {
		return this.nomeForn;
	}

	public void setNomeForn(String nomeForn) {
		this.nomeForn = nomeForn;
	}

	public List<Notafiscal> getNotafiscals() {
		return this.notafiscals;
	}

	public void setNotafiscals(List<Notafiscal> notafiscals) {
		this.notafiscals = notafiscals;
	}

	public Notafiscal addNotafiscal(Notafiscal notafiscal) {
		getNotafiscals().add(notafiscal);
		notafiscal.setFornecedor(this);

		return notafiscal;
	}

	public Notafiscal removeNotafiscal(Notafiscal notafiscal) {
		getNotafiscals().remove(notafiscal);
		notafiscal.setFornecedor(null);

		return notafiscal;
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto addProduto(Produto produto) {
		getProdutos().add(produto);
		produto.setFornecedor(this);

		return produto;
	}

	public Produto removeProduto(Produto produto) {
		getProdutos().remove(produto);
		produto.setFornecedor(null);

		return produto;
	}

}
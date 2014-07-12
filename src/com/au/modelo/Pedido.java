package com.au.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the pedido database table.
 *
 */
@Entity
@Table(name = "pedido")
@NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int idPedido;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataPedido;

    @Column(nullable = false)
    private double descPedido;

    @Column(nullable = false, length = 20)
    private String estadoPedido;
    
    @Column(nullable = false, length = 50)
    private String formaConsumo;

    //bi-directional many-to-one association to FormaPagamento
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idFormaPgto", nullable = false)
    private FormaPagamento formaPagamento;

    @Column(nullable = false)
    private Time horaPedido;

    @Column(nullable = false)
    private int numPedido;

    @Column(nullable = false)
    private double subTotPedido;

    @Column(nullable = false)
    private double totPedido;
    
    @Column(nullable = false)
    private double valorRecebido;

    //bi-directional many-to-one association to Itempedido
    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER)
    private List<Itempedido> itempedidos;

    //bi-directional many-to-one association to Caixa
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCaixa", nullable = false)
    private Caixa caixa;

    public Pedido() {
        this.itempedidos = new ArrayList<>();
    }

    public int getIdPedido() {
        return this.idPedido;
    }

    public double getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Date getDataPedido() {
        return this.dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public double getDescPedido() {
        return this.descPedido;
    }

    public void setDescPedido(double descPedido) {
        this.descPedido = descPedido;
    }

    public String getEstadoPedido() {
        return this.estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Time getHoraPedido() {
        return this.horaPedido;
    }

    public void setHoraPedido(Time horaPedido) {
        this.horaPedido = horaPedido;
    }

    public String getFormaConsumo() {
        return formaConsumo;
    }

    public void setFormaConsumo(String formaConsumo) {
        this.formaConsumo = formaConsumo;
    }

    public int getNumPedido() {
        return this.numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public double getSubTotPedido() {
        return this.subTotPedido;
    }

    public void setSubTotPedido(double subTotPedido) {
        this.subTotPedido = subTotPedido;
    }

    public double getTotPedido() {
        return this.totPedido;
    }

    public void setTotPedido(double totPedido) {
        this.totPedido = totPedido;
    }

    public List<Itempedido> getItempedidos() {
        return this.itempedidos;
    }

    public void setItempedidos(List<Itempedido> itempedidos) {
        this.itempedidos = itempedidos;
    }

    public Itempedido addItempedido(Itempedido itempedido) {
        getItempedidos().add(itempedido);
        itempedido.setPedido(this);

        return itempedido;
    }

    public Itempedido removeItempedido(Itempedido itempedido) {
        getItempedidos().remove(itempedido);
        itempedido.setPedido(null);

        return itempedido;
    }

    public Caixa getCaixa() {
        return this.caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

}

package com.au.pojo;
// Generated 26/03/2014 01:12:55 by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Pedido generated by hbm2java
 */
public class Pedido  implements java.io.Serializable {


     private Integer idPedido;
     private Caixa caixa;
     private int numPedido;
     private Date dataPedido;
     private Date horaPedido;
     private double subTotPedido;
     private double descPedido;
     private double totPedido;
     private String formaPagtoPedido;
     private String estadoPedido;
     private Set itempedidos = new HashSet(0);

    public Pedido() {
    }

	
    public Pedido(Caixa caixa, int numPedido, Date dataPedido, Date horaPedido, double subTotPedido, double descPedido, double totPedido, String formaPagtoPedido, String estadoPedido) {
        this.caixa = caixa;
        this.numPedido = numPedido;
        this.dataPedido = dataPedido;
        this.horaPedido = horaPedido;
        this.subTotPedido = subTotPedido;
        this.descPedido = descPedido;
        this.totPedido = totPedido;
        this.formaPagtoPedido = formaPagtoPedido;
        this.estadoPedido = estadoPedido;
    }
    public Pedido(Caixa caixa, int numPedido, Date dataPedido, Date horaPedido, double subTotPedido, double descPedido, double totPedido, String formaPagtoPedido, String estadoPedido, Set itempedidos) {
       this.caixa = caixa;
       this.numPedido = numPedido;
       this.dataPedido = dataPedido;
       this.horaPedido = horaPedido;
       this.subTotPedido = subTotPedido;
       this.descPedido = descPedido;
       this.totPedido = totPedido;
       this.formaPagtoPedido = formaPagtoPedido;
       this.estadoPedido = estadoPedido;
       this.itempedidos = itempedidos;
    }
   
    public Integer getIdPedido() {
        return this.idPedido;
    }
    
    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }
    public Caixa getCaixa() {
        return this.caixa;
    }
    
    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }
    public int getNumPedido() {
        return this.numPedido;
    }
    
    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }
    public Date getDataPedido() {
        return this.dataPedido;
    }
    
    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }
    public Date getHoraPedido() {
        return this.horaPedido;
    }
    
    public void setHoraPedido(Date horaPedido) {
        this.horaPedido = horaPedido;
    }
    public double getSubTotPedido() {
        return this.subTotPedido;
    }
    
    public void setSubTotPedido(double subTotPedido) {
        this.subTotPedido = subTotPedido;
    }
    public double getDescPedido() {
        return this.descPedido;
    }
    
    public void setDescPedido(double descPedido) {
        this.descPedido = descPedido;
    }
    public double getTotPedido() {
        return this.totPedido;
    }
    
    public void setTotPedido(double totPedido) {
        this.totPedido = totPedido;
    }
    public String getFormaPagtoPedido() {
        return this.formaPagtoPedido;
    }
    
    public void setFormaPagtoPedido(String formaPagtoPedido) {
        this.formaPagtoPedido = formaPagtoPedido;
    }
    public String getEstadoPedido() {
        return this.estadoPedido;
    }
    
    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }
    public Set getItempedidos() {
        return this.itempedidos;
    }
    
    public void setItempedidos(Set itempedidos) {
        this.itempedidos = itempedidos;
    }




}



/*
 * Copyright (C) 2014 BrunoRicardo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.au.bean;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BrunoRicardo
 */
public class Pedido {

    private int idPedido;
    private int numPedido;
    private Date dataPedido;
    private Time horaPedido;
    private int idCaixa;
    private double subTotPedido;
    private double descPedido;
    private double totPedido;
    private double valorRecebido;
    private int idFormaPgto;
    private String estadoPedido;
    private String formaConsumo;
    
    private List<ItemPedido> itempedidos = new ArrayList<>();

    public double getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public int getIdFormaPgto() {
        return idFormaPgto;
    }

    public void setIdFormaPgto(int idFormaPgto) {
        this.idFormaPgto = idFormaPgto;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Time getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(Time horaPedido) {
        this.horaPedido = horaPedido;
    }

    public int getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(int idCaixa) {
        this.idCaixa = idCaixa;
    }

    public double getSubTotPedido() {
        return subTotPedido;
    }

    public void setSubTotPedido(double subTotPedido) {
        this.subTotPedido = subTotPedido;
    }

    public double getDescPedido() {
        return descPedido;
    }

    public void setDescPedido(double descPedido) {
        this.descPedido = descPedido;
    }

    public double getTotPedido() {
        return totPedido;
    }

    public void setTotPedido(double totPedido) {
        this.totPedido = totPedido;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public String getFormaConsumo() {
        return formaConsumo;
    }

    public void setFormaConsumo(String formaConsumo) {
        this.formaConsumo = formaConsumo;
    }

    public List<ItemPedido> getItempedidos() {
        return itempedidos;
    }

    public void setItempedidos(List<ItemPedido> itempedidos) {
        this.itempedidos = itempedidos;
    }

}

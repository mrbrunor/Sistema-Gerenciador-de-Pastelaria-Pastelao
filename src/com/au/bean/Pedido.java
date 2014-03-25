/*
 * The MIT License
 *
 * Copyright 2014 BrunoRicardo.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.au.bean;

import java.sql.Date;
import java.sql.Time;

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
    private String formaPagtoPedido;
    private String estadoPedido;

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

    public String getFormaPagtoPedido() {
        return formaPagtoPedido;
    }

    public void setFormaPagtoPedido(String formaPagtoPedido) {
        this.formaPagtoPedido = formaPagtoPedido;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }
    
    
}

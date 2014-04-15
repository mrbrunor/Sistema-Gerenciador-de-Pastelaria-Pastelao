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

/**
 *
 * @author BrunoRicardo
 */
public class Despesa {
    private int idDesp;
    private Date dataDesp;
    private String descDesp;
    private double valorDesp;
    private int idCaixa;
    private int retirada;

    public int getIdDesp() {
        return idDesp;
    }

    public void setIdDesp(int idDesp) {
        this.idDesp = idDesp;
    }

    public Date getDataDesp() {
        return dataDesp;
    }

    public void setDataDesp(Date dataDesp) {
        this.dataDesp = dataDesp;
    }

    public String getDescDesp() {
        return descDesp;
    }

    public void setDescDesp(String descDesp) {
        this.descDesp = descDesp;
    }

    public double getValorDesp() {
        return valorDesp;
    }

    public void setValorDesp(double valorDesp) {
        this.valorDesp = valorDesp;
    }

    public int getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(int idCaixa) {
        this.idCaixa = idCaixa;
    }

    public int getRetirada() {
        return retirada;
    }

    public void setRetirada(int retirada) {
        this.retirada = retirada;
    }
    
    
}

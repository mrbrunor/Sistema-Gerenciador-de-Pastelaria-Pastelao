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
public class Caixa {
    private int idCaixa;
    private int idFunc;
    private double fundoCaixa;
    private Date dataCaixa;
    private Time aberturaCaixa;
    private Time fechamentoCaixa;
    private int estaAberto;
    private double totalCaixa;

    public int getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(int idCaixa) {
        this.idCaixa = idCaixa;
    }

    public int getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    public double getFundoCaixa() {
        return fundoCaixa;
    }

    public void setFundoCaixa(double fundoCaixa) {
        this.fundoCaixa = fundoCaixa;
    }

    public Date getDataCaixa() {
        return dataCaixa;
    }

    public void setDataCaixa(Date dataCaixa) {
        this.dataCaixa = dataCaixa;
    }

    public Time getAberturaCaixa() {
        return aberturaCaixa;
    }

    public void setAberturaCaixa(Time aberturaCaixa) {
        this.aberturaCaixa = aberturaCaixa;
    }

    public Time getFechamentoCaixa() {
        return fechamentoCaixa;
    }

    public void setFechamentoCaixa(Time fechamentoCaixa) {
        this.fechamentoCaixa = fechamentoCaixa;
    }

    public int getEstaAberto() {
        return estaAberto;
    }

    public void setEstaAberto(int estaAberto) {
        this.estaAberto = estaAberto;
    }

    public double getTotalCaixa() {
        return totalCaixa;
    }

    public void setTotalCaixa(double totalCaixa) {
        this.totalCaixa = totalCaixa;
    }
    
    
    
}

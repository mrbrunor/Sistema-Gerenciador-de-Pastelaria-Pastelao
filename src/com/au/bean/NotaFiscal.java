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
public class NotaFiscal {
    private int idNota;
    private int idForn;
    private Date dataNota;
    private Time horaNota;
    private int idDesp;
    private double subTotNota;
    private double descNota;
    private double totNota;

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public int getIdForn() {
        return idForn;
    }

    public void setIdForn(int idForn) {
        this.idForn = idForn;
    }

    public Date getDataNota() {
        return dataNota;
    }

    public void setDataNota(Date dataNota) {
        this.dataNota = dataNota;
    }

    public Time getHoraNota() {
        return horaNota;
    }

    public void setHoraNota(Time horaNota) {
        this.horaNota = horaNota;
    }

    public int getIdDesp() {
        return idDesp;
    }

    public void setIdDesp(int idDesp) {
        this.idDesp = idDesp;
    }

    public double getSubTotNota() {
        return subTotNota;
    }

    public void setSubTotNota(double subTotNota) {
        this.subTotNota = subTotNota;
    }

    public double getDescNota() {
        return descNota;
    }

    public void setDescNota(double descNota) {
        this.descNota = descNota;
    }

    public double getTotNota() {
        return totNota;
    }

    public void setTotNota(double totNota) {
        this.totNota = totNota;
    }
    
    
}

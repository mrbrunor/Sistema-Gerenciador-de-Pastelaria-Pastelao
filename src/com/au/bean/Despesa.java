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

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
public class Caixa {

    private int idCaixa;
    private int idFunc;
    private double fundoCaixa;
    private Date dataAberturaCaixa;
    private Time aberturaCaixa;
    private Time fechamentoCaixa;
    private Date dataFechamentoCaixa;
    private int estaAberto;
    private double totalCaixa;
    
    private Funcionario funcionario = new Funcionario();
    private List<Despesa> despesas = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();

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

    public Date getDataAberturaCaixa() {
        return dataAberturaCaixa;
    }

    public void setDataAberturaCaixa(Date dataAberturaCaixa) {
        this.dataAberturaCaixa = dataAberturaCaixa;
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

    public Date getDataFechamentoCaixa() {
        return dataFechamentoCaixa;
    }

    public void setDataFechamentoCaixa(Date dataFechamentoCaixa) {
        this.dataFechamentoCaixa = dataFechamentoCaixa;
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

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
}

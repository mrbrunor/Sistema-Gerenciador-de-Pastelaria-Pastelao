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
public class Funcionario {
    private int idFunc;
    private String nomeFunc;
    private Date nascFunc;
    private String sexoFunc;
    private String rgFunc;
    private String cpfFunc;
    private String mailFunc;
    private String foneFunc;
    private String celFunc;
    private Date dtAdmFunc;
    private double salFunc;
    private String userFunc;
    private String passFunc;
    private int nivelFunc;
    private int estaAtivo;

    public int getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public Date getNascFunc() {
        return nascFunc;
    }

    public void setNascFunc(Date nascFunc) {
        this.nascFunc = nascFunc;
    }

    public String getSexoFunc() {
        return sexoFunc;
    }

    public void setSexoFunc(String sexoFunc) {
        this.sexoFunc = sexoFunc;
    }

    public String getRgFunc() {
        return rgFunc;
    }

    public void setRgFunc(String rgFunc) {
        this.rgFunc = rgFunc;
    }

    public String getCpfFunc() {
        return cpfFunc;
    }

    public void setCpfFunc(String cpfFunc) {
        this.cpfFunc = cpfFunc;
    }

    public String getMailFunc() {
        return mailFunc;
    }

    public void setMailFunc(String mailFunc) {
        this.mailFunc = mailFunc;
    }

    public String getFoneFunc() {
        return foneFunc;
    }

    public void setFoneFunc(String foneFunc) {
        this.foneFunc = foneFunc;
    }

    public String getCelFunc() {
        return celFunc;
    }

    public void setCelFunc(String celFunc) {
        this.celFunc = celFunc;
    }

    public Date getDtAdmFunc() {
        return dtAdmFunc;
    }

    public void setDtAdmFunc(Date dtAdmFunc) {
        this.dtAdmFunc = dtAdmFunc;
    }

    public double getSalFunc() {
        return salFunc;
    }

    public void setSalFunc(double salFunc) {
        this.salFunc = salFunc;
    }

    public String getUserFunc() {
        return userFunc;
    }

    public void setUserFunc(String userFunc) {
        this.userFunc = userFunc;
    }

    public String getPassFunc() {
        return passFunc;
    }

    public void setPassFunc(String passFunc) {
        this.passFunc = passFunc;
    }

    public int getNivelFunc() {
        return nivelFunc;
    }

    public void setNivelFunc(int nivelFunc) {
        this.nivelFunc = nivelFunc;
    }

    public int isEstaAtivo() {
        return estaAtivo;
    }

    public void setEstaAtivo(int estaAtivo) {
        this.estaAtivo = estaAtivo;
    }
    
    
}

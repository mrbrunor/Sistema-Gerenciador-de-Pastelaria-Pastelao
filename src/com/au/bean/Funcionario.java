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

/**
 *
 * @author BrunoRicardo
 */
public class Funcionario {

    private int idFunc;
    private String nomeFunc;
    private String cpfFunc;
    private String mailFunc;
    private String foneFunc;
    private String celFunc;
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

    public int getEstaAtivo() {
        return estaAtivo;
    }

    public void setEstaAtivo(int estaAtivo) {
        this.estaAtivo = estaAtivo;
    }
}

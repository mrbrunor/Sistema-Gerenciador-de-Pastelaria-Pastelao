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
public class Aplicativo {

    private int idAplicativo;
    private String nomeAplicativo;    
    private int estaAtivo;

    public int getIdAplicativo() {
        return idAplicativo;
    }

    public void setIdAplicativo(int idAplicativo) {
        this.idAplicativo = idAplicativo;
    }

    public String getNomeAplicativo() {
        return nomeAplicativo;
    }

    public void setNomeAplicativo(String nomeAplicativo) {
        this.nomeAplicativo = nomeAplicativo;
    }   

    public int getEstaAtivo() {
        return estaAtivo;
    }

    public void setEstaAtivo(int estaAtivo) {
        this.estaAtivo = estaAtivo;
    }
}

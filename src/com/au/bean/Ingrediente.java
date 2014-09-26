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
public class Ingrediente {

    private int idIng;
    private String descIng;
    private double valorIng;

    public int getIdIng() {
        return idIng;
    }

    public void setIdIng(int idIng) {
        this.idIng = idIng;
    }

    public String getDescIng() {
        return descIng;
    }

    public void setDescIng(String descIng) {
        this.descIng = descIng;
    }

    public double getValorIng() {
        return valorIng;
    }

    public void setValorIng(double valorIng) {
        this.valorIng = valorIng;
    }

}

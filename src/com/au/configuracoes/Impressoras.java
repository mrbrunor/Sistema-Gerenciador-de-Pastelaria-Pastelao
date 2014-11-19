/*
 * Copyright (C) 2014 tiago_000
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
package com.au.configuracoes;

/**
 *
 * @author tiago_000
 */
public class Impressoras {
    private String local;
    private int modeloImpressora;
    private String porta;

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getModeloImpressora() {
        return modeloImpressora;
    }

    public void setModeloImpressora(int modeloImpressora) {
        this.modeloImpressora = modeloImpressora;
    }

    public String getPorta() {
        return porta;
    }

    public void setPorta(String porta) {
        this.porta = porta;
    }
}

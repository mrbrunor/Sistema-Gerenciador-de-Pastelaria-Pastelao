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
package com.au.gui.tmodel;

import com.au.bean.Aplicativo;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author BrunoRicardo
 */
public class AplicativoTableModel extends AbstractTableModel {

    private List<Aplicativo> aplicativos;
    private final List<String> colunas;

    public AplicativoTableModel(List<Aplicativo> aplicativos) {
        this.aplicativos = aplicativos;
        colunas = Arrays.asList("Id", "Descrição", "Ativo");
    }

    @Override
    public String getColumnName(int column) {
        return colunas.get(column);
    }

    @Override
    public int getRowCount() {
        if (aplicativos != null) {
            return aplicativos.size();
        } else {
            return -1;
        }
    }

    @Override
    public int getColumnCount() {
        return colunas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aplicativo aplicativo = aplicativos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return aplicativo.getIdAplicativo();
            case 1:
                return aplicativo.getNomeAplicativo();
            case 2:                
                if (aplicativo.getEstaAtivo() == 1) {
                    return "Sim";
                } else {
                    return "Não";
                }
        }
        return null;
    }

    public List<Aplicativo> getAplicativos() {
        return aplicativos;
    }

    public void setAplicativos(List<Aplicativo> aplicativos) {
        this.aplicativos = aplicativos;
    }

}

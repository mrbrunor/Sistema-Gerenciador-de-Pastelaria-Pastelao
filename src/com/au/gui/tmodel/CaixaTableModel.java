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

import com.au.bean.Caixa;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tiago
 */
public class CaixaTableModel extends AbstractTableModel {

    private List<Caixa> caixas;
    private final List<String> colunas;

    public CaixaTableModel(List<Caixa> caixas) {
        this.caixas = caixas;
        colunas = Arrays.asList("ID", "Abertura", "Fechamento", "Total Caixa");
    }

    @Override
    public String getColumnName(int column) {
        return colunas.get(column);
    }

    @Override
    public int getRowCount() {
        if(caixas != null){
            return caixas.size();
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
        Caixa caixa = caixas.get(rowIndex);
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        switch (columnIndex) {
            case 0:
                return caixa.getIdCaixa();
            case 1:                
                return formatador.format(caixa.getDataAberturaCaixa().getTime());
            case 2:
                if(caixa.getEstaAberto() == 1) {
                    return "Caixa Aberto";
                } else {
                    return formatador.format(caixa.getDataFechamentoCaixa().getTime());
                }
            case 3:
                return String.format("%.02f", caixa.getTotalCaixa());
        }
        return null;
    }

    public List<Caixa> getCaixas() {
        return caixas;
    }

    public void setCaixas(List<Caixa> caixas) {
        this.caixas = caixas;
    }
}

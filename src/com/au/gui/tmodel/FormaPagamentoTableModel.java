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

import com.au.bean.FormaPagamento;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author BrunoRicardo
 */
public class FormaPagamentoTableModel extends AbstractTableModel {

    private List<FormaPagamento> formaPagamentos;
    private final List<String> colunas;

    public FormaPagamentoTableModel(List<FormaPagamento> formaPagamentos) {
        this.formaPagamentos = formaPagamentos;
        colunas = Arrays.asList("Id", "Descrição", "Tipo", "Ativo");
    }

    @Override
    public String getColumnName(int column) {
        return colunas.get(column);
    }

    @Override
    public int getRowCount() {
        if (formaPagamentos != null) {
            return formaPagamentos.size();
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
        FormaPagamento formaPagamento = formaPagamentos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return formaPagamento.getIdFormaPgto();
            case 1:
                return formaPagamento.getNomeFormaPgto();
            case 2:
                return formaPagamento.getTipoFormaPgto();
            case 3:
                if (formaPagamento.getEstaAtivo() == 1) {
                    return "Sim";
                } else {
                    return "Não";
                }
        }
        return null;
    }

    public List<FormaPagamento> getFormasPagamento() {
        return formaPagamentos;
    }

    public void setFormasPagamento(List<FormaPagamento> formaPagamentos) {
        this.formaPagamentos = formaPagamentos;
    }

}

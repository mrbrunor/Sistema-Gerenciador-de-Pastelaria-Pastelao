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

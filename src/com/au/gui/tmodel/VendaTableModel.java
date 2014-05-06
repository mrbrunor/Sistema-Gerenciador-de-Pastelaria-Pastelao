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

import com.au.modelo.Itempedido;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author BrunoRicardo
 */
public class VendaTableModel extends AbstractTableModel{
    
    private List<Itempedido> itemspedido;
    private List<String> colunas;
    
    public VendaTableModel(List<Itempedido> itemspedido){
        this.itemspedido = itemspedido;
        colunas = Arrays.asList("Id", "Descrição", "Valor Unitario", "Quantidade", "Valor Total");
    }

    @Override
    public String getColumnName(int column) {
        return colunas.get(column);
    }       

    @Override
    public int getRowCount() {
        return itemspedido.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Itempedido itempedido = itemspedido.get(rowIndex);
     
        switch(columnIndex){
            case 0: return itempedido.getProduto().getIdProd();
            case 1: return itempedido.getProduto().getDescProd();
            case 2: return itempedido.getProduto().getValorProd();
            case 3: return itempedido.getQtdProd();
            case 4: return itempedido.getTotProd();
        }
        return null;
    }

    public List<Itempedido> getItemspedido() {
        return itemspedido;
    }

    public void setProdutos(List<Itempedido> itemspedido) {
        this.itemspedido = itemspedido;
    }    
    
}

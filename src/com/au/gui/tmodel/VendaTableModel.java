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

import com.au.bean.ItemPedido;
import com.au.bean.Produto;
import com.au.dao.ProdutoDao;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author BrunoRicardo
 */
public class VendaTableModel extends AbstractTableModel {

    private List<ItemPedido> itemspedido;
    private List<String> colunas;

    public VendaTableModel(List<ItemPedido> itemspedido) {
        this.itemspedido = itemspedido;
        colunas = Arrays.asList("Cod", "Descrição", "Vlr Unit", "Qtd", "Vlr Total");
    }

    @Override
    public String getColumnName(int column) {
        return colunas.get(column);
    }

    @Override
    public int getRowCount() {
        if(itemspedido != null){
            return itemspedido.size();
        } else {
            return 0;
        }        
    }

    @Override
    public int getColumnCount() {
        return colunas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ItemPedido itempedido = itemspedido.get(rowIndex);
        Produto produto;
        ProdutoDao pDao = new ProdutoDao();
        switch (columnIndex) {
            case 0:
                pDao.abreConnection();
                produto = pDao.buscaId(itempedido.getIdProd());
                pDao.fechaConnection();
                return produto.getNumProd();
            case 1:
                pDao.abreConnection();
                produto = pDao.buscaId(itempedido.getIdProd());
                pDao.fechaConnection();
                return produto.getDescProd();
            case 2:
                pDao.abreConnection();
                produto = pDao.buscaId(itempedido.getIdProd());
                pDao.fechaConnection();
                return produto.getValorProd();
            case 3:
                return itempedido.getQtdProd();
            case 4:
                return String.format("%.2f", itempedido.getTotProd());
        }
        return null;
    }

    public List<ItemPedido> getItemspedido() {
        return itemspedido;
    }

    public void setProdutos(List<ItemPedido> itemspedido) {
        this.itemspedido = itemspedido;
    }

}

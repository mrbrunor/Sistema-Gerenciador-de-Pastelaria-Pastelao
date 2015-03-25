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
    private final List<String> colunas;

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
            return -1;
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
                if(produto.getNumProd() == 0){
                    return itempedido.getNomePastel();
                } else {
                    return produto.getDescProd();
                }                
            case 2:
                pDao.abreConnection();
                produto = pDao.buscaId(itempedido.getIdProd());
                pDao.fechaConnection();
                if(produto.getNumProd() == 0){
                    return itempedido.getTotProd() / itempedido.getQtdProd();
                } else {
                    return produto.getValorProd();
                }
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

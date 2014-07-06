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
package com.au.gui.listener;

import com.au.dao.DAO;
import com.au.gui.TelaCancelamento;
import com.au.modelo.Pedido;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

/**
 *
 * @author BrunoRicardo
 */
public class CancelamentoActionListener implements ActionListener {

    private final TelaCancelamento frm;
    private Border vermelha = new MatteBorder(1, 1, 1, 1, Color.red);
    private Border normal;

    public CancelamentoActionListener(TelaCancelamento frm) {
        this.frm = frm;
        normal = frm.getCampoNumeroPedido().getBorder();
        adicionaListener();
    }

    public void adicionaListener() {
        frm.getBotaoSair().addActionListener(this);
        frm.getBotaoCancelarPedido().addActionListener(this);
        frm.getCampoNumeroPedido().addActionListener(this);
    }

    public boolean valida() {
        boolean valida = true;

        if (!"".equals(frm.getCampoNumeroPedido().getText())) {
            frm.getCampoNumeroPedido().setBorder(normal);
            valida = validaPedido();
        } else {
            frm.getCampoNumeroPedido().setBorder(vermelha);
            valida = false;
        }
        return valida;
    }

    public boolean validaPedido() {
        for (int i = 0; i < frm.getCaixa().getPedidos().size(); i++) {
            if (frm.getCaixa().getPedidos().get(i).getNumPedido() == Integer.valueOf(frm.getCampoNumeroPedido().getText())) {
                if (frm.getCaixa().getPedidos().get(i).getEstadoPedido().equals("Cancelado")) {
                    JOptionPane.showMessageDialog(frm, "Pedido informado já esta Cancelado!", "Cancelamento de Pedido", JOptionPane.INFORMATION_MESSAGE);
                    return false;
                }
                frm.getCaixa().getPedidos().get(i).setEstadoPedido("Cancelado");
                new DAO<>(Pedido.class).atualiza(frm.getCaixa().getPedidos().get(i));
                JOptionPane.showMessageDialog(frm, "Pedido cancelado com sucesso!", "Cancelamento de Pedido", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }            
        }
        JOptionPane.showMessageDialog(frm, "Pedido não foi encontrado!", "Cancelamento de Pedido", JOptionPane.INFORMATION_MESSAGE);
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Cancelar Pedido":
                if (valida()) {
                    frm.dispose();
                }                
                break;

            case "Sair":
                frm.dispose();
                break;
        }
    }
}

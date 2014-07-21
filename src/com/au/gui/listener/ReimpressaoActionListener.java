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

import com.au.gui.TelaReimpressao;
import com.au.util.Imprime;
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
public class ReimpressaoActionListener implements ActionListener {

    private final TelaReimpressao frm;
    private Border vermelha = new MatteBorder(1, 1, 1, 1, Color.red);
    private Border normal;

    public ReimpressaoActionListener(TelaReimpressao frm) {
        this.frm = frm;
        normal = frm.getCampoNumeroPedido().getBorder();
        adicionaListener();
    }

    public void adicionaListener() {
        frm.getBotaoSair().addActionListener(this);
        frm.getBotaoConfirmarReimpressao().addActionListener(this);
        frm.getCampoNumeroPedido().addActionListener(this);
    }

    public boolean valida() {
        boolean valida = true;

        if (!"".equals(frm.getCampoNumeroPedido().getText())) {
            frm.getCampoNumeroPedido().setBorder(normal);
            valida = true;
        } else {
            frm.getCampoNumeroPedido().setBorder(vermelha);
            valida = false;
        }
        return valida;
    }
    
    public void imprimeCupom () {
        int numeroPedido = 0;
        numeroPedido = Integer.getInteger(frm.getCampoNumeroPedido().getText());
        System.out.println(numeroPedido);
        new Imprime().geraComandaVenda(numeroPedido);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Confirmar Reimpressão de Cupom":
                if (valida()) {
                    try {
                        imprimeCupom();
                    } catch (NullPointerException e) {
                        JOptionPane.showMessageDialog(frm, "Erro ao Reimprimir o Cupom. O número do pedido não foi encontrado no caixa atual.", "Reimpressão de Cupom", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
            case "Cancelar Reimpressão":
                frm.dispose();
                break;
        }
    }
}

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

import com.au.gui.TelaFechamentoCaixa;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

/**
 *
 * @author BrunoRicardo
 */
public class FechamentoActionListener implements ActionListener {

    private final TelaFechamentoCaixa frm;
    private Border vermelha = new MatteBorder(1, 1, 1, 1, Color.red);
    private Border normal;

    public FechamentoActionListener(TelaFechamentoCaixa frm) {
        this.frm = frm;
        normal = frm.getCampoCedulaCemReais().getBorder();
        adicionaListener();
    }

    public void adicionaListener() {
        frm.getBotaoCancelarFechamentoDeCaixa().addActionListener(this);
        frm.getBotaoConfirmarFechamentoDeCaixa().addActionListener(this);
        frm.getCampoCedulaCemReais().addActionListener(this);
        frm.getCampoCedulaCincoReais().addActionListener(this);
        frm.getCampoCedulaCinquentaReais().addActionListener(this);
        frm.getCampoCedulaDezReais().addActionListener(this);
        frm.getCampoCedulaDoisReais().addActionListener(this);
        frm.getCampoCedulaVinteReais().addActionListener(this);
        frm.getCampoMoedaCincoCentavos().addActionListener(this);
        frm.getCampoMoedaCinquentaCentavos().addActionListener(this);
        frm.getCampoMoedaDezCentavos().addActionListener(this);
        frm.getCampoMoedaUmReal().addActionListener(this);
        frm.getCampoMoedaVinteCincoCentavos().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Cadastrar Fornecedor":
                break;
        }
    }
}

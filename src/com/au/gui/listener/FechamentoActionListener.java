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
import com.au.modelo.Caixa;
import com.au.util.DAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author BrunoRicardo
 */
public class FechamentoActionListener implements ActionListener, KeyListener {

    private final TelaFechamentoCaixa frm;
    private Caixa caixa;
    private double dinheiroCaixa;

    public FechamentoActionListener(TelaFechamentoCaixa frm) {
        this.frm = frm;
        caixa = new DAO<>(Caixa.class).buscaPorId(frm.getIdCaixa());
        inicializaCampos();
        adicionaListener();
    }

    public void inicializaCampos() {
        frm.getTextoValorFundoDeCaixa().setText("R$: " + caixa.getFundoCaixa());
        calculaReducoes();
        calculaDinheiro();
    }

    public void calculaDinheiro() {
        System.out.println("Entrou Calcula Dinheiro");
        if (caixa.getPedidos() != null && !caixa.getPedidos().isEmpty()) {
            System.out.println("Entrou IF Not Null");
            double totalDinheiro = 0;

            for (int i = 0; i < caixa.getPedidos().size(); i++) {
                if ("Dinheiro".equals(caixa.getPedidos().get(i).getFormaPagamento().getTipoFormaPgto())) {
                    totalDinheiro = totalDinheiro + caixa.getPedidos().get(i).getTotPedido();
                }
            }
            frm.getTextoValorDinheiro().setText("R$: " + totalDinheiro);
        } else {
            frm.getTextoValorDinheiro().setText("R$: 0.00");
        }
    }

    public void calculaCC() {
        if (!caixa.getDespesas().isEmpty()) {
            double totalDesp = 0;
            for (int i = 0; i < caixa.getDespesas().size(); i++) {
                totalDesp = totalDesp + caixa.getDespesas().get(i).getValorDesp();
            }
            frm.getTextoValorDespesas().setText("R$: " + totalDesp);
        } else {
            frm.getTextoValorDespesas().setText("R$: 0.00");
        }
    }

    public void calculaCD() {
        if (!caixa.getDespesas().isEmpty()) {
            double totalDesp = 0;
            for (int i = 0; i < caixa.getDespesas().size(); i++) {
                totalDesp = totalDesp + caixa.getDespesas().get(i).getValorDesp();
            }
            frm.getTextoValorDespesas().setText("R$: " + totalDesp);
        } else {
            frm.getTextoValorDespesas().setText("R$: 0.00");
        }
    }

    public void calculaVR() {
        if (!caixa.getDespesas().isEmpty()) {
            double totalDesp = 0;
            for (int i = 0; i < caixa.getDespesas().size(); i++) {
                totalDesp = totalDesp + caixa.getDespesas().get(i).getValorDesp();
            }
            frm.getTextoValorDespesas().setText("R$: " + totalDesp);
        } else {
            frm.getTextoValorDespesas().setText("R$: 0.00");
        }
    }

    public void calculaReducoes() {
        double totalDesp = 0;
        if (caixa.getDespesas() != null && !caixa.getDespesas().isEmpty()) {
            for (int i = 0; i < caixa.getDespesas().size(); i++) {
                totalDesp = totalDesp + caixa.getDespesas().get(i).getValorDesp();
            }
            frm.getTextoValorDespesas().setText("R$: " + totalDesp);
        } else {
            frm.getTextoValorDespesas().setText("R$: 0.00");
        }
        frm.getTextoValorTotalDeReducoes().setText("R$: " + caixa.getFundoCaixa() + totalDesp);
        frm.getTextoValorTotalFaturado().setText("TOTAL FATURADO: R$ " + (caixa.getTotalCaixa() - (caixa.getFundoCaixa() + totalDesp)));
    }

    public void adicionaListener() {
        frm.getBotaoCancelarFechamentoDeCaixa().addActionListener(this);
        frm.getBotaoConfirmarFechamentoDeCaixa().addActionListener(this);
        frm.getCampoCedulaCemReais().addKeyListener(this);
        frm.getCampoCedulaCincoReais().addKeyListener(this);
        frm.getCampoCedulaCinquentaReais().addKeyListener(this);
        frm.getCampoCedulaDezReais().addKeyListener(this);
        frm.getCampoCedulaDoisReais().addKeyListener(this);
        frm.getCampoCedulaVinteReais().addKeyListener(this);
        frm.getCampoMoedaCincoCentavos().addKeyListener(this);
        frm.getCampoMoedaCinquentaCentavos().addKeyListener(this);
        frm.getCampoMoedaDezCentavos().addKeyListener(this);
        frm.getCampoMoedaUmReal().addKeyListener(this);
        frm.getCampoMoedaVinteCincoCentavos().addKeyListener(this);
    }

    public void calculaDinheiroEmCaixa() {
        dinheiroCaixa = 0;
        
        if (!"".equals(frm.getCampoMoedaCincoCentavos().getText())) {
            dinheiroCaixa += Integer.valueOf((frm.getCampoMoedaCincoCentavos().getText()))*0.05;
        }
        if (!"".equals(frm.getCampoMoedaCinquentaCentavos().getText())) {
            dinheiroCaixa += Double.valueOf((frm.getCampoMoedaCinquentaCentavos().getText())) *0.5;
        }
        if (!"".equals(frm.getCampoMoedaDezCentavos().getText())) {
            dinheiroCaixa += Double.valueOf((frm.getCampoMoedaDezCentavos().getText()))*0.1;
        }
        if (!"".equals(frm.getCampoMoedaUmReal().getText())) {
            dinheiroCaixa += Double.valueOf((frm.getCampoMoedaUmReal().getText()));
        }
        if (!"".equals(frm.getCampoMoedaVinteCincoCentavos().getText())) {
            dinheiroCaixa += Double.valueOf((frm.getCampoMoedaVinteCincoCentavos().getText()))*.25;
        }
        if (!"".equals(frm.getCampoCedulaCemReais().getText())) {
            dinheiroCaixa += Double.valueOf((frm.getCampoCedulaCemReais().getText()))*100;
        }
        if (!"".equals(frm.getCampoCedulaCincoReais().getText())) {
            dinheiroCaixa += Double.valueOf((frm.getCampoCedulaCincoReais().getText()))*5;
        }
        if (!"".equals(frm.getCampoCedulaCinquentaReais().getText())) {
            dinheiroCaixa += Double.valueOf((frm.getCampoCedulaCinquentaReais().getText()))*50;
        }
        if (!"".equals(frm.getCampoCedulaDezReais().getText())) {
            dinheiroCaixa += Double.valueOf((frm.getCampoCedulaDezReais().getText()))*10;
        }
        if (!"".equals(frm.getCampoCedulaDoisReais().getText())) {
            dinheiroCaixa += Double.valueOf((frm.getCampoCedulaDoisReais().getText()))*2;
        }
        if (!"".equals(frm.getCampoCedulaVinteReais().getText())) {
            dinheiroCaixa += Double.valueOf((frm.getCampoCedulaVinteReais().getText()))*20;
        }
        
        frm.getTextoValorTotalEmCaixa().setText(String.format("R$: %.2f", dinheiroCaixa));
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Cadastrar Fornecedor":
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        calculaDinheiroEmCaixa();
    }
}

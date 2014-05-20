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
import java.sql.Time;
import java.util.Date;

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
        frm.getTextoValorFundoDeCaixa().setText(String.format("R$: %.2f", caixa.getFundoCaixa()));
        frm.getTextoValorTotalFaturado().setText(String.format("TOTAL FATURADO: R$ %.2f",(caixa.getTotalCaixa())));
        calculaReducoes();
        calculaDinheiro();
        calculaCC();
        calculaCD();
        calculaVR();
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
            frm.getTextoValorDinheiro().setText(String.format("R$: %.2f", totalDinheiro));
        } else {
            frm.getTextoValorDinheiro().setText("R$: 0,00");
        }
    }

    public void calculaCC() {
       System.out.println("Entrou Calcula CC");
        if (caixa.getPedidos() != null && !caixa.getPedidos().isEmpty()) {
            System.out.println("Entrou IF Not Null");
            double totalCredito = 0;

            for (int i = 0; i < caixa.getPedidos().size(); i++) {
                if ("Credito".equals(caixa.getPedidos().get(i).getFormaPagamento().getTipoFormaPgto())) {
                    totalCredito = totalCredito + caixa.getPedidos().get(i).getTotPedido();
                }
            }
            frm.getTextoValorCartaoDeCredito().setText(String.format("R$: %.2f", totalCredito));
        } else {
            frm.getTextoValorCartaoDeCredito().setText("R$: 0,00");
        }
    }

    public void calculaCD() {
       System.out.println("Entrou Calcula Debito");
        if (caixa.getPedidos() != null && !caixa.getPedidos().isEmpty()) {
            System.out.println("Entrou IF Not Null");
            double totalDebito = 0;

            for (int i = 0; i < caixa.getPedidos().size(); i++) {
                if ("Debito".equals(caixa.getPedidos().get(i).getFormaPagamento().getTipoFormaPgto())) {
                    totalDebito = totalDebito + caixa.getPedidos().get(i).getTotPedido();
                }
            }
            frm.getTextoValorCartaoDeDebito().setText(String.format("R$: %.2f", totalDebito));
        } else {
            frm.getTextoValorCartaoDeDebito().setText("R$: 0,00");
        }
    }

    public void calculaVR() {
       System.out.println("Entrou Calcula Vale");
        if (caixa.getPedidos() != null && !caixa.getPedidos().isEmpty()) {
            System.out.println("Entrou IF Not Null");
            double totalVale = 0;

            for (int i = 0; i < caixa.getPedidos().size(); i++) {
                if ("Vale".equals(caixa.getPedidos().get(i).getFormaPagamento().getTipoFormaPgto())) {
                    totalVale = totalVale + caixa.getPedidos().get(i).getTotPedido();
                }
            }
            frm.getTextoValorValeRefeicao().setText(String.format("R$: %.2f", totalVale));
        } else {
            frm.getTextoValorValeRefeicao().setText("R$: 0,00");
        }
    }

    public void calculaReducoes() {
        double totalDesp = 0;
        if (caixa.getDespesas() != null && !caixa.getDespesas().isEmpty()) {
            for (int i = 0; i < caixa.getDespesas().size(); i++) {
                totalDesp = totalDesp + caixa.getDespesas().get(i).getValorDesp();
            }
            frm.getTextoValorDespesas().setText(String.format("R$: %.2f", totalDesp));
        } else {
            frm.getTextoValorDespesas().setText("R$: 0,00");
        }
        frm.getTextoValorTotalDeReducoes().setText(String.format("R$: %.2f",(caixa.getFundoCaixa() + totalDesp)));
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
    
    public void fecharCaixa(){
        
        Date data = new Date();
        caixa.setDataFechamentoCaixa(data);
        caixa.setFechamentoCaixa(new Time(data.getTime()));
        caixa.setEstaAberto((byte)0);
        new DAO<>(Caixa.class).atualiza(caixa);
        TelaFechamentoCaixa.setFechou(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Cancelar Fechamento de Caixa":
                this.frm.dispose();
                break;
            case "Confirmar Fechamento de Caixa":
                //fecharCaixa();
                TelaFechamentoCaixa.setFechou(true);
                this.frm.dispose();
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

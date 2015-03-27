/*
 * Copyright (C) 2015 Tiago
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
package com.au.util;

import com.au.gui.TelaConfirmacaoPagamento;
import java.awt.Color;

/**
 *
 * @author Tiago
 */
public final class MonitorImpressora {

    private BematechNFiscal cupom = null;
    private int iRetorno;
    private final Color vermelho;
    private final Color amarelo;
    private final Color verde;
    private final Color cinza;
    private final TelaConfirmacaoPagamento tela;
    private boolean impressoraConectada;

    //static {
    //    System.loadLibrary("mp2032");
    //}
    public MonitorImpressora(TelaConfirmacaoPagamento frm) {
        try {
            cupom = BematechNFiscal.Instance;

        } catch (UnsatisfiedLinkError e) {
            System.out.println(e);
        }
        vermelho = new Color(255, 0, 0);
        amarelo = new Color(255, 201, 14);
        verde = new Color(0, 128, 0);
        cinza = new Color(128, 128, 128);
        tela = frm;
        impressoraConectada = false;
        verificar();
    }

    public void verificar() {

        impressoraConectada = verificaImpressora(1);
        if (!impressoraConectada) {
            tela.getTextoValorImpressoraCozinha().setText("DESCONECTADA");
            tela.getTextoValorImpressoraCozinha().setForeground(cinza);
        } else {
            iRetorno = cupom.Le_Status();
            switch (iRetorno) {
                case 0:
                    //Erro de Comunicação
                    tela.getTextoValorImpressoraCozinha().setText("DESCONECTADA");
                    tela.getTextoValorImpressoraCozinha().setForeground(cinza);
                    break;
                case 5:
                    //Impressora com pouco papel
                    tela.getTextoValorImpressoraCozinha().setText("POUCO PAPEL");
                    tela.getTextoValorImpressoraCozinha().setForeground(amarelo);
                    break;
                case 9:
                    //A tampa da impressora está aberta
                    tela.getTextoValorImpressoraCozinha().setText("TAMPA ABERTA");
                    tela.getTextoValorImpressoraCozinha().setForeground(amarelo);
                    break;
                case 24:
                    //A impressora está OK, online
                    tela.getTextoValorImpressoraCozinha().setText("CONECTADA");
                    tela.getTextoValorImpressoraCozinha().setForeground(verde);
                    break;
                case 32:
                    //A impressora está sem papel
                    tela.getTextoValorImpressoraCozinha().setText("SEM PAPEL");
                    tela.getTextoValorImpressoraCozinha().setForeground(vermelho);
                    break;
            }
        }

        impressoraConectada = verificaImpressora(2);
        if (!impressoraConectada) {
            tela.getTextoValorImpressoraCaixa().setText("DESCONECTADA");
            tela.getTextoValorImpressoraCaixa().setForeground(cinza);
        } else {
            iRetorno = cupom.Le_Status();
            switch (iRetorno) {
                case 0:
                    //Impressora está com pouco papel
                    tela.getTextoValorImpressoraCaixa().setText("POUCO PAPEL");
                    tela.getTextoValorImpressoraCaixa().setForeground(amarelo);
                    break;
                case 24:
                    //Impressora está OK, online
                    tela.getTextoValorImpressoraCaixa().setText("CONECTADA");
                    tela.getTextoValorImpressoraCaixa().setForeground(verde);
                    break;
                case 40:
                    //Impressora está offline, pode estar desligada ou algum problema na conexão
                    tela.getTextoValorImpressoraCaixa().setText("DESCONECTADA");
                    tela.getTextoValorImpressoraCaixa().setForeground(cinza);
                    break;
            }
        }
    }

    public boolean verificaImpressora(int impressora) {
        int iRetorno;
        int modelo = 0;
        String endereco = "";
        BematechNFiscal cupom = BematechNFiscal.Instance;

        if (impressora == 1) {
            modelo = 5;
            endereco = "LPT1";
        } else if (impressora == 2) {
            modelo = 7;
            endereco = "192.168.0.183";
        }
        iRetorno = cupom.ConfiguraModeloImpressora(modelo);
        System.out.println("Setando Modelo da impressora " + impressora + ": " + iRetorno);
        iRetorno = cupom.IniciaPorta(endereco);
        System.out.println("Iniciando Porta da impressora " + impressora + ": " + iRetorno);
        iRetorno = cupom.BematechTX(BematechComandosDiretos.INICIALIZA);
        System.out.println("Mandando comandos diretos na impressora " + impressora + ": " + iRetorno);
        if (iRetorno == 0) {
            return false;
        }
        iRetorno = cupom.Le_Status();
        if (modelo == 5) {
            switch (iRetorno) {
                case 0:
                    //Impressora está com pouco papel
                    break;
                case 24:
                    //Impressora está OK, online
                    break;
                case 40:
                    //Impressora está offline, pode estar desligada ou algum problema na conexão
                    return false;
            }
        } else if (modelo == 7) {
            switch (iRetorno) {
                case 0:
                    //Erro de Comunicação
                    return false;
                case 5:
                    //Impressora com pouco papel
                    break;
                case 9:
                    //A tampa da impressora está aberta
                    break;
                case 24:
                    //A impressora está OK, online
                    break;
                case 32:
                    //A impressora está sem papel
                    break;
            }
        }
        iRetorno = cupom.FechaPorta();
        System.out.println("Fechar Porta Retornou " + iRetorno);
        return true;
    }
}

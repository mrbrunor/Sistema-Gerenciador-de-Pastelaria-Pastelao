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
public class MonitorImpressora {

    private int iRetorno;
    private final Color vermelho;
    private final Color amarelo;
    private final Color verde;
    private final Color cinza;
    private final TelaConfirmacaoPagamento tela;
    private static boolean impressoraInicializadaCaixa;
    private static boolean impressoraInicializadaCozinha;
    private static BematechNFiscal caixa; 
    private static BematechNFiscal cozinha;

    //static {
    //    System.loadLibrary("mp2032");
    //}
    public MonitorImpressora() {
        vermelho = new Color(255, 0, 0);
        amarelo = new Color(255, 201, 14);
        verde = new Color(0, 128, 0);
        cinza = new Color(128, 128, 128);
        tela=null;
    }
    
    public MonitorImpressora(TelaConfirmacaoPagamento frm) {
        try {
            caixa = BematechNFiscal.Instance;
            cozinha = BematechNFiscal.Instance;

        } catch (UnsatisfiedLinkError e) {
            System.out.println(e);
        }
        vermelho = new Color(255, 0, 0);
        amarelo = new Color(255, 201, 14);
        verde = new Color(0, 128, 0);
        cinza = new Color(128, 128, 128);
        tela = frm;
        impressoraInicializadaCaixa = false;
        impressoraInicializadaCozinha = false;
        inicializaImpressora(caixa, iRetorno);
        inicializaImpressora(cozinha, iRetorno);
    }

    public void verificar() {

        if (!impressoraInicializadaCozinha) {
            tela.getTextoValorImpressoraCozinha().setText("DESCONECTADA");
            tela.getTextoValorImpressoraCozinha().setForeground(cinza);
        } else {
            iRetorno = cozinha.Le_Status();
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

        if (!impressoraInicializadaCaixa) {
            tela.getTextoValorImpressoraCaixa().setText("DESCONECTADA");
            tela.getTextoValorImpressoraCaixa().setForeground(cinza);
        } else {
            iRetorno = caixa.Le_Status();
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

    public void inicializaImpressora(BematechNFiscal impressora, int tipoImpressora) {
        int modelo = 0;
        String endereco = "";
        
        if (tipoImpressora == 1) {
            modelo = 5;
            endereco = "LPT1";
        } else if (tipoImpressora == 2) {
            modelo = 7;
            endereco = "192.168.0.183";
        }
        iRetorno = impressora.ConfiguraModeloImpressora(modelo);
        System.out.println("Setando Modelo da impressora " + tipoImpressora + ": " + iRetorno);
        iRetorno = impressora.IniciaPorta(endereco);
        System.out.println("Iniciando Porta da impressora " + tipoImpressora + ": " + iRetorno);
        iRetorno = impressora.BematechTX(BematechComandosDiretos.INICIALIZA);
        System.out.println("Mandando comandos diretos na impressora " + tipoImpressora + ": " + iRetorno);
        if (iRetorno != 0 && tipoImpressora == 1) {
            impressoraInicializadaCaixa = true;
        } else if (iRetorno != 0 && tipoImpressora == 2)        {
            impressoraInicializadaCozinha = true;
        }
    }
    
    public void fechaImpressora (){
        iRetorno = caixa.FechaPorta();
        System.out.println("Fechar Porta Caixa Retornou " + iRetorno);
        iRetorno = cozinha.FechaPorta();
        System.out.println("Fechar Porta Cozinha Retornou " + iRetorno);
    }

    public static boolean getImpressoraInicializadaCaixa() {
        return impressoraInicializadaCaixa;
    }

    public static boolean getImpressoraInicializadaCozinha() {
        return impressoraInicializadaCozinha;
    }
    
    public static BematechNFiscal getCaixa() {
        return caixa;
    }

    public static BematechNFiscal getCozinha() {
        return cozinha;
    }    
}

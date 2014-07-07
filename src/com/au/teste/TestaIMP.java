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
package com.au.teste;

import com.au.util.BematechComandosDiretos;
import com.au.util.BematechNFiscal;

/**
 *
 * @author BrunoRicardo
 */
public class TestaIMP {

    private static final char ESC = 27; //escape   
    private static final char AT = 64; //@   
    private static final char LINE_FEED = 10; //line feed/new line   
    private static final char PARENTHESIS_LEFT = 40;
    private static final char BACKSLASH = 92;
    private static final char CR = 13; //carriage return   
    private static final char TAB = 9; //horizontal tab   
    private static final char FF = 12; //form feed   
    private static final char P = 80; //10cpi pitch   
    private static final char M = 77; //12cpi pitch   
    private static final char g = 103; //15cpi pitch   
    private static final char p = 112; //used for choosing proportional mode or fixed-pitch   
    private static final char t = 116; //used for character set assignment/selection   
    private static final char l = 108; //used for setting left margin   
    private static final char x = 120; //used for setting draft or letter quality (LQ) printing   
    private static final char E = 69; //bold font on   
    private static final char F = 70; //bold font off   
    private static final char J = 74; //used for advancing paper vertically   
    private static final char Q = 81; //used for setting right margin   
    private static final char $ = 36; //used for absolute horizontal positioning   
    public static final char ITALIC_ON = 52; //set font italic   
    public static final char ITALIC_OFF = 53; //unset font italic   
    public static final char CONDENSED_ON = 15;
    public static final char CONDENSED_OFF = 18;
    public static char test = 135;

    public static void main(String[] args) {
        /*  Bematech bema = new Bematech();
        
        
         bema.detectaImpressoras("MP-4000 TH");
         bema.imprime("" + ESC + ITALIC_ON);
         bema.imprime("Teste da Testa ç Ç Ã");
         bema.imprime("" + ESC + ITALIC_OFF);
         bema.imprime("\t\tOI");
         bema.imprime("OI");
         bema.imprime("");
         bema.imprime("");
         bema.imprime("");
         bema.imprime(String.valueOf(test));
         //bema.acionarGuilhotina(); */
        int iRetorno;
        String iComando;

        BematechNFiscal cupom = BematechNFiscal.Instance;

        iRetorno = cupom.ConfiguraModeloImpressora(5);
        iRetorno = cupom.IniciaPorta("LPT1");
        iRetorno = cupom.PrintNVBitmap(1, 0);
        iRetorno = cupom.BematechTX("Codigo   QT" + BematechComandosDiretos.TAB + "Unit" + BematechComandosDiretos.TAB + "Total\n");
        iRetorno = cupom.BematechTX(BematechComandosDiretos.SO + BematechComandosDiretos.NEGRITO_ON + 5 + " x " + 3 + BematechComandosDiretos.NEGRITO_OFF + BematechComandosDiretos.DC4 + BematechComandosDiretos.TAB
                    + 10 + BematechComandosDiretos.TAB
                    + 30 + "\r\n");
        iRetorno = cupom.FormataTX("Produto Tica Laca Tica", 3, 0, 0, 0, 1);
        iComando = "" + (char) 10;
        for (int i = 0;
                i < 8; i++) {
            iRetorno = cupom.ComandoTX(iComando, iComando.length());
        }
        iRetorno = cupom.FechaPorta();
    }
}

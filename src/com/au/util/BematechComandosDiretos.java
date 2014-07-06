/*
 * Copyright (C) 2014 Tiago
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

/**
 *
 * @author Tiago
 */
public class BematechComandosDiretos {
        //Códigos para Funções Diretas
    public static final char ESC = 27; //escape   
    public static final char AT = 64; //@   
    public static final char LINE_FEED = 10; //line feed/new line   
    public static final char PARENTHESIS_LEFT = 40;   
    public static final char BACKSLASH = 92;   
    public static final char CR = 13; //carriage return   
    public static final char TAB = 9; //horizontal tab   
    public static final char FF = 12; //form feed   
    public static final char P = 80; //10cpi pitch   
    public static final char M = 77; //12cpi pitch   
    public static final char g = 103; //15cpi pitch   
    public static final char p = 112; //used for choosing proportional mode or fixed-pitch   
    public static final char t = 116; //used for character set assignment/selection   
    public static final char l = 108; //used for setting left margin   
    public static final char x = 120; //used for setting draft or letter quality (LQ) printing   
    public static final char E = 69; //bold font on   
    public static final char F = 70; //bold font off   
    public static final char J = 74; //used for advancing paper vertically   
    public static final char Q = 81; //used for setting right margin   
    public static final char $ = 36; //used for absolute horizontal positioning
    public static final char d = 100; //
    public static final char SO = 14; //Ativa modo expandido na linha atual
    public static final char DC4 = 20; //Desativa a impressão expandida por linha setada pelos comandos ESC SO ou SO.
    public static final char a = 97; //Configura o alinhamento horizontal
    public static final char SUBLINHADO = 45;
    public static final char ITALIC_ON = 52; //set font italic   
    public static final char ITALIC_OFF = 53; //unset font italic   
    public static final char CONDENSED_ON = 15;   
    public static final char CONDENSED_OFF = 18;
    
    //Funções Diretas 
    public static final String NEGRITO_ON = "" + ESC + E;
    public static final String NEGRITO_OFF = "" + ESC + F;
    public static final String ITALICO_ON = "" + ESC + ITALIC_ON;
    public static final String ITALICO_OFF = "" + ESC + ITALIC_OFF;
    
    
    public static String alinhamento (int posicao) {
        return "" + ESC + a + (char)posicao;
    }
    
    public static String sublinhado (int estado) {
        return "" + ESC + SUBLINHADO + (char)estado;
    }
}

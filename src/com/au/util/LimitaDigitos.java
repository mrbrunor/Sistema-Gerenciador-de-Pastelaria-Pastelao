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

package com.au.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author BrunoRicardo
 */
public class LimitaDigitos extends PlainDocument{
    private int tamanhoMaximo;
    private String caracteres;
    
    public LimitaDigitos(int tamanhoMaximo, String caracteres){
        super();
        if (tamanhoMaximo <= 0){
            throw new IllegalArgumentException("Especifique a Quantidade");
        }
        this.tamanhoMaximo = tamanhoMaximo;
        this.caracteres = caracteres;
    }
    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException{
        if(str==null||getLength()==this.tamanhoMaximo)
            return;
        int totalquantidade=(getLength()+str.length());
        if(totalquantidade<=this.tamanhoMaximo){
            super.insertString(offset, str.replaceAll(this.caracteres,""), attr);
            return;
        }
        String nova = str.substring(0,getLength()-this.tamanhoMaximo);
        super.insertString(offset, nova, attr);
    }
}

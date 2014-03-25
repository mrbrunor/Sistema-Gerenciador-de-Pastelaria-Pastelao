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

package com.au.bean;

/**
 *
 * @author BrunoRicardo
 */
public class Fornecedor {
    private int idForn;
    private String nomeForn;
    private String cnpjForn;
    private String mailForn;
    private String foneForn;
    private String celForn;

    public int getIdForn() {
        return idForn;
    }

    public void setIdForn(int idForn) {
        this.idForn = idForn;
    }

    public String getNomeForn() {
        return nomeForn;
    }

    public void setNomeForn(String nomeForn) {
        this.nomeForn = nomeForn;
    }

    public String getCnpjForn() {
        return cnpjForn;
    }

    public void setCnpjForn(String cnpjForn) {
        this.cnpjForn = cnpjForn;
    }

    public String getMailForn() {
        return mailForn;
    }

    public void setMailForn(String mailForn) {
        this.mailForn = mailForn;
    }

    public String getFoneForn() {
        return foneForn;
    }

    public void setFoneForn(String foneForn) {
        this.foneForn = foneForn;
    }

    public String getCelForn() {
        return celForn;
    }

    public void setCelForn(String celForn) {
        this.celForn = celForn;
    }
    
    
}

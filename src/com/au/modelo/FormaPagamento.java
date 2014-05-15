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
package com.au.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author BrunoRicardo
 */
@Entity
@Table(name = "formapagamento")
@NamedQuery(name = "FormaPagamento.findAll", query = "SELECT fp FROM FormaPagamento fp")
public class FormaPagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int idFormaPgto;

    @Column(nullable = false, length = 50)
    private String nomeFormaPgto;

    @Column(nullable = false, length = 50)
    private String tipoFormaPgto;

    @Column(nullable = false)
    private byte estaAtivo;

    //bi-directional many-to-one association to Pedido
    @OneToMany(mappedBy = "formaPagamento", fetch=FetchType.EAGER)
    private List<Pedido> pedidos;

    public FormaPagamento() {

    }

    public int getIdFormaPgto() {
        return idFormaPgto;
    }

    public void setIdFormaPgto(int idFormaPgto) {
        this.idFormaPgto = idFormaPgto;
    }

    public String getNomeFormaPgto() {
        return nomeFormaPgto;
    }

    public void setNomeFormaPgto(String nomeFormaPgto) {
        this.nomeFormaPgto = nomeFormaPgto;
    }

    public String getTipoFormaPgto() {
        return tipoFormaPgto;
    }

    public void setTipoFormaPgto(String tipoFormaPgto) {
        this.tipoFormaPgto = tipoFormaPgto;
    }

    public byte getEstaAtivo() {
        return estaAtivo;
    }

    public void setEstaAtivo(byte estaAtivo) {
        this.estaAtivo = estaAtivo;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Pedido addPedido(Pedido pedido) {
        getPedidos().add(pedido);
        pedido.setFormaPagamento(this);

        return pedido;
    }

    public Pedido removePedido(Pedido pedido) {
        getPedidos().remove(pedido);
        pedido.setFormaPagamento(null);

        return pedido;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Embeddable
public class PedidoProductosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProducto")
    private int idProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPedido")
    private int idPedido;

    public PedidoProductosPK() {
    }

    public PedidoProductosPK(int idProducto, int idPedido) {
        this.idProducto = idProducto;
        this.idPedido = idPedido;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProducto;
        hash += (int) idPedido;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoProductosPK)) {
            return false;
        }
        PedidoProductosPK other = (PedidoProductosPK) object;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (this.idPedido != other.idPedido) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sysio.ecommerce.data.entity.PedidoProductosPK[ idProducto=" + idProducto + ", idPedido=" + idPedido + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Entity
@Table(name = "PedidoProductos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidoProductos.findAll", query = "SELECT p FROM PedidoProductos p"),
    @NamedQuery(name = "PedidoProductos.findByIdProducto", query = "SELECT p FROM PedidoProductos p WHERE p.pedidoProductosPK.idProducto = :idProducto"),
    @NamedQuery(name = "PedidoProductos.findByIdPedido", query = "SELECT p FROM PedidoProductos p WHERE p.pedidoProductosPK.idPedido = :idPedido"),
    @NamedQuery(name = "PedidoProductos.findByCantidad", query = "SELECT p FROM PedidoProductos p WHERE p.cantidad = :cantidad")})
public class PedidoProductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PedidoProductosPK pedidoProductosPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cantidad")
    private float cantidad;
    @Column(name = "CostoTotal")
    private float costoTotal;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;
    @JoinColumn(name = "idPedido", referencedColumnName = "idPedido", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pedidos pedidos;

    public PedidoProductos() {
    }

    public PedidoProductos(PedidoProductosPK pedidoProductosPK) {
        this.pedidoProductosPK = pedidoProductosPK;
    }

    public PedidoProductos(PedidoProductosPK pedidoProductosPK, float cantidad) {
        this.pedidoProductosPK = pedidoProductosPK;
        this.cantidad = cantidad;
    }

    public PedidoProductos(int idProducto, int idPedido) {
        this.pedidoProductosPK = new PedidoProductosPK(idProducto, idPedido);
    }

    public PedidoProductosPK getPedidoProductosPK() {
        return pedidoProductosPK;
    }

    public void setPedidoProductosPK(PedidoProductosPK pedidoProductosPK) {
        this.pedidoProductosPK = pedidoProductosPK;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    public float getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pedidoProductosPK != null ? pedidoProductosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoProductos)) {
            return false;
        }
        PedidoProductos other = (PedidoProductos) object;
        if ((this.pedidoProductosPK == null && other.pedidoProductosPK != null) || (this.pedidoProductosPK != null && !this.pedidoProductosPK.equals(other.pedidoProductosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sysio.ecommerce.data.entity.PedidoProductos[ pedidoProductosPK=" + pedidoProductosPK + " ]";
    }
    
}

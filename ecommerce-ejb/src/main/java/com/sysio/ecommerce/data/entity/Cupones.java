/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Entity
@Table(name = "Cupones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cupones.findAll", query = "SELECT c FROM Cupones c"),
    @NamedQuery(name = "Cupones.findByIdCupon", query = "SELECT c FROM Cupones c WHERE c.idCupon = :idCupon"),
    @NamedQuery(name = "Cupones.findByDescripcion", query = "SELECT c FROM Cupones c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Cupones.findByCantidad", query = "SELECT c FROM Cupones c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "Cupones.findByInicia", query = "SELECT c FROM Cupones c WHERE c.inicia = :inicia"),
    @NamedQuery(name = "Cupones.findByTermina", query = "SELECT c FROM Cupones c WHERE c.termina = :termina")})
public class Cupones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCupon")
    private Integer idCupon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "CantidadDescuento")
    private String cantidadDescuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Inicia")
    @Temporal(TemporalType.DATE)
    private Date inicia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Termina")
    @Temporal(TemporalType.DATE)
    private Date termina;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne
    private Productos idProducto;
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria")
    @ManyToOne
    private Categorias idCategoria;

    public Cupones() {
    }

    public Cupones(Integer idCupon) {
        this.idCupon = idCupon;
    }

    public Cupones(Integer idCupon, String descripcion, String cantidadDescuento, int cantidad, Date inicia, Date termina) {
        this.idCupon = idCupon;
        this.descripcion = descripcion;
        this.cantidadDescuento = cantidadDescuento;
        this.cantidad = cantidad;
        this.inicia = inicia;
        this.termina = termina;
    }

    public Integer getIdCupon() {
        return idCupon;
    }

    public void setIdCupon(Integer idCupon) {
        this.idCupon = idCupon;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidadDescuento() {
        return cantidadDescuento;
    }

    public void setCantidadDescuento(String cantidadDescuento) {
        this.cantidadDescuento = cantidadDescuento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getInicia() {
        return inicia;
    }

    public void setInicia(Date inicia) {
        this.inicia = inicia;
    }

    public Date getTermina() {
        return termina;
    }

    public void setTermina(Date termina) {
        this.termina = termina;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }

    public Categorias getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categorias idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCupon != null ? idCupon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cupones)) {
            return false;
        }
        Cupones other = (Cupones) object;
        if ((this.idCupon == null && other.idCupon != null) || (this.idCupon != null && !this.idCupon.equals(other.idCupon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sysio.ecommerce.data.entity.Cupones[ idCupon=" + idCupon + " ]";
    }
    
}

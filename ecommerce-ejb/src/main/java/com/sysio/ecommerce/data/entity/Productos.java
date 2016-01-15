/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Entity
@Table(name = "Productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p"),
    @NamedQuery(name = "Productos.findByIdProducto", query = "SELECT p FROM Productos p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Productos.findByDescripcion", query = "SELECT p FROM Productos p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Productos.findByCantidad", query = "SELECT p FROM Productos p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Productos.findByNombre", query = "SELECT p FROM Productos p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Productos.findByDetalle", query = "SELECT p FROM Productos p WHERE p.detalle = :detalle"),
    @NamedQuery(name = "Productos.findByMarca", query = "SELECT p FROM Productos p WHERE p.marca = :marca")})
public class Productos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProducto")
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "Descripcion")
    private String descripcion;
    @Lob
    @Size(max = 16777215)
    @Column(name = "Costo")
    private String costo;
    @Column(name = "Cantidad")
    private Integer cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Detalle")
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Marca")
    private String marca;
    @JoinTable(name = "Subproductos", joinColumns = {
        @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")}, inverseJoinColumns = {
        @JoinColumn(name = "idSubproducto", referencedColumnName = "idProducto")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Productos> productosList;
    @ManyToMany(mappedBy = "productosList", fetch = FetchType.EAGER)
    private List<Productos> productosList1;
    @ManyToMany(mappedBy = "productosList", fetch = FetchType.EAGER)
    private List<Categorias> categoriasList;
    @OneToMany(mappedBy = "idProducto", fetch = FetchType.EAGER)
    private List<Cupones> cuponesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto", fetch = FetchType.EAGER)
    private List<Imagenes> imagenesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto", fetch = FetchType.EAGER)
    private List<Pedidos> pedidosList;

    public Productos() {
    }

    public Productos(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Productos(Integer idProducto, String descripcion, String nombre, String detalle, String marca) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.detalle = detalle;
        this.marca = marca;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @XmlTransient
    public List<Productos> getProductosList() {
        return productosList;
    }

    public void setProductosList(List<Productos> productosList) {
        this.productosList = productosList;
    }

    @XmlTransient
    public List<Productos> getProductosList1() {
        return productosList1;
    }

    public void setProductosList1(List<Productos> productosList1) {
        this.productosList1 = productosList1;
    }

    @XmlTransient
    public List<Categorias> getCategoriasList() {
        return categoriasList;
    }

    public void setCategoriasList(List<Categorias> categoriasList) {
        this.categoriasList = categoriasList;
    }

    @XmlTransient
    public List<Cupones> getCuponesList() {
        return cuponesList;
    }

    public void setCuponesList(List<Cupones> cuponesList) {
        this.cuponesList = cuponesList;
    }

    @XmlTransient
    public List<Imagenes> getImagenesList() {
        return imagenesList;
    }

    public void setImagenesList(List<Imagenes> imagenesList) {
        this.imagenesList = imagenesList;
    }

    @XmlTransient
    public List<Pedidos> getPedidosList() {
        return pedidosList;
    }

    public void setPedidosList(List<Pedidos> pedidosList) {
        this.pedidosList = pedidosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sysio.ecommerce.data.entity.Productos[ idProducto=" + idProducto + " ]";
    }
    
}

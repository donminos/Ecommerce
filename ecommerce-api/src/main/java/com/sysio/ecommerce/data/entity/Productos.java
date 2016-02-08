/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Productos.findByCosto", query = "SELECT p FROM Productos p WHERE p.costo = :costo"),
    @NamedQuery(name = "Productos.findByCantidad", query = "SELECT p FROM Productos p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Productos.findByNombre", query = "SELECT p FROM Productos p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Productos.findByDetalle", query = "SELECT p FROM Productos p WHERE p.detalle = :detalle"),
    @NamedQuery(name = "Productos.findByVideoDemostrativo", query = "SELECT p FROM Productos p WHERE p.videoDemostrativo = :videoDemostrativo"),
    @NamedQuery(name = "Productos.findByActivo", query = "SELECT p FROM Productos p WHERE p.activo = :activo"),
    @NamedQuery(name = "Productos.findByVisible", query = "SELECT p FROM Productos p WHERE p.visible = :visible"),
    @NamedQuery(name = "Productos.findByFechaCaducidad", query = "SELECT p FROM Productos p WHERE p.fechaCaducidad = :fechaCaducidad")})
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Costo")
    private Float costo;
    @Column(name = "Cantidad")
    private Float cantidad;
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
    @Size(max = 60)
    @Column(name = "VideoDemostrativo")
    private String videoDemostrativo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Activo")
    private short activo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Visible")
    private short visible;
    @Column(name = "FechaCaducidad")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCaducidad;
    @JoinTable(name = "Subproductos", joinColumns = {
        @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")}, inverseJoinColumns = {
        @JoinColumn(name = "idSubproducto", referencedColumnName = "idProducto")})
    @ManyToMany
    private List<Productos> productosList;
    @ManyToMany(mappedBy = "productosList")
    private List<Productos> productosList1;
    @ManyToMany(mappedBy = "productosList")
    private List<Categorias> categoriasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<Imagenes> imagenesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<CuponesDescuentos> cuponesDescuentosList;
    @JoinColumn(name = "idMarca", referencedColumnName = "idMarca")
    @ManyToOne(optional = false)
    private Marca idMarca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productos")
    private List<PedidoProductos> pedidoProductosList;

    public Productos() {
    }

    public Productos(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Productos(Integer idProducto, String descripcion, String nombre, String detalle, short activo, short visible) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.detalle = detalle;
        this.activo = activo;
        this.visible = visible;
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

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
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

    public String getVideoDemostrativo() {
        return videoDemostrativo;
    }

    public void setVideoDemostrativo(String videoDemostrativo) {
        this.videoDemostrativo = videoDemostrativo;
    }

    public short getActivo() {
        return activo;
    }

    public void setActivo(short activo) {
        this.activo = activo;
    }

    public short getVisible() {
        return visible;
    }

    public void setVisible(short visible) {
        this.visible = visible;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
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
    public List<Imagenes> getImagenesList() {
        return imagenesList;
    }

    public void setImagenesList(List<Imagenes> imagenesList) {
        this.imagenesList = imagenesList;
    }

    @XmlTransient
    public List<CuponesDescuentos> getCuponesDescuentosList() {
        return cuponesDescuentosList;
    }

    public void setCuponesDescuentosList(List<CuponesDescuentos> cuponesDescuentosList) {
        this.cuponesDescuentosList = cuponesDescuentosList;
    }

    public Marca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marca idMarca) {
        this.idMarca = idMarca;
    }

    @XmlTransient
    public List<PedidoProductos> getPedidoProductosList() {
        return pedidoProductosList;
    }

    public void setPedidoProductosList(List<PedidoProductos> pedidoProductosList) {
        this.pedidoProductosList = pedidoProductosList;
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

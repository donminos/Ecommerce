/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "Categorias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorias.findAll", query = "SELECT c FROM Categorias c"),
    @NamedQuery(name = "Categorias.findByIdCategoria", query = "SELECT c FROM Categorias c WHERE c.idCategoria = :idCategoria"),
    @NamedQuery(name = "Categorias.findByNombre", query = "SELECT c FROM Categorias c WHERE c.nombre = :nombre")})
public class Categorias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCategoria")
    private Integer idCategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Nombre")
    private String nombre;
    @JoinTable(name = "Subcategorias", joinColumns = {
        @JoinColumn(name = "idSubcategoria", referencedColumnName = "idCategoria")}, inverseJoinColumns = {
        @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria")})
    @ManyToMany
    private List<Categorias> categoriasList;
    @ManyToMany(mappedBy = "categoriasList")
    private List<Categorias> categoriasList1;
    @JoinTable(name = "CategoriaProductos", joinColumns = {
        @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria")}, inverseJoinColumns = {
        @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")})
    @ManyToMany
    private List<Productos> productosList;

    public Categorias() {
    }

    public Categorias(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Categorias(Integer idCategoria, String nombre) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Categorias> getCategoriasList() {
        return categoriasList;
    }

    public void setCategoriasList(List<Categorias> categoriasList) {
        this.categoriasList = categoriasList;
    }

    @XmlTransient
    public List<Categorias> getCategoriasList1() {
        return categoriasList1;
    }

    public void setCategoriasList1(List<Categorias> categoriasList1) {
        this.categoriasList1 = categoriasList1;
    }

    @XmlTransient
    public List<Productos> getProductosList() {
        return productosList;
    }

    public void setProductosList(List<Productos> productosList) {
        this.productosList = productosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorias)) {
            return false;
        }
        Categorias other = (Categorias) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sysio.ecommerce.data.entity.Categorias[ idCategoria=" + idCategoria + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Entity
@Table(name = "CodigoPostal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodigoPostal.findAll", query = "SELECT c FROM CodigoPostal c"),
    @NamedQuery(name = "CodigoPostal.findByIdCodigoPostal", query = "SELECT c FROM CodigoPostal c WHERE c.idCodigoPostal = :idCodigoPostal"),
    @NamedQuery(name = "CodigoPostal.findByAsentamiento", query = "SELECT c FROM CodigoPostal c WHERE c.asentamiento = :asentamiento"),
    @NamedQuery(name = "CodigoPostal.findByTipoAsenta", query = "SELECT c FROM CodigoPostal c WHERE c.tipoAsenta = :tipoAsenta"),
    @NamedQuery(name = "CodigoPostal.findByMunicipio", query = "SELECT c FROM CodigoPostal c WHERE c.municipio = :municipio"),
    @NamedQuery(name = "CodigoPostal.findByEstado", query = "SELECT c FROM CodigoPostal c WHERE c.estado = :estado"),
    @NamedQuery(name = "CodigoPostal.findByCiudad", query = "SELECT c FROM CodigoPostal c WHERE c.ciudad = :ciudad"),
    @NamedQuery(name = "CodigoPostal.findByIdEstado", query = "SELECT c FROM CodigoPostal c WHERE c.idEstado = :idEstado"),
    @NamedQuery(name = "CodigoPostal.findByIdAsentamiento", query = "SELECT c FROM CodigoPostal c WHERE c.idAsentamiento = :idAsentamiento"),
    @NamedQuery(name = "CodigoPostal.findByIdMunicipio", query = "SELECT c FROM CodigoPostal c WHERE c.idMunicipio = :idMunicipio"),
    @NamedQuery(name = "CodigoPostal.findByZona", query = "SELECT c FROM CodigoPostal c WHERE c.zona = :zona")})
public class CodigoPostal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCodigoPostal")
    private Integer idCodigoPostal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "Asentamiento")
    private String asentamiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TipoAsenta")
    private String tipoAsenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "Municipio")
    private String municipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "Estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "Ciudad")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEstado")
    private int idEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAsentamiento")
    private int idAsentamiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMunicipio")
    private int idMunicipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Zona")
    private String zona;

    public CodigoPostal() {
    }

    public CodigoPostal(Integer idCodigoPostal) {
        this.idCodigoPostal = idCodigoPostal;
    }

    public CodigoPostal(Integer idCodigoPostal, String asentamiento, String tipoAsenta, String municipio, String estado, String ciudad, int idEstado, int idAsentamiento, int idMunicipio, String zona) {
        this.idCodigoPostal = idCodigoPostal;
        this.asentamiento = asentamiento;
        this.tipoAsenta = tipoAsenta;
        this.municipio = municipio;
        this.estado = estado;
        this.ciudad = ciudad;
        this.idEstado = idEstado;
        this.idAsentamiento = idAsentamiento;
        this.idMunicipio = idMunicipio;
        this.zona = zona;
    }

    public Integer getIdCodigoPostal() {
        return idCodigoPostal;
    }

    public void setIdCodigoPostal(Integer idCodigoPostal) {
        this.idCodigoPostal = idCodigoPostal;
    }

    public String getAsentamiento() {
        return asentamiento;
    }

    public void setAsentamiento(String asentamiento) {
        this.asentamiento = asentamiento;
    }

    public String getTipoAsenta() {
        return tipoAsenta;
    }

    public void setTipoAsenta(String tipoAsenta) {
        this.tipoAsenta = tipoAsenta;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdAsentamiento() {
        return idAsentamiento;
    }

    public void setIdAsentamiento(int idAsentamiento) {
        this.idAsentamiento = idAsentamiento;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCodigoPostal != null ? idCodigoPostal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodigoPostal)) {
            return false;
        }
        CodigoPostal other = (CodigoPostal) object;
        if ((this.idCodigoPostal == null && other.idCodigoPostal != null) || (this.idCodigoPostal != null && !this.idCodigoPostal.equals(other.idCodigoPostal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sysio.ecommerce.data.entity.CodigoPostal[ idCodigoPostal=" + idCodigoPostal + " ]";
    }
    
}

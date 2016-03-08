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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Entity
@Table(name = "DatosUsuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatosUsuario.findAll", query = "SELECT d FROM DatosUsuario d"),
    @NamedQuery(name = "DatosUsuario.findByIdUsuario", query = "SELECT d FROM DatosUsuario d WHERE d.idUsuario = :idUsuario"),
    @NamedQuery(name = "DatosUsuario.findByNombre", query = "SELECT d FROM DatosUsuario d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "DatosUsuario.findByApellidoPaterno", query = "SELECT d FROM DatosUsuario d WHERE d.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "DatosUsuario.findByApellidoMaterno", query = "SELECT d FROM DatosUsuario d WHERE d.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "DatosUsuario.findByCp", query = "SELECT d FROM DatosUsuario d WHERE d.cp = :cp"),
    @NamedQuery(name = "DatosUsuario.findByEstado", query = "SELECT d FROM DatosUsuario d WHERE d.estado = :estado"),
    @NamedQuery(name = "DatosUsuario.findByCiudad", query = "SELECT d FROM DatosUsuario d WHERE d.ciudad = :ciudad"),
    @NamedQuery(name = "DatosUsuario.findByDelegacion", query = "SELECT d FROM DatosUsuario d WHERE d.delegacion = :delegacion"),
    @NamedQuery(name = "DatosUsuario.findByColonia", query = "SELECT d FROM DatosUsuario d WHERE d.colonia = :colonia"),
    @NamedQuery(name = "DatosUsuario.findByTelefonoCelular", query = "SELECT d FROM DatosUsuario d WHERE d.telefonoCelular = :telefonoCelular"),
    @NamedQuery(name = "DatosUsuario.findByTelefonoOtro", query = "SELECT d FROM DatosUsuario d WHERE d.telefonoOtro = :telefonoOtro"),
    @NamedQuery(name = "DatosUsuario.findByNumeroInt", query = "SELECT d FROM DatosUsuario d WHERE d.numeroInt = :numeroInt"),
    @NamedQuery(name = "DatosUsuario.findByNumeroExt", query = "SELECT d FROM DatosUsuario d WHERE d.numeroExt = :numeroExt"),
    @NamedQuery(name = "DatosUsuario.findByRfc", query = "SELECT d FROM DatosUsuario d WHERE d.rfc = :rfc"),
    @NamedQuery(name = "DatosUsuario.findByCalle", query = "SELECT d FROM DatosUsuario d WHERE d.calle = :calle")})
public class DatosUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ApellidoPaterno")
    private String apellidoPaterno;
    @Size(max = 45)
    @Column(name = "ApellidoMaterno")
    private String apellidoMaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CP")
    private String cp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Ciudad")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Delegacion")
    private String delegacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Colonia")
    private String colonia;
    @Size(max = 45)
    @Column(name = "TelefonoCelular")
    private String telefonoCelular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TelefonoOtro")
    private String telefonoOtro;
    @Size(max = 45)
    @Column(name = "NumeroInt")
    private String numeroInt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NumeroExt")
    private String numeroExt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "RFC")
    private String rfc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Calle")
    private String calle;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuarios usuarios;

    public DatosUsuario() {
    }

    public DatosUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public DatosUsuario(Integer idUsuario, String nombre, String apellidoPaterno, String cp, String estado, String ciudad, String delegacion, String colonia, String telefonoOtro, String numeroExt, String rfc, String calle) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.cp = cp;
        this.estado = estado;
        this.ciudad = ciudad;
        this.delegacion = delegacion;
        this.colonia = colonia;
        this.telefonoOtro = telefonoOtro;
        this.numeroExt = numeroExt;
        this.rfc = rfc;
        this.calle = calle;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
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

    public String getDelegacion() {
        return delegacion;
    }

    public void setDelegacion(String delegacion) {
        this.delegacion = delegacion;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getTelefonoOtro() {
        return telefonoOtro;
    }

    public void setTelefonoOtro(String telefonoOtro) {
        this.telefonoOtro = telefonoOtro;
    }

    public String getNumeroInt() {
        return numeroInt;
    }

    public void setNumeroInt(String numeroInt) {
        this.numeroInt = numeroInt;
    }

    public String getNumeroExt() {
        return numeroExt;
    }

    public void setNumeroExt(String numeroExt) {
        this.numeroExt = numeroExt;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatosUsuario)) {
            return false;
        }
        DatosUsuario other = (DatosUsuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sysio.ecommerce.data.entity.DatosUsuario[ idUsuario=" + idUsuario + " ]";
    }
    
}

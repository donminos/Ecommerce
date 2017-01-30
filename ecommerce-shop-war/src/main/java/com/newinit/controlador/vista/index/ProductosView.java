package com.newinit.controlador.vista.index;

import com.sysio.ecommerce.data.entity.Marca;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ceasar
 */
public class ProductosView implements Serializable {

    private Integer idProducto;
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Float costo;
    private Float cantidad;
    private String nombre;
    private String detalle;
    private short promocionar;
    private Date fechaCaducidad;
    private String imagenesPath;

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

    public short getPromocionar() {
        return promocionar;
    }

    public void setPromocionar(short promocionar) {
        this.promocionar = promocionar;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getImagenesPath() {
        return imagenesPath;
    }

    public void setImagenesPath(String imagenesPath) {
        this.imagenesPath = imagenesPath;
    }

}

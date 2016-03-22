
package com.sysio.ecommerce.data.entity.altern;

import java.io.Serializable;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
public class CarroCompra implements Serializable{
    
    private Integer idproducto;
    
    private Float cantidad;

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }
    
}

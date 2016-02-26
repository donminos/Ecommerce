
package com.sysio.ecommerce.data.entity.altern;

import com.sysio.ecommerce.data.entity.Productos;
import java.io.Serializable;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
public class ProductosCantidad implements Serializable{
    private Productos producto;
    private Float cantidad;

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }    
    
}

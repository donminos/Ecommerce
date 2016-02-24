
package com.sysio.ecommerce.data.entity.altern;

import java.io.Serializable;


/**
 *
 * @author Carlos Cesar Rosas
 */
public class Filtros implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer categoria;
    private String palabraClave;
    private Integer marca;

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public String getPalabraClave() {
        return palabraClave;
    }

    public void setPalabraClave(String palabraClave) {
        this.palabraClave = palabraClave;
    }

    public Integer getMarca() {
        return marca;
    }

    public void setMarca(Integer marca) {
        this.marca = marca;
    }
    
    
}

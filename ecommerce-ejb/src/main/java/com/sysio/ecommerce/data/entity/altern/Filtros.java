
package com.sysio.ecommerce.data.entity.altern;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Cesar Rosas
 */
@XmlRootElement
public class Filtros implements Serializable{
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

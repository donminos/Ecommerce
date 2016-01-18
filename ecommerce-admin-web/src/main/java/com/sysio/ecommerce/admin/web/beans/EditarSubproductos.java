
package com.sysio.ecommerce.admin.web.beans;

import com.sysio.ecommerce.data.entity.Productos;
import com.sysio.ecommerce.data.session.ProductosSessionRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Named(value = "editarSubproductos")
@RequestScoped
public class EditarSubproductos {
    @EJB
    private ProductosSessionRemote productosSession;

    @Getter @Setter private Integer idproducto;
    
    @Getter @Setter private Productos producto;
    
    @Getter @Setter private List<String> subproducto;
    
    public EditarSubproductos() {
    }
    
    public List<Productos> getLstSubProductos(){
        List<Productos> prod=productosSession.findAllSubFetch(new Productos(idproducto));
        return prod;
    }
    public List<Productos> getListProductos(){
        Productos p=productosSession.find(idproducto);
        List<Productos> prod=productosSession.findAllFetch();
        prod.remove(p);
        return prod;
    }
    public void addProducto(){
        
    }
    
}

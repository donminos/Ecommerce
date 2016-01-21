
package com.sysio.ecommerce.admin.web.beans;

import com.sysio.ecommerce.data.entity.Productos;
import com.sysio.ecommerce.data.session.ProductosSessionRemote;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Log
@Named(value = "editarSubproductos")
@ViewScoped
public class EditarSubproductos implements Serializable{
    @EJB
    private ProductosSessionRemote productosSession;

    @Getter @Setter private Integer idproducto;
    
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
        try{
        List<Productos> lstprodu=new ArrayList();
        for(String prod:subproducto){
            lstprodu.add(productosSession.find(Integer.parseInt(prod)));
        }
        productosSession.AgregarSubProducto(new Productos(idproducto), lstprodu);
        }catch(javax.ejb.EJBTransactionRolledbackException ex){
            log.log(Level.SEVERE, ex.getMessage());
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pueden repetir sub-productos");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    public void eliminarProducto(Productos prod){
        Productos producto=productosSession.find(idproducto);
        producto.setProductosList(productosSession.findAllSubFetch(new Productos(idproducto)));
        producto.getProductosList().remove(prod);
        productosSession.edit(producto);
    }
    
}

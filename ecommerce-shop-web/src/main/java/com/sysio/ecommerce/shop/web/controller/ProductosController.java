
package com.sysio.ecommerce.shop.web.controller;

import com.sysio.ecommerce.data.entity.Imagenes;
import com.sysio.ecommerce.data.entity.Productos;
import com.sysio.ecommerce.data.session.ImagenesSessionRemote;
import com.sysio.ecommerce.data.session.ProductosSessionRemote;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@RestController
@RequestMapping("/public/productos")
public class ProductosController {
    ImagenesSessionRemote imagenesSession = lookupImagenesSessionRemote();
    ProductosSessionRemote productosSession = lookupProductosSessionRemote();
    

    @RequestMapping(value = "/findAll.do", method = RequestMethod.GET, produces = "application/json")
    public List<Productos> findAll() {
        List<Productos> prods=new ArrayList();
        for(Productos prod:productosSession.findAllFetch()){
            /*prod.setCategoriasList(new ArrayList());
            prod.setProductosList(new ArrayList());
            prod.setProductosList1(new ArrayList());
            prod.setCategoriasList(new ArrayList());
            prod.setPedidoProductosList(new ArrayList());*/
            List<Imagenes> imgs=imagenesSession.findAllId(prod.getIdProducto());
            for(Imagenes img:imgs)
                img.setIdProducto(null);
            prod.setImagenesList(imgs.isEmpty()?new ArrayList():imgs);
            prods.add(prod);
        }
        return prods;
    }
    @RequestMapping(value = "/findId.do>{id}", method = RequestMethod.GET, produces = "application/json")
    public Productos findId(@PathVariable("id") Integer id) {
        return productosSession.find(id);
    }

    private ProductosSessionRemote lookupProductosSessionRemote() {
        try {
            Context c = new InitialContext();
            return (ProductosSessionRemote) c.lookup("java:global/ecommerce-ejb/ProductosSession!com.sysio.ecommerce.data.session.ProductosSessionRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private ImagenesSessionRemote lookupImagenesSessionRemote() {
        try {
            Context c = new InitialContext();
            return (ImagenesSessionRemote) c.lookup("java:global/ecommerce-ejb/ImagenesSession!com.sysio.ecommerce.data.session.ImagenesSessionRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}

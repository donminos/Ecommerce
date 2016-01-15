
package com.sysio.ecommerce.shop.web.controller;

import com.sysio.ecommerce.data.entity.Productos;
import com.sysio.ecommerce.data.session.ProductosSessionRemote;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@RestController
@RequestMapping("public/productos")
public class ProductosController {
    ProductosSessionRemote productosSession = lookupProductosSessionRemote();

    @RequestMapping(value = "/findAll.do", method = RequestMethod.GET, produces = "application/json")
    public List<Productos> findAll() {
        return productosSession.findAll();
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
    
}

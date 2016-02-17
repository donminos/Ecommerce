
package com.sysio.ecommerce.shop.web.controller;

import com.sysio.ecommerce.data.entity.Productos;
import com.sysio.ecommerce.data.session.CarroCompraSessionRemote;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Carlos Cesar Rosas
 */
@RestController
@RequestMapping("/usuario/compras")
public class CarroCompra {
    List<Productos> listprod;
    CarroCompra(){
        listprod=new ArrayList();
    }
    CarroCompraSessionRemote carroCompraSession = lookupCarroCompraSessionRemote();
        
    @RequestMapping(value = "/agregarCarro.do", method = RequestMethod.POST, produces = "application/json")
    public List<Productos> agregarCarro(HttpServletRequest request, @RequestParam(required = true) Integer idproducto){
        request.getUserPrincipal();
        Productos prod=new Productos();
        prod.setIdProducto(idproducto);
        listprod.add(prod);
        return listprod;
    }

    private CarroCompraSessionRemote lookupCarroCompraSessionRemote() {
        try {
            Context c = new InitialContext();
            return (CarroCompraSessionRemote) c.lookup("java:global/ecommerce-ejb/CarroCompraSession!com.sysio.ecommerce.data.session.CarroCompraSessionRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}

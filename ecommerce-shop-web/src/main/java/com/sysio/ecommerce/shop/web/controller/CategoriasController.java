
package com.sysio.ecommerce.shop.web.controller;

import com.sysio.ecommerce.data.entity.Categorias;
import com.sysio.ecommerce.data.session.CategoriasSessionRemote;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Log
@RestController
@RequestMapping("/public/categorias")
public class CategoriasController {
    CategoriasSessionRemote categoriasSession = lookupCategoriasSessionRemote();
    
    @RequestMapping(value = "/findAll.do", method = RequestMethod.GET, produces = "application/json")
    public List<Categorias> findAll() {
        List<Categorias> cats=categoriasSession.findAll();
        for(int i=0;i<cats.size();i++){
            cats.get(i).setProductosList(new ArrayList());
            cats.get(i).setCuponesList(new ArrayList());
        }
        return cats;
    }

    private CategoriasSessionRemote lookupCategoriasSessionRemote() {
        try {
            Context c = new InitialContext();
            return (CategoriasSessionRemote) c.lookup("java:global/ecommerce-ejb/CategoriasSession!com.sysio.ecommerce.data.session.CategoriasSessionRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}

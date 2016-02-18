
package com.sysio.ecommerce.shop.web.controller;

import com.sysio.ecommerce.data.entity.Productos;
import java.util.ArrayList;
import java.util.List;
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
@RequestMapping("/public/compras")
public class CarroCompra {
    List<Productos> listprod;
    CarroCompra(){
        listprod=new ArrayList();
    }
        
    @RequestMapping(value = "/agregarCarro.do", method = RequestMethod.POST, produces = "application/json")
    public List<Productos> agregarCarro(HttpServletRequest request, @RequestParam(required = true) Integer idproducto){
        request.getUserPrincipal();
        Productos prod=new Productos();
        prod.setIdProducto(idproducto);
        listprod.add(prod);
        return listprod;
    }
     @RequestMapping(value = "/realizarCompra.do", method = RequestMethod.POST, produces = "application/json")
    public void realizarCompra(HttpServletRequest request, @RequestParam(required = true) Integer idproducto){
    }
}

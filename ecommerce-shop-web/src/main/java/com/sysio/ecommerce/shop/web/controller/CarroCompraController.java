
package com.sysio.ecommerce.shop.web.controller;

import com.sysio.ecommerce.data.entity.Imagenes;
import com.sysio.ecommerce.data.entity.Productos;
import com.sysio.ecommerce.data.entity.altern.CarroCompra;
import com.sysio.ecommerce.data.entity.altern.JsonResponseView;
import com.sysio.ecommerce.data.entity.altern.ProductosCantidad;
import com.sysio.ecommerce.data.session.ImagenesSessionRemote;
import com.sysio.ecommerce.data.session.ProductosSessionRemote;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Carlos Cesar Rosas
 */
@RestController
@RequestMapping("/public/compras")
public class CarroCompraController {
    ImagenesSessionRemote imagenesSession = lookupImagenesSessionRemote();
    ProductosSessionRemote productosSession = lookupProductosSessionRemote();
    
    
    List<CarroCompra> car;
    CarroCompraController(){
        car=new ArrayList();
    }
        
    @RequestMapping(value = "/agregarCarro.do", method = RequestMethod.POST, produces = "application/json")
    public JsonResponseView agregarCarro(HttpServletRequest request, @RequestBody(required = true) CarroCompra carro){
        Principal user=request.getUserPrincipal();
        JsonResponseView json=new JsonResponseView();
        try{
        if(carro.getCantidad()!=null && carro.getIdproducto()!=null){
            car.add(carro);
        }else{
            json.getResponse().put("error", "Faltan cantidad");
            throw new Exception("Faltan cantidad");
        }
        }catch(Exception ex){
            return json;
        }
        return json;
    }
     @RequestMapping(value = "/verCarro.do", method = RequestMethod.POST, produces = "application/json")
    public List<ProductosCantidad> verCarro(){
        ProductosCantidad prod;
        List<ProductosCantidad> lst=new ArrayList();
        for(CarroCompra c:car){
            Productos p=productosSession.find(c.getIdproducto());
            p.setProductosList1(new ArrayList());
            p.setProductosList(new ArrayList());
            p.setCategoriasList(new ArrayList());
            p.setCuponesDescuentosList(new ArrayList());
            p.setPedidoProductosList(new ArrayList());
            p.getIdMarca().setProductosList(new ArrayList());
            List<Imagenes> imgs = imagenesSession.findAllId(p.getIdProducto());
            for (Imagenes img : imgs) {
                img.setIdProducto(null);
            }
            p.setImagenesList(imgs.isEmpty() ? new ArrayList() : imgs);
            
            prod=new ProductosCantidad();
            prod.setProducto(p);
            prod.setCantidad(c.getCantidad());
            lst.add(prod);
            
        }
        return lst;
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

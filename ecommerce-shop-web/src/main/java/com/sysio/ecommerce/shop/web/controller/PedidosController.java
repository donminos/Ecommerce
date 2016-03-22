package com.sysio.ecommerce.shop.web.controller;

import com.sysio.ecommerce.data.entity.Estatus;
import com.sysio.ecommerce.data.entity.PedidoProductos;
import com.sysio.ecommerce.data.entity.PedidoProductosPK;
import com.sysio.ecommerce.data.entity.Pedidos;
import com.sysio.ecommerce.data.entity.Productos;
import com.sysio.ecommerce.data.entity.altern.CarroCompra;
import com.sysio.ecommerce.data.session.PedidosProductisSessionRemote;
import com.sysio.ecommerce.data.session.PedidosSessionRemote;
import com.sysio.ecommerce.data.session.ProductosSessionRemote;
import com.sysio.ecommerce.data.session.UsuariosSessionRemote;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Log
@RestController
@RequestMapping("/private/pedidos")
public class PedidosController {

    PedidosProductisSessionRemote pedidosProductosSession = lookupPedidosProductosSessionRemote();

    ProductosSessionRemote productosSession = lookupProductosSessionRemote();

    UsuariosSessionRemote usuariosSession = lookupUsuariosSessionRemote();

    PedidosSessionRemote pedidosSession = lookupPedidosSessionRemote();
    
    

    @RequestMapping(value = "/create.do", method = RequestMethod.POST, produces = "application/json")
    public Integer crearPedido(Principal principal,@RequestBody(required = true) List<CarroCompra> carro) {
        Pedidos pedido = new Pedidos();
        pedido.setFechaPedido(new Date());
        pedido.setIdStatus(new Estatus(1));
        pedido.setIdUsuario(usuariosSession.findUserForEmail(principal.getName()));
        Integer id=pedidosSession.crear(pedido);
        pedido.setIdPedido(id);
        
        for (CarroCompra unidad : carro) {
            Productos articulo=productosSession.find(unidad.getIdproducto());
            PedidoProductosPK pk=new PedidoProductosPK();
            pk.setIdProducto(unidad.getIdproducto());
            pk.setIdPedido(id);
            PedidoProductos producto = new PedidoProductos();
            producto.setProductos(articulo);
            producto.setPedidos(pedido);
            producto.setCantidad(unidad.getCantidad());
            producto.setCostoTotal(articulo.getCosto()*unidad.getCantidad());
            producto.setPedidoProductosPK(pk);
            pedidosProductosSession.create(producto);
        }
        return 1;
    }

    private PedidosSessionRemote lookupPedidosSessionRemote() {
        try {
            Context c = new InitialContext();
            return (PedidosSessionRemote) c.lookup("java:global/ecommerce-ejb/PedidosSession!com.sysio.ecommerce.data.session.PedidosSessionRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private UsuariosSessionRemote lookupUsuariosSessionRemote() {
        try {
            Context c = new InitialContext();
            return (UsuariosSessionRemote) c.lookup("java:global/ecommerce-ejb/UsuariosSession!com.sysio.ecommerce.data.session.UsuariosSessionRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
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

    private PedidosProductisSessionRemote lookupPedidosProductosSessionRemote() {
        try {
            Context c = new InitialContext();
            return (PedidosProductisSessionRemote) c.lookup("java:global/ecommerce-ejb/PedidosProductosSession!com.sysio.ecommerce.data.session.PedidosProductisSessionRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}

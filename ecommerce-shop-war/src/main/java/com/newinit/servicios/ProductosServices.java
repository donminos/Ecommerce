package com.newinit.servicios;

import com.newinit.controlador.vista.index.ProductosView;
import com.sysio.ecommerce.data.entity.Imagenes;
import com.sysio.ecommerce.data.entity.Productos;
import com.sysio.ecommerce.data.entity.altern.Filtros;
import com.sysio.ecommerce.data.session.ImagenesSessionRemote;
import com.sysio.ecommerce.data.session.ProductosSessionRemote;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author ceasar
 */
@Service("ProductosServices")
public class ProductosServices {

    ImagenesSessionRemote imagenesSession = lookupImagenesSessionRemote();
    ProductosSessionRemote productosSession = lookupProductosSessionRemote();

    public List<ProductosView> findAll(Filtros filtro) {
        List<Productos> prods = new ArrayList();
        List<ProductosView> findprods = new ArrayList();
        if (filtro != null) {
            prods = productosSession.findAllFetch(filtro);
        }
        for (Productos prod : prods) {
            List<Imagenes> imgs = imagenesSession.findAllId(prod.getIdProducto());
            for (Imagenes img : imgs) {
                img.setIdProducto(null);
            }
            prod.setImagenesList(imgs.isEmpty() ? new ArrayList() : imgs);
            
            ModelMapper modelMapper = new ModelMapper();
            ProductosView producto = modelMapper.map(prod, ProductosView.class);
            producto.setImagenesPath(prod.getImagenesList().get(0).getPath());
            findprods.add(producto);
        }
        return findprods;
    }

    public ProductosView findId(Integer id) {
        Productos prod = productosSession.find(id);
        List<Imagenes> imgs = imagenesSession.findAllId(prod.getIdProducto());
        for (Imagenes img : imgs) {
            img.setIdProducto(null);
        }
        prod.setImagenesList(imgs.isEmpty() ? new ArrayList() : imgs);
        ModelMapper modelMapper = new ModelMapper();
        ProductosView producto = modelMapper.map(prod, ProductosView.class);
        producto.setImagenesPath(prod.getImagenesList().get(0).getPath());
        return producto;
    }

    private ProductosSessionRemote lookupProductosSessionRemote() {
        try {
            Context c = new InitialContext();
            return (ProductosSessionRemote) c.lookup("java:global/ecommerce-ejb-1.0/ProductosSession!com.sysio.ecommerce.data.session.ProductosSessionRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private ImagenesSessionRemote lookupImagenesSessionRemote() {
        try {
            Context c = new InitialContext();
            return (ImagenesSessionRemote) c.lookup("java:global/ecommerce-ejb-1.0/ImagenesSession!com.sysio.ecommerce.data.session.ImagenesSessionRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}

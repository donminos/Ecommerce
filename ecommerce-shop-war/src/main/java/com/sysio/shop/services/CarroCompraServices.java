/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.shop.services;

import com.sysio.ecommerce.data.entity.altern.CarroCompra;
import com.sysio.ecommerce.data.entity.altern.ProductosCantidad;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ceasar
 */
@Service("CarroCompraServices")
public class CarroCompraServices {
    
    public List<ProductosCantidad> verCarro(List<CarroCompra> car) {
        ProductosCantidad prod;
        List<ProductosCantidad> lst = new ArrayList();
        for (CarroCompra c : car) {
            /*Productos p = productosSession.find(c.getIdproducto());
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

            prod = new ProductosCantidad();
            prod.setProducto(p);
            prod.setCantidad(c.getCantidad());
            lst.add(prod);
*/
        }
        return lst;
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.facade;

import com.sysio.ecommerce.data.entity.PedidoProductos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Local
public interface PedidoProductosFacadeLocal {

    void create(PedidoProductos pedidoProductos);

    void edit(PedidoProductos pedidoProductos);

    void remove(PedidoProductos pedidoProductos);

    PedidoProductos find(Object id);

    List<PedidoProductos> findAll();

    List<PedidoProductos> findRange(int[] range);

    int count();
    
}

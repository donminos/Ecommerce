/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.session;

import com.sysio.ecommerce.data.entity.PedidoProductos;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Remote
public interface PedidosProductisSessionRemote {

    public void create(PedidoProductos pedidoProductos);

    public void edit(PedidoProductos pedidoProductos);

    public void remove(PedidoProductos pedidoProductos);

    public PedidoProductos find(Object id);

    public List<PedidoProductos> findAll();

    public List<PedidoProductos> findRange(int[] range);

    public int count();
}

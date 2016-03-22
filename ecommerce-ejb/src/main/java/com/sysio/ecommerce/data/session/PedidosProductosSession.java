
package com.sysio.ecommerce.data.session;

import com.sysio.ecommerce.data.entity.PedidoProductos;
import com.sysio.ecommerce.data.facade.PedidoProductosFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Stateless
public class PedidosProductosSession implements PedidosProductisSessionRemote {

    @EJB
    private PedidoProductosFacadeLocal pedidoProductosFacade;

    @Override
    public void create(PedidoProductos pedidoProductos) {
        pedidoProductosFacade.create(pedidoProductos);
    }

    @Override
    public void edit(PedidoProductos pedidoProductos) {
        pedidoProductosFacade.edit(pedidoProductos);
    }

    @Override
    public void remove(PedidoProductos pedidoProductos) {
        pedidoProductosFacade.remove(pedidoProductos);
    }

    @Override
    public PedidoProductos find(Object id) {
        return pedidoProductosFacade.find(id);
    }

    @Override
    public List<PedidoProductos> findAll() {
        return pedidoProductosFacade.findAll();
    }

    @Override
    public List<PedidoProductos> findRange(int[] range) {
        return pedidoProductosFacade.findRange(range);
    }

    @Override
    public int count() {
        return pedidoProductosFacade.count();
    }

}

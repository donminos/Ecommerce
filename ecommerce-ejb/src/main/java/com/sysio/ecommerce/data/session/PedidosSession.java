package com.sysio.ecommerce.data.session;

import com.sysio.ecommerce.data.entity.Pedidos;
import com.sysio.ecommerce.data.facade.PedidosFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Stateless
public class PedidosSession implements PedidosSessionRemote {

    @EJB
    private PedidosFacadeLocal pedidosFacade;

    @Override
    public void create(Pedidos pedidos) {
        pedidosFacade.create(pedidos);
    }

    @Override
    public void edit(Pedidos pedidos) {
        pedidosFacade.edit(pedidos);
    }

    @Override
    public void remove(Pedidos pedidos) {
        pedidosFacade.remove(pedidos);
    }

    @Override
    public Pedidos find(Object id) {
        return pedidosFacade.find(id);
    }

    @Override
    public List<Pedidos> findAll() {
        return pedidosFacade.findAll();
    }

    @Override
    public List<Pedidos> findRange(int[] range) {
        return pedidosFacade.findRange(range);
    }

    @Override
    public int count() {
        return pedidosFacade.count();
    }

    @Override
    public List<Pedidos> findAllStatus(Integer status) {
        return pedidosFacade.findAllStatus(status);
    }

    @Override
    public List<Pedidos> findAllFetch() {
        return pedidosFacade.findAllFetch();
    }

    @Override
    public Integer crear(Pedidos pedido) {
        return pedidosFacade.crear(pedido);
    }

}

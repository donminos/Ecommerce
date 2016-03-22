/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.facade;

import com.sysio.ecommerce.data.entity.Pedidos;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lombok.extern.java.Log;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Log
@Stateless
public class PedidosFacade extends AbstractFacade<Pedidos> implements PedidosFacadeLocal {

    @PersistenceContext(unitName = "ecommerce-ejb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidosFacade() {
        super(Pedidos.class);
    }
    
    @Override
    public Integer crear(Pedidos pedido){
        em.persist(pedido);
        em.flush();
        return pedido.getIdPedido();
    }

    @Override
    public List<Pedidos> findAllStatus(Integer status) {
        List<Pedidos> pedidos=new ArrayList();
        try {
            Query query=em.createQuery("SELECT p FROM Pedidos p where p.idStatus=:status");
            query.setParameter("status", status);
            pedidos=query.getResultList();
        } catch (Exception ex) {
            log.log(Level.SEVERE,ex.getMessage());
        }
        return pedidos;
    }
    @Override
    public List<Pedidos> findAllFetch() {
        Query query = em.createQuery("SELECT distinct p FROM Pedidos p JOIN FETCH p.pedidoProductosList", Pedidos.class);
        List<Pedidos> pedidos = query.getResultList();
        return pedidos;
    }
}

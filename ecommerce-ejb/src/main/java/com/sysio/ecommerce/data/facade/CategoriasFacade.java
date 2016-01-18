/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.facade;

import com.sysio.ecommerce.data.entity.Categorias;
import com.sysio.ecommerce.data.entity.Productos;
import java.util.ArrayList;
import java.util.List;
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
public class CategoriasFacade extends AbstractFacade<Categorias> implements CategoriasFacadeLocal {
    @PersistenceContext(unitName = "ecommerce-ejb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriasFacade() {
        super(Categorias.class);
    }
    @Override
    public List<Categorias> categoriasForProducto(Productos producto) {
        List<Categorias> cats=new ArrayList();
        try {
            Query query = em.createQuery("SELECT c FROM Categorias c WHERE c.productosList.idProducto = :idproducto ", Categorias.class);
            query.setParameter("idproducto", producto.getIdProducto());
            cats=(List<Categorias>)query.getResultList();
        }catch (Exception ex) {
            log.severe(ex.getMessage());
        }
        return cats;
    }
    
}

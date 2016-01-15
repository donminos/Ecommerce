/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.facade;

import com.sysio.ecommerce.data.entity.Imagenes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Stateless
public class ImagenesFacade extends AbstractFacade<Imagenes> implements ImagenesFacadeLocal {
    @PersistenceContext(unitName = "ecommerce-ejb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ImagenesFacade() {
        super(Imagenes.class);
    }
    
    @Override
    public List<Imagenes> findAllId(Integer idProducto){
        Query query = em.createQuery("SELECT i FROM Imagenes i WHERE i.idProducto.idProducto = :prod", Imagenes.class);
        query.setParameter("prod", idProducto);
        return (List<Imagenes>) query.getResultList();
    }
    
}

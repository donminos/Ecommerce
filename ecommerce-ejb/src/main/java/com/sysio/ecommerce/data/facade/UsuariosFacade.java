/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.facade;

import com.sysio.ecommerce.data.entity.Usuarios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "ecommerce-ejb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }

    @Override
    public Usuarios findUserForEmail(String email) {
        Query query = em.createQuery("SELECT us FROM Usuarios us WHERE us.usuario=:email", Usuarios.class);
        query.setParameter("email", email);
        Usuarios user = (Usuarios) query.getSingleResult();
        return user;
    }

}

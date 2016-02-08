/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.facade;

import com.sysio.ecommerce.data.entity.Categorias;
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
    public void createSubCategoria(Categorias categoria) {
        em.persist(categoria);
        em.flush();
        for (Categorias subcat : categoria.getCategoriasList1()) {
            Query query = em.createNativeQuery("INSERT INTO Subcategorias (idCategoria,idSubcategoria) values(?,?)");
            query.setParameter(1, categoria.getIdCategoria());
            query.setParameter(2, subcat.getIdCategoria());
            query.executeUpdate();
        }
    }

    @Override
    public void editSubCategoria(Categorias categoria) {
        em.merge(categoria);
        for (Categorias subcat : categoria.getCategoriasList1()) {
            Query query = em.createNativeQuery("INSERT INTO Subcategorias (idCategoria,idSubcategoria) values(?,?)");
            query.setParameter(1, categoria.getIdCategoria());
            query.setParameter(2, subcat.getIdCategoria());
            query.executeUpdate();
        }
    }

    @Override
    public void removeSubCategoria(Categorias categoria) {
        for (Categorias subcat : categoria.getCategoriasList1()) {
            Query query = em.createNativeQuery("DELETE FROM Subcategorias WHERE idCategoria=? AND idSubcategoria=?");
            query.setParameter(1, categoria.getIdCategoria());
            query.setParameter(2, subcat.getIdCategoria());
            query.executeUpdate();
        }
    }

    @Override
    public void removeCategoria(Categorias categoria) {
        Query query = em.createNativeQuery("DELETE FROM Categorias WHERE idCategoria=?");
        query.setParameter(1, categoria.getIdCategoria());
        query.executeUpdate();
    }

    @Override
    public List<Categorias> findAllFetch() {
        Query query = em.createQuery("SELECT distinct c FROM Categorias c LEFT JOIN FETCH c.categoriasList1", Categorias.class);
        List<Categorias> categorias = query.getResultList();
        return categorias;
    }

    @Override
    public List<Categorias> findForIdAllFetch(Integer idCategoria) {
        Categorias categorias = new Categorias();
        try {
            Query query = em.createQuery("SELECT distinct c FROM Categorias c JOIN FETCH c.categoriasList1 WHERE c.idCategoria = :cat", Categorias.class);
            query.setParameter("cat", idCategoria);
            categorias = (Categorias) query.getSingleResult();
        } catch (javax.persistence.NoResultException ex) {

        }
        return categorias.getCategoriasList1() == null ? new ArrayList() : categorias.getCategoriasList1();
    }

}

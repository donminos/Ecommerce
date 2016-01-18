/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.session;

import com.sysio.ecommerce.data.entity.Categorias;
import com.sysio.ecommerce.data.facade.CategoriasFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Stateless
public class CategoriasSession implements CategoriasSessionRemote {
    @EJB
    private CategoriasFacadeLocal categoriasFacade;

    @Override
    public void create(Categorias categorias) {
        categoriasFacade.create(categorias);
    }

    @Override
    public void edit(Categorias categorias) {
        categoriasFacade.edit(categorias);
    }

    @Override
    public void remove(Categorias categorias) {
        categoriasFacade.remove(categorias);
    }

    @Override
    public Categorias find(Object id) {
        return categoriasFacade.find(id);
    }

    @Override
    public List<Categorias> findAll() {
        return categoriasFacade.findAll();
    }

    @Override
    public List<Categorias> findRange(int[] range) {
        return categoriasFacade.findRange(range);
    }

    @Override
    public int count() {
        return categoriasFacade.count();
    }

}

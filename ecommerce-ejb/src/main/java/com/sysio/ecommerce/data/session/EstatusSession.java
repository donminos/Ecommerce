/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.session;

import com.sysio.ecommerce.data.entity.Estatus;
import com.sysio.ecommerce.data.facade.EstatusFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Stateless
public class EstatusSession implements EstatusSessionRemote {

    @EJB
    private EstatusFacadeLocal estatusFacade;

    @Override
    public void create(Estatus estatus) {
        estatusFacade.create(estatus);
    }

    @Override
    public void edit(Estatus estatus) {
        estatusFacade.edit(estatus);
    }

    @Override
    public void remove(Estatus estatus) {
        estatusFacade.remove(estatus);
    }

    @Override
    public Estatus find(Object id) {
        return estatusFacade.find(id);
    }

    @Override
    public List<Estatus> findAll() {
        return estatusFacade.findAll();
    }

    @Override
    public List<Estatus> findRange(int[] range) {
        return estatusFacade.findRange(range);
    }

    @Override
    public int count() {
        return estatusFacade.count();
    }

}

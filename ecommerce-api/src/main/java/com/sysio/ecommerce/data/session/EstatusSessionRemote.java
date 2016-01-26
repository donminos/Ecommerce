/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.session;

import com.sysio.ecommerce.data.entity.Estatus;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Remote
public interface EstatusSessionRemote {

    public void create(Estatus estatus);

    public void edit(Estatus estatus);

    public void remove(Estatus estatus);

    public Estatus find(Object id);

    public List<Estatus> findAll();

    public List<Estatus> findRange(int[] range);

    public int count();
}

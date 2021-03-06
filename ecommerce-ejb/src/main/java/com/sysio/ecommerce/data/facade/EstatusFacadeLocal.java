/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.facade;

import com.sysio.ecommerce.data.entity.Estatus;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Local
public interface EstatusFacadeLocal {

    void create(Estatus estatus);

    void edit(Estatus estatus);

    void remove(Estatus estatus);

    Estatus find(Object id);

    List<Estatus> findAll();

    List<Estatus> findRange(int[] range);

    int count();
    
}

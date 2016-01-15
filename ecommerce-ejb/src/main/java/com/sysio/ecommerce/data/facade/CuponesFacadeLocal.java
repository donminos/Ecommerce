/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.facade;

import com.sysio.ecommerce.data.entity.Cupones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Local
public interface CuponesFacadeLocal {

    void create(Cupones cupones);

    void edit(Cupones cupones);

    void remove(Cupones cupones);

    Cupones find(Object id);

    List<Cupones> findAll();

    List<Cupones> findRange(int[] range);

    int count();
    
}

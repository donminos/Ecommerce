/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.facade;

import com.sysio.ecommerce.data.entity.CuponesDescuentos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Local
public interface CuponesDescuentosFacadeLocal {

    void create(CuponesDescuentos cuponesDescuentos);

    void edit(CuponesDescuentos cuponesDescuentos);

    void remove(CuponesDescuentos cuponesDescuentos);

    CuponesDescuentos find(Object id);

    List<CuponesDescuentos> findAll();

    List<CuponesDescuentos> findRange(int[] range);

    int count();
    
}

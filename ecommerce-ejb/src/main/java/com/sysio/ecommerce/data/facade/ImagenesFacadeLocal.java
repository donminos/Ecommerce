/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.facade;

import com.sysio.ecommerce.data.entity.Imagenes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Local
public interface ImagenesFacadeLocal {

    void create(Imagenes imagenes);

    void edit(Imagenes imagenes);

    void remove(Imagenes imagenes);

    Imagenes find(Object id);

    List<Imagenes> findAll();

    List<Imagenes> findRange(int[] range);

    int count();
    
    List<Imagenes> findAllId(Integer idProducto);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.session;

import com.sysio.ecommerce.data.entity.Imagenes;
import com.sysio.ecommerce.data.facade.ImagenesFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Stateless
public class ImagenesSession implements ImagenesSessionRemote {
    @EJB
    private ImagenesFacadeLocal imagenesFacade;

    @Override
    public void create(Imagenes imagenes) {
        imagenesFacade.create(imagenes);
    }

    @Override
    public void edit(Imagenes imagenes) {
        imagenesFacade.edit(imagenes);
    }

    @Override
    public void remove(Imagenes imagenes) {
        imagenesFacade.remove(imagenes);
    }

    @Override
    public Imagenes find(Object id) {
        return imagenesFacade.find(id);
    }

    @Override
    public List<Imagenes> findAll() {
        return imagenesFacade.findAll();
    }

    @Override
    public List<Imagenes> findRange(int[] range) {
        return imagenesFacade.findRange(range);
    }

    @Override
    public int count() {
        return imagenesFacade.count();
    }

    @Override
    public List<Imagenes> findAllId(Integer idProducto) {
        return imagenesFacade.findAllId(idProducto);
    }
    
}

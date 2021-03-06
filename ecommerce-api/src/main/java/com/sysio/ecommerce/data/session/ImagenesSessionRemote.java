/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.session;

import com.sysio.ecommerce.data.entity.Imagenes;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Remote
public interface ImagenesSessionRemote {

    public void create(Imagenes imagenes);

    public void edit(Imagenes imagenes);

    public void remove(Imagenes imagenes);

    public Imagenes find(Object id);

    public List<Imagenes> findAll();

    public List<Imagenes> findRange(int[] range);

    public int count();
    
    public List<Imagenes> findAllId(Integer idProducto);
}
